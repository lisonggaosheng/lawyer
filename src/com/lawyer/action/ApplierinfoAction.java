package com.lawyer.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.Addrecord;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;
import com.lawyer.service.AddRecordService;
import com.lawyer.service.ApplierinfoService;
import com.lawyer.tools.ExcelTools;
import com.opensymphony.xwork2.ActionSupport;

public class ApplierinfoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Applierinfo applierinfo = null;
	private ApplierinfoService appinfoService = null;
	private AddRecordService ars;		//record对象的service类
	private Addrecord record = new Addrecord();			//封装Addrecord对象
	private List<Applierinfo> applierinfos;
	
	private File upd;// 上传的文件在缓存
	private String updFileName;// 文件名
	private String updContentType;// 文件类型
	
	private String caseId;
	
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public List<Applierinfo> getApplierinfos() {
		return applierinfos;
	}
	public void setApplierinfos(List<Applierinfo> applierinfos) {
		this.applierinfos = applierinfos;
	}
	public AddRecordService getArs() {
		return ars;
		
		
	}
	public void setArs(AddRecordService ars) {
		this.ars = ars;
	}
	public Addrecord getRecord() {
		return record;
	}
	public void setRecord(Addrecord record) {
		this.record = record;
	}
	public Applierinfo getApplierinfo() {
		return applierinfo;
	}
	public void setApplierinfo(Applierinfo applierinfo) {
		this.applierinfo = applierinfo;
	}
	public ApplierinfoService getAppinfoService() {
		return appinfoService;
	}
	public void setAppinfoService(ApplierinfoService appinfoService) {
		this.appinfoService = appinfoService;
	}
	public File getUpd() {
		return upd;
	}
	public void setUpd(File upd) {
		this.upd = upd;
	}
	public String getUpdFileName() {
		return updFileName;
	}
	public void setUpdFileName(String updFileName) {
		this.updFileName = updFileName;
	}
	public String getUpdContentType() {
		return updContentType;
	}
	public void setUpdContentType(String updContentType) {
		this.updContentType = updContentType;
	}
	
	/*
	 * excel导入更新申请人信息
	 */
	public String excelUpdateApplierinfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		Connection conn = null;
		try {
			if(updFileName != null){
				String path = basePath+"\\impExcel\\"+updFileName;
				FileUtils.copyFile(upd, new File(path));
				
				List<Applierinfo> dataList = new ArrayList<Applierinfo>();
				
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(path));
				// 在Excel文档中，第一张工作表的缺省索引是0
				HSSFSheet sheet = workbook.getSheetAt(0);
				// 获取到Excel文件中的所有行数
				int rows = sheet.getPhysicalNumberOfRows();
				// 遍历行
				for (int i = 1; i < rows; i++) {
					HSSFRow row = sheet.getRow(i);
					if (row != null) {
						// 获取到Excel文件中的所有的列
//						int cells = row.getPhysicalNumberOfCells();
						Applierinfo applierinfo = new Applierinfo();
						
						HSSFCell namecell = row.getCell(0);
						HSSFCell repnamecell = row.getCell(1);
		                HSSFCell statuscell = row.getCell(2);
		                if (namecell == null) {
		                    continue;
		                }
		                applierinfo.setAppName(ExcelTools.getValue(namecell));
		                if(repnamecell != null){
		                	applierinfo.setAppRepname(ExcelTools.getValue(repnamecell));
		                }else{
		                	applierinfo.setAppRepname("");
		                }
		                if(statuscell != null){
		                	applierinfo.setAppStatus(ExcelTools.getValue(statuscell));
		                }else{
		                	applierinfo.setAppStatus("");
		                }
						
						dataList .add(applierinfo);
					}
				}
				
				this.appinfoService.excelUpdateApplierinfo(dataList);
				request.setAttribute("message","excel导入申请人信息更新成功");
				return SUCCESS;
			}else{
				request.setAttribute("message","excel导入申请人信息文件上传失败");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.setAttribute("message","excel更新申请人信息失败");
				return SUCCESS;
			} catch (Exception e1) {
				e1.printStackTrace();
				return SUCCESS;
			}
		}
	}
	
	/*
	 * excel导入申请人信息
	 */
	public String excelInsertApplierinfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		try {
			if(updFileName != null){
				String path = basePath+"\\impExcel\\"+updFileName;
				FileUtils.copyFile(upd, new File(path));
				
				// 获取数据
				List<Applierinfo> dataList = new ArrayList<Applierinfo>();
				InputStream is = new FileInputStream(path);
				HSSFWorkbook workbook = new HSSFWorkbook(is);
				//在Excel文档中，第一张工作表的缺省索引是0
				HSSFSheet sheet = workbook.getSheetAt(0);
				// 获取到Excel文件中的所有行数
				int rows = sheet.getPhysicalNumberOfRows();
				// 遍历行
				for (int i = 1; i < rows; i++) {
					// 读取左上端单元格
					HSSFRow row = sheet.getRow(i);
					// 行不为空
					if (row != null) {
						HSSFCell pname = row.getCell(0);;
						HSSFCell casecode = row.getCell(1);;
						HSSFCell appName = row.getCell(2);
						HSSFCell appAddress = row.getCell(3);
						if(ExcelTools.getValue(pname) == null || ExcelTools.getValue(pname).length() ==0){
							break;
						}
						
						Applierinfo applierinfo = new Applierinfo();
						applierinfo.setPname(ExcelTools.getValue(pname));
						applierinfo.setCasecode(ExcelTools.getValue(casecode));
						applierinfo.setAppName(ExcelTools.getValue(appName));
						if(appAddress != null && !appAddress.equals("")){
							applierinfo.setAppAddress(ExcelTools.getValue(appAddress));
						}
						dataList.add(applierinfo);
					}
				}
				is.close();

				this.appinfoService.excelInsertApplierinfo(dataList);
				request.setAttribute("message","excel导入第三步信息执行成功");
				return SUCCESS;
			}else{
				request.setAttribute("message","excel导入第三步文件上传失败");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.setAttribute("message","excel导入第三步执行失败");
				return SUCCESS;
			} catch (Exception e1) {
				e1.printStackTrace();
				return SUCCESS;
			}
		}
	}
	
	/**
	 * 案源第三步--添加申请执行人企业信息 --注册信息
	 * 郭志鹏
	 * @return
	 */
	public String insert(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Users admin=(Users) session.getAttribute("admin");
			applierinfo.setUsers(admin);
			applierinfo.setAppSavetime(sdf.format(new Date()));
			if(applierinfo != null){
				this.appinfoService.insertApp(applierinfo);	
				return SUCCESS;
			}else{
				return "filed";
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String markAppInfo(){
		try {
			if(applierinfo != null){
				this.appinfoService.updateApp(applierinfo);
				return SUCCESS;
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "filed";
	}
	
	public String insertApp(){
		try {
			System.out.println(applierinfo.getAppCCasecodeself() + "===========================");
			
			this.appinfoService.insertAppSoft(applierinfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String selAp(){
		try {
			applierinfos=this.appinfoService.selAp(applierinfo);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	/**
	 * 批处理申请执行人企业信息——郭志鹏
	 * @return
	 */
	public String insertMore(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		try {
			this.appinfoService.insertMoreApplierinfos(user);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("批处理数据完成！");
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
