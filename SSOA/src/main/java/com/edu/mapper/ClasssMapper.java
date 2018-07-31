package com.edu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.edu.domain.Classs;

public interface ClasssMapper {
	//新增班级
	@Insert("insert into t_classs(no,name,createtime,flag,week,location,courseid) values(#{no},#{name},#{createtime},1,#{week},#{location},#{courseid})")
	public int save(Classs classs);
	
	
	//修改班级
	@Update("update t_classs set name=#{name},week=#{week},location=#{location} where no=#{no} and flag=1")
	public int update(@Param("no")String no,@Param("name")String name,@Param("week")String week,@Param("location")String location);
	
	
	//删除班级
	@Update("update t_classs set flag=2 where no=#{no}")
	public int delete(String no);
	
	//查询数量
	@Select("select count(*) from t_classs where flag=1")
	@ResultType(Long.class)
	public Long queryCount();
	
	//分页查询
	@Select("select * from t_classs where flag=1 limit #{rowindex},#{count}")
	@ResultType(Classs.class)
	public List<Classs> queryByPage(@Param("rowindex")int index,@Param("count")int count);	
}
