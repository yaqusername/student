package com.edu.web.converter;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;

//重写ObjectMapper
//@Component //等价�?<bean>
public class DateMapper extends ObjectMapper {

	public DateMapper() {
		setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
	}
}
