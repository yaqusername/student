package com.edu.service;

import com.edu.domain.Student;

import java.util.List;

/**
 * @Author Create By 407139407
 * @Date 2018/8/11 0011
 * @Time 9:47
 */
public interface StudentService {
    //增
    boolean save(Student student);
    //删
    boolean delete(int id);
    //改
    boolean update(Student student);
    //查
    List<Student> queryAll();
}
