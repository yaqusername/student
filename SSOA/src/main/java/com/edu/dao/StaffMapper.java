package com.edu.dao;

import com.edu.domain.Staff;
import java.util.List;

public interface StaffMapper {
    int insert(Staff record);

    List<Staff> selectAll();
}