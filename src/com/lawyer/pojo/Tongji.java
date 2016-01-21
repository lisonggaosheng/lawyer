package com.lawyer.pojo;

public class Tongji {
	private Users user;
	private long num;
	private String bili;
	private String info;
	public Tongji() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tongji(Users user, long num, String bili, String info) {
		super();
		this.user = user;
		this.num = num;
		this.bili = bili;
		this.info = info;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public String getBili() {
		return bili;
	}
	public void setBili(String bili) {
		this.bili = bili;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
