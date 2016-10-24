package com.lawyer.pojo;

import java.util.List;

/**
 * ContractSign entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class ContractSign implements java.io.Serializable {

	private Integer csId;
	private Users users;
	private String csDate;
	private String csAle;
	private String csMyName;
	private String csName;
	private String csTel;
	private String csNo;
	private String csRemark;
	private String csAttach;
	private String csCasecodeself;
	private String csSavetime;
	private String csCaseID;
	
	private String pname;
	private String appName;
	private String lawyerName;
	
	private String contMinTime;
	private String contMaxTime;
	

	// Constructors

	List<Material> materials;
	List<ClearClear> clearclears;
	List<ClearRecord> clearrecords;
	List<Litigation> litigations;
	List<Execute> executes;
	
	Material material;
	MaintainCustomers customer;
	ClearClear clearclear;
	ClearRecord clearrecord;
	Litigation litigation;
	Execute execute;
	CloseRecord closerecord;

	/** default constructor */
	public ContractSign() {
	}

	public ContractSign(Integer csId, Users users, String csDate, String csAle,
			String csName, String csTel, String csNo, String csRemark,
			String csAttach, String csCasecodeself,String pname,String appName) {
		super();
		this.csId = csId;
		this.users = users;
		this.csDate = csDate;
		this.csAle = csAle;
		this.csName = csName;
		this.csTel = csTel;
		this.csNo = csNo;
		this.csRemark = csRemark;
		this.csAttach = csAttach;
		this.csCasecodeself = csCasecodeself;
		this.pname = pname;
		this.appName = appName;
	}

	/** full constructor */

	// Property accessors

	public Integer getCsId() {
		return this.csId;
	}

	public ContractSign(Users users, String csDate, String csAle,
			String csMyName,String csName, String csTel, String csNo, String csRemark,
			String csAttach, String csCasecodeself, String csSavetime,
			List<ClearClear> clearclears, List<ClearRecord> clearrecords,
			List<Litigation> litigations, List<Execute> executes,
			ClearClear clearclear, ClearRecord clearrecord,
			Litigation litigation, Execute execute, CloseRecord closerecord) {
		super();
		this.users = users;
		this.csDate = csDate;
		this.csAle = csAle;
		this.csMyName = csMyName;
		this.csName = csName;
		this.csTel = csTel;
		this.csNo = csNo;
		this.csRemark = csRemark;
		this.csAttach = csAttach;
		this.csCasecodeself = csCasecodeself;
		this.csSavetime = csSavetime;
		this.clearclears = clearclears;
		this.clearrecords = clearrecords;
		this.litigations = litigations;
		this.executes = executes;
		this.clearclear = clearclear;
		this.clearrecord = clearrecord;
		this.litigation = litigation;
		this.execute = execute;
		this.closerecord = closerecord;
	}

	public void setCsId(Integer csId) {
		this.csId = csId;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getCsDate() {
		return this.csDate;
	}

	public void setCsDate(String csDate) {
		this.csDate = csDate;
	}

	public String getCsAle() {
		return this.csAle;
	}

	public void setCsAle(String csAle) {
		this.csAle = csAle;
	}

	public String getCsName() {
		return this.csName;
	}

	public void setCsName(String csName) {
		this.csName = csName;
	}

	public String getCsTel() {
		return this.csTel;
	}

	public void setCsTel(String csTel) {
		this.csTel = csTel;
	}

	public String getCsNo() {
		return this.csNo;
	}

	public void setCsNo(String csNo) {
		this.csNo = csNo;
	}

	public String getCsRemark() {
		return this.csRemark;
	}

	public void setCsRemark(String csRemark) {
		this.csRemark = csRemark;
	}

	public String getCsAttach() {
		return this.csAttach;
	}

	public void setCsAttach(String csAttach) {
		this.csAttach = csAttach;
	}

	public String getCsCasecodeself() {
		return this.csCasecodeself;
	}

	public void setCsCasecodeself(String csCasecodeself) {
		this.csCasecodeself = csCasecodeself;
	}


	public List<ClearClear> getClearclears() {
		return clearclears;
	}

	public void setClearclears(List<ClearClear> clearclears) {
		this.clearclears = clearclears;
	}

	public List<ClearRecord> getClearrecords() {
		return clearrecords;
	}

	public void setClearrecords(List<ClearRecord> clearrecords) {
		this.clearrecords = clearrecords;
	}

	public List<Litigation> getLitigations() {
		return litigations;
	}

	public void setLitigations(List<Litigation> litigations) {
		this.litigations = litigations;
	}

	public List<Execute> getExecutes() {
		return executes;
	}

	public void setExecutes(List<Execute> executes) {
		this.executes = executes;
	}

	public ClearClear getClearclear() {
		return clearclear;
	}

	public void setClearclear(ClearClear clearclear) {
		this.clearclear = clearclear;
	}

	public ClearRecord getClearrecord() {
		return clearrecord;
	}

	public void setClearrecord(ClearRecord clearrecord) {
		this.clearrecord = clearrecord;
	}

	public Litigation getLitigation() {
		return litigation;
	}

	public void setLitigation(Litigation litigation) {
		this.litigation = litigation;
	}

	public Execute getExecute() {
		return execute;
	}

	public void setExecute(Execute execute) {
		this.execute = execute;
	}

	public CloseRecord getCloserecord() {
		return closerecord;
	}

	public void setCloserecord(CloseRecord closerecord) {
		this.closerecord = closerecord;
	}

	public String getCsSavetime() {
		return csSavetime;
	}

	public void setCsSavetime(String csSavetime) {
		this.csSavetime = csSavetime;
	}

	public String getCsCaseID() {
		return csCaseID;
	}

	public void setCsCaseID(String csCaseID) {
		this.csCaseID = csCaseID;
	}

	public String getCsMyName() {
		return csMyName;
	}

	public void setCsMyName(String csMyName) {
		this.csMyName = csMyName;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getLawyerName() {
		return lawyerName;
	}

	public void setLawyerName(String lawyerName) {
		this.lawyerName = lawyerName;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public String getContMinTime() {
		return contMinTime;
	}

	public void setContMinTime(String contMinTime) {
		this.contMinTime = contMinTime;
	}

	public String getContMaxTime() {
		return contMaxTime;
	}

	public void setContMaxTime(String contMaxTime) {
		this.contMaxTime = contMaxTime;
	}

	public MaintainCustomers getCustomer() {
		return customer;
	}

	public void setCustomer(MaintainCustomers customer) {
		this.customer = customer;
	}

}