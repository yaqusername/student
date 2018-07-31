package com.edu.mapper;

import com.edu.domain.Contacts;
import java.util.List;

public interface ContactsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Contacts record);

    Contacts selectByPrimaryKey(Integer id);

    List<Contacts> selectAll();

    int updateByPrimaryKey(Contacts record);
}