package com.lawyer.pojo;



public class Filelibrary implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer flId;
	private String flName;
	private String flCategory;
	private String beizhu;
	/** default constructor */
	public Filelibrary() {
	}
	public Filelibrary(String flName, String flCategory, String beizhu) {
		super();
		this.flName = flName;
		this.flCategory = flCategory;
		this.beizhu = beizhu;
	}

	public Integer getFlId() {
		return this.flId;
	}

	public void setFlId(Integer flId) {
		this.flId = flId;
	}

	public String getFlName() {
		return this.flName;
	}

	public void setFlName(String flName) {
		this.flName = flName;
	}

	public String getFlCategory() {
		return this.flCategory;
	}

	public void setFlCategory(String flCategory) {
		this.flCategory = flCategory;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}
	
}