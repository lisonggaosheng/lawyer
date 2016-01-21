package com.lawyer.pojo;

/**
 * ContactFax entity. @author MyEclipse Persistence Tools
 */

public class SysTask implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String lawyername;
	private String lawyermobile;
	private String content;
	private String remindTime;
	private Integer status;
	private Integer times;
	private String saveTime;

	// Constructors

	/** default constructor */
	public SysTask() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLawyername() {
		return lawyername;
	}

	public void setLawyername(String lawyername) {
		this.lawyername = lawyername;
	}

	public String getLawyermobile() {
		return lawyermobile;
	}

	public void setLawyermobile(String lawyermobile) {
		this.lawyermobile = lawyermobile;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTimes() {
		return times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public String getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(String saveTime) {
		this.saveTime = saveTime;
	}


}