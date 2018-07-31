package com.edu.service;

import java.util.List;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Course;

public interface CourseService {
	boolean insert(Course course);

	ResultVo update(Course course);

	ResultVo delete(int id);

	List<Course> queryAll();

	PageVo<Course> queryByPage(int page, int count);
}
