package com.edu.dao;

import com.edu.domain.County;
import java.util.List;

public interface CountyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(County record);

    County selectByPrimaryKey(Integer id);

    List<County> selectAll();

    int updateByPrimaryKey(County record);
}