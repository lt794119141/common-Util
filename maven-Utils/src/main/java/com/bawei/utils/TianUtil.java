package com.bawei.utils;

public class TianUtil {
	//距离天安门的距离
	public static long juli(int x1,int y1) {
		//计算距离天安门距离的公式
		long round = Math.round( Math.sqrt( Math.pow(x1 - 39 ,2  ) +  Math.pow(y1 - 116 ,2  ) ));
		
		return round;
	}
	//判断当前在几环
	public static int huanshu(long round) {
		if(round>=0&&round<=15) {
			return 2;
		}
		else if(round>15&&round<=30) {
			return 3;
		}
		else if(round>30&&round<=40) {
			return 4;
		}
		else if(round>40&&round<=60) {
			return 5;
		}
		else if(round>60&&round<=70) {
			return 6;
		}
		
		return 0;
	}
	public static int huan(int x1,int y1) {
		long juli = juli(x1, y1);
		int huanshu = huanshu(juli);
		
		
		return huanshu;
	}
	public static void main(String[] args) {
		System.out.println(huan(66,142));
		
	}
}
