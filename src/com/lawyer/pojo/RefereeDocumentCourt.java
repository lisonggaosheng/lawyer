package com.lawyer.pojo;

import java.io.Serializable;

public class RefereeDocumentCourt implements Serializable {
	
	private Integer id;
	private String caseId;
	private String person_execution;			//被执行人姓名/名称
	private String person_execution_addr;			//被执行人地址
	private String courtname;		//执行法院
	private String publishDate;			//立案时间
	private String caseCode;		//案号
	private String case_content;			//裁定如下内容（备注）
	private String applicant;	//申请人
	private String applicant_addr;	//申请人地址
	
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
	public String getPerson_execution() {
		return person_execution;
	}
	public void setPerson_execution(String person_execution) {
		this.person_execution = person_execution;
	}
	public String getPerson_execution_addr() {
		return person_execution_addr;
	}
	public void setPerson_execution_addr(String person_execution_addr) {
		this.person_execution_addr = person_execution_addr;
	}
	public String getCourtname() {
		return courtname;
	}
	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getCaseCode() {
		return caseCode;
	}
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}
	public String getCase_content() {
		return case_content;
	}
	public void setCase_content(String case_content) {
		this.case_content = case_content;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	public String getApplicant_addr() {
		return applicant_addr;
	}
	public void setApplicant_addr(String applicant_addr) {
		this.applicant_addr = applicant_addr;
	}
	
	
}