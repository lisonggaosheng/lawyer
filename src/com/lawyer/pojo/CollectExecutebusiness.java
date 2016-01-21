package com.lawyer.pojo;

@SuppressWarnings("serial")
public class CollectExecutebusiness implements java.io.Serializable {
	private Integer ID;
	private String courtcode;				//法院编号	
	private String casecodeself;			//案件编号
	private String caseCode;				//案号
	private String business_name;			//主体名称
	private String registration_mark;		//注册号
	private String address;					//地址
	private String corporation;				//法定代表人姓名
	private String registered_capital;		//注册资本
	private String paid_in_capital;			//实收资本
	private String business_type;			//公司类型
	private String enterprise_status;		//企业状态
	private String business_scope_mark;		//经营范围项下标注
	private String operating_period_since;	//营业期限自
	private String operating_period_to;		//营业期限至
	private String establishmen_date;		//成立日期
	private String redistration_authority;	//登记机关
	private String cancellation_date;		//注销日期
	private String revoke_date;				//吊销日期
	private String organization_code;		//组织机构代码
	private String organization_code_issuing_agencies;	//代码证颁发机关
	private String inspection_annual;		//年检年度
	private String inspection_results;		//年检结果
	private String savetime;				//保存时间
	
	public CollectExecutebusiness() {
		super();
	}
	public CollectExecutebusiness(String courtcode, String casecodeself,
			String caseCode, String business_name, String registration_mark,
			String address, String corporation, String registered_capital,
			String paid_in_capital, String business_type,
			String enterprise_status, String business_scope_mark,
			String operating_period_since, String operating_period_to,
			String establishmen_date, String redistration_authority,
			String cancellation_date, String revoke_date,
			String organization_code,
			String organization_code_issuing_agencies,
			String inspection_annual, String inspection_results, String savetime) {
		super();
		this.courtcode = courtcode;
		this.casecodeself = casecodeself;
		this.caseCode = caseCode;
		this.business_name = business_name;
		this.registration_mark = registration_mark;
		this.address = address;
		this.corporation = corporation;
		this.registered_capital = registered_capital;
		this.paid_in_capital = paid_in_capital;
		this.business_type = business_type;
		this.enterprise_status = enterprise_status;
		this.business_scope_mark = business_scope_mark;
		this.operating_period_since = operating_period_since;
		this.operating_period_to = operating_period_to;
		this.establishmen_date = establishmen_date;
		this.redistration_authority = redistration_authority;
		this.cancellation_date = cancellation_date;
		this.revoke_date = revoke_date;
		this.organization_code = organization_code;
		this.organization_code_issuing_agencies = organization_code_issuing_agencies;
		this.inspection_annual = inspection_annual;
		this.inspection_results = inspection_results;
		this.savetime = savetime;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getCourtcode() {
		return courtcode;
	}
	public void setCourtcode(String courtcode) {
		this.courtcode = courtcode;
	}
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}
	public String getCaseCode() {
		return caseCode;
	}
	public void setCaseCode(String caseCode) {
		this.caseCode = caseCode;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public String getRegistration_mark() {
		return registration_mark;
	}
	public void setRegistration_mark(String registration_mark) {
		this.registration_mark = registration_mark;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	public String getRegistered_capital() {
		return registered_capital;
	}
	public void setRegistered_capital(String registered_capital) {
		this.registered_capital = registered_capital;
	}
	public String getPaid_in_capital() {
		return paid_in_capital;
	}
	public void setPaid_in_capital(String paid_in_capital) {
		this.paid_in_capital = paid_in_capital;
	}
	public String getBusiness_type() {
		return business_type;
	}
	public void setBusiness_type(String business_type) {
		this.business_type = business_type;
	}
	public String getEnterprise_status() {
		return enterprise_status;
	}
	public void setEnterprise_status(String enterprise_status) {
		this.enterprise_status = enterprise_status;
	}
	public String getBusiness_scope_mark() {
		return business_scope_mark;
	}
	public void setBusiness_scope_mark(String business_scope_mark) {
		this.business_scope_mark = business_scope_mark;
	}
	public String getEstablishmen_date() {
		return establishmen_date;
	}
	public void setEstablishmen_date(String establishmen_date) {
		this.establishmen_date = establishmen_date;
	}
	public String getOperating_period_since() {
		return operating_period_since;
	}
	public void setOperating_period_since(String operating_period_since) {
		this.operating_period_since = operating_period_since;
	}
	public String getOperating_period_to() {
		return operating_period_to;
	}
	public void setOperating_period_to(String operating_period_to) {
		this.operating_period_to = operating_period_to;
	}
	public String getRedistration_authority() {
		return redistration_authority;
	}
	public void setRedistration_authority(String redistration_authority) {
		this.redistration_authority = redistration_authority;
	}
	public String getInspection_annual() {
		return inspection_annual;
	}
	public void setInspection_annual(String inspection_annual) {
		this.inspection_annual = inspection_annual;
	}
	public String getInspection_results() {
		return inspection_results;
	}
	public void setInspection_results(String inspection_results) {
		this.inspection_results = inspection_results;
	}
	public String getCancellation_date() {
		return cancellation_date;
	}
	public void setCancellation_date(String cancellation_date) {
		this.cancellation_date = cancellation_date;
	}
	public String getRevoke_date() {
		return revoke_date;
	}
	public void setRevoke_date(String revoke_date) {
		this.revoke_date = revoke_date;
	}
	public String getOrganization_code() {
		return organization_code;
	}
	public void setOrganization_code(String organization_code) {
		this.organization_code = organization_code;
	}
	public String getOrganization_code_issuing_agencies() {
		return organization_code_issuing_agencies;
	}
	public void setOrganization_code_issuing_agencies(
			String organization_code_issuing_agencies) {
		this.organization_code_issuing_agencies = organization_code_issuing_agencies;
	}
	public String getSavetime() {
		return savetime;
	}
	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}
	
}