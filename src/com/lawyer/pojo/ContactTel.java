package com.lawyer.pojo;

@SuppressWarnings("serial")
public class ContactTel implements java.io.Serializable {

	private Integer ctId;
	private Users users;
	private String ctName;
	private String ctName1;
	private String ctTel1;
	private String ctName2;
	private String ctTel2;
	private String ctTime;
	private String ctResult;
	private String ctTel3;
	private String ctRemark;
	private String ctAttach;
	private String ctCasecodeself;
	private String ctSavetime;

	// Constructors

	/** default constructor */
	public ContactTel() {
	}

	/** full constructor */

	// Property accessors

	public Integer getCtId() {
		return this.ctId;
	}

	public ContactTel(Users users,String ctName, String ctName1, String ctTel1,
			String ctName2, String ctTel2, String ctTime, String ctResult,
			String ctTel3, String ctRemark, String ctAttach,
			String ctCasecodeself, String ctSavetime) {
		super();
		this.users = users;
		this.ctName = ctName;
		this.ctName1 = ctName1;
		this.ctTel1 = ctTel1;
		this.ctName2 = ctName2;
		this.ctTel2 = ctTel2;
		this.ctTime = ctTime;
		this.ctResult = ctResult;
		this.ctTel3 = ctTel3;
		this.ctRemark = ctRemark;
		this.ctAttach = ctAttach;
		this.ctCasecodeself = ctCasecodeself;
		this.ctSavetime = ctSavetime;
	}

	public void setCtId(Integer ctId) {
		this.ctId = ctId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCtName1() {
		return this.ctName1;
	}

	public void setCtName1(String ctName1) {
		this.ctName1 = ctName1;
	}

	public String getCtTel1() {
		return this.ctTel1;
	}

	public void setCtTel1(String ctTel1) {
		this.ctTel1 = ctTel1;
	}

	public String getCtName2() {
		return this.ctName2;
	}

	public void setCtName2(String ctName2) {
		this.ctName2 = ctName2;
	}

	public String getCtTel2() {
		return this.ctTel2;
	}

	public void setCtTel2(String ctTel2) {
		this.ctTel2 = ctTel2;
	}

	public String getCtTime() {
		return this.ctTime;
	}

	public void setCtTime(String ctTime) {
		this.ctTime = ctTime;
	}

	public String getCtResult() {
		return this.ctResult;
	}

	public void setCtResult(String ctResult) {
		this.ctResult = ctResult;
	}

	public String getCtTel3() {
		return this.ctTel3;
	}

	public void setCtTel3(String ctTel3) {
		this.ctTel3 = ctTel3;
	}

	public String getCtRemark() {
		return this.ctRemark;
	}

	public void setCtRemark(String ctRemark) {
		this.ctRemark = ctRemark;
	}

	public String getCtAttach() {
		return this.ctAttach;
	}

	public void setCtAttach(String ctAttach) {
		this.ctAttach = ctAttach;
	}

	public String getCtCasecodeself() {
		return this.ctCasecodeself;
	}

	public void setCtCasecodeself(String ctCasecodeself) {
		this.ctCasecodeself = ctCasecodeself;
	}

	public String getCtSavetime() {
		return ctSavetime;
	}

	public void setCtSavetime(String ctSavetime) {
		this.ctSavetime = ctSavetime;
	}

	public String getCtName() {
		return ctName;
	}

	public void setCtName(String ctName) {
		this.ctName = ctName;
	}

}