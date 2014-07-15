package com.fm.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将对象反射出表属性名和属性值
 * 
 * @author caizhi 1.0 2014-04-25
 * 
 */
public class ReflectUtil {

	/**
	 * 通过反射机制获取obj对象的属性名和属性值
	 * 
	 * @param obj
	 * @return
	 */
	public Map<String, Object> getFieldAndValue(Object obj) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<String> useFileName = new ArrayList<String>();
		List<Object> useFileValue = new ArrayList<Object>();
		String[] fileName = this.getFiledName(obj);
		for (String fName : fileName) {
			Object value = this.getFieldValueByName(fName, obj);
			if (value != null) {
				useFileName.add(fName);
				useFileValue.add(value);
			}
		}
		String tableName = this.getTableName(obj.getClass().getName());
		map.put("tableName", tableName);
		map.put("fileName", useFileName);
		map.put("fileValue", useFileValue);

		return map;
	}

	/**
	 * 通过类名获取表名
	 * 
	 * @param field
	 * @return
	 */
	public String getTableName(String field) {
		return "t" + this.getTableField(field.substring(field.lastIndexOf(".")+1));
	}

	/**
	 * 将对象属性名转换成对应的表属性名
	 * 
	 * @param field
	 *            对象属性名
	 * @return
	 */
	private String getTableField(String field) {
		if (field != null) {
			String[] strArray = field.split("[A-Z]+");
			String tableField = "";
			for (int i = 0; i < strArray.length; i++) {
				tableField = tableField + strArray[i];
				if ((i + 1) != strArray.length) {
					int begin = tableField.length() - i;
					int end = tableField.length() - i + 1;
					String upLetter = field.substring(begin, end).toLowerCase();
					tableField = tableField + "_" + upLetter;
				}
			}
			return tableField;
		} else
			return null;
	}

	/**
	 * 获取对象属性，返回一个字符串数组
	 * 
	 * @param o
	 *            对象
	 * @return String[] 字符串数组
	 */
	private String[] getFiledName(Object o) {
		try {
			Field[] fields = o.getClass().getDeclaredFields();
			String[] fieldNames = new String[fields.length];
			for (int i = 0; i < fields.length; i++) {
				fieldNames[i] = fields[i].getName();
			}
			return fieldNames;
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取对象第一个属性，返回一个字符串
	 * @param <T>
	 * 
	 * @param o
	 *            对象
	 * @return String[] 字符串数组
	 */
	public <T> String getFiledName(Class<T> clz) {
		try {
			Field[] fields = clz.getDeclaredFields();
			return fields[1].getName();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 使用反射根据属性名称获取属性值
	 * 
	 * @param fieldName
	 *            属性名称
	 * @param o
	 *            操作对象
	 * @return Object 属性值
	 */

	private Object getFieldValueByName(String fieldName, Object o) {
		try {
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getter = "get" + firstLetter + fieldName.substring(1);
			Method method = o.getClass().getMethod(getter, new Class[] {});
			Object value = method.invoke(o, new Object[] {});
			return value;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ReflectUtil 对象用于单例
	 */
	private static ReflectUtil reflectUtil = null;

	/**
	 * 获取一个实例(单例)
	 * 
	 * @return
	 */
	public static ReflectUtil getInstance() {
		if (reflectUtil == null)
			reflectUtil = new ReflectUtil();
		return reflectUtil;
	}

	/**
	 * 私有构造方法，不让new实例
	 */
	private ReflectUtil() {
	}
	
//	public static void main(String[] args) {
//		ReflectUtil r = ReflectUtil.getInstance();
//		String[] u = r.getFiledName(new User());
//		for (String string : u) {
//			System.out.println(string);
//		}
//	}
}
