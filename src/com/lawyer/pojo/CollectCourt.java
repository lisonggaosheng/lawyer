package com.lawyer.pojo;

@SuppressWarnings("serial")
public class CollectCourt implements java.io.Serializable {
	private Integer id;
	private String caseId;
	private String pname;
	private String partyCardNum;
	private String execCourtName;
	private String courtcode;
	private String casecodeself;
	private String caseCreateTime;
	private String caseCode;
	private String execMoney;
	private String caseState;
	private String  savetime;
	private Integer beijingCourtState;
	public CollectCourt() {
		super();
	}
	public CollectCourt(Integer id, String caseId, String pname,
			String partyCardNum, String execCourtName, String courtcode,
			String casecodeself, String caseCreateTime, String caseCode,
			String execMoney, String caseState, String savetime,
			Integer beijingCourtState) {
		super();
		this.id = id;
		this.caseId = caseId;
		this.pname = pname;
		this.partyCardNum = partyCardNum;
		this.execCourtName = execCourtName;
		this.courtcode = courtcode;
		this.casecodeself = casecodeself;
		this.caseCreateTime = caseCreateTime;
		this.caseCode = caseCode;
		this.execMoney = execMoney;
		this.caseState = caseState;
		this.savetime = savetime;
		this.beijingCourtState = beijingCourtState;
	}
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
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPartyCardNum() {
		return partyCardNum;
	}
	public void setPartyCardNum(String partyCardNum) {
		this.partyCardNum = partyCardNum;
	}
	public String getExecCourtName() {
		return execCourtName;
	}
	public void setExecCourtName(String execCourtName) {
		this.execCourtName = execCourtName;
	}
	public String getCourtcode() {
		return courtcode;
	}
	public void setCourtcode(String courtcode) {
		this.courtcode = courtcode;
	}
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}
	public String getCaseCreateTime() {
		return caseCreateTime;
	}
	public void setCaseCreateTime(String caseCreateTime) {
		this.caseCreateTime = caseCreateTime;
	}
	public String getCaseCode() {
		return caseCode;
	}
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}
	public String getExecMoney() {
		return execMoney;
	}
	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}
	public String getCaseState() {
		return caseState;
	}
	public void setCaseState(String caseState) {
		this.caseState = caseState;
	}
	public String getSavetime() {
		return savetime;
	}
	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	public Integer getBeijingCourtState() {
		return beijingCourtState;
	}
	public void setBeijingCourtState(Integer beijingCourtState) {
		this.beijingCourtState = beijingCourtState;
	}
	
}