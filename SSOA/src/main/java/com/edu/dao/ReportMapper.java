package com.edu.dao;

import com.edu.domain.Report;
import java.util.List;

public interface ReportMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Report record);

    Report selectByPrimaryKey(Long id);

    List<Report> selectAll();

    int updateByPrimaryKey(Report record);
}