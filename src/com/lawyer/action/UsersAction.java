package com.lawyer.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.LimitPower;
import com.lawyer.pojo.Log;
import com.lawyer.pojo.PageBean;
import com.lawyer.pojo.Users;
import com.lawyer.service.LimitPowerService;
import com.lawyer.service.LogService;
import com.lawyer.service.PageService;
import com.lawyer.service.UsersService;
import com.lawyer.tools.ObjAndList2Json;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	//封装的limitpower服务层接口
	private LimitPowerService lpService;
	//:封装的Users服务层接口
	private UsersService usersService;
	//:封装的普通用户用Users对象
	private Users users;
	//:封装的管理员用Users对象
	private Users admin;
	
	
	public LimitPowerService getLpService() {
		return lpService;
	}

	public void setLpService(LimitPowerService lpService) {
		this.lpService = lpService;
	}

	public Users getAdmin() {
		return admin;
	}

	public void setAdmin(Users admin) {
		this.admin = admin;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
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

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	public UsersService getUsersService() {
		return usersService;
	}
	//用户对应的权限对象
	private LimitPower lp;
	
	public LimitPower getLp() {
		return lp;
	}

	public void setLp(LimitPower lp) {
		this.lp = lp;
	}
	//操作结果
	private String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 根据用户名查询用户的权限
	 */
	public String findlp(){
		lp = lpService.findLPByUserName(lp.getLp_user_name());
		return SUCCESS;
	}
	/**
	 * 修改用户权限
	 * @return
	 */
	public String updlp(){
		lpService.updLP(lp);
		result="用户权限保存成功！";
		return SUCCESS;
	}
	/**
	 * 管理员与用户登陆验证方法
	 * */
	public String login() {
		//:得到一个Session对象
		HttpSession session=ServletActionContext.getRequest().getSession();
		try {
			admin=usersService.login(admin);
			if(admin!=null){
		//		System.out.println(admin+"=============>"+admin.getURole());
				if(admin.getURole().equals("管理员")){
					session.setAttribute("admin", admin);
					return "admin";
				}else {
					if(admin.getUSta().equals("启用")){
						//查询用户的权限放入session中 
						LimitPower userlp = lpService.findLPByUserName(admin.getUName());
						session.setAttribute("admin", admin);
						session.setAttribute("userlp", userlp);
						return "users";
					}else{
						return "fali";
					}
				}
			}else{
				return "fali";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "fali";
		}
	}

	/**
	 * 管理员与用户退出方法
	 * */
	public String quit(){
		try {
			ServletActionContext.getRequest().getSession().setAttribute("admin", null);
			ServletActionContext.getRequest().getSession().setAttribute("userlp", null);
			return "quit";
		} catch (Exception e) {
			e.printStackTrace();
			return "quit";
		}
	}
	
	/**
	 * 管理员添加用户方法，添加完成查询所有用户信息，跳转至SHOW页面，分页显示
	 * */
	public String insert(){
		try {
			//:管理员添加用户记录
			admin = usersService.SelectID(admin);
			usersService.insert(users);
			//为用户添加对应的权限
			lpService.addLP(new LimitPower(users.getUName(),"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"));
			
			/**
			 * 添加完成后，到所有用户显示页面
			 * */
			pageBean=pageService.queryForPage(5,page,"Users","UId","where UName <> 'admin'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}

	/**
	 * 分页显示所有用户信息，倒叙
	 * */
	public String SelectShow(){
		try {
			//:管理员查询用户记录
			admin = (Users) ServletActionContext.getRequest().getSession().getAttribute("admin");

			pageBean=pageService.queryForPage(10,page,"Users","UId","where UName <> 'admin'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}
	
	/**
	 * 通过用户名模糊查询
	 * */
	public String selectName(){
		try {
			//:管理员查询用户记录
			list=usersService.selectName(users);
			return "usersShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersShow";
		}
	}
	/**
	 * 管理员修改用户信息(1),通过发送的要修改用户ID，得到用户所有信息，发送到修改页面
	 * */
	public String update1(){
		try {
			users=usersService.SelectID(users);
			return "update1";
		} catch (Exception e) {
			e.printStackTrace();
			return "update1";
		}
	} 
	/**
	 * 管理员修改用户信息(2),修改用户信息，完成后模糊查询用户信息，跳转至SHOW页面，分页显示
	 * */
	public String update2(){
		try {
			usersService.update(users);
			list=usersService.selectName(users);
			return "usersShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersShow";
		}
	}
	/**
	 * 通过ID删除用户信息
	 * */
	public String delete(){
		
		try {
			users=usersService.SelectID(users);
			//删除用户权限
			lpService.removeLP(lpService.findLPByUserName(users.getUName()));
			usersService.delete(users);
			pageBean=pageService.queryForPage(5,page,"Users","UId","where UName <> 'admin'");
			return "show";
		} catch (Exception e) {
			e.printStackTrace();
			return "show";
		}
	}
	/**
	 * 通过ID修改用户账号状态
	 * */
	public String updateUSta(){
		try {
			
			users=usersService.SelectID(users);
			if(users.getUSta().equals("启用")){
				users.setUSta("禁用");
			}else{
				users.setUSta("启用");
			}
			usersService.update(users);
			list=usersService.selectName(users);
			return "usersShow";
		} catch (Exception e) {
			e.printStackTrace();
			return "usersShow";
		}
	}
	
	/**
	 * 分页显示所有用户信息，倒叙
	 * @throws Exception 
	 * */
	public String selectLawyers() throws Exception{
		List<Users> lawuers = usersService.selectLawyers();
		
		String jsonarr = ObjAndList2Json.list2jsonarr(lawuers);
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonarr);
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 分页显示所有用户信息，倒叙
	 * @throws Exception 
	 * */
	public String selectPensons() throws Exception{
		List<Users> lawuers = usersService.selectPensons();
		
		String jsonarr = ObjAndList2Json.list2jsonarr(lawuers);
		HttpServletResponse response =  ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(jsonarr);
		out.flush();
		out.close();
		return null;
	}
}