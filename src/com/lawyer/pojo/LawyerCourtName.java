package com.lawyer.pojo;

import java.io.Serializable;
/**
 * @date 2013-4-13 15:18:58
 * @author 李梦翔
 *	法院表对应的实体名称类
 */
public class LawyerCourtName implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer court_id;
	private String same_name;
	
	public LawyerCourtName() {
		super();
	}
	public LawyerCourtName(Integer court_id, String same_name) {
		super();
		this.court_id = court_id;
		this.same_name = same_name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCourt_id() {
		return court_id;
	}
	public void setCourt_id(Integer court_id) {
		this.court_id = court_id;
	}
	public String getSame_name() {
		return same_name;
	}
	public void setSame_name(String same_name) {
		this.same_name = same_name;
	}
	
	
}
