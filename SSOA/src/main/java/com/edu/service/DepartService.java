package com.edu.service;


import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Depart;

public interface DepartService {
	
	
	//新增
	public boolean save(Depart depart);
	
	//查询
	public ResultVo delete(int id);
	
	//分页查询
	public ResultVo update(String name,int id);
	
	//查询全部数量
	public Long queryCount(int index,int count);
	
	//删除
	public PageVo queryByPage(int page,int count);
}
