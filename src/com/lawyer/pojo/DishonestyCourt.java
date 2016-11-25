package com.lawyer.pojo;

import java.io.Serializable;

public class DishonestyCourt implements Serializable {
	
	private Integer id;
	private String caseId;
	private String iname;			//被执行人姓名/名称
	private String cardNum;			//身份证号码/组织机构代码
	private String courtName;		//执行法院
	private String gistId;			//执行依据文号（法律文书号）
	private String regDate;			//立案时间
	private String caseCode;		//案号
	private String performance;		//被执行人的履行情况（案件状态）
	private String publishDate;		//发布时间（公告时间）
	private String  duty;			//生效法律文书确定的义务（备注）
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCourtName() {
		return courtName;
	}
	public void setCourtName(String courtName) {
		this.courtName = courtName;
	}
	public String getGistId() {
		return gistId;
	}
	public void setGistId(String gistId) {
		this.gistId = gistId;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getCaseCode() {
		return caseCode;
	}
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	
	
}