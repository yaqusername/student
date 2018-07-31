package com.edu.domain;

public class User {
	private int id;
	private String no;
	private String password;
	private int flag;
	private int role;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public User(int id, String no, String password, int flag, int role) {
		super();
		this.id = id;
		this.no = no;
		this.password = password;
		this.flag = flag;
		this.role = role;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", no=" + no + ", password=" + password + ", flag=" + flag + ", role=" + role + "]";
	}
	
	
}
