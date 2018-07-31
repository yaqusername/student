package com.edu.common.utils;
//字符串的各种校验
public class StrUtils {
	
	/**
	 * 是否为空的校�?
	 * @return true �? false 非空*/
	public static boolean empty(String...msg){
		boolean res = false;
		for(String s:msg){
			res = (s==null|| s.length()==0);
			if(res) {
				break;
			}
		}
		return res;
	}
}
