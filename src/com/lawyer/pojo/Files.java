package com.lawyer.pojo;


public class Files implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Users users;
	private Filelibrary filelibrary;
	private String FTitle;
	private String FType;
	private String FReldate;
	private String FAttach;
	// Fields	
	private Integer FId;
	
	public Files() {
	}
	public Users getUsers() {
		return this.users;
	}

	public Integer getFId() {
		return FId;
	}

	public void setFId(Integer fId) {
		FId = fId;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Filelibrary getFilelibrary() {
		return this.filelibrary;
	}

	public void setFilelibrary(Filelibrary filelibrary) {
		this.filelibrary = filelibrary;
	}

	public String getFTitle() {
		return this.FTitle;
	}

	public void setFTitle(String FTitle) {
		this.FTitle = FTitle;
	}

	public String getFType() {
		return this.FType;
	}

	public void setFType(String FType) {
		this.FType = FType;
	}
	public String getFReldate() {
		return FReldate;
	}

	public void setFReldate(String fReldate) {
		FReldate = fReldate;
	}

	public String getFAttach() {
		return this.FAttach;
	}

	public void setFAttach(String FAttach) {
		this.FAttach = FAttach;
	}

}