package com.edu.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.UUID;

//随机�?
public class RandomUtils {
	//生成�?活码
	public static String createActive(){
		return getTime()+Integer.toHexString(new Random().nextInt(900)+100);
	}
	//设置时间�?
	public static String getTime(){
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime());
	}
	//生成订单编号
	public static String createOrderId(){
		return getTime()+UUID.randomUUID().toString();
	}
}
