package com.lawyer.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.SysTask;
import com.lawyer.service.UserTaskService;
import com.lawyer.tools.SendMsgUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SendSmsAction extends ActionSupport{
	
	private static final long serialVersionUID = 1086449867633030995L;
	
	private SysTask usertask;
	private int taskid;
	
	private String lawyername;
	private String lawyermobile;
	private String content;
	private String remindTime;
	
	private UserTaskService userTaskService;
	
	private int pagesize;
	List<SysTask> tasks;
	private int page;

	/**
	 * 发送短信提醒
	 * @return
	 * @throws Exception
	 */
	public String smsRemind() throws Exception{
		SysTask systask = userTaskService.getTask(taskid);
		
		String result = SendMsgUtil.send(systask.getLawyermobile(), systask.getLawyername(),
				systask.getContent(),systask.getRemindTime());
		String message="";
		if(result.equals("1")){
			message = "{'result':1,'message':'短信发送成功！'}";
		}else{
			message = "{'result':-1,'message':'短信发送失败！'}";
		}
		
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(message);
		out.flush();
		out.close();
		return null;
	}

	
	public String insertTasks() throws IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		
		SysTask task  = new SysTask();
		task.setLawyername(lawyername);
		task.setLawyermobile(lawyermobile);
		task.setContent(content);
		task.setRemindTime(remindTime);
		task.setTimes(0);
		task.setStatus(1);
		task.setSaveTime(sdf.format(new Date()));
		
		String message = null;
		try {
			usertask = (SysTask) userTaskService.insertUserTask(task);
			if(usertask.getId() > 0){
				message = "{'result':1,'message':'提醒内容保存成功，请到代办事项查看！'}";
			}else{
				message = "{'result':-1,'message':'提醒内容保存失败！'}";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(message);
		out.flush();
		out.close();
		return null;
	}
	
	public String selectTasks() {
		if (page == 0) {
			page = 1;
		}
		try {
			pagesize = this.userTaskService.selectUserTaskPageSize(usertask);
			pagesize = (pagesize-1)/10+1;
			if (page > pagesize) {
				page = pagesize;
			}
			tasks = this.userTaskService.selectUserTasks(page, usertask);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return "filed";
		}
	}

	public UserTaskService getUserTaskService() {
		return userTaskService;
	}

	public void setUserTaskService(UserTaskService userTaskService) {
		this.userTaskService = userTaskService;
	}


	public String getLawyername() {
		return lawyername;
	}
	public void setLawyername(String lawyername) {
		this.lawyername = lawyername;
	}
	public String getLawyermobile() {
		return lawyermobile;
	}
	public void setLawyermobile(String lawyermobile) {
		this.lawyermobile = lawyermobile;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRemindTime() {
		return remindTime;
	}

	public void setRemindTime(String remindTime) {
		this.remindTime = remindTime;
	}

	public SysTask getUsertask() {
		return usertask;
	}

	public void setUsertask(SysTask usertask) {
		this.usertask = usertask;
	}
	public int getPagesize() {
		return pagesize;
	}


	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}


	public List<SysTask> getTasks() {
		return tasks;
	}


	public void setTasks(List<SysTask> tasks) {
		this.tasks = tasks;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	
}
