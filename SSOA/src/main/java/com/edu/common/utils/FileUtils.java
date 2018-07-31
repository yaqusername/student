/**  
* @Title: FileUtils.java  
* @Package com.qfedu.common.utils  
* @Description: TODO(用一句话描述该文件做�?�?)  
* @author Feri 
* @date 2018�?5�?29�?  
* @version V1.0  
*/  
package com.edu.common.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**  
* @Title: FileUtils.java  
* @Package com.qfedu.common.utils  
* @Description: TODO(用一句话描述该文件做�?�?)  
* @author Feri  
* @date 2018�?5�?29�?  
* @version V1.0  
* 文件工具�?
*/
public class FileUtils {
	
	//创建文件�? �?个月�?个文件夹
	public static File createDir(String dir) {
		//子文件名称：201805 201806
		String month=new SimpleDateFormat("yyyyMM").format(new Date());
		File dir1=new File(new File(dir).getParent(),"xiaomiimages");
		File dir2=new File(dir1,month) ;
		if(!dir2.exists()) {
			dir2.mkdirs();
		}
		return dir2;
	}
	//创建唯一名称 
	public static String createFileName(String fn) {
		if(fn.length()>30) {
			fn=fn.substring(fn.length()-30);
		}
		return UUID.randomUUID().toString()+"_"+fn;
	}
	

}
