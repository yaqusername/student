package com.edu.mapper;

import com.edu.domain.Student;

import java.util.List;

/**
 * @Author Create By 407139407
 * @Date 2018/8/11 0011
 * @Time 9:36
 */
public interface StudentMapper {

    //增
    int insert(Student student);
    //删
    int delete(int id);
    //改
    int update(Student student);
    //查All
    List<Student> select();

}
