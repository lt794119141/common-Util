package com.bawei.utils;

import java.util.Date;

public class TimeUtil {

	public static boolean time(String typeId,String cardId) {
		//判断星期的奇偶性
		int day = new Date().getDay()/2;
		boolean bl=false;
		//当是汽车时并且牌照为京时
		if(typeId=="C"&&cardId.substring(0).equals("京")) {
			//当day==0时说明为偶
			if(day==0) {
				
				if(cardId.substring(6).equals("0")||cardId.substring(6).equals("1")||cardId.substring(6).equals("3")||cardId.substring(6).equals("5")||cardId.substring(6).equals("7")||cardId.substring(6).equals("9")) {
					return bl;
				}
			}
			//当day==0时说明为奇
			if(day!=0) {
				if(cardId.substring(6).equals("2")||cardId.substring(6).equals("4")||cardId.substring(6).equals("6")||cardId.substring(6).equals("8")) {
					return bl;
				}
			}
		}
		return bl=true;
	}
}
