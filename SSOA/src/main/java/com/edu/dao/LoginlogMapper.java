package com.edu.dao;

import com.edu.domain.Loginlog;
import java.util.List;

public interface LoginlogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Loginlog record);

    Loginlog selectByPrimaryKey(Long id);

    List<Loginlog> selectAll();

    int updateByPrimaryKey(Loginlog record);
}