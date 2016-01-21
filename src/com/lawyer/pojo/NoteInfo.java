package com.lawyer.pojo;

import java.util.Date;


@SuppressWarnings("serial")
public class NoteInfo implements java.io.Serializable {
	private Integer id;
	private String debtor_name;
	private String announcement_court;
	private String announcement_date;
	private String published_page;
	private String bak;
	private String url;
	private Date savetime;
	public NoteInfo() {
		super();
	}
	public NoteInfo(String debtor_name, String announcement_court,
			String announcement_date, String published_page, String bak,
			String url, Date savetime) {
		super();
		this.debtor_name = debtor_name;
		this.announcement_court = announcement_court;
		this.announcement_date = announcement_date;
		this.published_page = published_page;
		this.bak = bak;
		this.url = url;
		this.savetime = savetime;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDebtor_name() {
		return debtor_name;
	}
	public void setDebtor_name(String debtor_name) {
		this.debtor_name = debtor_name;
	}
	public String getAnnouncement_court() {
		return announcement_court;
	}
	public void setAnnouncement_court(String announcement_court) {
		this.announcement_court = announcement_court;
	}
	public String getAnnouncement_date() {
		return announcement_date;
	}
	public void setAnnouncement_date(String announcement_date) {
		this.announcement_date = announcement_date;
	}
	public String getPublished_page() {
		return published_page;
	}
	public void setPublished_page(String published_page) {
		this.published_page = published_page;
	}
	public String getBak() {
		return bak;
	}
	public void setBak(String bak) {
		this.bak = bak;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getSavetime() {
		return savetime;
	}
	public void setSavetime(Date savetime) {
		this.savetime = savetime;
	}
}
