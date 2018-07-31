package com.edu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.edu.domain.Classs;

public interface ClasssMapper {
	//新增班级
	@Insert("insert into t_grade(no,name,createtime,flag,week,location) values(#{no},#{name},#{createtime},1,#{week},#{location})")
	public int save(Classs classs);
	
	
	//修改班级
	@Update("update t_grade set name=#{name},week=#{week},location=#{location} where id=#{id} and flag=1")
	public int update(@Param("id")int id,@Param("name")String name,@Param("week")String week,@Param("location")String location);
	
	
	//删除班级
	@Update("update t_grade set flag=2 where id=#{id}")
	public int delete(int id);
	
	//查询数量
	@Select("select count(*) from t_grade where flag=1")
	@ResultType(Long.class)
	public Long queryCount();
	
	//分页查询
	@Select("select * from t_grade where flag=1 limit #{rowindex},#{count}")
	@ResultType(Classs.class)
	public List<Classs> queryByPage(@Param("rowindex")int index,@Param("count")int count);	
}
