package com.edu.service;

import java.util.List;

import com.edu.domain.User;

public interface UserService {

	//����
	public boolean save(User user);
	
	//��ѯ ��½
	public User queryByNo(String no,String password); 
	
	//�޸�����
	public boolean updatePassword(User user);
	
	//��������
	public boolean saveBach(List<User> list);
}
