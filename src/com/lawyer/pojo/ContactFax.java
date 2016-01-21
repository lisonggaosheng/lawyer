package com.lawyer.pojo;

/**
 * ContactFax entity. @author MyEclipse Persistence Tools
 */

public class ContactFax implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer cfId;
	private String cfName;
	private String cfTime;
	private String cfResult;
	private String cfReceive;
	private String cfRemark;
	private String cfAttach;
	private Users users;
	private String cfCasecodeself;
	private String cfSavetime;

	// Constructors

	/** default constructor */
	public ContactFax() {
	}


	public ContactFax(String cfName, String cfTime, String cfResult,
			String cfReceive, String cfRemark, String cfAttach, Users users,
			String cfCasecodeself, String cfSavetime) {
		super();
		this.cfName = cfName;
		this.cfTime = cfTime;
		this.cfResult = cfResult;
		this.cfReceive = cfReceive;
		this.cfRemark = cfRemark;
		this.cfAttach = cfAttach;
		this.users = users;
		this.cfCasecodeself = cfCasecodeself;
		this.cfSavetime = cfSavetime;
	}


	public Integer getCfId() {
		return cfId;
	}

	public void setCfId(Integer cfId) {
		this.cfId = cfId;
	}

	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	public String getCfTime() {
		return cfTime;
	}

	public void setCfTime(String cfTime) {
		this.cfTime = cfTime;
	}

	public String getCfResult() {
		return cfResult;
	}

	public void setCfResult(String cfResult) {
		this.cfResult = cfResult;
	}

	public String getCfReceive() {
		return cfReceive;
	}

	public void setCfReceive(String cfReceive) {
		this.cfReceive = cfReceive;
	}

	public String getCfRemark() {
		return cfRemark;
	}

	public void setCfRemark(String cfRemark) {
		this.cfRemark = cfRemark;
	}

	public String getCfAttach() {
		return cfAttach;
	}

	public void setCfAttach(String cfAttach) {
		this.cfAttach = cfAttach;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCfCasecodeself() {
		return cfCasecodeself;
	}

	public void setCfCasecodeself(String cfCasecodeself) {
		this.cfCasecodeself = cfCasecodeself;
	}


	public String getCfSavetime() {
		return cfSavetime;
	}

	public void setCfSavetime(String cfSavetime) {
		this.cfSavetime = cfSavetime;
	}

}