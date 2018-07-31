package com.edu.mapper;

import com.edu.domain.Course;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface CourseMapper {
	
		@Update("update t_course set flag=2 where id = #{id}")
	    int deleteById(Integer id);
	
		@Insert("insert into t_course ( name, flag, week, createdate, type )values ( #{name}, 1,#{week}, #{createdate}, #{type})")
	    int insert(Course course);

	   
	    @Update("update t_course set name = #{name},week = #{week} where id = #{id}")
	    int updateById(Course course);
	    
	    @Select("select id, name from t_course where flag=1")
	    @ResultType(Course.class)
	    List<Course> queryAll();
	
		@Select("select c.id, c.name, c.flag, c.week, c.createdate, c.type,g.gcount from t_course c left join (select count(*)gcount,cid from t_grade group by cid) g on c.id=g.cid where c.flag=1 limit #{rowindex},#{count}")
		@ResultType(Course.class)
		List<Course> queryByPage(@Param("rowindex")int index,@Param("count")int count);
		
		@Select("select count(*) from t_course where flag=1")
		@ResultType(Long.class)
		Long queryCount();
}