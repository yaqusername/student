package com.edu.mapper;

import com.edu.domain.Msg;
import java.util.List;

public interface MsgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Msg record);

    Msg selectByPrimaryKey(Long id);

    List<Msg> selectAll();

    int updateByPrimaryKey(Msg record);
}