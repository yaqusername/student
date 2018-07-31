package com.edu.dao;

import com.edu.domain.Papers;
import java.util.List;

public interface PapersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Papers record);

    Papers selectByPrimaryKey(Integer id);

    List<Papers> selectAll();

    int updateByPrimaryKey(Papers record);
}