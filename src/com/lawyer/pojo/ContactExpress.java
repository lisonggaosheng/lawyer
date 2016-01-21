package com.lawyer.pojo;

/**
 * ContactExpress entity. @author MyEclipse Persistence Tools
 */

public class ContactExpress implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ceId;
	private String ceName;
	private String ceDate;
	private String ceResult;
	private String ceAccepter;
	private String ceTime;
	private String ceNumber;
	private String ceRemark;
	private String ceAttach;
	private Users users;
	private String ceCasecodeself;
	private String ceSavetime;

	// Constructors

	/** default constructor */
	public ContactExpress() {
	}

	public ContactExpress(String ceName, String ceDate, String ceResult,
			String ceAccepter, String ceTime, String ceNumber, String ceRemark,
			String ceAttach, Users users, String ceCasecodeself,
			String ceSavetime) {
		super();
		this.ceName = ceName;
		this.ceDate = ceDate;
		this.ceResult = ceResult;
		this.ceAccepter = ceAccepter;
		this.ceTime = ceTime;
		this.ceNumber = ceNumber;
		this.ceRemark = ceRemark;
		this.ceAttach = ceAttach;
		this.users = users;
		this.ceCasecodeself = ceCasecodeself;
		this.ceSavetime = ceSavetime;
	}

	public Integer getCeId() {
		return ceId;
	}

	public void setCeId(Integer ceId) {
		this.ceId = ceId;
	}

	public String getCeName() {
		return ceName;
	}

	public void setCeName(String ceName) {
		this.ceName = ceName;
	}

	public String getCeDate() {
		return ceDate;
	}

	public void setCeDate(String ceDate) {
		this.ceDate = ceDate;
	}

	public String getCeResult() {
		return ceResult;
	}

	public void setCeResult(String ceResult) {
		this.ceResult = ceResult;
	}

	public String getCeAccepter() {
		return ceAccepter;
	}

	public void setCeAccepter(String ceAccepter) {
		this.ceAccepter = ceAccepter;
	}

	public String getCeTime() {
		return ceTime;
	}

	public void setCeTime(String ceTime) {
		this.ceTime = ceTime;
	}

	public String getCeNumber() {
		return ceNumber;
	}

	public void setCeNumber(String ceNumber) {
		this.ceNumber = ceNumber;
	}

	public String getCeRemark() {
		return ceRemark;
	}

	public void setCeRemark(String ceRemark) {
		this.ceRemark = ceRemark;
	}

	public String getCeAttach() {
		return ceAttach;
	}

	public void setCeAttach(String ceAttach) {
		this.ceAttach = ceAttach;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCeCasecodeself() {
		return ceCasecodeself;
	}

	public void setCeCasecodeself(String ceCasecodeself) {
		this.ceCasecodeself = ceCasecodeself;
	}

	public String getCeSavetime() {
		return ceSavetime;
	}

	public void setCeSavetime(String ceSavetime) {
		this.ceSavetime = ceSavetime;
	}

}