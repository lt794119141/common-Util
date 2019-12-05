package com.bawei.utils;

public class StringUtil {

	public static boolean isPhoneNum(String str) {
		String regex ="1[3578]\\d{9}";
		return str.matches(str);
	}
	
	public static void main(String[] args) {
		System.out.println(isPhoneNum("18636074152"));
	}
}
