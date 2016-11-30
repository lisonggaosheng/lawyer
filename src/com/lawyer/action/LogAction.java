package com.lawyer.action;

import java.util.List;

import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Log;
import com.lawyer.pojo.PageBean;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplyService;
import com.lawyer.service.LogService;
import com.lawyer.service.PageService;
import com.lawyer.service.UsersService;
import com.opensymphony.xwork2.ActionSupport;

public class LogAction extends ActionSupport{
	//:封装的Apply对象Service接口
	private ApplyService applyService;
	//:封装的Apply对象
	private Apply apply;
	
	//:封装的Users服务层接口
	private UsersService usersService;
	//:封装的普通用户用Users对象
	private Users users;
	//:封装的管理员用Users对象
	private Users admin;
	//:封装的Log服务层接口
	private LogService logService;
	//:封装的Log对象
	private Log log;
	
	//:封装的List对象
	private List list;
	/**
	 * 通用分页方法所用封装属性
	 * 刘腾升
	 * */
	private PageService pageService;
	private PageBean pageBean;
	private int page;
	public ApplyService getApplyService() {
		return applyService;
	}
	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}
	public Apply getApply() {
		return apply;
	}
	public void setApply(Apply apply) {
		this.apply = apply;
	}
	public UsersService getUsersService() {
		return usersService;
	}
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Users getAdmin() {
		return admin;
	}
	public void setAdmin(Users admin) {
		this.admin = admin;
	}
	public LogService getLogService() {
		return logService;
	}
	public void setLogService(LogService logService) {
		this.logService = logService;
	}
	public Log getLog() {
		return log;
	}
	public void setLog(Log log) {
		this.log = log;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public PageService getPageService() {
		return pageService;
	}
	public void setPageService(PageService pageService) {
		this.pageService = pageService;
	}
	public PageBean getPageBean() {
		return pageBean;
	}
	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	/**
	 * 查询所有用户日志记录，分页显示
	 * 刘腾升
	 * */
	public String showUsersLog(){
		try {
			//:管理员查询所有用户申请信息记录
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("查询");
			log.setLogTarget("所有用户操作信息");
			logService.insert(log);
			
			pageBean=pageService.queryForPage(5,page,"Log","logId","where logUrole = '普通用户'");
			return "usersLog";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersLog";
		}
	}
	/**
	 * 通过用户名迷糊查询用户日志记录
	 * 刘腾升
	 * */
	public String selectUsersName(){
		//:管理员查询所有用户申请信息记录
		try {
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("模糊查询");
			log.setLogTarget("用户操作信息");
			logService.insert(log);
			
			list=logService.selectUsersName(users);
			return "usersName";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersName";
		}
	}
	/**
	 * 查询所有管理员日志记录，分页显示
	 * 刘腾升
	 * */
	public String showAdminLog(){
		//:管理员查询所有用户申请信息记录
		try {
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("查询");
			log.setLogTarget("所有管理员操作信息");
			logService.insert(log);
			
			pageBean=pageService.queryForPage(5,page,"Log","logId","where logUrole = '管理员'");
			return "adminLog";
		} catch (Exception e) {
			e.printStackTrace();
			return "adminLog";
		}
	}
	/**
	 * 通过用户名迷糊查询用户日志记录
	 * 刘腾升
	 * */
	public String selectAdminName(){
		//:管理员查询所有用户申请信息记录
		try {
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("模糊查询");
			log.setLogTarget("管理员操作信息");
			logService.insert(log);
			
			list=logService.selectUsersName2(users);
			return "adminName";
		} catch (Exception e) {
			e.printStackTrace();
			return "adminName";
		}
	}
	
}
