package com.edu.dao;

import com.edu.domain.City;
import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    City selectByPrimaryKey(Integer id);

    List<City> selectAll();

    int updateByPrimaryKey(City record);
}