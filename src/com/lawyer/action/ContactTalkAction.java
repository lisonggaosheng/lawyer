package com.lawyer.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ContactTalk;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactTalkService;
import com.lawyer.service.FilesService;
import com.opensymphony.xwork2.ActionSupport;

public class ContactTalkAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private ContactTalk contactTalk = null;
	private ContactTalkService contactTalkService ;
	private File attach;
	private String attachFileName;
	private String attachContentType;
	private FilesService filesService;
	private Files file = new Files();
	private String caseId;
	private List<ContactTalk> contactTalkList;
	private String casecodeself;
	
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
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
	
	public ContactTalk getContactTalk() {
		return contactTalk;
	}
	public void setContactTalk(ContactTalk contactTalk) {
		this.contactTalk = contactTalk;
	}
	public ContactTalkService getContactTalkService() {
		return contactTalkService;
	}
	public void setContactTalkService(ContactTalkService contactTalkService) {
		this.contactTalkService = contactTalkService;
	}
	public List<ContactTalk> getContactTalkList() {
		return contactTalkList;
	}
	public void setContactTalkList(List<ContactTalk> contactTalkList) {
		this.contactTalkList = contactTalkList;
	}
	
	public String showConTalk(){
		try {
			contactTalk=this.contactTalkService.showConTalk(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String selectConTalk(){
		try {
			contactTalkList = this.contactTalkService.selectContactTalk(contactTalk);
			
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
			System.out.println("开始添加申请执行人联系信息--快递");
			Users admin=(Users) session.getAttribute("admin");
			contactTalk.setUsers(admin);
			contactTalk.setCtSavetime(sdf.format(new Date()));
			if(attachFileName != null){	
				attachFileName = df2.format(new Date())+attachFileName;
				contactTalk.setCtAttach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath+"\\uploads\\案源文件库\\"+attachFileName));
			
				String ftitle = contactTalk.getCtCasecodeself()+"-"+attachFileName;
				file.setFTitle(ftitle);
				file.setFType("案源文件");
				file.setFilelibrary(this.filesService.loadById(6));
				file.setFReldate(df1.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(admin);
				this.filesService.filesUpload(file);
			}
	
			if(contactTalk!=null){
				this.contactTalkService.insertContactTalk(contactTalk);	
				return SUCCESS;
			}else{
				return "filed";
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
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
