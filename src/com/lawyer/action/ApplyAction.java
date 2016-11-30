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

public class ApplyAction extends ActionSupport{
	
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
	
	
	public UsersService getUsersService() {
		return usersService;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
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

	public Apply getApply() {
		return apply;
	}

	public void setApply(Apply apply) {
		this.apply = apply;
	}

	public ApplyService getApplyService() {
		return applyService;
	}

	public void setApplyService(ApplyService applyService) {
		this.applyService = applyService;
	}
	
	/**
	 * 分页显示所有用户申请信息
	 * 刘腾升
	 * */
	public String selectShow(){
		try {
			//:管理员查询所有用户申请信息记录
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("查询");
			log.setLogTarget("所有用户申请信息");
			logService.insert(log);
			pageBean=pageService.queryForPage(5,page,"Apply","appId","where appSta = '申请中'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}
	/**
	 *通过用户名模糊查询申请信息(***********************************************)
	 *刘腾升
	 * */
	public String selectName(){
		try {
			//:管理员查询所有用户申请信息记录
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("模糊查询");
			log.setLogTarget("用户申请信息");
			logService.insert(log);
			
			list=applyService.selectName(users);
			return "applyShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "applyShow";
		}
	}
	/**
	 * 通过用户ID批准授权
	 * 刘腾升
	 * */
	public String authorize(){
		//:管理员查询所有用户申请信息记录
		try {
			admin= usersService.SelectID(admin);
			users=usersService.SelectID(users);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("批准");
			log.setLogTarget("用户"+users.getUName()+"的申请");
			logService.insert(log);
			
			apply=applyService.selectID(apply);
			apply.setAppSta("已批准");
			applyService.authorize(apply);
			list=applyService.selectName(users);
			return "authorize";
		} catch (Exception e) {
			e.printStackTrace();
			return "authorize";
		}
	}
	/**
	 * 通过用户ID拒绝授权
	 * 刘腾升
	 * */
	public String decline(){
		//:管理员查询所有用户申请信息记录
		try {
			admin= usersService.SelectID(admin);
			users=usersService.SelectID(users);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("拒绝");
			log.setLogTarget("用户"+users.getUName()+"的申请");
			logService.insert(log);
			
			apply=applyService.selectID(apply);
			applyService.decline(apply);
			list=applyService.selectName(users);
			return "decline";
		} catch (Exception e) {
			e.printStackTrace();
			return "decline";
		}
	}
	/**
	 * 查询用户所有权限
	 * 刘腾升
	 * */
	public String declineShow(){
		try {
			//:管理员查询所有用户申请信息记录
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("查询");
			log.setLogTarget("所有用户权限信息");
			logService.insert(log);
			pageBean=pageService.queryForPage(5,page,"Apply","appId","where appSta = '已批准'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}
	/**
	 *通过用户名模糊查询申请信息2(***********************************************)
	 *刘腾升
	 * */
	public String selectName2(){
		try {
			//:管理员查询所有用户申请信息记录
			admin= usersService.SelectID(admin);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("模糊查询");
			log.setLogTarget("用户权限信息");
			logService.insert(log);
			
			list=applyService.selectName2(users);
			System.out.println(list);
			return "applyShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "applyShow";
		}
	}
	/**
	 * 通过用户ID拒绝授权
	 * 刘腾升
	 * */
	public String declineUsers(){
		//:管理员查询所有用户申请信息记录
		try {
			admin= usersService.SelectID(admin);
			users=usersService.SelectID(users);
			log=new Log();
			log.setLogDate(logService.getDataTime());
			log.setLogUid(admin.getUId());
			log.setLogUname(admin.getUName());
			log.setLogUrole(admin.getURole());
			log.setLogContent("收回");
			log.setLogTarget("用户"+users.getUName()+"的权限");
			logService.insert(log);
			
			apply=applyService.selectID(apply);
			applyService.decline(apply);
			pageBean=pageService.queryForPage(5,page,"Apply","appId","where appSta = '已批准'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}

}
