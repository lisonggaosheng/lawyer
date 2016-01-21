package com.lawyer.pojo;

import java.io.Serializable;

public class AdverseJudicialInformation implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String registration_mark;
	private String litigant;
	private String paperID;
	private String caseid;
	private String obligation;
	private String circumstances;
	private String basis_unit;
	private String performance;
	private String implementation_court;
	private String publication_date;
	
	public AdverseJudicialInformation() {
		super();
	}
	public AdverseJudicialInformation(String registration_mark,
			String litigant, String paperID, String caseid, String obligation,
			String circumstances, String basis_unit, String performance,
			String implementation_court, String publication_date) {
		super();
		this.registration_mark = registration_mark;
		this.litigant = litigant;
		this.paperID = paperID;
		this.caseid = caseid;
		this.obligation = obligation;
		this.circumstances = circumstances;
		this.basis_unit = basis_unit;
		this.performance = performance;
		this.implementation_court = implementation_court;
		this.publication_date = publication_date;
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
	public String getPaperID() {
		return paperID;
	}
	public void setPaperID(String paperID) {
		this.paperID = paperID;
	}
	public String getCaseid() {
		return caseid;
	}
	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}
	public String getObligation() {
		return obligation;
	}
	public void setObligation(String obligation) {
		this.obligation = obligation;
	}
	public String getCircumstances() {
		return circumstances;
	}
	public void setCircumstances(String circumstances) {
		this.circumstances = circumstances;
	}
	public String getBasis_unit() {
		return basis_unit;
	}
	public void setBasis_unit(String basis_unit) {
		this.basis_unit = basis_unit;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getImplementation_court() {
		return implementation_court;
	}
	public void setImplementation_court(String implementation_court) {
		this.implementation_court = implementation_court;
	}
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	
}
