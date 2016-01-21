package com.lawyer.pojo;

import java.io.Serializable;

public class Litigation implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer liid;
	private String linumber;
	private String lidate;
	private Float lifund;
	private String lilawname;
	private String lilawtel;
	private String lijudge;
	private String lijudgetel;
	private Users users;
	private String licasecodeself;
	private String lifollowupresult;
	private String liremark;
	private String liattach;
	private String lisaveTime;
	private String assistingName;
	private String assistingTel;
	private String competentCourt;
	
	private String litigationMinTime;
	private String litigationMaxTime;
	private String litigationMinMoney;
	private String litigationMaxMoney;
	
	
	public Litigation() {
		super();
	}

	public Integer getLiid() {
		return liid;
	}


	public void setLiid(Integer liid) {
		this.liid = liid;
	}



	public String getLinumber() {
		return linumber;
	}


	public void setLinumber(String linumber) {
		this.linumber = linumber;
	}


	public String getLidate() {
		return lidate;
	}


	public void setLidate(String lidate) {
		this.lidate = lidate;
	}


	public Float getLifund() {
		return lifund;
	}


	public void setLifund(Float lifund) {
		this.lifund = lifund;
	}


	public String getLilawname() {
		return lilawname;
	}


	public void setLilawname(String lilawname) {
		this.lilawname = lilawname;
	}


	public String getLilawtel() {
		return lilawtel;
	}


	public void setLilawtel(String lilawtel) {
		this.lilawtel = lilawtel;
	}


	public String getLijudge() {
		return lijudge;
	}


	public void setLijudge(String lijudge) {
		this.lijudge = lijudge;
	}


	public String getLijudgetel() {
		return lijudgetel;
	}


	public void setLijudgetel(String lijudgetel) {
		this.lijudgetel = lijudgetel;
	}


	public Users getUsers() {
		return users;
	}


	public void setUsers(Users users) {
		this.users = users;
	}


	public String getLicasecodeself() {
		return licasecodeself;
	}


	public void setLicasecodeself(String licasecodeself) {
		this.licasecodeself = licasecodeself;
	}


	public String getLifollowupresult() {
		return lifollowupresult;
	}


	public void setLifollowupresult(String lifollowupresult) {
		this.lifollowupresult = lifollowupresult;
	}


	public String getLiremark() {
		return liremark;
	}


	public void setLiremark(String liremark) {
		this.liremark = liremark;
	}


	public String getLiattach() {
		return liattach;
	}


	public void setLiattach(String liattach) {
		this.liattach = liattach;
	}


	public String getLisaveTime() {
		return lisaveTime;
	}

	public void setLisaveTime(String lisaveTime) {
		this.lisaveTime = lisaveTime;
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

	public String getLitigationMinTime() {
		return litigationMinTime;
	}

	public void setLitigationMinTime(String litigationMinTime) {
		this.litigationMinTime = litigationMinTime;
	}

	public String getLitigationMaxTime() {
		return litigationMaxTime;
	}

	public void setLitigationMaxTime(String litigationMaxTime) {
		this.litigationMaxTime = litigationMaxTime;
	}

	public String getLitigationMinMoney() {
		return litigationMinMoney;
	}

	public void setLitigationMinMoney(String litigationMinMoney) {
		this.litigationMinMoney = litigationMinMoney;
	}

	public String getLitigationMaxMoney() {
		return litigationMaxMoney;
	}

	public void setLitigationMaxMoney(String litigationMaxMoney) {
		this.litigationMaxMoney = litigationMaxMoney;
	}

	public Litigation(Integer liid, String linumber, String lidate,
			Float lifund, String lilawname, String lilawtel, String lijudge,
			String lijudgetel, Users users, String licasecodeself,
			String lifollowupresult, String liremark, String liattach,String lisaveTime) {
		super();
		this.liid = liid;
		this.linumber = linumber;
		this.lidate = lidate;
		this.lifund = lifund;
		this.lilawname = lilawname;
		this.lilawtel = lilawtel;
		this.lijudge = lijudge;
		this.lijudgetel = lijudgetel;
		this.users = users;
		this.licasecodeself = licasecodeself;
		this.lifollowupresult = lifollowupresult;
		this.liremark = liremark;
		this.liattach = liattach;
		this.lisaveTime = lisaveTime;
	}
}
