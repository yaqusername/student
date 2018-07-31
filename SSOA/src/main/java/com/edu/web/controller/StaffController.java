package com.edu.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Staff;
import com.edu.service.StaffService;
@Service
public class StaffController {
	@Autowired
	private StaffService service;

	// 
	@RequestMapping(value = "/staffadd.do", method = { RequestMethod.POST })
	public String add(Staff staff) {
		if (service.insert(staff)) {
			return "stafflist";
		} else {
			return "staffadd";
		}
	}

	// 
	@RequestMapping(value = "/staffupdate.do", method = { RequestMethod.POST })
	public String updateFrom(Staff staff) {
		if (service.update(staff).getCode() == 1000) {
			return "stafflist";
		} else {
			return "staffupdate";
		}
	}

	// 
	@RequestMapping(value = "staffdelete.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo delete(String no) {
		return service.delete(no);
	}

	// 
	@RequestMapping(value = "staffpage.do")
	@ResponseBody
	public PageVo<Staff> queryPage(int page, int limit) {
		return service.queryByPage(page, limit);
	}

	// 
	@RequestMapping(value = "staffall.do")
	@ResponseBody
	public List<Staff> queryAll() {
		return service.queryAll();
	}
	@RequestMapping(value = "staffno.do")
	@ResponseBody
	public ResultVo queryMaxNo() {
		return ResultVo.OK(service.queryMaxNo());
	}
	
}
