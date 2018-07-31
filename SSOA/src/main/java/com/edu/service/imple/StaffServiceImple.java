package com.edu.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Staff;
import com.edu.mapper.StaffMapper;
import com.edu.service.StaffService;
@Service
public class StaffServiceImple implements StaffService {
	@Autowired
	private StaffMapper mapper;

	@Override
	public boolean insert(Staff staff) {
		return mapper.insert(staff) > 0;
	}

	@Override
	public ResultVo update(Staff staff) {
		if (mapper.updateById(staff) > 0) {
			return ResultVo.OK("修改成功");
		} else {
			return ResultVo.ERROR("修改失败");
		}
	}

	@Override
	public ResultVo delete(String no) {
		if (mapper.deleteById(no) > 0) {
			return ResultVo.OK("删除成功");
		} else {
			return ResultVo.ERROR("删除失败");
		}
	}

	@Override
	public List<Staff> queryAll() {
		return mapper.queryAll();
	}

	@Override
	public PageVo<Staff> queryByPage(int page, int count) {
		int index = 0;
		if (page > 0) {
			index = (page - 1) * count;
		}
		PageVo<Staff> po = new PageVo<>();
		po.setData(mapper.queryByPage(index, count));
		if (po.getData() != null) {
			po.setCount(mapper.queryCount().intValue());
		}
		po.setCode(0);
		po.setMsg("OK");
		return po;
	}
	
	@Override
	public String queryMaxNo() {
		return mapper.queryMaxNo();
	}

	
}
