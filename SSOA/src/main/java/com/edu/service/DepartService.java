package com.edu.service;


import com.edu.common.vo.PageVo;
import com.edu.common.vo.ResultVo;
import com.edu.domain.Depart;

public interface DepartService {
	
	
	//����
	public boolean save(Depart depart);
	
	//��ѯ
	public ResultVo delete(int id);
	
	//��ҳ��ѯ
	public ResultVo update(String name,int id);
	
	//��ѯȫ������
	public Long queryCount(int index,int count);
	
	//ɾ��
	public PageVo queryByPage(int page,int count);
}
