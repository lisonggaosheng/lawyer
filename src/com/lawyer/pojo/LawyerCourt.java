package com.lawyer.pojo;

import java.io.Serializable;
/**
 * @date 2013-4-13 15:18:58
 * @author 李梦翔
 *	法院表对应的实体类
 */
public class LawyerCourt implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer lawyerCourt_id;
	private Integer lawyerCourt_pid;
	private String lawyerCourt_court_name;
	private String lawyerCourt_number;
	
	public LawyerCourt(Integer lawyerCourtId, Integer lawyerCourtPid,
			String lawyerCourtCourtName, String lawyerCourtNumber) {
		super();
		lawyerCourt_id = lawyerCourtId;
		lawyerCourt_pid = lawyerCourtPid;
		lawyerCourt_court_name = lawyerCourtCourtName;
		lawyerCourt_number = lawyerCourtNumber;
	}
	public LawyerCourt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getLawyerCourt_id() {
		return lawyerCourt_id;
	}
	public void setLawyerCourt_id(Integer lawyerCourtId) {
		lawyerCourt_id = lawyerCourtId;
	}
	public Integer getLawyerCourt_pid() {
		return lawyerCourt_pid;
	}
	public void setLawyerCourt_pid(Integer lawyerCourtPid) {
		lawyerCourt_pid = lawyerCourtPid;
	}
	public String getLawyerCourt_court_name() {
		return lawyerCourt_court_name;
	}
	public void setLawyerCourt_court_name(String lawyerCourtCourtName) {
		lawyerCourt_court_name = lawyerCourtCourtName;
	}
	public String getLawyerCourt_number() {
		return lawyerCourt_number;
	}
	public void setLawyerCourt_number(String lawyerCourtNumber) {
		lawyerCourt_number = lawyerCourtNumber;
	}

	
	
}
