package com.edu.domain;

import java.util.Date;

public class Depart {
	private int id;
	private String name;
	private Date createtime;
	private int flag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatetume() {
		return createtime;
	}
	public void setCreatetume(Date createtime) {
		this.createtime = createtime;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Depart(int id, String name, Date createtume, int flag) {
		super();
		this.id = id;
		this.name = name;
		this.createtime = createtime;
		this.flag = flag;
	}
	public Depart() {
		super();
	}
	
}
