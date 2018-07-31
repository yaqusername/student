package com.edu.domain;

import java.sql.Date;

public class Classs {
	private String courseid;
	private String no;
	private String name;
	private Date createtime;
	private int flag;
	private int week;
	private String location;
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Classs() {
		super();
	}
	public Classs(String courseid, String no, String name, Date createtime, int flag, int week, String location) {
		super();
		this.courseid = courseid;
		this.no = no;
		this.name = name;
		this.createtime = createtime;
		this.flag = flag;
		this.week = week;
		this.location = location;
	}
	
}