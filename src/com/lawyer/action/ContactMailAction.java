package com.lawyer.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactMailService;
import com.lawyer.service.FilesService;
import com.opensymphony.xwork2.ActionSupport;

public class ContactMailAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private ContactMail contactMail = null;
	private ContactMailService contactMailService = null;
	private File attach;
	private String attachFileName;
	private String attachContentType;
	private FilesService filesService;
	private Files file = new Files();
	private List<ContactMail> cms;
	
	private String caseId;
	private String casecodeself;
	
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}
	public List<ContactMail> getCms() {
		return cms;
	}
	public void setCms(List<ContactMail> cms) {
		this.cms = cms;
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
	public String getAttachFileName() {
		return attachFileName;
	}
	public String getAttachContentType() {
		return attachContentType;
	}
	public ContactMail getContactMail() {
		return contactMail;
	}
	public void setContactMail(ContactMail contactMail) {
		this.contactMail = contactMail;
	}
	public ContactMailService getContactMailService() {
		return contactMailService;
	}
	public void setContactMailService(ContactMailService contactMailService) {
		this.contactMailService = contactMailService;
	}
	public File getAttach() {
		return attach;
	}
	public void setAttach(File attack) {
		this.attach = attack;
	}
	public String getAttackFileName() {
		return attachFileName;
	}
	public void setAttachFileName(String attackFileName) {
		this.attachFileName = attackFileName;
	}
	public String getAttackContentType() {
		return attachContentType;
	}
	public void setAttachContentType(String attackContentType) {
		this.attachContentType = attackContentType;
	}
	
	public String showConMail(){
		try {
			contactMail=this.contactMailService.showConMail(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	/**
	 * 添加申请执行人联系信息--电子邮件
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
			contactMail.setUsers(admin);
			contactMail.setCmSavetime(sdf.format(new Date()));
			if(attachFileName != null){
				attachFileName = df2.format(new Date())+attachFileName;
				contactMail.setCmAttach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath+"\\uploads\\案源文件库\\"+attachFileName));
				String ftitle = contactMail.getCmCasecodeself()+"-"+attachFileName;
				file.setFTitle(ftitle);
				file.setFType("案源文件");
				file.setFilelibrary(this.filesService.loadById(6));
				file.setFReldate(df1.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(admin);
				this.filesService.filesUpload(file);
			}
			if(contactMail!=null){
				this.contactMailService.insertContactMail(contactMail);
	
				return SUCCESS;
			}else{
				return "filed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String selectConMail(){
		try {
			cms = this.contactMailService.selectContactMail(contactMail);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
}
