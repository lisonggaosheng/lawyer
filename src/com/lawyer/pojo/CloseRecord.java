package com.lawyer.pojo;

import java.io.Serializable;

public class CloseRecord implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer crid;
	private String crtime;
	private String crperson;
	private String crpersontel;
	private String crcasecodeself;
	private String crremark;
	private String crattach;
	private Users users;
	private String crsavetime;
	
	private String closerecordMinTime;
	private String closerecordMaxTime;
	
	public CloseRecord() {
		super();
	}
	public CloseRecord(String crtime, String crperson, String crpersontel,
			String crcasecodeself, String crremark, String crattach,
			Users users, String crsavetime) {
		super();
		this.crtime = crtime;
		this.crperson = crperson;
		this.crpersontel = crpersontel;
		this.crcasecodeself = crcasecodeself;
		this.crremark = crremark;
		this.crattach = crattach;
		this.users = users;
		this.crsavetime = crsavetime;
	}
	public String getCrsavetime() {
		return crsavetime;
	}
	public void setCrsavetime(String crsavetime) {
		this.crsavetime = crsavetime;
	}
	public Integer getCrid() {
		return crid;
	}
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	public String getCrtime() {
		return crtime;
	}
	public void setCrtime(String crtime) {
		this.crtime = crtime;
	}
	public String getCrperson() {
		return crperson;
	}
	public void setCrperson(String crperson) {
		this.crperson = crperson;
	}
	public String getCrpersontel() {
		return crpersontel;
	}
	public void setCrpersontel(String crpersontel) {
		this.crpersontel = crpersontel;
	}
	public String getCrcasecodeself() {
		return crcasecodeself;
	}
	public void setCrcasecodeself(String crcasecodeself) {
		this.crcasecodeself = crcasecodeself;
	}
	public String getCrremark() {
		return crremark;
	}
	public void setCrremark(String crremark) {
		this.crremark = crremark;
	}
	public String getCrattach() {
		return crattach;
	}
	public void setCrattach(String crattach) {
		this.crattach = crattach;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getCloserecordMinTime() {
		return closerecordMinTime;
	}
	public void setCloserecordMinTime(String closerecordMinTime) {
		this.closerecordMinTime = closerecordMinTime;
	}
	public String getCloserecordMaxTime() {
		return closerecordMaxTime;
	}
	public void setCloserecordMaxTime(String closerecordMaxTime) {
		this.closerecordMaxTime = closerecordMaxTime;
	}
	
}
