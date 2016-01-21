package com.lawyer.pojo;

/**
 * ContactSee entity. @author MyEclipse Persistence Tools
 */

public class ContactTalk implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Fields

	private Integer ctId;
	private String ctName;
	private String ctLawyerName;
	private String ctResult;
	private String ctDate;
	private String ctRemark;
	private String ctAttach;
	private Users users;
	private String ctCasecodeself;
	private String ctSavetime;
	public Integer getCtId() {
		return ctId;
	}
	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}
	public String getCtName() {
		return ctName;
	}
	public void setCtName(String ctName) {
		this.ctName = ctName;
	}
	public String getCtLawyerName() {
		return ctLawyerName;
	}
	public void setCtLawyerName(String ctLawyerName) {
		this.ctLawyerName = ctLawyerName;
	}
	public String getCtResult() {
		return ctResult;
	}
	public void setCtResult(String ctResult) {
		this.ctResult = ctResult;
	}
	public String getCtDate() {
		return ctDate;
	}
	public void setCtDate(String ctDate) {
		this.ctDate = ctDate;
	}
	public String getCtRemark() {
		return ctRemark;
	}
	public void setCtRemark(String ctRemark) {
		this.ctRemark = ctRemark;
	}
	public String getCtAttach() {
		return ctAttach;
	}
	public void setCtAttach(String ctAttach) {
		this.ctAttach = ctAttach;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getCtCasecodeself() {
		return ctCasecodeself;
	}
	public void setCtCasecodeself(String ctCasecodeself) {
		this.ctCasecodeself = ctCasecodeself;
	}
	public String getCtSavetime() {
		return ctSavetime;
	}
	public void setCtSavetime(String ctSavetime) {
		this.ctSavetime = ctSavetime;
	}

	

	
}