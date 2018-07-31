package com.edu.mapper;

import com.edu.domain.Schedule;
import java.util.List;

public interface ScheduleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Schedule record);

    Schedule selectByPrimaryKey(Integer id);

    List<Schedule> selectAll();

    int updateByPrimaryKey(Schedule record);
}