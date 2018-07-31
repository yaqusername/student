package com.edu.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Course;
import com.edu.mapper.CourseMapper;
import com.edu.service.CourseService;
@Service
public class CourseServiceImple implements CourseService {

	@Autowired
	private CourseMapper mapper;

	@Override
	public boolean insert(Course course) {
		return mapper.insert(course) > 0;
	}

	@Override
	public ResultVo update(Course course) {
		if (mapper.updateById(course) > 0) {
			return ResultVo.OK("修改成功");
		} else {
			return ResultVo.ERROR("修改失败");
		}
	}

	@Override
	public ResultVo delete(int id) {
		if (mapper.deleteById(id) > 0) {
			return ResultVo.OK("删除成功");
		} else {
			return ResultVo.ERROR("删除失败");
		}
	}

	@Override
	public List<Course> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public PageVo<Course> queryByPage(int page, int count) {
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		PageVo<Course> po = new PageVo<>();
		po.setData(mapper.queryByPage(index, count));
		if (po.getData() != null) {
			po.setCount(mapper.queryCount().intValue());
		}
			po.setCode(0);
			po.setMsg("OK");
		return po;
	}
}
