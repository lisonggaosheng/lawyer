package com.lawyer.pojo;

public class ApplierinfoNetwork implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer anId;	
	private String anName;
	private String anAddress;												
	private String anConname;
	private String anPhone;
	private String anFax;
	private String anMail;
	private Users users;
	private String anCasecodeself;
	private String anSavetime;
	public ApplierinfoNetwork() {
		super();
	}
	
	public ApplierinfoNetwork(String anName, String anAddress,
			String anConname, String anPhone, String anFax, String anMail,
			Users users, String anCasecodeself, String anSavetime) {
		super();
		this.anName = anName;
		this.anAddress = anAddress;
		this.anConname = anConname;
		this.anPhone = anPhone;
		this.anFax = anFax;
		this.anMail = anMail;
		this.users = users;
		this.anCasecodeself = anCasecodeself;
		this.anSavetime = anSavetime;
	}

	public Integer getAnId() {
		return anId;
	}
	public void setAnId(Integer anId) {
		this.anId = anId;
	}
	public String getAnName() {
		return anName;
	}
	public void setAnName(String anName) {
		this.anName = anName;
	}
	public String getAnAddress() {
		return anAddress;
	}
	public void setAnAddress(String anAddress) {
		this.anAddress = anAddress;
	}
	public String getAnConname() {
		return anConname;
	}
	public void setAnConname(String anConname) {
		this.anConname = anConname;
	}
	public String getAnPhone() {
		return anPhone;
	}
	public void setAnPhone(String anPhone) {
		this.anPhone = anPhone;
	}
	public String getAnFax() {
		return anFax;
	}
	public void setAnFax(String anFax) {
		this.anFax = anFax;
	}
	public String getAnMail() {
		return anMail;
	}
	public void setAnMail(String anMail) {
		this.anMail = anMail;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getAnCasecodeself() {
		return anCasecodeself;
	}
	public void setAnCasecodeself(String anCasecodeself) {
		this.anCasecodeself = anCasecodeself;
	}
	public String getAnSavetime() {
		return anSavetime;
	}
	public void setAnSavetime(String anSavetime) {
		this.anSavetime = anSavetime;
	}
	
}