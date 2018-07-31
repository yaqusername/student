package com.edu.mapper;

import com.edu.domain.Log;
import java.util.List;

public interface LogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    Log selectByPrimaryKey(Long id);

    List<Log> selectAll();

    int updateByPrimaryKey(Log record);
}