package com.rapid.common.base.mybatis.autobuilder;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * 根据数据库表字段自动生成 实体+ibatis xml xwl
 */
public class Entity {

	// 主键属性
	Field primaryKeyField;

	// 其他属性
	ArrayList<Field> fields = new ArrayList<Field>();

	private String srcProjectPath;

	// 代码文件生成路径
	private String srcPakagePath;

	// 代码内部导入包路径
	private String pakagePath;

	private Connection conn;

	private String entityName = null;

	private String ENTITY = File.separatorChar + "";

	private String PAKAGE_ENTITY = "";

	private String SRC = File.separatorChar + "src" + File.separatorChar;

	private String tableName;
	
	private final String PATH_DAO = ".dao.";
	
	private final String PATH_MODEL = ".model.";

	public Entity(String pakagePath, String srcProjectPath) {
		this.srcProjectPath = srcProjectPath;
		this.srcPakagePath = SRC + pakagePath + ENTITY;
		this.pakagePath = pakagePath + PAKAGE_ENTITY;
	}

	// 读取数据库配置文件 & 加载数据库连接
	private void connectDB(String db_properties) throws IOException, ClassNotFoundException, SQLException {
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
		Resource resource = resourceLoader.getResource(getClass().getResource("/conf/").toString() + db_properties);
		Properties properties = PropertiesLoaderUtils.loadProperties(resource);

		String jdbcDriver = properties.getProperty("jdbc_driverClassName");
		String jdbcUrl = properties.getProperty("jdbc_url");
		String userName = properties.getProperty("jdbc_username");
		String password = properties.getProperty("jdbc_password");

		Class.forName(jdbcDriver);
		conn = DriverManager.getConnection(jdbcUrl, userName, password);
	}

	void builderEntity(String db_properties, String tableName) throws Exception {
		this.tableName = tableName;
		// 开始生成
		connectDB(db_properties);
		this.entityName = ColumnConvert.getJavaBeanNameBy(tableName);
		Statement stmt = conn.createStatement();
		ResultSet result = stmt.executeQuery("select * from " + tableName + " where 1 = 2 ");

		ResultSetMetaData metData = result.getMetaData();

		int ColumnCount = metData.getColumnCount();
		DatabaseMetaData databaseMetaData = conn.getMetaData();

		ResultSet priKeySet = databaseMetaData.getPrimaryKeys(null, null, tableName);

		String primaryKeyFieldName = null;
		String primaryKeyPropertyName = null;

		if (priKeySet.next()) {
			primaryKeyFieldName = priKeySet.getString(4);
			primaryKeyPropertyName = ColumnConvert.getJavaBeanPropsNameBy(primaryKeyFieldName);
			primaryKeyField = new Field(primaryKeyFieldName, primaryKeyPropertyName, true);
			ResultSet remarkSet = databaseMetaData.getColumns(null, null, tableName, primaryKeyFieldName);
			if (remarkSet.next()) {
				primaryKeyField.setRemark(remarkSet.getString("REMARKS"));
			}
		}
		priKeySet.close();

		for (int i = 1; i <= ColumnCount; i++) {
			String fieldName = metData.getColumnName(i);
			int iColumnType = metData.getColumnType(i);

			if (!fieldName.equalsIgnoreCase(primaryKeyFieldName)) {
				String propertyName = ColumnConvert.getJavaBeanPropsNameBy(fieldName);
				Field field = new Field(fieldName, propertyName, false);
				field.setDataType(iColumnType);
				ResultSet remarkSet = databaseMetaData.getColumns(null, null, tableName, fieldName);
				if (remarkSet.next()) {
					field.setRemark(remarkSet.getString("REMARKS"));
				}
				fields.add(field);
			} else {
				if (null != primaryKeyField) {
					primaryKeyField.setDataType(iColumnType);
				}
			}
		}

		saveToFile();

		result.close();
		stmt.close();
		conn.close();

	}

	private String getDataType(int iDataType) {
		String dataType = "";

		if (iDataType == Types.VARCHAR || iDataType == Types.CHAR || iDataType == Types.LONGVARCHAR
				|| iDataType == Types.CLOB) {
			dataType = "String";
		} else if (iDataType == Types.INTEGER || iDataType == Types.BIGINT || iDataType == Types.BIT
				|| iDataType == Types.TINYINT || iDataType == Types.NUMERIC) {
			dataType = "Integer";
		} else if (iDataType == Types.DOUBLE || iDataType == Types.FLOAT || iDataType == Types.REAL) {
			dataType = "Double";
		} else if (iDataType == Types.DATE || iDataType == Types.TIMESTAMP || iDataType == Types.TIME) {
			dataType = "Date";
		} else if (iDataType == Types.BLOB) {
			dataType = "byte[]";
		}

		return dataType;
	}

	public String createSetter(Field field) {
		StringBuffer codeBuffer = new StringBuffer();

		codeBuffer.append("    public void set" + ColumnConvert.getGetSetterNameByProp(field.getPropertyName()) + "("
				+ getDataType(field.getDataType()) + " " + field.getPropertyName() + ") {\r\n");
		codeBuffer.append("        this." + field.getPropertyName() + " = " + field.getPropertyName() + ";\r\n");
		codeBuffer.append("    }\r\n\r\n");

		return codeBuffer.toString();
	}

	public String createGetter(Field field) {
		StringBuffer codeBuffer = new StringBuffer();

		codeBuffer.append("    public " + getDataType(field.getDataType()) + " get"
				+ ColumnConvert.getGetSetterNameByProp(field.getPropertyName()) + "() {\r\n");
		codeBuffer.append("        return this." + field.getPropertyName() + ";\r\n");
		codeBuffer.append("    }\r\n\r\n");

		return codeBuffer.toString();
	}

	public void saveToFile() {
		Field field;
		StringBuffer codeBuffer = new StringBuffer();
		String pakage = this.pakagePath.replace("\\", ".");

		codeBuffer.append("package " + pakage + ";\r\n\r\n");

		codeBuffer.append("import java.util.Date;\r\n\r\n");
		codeBuffer.append("import com.fly.common.entity.BaseModel;\r\n\r\n");

		codeBuffer.append("public class " + this.entityName + " extends BaseModel {\r\n\r\n");

		codeBuffer.append("    // Fields\r\n\r\n");

		if (this.primaryKeyField != null) {
			codeBuffer.append("    private " + getDataType(this.primaryKeyField.getDataType()) + " "
					+ this.primaryKeyField.getPropertyName() + ";\t\t" + this.primaryKeyField.getRemark() + "\r\n");
		}

		int iFieldCount = this.fields.size();
		for (int i = 0; i < iFieldCount; i++) {
			field = this.fields.get(i);
			codeBuffer.append("    private " + getDataType(field.getDataType()) + " " + field.getPropertyName()
					+ ";\t\t" + field.getRemark() + "\r\n");
		}
		codeBuffer.append("    \r\n");
		codeBuffer.append("    \r\n\r\n");
		codeBuffer.append("    \r\n");
		codeBuffer.append("    public " + this.entityName + "() {\r\n");
		codeBuffer.append("    }\r\n\r\n");

		codeBuffer.append("    \r\n\r\n");

		// 主键的getter和setter方法
		if (this.primaryKeyField != null) {
			codeBuffer.append(createSetter(this.primaryKeyField));
			codeBuffer.append(createGetter(this.primaryKeyField));
		}

		for (int i = 0; i < iFieldCount; i++) {
			field = this.fields.get(i);
			codeBuffer.append(createSetter(field));
			codeBuffer.append(createGetter(field));
		}

		codeBuffer.append("}");

		// 接口文件
		String fileName = this.srcProjectPath + this.srcPakagePath + this.entityName + ".java";

		System.out.println(fileName);

		File file = new File(fileName);

		try {
			FileUtils.writeStringToFile(file, codeBuffer.toString(), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void buildIbatis() {
		StringBuffer buff = new StringBuffer();

		String pkId = "";
		if (primaryKeyField != null) {
			pkId = ColumnConvert.getJavaBeanPropsNameBy(primaryKeyField.getFieldName());
		}

		buff.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \r\n");
		buff
				.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\"> \r\n");

		buff.append("<mapper namespace=\"" + this.pakagePath + PATH_DAO + this.entityName + "DAO\"> \r\n");
		buff.append("	<resultMap id=\"" + this.entityName + "Map\" type=\"" + this.pakagePath + PATH_MODEL + this.entityName + "\"> \r\n");

		if (StringUtils.isNotBlank(pkId)) {
			buff
					.append("		<result property=\"" + pkId + "\" column=\"" + primaryKeyField.getFieldName()
							+ "\" /> \r\n");
		}

		for (Field f : fields) {
			buff.append("		<result property=\"" + ColumnConvert.getJavaBeanPropsNameBy(f.getFieldName())
					+ "\" column=\"" + f.getFieldName() + "\" /> \r\n");
		}
		buff.append("	</resultMap> \r\n");
		buff.append("	<sql id=\"allColumns\">  \r\n");

		buff.append("		");
		if (primaryKeyField != null) {
			buff.append(primaryKeyField.getFieldName() + ",");
		}
		int i = 0;
		for (Field f : fields) {
			if (i == 0) {
				buff.append(f.getFieldName());
			} else {
				buff.append("," + f.getFieldName());
			}
			i++;
		}
		buff.append(" \r\n");
		buff.append("	</sql> \r\n");
		buff.append("	<sql id=\"dynamicWhere\"> \r\n");
		buff.append("     <where> \r\n");
		buff.append("       <trim prefixOverrides=\"and\"> \r\n");
		
        

		if (StringUtils.isNotBlank(pkId)) {
			buff.append("		<if test=\""+pkId+" != null\" >and "+primaryKeyField.getFieldName()+" = #{"+pkId+"}</if>\r\n");
		}
		for (Field f : fields) {
			String attrName = ColumnConvert.getJavaBeanPropsNameBy(f.getFieldName());
			buff.append("		<if test=\""+attrName+" != null\" >and "+f.getFieldName()+" = #{"+attrName+"}</if>\r\n");
		}
		buff.append("       </trim> \r\n");
		buff.append("     </where> \r\n");
		buff.append("	</sql> \r\n");
		buff.append("	<!-- 通过复合条件查询 --> \r\n");
		buff.append("	<select id=\"select\" parameterType=\"java.util.HashMap\" resultMap=\"" + this.entityName
				+ "Map\">  \r\n");
		buff.append("		select <include refid=\"allColumns\" />  \r\n");
		buff.append("		from  " + this.tableName + " \r\n");
		buff.append("		<include refid=\"dynamicWhere\" /> \r\n");
		buff.append("	</select> \r\n");
		buff.append("\r\n");

		if (primaryKeyField != null) {
			buff.append("	<!-- 通过主键查询对象 --> \r\n");
			buff.append("	<select id=\"selectById\" parameterType=\"java.lang.String\" resultMap=\"" + this.entityName
					+ "Map\">  \r\n");
			buff.append("			select <include refid=\"allColumns\" />  \r\n");
			buff.append("			from  " + this.tableName + " \r\n");
			buff.append("			where " + primaryKeyField.getFieldName() + " = #" + pkId + "#  \r\n");
			buff.append("	</select> \r\n");
			buff.append("\r\n");
		}

		buff.append("	<!-- 统计 --> \r\n");
		buff
				.append("	<select id=\"selectCount\" parameterType=\"java.util.HashMap\" resultClass=\"java.lang.Integer\">  \r\n");
		buff.append("		select count(1) \r\n");
		buff.append("		from  " + this.tableName + " \r\n");
		buff.append("		<include refid=\"dynamicWhere\" /> \r\n");
		buff.append("	</select> \r\n");
		buff.append("\r\n");

		if (primaryKeyField != null) {
			buff.append("	<!-- 新增对象 --> \r\n");
			buff.append("	<insert id=\"insert\" parameterType=\"" + this.pakagePath + PATH_MODEL + this.entityName + "\">  \r\n");
			buff.append("		insert into " + this.tableName + " \r\n");
			buff.append("		(  \r\n");
			buff.append("			<include refid=\"allColumns\" /> \r\n");
			buff.append("		)  \r\n");
			buff.append("		values  \r\n");
			buff.append("		(  \r\n");
			buff.append("			#" + pkId + "#,");
			for (Field f : fields) {
				buff.append("#" + ColumnConvert.getJavaBeanPropsNameBy(f.getFieldName()) + "#,");
			}
			buff.deleteCharAt(buff.length() - 1); // 移除for循环后多余的逗号
			buff.append(" \r\n");
			buff.append("		)  \r\n");
			buff.append("	</insert> \r\n");
			buff.append("\r\n");
		}
		if (primaryKeyField != null) {
			buff.append("	<!-- 修改对象 --> \r\n");
			buff.append("	<update id=\"update\" parameterType=\"" + this.pakagePath + PATH_MODEL + this.entityName + "\">  \r\n");
			buff.append("		update " + this.tableName + " \r\n");
			buff.append("		<set> \r\n");
			for (Field f : fields) {
				String attr = ColumnConvert.getJavaBeanPropsNameBy(f.getFieldName());
				buff.append("			<if test=\""+attr+" != null\" >"+f.getFieldName()+" = #{"+attr+"},</if> \r\n");
			}
			buff.append("		</set>  \r\n");
			buff.append("		where " + primaryKeyField.getFieldName() + " = #" + pkId + "# \r\n");
			buff.append("	</update> \r\n");
			buff.append("\r\n");
		}

		if (primaryKeyField != null) {
			buff.append("	<!-- 通过主键删除对象 --> \r\n");
			buff.append("	<delete id=\"deleteById\" parameterType=\"java.lang.String\"> \r\n");
			buff.append("		delete from " + this.tableName + " \r\n");
			buff.append("		where " + primaryKeyField.getFieldName() + " = #" + pkId + "# \r\n");
			buff.append("	</delete> \r\n");
			buff.append("\r\n");
		}

		buff.append("</mapper> \r\n");

		// 接口文件
		String fileName = this.srcProjectPath + this.srcPakagePath + this.entityName + "Mapper.xml";

		System.out.println(fileName);

		File file = new File(fileName);

		try {
			FileUtils.writeStringToFile(file, buff.toString(), "utf-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
