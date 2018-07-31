package com.edu.service.imple;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Depart;
import com.edu.mapper.DepartMapper;
import com.edu.service.DepartService;
@Service
public class DepartServiceImple implements DepartService{
@Autowired
private DepartMapper mapper;

@Override
public boolean save(Depart depart) {
	return mapper.save(depart)>0;
}

@Override
public ResultVo delete(int id) {
	 if(mapper.delete(id)>0) {
		 return ResultVo.OK("删除成功");
	 }else {
		 return ResultVo.ERROR("删除失败");
	 }
}

@Override
public ResultVo update(String name, int id) {
	if(mapper.update(id, name)>0) {
		return ResultVo.OK("修改成功");
	}else {
		return ResultVo.ERROR("修改失败");
	}
}

@Override
public Long queryCount(int index, int count) {
	return mapper.queryCount();
}


@Override
public PageVo queryByPage(int page, int count) {
	PageVo<Depart> vo = new PageVo<>();
	int index =0;
	if (page>0) {
		index= (page-1)*count;
	}
	List<Depart> list = mapper.queryByPage(index, count);
	if(list!=null) {
		vo.setCode(0);
		vo.setMsg("");
		vo.setData(list);
		vo.setCount(mapper.queryCount().intValue());
	}else {
		vo.setCode(1);
		vo.setMsg("暂无数据");
		vo.setData(new ArrayList<>());
		vo.setCount(0);
	}
	return vo;
}
	

}





















