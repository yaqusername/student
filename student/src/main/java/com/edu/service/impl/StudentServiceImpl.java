package com.edu.service.impl;

import com.edu.domain.Student;
import com.edu.mapper.StudentMapper;
import com.edu.service.StudentService;
import org.apache.ibatis.annotations.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Create By 407139407
 * @Date 2018/8/11 0011
 * @Time 9:50
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper mapper;
    @Override
    public boolean save(Student student) {
        return mapper.insert(student)>0;
    }

    @Override
    public boolean delete(int id) {
        return mapper.delete(id)>0;
    }

    @Override
    public boolean update(Student student) {
        return mapper.update(student)>0;
    }

    @Override
    @ResultType(Student.class)
    public List<Student> queryAll() {
        return mapper.select();
    }
}
