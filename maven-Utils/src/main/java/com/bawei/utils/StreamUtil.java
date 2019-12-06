package com.bawei.utils;

import java.io.File;
import java.io.FileInputStream;

public class StreamUtil {

	/**
	 * 
	* @Title: closeAll 
	* @Description: 关闭流
	* @param @param autoCloseables    设定文件 
	* @return void    返回类型 
	* @throws
	 */
	public static void closeAll(AutoCloseable... autoCloseables) {
		if(autoCloseables!=null) {
			for (AutoCloseable autoCloseable : autoCloseables) {
				try {
					autoCloseable.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String getFileContent(File file) {
		FileInputStream inputStream =null;
		try {
			 inputStream=new FileInputStream(file);
			byte[] b=new byte[1024];
			String str="";
			while(inputStream.read(b)!=-1) {
				str+=new String(b);
			}
			return str;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			closeAll(inputStream);
		}
		
	}
	
	
	public static String getFileContent(String fileName) {
		return getFileContent(new File(fileName));
	}
	
	public static void main(String[] args) {
		System.out.println(getFileContent("F:\\GitTest\\maven-demo2\\readme.txt"));
	}
}
