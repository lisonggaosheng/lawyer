package com.lawyer.pojo;

/**
 * AddrecordCopy entity. @author MyEclipse Persistence Tools
 */

public class Addrecord implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer reId;
	private Users users;
	private String reSchedule;
	private String addRecordTime;

	// Constructors

	/** default constructor */
	public Addrecord() {
	}

	public Addrecord(Users users, String reSchedule, String addRecordTime) {
		super();
		this.users = users;
		this.reSchedule = reSchedule;
		this.addRecordTime = addRecordTime;
	}

	public Integer getReId() {
		return reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getReSchedule() {
		return reSchedule;
	}

	public void setReSchedule(String reSchedule) {
		this.reSchedule = reSchedule;
	}

	public String getAddRecordTime() {
		return addRecordTime;
	}

	public void setAddRecordTime(String addRecordTime) {
		this.addRecordTime = addRecordTime;
	}

}