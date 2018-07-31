package com.edu.service;


import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Classs;

public interface ClasssService {
	    
	
		//鏂板鐝骇
		public boolean save(Classs classs);
		
		//鍒犻櫎鐝骇
		public ResultVo delete(String no);
		
		//淇敼鐝骇
		public ResultVo update(String name,String no,String week,String location);
		
		//鏌ヨ鎬绘暟閲�
		public Long queryCount(int index,int count);
		
		//鍒嗛〉鏌ヨ
		public PageVo queryByPage(int page,int count);
}
