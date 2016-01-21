package com.lawyer.pojo;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */

public class Log implements java.io.Serializable {

	// Fields

	private Integer logId;
	private String logDate;
	private Integer logUid;
	private String logUname;
	private String logUrole;
	private String logContent;
	private String logTarget;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(String logDate, Integer logUid, String logUname,
			String logUrole, String logContent, String logTarget) {
		this.logDate = logDate;
		this.logUid = logUid;
		this.logUname = logUname;
		this.logUrole = logUrole;
		this.logContent = logContent;
		this.logTarget = logTarget;
	}

	// Property accessors

	public Integer getLogId() {
		return this.logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getLogDate() {
		return this.logDate;
	}

	public void setLogDate(String logDate) {
		this.logDate = logDate;
	}

	public Integer getLogUid() {
		return this.logUid;
	}

	public void setLogUid(Integer logUid) {
		this.logUid = logUid;
	}

	public String getLogUname() {
		return this.logUname;
	}

	public void setLogUname(String logUname) {
		this.logUname = logUname;
	}

	public String getLogUrole() {
		return this.logUrole;
	}

	public void setLogUrole(String logUrole) {
		this.logUrole = logUrole;
	}

	public String getLogContent() {
		return this.logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent;
	}

	public String getLogTarget() {
		return this.logTarget;
	}

	public void setLogTarget(String logTarget) {
		this.logTarget = logTarget;
	}

}