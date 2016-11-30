package com.lawyer.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.Filelibrary;
import com.lawyer.pojo.Files;
import com.lawyer.pojo.Users;
import com.lawyer.service.FilesService;
import com.lawyer.service.PagingService;
import com.lawyer.tools.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FilesAction extends ActionSupport {
	private Files files1;
	private FilesService filesService;
	private List<Files> list;
	private int id;
	private int fid;
	private Filelibrary filelibrary;
	private String starttime = "";
	private String endtime = "";
	private static final long serialVersionUID = 1L;
	private static final int BUFFERED_SIZE = 60 * 1024;

	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String imageFiles;

	private static String DOWNLOADFILEPATH = "/uploads/";
	private String fileName;
	private PageBean pageBean;
	private int page=1;
	private PagingService pagingService;

	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public Filelibrary getFilelibrary() {
		return filelibrary;
	}
	public void setFilelibrary(Filelibrary filelibrary) {
		this.filelibrary = filelibrary;
	}
	public PagingService getPagingService() {
		return pagingService;
	}
	public void setPagingService(PagingService pagingService) {
		this.pagingService = pagingService;
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
	public String list() {
		HttpServletRequest req=ServletActionContext.getRequest();
		files1.setFilelibrary(this.filesService.loadById(files1.getFId()));
		String i=req.getParameter("i");
		req.setAttribute("i", i);
		pageBean=this.pagingService.queryForPage(10, page, files1, i,starttime,endtime);		
		return SUCCESS;
	}
	public String selectFile() {
		HttpServletRequest req=ServletActionContext.getRequest();	
		files1.setFilelibrary(this.filesService.loadById(files1.getFId()));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(("").equals(starttime)){
			starttime = "1900年01月01日";
		}
		if(("").equals(endtime)){
			endtime = "2100年12月30日";
		}
		 Date resultDate;
		try {
			resultDate = simpleDateFormat.parse(starttime);
			 starttime  = sdf.format(resultDate);
			 resultDate = simpleDateFormat.parse(endtime);
			 endtime  = sdf.format(resultDate);
			
			String i=req.getParameter("i");
			if(i.equals("null")){
				pageBean=this.pagingService.queryForPage(10, page, "Files", i,starttime,endtime);
				req.setAttribute("i", i);
			}else{
				pageBean=this.pagingService.queryForPage(10, page, files1, i,starttime,endtime);
				req.setAttribute("i", i);
			}
			return SUCCESS;
		} catch (ParseException e) {
			e.printStackTrace();
			return ERROR;
		}
		
		
	}
	public String updateInput(){
		System.out.println(fid+"信息信息下");
		files1=this.filesService.filesById(fid);
		return SUCCESS;
	}
	public String update(){
		this.filesService.update(files1);
		return SUCCESS;
	}
	
	public String delete(){
		this.filesService.delete(fid);
		return SUCCESS;
	}
	/*
	 * 文件上传
	 */
	public String add() {
		SimpleDateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		
		if(uploadFileName != null){
			uploadFileName = df1.format(new Date())+"_"+uploadFileName;
			files1.setFAttach(uploadFileName);
			files1.setFReldate(df2.format(new Date()));
			files1.setUsers(user);
			files1.setFilelibrary(this.filesService.loadById(filelibrary.getFlId()));
			
			try {
				FileUtils.copyFile(upload, new File(ServletActionContext.getServletContext().getRealPath("/")+"\\uploads\\"+files1.getFType()+"\\"+uploadFileName));
//				FileUtils.copyFile(upload, new File("E:/uploads/"+files1.getFType()+"/"+uploadFileName));
				this.filesService.filesUpload(files1);
			} catch (IOException e1) {
				e1.printStackTrace();
				return ERROR;
			}
		}

		return SUCCESS;

	}

	private static void copy(File src, File target) {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new BufferedInputStream(new FileInputStream(src),
					BUFFERED_SIZE);
			out = new BufferedOutputStream(new FileOutputStream(target),
					BUFFERED_SIZE);
			byte[] b = new byte[BUFFERED_SIZE];
			while (in.read(b) > 0) {
				out.write(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * 文件下载
	 */

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public InputStream getInputStream() {
		return ServletActionContext.getServletContext().getResourceAsStream(
				DOWNLOADFILEPATH + fileName);
	}

	public String getDownloadChineseFileName() {

		String downloadChineseFileName = fileName;

		try {
			downloadChineseFileName = new String(downloadChineseFileName
					.getBytes(), "ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return downloadChineseFileName;
	}

	public String execute() {

		DOWNLOADFILEPATH = "/uploads/";
		return SUCCESS;
	}

	public Files getFiles1() {
		return files1;
	}

	public void setFiles1(Files files1) {
		this.files1 = files1;
	}

	public FilesService getFilesService() {
		return filesService;
	}

	public void setFilesService(FilesService filesService) {
		this.filesService = filesService;
	}

	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getImageFiles() {
		return imageFiles;
	}
	public void setImageFiles(String imageFiles) {
		this.imageFiles = imageFiles;
	}
	public List<Files> getList() {
		return list;
	}

	public void setList(List<Files> list) {
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

}
