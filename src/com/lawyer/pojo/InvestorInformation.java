package com.lawyer.pojo;

import java.io.Serializable;

public class InvestorInformation implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String registration_mark;
	private String litigant;
	private String capital_contribution;
	private String type;
	
	public InvestorInformation() {
		super();
	}
	public InvestorInformation(String registration_mark, String litigant,
			String capital_contribution, String type) {
		super();
		this.registration_mark = registration_mark;
		this.litigant = litigant;
		this.capital_contribution = capital_contribution;
		this.type = type;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRegistration_mark() {
		return registration_mark;
	}
	public void setRegistration_mark(String registration_mark) {
		this.registration_mark = registration_mark;
	}
	public String getLitigant() {
		return litigant;
	}
	public void setLitigant(String litigant) {
		this.litigant = litigant;
	}
	public String getCapital_contribution() {
		return capital_contribution;
	}
	public void setCapital_contribution(String capital_contribution) {
		this.capital_contribution = capital_contribution;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
