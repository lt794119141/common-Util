package com.bawei.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static int getAge(Date birthDate) {
		//获得日历控件
		Calendar calendar=Calendar.getInstance();
		int nowYear=calendar.get(Calendar.YEAR);
		int nowMonth=calendar.get(Calendar.MONTH);
		int nowDay=calendar.get(Calendar.DAY_OF_MONTH);
		//设置生日
		calendar.setTime(birthDate);
		int birthYear=calendar.get(Calendar.YEAR);
		int birthMonth=calendar.get(Calendar.MONTH);
		int birthDay=calendar.get(Calendar.DAY_OF_MONTH);
		//年龄
		int age=nowYear-birthYear;
		//如果生日月份大于当前月份    年龄-1
		if(birthMonth>nowMonth) {
			age--;
		}
		if(birthMonth==nowMonth &&  nowDay<birthDay ) {
			age--;
		}
		return age;
	}
	
	public static int getAge(String birthDateStr) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		Date parse =null;
		try {
			 parse=sd.parse(birthDateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getAge(parse);
	}
	
	
	public static void main(String[] args) {
		System.out.println(getAge("1999-09-21"));
	}
}
