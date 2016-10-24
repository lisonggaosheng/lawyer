package com.lawyer.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactSeeService;
import com.lawyer.service.FilesService;
import com.opensymphony.xwork2.ActionSupport;

public class ContactSeeAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private ContactSee contactSee = null;
	private ContactSeeService css ;
	private File attach;
	private String attachFileName;
	private String attachContentType;
	private FilesService filesService;
	private Files file = new Files();
	private String caseId;
	private List<ContactSee> cseelist;
	private String casecodeself;
	
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}
	
	public List<ContactSee> getCseelist() {
		return cseelist;
	}
	public void setCseelist(List<ContactSee> cseelist) {
		this.cseelist = cseelist;
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
	public ContactSee getContactSee() {
		return contactSee;
	}
	public void setContactSee(ContactSee contactSee) {
		this.contactSee = contactSee;
	}
	public ContactSeeService getCss() {
		return css;
	}
	public void setCss(ContactSeeService css) {
		this.css = css;
	}
	
	public String showConSee(){
		try {
			contactSee=this.css.showConSee(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String selectConSee(){
		try {
			cseelist = this.css.selectContactSee(contactSee);
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
			contactSee.setUsers(admin);
			contactSee.setCsSavetime(sdf.format(new Date()));
			if(attachFileName != null){	
				attachFileName = df2.format(new Date())+attachFileName;
				contactSee.setCsAttach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath+"\\uploads\\案源文件库\\"+attachFileName));
			
				String ftitle = contactSee.getCsCasecodeself()+"-"+attachFileName;
				file.setFTitle(ftitle);
				file.setFType("案源文件");
				file.setFilelibrary(this.filesService.loadById(6));
				file.setFReldate(df1.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(admin);
				this.filesService.filesUpload(file);
			}
	
			if(contactSee!=null){
				this.css.insertContactSee(contactSee);				
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
