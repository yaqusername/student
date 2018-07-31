package com.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.edu.domain.Depart;

public interface DepartMapper {
	//新增
	@Insert("insert into t_depart(name,createtime,flag) values(#{name},#{createtime},1)")
	public int save(Depart depart);
	
	
	//修改
	@Update("update t_depart set name=#{name} where id=#{id} and flag=1")
	public int update(@Param("id")int id,@Param("name")String name);
	
	
	//删除
	@Update("update t_depart set flag=2 where id=#{id}")
	public int delete(int id);
	
	//查询数量
	@Select("select count(*) from t_depart where flag=1")
	@ResultType(Long.class)
	public Long queryCount();
	
	//分页查询
	@Select("select id,name,createtime,flag from t_depart where flag=1 limit #{rowindex},#{count}")
	@ResultType(Depart.class)
	public List<Depart> queryByPage(@Param("rowindex")int index,@Param("count")int count);		
}
