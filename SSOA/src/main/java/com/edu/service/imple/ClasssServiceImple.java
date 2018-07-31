package com.edu.service.imple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Classs;
import com.edu.domain.Depart;
import com.edu.mapper.ClasssMapper;
import com.edu.service.ClasssService;
@Service
public class ClasssServiceImple implements ClasssService{
@Autowired
private ClasssMapper mapper;
	@Override
	public boolean save(Classs classs) {
		return mapper.save(classs)>0;
	}

	@Override
	public ResultVo delete(String no) {
		if(mapper.delete(no)>0) {
			return ResultVo.OK("删除成功");
		}else {
			return ResultVo.ERROR("删除失败");
		}
	}

	@Override
	public ResultVo update(String name, String no, String week, String location) {
		if (mapper.update(no, name, week, location)>0) {
			return ResultVo.OK("修改成功");
		}else {
			return ResultVo.ERROR("修改成功");
		}
	}

	@Override
	public Long queryCount(int index, int count) {
		return mapper.queryCount();
	}

	@Override
	public PageVo queryByPage(int page, int count) {
		PageVo<Classs> vo = new PageVo<>();
		int index =0;
		if (page>0) {
			index= (page-1)*count;
		}
		List<Classs> list = mapper.queryByPage(index, count);
		if(list!=null) {
			vo.setCode(0);
			vo.setMsg("");
			vo.setData(list);
			vo.setCount(mapper.queryCount().intValue());
		}else {
			vo.setCode(1);
			vo.setMsg("��������");
			vo.setData(new ArrayList<>());
			vo.setCount(0);
		}
		return vo;
	}
	
}
