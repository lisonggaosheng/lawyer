package com.lawyer.pojo;

import java.io.Serializable;

public class LimitPower implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer lp_id;
	private String lp_user_name;
	private String lp_add_casesource="0";
	private String lp_add_casesource_bat="0";
	private String lp_query_casesource="0";
	private String lp_query_casesource_resultopts="0";
	private String lp_senior_query_casesource="0";
	private String lp_statistics_casesource="0";
	private String lp_add_case="0";
	private String lp_query_case="0";
	private String lp_senior_query_case="0";
	private String lp_statistics_case="0";
	private String lp_add_filebase="0";
	private String lp_query_filebase="0";
	
	private String lp_query_casesource_detail="0";
	private String lp_upd="0";
	private String lp_del="0";
	private String lp_limit_query_court="0";
	private String lp_query_case_detail="0";
	private String lp_exb_show_repid="0";
	
	public LimitPower() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LimitPower(String lpUserName, String lpAddCasesource,
			String lpAddCasesourceBat, String lpQueryCasesource,
			String lpQueryCasesourceResultopts, String lpSeniorQueryCasesource,
			String lpStatisticsCasesource, String lpAddCase,
			String lpQueryCase, String lpSeniorQueryCase,
			String lpStatisticsCase, String lpAddFilebase,
			String lpQueryFilebase, String lpQueryCasesourceDetail,
			String lpUpd, String lpDel, String lpLimitQueryCourt,
			String lpQueryCaseDetail) {
		super();
		lp_user_name = lpUserName;
		lp_add_casesource = lpAddCasesource;
		lp_add_casesource_bat = lpAddCasesourceBat;
		lp_query_casesource = lpQueryCasesource;
		lp_query_casesource_resultopts = lpQueryCasesourceResultopts;
		lp_senior_query_casesource = lpSeniorQueryCasesource;
		lp_statistics_casesource = lpStatisticsCasesource;
		lp_add_case = lpAddCase;
		lp_query_case = lpQueryCase;
		lp_senior_query_case = lpSeniorQueryCase;
		lp_statistics_case = lpStatisticsCase;
		lp_add_filebase = lpAddFilebase;
		lp_query_filebase = lpQueryFilebase;
		lp_query_casesource_detail = lpQueryCasesourceDetail;
		lp_upd = lpUpd;
		lp_del = lpDel;
		lp_limit_query_court = lpLimitQueryCourt;
		lp_query_case_detail = lpQueryCaseDetail;
	}



	public Integer getLp_id() {
		return lp_id;
	}
	public void setLp_id(Integer lpId) {
		lp_id = lpId;
	}
	public String getLp_user_name() {
		return lp_user_name;
	}
	public void setLp_user_name(String lpUserName) {
		lp_user_name = lpUserName;
	}
	public String getLp_add_casesource() {
		return lp_add_casesource;
	}
	public void setLp_add_casesource(String lpAddCasesource) {
		lp_add_casesource = lpAddCasesource;
	}
	public String getLp_add_casesource_bat() {
		return lp_add_casesource_bat;
	}
	public void setLp_add_casesource_bat(String lpAddCasesourceBat) {
		lp_add_casesource_bat = lpAddCasesourceBat;
	}
	public String getLp_query_casesource() {
		return lp_query_casesource;
	}
	public void setLp_query_casesource(String lpQueryCasesource) {
		lp_query_casesource = lpQueryCasesource;
	}
	public String getLp_query_casesource_resultopts() {
		return lp_query_casesource_resultopts;
	}
	public void setLp_query_casesource_resultopts(String lpQueryCasesourceResultopts) {
		lp_query_casesource_resultopts = lpQueryCasesourceResultopts;
	}
	public String getLp_senior_query_casesource() {
		return lp_senior_query_casesource;
	}
	public void setLp_senior_query_casesource(String lpSeniorQueryCasesource) {
		lp_senior_query_casesource = lpSeniorQueryCasesource;
	}
	public String getLp_statistics_casesource() {
		return lp_statistics_casesource;
	}
	public void setLp_statistics_casesource(String lpStatisticsCasesource) {
		lp_statistics_casesource = lpStatisticsCasesource;
	}
	public String getLp_add_case() {
		return lp_add_case;
	}
	public void setLp_add_case(String lpAddCase) {
		lp_add_case = lpAddCase;
	}
	public String getLp_query_case() {
		return lp_query_case;
	}
	public void setLp_query_case(String lpQueryCase) {
		lp_query_case = lpQueryCase;
	}
	public String getLp_senior_query_case() {
		return lp_senior_query_case;
	}
	public void setLp_senior_query_case(String lpSeniorQueryCase) {
		lp_senior_query_case = lpSeniorQueryCase;
	}
	public String getLp_statistics_case() {
		return lp_statistics_case;
	}
	public void setLp_statistics_case(String lpStatisticsCase) {
		lp_statistics_case = lpStatisticsCase;
	}
	public String getLp_add_filebase() {
		return lp_add_filebase;
	}
	public void setLp_add_filebase(String lpAddFilebase) {
		lp_add_filebase = lpAddFilebase;
	}
	public String getLp_query_filebase() {
		return lp_query_filebase;
	}
	public void setLp_query_filebase(String lpQueryFilebase) {
		lp_query_filebase = lpQueryFilebase;
	}

	public String getLp_query_casesource_detail() {
		return lp_query_casesource_detail;
	}

	public void setLp_query_casesource_detail(String lpQueryCasesourceDetail) {
		lp_query_casesource_detail = lpQueryCasesourceDetail;
	}

	public String getLp_upd() {
		return lp_upd;
	}

	public void setLp_upd(String lpUpd) {
		lp_upd = lpUpd;
	}

	public String getLp_del() {
		return lp_del;
	}

	public void setLp_del(String lpDel) {
		lp_del = lpDel;
	}

	public String getLp_limit_query_court() {
		return lp_limit_query_court;
	}

	public void setLp_limit_query_court(String lpLimitQueryCourt) {
		lp_limit_query_court = lpLimitQueryCourt;
	}

	public String getLp_query_case_detail() {
		return lp_query_case_detail;
	}

	public void setLp_query_case_detail(String lpQueryCaseDetail) {
		lp_query_case_detail = lpQueryCaseDetail;
	}

	public String getLp_exb_show_repid() {
		return lp_exb_show_repid;
	}

	public void setLp_exb_show_repid(String lp_exb_show_repid) {
		this.lp_exb_show_repid = lp_exb_show_repid;
	}
	
	
}
