package com.edu.mapper;

import com.edu.domain.Student;
import java.util.List;

public interface StudentMapper {
    int insert(Student record);

    List<Student> selectAll();
}