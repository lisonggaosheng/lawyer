package com.lawyer.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ApplierinfoDao;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.Users;

public class ApplierinfoDaoImpl extends HibernateDaoSupport implements
		ApplierinfoDao {
	@Override
	public void insertApp(Applierinfo applierinfo) throws Exception {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(applierinfo);

		String sql = "UPDATE courtinfo SET executestep='3' WHERE casecodeself = '"
				+ applierinfo.getAppCCasecodeself() + "' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public List selectApp(Applierinfo applierinfo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateAppMark(Applierinfo applierinfo) throws Exception {
		String sql = "update applierinfo set used_mark= "+applierinfo.getUsedMark()+",mark_remark='"+applierinfo.getMarkRemark()
				+"',mark_time=DATE_FORMAT(NOW(), '%Y-%m-%d %T') where a_c_casecodeself='"+applierinfo.getAppCCasecodeself()+"'; ";
		this.getSession().createSQLQuery(sql).executeUpdate();

	}

	/**
	 * 案源第三步申请执行人企业信息的批处理操作——郭志鹏
	 * 
	 * ------所有批出理 事务（李梦翔）
	 */
	public void insertMoreApplierinfos(Users user) throws Exception {

		String sql = "SELECT ID as a_id, registration_mark AS a_renumber,business_name AS a_name,business_type AS a_type,corporation AS a_repname,certificate_number AS a_repid,administrative_area AS a_district,establishmen_date AS a_date,registered_capital AS a_fund,operating_period_since AS a_dfrom,operating_period_to AS a_dto,redistration_authority AS a_organ,address AS a_address,enterprise_status AS a_status,business_scope AS a_remark,casecodeself AS a_c_casecodeself,savetime as a_savetime,inspection_annual as a_inspection_annual,inspection_results as a_inspection_results,cancellation_date as a_cancellation_date,revoke_date as a_revoke_date,uid as a_uid  FROM enterprise_info";
		List list = this.getSession().createSQLQuery(sql).addEntity(
				"applierinfo", Applierinfo.class).list();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (list.size() > 0) {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				Applierinfo app = (Applierinfo) it.next();
				String sqlstr = "INSERT INTO applierinfo(a_renumber,a_type,a_name,a_repname,a_repid,a_district,a_date,a_fund,a_dfrom,a_dto,a_organ,a_address,a_status,a_remark,a_uid,a_c_casecodeself,a_savetime,a_inspection_annual,a_inspection_results,a_cancellation_date,a_revoke_date) values('"
						+ app.getAppRenumber()
						+ "','"
						+ app.getAppType()
						+ "','"
						+ app.getAppName()
						+ "','"
						+ app.getAppRepname()
						+ "','"
						+ app.getAppRepid()
						+ "','"
						+ app.getAppDistrict()
						+ "','"
						+ app.getAppDate()
						+ "','"
						+ app.getAppFund()
						+ "','"
						+ app.getAppDfrom()
						+ "','"
						+ app.getAppDto()
						+ "','"
						+ app.getAppOrgan()
						+ "','"
						+ app.getAppAddress()
						+ "','"
						+ app.getAppStatus()
						+ "','"
						+ app.getAppRemark()
						+ "','"
						+ user.getUId()
						+ "','"
						+ app.getAppCCasecodeself()
						+ "','"
						+ sdf.format(new Date())
						+ "','"
						+ app.getAppAnnual()
						+ "','"
						+ app.getAppResults()
						+ "','"
						+ app.getAppCancellation()
						+ "','"
						+ app.getAppRevoke()
						+ "')";
				this.getSession().createSQLQuery(sqlstr).executeUpdate();
			}
		}
		String sql3 = " UPDATE courtinfo SET executestep='3' WHERE EXISTS(SELECT  casecodeself from enterprise_info WHERE enterprise_info.casecodeself = courtinfo.casecodeself) ";
		this.getSession().createSQLQuery(sql3).executeUpdate();

		String sql4 = "DELETE FROM enterprise_info";
		this.getSession().createSQLQuery(sql4).executeUpdate();
	//	sql4 = "DROP TABLE `"+user.getUName()+"step2start`";
	//	this.getSession().createSQLQuery(sql4).executeUpdate();

	}

	public void insertAppSoft(Applierinfo applierinfo) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		String sql = "";
		sql = "DROP TABLE IF EXISTS `"+user.getUName()+"step2start`";
		this.getSession().createSQLQuery(sql).executeUpdate();
//		String sql = "delete from step2start";
		sql = "CREATE TABLE `"+user.getUName()+"step2start` (`id` int(11) NOT NULL AUTO_INCREMENT,`casecodeself` varchar(255) NOT NULL,`pname` varchar(255) NOT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=59996 DEFAULT CHARSET=utf8";		
		this.getSession().createSQLQuery(sql).executeUpdate();

		sql = "INSERT INTO `"+user.getUName()+"step2start`(casecodeself,pname) VALUES('"
				+ applierinfo.getAppCCasecodeself() + "','"
				+ applierinfo.getAppName() + "') ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Applierinfo> selAp(Applierinfo applierinfo) throws Exception {
		return this.getHibernateTemplate()
				.find(
						"from Applierinfo ap where ap.appCCasecodeself='"
								+ applierinfo.getAppCCasecodeself()
								+ "' and ap.appName is not null ");
	}

	@Override
	public void updateAppStatus(Applierinfo applierinfo) throws Exception {
		String sql = "update applierinfo set a_repname= '"+applierinfo.getAppRepname()+"',a_status='"+applierinfo.getAppStatus()
				+"' where a_name like '%"+applierinfo.getAppName()+"%'; ";
		this.getSession().createSQLQuery(sql).executeUpdate();
		
	}

}
