package com.lawyer.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactTelService;
import com.lawyer.service.FilesService;
import com.opensymphony.xwork2.ActionSupport;

public class ContactTelAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ContactTel contactTel = null;
	private ContactTelService cts = null;
	private File attach;
	private String attachFileName;
	private String attachContentType;
	private FilesService filesService;
	private Files file = new Files();
	private String caseId;
	private List<ContactTel> ctels;
	private String casecodeself;
	
	public String getCasecodeself() {
		return casecodeself;
	}
	public void setCasecodeself(String casecodeself) {
		this.casecodeself = casecodeself;
	}

	public List<ContactTel> getCtels() {
		return ctels;
	}

	public void setCtels(List<ContactTel> ctels) {
		this.ctels = ctels;
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
	
	public String showConTel(){
		try {
			contactTel=this.cts.showConTel(casecodeself);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String selectConTel(){
		try {
			ctels = this.cts.selectContactTel(contactTel);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	/**
	 * 添加申请执行人联系信息--电话联系 郭志鹏
	 * 
	 * @return
	 */
	public String insert() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy年MM月dd日");
		String basePath = ServletActionContext.getServletContext().getRealPath(
				"/");
		try {
			Users admin = (Users) session.getAttribute("admin");
			System.out.println(admin.getUName());
			contactTel.setUsers(admin);
			contactTel.setCtSavetime(sdf.format(new Date()));
			if (attachFileName != null) {
				String fAttach = System.currentTimeMillis()+"_"+attachFileName;
				contactTel.setCtAttach(fAttach);
				FileUtils.copyFile(attach, new File(basePath
						+ "\\fileUploads\\anyuan\\" + fAttach));
				file.setFTitle(attachFileName);
				file.setFType("anyuan");
				file.setFilelibrary(this.filesService.loadById(1001));
				file.setFReldate(df1.format(new Date()));
				file.setFAttach(fAttach);
				file.setUsers(admin);
				file.setCasecodeself(contactTel.getCtCasecodeself());
				file.setRemark(contactTel.getCtCasecodeself()+"案源电话联系信息文件");
				this.filesService.filesUpload(file);
			}

			if (contactTel != null) {
				this.cts.insertContactTel(contactTel);

				return SUCCESS;
			} else {
				return "filed";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public ContactTel getContactTel() {
		return contactTel;
	}

	public void setContactTel(ContactTel contactTel) {
		this.contactTel = contactTel;
	}

	public ContactTelService getCts() {
		return cts;
	}

	public void setCts(ContactTelService cts) {
		this.cts = cts;
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
