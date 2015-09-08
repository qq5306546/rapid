package com.rapid.common.base.mybatis.autobuilder;

/**
 * 自动代码生成
 * 
 * @author cs
 * 
 */
public class AutoBuilder {
 
	// 源文件所在工程目录
	static String SRC_PROJECT_PATH = "/Users/wubei/Desktop";
	// 代码文件生成路径
	static String PAKAGE_PATH = "com.rapid.module.party";
	// 数据库配置文件
	static String DB_PROPERTIES = "jdbc.properties";
	// 根据表自行定义
	static String[] TABLE_NAME = {"person", "party", "party_group", "party_type", "role_type", "party_role", "party_relationship_type", "party_relationship"};

	public static void main(String[] args) throws Exception {
		for (String name : TABLE_NAME) {
			Entity entity = new Entity(PAKAGE_PATH, SRC_PROJECT_PATH);
			entity.builderEntity(DB_PROPERTIES, name);
			entity.buildIbatis();
		}
	}
}
