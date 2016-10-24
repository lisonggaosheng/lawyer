package com.lawyer.pojo;

import java.io.Serializable;

public class MaintainCustomers implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String casecodeself;
	private String contacts;
	private String contactPhone;
	private String contactDate;
	private String serviceUser;
	private String servicePhone;
	private String content;
	private Users users;
	private String savetime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactDate() {
		return contactDate;
	}
	public void setContactDate(String contactDate) {
		this.contactDate = contactDate;
	}
	public String getServiceUser() {
		return serviceUser;
	}
	public void setServiceUser(String serviceUser) {
		this.serviceUser = serviceUser;
	}
	public String getServicePhone() {
		return servicePhone;
	}
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getSavetime() {
		return savetime;
	}
	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	
}
