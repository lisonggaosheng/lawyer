package com.lawyer.pojo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ClearClear implements Serializable{

	private Integer ccid;
	private String ccnumber;
	private String cclawname;
	private String cclawnametel;
	private String ccjudge;
	private String ccjudgetel;
	private String ccfollowupresult;
	private String ccattach;
	private String ccremark;
	private Users users;
	private String cccasecodeself;
	private String ccTime;
	private String ccsaveTime;
	private String assistingName;
	private String assistingTel;
	private String competentCourt;
	
	public ClearClear() {
		super();
		
	}

	public Integer getCcid() {
		return ccid;
	}

	public void setCcid(Integer ccid) {
		this.ccid = ccid;
	}

	public String getCcnumber() {
		return ccnumber;
	}

	public void setCcnumber(String ccnumber) {
		this.ccnumber = ccnumber;
	}

	public String getCclawname() {
		return cclawname;
	}

	public void setCclawname(String cclawname) {
		this.cclawname = cclawname;
	}

	public String getCclawnametel() {
		return cclawnametel;
	}

	public void setCclawnametel(String cclawnametel) {
		this.cclawnametel = cclawnametel;
	}

	public String getCcjudge() {
		return ccjudge;
	}

	public void setCcjudge(String ccjudge) {
		this.ccjudge = ccjudge;
	}

	public String getCcjudgetel() {
		return ccjudgetel;
	}

	public void setCcjudgetel(String ccjudgetel) {
		this.ccjudgetel = ccjudgetel;
	}

	public String getCcattach() {
		return ccattach;
	}

	public void setCcattach(String ccattach) {
		this.ccattach = ccattach;
	}

	public String getCcremark() {
		return ccremark;
	}

	public void setCcremark(String ccremark) {
		this.ccremark = ccremark;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}


	public String getCcfollowupresult() {
		return ccfollowupresult;
	}

	public void setCcfollowupresult(String ccfollowupresult) {
		this.ccfollowupresult = ccfollowupresult;
	}

	public String getCccasecodeself() {
		return cccasecodeself;
	}

	public void setCccasecodeself(String cccasecodeself) {
		this.cccasecodeself = cccasecodeself;
	}

	public String getCcTime() {
		return ccTime;
	}

	public void setCcTime(String ccTime) {
		this.ccTime = ccTime;
	}

	public String getCcsaveTime() {
		return ccsaveTime;
	}

	public void setCcsaveTime(String ccsaveTime) {
		this.ccsaveTime = ccsaveTime;
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

	public ClearClear(Integer ccid, String ccnumber, String cclawname,
			String cclawnametel, String ccjudge, String ccjudgetel,
			String ccfollowupresult, String ccattach, String ccremark,
			Users users, String cccasecodeself,String ccTime,String ccsaveTime) {
		super();
		this.ccid = ccid;
		this.ccnumber = ccnumber;
		this.cclawname = cclawname;
		this.cclawnametel = cclawnametel;
		this.ccjudge = ccjudge;
		this.ccjudgetel = ccjudgetel;
		this.ccfollowupresult = ccfollowupresult;
		this.ccattach = ccattach;
		this.ccremark = ccremark;
		this.users = users;
		this.cccasecodeself = cccasecodeself;
		this.ccTime = ccTime;
		this.ccsaveTime = ccsaveTime;
	}
}
