package com.lawyer.pojo;

/**
 * Apply entity. @author MyEclipse Persistence Tools
 */

public class Apply implements java.io.Serializable {

	// Fields

	private Integer appId;
	private Users users;
	private String appSta;
	private String appDate;
	private String appTarget;
	private String appContent;

	// Constructors

	/** default constructor */
	public Apply() {
	}

	/** full constructor */
	public Apply(Users users, String appSta, String appDate, String appTarget,
			String appContent) {
		this.users = users;
		this.appSta = appSta;
		this.appDate = appDate;
		this.appTarget = appTarget;
		this.appContent = appContent;
	}

	// Property accessors

	public Integer getAppId() {
		return this.appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAppSta() {
		return this.appSta;
	}

	public void setAppSta(String appSta) {
		this.appSta = appSta;
	}

	public String getAppDate() {
		return this.appDate;
	}

	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}

	public String getAppTarget() {
		return this.appTarget;
	}

	public void setAppTarget(String appTarget) {
		this.appTarget = appTarget;
	}

	public String getAppContent() {
		return this.appContent;
	}

	public void setAppContent(String appContent) {
		this.appContent = appContent;
	}

}