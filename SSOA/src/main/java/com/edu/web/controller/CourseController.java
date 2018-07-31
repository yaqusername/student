package com.edu.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Course;
import com.edu.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService service;

	@RequestMapping(value = "/courseadd.do", method = { RequestMethod.POST })
	public String add(Course course) {
		if (service.insert(course)) {
			return "courselist";
		} else {
			return "courseadd";
		}
	}

	@RequestMapping(value = "/courseupdate.do", method = { RequestMethod.POST })
	public String updateFrom(Course course) {
		if (service.update(course).getCode() == 1000) {
			return "courselist";
		} else {
			return "courseupdate";
		}
	}

	@RequestMapping(value = "coursedelete.do", method = { RequestMethod.POST })
	@ResponseBody
	public ResultVo delete(int id) {
		return service.delete(id);
	}

	@RequestMapping(value = "coursepage.do")
	@ResponseBody
	public PageVo<Course> queryPage(int page, int limit) {
		return service.queryByPage(page, limit);
	}

	@RequestMapping(value = "courseall.do")
	@ResponseBody
	public List<Course> queryAll() {
		return service.queryAll();
	}
}
