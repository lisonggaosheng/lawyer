package com.lawyer.pojo;

import java.io.Serializable;

public class AdministrativeSanctionInformation implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String registration_mark;
	private String litigant;
	private String paperID;
	private String basic_facts;
	private String asserting_basis;
	private String Punishment_basis;
	private String disciplinary_action;
	private String case_handling_organ;
	private String publication_date;
	
	public AdministrativeSanctionInformation() {
		super();
	}
	public AdministrativeSanctionInformation(
			String registration_mark, String litigant, String paperID,
			String basic_facts, String asserting_basis,
			String punishment_basis, String disciplinary_action,
			String case_handling_organ, String publication_date) {
		super();
		this.registration_mark = registration_mark;
		this.litigant = litigant;
		this.paperID = paperID;
		this.basic_facts = basic_facts;
		this.asserting_basis = asserting_basis;
		Punishment_basis = punishment_basis;
		this.disciplinary_action = disciplinary_action;
		this.case_handling_organ = case_handling_organ;
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
	public String getBasic_facts() {
		return basic_facts;
	}
	public void setBasic_facts(String basic_facts) {
		this.basic_facts = basic_facts;
	}
	public String getAsserting_basis() {
		return asserting_basis;
	}
	public void setAsserting_basis(String asserting_basis) {
		this.asserting_basis = asserting_basis;
	}
	public String getPunishment_basis() {
		return Punishment_basis;
	}
	public void setPunishment_basis(String punishment_basis) {
		Punishment_basis = punishment_basis;
	}
	public String getDisciplinary_action() {
		return disciplinary_action;
	}
	public void setDisciplinary_action(String disciplinary_action) {
		this.disciplinary_action = disciplinary_action;
	}
	public String getCase_handling_organ() {
		return case_handling_organ;
	}
	public void setCase_handling_organ(String case_handling_organ) {
		this.case_handling_organ = case_handling_organ;
	}
	public String getPublication_date() {
		return publication_date;
	}
	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}
	
	
}
