package com.lawyer.pojo;

/**
 * ContactSee entity. @author MyEclipse Persistence Tools
 */

public class ContactSee implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer csId;
	private String csName;
	private String csOthername;
	private String csResult;
	private String csDate;
	private String csRemark;
	private String csAttach;
	private Users users;
	private String csCasecodeself;
	private String csSavetime;

	public String getCsSavetime() {
		return csSavetime;
	}

	public void setCsSavetime(String csSavetime) {
		this.csSavetime = csSavetime;
	}

	/** default constructor */
	public ContactSee() {
	}


	public ContactSee(String csName, String csOthername, String csResult,
			String csDate, String csRemark, String csAttach, Users users,
			String csCasecodeself, String csSavetime) {
		super();
		this.csName = csName;
		this.csOthername = csOthername;
		this.csResult = csResult;
		this.csDate = csDate;
		this.csRemark = csRemark;
		this.csAttach = csAttach;
		this.users = users;
		this.csCasecodeself = csCasecodeself;
		this.csSavetime = csSavetime;
	}

	public Integer getCsId() {
		return csId;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public String getCsName() {
		return csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getCsOthername() {
		return csOthername;
	}

	public void setCsOthername(String csOthername) {
		this.csOthername = csOthername;
	}

	public String getCsResult() {
		return csResult;
	}

	public void setCsResult(String csResult) {
		this.csResult = csResult;
	}

	public String getCsDate() {
		return csDate;
	}

	public void setCsDate(String csDate) {
		this.csDate = csDate;
	}

	public String getCsRemark() {
		return csRemark;
	}

	public void setCsRemark(String csRemark) {
		this.csRemark = csRemark;
	}

	public String getCsAttach() {
		return csAttach;
	}

	public void setCsAttach(String csAttach) {
		this.csAttach = csAttach;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCsCasecodeself() {
		return csCasecodeself;
	}

	public void setCsCasecodeself(String csCasecodeself) {
		this.csCasecodeself = csCasecodeself;
	}

	
}