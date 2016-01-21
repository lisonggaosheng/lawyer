package com.lawyer.pojo;

/**
 * ContactMail entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class ContactMail implements java.io.Serializable {

	private Integer cmId;
	private Users users;
	private String cmMail;
	private String cmMsender;
	private String cmDate;
	private String cmResult;
	private String cmRemark;
	private String cmAttach;
	private String cmCasecodeself;
	private String cmSavetime;
	
	public ContactMail() {
	}

	public ContactMail(Users users, String cmMail, String cmMsender,
			String cmDate, String cmResult, String cmRemark, String cmAttach,
			String cmCasecodeself, String cmSavetime) {
		super();
		this.users = users;
		this.cmMail = cmMail;
		this.cmMsender = cmMsender;
		this.cmDate = cmDate;
		this.cmResult = cmResult;
		this.cmRemark = cmRemark;
		this.cmAttach = cmAttach;
		this.cmCasecodeself = cmCasecodeself;
		this.cmSavetime = cmSavetime;
	}
	
	public Integer getCmId() {
		return this.cmId;
	}

	public void setCmId(Integer cmId) {
		this.cmId = cmId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCmMail() {
		return this.cmMail;
	}

	public void setCmMail(String cmMail) {
		this.cmMail = cmMail;
	}

	public String getCmMsender() {
		return this.cmMsender;
	}

	public void setCmMsender(String cmMsender) {
		this.cmMsender = cmMsender;
	}

	public String getCmDate() {
		return this.cmDate;
	}

	public void setCmDate(String cmDate) {
		this.cmDate = cmDate;
	}

	public String getCmResult() {
		return this.cmResult;
	}

	public void setCmResult(String cmResult) {
		this.cmResult = cmResult;
	}

	public String getCmRemark() {
		return this.cmRemark;
	}

	public void setCmRemark(String cmRemark) {
		this.cmRemark = cmRemark;
	}

	public String getCmAttach() {
		return this.cmAttach;
	}

	public void setCmAttach(String cmAttach) {
		this.cmAttach = cmAttach;
	}

	public String getCmCasecodeself() {
		return this.cmCasecodeself;
	}

	public void setCmCasecodeself(String cmCasecodeself) {
		this.cmCasecodeself = cmCasecodeself;
	}

	public String getCmSavetime() {
		return cmSavetime;
	}

	public void setCmSavetime(String cmSavetime) {
		this.cmSavetime = cmSavetime;
	}

}