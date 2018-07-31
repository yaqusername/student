package com.edu.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.edu.domain.User;

public interface UserMapper {
	//新增
	@Insert("insert into t_user(no,password,flag,role) values(#{no},#{password},1,#{role})")
	public int save(User user);
	
	
	//登陆
	@Select("select * from t_user where no=#{no} and flag=1 and role=1")
	@ResultType(User.class)
	public User queryByNo(String no);
	
	//

	//修改密码
	@Update("update t_user set password=#{password} where no =#{no} and flag=1 and role=1")
	public int updatePassword(User user);
	
}
