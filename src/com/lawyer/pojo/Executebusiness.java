package com.lawyer.pojo;

public class Executebusiness implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer EId;
	private String ERenumber;				//注册号
	private String EType;					//企业类型
	private String EName;					//主体名称
	private String ERepname;				//法定代表人名称
	private String shareholder;				//股东名录
	private String ERepid;					//证件号码
	private String EDistrict;				//行政区域
	private String EDate;					//成立日期	
	private String EFund;					//注册资本
	private String paidFund;				//实收资本
	private String EDfrom;					//经营期限自
	private String EDto;					//经营期限至
	private String EOrgan;					//登记机关
	private String EAddress;				//地址
	private String EStatus;					//企业状态
	private String ERemark;					//备注
	private Users users;					//用户
	private String ECCasecodeself;			//案件编号
	private String ESavetime;				//保存日期
	private String EAnnual;					//年检年度
	private String EResults;				//年检结果
	private String ECancellation;			//注销日期
	private String ERevoke;					//吊销日期
	private String organization_code;		//组织机构代码
	private String organization_code_issuing_agencies;	//代码证颁发机关
	private String adverse_judicial_information;//不良司法信息
	private String administrative_sanction_information;//行政处罚信息
	private String investor_information;	//投资人信息
	private String reinvestment_information;//再投资信息
	private String exception;				//经营异常名录
	
	public Executebusiness() {
		super();
	}
	public Executebusiness(String eRenumber, String eType, String eName,
			String eRepname, String eRepid, String eDistrict, String eDate,
			String eFund, String paidFund, String eDfrom, String eDto,
			String eOrgan, String eAddress, String eStatus, String eRemark,
			Users users, String eCCasecodeself, String eSavetime,
			String eAnnual, String eResults, String eCancellation,
			String eRevoke, String organization_code,
			String organization_code_issuing_agencies,
			String adverse_judicial_information,
			String administrative_sanction_information,
			String investor_information, String reinvestment_information,String exception) {
		super();
		ERenumber = eRenumber;
		EType = eType;
		EName = eName;
		ERepname = eRepname;
		ERepid = eRepid;
		EDistrict = eDistrict;
		EDate = eDate;
		EFund = eFund;
		this.paidFund = paidFund;
		EDfrom = eDfrom;
		EDto = eDto;
		EOrgan = eOrgan;
		EAddress = eAddress;
		EStatus = eStatus;
		ERemark = eRemark;
		this.users = users;
		ECCasecodeself = eCCasecodeself;
		ESavetime = eSavetime;
		EAnnual = eAnnual;
		EResults = eResults;
		ECancellation = eCancellation;
		ERevoke = eRevoke;
		this.organization_code = organization_code;
		this.organization_code_issuing_agencies = organization_code_issuing_agencies;
		this.adverse_judicial_information = adverse_judicial_information;
		this.administrative_sanction_information = administrative_sanction_information;
		this.investor_information = investor_information;
		this.reinvestment_information = reinvestment_information;
		this.exception = exception;
	}
	public Integer getEId() {
		return EId;
	}
	public void setEId(Integer eId) {
		EId = eId;
	}
	public String getERenumber() {
		return ERenumber;
	}
	public void setERenumber(String eRenumber) {
		ERenumber = eRenumber;
	}
	public String getEType() {
		return EType;
	}
	public void setEType(String eType) {
		EType = eType;
	}
	public String getEName() {
		return EName;
	}
	public void setEName(String eName) {
		EName = eName;
	}
	public String getERepname() {
		return ERepname;
	}
	public void setERepname(String eRepname) {
		ERepname = eRepname;
	}
	public String getERepid() {
		return ERepid;
	}
	public void setERepid(String eRepid) {
		ERepid = eRepid;
	}
	public String getEDistrict() {
		return EDistrict;
	}
	public void setEDistrict(String eDistrict) {
		EDistrict = eDistrict;
	}
	public String getEDate() {
		return EDate;
	}
	public void setEDate(String eDate) {
		EDate = eDate;
	}
	public String getEFund() {
		return EFund;
	}
	public void setEFund(String eFund) {
		EFund = eFund;
	}
	public String getPaidFund() {
		return paidFund;
	}
	public void setPaidFund(String paidFund) {
		this.paidFund = paidFund;
	}
	public String getEDfrom() {
		return EDfrom;
	}
	public void setEDfrom(String eDfrom) {
		EDfrom = eDfrom;
	}
	public String getEDto() {
		return EDto;
	}
	public void setEDto(String eDto) {
		EDto = eDto;
	}
	public String getEOrgan() {
		return EOrgan;
	}
	public void setEOrgan(String eOrgan) {
		EOrgan = eOrgan;
	}
	public String getEAddress() {
		return EAddress;
	}
	public void setEAddress(String eAddress) {
		EAddress = eAddress;
	}
	public String getEStatus() {
		return EStatus;
	}
	public void setEStatus(String eStatus) {
		EStatus = eStatus;
	}
	public String getERemark() {
		return ERemark;
	}
	public void setERemark(String eRemark) {
		ERemark = eRemark;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getECCasecodeself() {
		return ECCasecodeself;
	}
	public void setECCasecodeself(String eCCasecodeself) {
		ECCasecodeself = eCCasecodeself;
	}
	public String getESavetime() {
		return ESavetime;
	}
	public void setESavetime(String eSavetime) {
		ESavetime = eSavetime;
	}
	public String getEAnnual() {
		return EAnnual;
	}
	public void setEAnnual(String eAnnual) {
		EAnnual = eAnnual;
	}
	public String getEResults() {
		return EResults;
	}
	public void setEResults(String eResults) {
		EResults = eResults;
	}
	public String getECancellation() {
		return ECancellation;
	}
	public void setECancellation(String eCancellation) {
		ECancellation = eCancellation;
	}
	public String getERevoke() {
		return ERevoke;
	}
	public void setERevoke(String eRevoke) {
		ERevoke = eRevoke;
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
	public String getAdverse_judicial_information() {
		return adverse_judicial_information;
	}
	public void setAdverse_judicial_information(String adverse_judicial_information) {
		this.adverse_judicial_information = adverse_judicial_information;
	}
	public String getAdministrative_sanction_information() {
		return administrative_sanction_information;
	}
	public void setAdministrative_sanction_information(
			String administrative_sanction_information) {
		this.administrative_sanction_information = administrative_sanction_information;
	}
	public String getInvestor_information() {
		return investor_information;
	}
	public void setInvestor_information(String investor_information) {
		this.investor_information = investor_information;
	}
	public String getReinvestment_information() {
		return reinvestment_information;
	}
	public void setReinvestment_information(String reinvestment_information) {
		this.reinvestment_information = reinvestment_information;
	}
	public String getShareholder() {
		return shareholder;
	}
	public void setShareholder(String shareholder) {
		this.shareholder = shareholder;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	
	
}