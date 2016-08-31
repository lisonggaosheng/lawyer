package com.lawyer.pojo;

public class Applierinfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer appId;
	private Users users;
	private String appRenumber;
	private String appType;
	private String appName;
	private String appRepname;
	private String appRepid;
	private String appDistrict;
	private String appDate;
	private String appFund;
	private String appDfrom;
	private String appDto;
	private String appOrgan;
	private String appAddress;
	private String appStatus;
	private String appRemark;
	private String appCCasecodeself;
	private String appSavetime;
	private String appAnnual;
	private String appResults;
	private String appCancellation;
	private String appRevoke;
	
	private Integer usedMark;
	private String markRemark;
	private String markTime;
	
	/**
	 * 市场处理结果
	 */
	private String disposeResult;
	
	private String pname;
	private String casecode;
	
	
	public Applierinfo(Users users, String appRenumber, String appType,
			String appName, String appRepname, String appRepid,
			String appDistrict, String appDate, String appFund,
			String appDfrom, String appDto, String appOrgan, String appAddress,
			String appStatus, String appRemark, String appCCasecodeself,
			String appSavetime, String appAnnual, String appResults,
			String appCancellation, String appRevoke) {
		super();
		this.users = users;
		this.appRenumber = appRenumber;
		this.appType = appType;
		this.appName = appName;
		this.appRepname = appRepname;
		this.appRepid = appRepid;
		this.appDistrict = appDistrict;
		this.appDate = appDate;
		this.appFund = appFund;
		this.appDfrom = appDfrom;
		this.appDto = appDto;
		this.appOrgan = appOrgan;
		this.appAddress = appAddress;
		this.appStatus = appStatus;
		this.appRemark = appRemark;
		this.appCCasecodeself = appCCasecodeself;
		this.appSavetime = appSavetime;
		this.appAnnual = appAnnual;
		this.appResults = appResults;
		this.appCancellation = appCancellation;
		this.appRevoke = appRevoke;
	}
	
	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getCasecode() {
		return casecode;
	}

	public void setCasecode(String casecode) {
		this.casecode = casecode;
	}

	public String getAppRevoke() {
		return appRevoke;
	}
	public void setAppRevoke(String appRevoke) {
		this.appRevoke = appRevoke;
	}

	public Applierinfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getAppRenumber() {
		return appRenumber;
	}
	public void setAppRenumber(String appRenumber) {
		this.appRenumber = appRenumber;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getAppRepname() {
		return appRepname;
	}
	public void setAppRepname(String appRepname) {
		this.appRepname = appRepname;
	}
	public String getAppRepid() {
		return appRepid;
	}
	public void setAppRepid(String appRepid) {
		this.appRepid = appRepid;
	}
	public String getAppDistrict() {
		return appDistrict;
	}
	public void setAppDistrict(String appDistrict) {
		this.appDistrict = appDistrict;
	}
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getAppFund() {
		return appFund;
	}
	public void setAppFund(String appFund) {
		this.appFund = appFund;
	}
	public String getAppDfrom() {
		return appDfrom;
	}
	public void setAppDfrom(String appDfrom) {
		this.appDfrom = appDfrom;
	}
	public String getAppDto() {
		return appDto;
	}
	public void setAppDto(String appDto) {
		this.appDto = appDto;
	}
	public String getAppOrgan() {
		return appOrgan;
	}
	public void setAppOrgan(String appOrgan) {
		this.appOrgan = appOrgan;
	}
	public String getAppAddress() {
		return appAddress;
	}
	public void setAppAddress(String appAddress) {
		this.appAddress = appAddress;
	}
	public String getAppStatus() {
		return appStatus;
	}
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}
	public String getAppRemark() {
		return appRemark;
	}
	public void setAppRemark(String appRemark) {
		this.appRemark = appRemark;
	}
	public String getAppCCasecodeself() {
		return appCCasecodeself;
	}
	public void setAppCCasecodeself(String appCCasecodeself) {
		this.appCCasecodeself = appCCasecodeself;
	}
	public String getAppSavetime() {
		return appSavetime;
	}
	public void setAppSavetime(String appSavetime) {
		this.appSavetime = appSavetime;
	}
	public String getAppAnnual() {
		return appAnnual;
	}
	public void setAppAnnual(String appAnnual) {
		this.appAnnual = appAnnual;
	}
	public String getAppResults() {
		return appResults;
	}
	public void setAppResults(String appResults) {
		this.appResults = appResults;
	}
	public String getAppCancellation() {
		return appCancellation;
	}
	public void setAppCancellation(String appCancellation) {
		this.appCancellation = appCancellation;
	}

	public Integer getUsedMark() {
		return usedMark;
	}

	public void setUsedMark(Integer usedMark) {
		this.usedMark = usedMark;
	}

	public String getMarkRemark() {
		return markRemark;
	}

	public void setMarkRemark(String markRemark) {
		this.markRemark = markRemark;
	}

	public String getMarkTime() {
		return markTime;
	}

	public void setMarkTime(String markTime) {
		this.markTime = markTime;
	}

	public String getDisposeResult() {
		return disposeResult;
	}

	public void setDisposeResult(String disposeResult) {
		this.disposeResult = disposeResult;
	}
	
	
}