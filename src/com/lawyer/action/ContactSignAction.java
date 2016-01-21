package com.lawyer.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.Addrecord;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.AddRecordService;
import com.lawyer.service.ContractSignService;
import com.lawyer.service.FilesService;
import com.opensymphony.xwork2.ActionSupport;

public class ContactSignAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private ContractSign contactSign = null;
	private ContractSignService css = null;
	private File attach;
	private String attachFileName;
	private String attachContentType;
	private FilesService filesService;
	private Files file = new Files();
	private String caseId;
	
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
	/**
	 * 添加申请执行人联系信息--快递
	 * 郭志鹏
	 * @return
	 */
	public String insert(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddhhmmss");
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		try {

			Users admin=(Users) session.getAttribute("admin");
			contactSign.setUsers(admin);
			contactSign.setCsCaseID(caseId);
			contactSign.setCsSavetime(sdf.format(new Date()));
			if(attachFileName != null){	
				attachFileName = df2.format(new Date())+attachFileName;
				contactSign.setCsAttach(attachFileName);
				FileUtils.copyFile(attach, new File(basePath+"\\uploads\\案源文件库\\"+attachFileName));
			
				String ftitle = contactSign.getCsCasecodeself()+"-"+attachFileName;
				file.setFTitle(ftitle);
				file.setFType("案源文件");
				file.setFilelibrary(this.filesService.loadById(6));
				file.setFReldate(df1.format(new Date()));
				file.setFAttach(attachFileName);
				file.setUsers(admin);
				this.filesService.filesUpload(file);
			}
		
			if(contactSign!=null){
				this.css.insertContractSign(contactSign);	
				return SUCCESS;
			}else{
				return "filed";
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}


	public ContractSign getContactSign() {
		return contactSign;
	}


	public void setContactSign(ContractSign contactSign) {
		this.contactSign = contactSign;
	}


	public ContractSignService getCss() {
		return css;
	}


	public void setCss(ContractSignService css) {
		this.css = css;
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
