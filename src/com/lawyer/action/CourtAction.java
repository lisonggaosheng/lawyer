package com.lawyer.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.LawyerCourt;
import com.lawyer.pojo.LimitPower;
import com.lawyer.pojo.PageBean;
import com.lawyer.pojo.Users;
import com.lawyer.service.AddRecordService;
import com.lawyer.service.CourtService;
import com.lawyer.service.LawyerCourtService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Entity
public class CourtAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private LawyerCourt lawyerCourt;
	private LawyerCourtService lcs;
	private String startDate;//案源查询的立案时间段
	private String endDate;
	private String instartDate;//案源入库时间段
	private String inendDate;
	private String minMoney;//执行标的
	private String maxMoney;
	private String courtStep;
	private String caseId;
	private Court court;				//court对象
	private CourtService courtService;  //court对象的service实现类
	private AddRecordService ars;		//record对象的service类
	private Users users;				//封装users对象
	private Apply apply;				//封装apply对象
	private Executebusiness exb;			//封装Executebusiness对象
	
	@SuppressWarnings("rawtypes")
	private List list;					//封装list
	private String str;
	private PageBean pageBean; 
	private int page;
	
	private File upd;// 上传的文件在缓存
	private String updFileName;// 文件名
	private String updContentType;// 文件类型
	
	private List<Court> courts;
	private int cp;//当前页
	private int tp;//总页数
	
	public Executebusiness getExb() {
		return exb;
	}
	public void setExb(Executebusiness exb) {
		this.exb = exb;
	}
	public String getCourtStep() {
		return courtStep;
	}
	public void setCourtStep(String courtStep) {
		this.courtStep = courtStep;
	}
	public String getCaseId() {
		return caseId;
	}
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	public LawyerCourtService getLcs() {
		return lcs;
	}
	public void setLcs(LawyerCourtService lcs) {
		this.lcs = lcs;
	}
	public LawyerCourt getLawyerCourt() {
		return lawyerCourt;
	}
	public void setLawyerCourt(LawyerCourt lawyerCourt) {
		this.lawyerCourt = lawyerCourt;
	}
	public String getMinMoney() {
		return minMoney;
	}
	public void setMinMoney(String minMoney) {
		this.minMoney = minMoney;
	}
	public String getMaxMoney() {
		return maxMoney;
	}
	public void setMaxMoney(String maxMoney) {
		this.maxMoney = maxMoney;
	}
	public String getInstartDate() {
		return instartDate;
	}
	public void setInstartDate(String instartDate) {
		this.instartDate = instartDate;
	}
	public String getInendDate() {
		return inendDate;
	}
	public void setInendDate(String inendDate) {
		this.inendDate = inendDate;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	/*
	 * excel导入被执行人信息
	 */
	public String excelInsertCourt(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session=ServletActionContext.getRequest().getSession();
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
				// 获取数据
				List<Court> dataList = new ArrayList<Court>();
				while (rs.next()) {
					String pname = rs.getString("债务人名称");
					String caseCode = rs.getString("案号");
					String execMoney = rs.getString("标的");
					String remark = rs.getString("链接");
					String creditor = rs.getString("债权人名称");
					String creditorAddress = rs.getString("债权人地址");
					String caseCreateTime = "2012年10月10日";
					
					Court court = new Court();
					court.setPname(pname);
					court.setCaseCode(caseCode);
					court.setExecMoney(execMoney);
					court.setRemark(remark);
					court.setCreditor(creditor);
					court.setCreditorAddress(creditorAddress);
					court.setCaseCreateTime(caseCreateTime);
					court.setExcludeStatus("0");
					court.setInfoType("1");
					court.setExecutestep("1");
					dataList.add(court);
				}
				this.courtService.excelInsertCourt(dataList);
				conn.close();
				request.setAttribute("message","excel导入第一步执行成功");
				return SUCCESS;
			}else{
				request.setAttribute("message","excel导入第一步文件上传失败");
				return SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.close(); 
				request.setAttribute("message","excel导入第一步执行失败");
				return SUCCESS;
			} catch (Exception e1) {
				e1.printStackTrace();
				return SUCCESS;
			}
		}
	}
	
	/**
	 * 郭志鹏
	 * 向数据库插入企业更新所需要的数据
	 */
	public String createUpdateData()throws Exception{
		courtService.createUpdateData(court, startDate, endDate, instartDate, inendDate, minMoney, maxMoney);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("更新企业状态数据创建完成！");
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 法院编码更新——郭志鹏
	 * @return
	 */
	public String courtcodeUpdate(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		try {
			users=(Users) session.getAttribute("admin");
			courtService.courtcodeUpdate(users);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("法院编码更新完成！");
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 郭志鹏
	 * 数据暂时排除
	 */
	public String presentExclude()throws Exception{
		int flog = courtService.presentExclude(court);
		if(flog == 1){
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("数据暂时排除成功！");
			out.flush();
			out.close();
		}
		return null;
	}
	/**
	 * 郭志鹏
	 * 数据永久排除
	 */
	public String perpetualExclude()throws Exception{
		courtService.perpetualExclude(court);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("数据永久排除成功！");
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 郭志鹏
	 * 数据恢复
	 */
	public String dataRecover()throws Exception{
		courtService.dataRecover(court);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("数据恢复显示成功！");
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 李梦翔
	 * 向数据库插入外部软件所需要的数据
	 */
	public String createData()throws Exception{
		courtService.createDate(court, startDate, endDate, instartDate, inendDate, minMoney, maxMoney);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("数据创建完成！");
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 郭志鹏
	 * 改变执行步骤
	 */
	public String changeStep()throws Exception{
		System.out.println(court.getCourtcode()+"="+court.getExecutestep()+"="+startDate+"="+endDate+"="+instartDate+"="+inendDate+"="+minMoney+"="+maxMoney+ courtStep);
		courtService.changeStep(court, startDate, endDate, instartDate, inendDate, minMoney, maxMoney,courtStep);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("执行步骤修改成功！");
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 郭志鹏
	 * 改变一个案源信息执行步骤
	 */
	public String changeOneStep()throws Exception{
		courtService.changeOneStep(court, courtStep);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("执行步骤修改成功！");
		out.flush();
		out.close();
		return null;
	}
	/**
	 * 查询所有普通案源     可以按条件
	 */
	public String findCourts() throws Exception{
		//直接请求当前方法
		if(court==null){
			court = new Court();
			court.setCourtcode("");
			court.setExecCourtName("");
			court.setExecutestep("");
		}
		if(court.getExecutestep()==null){
			court.setExecutestep("");
		}
		//根据用户限制查询法院的权限，设置法院
		LimitPower userlp = (LimitPower) ServletActionContext.getRequest().getSession().getAttribute("userlp");
		if(!"".equals(userlp.getLp_limit_query_court().trim()) && !"0".equals(userlp.getLp_limit_query_court())){
			//权限里设置的是法院的id courtcode里放的是法院的number  这里需要转换一下
			LawyerCourt lawyerCourt = lcs.selectCourtByID(Integer.parseInt(userlp.getLp_limit_query_court()));
			court.setExecCourtName(lawyerCourt.getLawyerCourt_court_name());
			court.setCourtcode(lawyerCourt.getLawyerCourt_number());
		}
		if(exb == null){
			exb = new Executebusiness();
		}
		tp=courtService.selectTatolPage(court,exb, startDate, endDate, instartDate, inendDate, minMoney, maxMoney);
		if(cp>tp){
			cp=tp;
		}
		if(cp<1){
			cp=1;
		}
		courts = courtService.selectCourts(court,exb, cp, startDate, endDate, instartDate, inendDate, minMoney, maxMoney);
		
		return SUCCESS;
	}
	
	/**
	 * 查询所有公告案源     可以按条件
	 */
	public String findNoteCourts() throws Exception{
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		//直接请求当前方法
		if(court==null){
			court = new Court();
			court.setCourtcode("");
			court.setExecutestep("");
		}
		if(court.getExecutestep()==null){
			court.setExecutestep("");
		}
		if(!"".equals(court.getCourtcode().trim()) && court.getCourtcode()!=null){
			LawyerCourt lawyerCourt = lcs.selectCourtByNumber(court.getCourtcode());
			court.setExecCourtName(lawyerCourt.getLawyerCourt_court_name());
			court.setCourtcode(lawyerCourt.getLawyerCourt_number());
		}
		
		tp=courtService.selectNoteTatolPage(court, startDate, endDate, instartDate, inendDate, minMoney, maxMoney);
		if(cp>tp){
			cp=tp;
		}
		if(cp<1){
			cp=1;
		}
		courts = courtService.selectNoteCourts(court, cp, startDate, endDate, instartDate, inendDate, minMoney, maxMoney);
		return SUCCESS;
	}
	
	/**
	 * 债务人公告信息批处理导入——郭志鹏
	 * @return
	 */
	public String insertNoteCourts(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		try {
			users=(Users) session.getAttribute("admin");
			courtService.insertNoteCourts(users);
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.print("批处理债务人公告数据完成！");
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 企业状态更新——郭志鹏
	 * @return
	 */
	public String updateStutas(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		try {
			users=(Users) session.getAttribute("admin");
			courtService.updateStutas(users);
			
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
	/**
	 * 案源批处理操作——郭志鹏
	 * @return
	 */
	public String insertMore(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html; charset=utf-8");
		
		try {
			users=(Users) session.getAttribute("admin");
			int count = courtService.insertMoreCourts(users);
			PrintWriter out = response.getWriter();
			out.print("批处理数据完成,查询5000条，实际插入"+count+"条数据");
			out.flush();
			out.close();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			PrintWriter out = null;
			try {
				out = response.getWriter();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			out.print("批处理数据异常信息："+e.getMessage());
			out.flush();
			out.close();
			return null;
		}
	}
	
	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getTp() {
		return tp;
	}

	public void setTp(int tp) {
		this.tp = tp;
	}

	public List<Court> getCourts() {
		return courts;
	}

	public void setCourts(List<Court> courts) {
		this.courts = courts;
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
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Apply getApply() {
		return apply;
	}
	public void setApply(Apply apply) {
		this.apply = apply;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public Court getCourt() {
		return court;
	}
	public void setCourt(Court court) {
		this.court = court;
	}
	public CourtService getCourtService() {
		return courtService;
	}
	public void setCourtService(CourtService courtService) {
		this.courtService = courtService;
	}	
	
	public String upd() {
		try {
			FileInputStream in = new FileInputStream(upd);
			Runtime rt = Runtime.getRuntime();
			Process child = rt.exec("mysql -uroot -proot lawyer");
			OutputStream out = child.getOutputStream();
			String inStr;
			StringBuffer sb = new StringBuffer("");
			String outStr;
			BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf8"));
			while ((inStr = br.readLine()) != null) {
				sb.append(inStr + "\r\n");
			}
			outStr = sb.toString();
			OutputStreamWriter writer = new OutputStreamWriter(out, "utf8");
			writer.write(outStr);
			// 注：这里如果用缓冲方式写入文件的话，会导致中文乱码，用flush()方法则可以避免
			writer.flush();
			// 别忘记关闭输入输出流
			out.close();
			br.close();
			writer.close();	
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return "success";
	}
	/**
	 * @since 13-3-19
	 * 新建案源信息 	
	 * 郭志鹏
	 */
	public String insertCourt(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String casedatetime = null;
		String noticeTime = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddhhmmss");
		String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8","9"};
		String CaseId = "";
		for (int i = 0; i < 8; i++) {
			int a=(int)(Math.random()*10);
			CaseId+=str[a];
		}	
		try {			
				//生成案件的唯一标识
				if(court.getInfoType().equals("1")){
					try {
						 Date resultDate = simpleDateFormat.parse(court.getCaseCreateTime());
						 casedatetime  = sdf.format(resultDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					int n = courtService.countCourtByCC(court.getCourtcode(), court.getCaseCreateTime(),court.getExecCourtName()) + 1;
					StringBuffer count = new StringBuffer();	
					if(n >= 0&&n<10){
						count.append('0');
						count.append('0');
						count.append(String.valueOf(n));
					}else if( n >= 10&&n<100){
						count.append('0');
						count.append(String.valueOf(n));
					}	
					court.setCasecodeself(court.getCourtcode() + casedatetime + count +System.currentTimeMillis());
				}else{
					try {
						 Date resultDate2 = simpleDateFormat.parse(court.getNoticeTime());
						 noticeTime = sdf.format(resultDate2);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					
					int n = courtService.countCourtByCC(court.getCourtcode(), court.getNoticeTime(),court.getExecCourtName()) + 1;
					StringBuffer count = new StringBuffer();	
					if(n >= 0&&n<10){
						count.append('0');
						count.append('0');
						count.append(String.valueOf(n));
					}else if( n >= 10&&n<100){
						count.append('0');
						count.append(String.valueOf(n));
					}	
					court.setCasecodeself("G" + court.getCourtcode() + noticeTime + count + System.currentTimeMillis());
					court.setCaseCreateTime("1111年11月12日");
				}
				if(court.getExecMoney().equals("")){
					court.setExecMoney("0.1");
				}
				court.setCaseId(CaseId);
				court.setSavetime(df1.format(new Date()));	
				court.setBeijingCourtState(0);
				users=(Users) session.getAttribute("admin");			
				court.setUid(users.getUId());		
				court.setExecutestep("1");
				court.setExcludeStatus("0");
				if(court!=null){
					this.courtService.insertCourt(court);	
					return SUCCESS;
				}else{
					return "filed";
				}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 申请   查看详细信息    权限    和    按id查询案源的详细信息
	 * @author acer  田紫贺
	 */
	public String selectCourtById(){
		try {
			court=this.courtService.selectCourtById(court);
			if(court!=null){
				return SUCCESS;
			}else{
				return "uninfo";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 修改案源信息(被执行人执行信息)
	 * @author Administrator 何静
	 * @since 13.3.21
	 * @return
	 */
	public String updateCourt(){
		try {
			this.courtService.updateCourt(court);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updCourt1(){
		try {
			court=this.courtService.selCourtByCasecodeself(court.getCaseId());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdCourt1(){
		try {
			court.setExcludeStatus("0");
			this.courtService.toupdCourt1(court);
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updExecutebus(){
		try {
			court.setEb(this.courtService.selExecutebusById(court.getEb().getEId()+""));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("Exuser", court.getEb().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdExecutebus(){
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("Exuser");
			court.getEb().setUsers(user);
			session.remove("Exuser");
			this.courtService.toupdExecutebus(court.getEb());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	public String updApplierinfo(){
		try {
			court.setAp(this.courtService.selApplierinfoByCasecodeself(court.getAp().getAppId()+""));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("Apuser", court.getAp().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdApplierinfo(){
		try {
			
 			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("Apuser");
			court.getAp().setUsers(user);
 			session.remove("Apuser");
			this.courtService.toupdApplierinfo(court.getAp());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updNetwork(){
		try {
		
			court.setAn(this.courtService.selNetwork(court.getAn().getAnCasecodeself()));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("Anuser", court.getAn().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdNetwork(){
		try {
			
 			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("Anuser");
			court.getAn().setUsers(user);
 			session.remove("Anuser");
			this.courtService.toupdNetwork(court.getAn());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updApplierinfoOnself(){
		try {

			court.setAo(this.courtService.updApplierinfoOnself(court.getAo().getAoCasecodeself()));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("Aouser", court.getAo().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdApplierinfoOnself(){
		try {
			
			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("Aouser");
			court.getAo().setUsers(user);
			session.remove("Aouser");
			this.courtService.toupdApplierinfoOnself(court.getAo());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updConMail(){
		try {

			court.setCm(this.courtService.updConMail(court.getCm().getCmCasecodeself()));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("cmuser", court.getCm().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdConMail(){
		try {
			
			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("cmuser");
			court.getCm().setUsers(user);
			session.remove("cmuser");
			this.courtService.toupdConMail(court.getCm());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updConTel(){
		try {
			court.setCt(this.courtService.updConTel(court.getCt().getCtCasecodeself()));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("ctuser", court.getCt().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String toupdConTel(){
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("ctuser");
			court.getCt().setUsers(user);
			session.remove("ctuser");
			this.courtService.toupdConTel(court.getCt());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		
	}
	
	public String updConExpress(){
		try {
			court.setCe(this.courtService.updConExpress(court.getCe().getCeCasecodeself()));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("ceuser", court.getCe().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdConExpress(){
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("ceuser");
			court.getCe().setUsers(user);
			session.remove("ceuser");
			this.courtService.toupdConExpress(court.getCe());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updConFax(){
		try {
			court.setCf(this.courtService.updConFax(court.getCf().getCfCasecodeself()));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("cfuser", court.getCf().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdConFax(){
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("cfuser");
			court.getCf().setUsers(user);
			session.remove("cfuser");
			this.courtService.toupdConFax(court.getCf());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String updConSee(){
		try {
			court.setCsee(this.courtService.updConSee(court.getCsee().getCsCasecodeself()));
			Map<String, Object> session = ActionContext.getContext().getSession();
			session.put("cseeuser", court.getCsee().getUsers());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	public String toupdConSee(){
		try {
			Map<String, Object> session = ActionContext.getContext().getSession();
			Users user=(Users) session.get("cseeuser");
			court.getCsee().setUsers(user);
			session.remove("cseeuser");
			this.courtService.toupdConSee(court.getCsee());
			return Action.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}
