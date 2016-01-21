package com.lawyer.pojo;

import java.io.Serializable;

public class Execute implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer exid;
	private String exnumber;
	private String exdate;
	private String exlawname;
	private String exlawtel;
	private String exjudge;
	private String exjudgetel;
	private Users users;
	private String excasecodeself;
	private String exfollowupresult;
	private String exremark;
	private String exattach;
	private String exsavetime;
	private String assistingName;
	private String assistingTel;
	private String competentCourt;
	private String execMoney;
	
	
	private String executeMinTime;
	private String executeMaxTime;
	private String executeMinMoney;
	private String executeMaxMoney;
	
	
	
	public Execute(String exnumber, String exdate, String exlawname,
			String exlawtel, String exjudge, String exjudgetel, Users users,
			String excasecodeself, String exfollowupresult, String exremark,
			String exattach, String exsavetime) {
		super();
		this.exnumber = exnumber;
		this.exdate = exdate;
		this.exlawname = exlawname;
		this.exlawtel = exlawtel;
		this.exjudge = exjudge;
		this.exjudgetel = exjudgetel;
		this.users = users;
		this.excasecodeself = excasecodeself;
		this.exfollowupresult = exfollowupresult;
		this.exremark = exremark;
		this.exattach = exattach;
		this.exsavetime = exsavetime;
	}

	public String getExsavetime() {
		return exsavetime;
	}

	public void setExsavetime(String exsavetime) {
		this.exsavetime = exsavetime;
	}

	public Execute() {
		super();
	}

	public Integer getExid() {
		return exid;
	}

	public void setExid(Integer exid) {
		this.exid = exid;
	}

	public String getExnumber() {
		return exnumber;
	}

	public void setExnumber(String exnumber) {
		this.exnumber = exnumber;
	}

	public String getExdate() {
		return exdate;
	}

	public void setExdate(String exdate) {
		this.exdate = exdate;
	}

	public String getExlawname() {
		return exlawname;
	}

	public void setExlawname(String exlawname) {
		this.exlawname = exlawname;
	}

	public String getExlawtel() {
		return exlawtel;
	}

	public void setExlawtel(String exlawtel) {
		this.exlawtel = exlawtel;
	}

	public String getExjudge() {
		return exjudge;
	}

	public void setExjudge(String exjudge) {
		this.exjudge = exjudge;
	}

	public String getExjudgetel() {
		return exjudgetel;
	}

	public void setExjudgetel(String exjudgetel) {
		this.exjudgetel = exjudgetel;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getExcasecodeself() {
		return excasecodeself;
	}

	public void setExcasecodeself(String excasecodeself) {
		this.excasecodeself = excasecodeself;
	}

	public String getExfollowupresult() {
		return exfollowupresult;
	}

	public void setExfollowupresult(String exfollowupresult) {
		this.exfollowupresult = exfollowupresult;
	}

	public String getExremark() {
		return exremark;
	}

	public void setExremark(String exremark) {
		this.exremark = exremark;
	}

	public String getExattach() {
		return exattach;
	}

	public void setExattach(String exattach) {
		this.exattach = exattach;
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

	public String getExecMoney() {
		return execMoney;
	}

	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}

	public String getExecuteMinTime() {
		return executeMinTime;
	}

	public void setExecuteMinTime(String executeMinTime) {
		this.executeMinTime = executeMinTime;
	}

	public String getExecuteMaxTime() {
		return executeMaxTime;
	}

	public void setExecuteMaxTime(String executeMaxTime) {
		this.executeMaxTime = executeMaxTime;
	}

	public String getExecuteMinMoney() {
		return executeMinMoney;
	}

	public void setExecuteMinMoney(String executeMinMoney) {
		this.executeMinMoney = executeMinMoney;
	}

	public String getExecuteMaxMoney() {
		return executeMaxMoney;
	}

	public void setExecuteMaxMoney(String executeMaxMoney) {
		this.executeMaxMoney = executeMaxMoney;
	}
	
}
