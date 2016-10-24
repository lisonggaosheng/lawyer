package com.lawyer.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactFaxService;
import com.lawyer.service.FilesService;
import com.opensymphony.xwork2.ActionSupport;

public class ContactFaxAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private ContactFax contactFax = null;
	private ContactFaxService cfs = null;
	private File attach;
	private String attachFileName;
	private String attachContentType;
	private FilesService filesService;
	private Files file = new Files();
	private List<ContactFax> cflist;
	private String caseId;
	private String casecodeself;
	
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}
	
	public List<ContactFax> getCflist() {
		return cflist;
	}
	public void setCflist(List<ContactFax> cflist) {
		this.cflist = cflist;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public Files getFile() {
		return file;
	}
	public void setFile(Files file) {
		this.file = file;
	}
	public FilesService getFilesService() {
		return filesService;
	}
	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}
	
	public String showConFax(){
		try {
			contactFax=this.cfs.showConFax(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String selectConFax(){
		try {
			cflist = this.cfs.selectContactFax(contactFax);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 添加申请执行人联系信息--快递
	 * 郭志鹏
	 * @return
	 */
	public String insert(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddhhmmss");
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		try {
		
			Users admin=(Users) session.getAttribute("admin");
			contactFax.setUsers(admin);
			contactFax.setCfSavetime(sdf.format(new Date()));
			if(attachFileName != null){		
				attachFileName = df2.format(new Date())+attachFileName;
				contactFax.setCfAttach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath+"\\uploads\\案源文件库\\"+attachFileName));
			
				String ftitle = contactFax.getCfCasecodeself()+"-"+attachFileName;
				file.setFTitle(ftitle);
				file.setFType("案源文件");
				file.setFilelibrary(this.filesService.loadById(6));
				file.setFReldate(df1.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(admin);
				this.filesService.filesUpload(file);
			}
			if(contactFax!=null){
				this.cfs.insertContactFax(contactFax);
				return SUCCESS;
			}else{
				return "filed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	public ContactFax getContactFax() {
		return contactFax;
	}


	public void setContactFax(ContactFax contactFax) {
		this.contactFax = contactFax;
	}


	public ContactFaxService getCfs() {
		return cfs;
	}


	public void setCfs(ContactFaxService cfs) {
		this.cfs = cfs;
	}


	public File getAttach() {
		return attach;
	}
	public void setAttach(File attach) {
		this.attach = attach;
	}
	public String getAttachFileName() {
		return attachFileName;
	}
	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}
	public String getAttachContentType() {
		return attachContentType;
	}
	public void setAttachContentType(String attachContentType) {
		this.attachContentType = attachContentType;
	}
	
	
}
