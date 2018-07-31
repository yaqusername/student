package com.edu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Classs;
import com.edu.domain.Depart;
import com.edu.service.ClasssService;

@Controller
public class ClasssController {
	@Autowired
	private ClasssService service;
	

	//新增
	@RequestMapping(value="/classsadd.do",method= {RequestMethod.POST})
	public String save(Classs classs) {
		if (service.save(classs)) {
			return "classslist";
		}else {
			return "classsadd";
		}
	}
	
	//修改--基于Ajax
	@RequestMapping(value="/classsupdate1.do",method= {RequestMethod.POST})
	@ResponseBody
	public ResultVo updateAjax(String name,String no,String week,String location) {
		return service.update(name, no,week,location);
	}
	
	//修改--基于form表单
	@RequestMapping(value="/classsupdate.do",method= {RequestMethod.POST})
	public String updateForm(String name,String no,String week,String location) {
		if (service.update(name, no,week,location).getCode()==1000) {
			return "classslist";
		}else {
			return "classsupdate";
		}
	}
	
	//删除--json格式数据 ---ajax
	@RequestMapping(value="/classsdelete.do",method= {RequestMethod.POST})
	@ResponseBody
	public ResultVo delete(String no) {
		return service.delete(no);
	}
	
	//查询  --分页
	@RequestMapping(value="/classspage.do")
	@ResponseBody
	public PageVo<Classs> queryByPage(int page,int limit){
		return service.queryByPage(page, limit);
	}
	
}
