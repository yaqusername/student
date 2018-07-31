package com.edu.service.imple;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.common.utils.MD5Utils;
import com.edu.domain.User;
import com.edu.mapper.UserMapper;
import com.edu.service.UserService;
@Service
public class UserServiceImple implements UserService{
@Autowired
private UserMapper mapper;
	
    @Override
	public boolean save(User user) {
		return mapper.save(user)>0;
	}
    
    @Override//登陆，查询
	public User queryByNo(String no, String password) {
		//User user = new User();
		User user1 = mapper.queryByNo(no);
		if(user1!=null) {
			if(Objects.equals(password, user1.getPassword())){
				return user1;
			}
		}
		return null;
	}
    
    @Override
	public boolean updatePassword(User user) {
		user.setPassword((user.getPassword()));
    	return mapper.updatePassword(user)>0;
	}
    
    @Override
	public boolean saveBach(List<User> list) {
		for(User u :list) {
			mapper.save(u);
			return true;
		}
    	return false;
	}

}
