package com.lawyer.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lawyer.dao.ApplierinfoDao;
import com.lawyer.dao.CourtDao;
import com.lawyer.dao.ExecutebusinessDao;
import com.lawyer.dao.LawyerCourtDao;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.RefereeDocumentCourt;
import com.lawyer.pojo.Users;
import com.lawyer.service.CourtService;
import com.lawyer.tools.CommonUtil;
import com.lawyer.tools.Parser;

@Entity
public class CourtServiceImpl implements CourtService {
	@ManyToOne
	private CourtDao courtDao;
	private ExecutebusinessDao executebusDao;
	private ApplierinfoDao appdao;
	private LawyerCourtDao lawyerCourtDao;
	

	public CourtDao getCourtDao() {
		return courtDao;
	}

	public void setCourtDao(CourtDao courtDao) {
		this.courtDao = courtDao;
	}

	public ExecutebusinessDao getExecutebusDao() {
		return executebusDao;
	}

	public void setExecutebusDao(ExecutebusinessDao executebusDao) {
		this.executebusDao = executebusDao;
	}

	public ApplierinfoDao getAppdao() {
		return appdao;
	}

	public void setAppdao(ApplierinfoDao appdao) {
		this.appdao = appdao;
	}

	public LawyerCourtDao getLawyerCourtDao() {
		return lawyerCourtDao;
	}

	public void setLawyerCourtDao(LawyerCourtDao lawyerCourtDao) {
		this.lawyerCourtDao = lawyerCourtDao;
	}

	/**
	 * 向数据库插入外部软件所需要的数据
	 */
	public void createDate(Court court, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney) {
		if (startDate == null || "".equals(startDate.trim()))
			startDate = "1111年11月11日";
		if (endDate == null || "".equals(endDate.trim()))
			endDate = "2222年22月22日";
		if (instartDate == null || "".equals(instartDate.trim()))
			instartDate = "1111-11-11 00:00:00";
		else {
			instartDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(instartDate);
				instartDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (inendDate == null || "".equals(inendDate.trim()))
			inendDate = "2222-22-22 00:00:00";
		else {
			inendDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(inendDate);
				inendDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (minMoney == null || "".equals(minMoney.trim()))
			minMoney = "0";
		if (maxMoney == null || "".equals(maxMoney.trim()))
			maxMoney = "100000000000";
		courtDao.createUpdateData(court, startDate, endDate, instartDate,
				inendDate, minMoney, maxMoney);
	}

	/**
	 * 改变执行步骤
	 */
	public void changeStep(Court court, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney, String courtStep) {
		if (startDate == null || "".equals(startDate.trim()))
			startDate = "1111年11月11日";
		if (endDate == null || "".equals(endDate.trim()))
			endDate = "2222年22月22日";
		if (instartDate == null || "".equals(instartDate.trim()))
			instartDate = "1111-11-11 00:00:00";
		else {
			instartDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(instartDate);
				instartDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (inendDate == null || "".equals(inendDate.trim()))
			inendDate = "2222-22-22 00:00:00";
		else {
			inendDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(inendDate);
				inendDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (minMoney == null || "".equals(minMoney.trim()))
			minMoney = "0";
		if (maxMoney == null || "".equals(maxMoney.trim()))
			maxMoney = "100000000000";
		courtDao.changeStep(court, startDate, endDate, instartDate, inendDate,
				minMoney, maxMoney, courtStep);
	}

	/**
	 * 按条件分页查询court信息
	 */
	public List<Court> selectCourts(Court court, Executebusiness exb,
			int currentPage, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney) throws Exception {
		if (startDate == null || "".equals(startDate.trim()))
			startDate = "1111年11月11日";
		if (endDate == null || "".equals(endDate.trim()))
			endDate = "2222年22月22日";
		if (instartDate == null || "".equals(instartDate.trim()))
			instartDate = "1111-11-11 00:00:00";
		else {
			instartDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(instartDate);
				instartDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (inendDate == null || "".equals(inendDate.trim()))
			inendDate = "2222-22-22 00:00:00";
		else {
			inendDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(inendDate);
				inendDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (minMoney == null || "".equals(minMoney.trim()))
			minMoney = "0";
		if (maxMoney == null || "".equals(maxMoney.trim()))
			maxMoney = "100000000000";
		return courtDao.selectCourts(court, exb, currentPage, startDate,
				endDate, instartDate, inendDate, minMoney, maxMoney);
	}

	/**
	 * 按条件分页查询的总页数
	 */
	public int selectTatolPage(Court court, Executebusiness exb,
			String startDate, String endDate, String instartDate,
			String inendDate, String minMoney, String maxMoney)
			throws Exception {
		if (startDate == null || "".equals(startDate.trim()))
			startDate = "1111年11月11日";
		if (endDate == null || "".equals(endDate.trim()))
			endDate = "2222年22月22日";
		if (instartDate == null || "".equals(instartDate.trim()))
			instartDate = "1111-11-11 00:00:00";
		else {
			instartDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(instartDate);
				instartDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (inendDate == null || "".equals(inendDate.trim()))
			inendDate = "2222-22-22 00:00:00";
		else {
			inendDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(inendDate);
				inendDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (minMoney == null || "".equals(minMoney.trim()))
			minMoney = "0";
		if (maxMoney == null || "".equals(maxMoney.trim()))
			maxMoney = "100000000000";
		return courtDao.selectTatolPage(court, exb, startDate, endDate,
				instartDate, inendDate, minMoney, maxMoney);
	}

	/**
	 * 按条件分页查询公告信息
	 */
	public List<Court> selectNoteCourts(Court court, int currentPage,
			String startDate, String endDate, String instartDate,
			String inendDate, String minMoney, String maxMoney)
			throws Exception {
		if (startDate == null || "".equals(startDate.trim()))
			startDate = "1111年11月11日";
		if (endDate == null || "".equals(endDate.trim()))
			endDate = "2222年22月22日";
		if (instartDate == null || "".equals(instartDate.trim()))
			instartDate = "1111-11-11 00:00:00";
		else {
			instartDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(instartDate);
				instartDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (inendDate == null || "".equals(inendDate.trim()))
			inendDate = "2222-22-22 00:00:00";
		else {
			inendDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(inendDate);
				inendDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (minMoney == null || "".equals(minMoney.trim()))
			minMoney = "0";
		if (maxMoney == null || "".equals(maxMoney.trim()))
			maxMoney = "100000000000";
		return courtDao.selectNoteCourts(court, currentPage, startDate,
				endDate, instartDate, inendDate, minMoney, maxMoney);
	}

	/**
	 * 按条件分页查询公告的总页数
	 */
	public int selectNoteTatolPage(Court court, String startDate,
			String endDate, String instartDate, String inendDate,
			String minMoney, String maxMoney) throws Exception {
		if (startDate == null || "".equals(startDate.trim()))
			startDate = "1111年11月11日";
		if (endDate == null || "".equals(endDate.trim()))
			endDate = "2222年22月22日";
		if (instartDate == null || "".equals(instartDate.trim()))
			instartDate = "1111-11-11 00:00:00";
		else {
			instartDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(instartDate);
				instartDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (inendDate == null || "".equals(inendDate.trim()))
			inendDate = "2222-22-22 00:00:00";
		else {
			inendDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(inendDate);
				inendDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (minMoney == null || "".equals(minMoney.trim()))
			minMoney = "0";
		if (maxMoney == null || "".equals(maxMoney.trim()))
			maxMoney = "100000000000";
		return courtDao.selectNoteTatolPage(court, startDate, endDate,
				instartDate, inendDate, minMoney, maxMoney);
	}

	/**
	 * 新建案源信息
	 */
	public void insertCourt(Court court) throws Exception {
		this.courtDao.insertCourt(court);
	}

	/**
	 */
	public Apply selectApply(Users users) throws Exception {
		return this.courtDao.selectApply(users);
	}

	/**
	 * 查询案源信息
	 * 
	 * @since 13-3-20
	 */
	@SuppressWarnings("rawtypes")
	public List selectCourtAll(Court court) throws Exception {
		List list = this.courtDao.selectCourtAll(court);
		return list;
	}

	/**
	 * 验证查询案源权限
	 */
	public Apply selectCourt3(Apply apply, Users users) throws Exception {
		apply = this.courtDao.selectCourt3(apply, users);
		return apply;
	}

	public int getAllRowCount(String hql) {
		return this.courtDao.getAllRowCount(hql);
	}

	/**
	 * 验证 案源管理 查看详细信息 权限
	 */
	public Apply appSelectById(Apply apply, Users users) throws Exception {
		return this.courtDao.appSelectById(apply, users);
	}

	/**
	 * 按id 查看案源 详细信息
	 */
	public Court selectCourtById(Court court) throws Exception {
		return this.courtDao.selectCourtById(court);
	}

	/**
	 * 修改案源信息（被执行人执行信息）
	 * 
	 * @since 13-3-21
	 */
	public void updateCourt(Court court) throws Exception {
		courtDao.updateCourt(court);
	}

	@Override
	public long countCourtByCC(String courtcode, String caseCreateTime)
			throws Exception {

		return courtDao.countCourtByCC(courtcode, caseCreateTime);
	}

	@Override
	public String insertMoreCourts(Users user) throws Exception {
		return courtDao.insertMoreCourts(user);
	}

	public Court selCourtByCasecodeself(String casecodeself) throws Exception {
		return courtDao.selCourtByCasecodeself(casecodeself);
	}

	public void toupdCourt1(Court court) throws Exception {
		courtDao.toupdCourt1(court);

	}

	public Executebusiness selExecutebusByCasecodeself(String ecCasecodeself)
			throws Exception {
		return courtDao.selExecutebusByCasecodeself(ecCasecodeself);
	}

	@Override
	public Executebusiness selExecutebusById(String id) throws Exception {
		return courtDao.selExecutebusById(id);
	}

	@Override
	public void toupdExecutebus(Executebusiness eb) throws Exception {
		courtDao.toupdExecutebus(eb);

	}

	@Override
	public Applierinfo selApplierinfoByCasecodeself(String appCCasecodeself)
			throws Exception {
		return courtDao.selApplierinfoByCasecodeself(appCCasecodeself);
	}

	@Override
	public void toupdApplierinfo(Applierinfo ap) throws Exception {
		courtDao.toupdApplierinfo(ap);

	}

	@Override
	public ApplierinfoNetwork selNetwork(String anCasecodeself)
			throws Exception {
		return courtDao.selNetwork(anCasecodeself);
	}

	@Override
	public void toupdNetwork(ApplierinfoNetwork an) throws Exception {
		courtDao.toupdNetwork(an);

	}

	@Override
	public ApplierinfoOnself updApplierinfoOnself(String aoCasecodeself)
			throws Exception {
		return courtDao.updApplierinfoOnself(aoCasecodeself);
	}

	@Override
	public void toupdApplierinfoOnself(ApplierinfoOnself ao) throws Exception {
		courtDao.toupdApplierinfoOnself(ao);
	}

	@Override
	public void changeOneStep(Court court, String courtStep) {
		courtDao.changeOneStep(court, courtStep);
	}

	@Override
	public void toupdConMail(ContactMail cm) throws Exception {
		courtDao.toupdConMail(cm);
	}

	@Override
	public ContactMail updConMail(String cmCasecodeself) throws Exception {
		return courtDao.updConMail(cmCasecodeself);
	}

	@Override
	public void toupdConTel(ContactTel ct) throws Exception {
		courtDao.toupdConTel(ct);

	}

	@Override
	public ContactTel updConTel(String ctCasecodeself) throws Exception {
		return courtDao.updConTel(ctCasecodeself);
	}

	@Override
	public void toupdConExpress(ContactExpress ce) throws Exception {
		courtDao.toupdConExpress(ce);
	}

	@Override
	public void toupdConFax(ContactFax cf) throws Exception {
		courtDao.toupdConFax(cf);
	}

	@Override
	public void toupdConSee(ContactSee csee) throws Exception {
		courtDao.toupdConSee(csee);
	}

	@Override
	public ContactExpress updConExpress(String ceCasecodeself) throws Exception {
		return courtDao.updConExpress(ceCasecodeself);
	}

	@Override
	public ContactFax updConFax(String cfCasecodeself) throws Exception {
		return courtDao.updConFax(cfCasecodeself);
	}

	@Override
	public ContactSee updConSee(String csCasecodeself) throws Exception {
		return courtDao.updConSee(csCasecodeself);
	}

	@Override
	public int presentExclude(Court court) {
		return courtDao.presentExclude(court);
	}

	@Override
	public int perpetualExclude(Court court) {
		return courtDao.perpetualExclude(court);
	}

	@Override
	public int dataRecover(Court court) {
		return courtDao.dataRecover(court);
	}

	@Override
	public void insertNoteCourts(Users users) throws Exception {
		courtDao.insertNoteCourts(users);
	}

	@Override
	public String insertDishonestyCourts(Users users) throws Exception {
		return courtDao.insertDishonestyCourts(users);
	}

	@Override
	public void updateStutas(Users users) throws Exception {
		courtDao.updateStutas(users);
	}

	@Override
	public void courtcodeUpdate(Users users) throws Exception {
		courtDao.courtcodeUpdate(users);
	}

	@Override
	public void createUpdateData(Court court, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney) {
		if (startDate == null || "".equals(startDate.trim()))
			startDate = "1111年11月11日";
		if (endDate == null || "".equals(endDate.trim()))
			endDate = "2222年22月22日";
		if (instartDate == null || "".equals(instartDate.trim()))
			instartDate = "1111-11-11 00:00:00";
		else {
			instartDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(instartDate);
				instartDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (inendDate == null || "".equals(inendDate.trim()))
			inendDate = "2222-22-22 00:00:00";
		else {
			inendDate += " 00:00:00";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
			Date d;
			try {
				d = df2.parse(inendDate);
				inendDate = df.format(d);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if (minMoney == null || "".equals(minMoney.trim()))
			minMoney = "0";
		if (maxMoney == null || "".equals(maxMoney.trim()))
			maxMoney = "100000000000";
		courtDao.createUpdateData(court, startDate, endDate, instartDate,
				inendDate, minMoney, maxMoney);
	}

	@Override
	public long excelInsertCourt(List<Court> dataList) throws Exception {
		long dealCount = 0;
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users admin=(Users) session.getAttribute("admin");	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		for (int i = 0; i < dataList.size(); i++) {
			Court court = dataList.get(i);
			if (court.getCaseCode() == null) {
				continue;
			}
			List<Court> courts = courtDao.selectCourtsByNameCasecode(
					court.getPname(), court.getCaseCode());
			if (courts.size() > 0) {
				continue;
			}
			Date resultDate = simpleDateFormat.parse(court.getCaseCreateTime());
			String casedatetime = sdf.format(resultDate);

			long count = courtDao.countCourtByCC(court.getCourtcode(),
					court.getCaseCreateTime());

			String casecodeself = court.getCourtcode() + casedatetime + count
					+ System.currentTimeMillis();
			court.setCasecodeself(casecodeself);
			court.setSavetime(df1.format(new Date()));
			court.setUid(admin.getUId());
			court.setCaseId(String.valueOf((int) ((Math.random() * 9 + 1) * 100000)));
			courtDao.insertCourt(court);

			Executebusiness executebus = new Executebusiness();
			executebus.setEName(court.getPname());
			executebus.setUsers(admin);
			executebus.setECCasecodeself(casecodeself);
			executebusDao.insertStep2(executebus);

			Applierinfo applierinfo = new Applierinfo();
			applierinfo.setAppName(court.getCreditor());
			applierinfo.setAppAddress(court.getCreditorAddress());
			applierinfo.setUsers(admin);
			applierinfo.setAppCCasecodeself(casecodeself);
			appdao.insertApp(applierinfo);
			
			dealCount++;
		}
		
		return dealCount;
	}

	@Override
	public String insertRefereeDocument() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users user = (Users) session.getAttribute("admin");
		String message = "";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		int dealCount = 0;
		List<?> list = courtDao.listRefereeDocument();
		if (list.size() > 0) {
			Iterator<?> it = list.iterator();
			while (it.hasNext()) {
				RefereeDocumentCourt dcourt = (RefereeDocumentCourt) it.next();
				List<Court> courts = courtDao.selectCourtsByNameCasecode(dcourt.getPerson_execution(), dcourt.getCaseCode());
				if (courts.size() > 0) {
					continue;
				}
				
				//被申请人/被执行人自然人去除
				String courtName = dcourt.getPerson_execution();
				if(courtName.length()<=6 || courtName.length()>200){
					continue;
				}

				String courtNumber = lawyerCourtDao.getCourtNumberByName(dcourt.getCourtname());
				long courtCount = courtDao.countCourtByCC(courtNumber, dcourt.getPublishDate());
				String count = String.format("%4d", courtCount+1).replace(" ", "0");
				String date = sdf.format(sdf.parse(dcourt.getPublishDate()));
				String casecodeself = courtNumber+date+count+System.currentTimeMillis();
				Court court = new Court();
				court.setCasecodeself(casecodeself);
				court.setCaseId(CommonUtil.generateString(8));
				court.setPname(dcourt.getPerson_execution());
				court.setCaseCode(dcourt.getCaseCode());
				court.setExecCourtName(dcourt.getCourtname());
				court.setCourtcode(courtNumber);
				court.setCaseCreateTime(simpleDateFormat.format(sdf.parse(dcourt.getPublishDate())));
				court.setExecutestep("1");
				court.setExcludeStatus("0");
				court.setInfoType("1");
				court.setExecMoney("1");
				court.setRemark(dcourt.getCase_content());
				court.setSavetime(df1.format(new Date()));
				court.setUid(user.getUId());
				courtDao.insertCourt(court);

				Executebusiness executebus = new Executebusiness();
				executebus.setEName(dcourt.getPerson_execution());
				executebus.setEAddress(dcourt.getPerson_execution_addr());
				executebus.setUsers(user);
				executebus.setECCasecodeself(casecodeself);
				executebusDao.insertStep2(executebus);

				Applierinfo applierinfo = new Applierinfo();
				applierinfo.setAppName(dcourt.getApplicant());
				applierinfo.setAppAddress(dcourt.getApplicant_addr());
				applierinfo.setUsers(user);
				applierinfo.setAppCCasecodeself(casecodeself);
				appdao.insertApp(applierinfo);

				dealCount++;
			}
		}

		courtDao.deleteRefereeDocument();
		message = "批处理数据完成,查询" + list.size() + "条，实际插入更新" + dealCount + "条数据";
		return message;
	}

	@Override
	public long excelInsertNoteCourts(List<Court> dataList) throws Exception {
		long dealCount = 0;
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users admin=(Users) session.getAttribute("admin");	
		for (int i = 0; i < dataList.size(); i++) {
			Court court = dataList.get(i);
			String casecodeself = court.getCasecodeself();
			
			Court courtDB = courtDao.selCourtByCasecodeself(casecodeself);
			if(courtDB == null){
				continue;
			}
			if(Parser.getInt(courtDB.getExecutestep()) > 2){
				continue;
			}
			
			if(Parser.getInt(courtDB.getExecutestep()) == 1){
				Executebusiness executebus = new Executebusiness();
				executebus.setEName(court.getPname());
				executebus.setEStatus(court.getExcludeStatus());
				executebus.setUsers(admin);
				executebus.setECCasecodeself(casecodeself);
				executebusDao.insertStep2(executebus);

				Applierinfo applierinfo = new Applierinfo();
				applierinfo.setAppName(court.getCreditor());
				applierinfo.setAppStatus(court.getCreditorStatus());
				applierinfo.setUsers(admin);
				applierinfo.setAppCCasecodeself(casecodeself);
				appdao.insertApp(applierinfo);
			}else if(Parser.getInt(courtDB.getExecutestep()) == 2){
				Applierinfo applierinfo = new Applierinfo();
				applierinfo.setAppName(court.getCreditor());
				applierinfo.setAppStatus(court.getCreditorStatus());
				applierinfo.setUsers(admin);
				applierinfo.setAppCCasecodeself(casecodeself);
				appdao.insertApp(applierinfo);
			}
			
			dealCount++;
		}
		
		return dealCount;
	}

}
