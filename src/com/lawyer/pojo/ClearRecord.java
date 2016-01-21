package com.lawyer.pojo;

import java.io.Serializable;

public class ClearRecord implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer crid;
	private String crdate;
	private String crfollowupresult;//案件进展
	private String crnumber;
	private String crcontactjudge;
	private String crcontacttel;
	private String crlawname;
	private String crlawtel;
	private String crremark;
	private String crattach;
	private Users users;
	private String crcasecodeself;
	private String crSaveTime;
	private Integer uid;
	
	private String assistingName;
	private String assistingTel;
	private String competentCourt;
	
	private String clearrecordMinTime;
	private String clearrecordMaxTime;
	
	public String getClearrecordMinTime() {
		return clearrecordMinTime;
	}
	public void setClearrecordMinTime(String clearrecordMinTime) {
		this.clearrecordMinTime = clearrecordMinTime;
	}
	public String getClearrecordMaxTime() {
		return clearrecordMaxTime;
	}
	public void setClearrecordMaxTime(String clearrecordMaxTime) {
		this.clearrecordMaxTime = clearrecordMaxTime;
	}
	public Integer getCrid() {
		return crid;
	}
	public void setCrid(Integer crid) {
		this.crid = crid;
	}
	public String getCrdate() {
		return crdate;
	}
	public void setCrdate(String crdate) {
		this.crdate = crdate;
	}
	public String getCrfollowupresult() {
		return crfollowupresult;
	}
	public void setCrfollowupresult(String crfollowupresult) {
		this.crfollowupresult = crfollowupresult;
	}
	public String getCrnumber() {
		return crnumber;
	}
	public void setCrnumber(String crnumber) {
		this.crnumber = crnumber;
	}
	public String getCrcontactjudge() {
		return crcontactjudge;
	}
	public void setCrcontactjudge(String crcontactjudge) {
		this.crcontactjudge = crcontactjudge;
	}
	public String getCrcontacttel() {
		return crcontacttel;
	}
	public void setCrcontacttel(String crcontacttel) {
		this.crcontacttel = crcontacttel;
	}
	public String getCrlawname() {
		return crlawname;
	}
	public void setCrlawname(String crlawname) {
		this.crlawname = crlawname;
	}
	public String getCrlawtel() {
		return crlawtel;
	}
	public void setCrlawtel(String crlawtel) {
		this.crlawtel = crlawtel;
	}
	public String getCrremark() {
		return crremark;
	}
	public void setCrremark(String crremark) {
		this.crremark = crremark;
	}
	public String getCrattach() {
		return crattach;
	}
	public void setCrattach(String crattach) {
		this.crattach = crattach;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getCrcasecodeself() {
		return crcasecodeself;
	}
	public void setCrcasecodeself(String crcasecodeself) {
		this.crcasecodeself = crcasecodeself;
	}
	
	public String getCrSaveTime() {
		return crSaveTime;
	}
	public void setCrSaveTime(String crSaveTime) {
		this.crSaveTime = crSaveTime;
	}
	public ClearRecord(String crdate, String crfollowupresult, String crnumber,
			String crcontactjudge, String crcontacttel, String crlawname,
			String crlawtel, String crremark, String crattach, Users users,
			String crcasecodeself,String crSaveTime) {
		super();
		this.crdate = crdate;
		this.crfollowupresult = crfollowupresult;
		this.crnumber = crnumber;
		this.crcontactjudge = crcontactjudge;
		this.crcontacttel = crcontacttel;
		this.crlawname = crlawname;
		this.crlawtel = crlawtel;
		this.crremark = crremark;
		this.crattach = crattach;
		this.users = users;
		this.crcasecodeself = crcasecodeself;
		this.crSaveTime = crSaveTime;
	}
	public ClearRecord() {
		super();
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getAssistingName() {
		return assistingName;
	}
	public void setAssistingName(String assistingName) {
		this.assistingName = assistingName;
	}
	public String getAssistingTel() {
		return assistingTel;
	}
	public void setAssistingTel(String assistingTel) {
		this.assistingTel = assistingTel;
	}
	public String getCompetentCourt() {
		return competentCourt;
	}
	public void setCompetentCourt(String competentCourt) {
		this.competentCourt = competentCourt;
	}
	
	
	
}
