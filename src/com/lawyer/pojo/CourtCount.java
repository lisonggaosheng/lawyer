package com.lawyer.pojo;

import java.io.Serializable;
import java.util.List;

public class CourtCount implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Users> ltuser1;
	private List<Users> ltuser2;
	private List<Users> ltuser3;
	private List<Users> ltuser4;
	@SuppressWarnings("rawtypes")
	private List lunum;
	private String bili;
	
	
	public List<Users> getLtuser1() {
		return ltuser1;
	}
	public void setLtuser1(List<Users> ltuser1) {
		this.ltuser1 = ltuser1;
	}
	public List<Users> getLtuser2() {
		return ltuser2;
	}
	public void setLtuser2(List<Users> ltuser2) {
		this.ltuser2 = ltuser2;
	}
	public List<Users> getLtuser3() {
		return ltuser3;
	}
	public void setLtuser3(List<Users> ltuser3) {
		this.ltuser3 = ltuser3;
	}
	public List<Users> getLtuser4() {
		return ltuser4;
	}
	public void setLtuser4(List<Users> ltuser4) {
		this.ltuser4 = ltuser4;
	}
	@SuppressWarnings("rawtypes")
	public List getLunum() {
		return lunum;
	}
	@SuppressWarnings("rawtypes")
	public void setLunum(List lunum) {
		this.lunum = lunum;
	}
	public String getBili() {
		return bili;
	}
	public void setBili(String bili) {
		this.bili = bili;
	}
	
	
}
