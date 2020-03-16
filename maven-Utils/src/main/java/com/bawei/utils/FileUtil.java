package com.bawei.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

/**
 * 文件工具类
 * @Description:封装文件的常用方法  
 * @author: zhanggm1002
 * @date:   2019年12月5日 下午1:27:47
 */
public class FileUtil {
	/**
	 * 根据文件，截取扩展名
	 * @param fileName "aa.png"
	 * @return
	 */
	public static String getExtName(String fileName) {
		//处理空异常
		if(fileName==null || "".equals(fileName)) {
			throw new RuntimeException("文件名不能为空");
		}
		if(fileName.indexOf(".")<=-1) {
			throw new RuntimeException(fileName+":该文件名没有包含扩展名");
		}
		String extName = fileName.substring(fileName.lastIndexOf("."));
		return extName;
	}
	/**
	 * 获取系统当前用户目录
	 * @return
	 */
	public static String getSystemUserHome() {
		return System.getProperty("user.home");
	}
	/**
	 * @Title: getSystemTempDirectory   
	 * @Description: 操作系统临时目录
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getSystemTempDirectory() {
		return System.getProperty("java.io.tmpdir");
	}
	/**
	 * @Title: readTextFileByLine   
	 * @Description: 读取文件内容   
	 * @param: @param pathname
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String readTextFileByLine(String pathname) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		String str=null;
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));
			while((str=br.readLine())!=null) {
				sb.append(str);
				sb.append("\r\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			StreamUtil.closeAll(br);
		}
		return sb.toString();
	}
	/**
	 * @Title: readTextFileOfList   
	 * @Description: 按行读取文件内容到list集合   
	 * @param: @param pathname
	 * @param: @return      
	 * @return: List<String>      
	 * @throws
	 */
	public static List<String> readTextFileOfList(String pathname) {
		BufferedReader br = null;
		List<String> strList = new ArrayList<>();
		String str=null;
		try {
			br = new BufferedReader(new FileReader(new File(pathname)));
			/*do {
				strList.add(br.readLine());
			}while(br.read()!=-1);*/
			while((str=br.readLine())!=null) {
				strList.add(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}finally {
			StreamUtil.closeAll(br);
		}
		return strList;
	}
	/**
	 * @Title: deleteFile   
	 * @Description: 递归删除文件   
	 * @param: @param file      
	 * @return: void      
	 * @throws
	 */
	public static void deleteFile(File file) {
		if(file.isDirectory()) {
			File[] listFiles = file.listFiles();
			for(File theFile:listFiles) {
				deleteFile(theFile);
			}
			file.delete();
		}else {
			file.delete();
		}
	}
	/**
	 * @Title: deleteFile   
	 * @Description: 递归删除文件  
	 * @param: @param filePath      
	 * @return: void      
	 * @throws
	 */
	public static void deleteFile(String filePath) {
		deleteFile(new File(filePath));
	}
	/**
	 * @Title: getFileSize   
	 * @Description: 获得文件大小
	 * 返回文件以指定单位大小表示
	 * File a.txt=2k  
	 * @param: @param file
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getFileSize(File file) {
		long length = file.length();
		double len = length/1024.0;
//		return Math.round((length/1024.0))+"kb";
		return String.format("%.2f",len)+"kb";
	}
	
	public static String getFileSize(String fileFullName) {
		return getFileSize(new File(fileFullName));
	}
	
	/**
	 *  上传文件
	 * @param file
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String processFile(MultipartFile file) throws IllegalStateException, IOException {

		// 原来的文件名称
		System.out.println("file.isEmpty() :" + file.isEmpty()  );
		System.out.println("file.name :" + file.getOriginalFilename());
		
		if(file.isEmpty()||"".equals(file.getOriginalFilename()) || file.getOriginalFilename().lastIndexOf('.')<0 ) {
			return "";
		}
			
		String originName = file.getOriginalFilename();
		String suffixName = originName.substring(originName.lastIndexOf('.'));
		SimpleDateFormat sdf=  new SimpleDateFormat("yyyyMMdd");
		String path = "d:/pic/" + sdf.format(new Date());
		File pathFile = new File(path);
		if(!pathFile.exists()) {
			pathFile.mkdir();
		}
		String destFileName = 		path + "/" +  UUID.randomUUID().toString() + suffixName;
		File distFile = new File( destFileName);
		file.transferTo(distFile);//文件另存到这个目录下边
		return destFileName.substring(7);
		
		
	}
	
	public static void main(String[] args) {
		
	}
	
}
