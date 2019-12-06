package com.bawei.utils;

import java.util.Random;

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
	
	
	public static boolean isEmail(String str) {
		String regex="[A-Za-z0-9]+@[A-Za-z0-9]+.(com|cn|com.cn|net)";
		return str.matches(regex);
	}
	
	public static boolean isLetter(String str) {
		if(isNotBlank(str)) {
			str=str.toLowerCase();
			String regex="[a-z]+";
			return str.matches(regex);
		}
		return false;
	}
	
	public static char getRandomAzChar() {
		Random random = new Random();
		int startChar='a'+0;
		char c=(char)(startChar+random.nextInt(26));
		return c;
	}
	
	public static String getRandomLetter(int num) {
		StringBuffer sb=new StringBuffer();
		//生成随机字符
		for(int i=0;i<num;i++) {
			char newChar=getRandomAzChar();
			sb.append(newChar);
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(isEmail("79441@qq.com"));
	}
}
