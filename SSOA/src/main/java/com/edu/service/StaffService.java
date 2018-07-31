package com.edu.service;

import java.util.List;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Staff;

public interface StaffService {
	
	boolean insert(Staff staff);
	
	ResultVo update(Staff staff);
	
	ResultVo delete(String no);
	
	List<Staff> queryAll();
	
	PageVo<Staff> queryByPage(int page,int count);
	
	String queryMaxNo();
}
