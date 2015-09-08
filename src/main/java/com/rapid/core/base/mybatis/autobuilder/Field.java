package com.rapid.core.base.mybatis.autobuilder;

/**
 * @author Administrator
 * 
 */
public class Field {
	private String fieldName;
	private String propertyName;
	private int dataType;
	private String remark;
	private boolean primaryKey;

	public Field(String fieldName, String propertyName, boolean primaryKey) {
		super();
		this.fieldName = fieldName;
		this.primaryKey = primaryKey;
		this.propertyName = propertyName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public int getDataType() {
		return dataType;
	}

	public void setDataType(int dataType) {
		this.dataType = dataType;
	}

	public String getRemark() {
		if (this.remark != null && !this.remark.equals("")) {
			return "//" + this.remark;
		}
		return "";
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
