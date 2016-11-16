package com.lawyer.pojo;

import java.util.List;

@SuppressWarnings("serial")
public class Court implements java.io.Serializable {
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
	private Integer uid;
	private String executestep;
	private String remark;
	private String creditor;  //债权人
	private String creditorAddress;  //债权人住所
	
	private String noticeCourt;
	private String noticeTime;
	private String lawDocumentNum;  //公告文书号
	private String infoType;   //案源类型   1执行    2公告   3失信
	private String excludeStatus;   //排除状态      0正常   1临时排除    2永久排除

	private Executebusiness eb;
	private Applierinfo ap;
	private ApplierinfoOnself ao;
	private  ApplierinfoNetwork an;
	private ContactMail cm;
	private ContactTel ct;
	private ContactExpress ce;
	private ContactFax cf;
	private ContactSee csee;
	private ContactTalk ctalk;
	private ContractSign csign;
	private List<ContactMail> listcm;
	private List<ContactTel> listct;
	private List<ContactExpress> listce;
	private List<ContactFax> listcf;
	private List<ContactSee> listcs;
	private List<ContactTalk> listctalk;
	
	public Court(Integer id, String caseId, String pname, String execCourtName,
			String casecodeself, String caseCreateTime, String caseCode) {
		super();
		this.id = id;
		this.caseId = caseId;
		this.pname = pname;
		this.execCourtName = execCourtName;
		this.casecodeself = casecodeself;
		this.caseCreateTime = caseCreateTime;
		this.caseCode = caseCode;
	}
	
	public Court(String caseId, String pname, String partyCardNum,
			String execCourtName, String courtcode, String casecodeself,
			String caseCreateTime, String caseCode, String execMoney,
			String caseState, String savetime, Integer beijingCourtState,
			Integer uid, String executestep, String remark, String creditor,
			String noticeCourt, String noticeTime, String lawDocumentNum,String infoType,
			String excludeStatus) {
		super();
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
		this.uid = uid;
		this.executestep = executestep;
		this.remark = remark;
		this.creditor = creditor;
		this.noticeCourt = noticeCourt;
		this.noticeTime = noticeTime;
		this.lawDocumentNum = lawDocumentNum;
		this.infoType = infoType;
		this.excludeStatus = excludeStatus;
	}

	
	public ContactTalk getCtalk() {
		return ctalk;
	}

	public void setCtalk(ContactTalk ctalk) {
		this.ctalk = ctalk;
	}

	public List<ContactTalk> getListctalk() {
		return listctalk;
	}

	public void setListctalk(List<ContactTalk> listctalk) {
		this.listctalk = listctalk;
	}

	public List<ContactMail> getListcm() {
		return listcm;
	}

	public void setListcm(List<ContactMail> listcm) {
		this.listcm = listcm;
	}

	public List<ContactTel> getListct() {
		return listct;
	}

	public void setListct(List<ContactTel> listct) {
		this.listct = listct;
	}

	public List<ContactExpress> getListce() {
		return listce;
	}

	public void setListce(List<ContactExpress> listce) {
		this.listce = listce;
	}

	public List<ContactFax> getListcf() {
		return listcf;
	}

	public void setListcf(List<ContactFax> listcf) {
		this.listcf = listcf;
	}

	public List<ContactSee> getListcs() {
		return listcs;
	}

	public void setListcs(List<ContactSee> listcs) {
		this.listcs = listcs;
	}

	public ContactMail getCm() {
		return cm;
	}

	public void setCm(ContactMail cm) {
		this.cm = cm;
	}

	public ContactTel getCt() {
		return ct;
	}

	public void setCt(ContactTel ct) {
		this.ct = ct;
	}

	public ContactExpress getCe() {
		return ce;
	}


	public void setCe(ContactExpress ce) {
		this.ce = ce;
	}

	public ContactFax getCf() {
		return cf;
	}

	public void setCf(ContactFax cf) {
		this.cf = cf;
	}

	public ContactSee getCsee() {
		return csee;
	}

	public void setCsee(ContactSee csee) {
		this.csee = csee;
	}

	public Applierinfo getAp() {
		return ap;
	}
	public void setAp(Applierinfo ap) {
		this.ap = ap;
	}
	
	public ApplierinfoNetwork getAn() {
		return an;
	}

	public void setAn(ApplierinfoNetwork an) {
		this.an = an;
	}

	public Executebusiness getEb() {
		return eb;
	}
	public void setEb(Executebusiness eb) {
		this.eb = eb;
	}

	public ApplierinfoOnself getAo() {
		return ao;
	}
	public void setAo(ApplierinfoOnself ao) {
		this.ao = ao;
	}
	public ContractSign getCsign() {
		return csign;
	}

	public void setCsign(ContractSign csign) {
		this.csign = csign;
	}
	/** default constructor */
	public Court() {
	}
	/** full constructor */

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCaseId() {
		return this.caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public String getPname() {
		return this.pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPartyCardNum() {
		return this.partyCardNum;
	}

	public void setPartyCardNum(String partyCardNum) {
		this.partyCardNum = partyCardNum;
	}

	public String getExecCourtName() {
		return this.execCourtName;
	}

	public void setExecCourtName(String execCourtName) {
		this.execCourtName = execCourtName;
	}

	public String getCourtcode() {
		return this.courtcode;
	}

	public void setCourtcode(String courtcode) {
		this.courtcode = courtcode;
	}

	public String getCasecodeself() {
		return this.casecodeself;
	}

	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}

	public String getCaseCreateTime() {
		return this.caseCreateTime;
	}

	public void setCaseCreateTime(String caseCreateTime) {
		this.caseCreateTime = caseCreateTime;
	}

	public String getCaseCode() {
		return this.caseCode;
	}

	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}

	public String getExecMoney() {
		return this.execMoney;
	}

	public void setExecMoney(String execMoney) {
		this.execMoney = execMoney;
	}

	public String getCaseState() {
		return this.caseState;
	}

	public void setCaseState(String caseState) {
		this.caseState = caseState;
	}

	public String  getSavetime() {
		return this.savetime;
	}

	public void setSavetime(String  savetime) {
		this.savetime = savetime;
	}

	public Integer getBeijingCourtState() {
		return this.beijingCourtState;
	}

	public void setBeijingCourtState(Integer beijingCourtState) {
		this.beijingCourtState = beijingCourtState;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getExecutestep() {
		return executestep;
	}

	public void setExecutestep(String executestep) {
		this.executestep = executestep;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreditor() {
		return creditor;
	}

	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}
	public String getCreditorAddress() {
		return creditorAddress;
	}

	public void setCreditorAddress(String creditorAddress) {
		this.creditorAddress = creditorAddress;
	}

	public String getNoticeCourt() {
		return noticeCourt;
	}

	public void setNoticeCourt(String noticeCourt) {
		this.noticeCourt = noticeCourt;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getLawDocumentNum() {
		return lawDocumentNum;
	}

	public void setLawDocumentNum(String lawDocumentNum) {
		this.lawDocumentNum = lawDocumentNum;
	}

	public String getInfoType() {
		return infoType;
	}

	public void setInfoType(String infoType) {
		this.infoType = infoType;
	}

	public String getExcludeStatus() {
		return excludeStatus;
	}

	public void setExcludeStatus(String excludeStatus) {
		this.excludeStatus = excludeStatus;
	}
}