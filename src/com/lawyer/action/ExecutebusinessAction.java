package com.lawyer.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import cn.com.stronginfo.core.jdbc.DBConnection;
import cn.com.stronginfo.core.jdbc.DBConnectionHelper;

import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;
import com.lawyer.service.AddRecordService;
import com.lawyer.service.ExecutebusinessService;
import com.lawyer.tools.ExcelTools;
import com.lawyer.tools.StringFilter;
import com.opensymphony.xwork2.ActionSupport;

public class ExecutebusinessAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private Executebusiness  executebus;
	private ExecutebusinessService  executebusService;
	private AddRecordService ars;		//record对象的service类
	private File upd;// 上传的文件在缓存
	private String updFileName;// 文件名
	private String updContentType;// 文件类型
	List<Executebusiness> businlist;
	String caseId;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public List<Executebusiness> getBusinlist() {
		return businlist;
	}
	public void setBusinlist(List<Executebusiness> businlist) {
		this.businlist = businlist;
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
	public AddRecordService getArs() {
		return ars;
	}
	public void setArs(AddRecordService ars) {
		this.ars = ars;
	}
	public ExecutebusinessService getExecutebusService() {
		return executebusService;
	}
	public void setExecutebusService(ExecutebusinessService executebusService) {
		this.executebusService = executebusService;
	}
	public Executebusiness getExecutebus() {
		return executebus;
	}
	public void setExecutebus(Executebusiness executebus) {
		this.executebus = executebus;
	}
	
	/*
	 * excel导入被执行人信息
	 */
	public String excelInsertExecutebusiness(){
		HttpServletRequest request = ServletActionContext.getRequest();
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		try {
			if(updFileName != null){
				String path = basePath+"\\impExcel\\"+updFileName;
				FileUtils.copyFile(upd, new File(path));
				
				// 获取数据
				List<Executebusiness> dataList = new ArrayList<Executebusiness>();
				InputStream is = new FileInputStream(path);
				HSSFWorkbook workbook = new HSSFWorkbook(is);
				//在Excel文档中，第一张工作表的缺省索引是0
				HSSFSheet sheet = workbook.getSheetAt(0);
				// 获取到Excel文件中的所有行数
				int rows = sheet.getLastRowNum();
				// 遍历行
				for (int i = 1; i < rows; i++) {
					// 读取左上端单元格
					HSSFRow row = sheet.getRow(i);
					// 行不为空
					if (row != null) {
						
						HSSFCell pname = row.getCell(0);
						if(StringUtils.isBlank(ExcelTools.getValue(pname))){
							continue;
						}
						
						HSSFCell address = row.getCell(1);
						HSSFCell status = row.getCell(2);
						HSSFCell exception = row.getCell(3);
						Executebusiness executebusiness = new Executebusiness();
						executebusiness.setEName(ExcelTools.getValue(pname));
						executebusiness.setEAddress(ExcelTools.getValue(address));
						executebusiness.setException(ExcelTools.getValue(exception));
						if(status != null && !status.equals("")){
							executebusiness.setEStatus(ExcelTools.getValue(status));
						}
						dataList.add(executebusiness);
					}
				}
				is.close();
				this.executebusService.excelInsertExecutebusiness(dataList);
				request.setAttribute("message","excel导入第二步信息执行成功");
				return SUCCESS;
			}else{
				request.setAttribute("message","excel导入第二步文件上传失败");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				request.setAttribute("message","excel导入第二步执行失败");
				return SUCCESS;
			} catch (Exception e1) {
				e1.printStackTrace();
				return SUCCESS;
			}
		}
	}
	
	public String excelUpStutas(){
		String basePath=ServletActionContext.getServletContext().getRealPath("/");
		Connection conn = null;
		try {
			if(updFileName != null){
				String path = basePath+"\\impExcel\\"+updFileName;
				FileUtils.copyFile(upd, new File(path));
				
				
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				String dburl = "driver={Microsoft Excel Driver (*.xls, *.xlsx, *.xlsm, *.xlsb)};DBQ=" + path;
				String connectionString = "jdbc:odbc:" + dburl;
				conn = DriverManager.getConnection(connectionString);
				Statement stmt = conn.createStatement();
				ResultSet  rs = stmt.executeQuery("select * from [sheet1$]");
			//	ResultSet  rs = stmt.executeQuery("select * from [abc$]");
				// 获取列名（cnName）
				// 获取数据
				List<Executebusiness> dataList = new ArrayList<Executebusiness>();
				while (rs.next()) {
					String eName = rs.getString("企业名称");
					String eStatus = rs.getString("企业状态");
					Executebusiness exb = new Executebusiness();
					exb.setEName(eName);
					exb.setEStatus(eStatus);
					dataList.add(exb);
				}
				this.executebusService.Executebusiness(dataList);
				conn.close();
				message = "excel导入执行成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.close(); 
			} catch (SQLException e1) {
				message = "excel导入执行错误";
				e1.printStackTrace();
			}
			message = "excel导入执行错误";
		}
		return SUCCESS;
	}
	
	/**
	 * 获取数据库链接
	 * 
	 * @return
	 */
	public static Connection getConn() {
		DBConnection dbcon = (DBConnection) DBConnectionHelper
				.getDBConnection();
		Connection con = dbcon.getConnection();
		return con;
	}
	
	
	/**
	 * 批处理执行人企业信息——郭志鹏
	 * @return
	 */
	public String insertMore(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		try {
			this.executebusService.insertMoreExecutes(user);
			
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
	/*
	 * 添加被执行人企业信息	张磊
	 * 
	 */
	public String insertStep2(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Users admin=(Users) session.getAttribute("admin");	
			executebus.setUsers(admin);
			executebus.setESavetime(sdf.format(new Date()));
			if(executebus!=null){
				this.executebusService.insertStep2(executebus);
			return SUCCESS;
			}else{
				return "filed";
			}		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String insertEb(){
		try {
			this.executebusService.insertEb(executebus);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String selExecutebusiness(){
		try {
			businlist=this.executebusService.selExecutebusiness(executebus);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	
}
