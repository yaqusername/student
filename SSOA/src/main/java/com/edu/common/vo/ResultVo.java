package com.edu.common.vo;

public class ResultVo {
	private int code;//³É¹¦1000£¬Ê§°Ü2000
	private String msg;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ResultVo(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public ResultVo() {
		super();
	}
	public static ResultVo OK(String msg) {
		return new ResultVo(1000,msg);
	}
	
	public static ResultVo ERROR(String msg) {
		return new ResultVo(2000,msg);
	}
	
}
