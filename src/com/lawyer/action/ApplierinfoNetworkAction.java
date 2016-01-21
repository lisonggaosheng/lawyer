package com.lawyer.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplierinfoNetworkService;
import com.opensymphony.xwork2.ActionSupport;

public class ApplierinfoNetworkAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ApplierinfoNetwork applierinfoNetwork;
	private List<ApplierinfoNetwork> appnets;
	private ApplierinfoNetworkService appNetService;
	private String caseId;

	public String getCaseId() {
		return caseId;
	}

	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}

	public List<ApplierinfoNetwork> getAppnets() {
		return appnets;
	}

	public void setAppnets(List<ApplierinfoNetwork> appnets) {
		this.appnets = appnets;
	}

	public ApplierinfoNetworkService getAppNetService() {
		return appNetService;
	}

	public void setAppNetService(ApplierinfoNetworkService appNetService) {
		this.appNetService = appNetService;
	}

	public ApplierinfoNetwork getApplierinfoNetwork() {
		return applierinfoNetwork;
	}

	public void setApplierinfoNetwork(ApplierinfoNetwork applierinfoNetwork) {
		this.applierinfoNetwork = applierinfoNetwork;
	}

	/**
	 * 修改 第三步--网络部分
	 * 
	 */
	public String update() {
		try {
			this.appNetService.updateAppnet(applierinfoNetwork);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 删除 第三步--网络部分
	 * 
	 */
	public String delete() {
		try {
			this.appNetService.deleteAppnet(applierinfoNetwork);

			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 案源第三步--添加申请执行人企业信息 --网络信息 郭志鹏
	 * 
	 * @return
	 */
	public String insert() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			System.out.println("开始添加申请执行人企业信息--网络信息");
			Users admin = (Users) session.getAttribute("admin");
			applierinfoNetwork.setUsers(admin);
			applierinfoNetwork.setAnSavetime(sdf.format(new Date()));
			this.appNetService.insertAppnet(applierinfoNetwork);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String insertAppnetOne(){
		try {
			this.appNetService.insertAppnetOne(applierinfoNetwork);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 批处理申请执行人企业信息（网络信息）——郭志鹏
	 * 
	 * @return
	 */
	public String insertMore() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users user = (Users) session.getAttribute("admin");
		try {
			this.appNetService.insertAppNets(user);

			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("批处理数据完成！");
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public String selectAllAppNet() {
		try {
			appnets = this.appNetService.selectAppnet(applierinfoNetwork);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
