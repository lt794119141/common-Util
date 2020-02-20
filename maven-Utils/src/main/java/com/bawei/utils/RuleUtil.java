package com.bawei.utils;
import java.util.Date;

public class RuleUtil {

	@SuppressWarnings("deprecation")
	public static String rule(String typeId,long juli,String cardId) {
		int day = new Date().getDay()/2;
		//摩托车A 牌照 并且 距离小于15 
		if(typeId=="A"&&juli<15) {
			return "摩托车A进入2环";
		}
		//摩托车B 牌照 并且 距离小于40
		if(typeId=="B"&&juli<40) {
			return "摩托车B进入4环";
		}
		//汽车c 牌照  并且 牌照第一个字母不等于’京’ 并且距离小于60
		if(typeId=="C" && cardId.substring(0,1).equals("京") && juli<60) {
			return "外地牌照不能进入5环";
		}
		//汽车c 牌照  并且 牌照第一个字母等于’京’
		if(typeId=="C"&&cardId.substring(0).equals("京")) {
		
			if(day==0) {
				if(cardId.substring(6).equals("0")||cardId.substring(6).equals("1")||cardId.substring(6).equals("3")||cardId.substring(6).equals("5")||cardId.substring(6).equals("7")||cardId.substring(6).equals("9")) {
					return "违反单双号限行规定";
				}
			}
			if(day!=0) {
				if(cardId.substring(6).equals("2")||cardId.substring(6).equals("4")||cardId.substring(6).equals("6")||cardId.substring(6).equals("8")) {
					return "违反单双号限行规定";
				}
			}
		}
		return "没有违反交通规则";
	}
	public static  String ceshi(String typeId,long juli,String cardId) {
		String rule = rule(typeId, juli, cardId);
		return rule;
	}
	public static void main(String[] args) {
	
	}
}
