package com.lawyer.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.Filelibrary;
import com.lawyer.pojo.LawyerCourt;
import com.lawyer.service.FilelibraryService;
import com.lawyer.service.PagingService;
import com.lawyer.tools.PageBean;
import com.opensymphony.xwork2.ActionSupport;

public class FilelibraryAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private Filelibrary filelibrary;
	private FilelibraryService filelibraryService;
	private List<Filelibrary> flist;
	private int id;
	private PageBean pageBean;
	private int page=1;
	private PagingService pagingService;
	private String starttime;
	private String endtime;

	public PagingService getPagingService() {
		return pagingService;
	}
	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
	}
	public String add(){
		this.filelibraryService.add(filelibrary);
		return SUCCESS;
	}
	public String list(){
		HttpServletRequest req=ServletActionContext.getRequest();
		String i=req.getParameter("i");
		pageBean=this.pagingService.queryForPage(10, page, "Filelibrary", i, starttime,endtime);
		req.setAttribute("i", i);
		return SUCCESS;
	}
	
	public String getList() {
		//查找所有的文件库
		flist = (List<Filelibrary>) filelibraryService.findAllFilelibrary();
		return SUCCESS;
	}
	public String updateInput(){
		filelibrary=this.filelibraryService.updateInput(id);
		return SUCCESS;
	}
	public String update(){
		this.filelibraryService.update(filelibrary);
		return SUCCESS;
	}
	public String delete(){
		this.filelibraryService.delete(id);
		return SUCCESS;
	}
	
	public String selectFilelibrary(){	
		HttpServletRequest req=ServletActionContext.getRequest();
		String i=req.getParameter("i");
		if(i.equals("null")){
			pageBean=this.pagingService.queryForPage(10, page, "Filelibrary", i, starttime,endtime);
			req.setAttribute("i", i);
		}else{
			pageBean=this.pagingService.queryForPage(10, page, filelibrary, i, starttime,endtime);
			req.setAttribute("i", i);
		}	
		return SUCCESS;
	}
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setList(List<Filelibrary> list) {
		this.flist = list;
	}
	public Filelibrary getFilelibrary() {
		return filelibrary;
	}
	public void setFilelibrary(Filelibrary filelibrary) {
		this.filelibrary = filelibrary;
	}
	public FilelibraryService getFilelibraryService() {
		return filelibraryService;
	}
	public void setFilelibraryService(FilelibraryService filelibraryService) {
		this.filelibraryService = filelibraryService;
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
	
}
