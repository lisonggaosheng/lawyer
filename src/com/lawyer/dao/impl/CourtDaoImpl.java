package com.lawyer.dao.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.CourtDao;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.CollectCourt;
import com.lawyer.pojo.CollectExecutebusiness;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.ContactTalk;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.DishonestyCourt;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.LawyerCourt;
import com.lawyer.pojo.LawyerCourtName;
import com.lawyer.pojo.NoteInfo;
import com.lawyer.pojo.PageBean;
import com.lawyer.pojo.RefereeDocumentCourt;
import com.lawyer.pojo.Users;
import com.lawyer.tools.CommonUtil;
import com.lawyer.tools.Parser;
import com.lawyer.tools.StringFilter;

@Entity
public class CourtDaoImpl extends HibernateDaoSupport implements CourtDao {
	
	private static Logger logger = Logger.getLogger(CourtDaoImpl.class);
	
	/**
	 * 向数据库插入外部软件所需要的数据
	 */
	public void createDate(Court court, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users user = (Users) session.getAttribute("admin");
		// 由案源第一步生成批量操作第二步所需要的数据
		// 1.查询当前执行状态为第一步的所有案源 并将结果选择性的导入批量添加第二部所操作的表中
		String sql = "";
		if (court.getExecutestep().equals("1")) {
			sql = "DROP TABLE IF EXISTS `" + user.getUName() + "step2start`";
			this.getSession().createSQLQuery(sql).executeUpdate();
			sql = "CREATE TABLE `"
					+ user.getUName()
					+ "step2start` (`id` int(11) NOT NULL AUTO_INCREMENT,`casecodeself` varchar(255) NOT NULL,`pname` varchar(255) NOT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=59996 DEFAULT CHARSET=utf8";
			// sql = "delete from step2start";
			this.getSession().createSQLQuery(sql).executeUpdate();
			sql = "insert into `"
					+ user.getUName()
					+ "step2start`(casecodeself,pname) select casecodeself,pname from courtinfo where courtcode like '%"
					+ court.getCourtcode() + "%'  and executestep like '%"
					+ court.getExecutestep()
					+ "%' and casecreatetime between '" + startDate + "' and '"
					+ endDate + "' and savetime between '" + instartDate
					+ "' and '" + inendDate + "' and execmoney between '"
					+ minMoney + "' and '" + maxMoney + "'";
		}
		// 3.批量操作第三步结果信息
		if (court.getExecutestep().equals("3")) {
			// sql = "delete from step4start";
			sql = "DROP TABLE IF EXISTS `" + user.getUName() + "step4start`";
			this.getSession().createSQLQuery(sql).executeUpdate();
			sql = "CREATE TABLE `"
					+ user.getUName()
					+ "step4start` (`id` int(11) NOT NULL AUTO_INCREMENT,`casecodeself` varchar(255) NOT NULL,`pname` varchar(255) NOT NULL,`beizhu` varchar(255) NOT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8";

			this.getSession().createSQLQuery(sql).executeUpdate();
			sql = "insert into `"
					+ user.getUName()
					+ "step4start`(casecodeself,pname,beizhu) select casecodeself,a_name,execcourtname from applierinfo left join courtinfo on a_c_casecodeself=casecodeself  where courtcode like '%"
					+ court.getCourtcode() + "%'  and executestep like '%"
					+ court.getExecutestep()
					+ "%' and casecreatetime between '" + startDate + "' and '"
					+ endDate + "' and savetime between '" + instartDate
					+ "' and '" + inendDate + "' and execmoney between '"
					+ minMoney + "' and '" + maxMoney + "'";
		}
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	/**
	 * 改变案源信息执行步骤
	 */
	public void changeStep(Court court, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney, String courtStep) {
		String sql = "";
		sql = "UPDATE courtinfo c set c.executestep = '" + courtStep
				+ "' where courtcode like '%" + court.getCourtcode()
				+ "%'  and executestep like '%" + court.getExecutestep()
				+ "%' and casecreatetime between '" + startDate + "' and '"
				+ endDate + "' and savetime between '" + instartDate
				+ "' and '" + inendDate + "' and execmoney between '"
				+ minMoney + "' and '" + maxMoney + "'";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	/**
	 * 按条件分页查询court信息
	 */
	public List<Court> selectCourts(final Court court,final Executebusiness exb, final int currentPage,
			final String startDate, final String endDate,
			final String instartDate, final String inendDate,
			final String minMoney, final String maxMoney) throws Exception {
		String hql = "";
		List<Court> courts = new ArrayList<Court>();
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		
		if(Parser.getInt(court.getExecutestep()) == 1){
			hql = "from Court c where c.courtcode like '%"
					+ court.getCourtcode()
					+ "%'  and c.executestep like '%"
					+ court.getExecutestep()
					+ "%' and c.caseCreateTime between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and c.savetime between '"
					+ instartDate
					+ "' and '"
					+ inendDate
					+ "' and c.execMoney between '"
					+ minMoney
					+ "' and '"
					+ maxMoney
					+ "' and c.excludeStatus='0' ";
		}else{
			hql = "from Court c, Executebusiness eb  where c.casecodeself=eb.ECCasecodeself and c.courtcode like '%"
					+ court.getCourtcode()
					+ "%'  and c.executestep like '%"
					+ court.getExecutestep()
					+ "%' and c.caseCreateTime between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and c.savetime between '"
					+ instartDate
					+ "' and '"
					+ inendDate
					+ "' and c.execMoney between '"
					+ minMoney
					+ "' and '"
					+ maxMoney
					+ "' and c.excludeStatus='0' ";
			if(exb.getEStatus()!=null && exb.getEStatus().length()>0){
				hql += "and eb.EStatus like '%"+exb.getEStatus()+"%' ";
			}
		}
		if(user != null && user.getURole().contains("市场")){
			hql += " and c.execMoney >= 70000 ";
		}
		hql += " order by c.caseCreateTime desc";
		
		Query query = this.getSession().createQuery(hql);
		List courtList =  query.setFirstResult((currentPage - 1) * 12).setMaxResults(12).list();
		for (int i = 0; i < courtList.size(); i++) {
			Object[] objects = (Object[]) courtList.get(i);
			Court courtNew=(Court)objects[0];  
			 courts.add(courtNew);
		}
		return courts;
	}

	/**
	 * 按条件分页查询的总页数
	 */
	public int selectTatolPage(Court court,Executebusiness exb, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		
		if(exb.getEStatus() == null){
			exb.setEStatus("");
		}
		String hql = "";
		if(Parser.getInt(court.getExecutestep()) == 1){
			hql = "select count(*) from Court c " +
					" where c.courtcode like ? and c.executestep like ? and c.caseCreateTime between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and c.savetime between '"
					+ instartDate
					+ "' and '"
					+ inendDate
					+ "' and c.execMoney between '"
					+ minMoney
					+ "' and '"
					+ maxMoney
					+ "' and c.excludeStatus='0' ";
		}else{
			hql = "select count(*) from Court c, Executebusiness eb " +
					" where c.casecodeself=eb.ECCasecodeself and c.courtcode like ? and c.executestep like ? and c.caseCreateTime between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and c.savetime between '"
					+ instartDate
					+ "' and '"
					+ inendDate
					+ "' and c.execMoney between '"
					+ minMoney
					+ "' and '"
					+ maxMoney
					+ "' and c.excludeStatus='0' ";
			if(exb.getEStatus()!=null && exb.getEStatus().length()>0){
				hql += "and eb.EStatus like '%"+exb.getEStatus()+"%' ";
			}
		}
		if(user != null && user.getURole().contains("市场")){
			hql += " and c.execMoney >= 70000";
		}
		int totalRec = Integer.parseInt((this.getObj(hql,
				"%" + court.getCourtcode() + "%", "%" + court.getExecutestep()
						+ "%").toString()));
		return (totalRec - 1) / 12 + 1;
	}
	
	
	/**
	 * 按条件分页查询court信息
	 */
	@SuppressWarnings("unchecked")
	public List<Court> selectNoteCourts(final Court court, final int currentPage,
			final String startDate, final String endDate,
			final String instartDate, final String inendDate,
			final String minMoney, final String maxMoney) throws Exception {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				if(court.getExecCourtName() == null){
					court.setExecCourtName("");
				}
				String hql = "from Court c where c.noticeCourt like '%"
					+ court.getExecCourtName()
					+ "%'  and c.executestep like '%"
					+ court.getExecutestep()
					+ "%' and c.noticeTime between '"
					+ startDate
					+ "' and '"
					+ endDate
					+ "' and c.savetime between '"
					+ instartDate
					+ "' and '"
					+ inendDate
					+ "' and c.execMoney between '"
					+ minMoney
					+ "' and '"
					+ maxMoney
					+ "' and c.excludeStatus='0' ";
			hql += " order by c.noticeTime desc";
				Query query = session.createQuery(hql);
				query.setFirstResult((currentPage - 1) * 12);
				query.setMaxResults(12);
				return query.list();
			}
		});
	}

	/**
	 * 按条件分页查询的总页数
	 */
	public int selectNoteTatolPage(Court court, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney) throws Exception {
		if(court.getExecCourtName() == null){
			court.setExecCourtName("");
		}
		String hql = "select count(*) from Court where noticeCourt like ? and executestep like ? and noticeTime between '"
			+ startDate
			+ "' and '"
			+ endDate
			+ "' and savetime between '"
			+ instartDate
			+ "' and '"
			+ inendDate
			+ "' and execmoney between '"
			+ minMoney
			+ "' and '"
			+ maxMoney
			+ "' and excludeStatus='0' ";
		int totalRec = Integer.parseInt((this.getObj(hql,
				"%" + court.getExecCourtName() + "%", "%" + court.getExecutestep()
						+ "%").toString()));
		return (totalRec - 1) / 12 + 1;
	}

	/**
	 * 查询得到一个对象
	 */
	public Object getObj(final String hql, final String... params) {

		return this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if (params != null && params.length > 0) {
					for (int i = 0; i < params.length; i++) {
						query.setString(i, params[i]);
					}
				}
				return query.iterate().next();
			}
		});
	}

	public void insertCourt(Court court) throws Exception {
		this.getHibernateTemplate().save(court);
	}

	@SuppressWarnings("unchecked")
	public Apply selectApply(Users users) throws Exception {
		String str1 = "案源管理被执行人执行信息";
		String str2 = "新增";
		Apply app = null;

		Iterator<Apply> it = this
				.getHibernateTemplate()
				.find("from Apply where app_uid=" + users.getUId()
						+ " and appTarget='" + str1 + "' and app_content='"
						+ str2 + "'").iterator();
		while (it.hasNext()) {
			app = it.next();
		}
		return app;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List selectCourt(Court court) throws Exception {
		Iterator<Court> it = this.getHibernateTemplate().find("from Court")
				.iterator();
		while (it.hasNext()) {

		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Apply selectCourt3(Apply apply, Users users) throws Exception {
		String str1 = "案源管理";
		String str2 = "查询";
		Apply app = null;
		Iterator<Apply> it = this
				.getHibernateTemplate()
				.find("from Apply where app_uid=" + users.getUId()
						+ " and app_target='" + str1 + "' and app_content='"
						+ str2 + "'").iterator();
		while (it.hasNext()) {
			app = it.next();
		}
		return app;
	}

	@SuppressWarnings({ "rawtypes" })
	public List selectCourtAll(Court court) throws Exception {
		List list = this.getHibernateTemplate().find("from Court");

		return list;
	}

	@SuppressWarnings("unchecked")
	public int getAllRowCount(String hql) {
		Query q = this.getHibernateTemplate().getSessionFactory().openSession()
				.createQuery(hql);
		q.setFirstResult(0);
		q.setMaxResults(18);
		List<Court> list = q.list();
		return list.size();
	}

	@SuppressWarnings("rawtypes")
	public List queryForPage(String hql, int offset, int length) {
		// Hibernate分页
		Query q = this.getSession().createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List list = q.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	public PageBean queryForPage(int pageSize, int page) {
		// 页面分页
		String hql = "from Court order by id desc";
		// 总条数
		int allRow = getAllRowCount(hql);
		// 总页数
		int totalPage = PageBean.countTotalPage(pageSize, allRow);
		// 当前页
		int currentPage = PageBean.countCurrentPage(page);
		// 当前页开始记录
		int offset = PageBean.countOffset(pageSize, currentPage);

		List<Court> list = queryForPage(hql, offset, pageSize);

		// 把各个属性封装到PageBean
		PageBean pb = new PageBean();
		pb.setAllRow(allRow);
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage);
		pb.setList(list);
		pb.init();
		return pb;
	}

	@SuppressWarnings("unchecked")
	public Apply appSelectById(Apply apply, Users users) throws Exception {
		String str1 = "案源管理查看详细信息";
		String str2 = "查询";
		Apply app = null;
		Iterator<Apply> it = this
				.getHibernateTemplate()
				.find("from Apply where app_uid=" + users.getUId()
						+ " and app_target='" + str1 + "' and app_content='"
						+ str2 + "'").iterator();
		while (it.hasNext()) {
			app = it.next();
		}

		return app;
	}

	@SuppressWarnings("unchecked")
	public Court selectCourtById(Court court) throws Exception {
		Court c = null;
		Iterator<Court> it = this
				.getHibernateTemplate()
				.find("from Court where casecodeself='"
						+ court.getCasecodeself() + "' and caseId='"
						+ court.getCaseId() + "'").iterator();
		while (it.hasNext()) {
			c = it.next();
		}

		// 被执行人企业信息
		Executebusiness eb = null;
		Iterator<Executebusiness> iteb = this
				.getHibernateTemplate()
				.find("from Executebusiness ex where ex.ECCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (iteb.hasNext()) {
			eb = iteb.next();
			if(eb.getEType() != null){
				if(!(eb.getEType().indexOf("分公司")!=-1)){
					c.setEb(eb);
				}
			}else{
				c.setEb(eb);
			}
			
		}

		// 申请执行人企业信息
		Applierinfo ap = null;
		Iterator<Applierinfo> itap = this
				.getHibernateTemplate()
				.find("from Applierinfo ap where ap.appCCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itap.hasNext()) {
			ap = itap.next();
			if(ap.getAppType() != null){
				if(!(ap.getAppType().indexOf("分公司")!=-1)){
					c.setAp(ap);
				}
			}else{
				c.setAp(ap);
			}
		}

		// 申请执行人企业信息（网络信息applierinfo_ network）
		ApplierinfoNetwork an = null;
		Iterator<ApplierinfoNetwork> itan = this
				.getHibernateTemplate()
				.find("from ApplierinfoNetwork ap where ap.anCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itan.hasNext()) {
			an = itan.next();
		}
		if (an != null) {
			if (an.getAnAddress() != null) {
				if (an.getAnAddress().length() > 100) {
					an.setAnAddress(an.getAnAddress().substring(0, 100));
				}
			}
			if (an.getAnConname() != null) {
				if (an.getAnConname().length() > 100) {
					an.setAnConname(an.getAnConname().substring(0, 100));
				}
			}

			if (an.getAnFax() != null) {
				if (an.getAnFax().length() > 100) {
					an.setAnFax(an.getAnFax().substring(0, 100));
				}
			}

			if (an.getAnMail() != null) {
				if (an.getAnMail().length() > 100) {
					an.setAnMail(an.getAnMail().substring(0, 100));
				}
			}

			if (an.getAnPhone() != null) {
				if (an.getAnPhone().length() > 100) {
					an.setAnPhone(an.getAnPhone().substring(0, 100));
				}
			}

			if (an.getAnName() != null) {
				if (an.getAnName().length() > 100) {
					an.setAnName(an.getAnName().substring(0, 100));
				}
			}
			c.setAn(an);
		}

		// 申请执行人信息（自有信息applierinfo_ oneself）
		ApplierinfoOnself ao = null;
		Iterator<ApplierinfoOnself> itao = this
				.getHibernateTemplate()
				.find("from ApplierinfoOnself api where api.aoCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itao.hasNext()) {
			ao = itao.next();
			c.setAo(ao);
		}

		// 与申请执行人联系信息（电子邮件contact_mail）
		ContactMail cm = null;
		Iterator<ContactMail> itcm = this
				.getHibernateTemplate()
				.find("from ContactMail cm where cm.cmCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itcm.hasNext()) {
			cm = itcm.next();
			c.setCm(cm);
		}

		// 与申请执行人联系信息（电话联系contact_tel）
		ContactTel ct = null;
		Iterator<ContactTel> itct = this
				.getHibernateTemplate()
				.find("from ContactTel ct where ct.ctCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itct.hasNext()) {
			ct = itct.next();
			c.setCt(ct);
		}

		// 与申请执行人联系信息（快递contact_express）
		ContactExpress ce = null;
		Iterator<ContactExpress> itce = this
				.getHibernateTemplate()
				.find("from ContactExpress ce where ce.ceCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itce.hasNext()) {
			ce = itce.next();
			c.setCe(ce);
		}

		// 与申请执行人联系信息（传真contact_fax）
		ContactFax cf = null;
		Iterator<ContactFax> itcf = this
				.getHibernateTemplate()
				.find("from ContactFax cf where cf.cfCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itcf.hasNext()) {
			cf = itcf.next();
			c.setCf(cf);
		}

		// 与申请执行人联系信息（登门拜访contact_see）
		ContactSee csee = null;
		Iterator<ContactSee> itcsee = this
				.getHibernateTemplate()
				.find("from ContactSee cs where cs.csCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itcsee.hasNext()) {
			csee = itcsee.next();
			c.setCsee(csee);
		}

		
		ContactTalk ctalk = null;
		Iterator<ContactTalk> itctalk = this
				.getHibernateTemplate()
				.find("from ContactTalk talk where talk.ctCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itctalk.hasNext()) {
			ctalk = itctalk.next();
			c.setCtalk(ctalk);
		}
		

		// 签约情况(contract_sign)
		ContractSign csign = null;
		Iterator<ContractSign> itcsign = this
				.getHibernateTemplate()
				.find("from ContractSign csign where csign.csCasecodeself='"
						+ court.getCasecodeself() + "'").iterator();
		while (itcsign.hasNext()) {
			csign = itcsign.next();
			c.setCsign(csign);
		}
		return c;
	}

	public void updateCourt(Court court) throws Exception {
		this.getHibernateTemplate().load(Court.class, court.getId());
	}
	
	/**
	 * 根据法院id和立案时间获取案件数量
	 */
	private long countCourtByCourtcode(String courtcode, String caseCreateTime) {
		String hql = "select count(*) from Court where caseCreateTime='"+caseCreateTime+"' and courtcode='"+courtcode+"'";
		Long query = (Long) this.getHibernateTemplate().iterate(hql).next();
		return query.longValue();  
	}
	
	/**
	 * 根据法院名称获取法院编号
	 */
	private String getCourtNumberByName(String courtName) {
		String hql = "select lc.number from lawyer_court lc "+
				" inner join lawyer_court_name lcn  on lcn.court_id=lc.Id "+
				" where lcn.same_name like '%"+courtName+"%' group by number";
		SQLQuery query = this.getSession().createSQLQuery(hql);
		List<Object[]> list = query.list();
		if(list.size() >0 ){
			return Parser.getString(list.get(0));
		}
		return "000000";
	}

	/**
	 * 根据法院编号和时间获取案件数量 郭志鹏
	 */
	public long countCourtByCC(String courtcode,String caseCreateTime) {
		String sql = "select count(*) from Court where caseCreateTime='"+caseCreateTime+"' and courtcode='"+courtcode+"'";
		Long query = (Long) this.getHibernateTemplate().iterate(sql).next();
		return query.longValue(); 
	}
	
	/**
	 * 根据公告法院和时间获取案件数量 郭志鹏
	 */
	public int countCourtBynote(final String noticeCourt,
			final String noticeTime) {
		final String hql = "select count(*) from Court where noticeCourt=? and noticeTime=?";

		Object obj = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(hql);
						query.setString(0, noticeCourt);
						query.setString(1, noticeTime);
						return query.iterate().next();
					}
				});
		return Integer.parseInt(obj + "");
	}

	/**
	 * 案源的批处理操作——郭志鹏
	 * 
	 * (可优化 ---李梦翔)
	 */
	@SuppressWarnings({ "rawtypes" })
	public String insertMoreCourts(Users user) throws Exception {
		int count = 0;
		String message = "";
		
		if(user == null){
			user = new Users(29);
		}
		
		String sql = "SELECT ID,caseId,pname,partyCardNum,execCourtName,courtcode,casecodeself,caseCreateTime,caseCode,execMoney,caseState,savetime,beijingCourtState from court limit 5000";
		List list = this.getSession().createSQLQuery(sql)
				.addEntity("CollectCourt", CollectCourt.class).list();
		if (list.size() > 0) {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				String sqlstr = "INSERT IGNORE into courtinfo(caseId,pname,partyCardNum,execCourtName,courtcode,casecodeself,caseCreateTime,caseCode,execMoney,caseState,savetime,beijingCourtState,infoType,excludeStatus,executestep) values ";
				CollectCourt court = (CollectCourt) it.next();
				if(court.getPname()==null || court.getCaseCode()==null || court.getPname().contains("'")){
					continue;
				}
				List<Court> courts = selectCourtsByNameCasecode(court.getPname(), court.getCaseCode());
				if(courts.size()>0){
					continue;
				}
				
				SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				sqlstr += "('"
						+ court.getCaseId()
						+ "','"
						+ StringFilter.stringFilter(court.getPname())
						+ "','"
						+ StringFilter.stringFilter(court.getPartyCardNum().replaceAll("\\\\", ""))
						+ "','"
						+ court.getExecCourtName()
						+ "','"
						+ court.getCourtcode()
						+ "','"
						+ court.getCasecodeself()+court.getCaseId()
						+ System.currentTimeMillis()
						+ "','"
						+ court.getCaseCreateTime()
						+ "','"
						+ court.getCaseCode()
						+ "','"
						+ court.getExecMoney()
						+ "','"
						+ court.getCaseState()
						+ "','"
						+ df2.format(new Date())
						+ "','"
						+ court.getBeijingCourtState() + "','1','0',1)";
				this.getSession().createSQLQuery(sqlstr).executeUpdate();
				count++;
			}
			String sql2 = "UPDATE courtinfo SET uid = '"
					+ user.getUId()
					+ "' WHERE uid is NULL";
			this.getSession().createSQLQuery(sql2).executeUpdate();

			String sql3 = "DELETE FROM court limit 5000";
			this.getSession().createSQLQuery(sql3).executeUpdate();
		}
		message = "批处理数据完成,查询"+list.size()+"条，实际插入"+count+"条数据";
		
		return message;
	}
	
	@Override
	public String insertDishonestyCourts(Users user) {
		String message = null;
		try{
			SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");
			if(user == null){
				user = new Users(29);
			}
			int dealCount = 0;
			
			String sql = "SELECT ID,caseId,iname,cardNum,courtName,gistId,regDate,"+
							"caseCode,duty,performance,publishDate "+
							"from court_shixin limit 0,5000";
			List list = this.getSession().createSQLQuery(sql)
					.addEntity("DishonestyCourt", DishonestyCourt.class).list();
			if (list.size() > 0) {
				Iterator it = list.iterator();
				while (it.hasNext()) {
					DishonestyCourt dcourt = (DishonestyCourt) it.next();
					if(StringUtils.isBlank(dcourt.getIname())){
						continue;
					}
					List<Court> courts = selectCourtsByNameCasecode(dcourt.getIname(), dcourt.getCaseCode());
					if(courts.size()>0){
						for (Court court2 : courts) {
							if(Parser.getInt(court2.getExecutestep()) > 2){
								continue;
							}
							String courtNumber = getCourtNumberByName(dcourt.getCourtName());
							court2.setPartyCardNum(dcourt.getCardNum());
							court2.setExecCourtName(dcourt.getCourtName());
							court2.setCourtcode(courtNumber);
							court2.setLawDocumentNum(dcourt.getGistId());
							court2.setCaseCreateTime(dcourt.getRegDate());
							court2.setCaseState(dcourt.getPerformance());
							court2.setNoticeTime(dcourt.getPublishDate());
							court2.setRemark(dcourt.getDuty());
							court2.setSavetime(df1.format(new Date()));
							court2.setUid(user.getUId());
//							court2.setExecMoney(String.valueOf(CommonUtil.getNumbers(dcourt.getDuty())));
							this.getHibernateTemplate().update(court2);
						}
					}else{
						String courtNumber = getCourtNumberByName(dcourt.getCourtName());
						String count = String.format("%4d", countCourtByCourtcode(courtNumber, dcourt.getRegDate())+1).replace(" ", "0");
						String date = sdfDate.format(sdf2.parse(dcourt.getRegDate()));
						String casecodeself = "S"+courtNumber+date+count+System.currentTimeMillis();
						
						Court court = new Court();
						court.setCasecodeself(casecodeself);
						court.setCaseId(CommonUtil.generateString(8));
						court.setPname(dcourt.getIname());
						court.setCaseCode(dcourt.getCaseCode());
						court.setPartyCardNum(dcourt.getCardNum());
						court.setExecCourtName(dcourt.getCourtName());
						court.setCourtcode(courtNumber);
						court.setLawDocumentNum(dcourt.getGistId());
						court.setCaseCreateTime(dcourt.getRegDate());
						court.setCaseState(dcourt.getPerformance());
						court.setNoticeTime(dcourt.getPublishDate());
						court.setExecutestep("1");
						court.setExcludeStatus("0");
						court.setInfoType("3");
						court.setExecMoney("1");
						court.setRemark(dcourt.getDuty());
//						court.setExecMoney(String.valueOf(CommonUtil.getNumbers(dcourt.getDuty())));
						court.setSavetime(df1.format(new Date()));
						court.setUid(user.getUId());
						this.getHibernateTemplate().save(court);
					}
					dealCount++;
				}
			}
			String deleteSql = "DELETE FROM court_shixin limit 5000";
			this.getSession().createSQLQuery(deleteSql).executeUpdate();
			
			message = "批处理数据完成,查询"+list.size()+"条，实际插入更新"+dealCount+"条数据";
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		return message;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Court selCourtByCasecodeself(String casecodeself) throws Exception {
		Court court = null;
		Iterator<Court> courts = this.getHibernateTemplate()
				.find("from Court c where c.caseId='" + casecodeself + "'")
				.iterator();
		while (courts.hasNext()) {
			court = courts.next();
		}
		return court;
	}

	@Override
	public void toupdCourt1(Court court) throws Exception {
		this.getHibernateTemplate().update(court);

	}

	@SuppressWarnings("unchecked")
	@Override
	public Executebusiness selExecutebusByCasecodeself(String ecCasecodeself)
			throws Exception {
		Executebusiness eb = null;
		Iterator<Executebusiness> ebs = this
				.getHibernateTemplate()
				.find("from Executebusiness e where e.ECCasecodeself='"
						+ ecCasecodeself + "'").iterator();
		while (ebs.hasNext()) {
			eb = ebs.next();
		}
		Hibernate.initialize(eb.getUsers());
		return eb;
	}

	@SuppressWarnings("unchecked")
	public Executebusiness selExecutebusById(String id) throws Exception {
		Executebusiness eb = null;
		Iterator<Executebusiness> ebs = this.getHibernateTemplate()
				.find("from Executebusiness e where e.EId='" + id + "'")
				.iterator();
		while (ebs.hasNext()) {
			eb = ebs.next();
		}
		Hibernate.initialize(eb.getUsers());
		return eb;
	}

	@Override
	public void toupdExecutebus(Executebusiness eb) throws Exception {
		this.getHibernateTemplate().update(eb);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Applierinfo selApplierinfoByCasecodeself(String appCCasecodeself)
			throws Exception {
		Applierinfo ap = null;
		Iterator<Applierinfo> aps = this
				.getHibernateTemplate()
				.find("from Applierinfo a where a.appId='" + appCCasecodeself
						+ "'").iterator();
		while (aps.hasNext()) {
			ap = aps.next();
		}
		Hibernate.initialize(ap.getUsers());
		return ap;
	}

	@Override
	public void toupdApplierinfo(Applierinfo ap) throws Exception {
		this.getHibernateTemplate().update(ap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ApplierinfoNetwork selNetwork(String anCasecodeself)
			throws Exception {

		ApplierinfoNetwork an = null;
		Iterator<ApplierinfoNetwork> ans = this
				.getHibernateTemplate()
				.find("from ApplierinfoNetwork a where a.anCasecodeself='"
						+ anCasecodeself + "'").iterator();
		while (ans.hasNext()) {
			an = ans.next();
		}

		Hibernate.initialize(an.getUsers());
		return an;

	}

	@Override
	public void toupdNetwork(ApplierinfoNetwork an) throws Exception {
		this.getHibernateTemplate().update(an);

	}

	@SuppressWarnings("unchecked")
	@Override
	public ApplierinfoOnself updApplierinfoOnself(String aoCasecodeself)
			throws Exception {
		ApplierinfoOnself ao = null;
		Iterator<ApplierinfoOnself> aos = this
				.getHibernateTemplate()
				.find("from ApplierinfoOnself a where a.aoCasecodeself='"
						+ aoCasecodeself + "'").iterator();
		while (aos.hasNext()) {
			ao = aos.next();
		}

		Hibernate.initialize(ao.getUsers());
		return ao;
	}

	@Override
	public void toupdApplierinfoOnself(ApplierinfoOnself ao) throws Exception {
		this.getHibernateTemplate().update(ao);
	}

	@Override
	public void changeOneStep(Court court, String courtStep) {
		String sql = "";
		sql = "UPDATE courtinfo c set c.executestep = '" + courtStep + "'"
				+ "WHERE c.ID = '" + court.getId() + "' and c.casecodeself = '"
				+ court.getCasecodeself() + "' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public void toupdConMail(ContactMail cm) throws Exception {
		this.getHibernateTemplate().update(cm);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ContactMail updConMail(String cmCasecodeself) throws Exception {
		ContactMail cm = null;
		Iterator<ContactMail> cms = this
				.getHibernateTemplate()
				.find("from ContactMail cm where cm.cmCasecodeself='"
						+ cmCasecodeself + "'").iterator();
		while (cms.hasNext()) {
			cm = cms.next();
		}

		Hibernate.initialize(cm.getUsers());
		return cm;
	}

	@Override
	public void toupdConTel(ContactTel ct) throws Exception {
		this.getHibernateTemplate().update(ct);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ContactTel updConTel(String ctCasecodeself) throws Exception {
		ContactTel ct = null;
		Iterator<ContactTel> cts = this
				.getHibernateTemplate()
				.find("from ContactTel ct where ct.ctCasecodeself='"
						+ ctCasecodeself + "'").iterator();
		while (cts.hasNext()) {
			ct = cts.next();
		}
		Hibernate.initialize(ct.getUsers());
		return ct;
	}

	public void toupdConExpress(ContactExpress ce) throws Exception {
		this.getHibernateTemplate().update(ce);
	}

	public void toupdConFax(ContactFax cf) throws Exception {
		this.getHibernateTemplate().update(cf);
	}

	public void toupdConSee(ContactSee csee) throws Exception {
		this.getHibernateTemplate().update(csee);
	}

	@SuppressWarnings("unchecked")
	public ContactExpress updConExpress(String ceCasecodeself) throws Exception {
		ContactExpress ce = null;
		Iterator<ContactExpress> ces = this
				.getHibernateTemplate()
				.find("from ContactExpress ce where ce.ceCasecodeself='"
						+ ceCasecodeself + "'").iterator();
		while (ces.hasNext()) {
			ce = ces.next();
		}
		Hibernate.initialize(ce.getUsers());
		return ce;
	}

	@SuppressWarnings("unchecked")
	public ContactFax updConFax(String cfCasecodeself) throws Exception {
		ContactFax cf = null;
		Iterator<ContactFax> cfs = this
				.getHibernateTemplate()
				.find("from ContactFax cf where cf.cfCasecodeself='"
						+ cfCasecodeself + "'").iterator();
		while (cfs.hasNext()) {
			cf = cfs.next();
		}
		Hibernate.initialize(cf.getUsers());
		return cf;
	}

	@SuppressWarnings("unchecked")
	public ContactSee updConSee(String csCasecodeself) throws Exception {
		ContactSee csee = null;
		Iterator<ContactSee> csees = this
				.getHibernateTemplate()
				.find("from ContactSee cs where cs.csCasecodeself='"
						+ csCasecodeself + "'").iterator();
		while (csees.hasNext()) {
			csee = csees.next();
		}
		Hibernate.initialize(csee.getUsers());
		return csee;
	}

	@Override
	public int presentExclude(Court court) {
		String sql = "";
		sql = "UPDATE courtinfo c set excludeStatus = '1'" + "WHERE c.ID = '"
				+ court.getId() + "' and c.casecodeself = '"
				+ court.getCasecodeself() + "' ";
		return this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public int perpetualExclude(Court court) {
		String sql = "";
		sql = "UPDATE courtinfo c set excludeStatus = '2'" + "WHERE c.ID = '"
				+ court.getId() + "' and c.casecodeself = '"
				+ court.getCasecodeself() + "' ";
		return this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public int dataRecover(Court court) {
		String sql = "";
		sql = "UPDATE courtinfo c set excludeStatus = '0'" + "WHERE c.ID = '"
				+ court.getId() + "' and c.casecodeself = '"
				+ court.getCasecodeself() + "' ";
		return this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insertNoteCourts(Users user) {
		try{
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy.MM.dd");
		NoteInfo note = null;
		String casecodeself = null;
		Iterator<NoteInfo> notes = this.getHibernateTemplate()
				.find("from NoteInfo where LENGTH(debtor_name) <=255").iterator();
		while (notes.hasNext()) {
			LawyerCourtName lawyerCourtName = null;
			LawyerCourt lawyerCourt = null;
			Court court = new Court();
			note = notes.next();
			Iterator<LawyerCourtName> lcnames = this
					.getHibernateTemplate()
					.find("from LawyerCourtName lcn where lcn.same_name like '%"
							+ note.getAnnouncement_court() + "%'").iterator();
			while (lcnames.hasNext()) {
				lawyerCourtName = lcnames.next();
			}
			String[] str = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
			String CaseId = "";
			for (int i = 0; i < 8; i++) {
				int a = (int) (Math.random() * 10);
				CaseId += str[a];
			}
			String noticeCourt="";
			if(note.getAnnouncement_court().length()>125){
				noticeCourt = note.getAnnouncement_court().substring(0, 125);
			}else{
				noticeCourt = note.getAnnouncement_court();
			}
			if (lawyerCourtName != null) {
				Iterator<LawyerCourt> lcs = this
						.getHibernateTemplate()
						.find("from LawyerCourt lc where lc.id='"
								+ lawyerCourtName.getCourt_id() + "'")
						.iterator();
				while (lcs.hasNext()) {
					lawyerCourt = lcs.next();
				}
				String noticeTime="";
				String noticeTime1="";
				if(note.getAnnouncement_date().indexOf(".")!=-1){
					noticeTime = sdf.format(sdf3.parse(note.getAnnouncement_date()));
					noticeTime1 = sdf1.format(sdf3.parse(note.getAnnouncement_date()));
				}else{
					noticeTime = sdf.format(sdf2.parse(note.getAnnouncement_date()));
					noticeTime1 = sdf1.format(sdf2.parse(note.getAnnouncement_date()));
				}
				int num = countCourtBynote(note.getAnnouncement_court(),noticeTime)+1;
				String count = String.format("%4d", num).replace(" ", "0");
				casecodeself = "G" + lawyerCourt.getLawyerCourt_number()
						+ noticeTime1
						+ count + System.currentTimeMillis();
				court.setCasecodeself(casecodeself);
				court.setPname(note.getDebtor_name());
				court.setNoticeCourt(noticeCourt);
				court.setNoticeTime(noticeTime);
				court.setCaseId(CaseId);
				court.setExecutestep("1");
				court.setExcludeStatus("0");
				court.setInfoType("2");
				court.setCaseCreateTime("1111年11月12日");
				court.setExecMoney("1");
				court.setCourtcode("");
				court.setSavetime(df1.format(new Date()));
				court.setUid(user.getUId());
				court.setRemark(note.getBak());
				this.getHibernateTemplate().save(court);
			} else {
				String noticeTime="";
				String noticeTime1="";
				if(note.getAnnouncement_date().indexOf(".")!=-1){
					noticeTime = sdf.format(sdf3.parse(note.getAnnouncement_date()));
					noticeTime1 = sdf1.format(sdf3.parse(note.getAnnouncement_date()));
				}else{
					noticeTime = sdf.format(sdf2.parse(note.getAnnouncement_date()));
					noticeTime1 = sdf1.format(sdf2.parse(note.getAnnouncement_date()));
				}
				int num = countCourtBynote(note.getAnnouncement_court(),noticeTime)+1;
				String count = String.format("%4d", num).replace(" ", "0");
				casecodeself = "G" + "000000"
						+ noticeTime1
						+ count + df.format(new Date());
				court.setCasecodeself(casecodeself);
				court.setPname(note.getDebtor_name());
				court.setNoticeCourt(noticeCourt);
				court.setNoticeTime(noticeTime);
				court.setCaseId(CaseId);
				court.setExecutestep("1");
				court.setExcludeStatus("0");
				court.setInfoType("2");
				court.setCaseCreateTime("1111年11月12日");
				court.setExecMoney("1");
				court.setCourtcode("");
				court.setSavetime(df1.format(new Date()));
				court.setUid(user.getUId());
				court.setRemark(note.getBak());
				this.getHibernateTemplate().save(court);
			}
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		String sql = "TRUNCATE TABLE chinacourt_fygg ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}
	
	

	@Override
	/**
	 * 企业状态更新
	 */
	public void updateStutas(Users user) throws Exception {
		String sql = "SELECT ID,courtcode,casecodeself,caseCode,business_name,registration_mark,address,corporation,registered_capital,paid_in_capital,business_type,enterprise_status,business_scope_mark,operating_period_since,operating_period_to,establishmen_date,redistration_authority,cancellation_date,revoke_date,organization_code,organization_code_issuing_agencies,inspection_annual,inspection_results,savetime FROM enterprise_info WHERE casecodeself IN (SELECT casecodeself from `"+user.getUName()+"step2start`)";
		List list = this
				.getSession()
				.createSQLQuery(sql)
				.addEntity("CollectExecutebusiness",
						CollectExecutebusiness.class).list();
		if (list.size() > 0) {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				CollectExecutebusiness ceb = (CollectExecutebusiness) it.next();

				Executebusiness ebold = null;
				Iterator<Executebusiness> iteb = this
						.getHibernateTemplate()
						.find("from Executebusiness ex where ex.ECCasecodeself='"
								+ ceb.getCasecodeself() + "'").iterator();
				while (iteb.hasNext()) {
					ebold = iteb.next();
					if (!ebold.getEStatus()
							.endsWith(ceb.getEnterprise_status())) {
						ebold.setEStatus(ceb.getEnterprise_status());
						ebold.setEAnnual(ceb.getInspection_annual());
						ebold.setEResults(ceb.getInspection_results());
						ebold.setECancellation(ceb.getCancellation_date());
						ebold.setERevoke(ceb.getRevoke_date());
					}
					this.getHibernateTemplate().update(ebold);
				}
			}
		}

		String sql4 = "DELETE FROM enterprise_info WHERE casecodeself IN (SELECT casecodeself from `"
				+ user.getUName() + "step2start`)";
		this.getSession().createSQLQuery(sql4).executeUpdate();
	}

	/**
	 * 法院编码更新
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void courtcodeUpdate(Users users) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		String hql = "from Court WHERE courtcode = '110101' and casecodeself = '11010120101206010'";
		Query query = this.getSession().createQuery(hql);
		query.setFirstResult(0);
		query.setMaxResults(1);
		List<Court> list = query.list();
		for (Court court : list) {
			String pname = court.getPname();
			String casecodeself = court.getCasecodeself();
			String courtcode = court.getCourtcode();
			String caseCreateTime = court.getCaseCreateTime();
			String execCourtName = court.getExecCourtName();
			String casecode = court.getCaseCode();
			//String savetimestr = casecodeself.substring(18, casecodeself.length());	
			//生成法院某一天受理的案件数
			long n = countCourtByCC(courtcode, caseCreateTime) + 1;
			StringBuffer count = new StringBuffer();	
			if(n >= 0&&n<10){
				count.append('0');
				count.append('0');
				count.append(String.valueOf(n));
			}else if( n >= 10&&n<100){
				count.append('0');
				count.append(String.valueOf(n));
			}	
			Date resultDate = simpleDateFormat.parse(court.getCaseCreateTime());
			caseCreateTime  = sdf.format(resultDate);
			
			LawyerCourtName lawyerCourtName = null;
			LawyerCourt lawyerCourt = null;
			Iterator<LawyerCourtName> lcnames = this
					.getHibernateTemplate()
					.find("from LawyerCourtName lcn where lcn.same_name like '%"
							+ court.getExecCourtName() + "%'").iterator();
			while (lcnames.hasNext()) {
				lawyerCourtName = lcnames.next();
			}
			if (lawyerCourtName != null) {
				Iterator<LawyerCourt> lcs = this
						.getHibernateTemplate()
						.find("from LawyerCourt lc where lc.id='"
								+ lawyerCourtName.getCourt_id() + "'")
						.iterator();
				while (lcs.hasNext()) {
					lawyerCourt = lcs.next();
				}
				String lawyerCourt_number = lawyerCourt.getLawyerCourt_number();
				String newcasecodeself = "";
				/*if(savetimestr != null && savetimestr != ""){
					newcasecodeself = lawyerCourt_number + caseCreateTime + count + savetimestr;
				}else{
					newcasecodeself = lawyerCourt_number + caseCreateTime + count;
				}*/
				newcasecodeself = lawyerCourt_number + caseCreateTime + count;
				
				String sql = "UPDATE courtinfo SET courtcode = '"
						+ lawyerCourt_number
						+ "', casecodeself = '"+newcasecodeself+"' WHERE caseCode='"
						+ casecode + "' and pname='"+pname+"'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE executebusiness SET e_c_casecodeself = '"+newcasecodeself+"' WHERE e_c_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE applierinfo SET a_c_casecodeself = '"+newcasecodeself+"' WHERE a_c_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE applierinfo_network SET an_casecodeself = '"+newcasecodeself+"' WHERE an_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE applierinfo_onself SET ao_casecodeself = '"+newcasecodeself+"' WHERE ao_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE contact_mail SET cm_casecodeself = '"+newcasecodeself+"' WHERE cm_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE contact_tel SET ct_casecodeself = '"+newcasecodeself+"' WHERE ct_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE contact_express SET ce_casecodeself = '"+newcasecodeself+"' WHERE ce_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE contact_fax SET cf_casecodeself = '"+newcasecodeself+"' WHERE cf_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE contact_see SET cs_casecodeself = '"+newcasecodeself+"' WHERE cs_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE contact_sign SET cs_casecodeself = '"+newcasecodeself+"' WHERE cs_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE clear_record SET cr_casecodeself = '"+newcasecodeself+"' WHERE cr_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE clear_clear SET cc_casecodeself = '"+newcasecodeself+"' WHERE cc_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE litigation SET li_casecodeself = '"+newcasecodeself+"' WHERE li_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE execute SET ex_casecodeself = '"+newcasecodeself+"' WHERE ex_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();

				sql = "UPDATE close_record SET cr_casecodeself = '"+newcasecodeself+"' WHERE cr_casecodeself='"
						+ casecodeself + "'";
				this.getSession().createSQLQuery(sql).executeUpdate();
			}
		}
	}

	@Override
	public void createUpdateData(Court court, String startDate, String endDate,
			String instartDate, String inendDate, String minMoney,
			String maxMoney) {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Users user = (Users) session.getAttribute("admin");
		// 由案源第一步生成批量操作第二步所需要的数据
		// 1.查询当前执行状态为第一步的所有案源 并将结果选择性的导入批量添加第二部所操作的表中
		String sql = "";
		sql = "DROP TABLE IF EXISTS `" + user.getUName() + "step2start`";
		this.getSession().createSQLQuery(sql).executeUpdate();
		sql = "CREATE TABLE `"
				+ user.getUName()
				+ "step2start` (`id` int(11) NOT NULL AUTO_INCREMENT,`casecodeself` varchar(255) NOT NULL,`pname` varchar(255) NOT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=59996 DEFAULT CHARSET=utf8";
		this.getSession().createSQLQuery(sql).executeUpdate();
		sql = "insert into `"
				+ user.getUName()
				+ "step2start`(casecodeself,pname) select casecodeself,pname from courtinfo where courtcode like '%"
				+ court.getCourtcode() + "%'  and executestep like '%"
				+ court.getExecutestep() + "%' and casecreatetime between '"
				+ startDate + "' and '" + endDate + "' and savetime between '"
				+ instartDate + "' and '" + inendDate
				+ "' and execmoney between '" + minMoney + "' and '" + maxMoney
				+ "'";
		this.getSession().createSQLQuery(sql).executeUpdate();

	}

	@Override
	public void excelInsertCourt(List<Court> dataList) {
		for (int i = 0; i < dataList.size(); i++) {
			Court court = dataList.get(i);
			String sql = "insert ignore into step1start(pname,partyCardNum) values('"+court.getPname()+"','"+court.getPartyCardNum()+"')";
			this.getSession().createSQLQuery(sql).executeUpdate();
		}
		String sql = "delete from step1start";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public List<Court> selectCourtsByName(String pname) {
		String hqlcc = "from Court c  where c.pname like '%"+pname+"%' ";
		@SuppressWarnings("unchecked")
		List<Court> courts = this.getHibernateTemplate().find(hqlcc);
		return courts;
	}
	
	@Override
	public List<Court> selectCourtsByNameCasecode(String pname,String caseCode) {
		String hqlcc = "from Court c  where c.pname like '%"+pname+"%' and c.caseCode like '%"+caseCode+"%' "
				+ "and c.caseCode is not null and c.excludeStatus = '0'";
		@SuppressWarnings("unchecked")
		List<Court> courts = this.getHibernateTemplate().find(hqlcc);
		return courts;
	}

	@Override
	public Object getCourtByCasecode(final Court court) throws Exception {
		
		return this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "select value,courtcode from casecode_court where INSTR('"+court.getCaseCode()+"',name)>0 ";
				Query query = session.createSQLQuery(sql);
				List<Object[]> list = query.list();
				if(list.size() == 0){
					court.setExecCourtName(null);
					court.setCourtcode("000000");
					return court;
				}
				Object[] ob = (Object[]) query.list().get(0);
				String[] strs  =  Arrays.asList( ob ).toArray( new String[2] );
				court.setExecCourtName(strs[0]);
				court.setCourtcode(strs[1]);
				return court;
			}
		});
	}
	
	@Override
	public List<?> listRefereeDocument() {
		List<?> list = new ArrayList<>();
		try{
			String sql = "SELECT id,caseId,person_execution,person_execution_addr,courtname,publishDate,"+
							"caseCode,case_content,applicant,applicant_addr "+
							"from bjcourt limit 0,2000";
			list = this.getSession().createSQLQuery(sql)
					.addEntity("RefereeDocumentCourt", RefereeDocumentCourt.class).list();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return list;
	}
	@Override
	public void deleteRefereeDocument() {
		String deleteSql = "DELETE FROM bjcourt limit 2000";
		this.getSession().createSQLQuery(deleteSql).executeUpdate();
	}
	
	
}
