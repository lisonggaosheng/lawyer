package com.lawyer.pojo;

import java.util.HashSet;
import java.util.Set;

public class Users  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

     private Integer UId;
     private String UName;
     private String UPassword;
     private String URole;
     private String USta;
     private String roleName;
     private String mobile;
     
     
	 private Set applies = new HashSet(0);
	 private Set contactTels = new HashSet(0);
	 private Set executebusinesses = new HashSet(0);
     private Set applierinfoNetworks = new HashSet(0);
     private Set applierinfoOnselfs = new HashSet(0);
     private Set clearClears = new HashSet(0);
     private Set fileses = new HashSet(0);
     private Set addrecords = new HashSet(0);
     private Set addrecordCopies = new HashSet(0);
     private Set contactMails = new HashSet(0);
     private Set contractSigns = new HashSet(0);
     private Set litigations = new HashSet(0);
     private Set executes = new HashSet(0);
     private Set clearRecords = new HashSet(0);

    public Users() {
    }
    
    public Users(Integer uId) {
		super();
		UId = uId;
	}

    public Integer getUId() {
        return this.UId;
    }
    
    public void setUId(Integer UId) {
        this.UId = UId;
    }

    public String getUName() {
        return this.UName;
    }
    
    public void setUName(String UName) {
        this.UName = UName;
    }

    public String getUPassword() {
        return this.UPassword;
    }
    
    public void setUPassword(String UPassword) {
        this.UPassword = UPassword;
    }

    public String getURole() {
        return this.URole;
    }
    
    public void setURole(String URole) {
        this.URole = URole;
    }

    public String getUSta() {
        return this.USta;
    }
    
    public void setUSta(String USta) {
        this.USta = USta;
    }

    public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Set getApplies() {
        return this.applies;
    }
    
    public void setApplies(Set applies) {
        this.applies = applies;
    }

    public Set getContactTels() {
        return this.contactTels;
    }
    
    public void setContactTels(Set contactTels) {
        this.contactTels = contactTels;
    }

    public Set getExecutebusinesses() {
        return this.executebusinesses;
    }
    
    public void setExecutebusinesses(Set executebusinesses) {
        this.executebusinesses = executebusinesses;
    }

    public Set getApplierinfoNetworks() {
        return this.applierinfoNetworks;
    }
    
    public void setApplierinfoNetworks(Set applierinfoNetworks) {
        this.applierinfoNetworks = applierinfoNetworks;
    }

    public Set getApplierinfoOnselfs() {
        return this.applierinfoOnselfs;
    }
    
    public void setApplierinfoOnselfs(Set applierinfoOnselfs) {
        this.applierinfoOnselfs = applierinfoOnselfs;
    }

    public Set getClearClears() {
        return this.clearClears;
    }
    
    public void setClearClears(Set clearClears) {
        this.clearClears = clearClears;
    }

    public Set getFileses() {
        return this.fileses;
    }
    
    public void setFileses(Set fileses) {
        this.fileses = fileses;
    }

    public Set getAddrecords() {
        return this.addrecords;
    }
    
    public void setAddrecords(Set addrecords) {
        this.addrecords = addrecords;
    }

    public Set getAddrecordCopies() {
        return this.addrecordCopies;
    }
    
    public void setAddrecordCopies(Set addrecordCopies) {
        this.addrecordCopies = addrecordCopies;
    }

    public Set getContactMails() {
        return this.contactMails;
    }
    
    public void setContactMails(Set contactMails) {
        this.contactMails = contactMails;
    }

    public Set getContractSigns() {
        return this.contractSigns;
    }
    
    public void setContractSigns(Set contractSigns) {
        this.contractSigns = contractSigns;
    }

    public Set getLitigations() {
        return this.litigations;
    }
    
    public void setLitigations(Set litigations) {
        this.litigations = litigations;
    }

    public Set getExecutes() {
        return this.executes;
    }
    
    public void setExecutes(Set executes) {
        this.executes = executes;
    }

    public Set getClearRecords() {
        return this.clearRecords;
    }
    
    public void setClearRecords(Set clearRecords) {
        this.clearRecords = clearRecords;
    }
}