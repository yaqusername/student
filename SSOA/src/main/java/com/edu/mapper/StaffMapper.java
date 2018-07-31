package com.edu.mapper;

import com.edu.domain.Staff;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StaffMapper {

	@Update("update t_staff set flag=2 where no=#{no}")
	int deleteById(String no);

	@Insert("insert into t_staff (no, name, did,  flag, sex, email, qq,  phone, createdate, photo ) values "
			+ "(#{no}, #{name}, #{did}, 1, #{sex}, #{email}, #{qq}, #{phone}, #{createdate}, #{photo} )")
	int insert(Staff staff);

	@Update(" update t_staff set name = #{name}, did = #{did}, email = #{email},qq = #{qq}, phone = #{phone}, photo = #{photo}  where no = #{no}")
	int updateById(Staff staff);

	@Select("select no, name, did, flag, sex, email, qq, phone, createdate, photo from t_staff where flag=1 limit #{rowindex},#{count}")
	@ResultType(Staff.class)
	List<Staff> queryByPage(@Param("rowindex") int index, @Param("count") int count);

	@Select("select count(*) from t_staff where flag=1")
	@ResultType(Long.class)
	Long queryCount();

	@Select("select no, name from t_staff where flag=1")
	@ResultType(Staff.class)
	List<Staff> queryAll();

	@Select("select no from t_staff order by no desc limit 1")
	@ResultType(String.class)
	String queryMaxNo();

}