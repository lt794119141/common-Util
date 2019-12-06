package com.bawei.utils;

public class FileUtil {

	public static String getExtName(String fileName) {
		if(fileName==null || "".equals(fileName)) {
			throw new RuntimeException("文件名不能为空");
		}
		String extName=fileName.substring(fileName.lastIndexOf("."));
		return extName;
		
	}
	
	public static String getUserHome() {
		return System.getProperty("user.home");
	}
	
	public static void main(String[] args) {
		System.out.println(getExtName("aaadddd.jsp"));
	}
	
}
