package com.lawyer.pojo;

@SuppressWarnings("serial")
public class ApplierinfoOnself implements java.io.Serializable {

	// Fields

	private Integer aoId;
	private Users users;
	private String aoName;
	private String aoAddress;
	private String aoName1;
	private String aoPhone1;
	private String aoFax1;
	private String aoMail1;
	private String aoName2;
	private String aoPhone2;
	private String aoFax2;
	private String aoMail2;
	private String aoCasecodeself;
	private String aoSavetime;
	private String aoRemark;

	// Constructors

	/** default constructor */
	public ApplierinfoOnself() {
	}

	// Property accessors

	public Integer getAoId() {
		return this.aoId;
	}

	public ApplierinfoOnself(Users users, String aoName, String aoAddress,
			String aoName1, String aoPhone1, String aoFax1, String aoMail1,
			String aoName2, String aoPhone2, String aoFax2, String aoMail2,
			String aoCasecodeself, String aoSavetime,String aoRemark) {
		super();
		this.users = users;
		this.aoName = aoName;
		this.aoAddress = aoAddress;
		this.aoName1 = aoName1;
		this.aoPhone1 = aoPhone1;
		this.aoFax1 = aoFax1;
		this.aoMail1 = aoMail1;
		this.aoName2 = aoName2;
		this.aoPhone2 = aoPhone2;
		this.aoFax2 = aoFax2;
		this.aoMail2 = aoMail2;
		this.aoCasecodeself = aoCasecodeself;
		this.aoSavetime = aoSavetime;
		this.aoRemark = aoRemark;
	}

	public void setAoId(Integer aoId) {
		this.aoId = aoId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getAoName() {
		return this.aoName;
	}

	public void setAoName(String aoName) {
		this.aoName = aoName;
	}

	public String getAoAddress() {
		return this.aoAddress;
	}

	public void setAoAddress(String aoAddress) {
		this.aoAddress = aoAddress;
	}

	public String getAoName1() {
		return this.aoName1;
	}

	public void setAoName1(String aoName1) {
		this.aoName1 = aoName1;
	}

	public String getAoPhone1() {
		return this.aoPhone1;
	}

	public void setAoPhone1(String aoPhone1) {
		this.aoPhone1 = aoPhone1;
	}

	public String getAoFax1() {
		return this.aoFax1;
	}

	public void setAoFax1(String aoFax1) {
		this.aoFax1 = aoFax1;
	}

	public String getAoMail1() {
		return this.aoMail1;
	}

	public void setAoMail1(String aoMail1) {
		this.aoMail1 = aoMail1;
	}

	public String getAoName2() {
		return this.aoName2;
	}

	public void setAoName2(String aoName2) {
		this.aoName2 = aoName2;
	}

	public String getAoPhone2() {
		return this.aoPhone2;
	}

	public void setAoPhone2(String aoPhone2) {
		this.aoPhone2 = aoPhone2;
	}

	public String getAoFax2() {
		return this.aoFax2;
	}

	public void setAoFax2(String aoFax2) {
		this.aoFax2 = aoFax2;
	}

	public String getAoMail2() {
		return this.aoMail2;
	}

	public void setAoMail2(String aoMail2) {
		this.aoMail2 = aoMail2;
	}

	public String getAoCasecodeself() {
		return this.aoCasecodeself;
	}

	public void setAoCasecodeself(String aoCasecodeself) {
		this.aoCasecodeself = aoCasecodeself;
	}

	public String getAoSavetime() {
		return aoSavetime;
	}

	public void setAoSavetime(String aoSavetime) {
		this.aoSavetime = aoSavetime;
	}

	public String getAoRemark() {
		return aoRemark;
	}

	public void setAoRemark(String aoRemark) {
		this.aoRemark = aoRemark;
	}

}