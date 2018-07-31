package com.edu.dao;

import com.edu.domain.Work;
import java.util.List;

public interface WorkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Work record);

    Work selectByPrimaryKey(Integer id);

    List<Work> selectAll();

    int updateByPrimaryKey(Work record);
}