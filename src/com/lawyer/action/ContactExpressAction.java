package com.lawyer.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactExpressService;
import com.lawyer.service.FilesService;
import com.opensymphony.xwork2.ActionSupport;

public class ContactExpressAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private ContactExpress contactExpress = null;
	private ContactExpressService ces = null;
	private File attach;
	private String attachFileName;
	private String attachContentType;	
	private FilesService filesService;
	private Files file = new Files();
	private String caseId;
	private List<ContactExpress> celist;
	private String casecodeself;
	
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}
	
	public List<ContactExpress> getCelist() {
		return celist;
	}
	public void setCelist(List<ContactExpress> celist) {
		this.celist = celist;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	
	public FilesService getFilesService() {
		return filesService;
	}
	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}
	public Files getFile() {
		return file;
	}
	public void setFile(Files file) {
		this.file = file;
	}
	
	public String showConExpress(){
		try {
			contactExpress=this.ces.showConExpress(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String selectConExpress(){
		try {
			celist = this.ces.selectContactExpress(contactExpress);
			return SUCCESS;
		}catch (Exception e) {
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
			contactExpress.setUsers(admin);
			contactExpress.setCeSavetime(sdf.format(new Date()));
			if(attachFileName != null){
				attachFileName = df2.format(new Date())+attachFileName;
				contactExpress.setCeAttach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath+"\\uploads\\案源文件库\\"+attachFileName));
				
				String ftitle = System.currentTimeMillis()+"-"+attachFileName;
				file.setFTitle(ftitle);
				file.setFType("案源文件");
				file.setFilelibrary(this.filesService.loadById(6));
				file.setFReldate(df1.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(admin);
				file.setCasecodeself(contactExpress.getCeCasecodeself());
				this.filesService.filesUpload(file);
			}
			if(contactExpress!=null){
				this.ces.insertContactExpress(contactExpress);
				return SUCCESS;
			}else{
				return "filed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	
	public ContactExpress getContactExpress() {
		return contactExpress;
	}


	public void setContactExpress(ContactExpress contactExpress) {
		this.contactExpress = contactExpress;
	}


	public ContactExpressService getCes() {
		return ces;
	}


	public void setCes(ContactExpressService ces) {
		this.ces = ces;
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
