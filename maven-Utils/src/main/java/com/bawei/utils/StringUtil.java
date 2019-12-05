package com.bawei.utils;

public class StringUtil {

	/**
	 * 
	* @Title: isBlank 
	* @Description: 判断是否为空 
	* @param @param str
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isBlank(String str) {
		if(str==null) {
			return true;
		}
		//去掉空格
		str=str.trim();
		if(str.length()==0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	* @Title: isNotBlank 
	* @Description: 判断是否非空 
	* @param @param str
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isNotBlank(String str) {
		return !isBlank(str);
	}
	
	
	/**
	 * 
	* @Title: isPhoneNum 
	* @Description: 判断是否是电话号
	* @param @param str
	* @param @return    设定文件 
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isPhoneNum(String str) {
		String regex ="1[3578]\\d{9}";
		return str.matches(str);
	}
	
	public static void main(String[] args) {
		System.out.println(isPhoneNum("18636074152"));
	}
}
