package com.rapid.common.base.mybatis.autobuilder;

public class ColumnConvert {

	public ColumnConvert() {

	}

	public static String getJavaBeanNameBy(String entityName) {
		StringBuffer javaBeanName = new StringBuffer();

		String[] attrs = entityName.split("_");

		for (int i = 0; i < attrs.length; i++) {
			javaBeanName.append(attrs[i].substring(0, 1).toUpperCase() + attrs[i].substring(1, attrs[i].length()));
		}

		return javaBeanName.toString();
	}

	public static String getGetSetterNameByProp(String propName) {
		String getSetterName = propName.substring(0, 1).toUpperCase();
		getSetterName += propName.substring(1);

		return getSetterName;
	}

	public static String getJavaBeanPropsNameBy(String columnName) {
		String javaBeanName = "";
		boolean bFlag = false;
		boolean bFirstFlag = false;
		char ch;

		columnName = columnName.toUpperCase();
		for (int i = 0; i < columnName.length(); i++) {
			ch = columnName.charAt(i);
			if (!bFirstFlag) {
				javaBeanName += Character.toString(columnName.charAt(i)).toLowerCase();
				bFirstFlag = true;
				bFlag = true;
				continue;
			}

			if (!bFlag) {
				javaBeanName += ch;
				bFlag = true;
			} else {
				if (ch != '_') {
					javaBeanName += Character.toString(columnName.charAt(i)).toLowerCase();
				} else {
					bFlag = false;
				}
			}
		}

		return javaBeanName;
	}
}
