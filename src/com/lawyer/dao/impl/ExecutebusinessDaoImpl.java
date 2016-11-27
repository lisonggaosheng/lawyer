package com.lawyer.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ExecutebusinessDao;
import com.lawyer.pojo.CollectExecutebusiness;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;

@Entity
public class ExecutebusinessDaoImpl extends HibernateDaoSupport implements
		ExecutebusinessDao {

	public void insertStep2(Executebusiness executebus) throws Exception {
		this.getHibernateTemplate().save(executebus);

		String sql = "UPDATE courtinfo SET executestep='2' WHERE casecodeself = '"
				+ executebus.getECCasecodeself() + "' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	public void insertEb(Executebusiness eb) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		String sql = "";
		sql = "DROP TABLE IF EXISTS `"+user.getUName()+"step2start`";
		this.getSession().createSQLQuery(sql).executeUpdate();
	//	String sql = "delete from step2start";
		sql = "CREATE TABLE `"+user.getUName()+"step2start` (`id` int(11) NOT NULL AUTO_INCREMENT,`casecodeself` varchar(255) NOT NULL,`pname` varchar(255) NOT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=59996 DEFAULT CHARSET=utf8";		
		this.getSession().createSQLQuery(sql).executeUpdate();

		sql = "INSERT INTO `"+user.getUName()+"step2start`(casecodeself,pname) VALUES('"
				+ eb.getECCasecodeself() + "','" + eb.getEName() + "') ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	/**
	 * 案源第二步被执行人企业信息的批处理操作——郭志鹏
	 */
	@SuppressWarnings("rawtypes")
	public void insertMoreExecutes(Users user) throws Exception {
		String asiInfo = "";
		String ajiInfo = "";
		String invesInfo = "";
		String reinvesInfo = "";
	//	String registration_mark = "";
		// 连接查询enterprise_info 和 step2start 公司名相同
		String sql = "SELECT ID,courtcode,casecodeself,caseCode,business_name,registration_mark,address,corporation,registered_capital,paid_in_capital,business_type,enterprise_status,business_scope_mark,operating_period_since,operating_period_to,establishmen_date,redistration_authority,cancellation_date,revoke_date,organization_code,organization_code_issuing_agencies,inspection_annual,inspection_results,savetime FROM enterprise_info WHERE casecodeself IN (SELECT casecodeself from `"+user.getUName()+"step2start`)";
		List list = this.getSession().createSQLQuery(sql).addEntity(
				"CollectExecutebusiness", CollectExecutebusiness.class).list();
		if (list.size() > 0) {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				CollectExecutebusiness ceb = (CollectExecutebusiness) it.next();
			//	registration_mark = ceb.getRegistration_mark();
				/*List asis = this.getHibernateTemplate().find("from AdministrativeSanctionInformation where registration_mark='"+registration_mark+"'");
				if(asis.size() > 0){
					Iterator itasi = asis.iterator();
					int i=1;
					while (itasi.hasNext()) {
						AdministrativeSanctionInformation asi = (AdministrativeSanctionInformation) itasi.next();
						asiInfo += "("+i+") 当事人名称："+asi.getLitigant()+"；处罚决定书文号："+asi.getPaperID()+"；基本事实："+asi.getBasic_facts()+"；认定依据:"+asi.getAsserting_basis()+"；处罚依据:"+asi.getPunishment_basis()+"；处罚结果:"+asi.getDisciplinary_action()+"；办案机关:"+asi.getCase_handling_organ()+"；公示日期:"+asi.getPublication_date()+"<br>"; 
						i++;
					}
				}
				List ajis = this.getHibernateTemplate().find("from AdverseJudicialInformation where registration_mark='"+registration_mark+"'");
				if(ajis.size() > 0){
					Iterator itaji = ajis.iterator();
					int i=1;
					while (itaji.hasNext()) {
						AdverseJudicialInformation aji = (AdverseJudicialInformation) itaji.next();
						ajiInfo += "("+i+") 主体名称："+aji.getLitigant()+"；处罚决定书文号："+aji.getPaperID()+"；案号："+aji.getCaseid()+"；生效法律文书确定的义务:"+aji.getObligation()+"；失信被执行人行为具体情形:"+aji.getCircumstances()+"；做出执行依据单位:"+aji.getBasis_unit()+"；被执行人的履行情况:"+aji.getPerformance()+"；执行法院:"+aji.getImplementation_court()+"；发布时间:"+aji.getPublication_date()+"<br>"; 
						i++;
					}
				}
				List ins = this.getHibernateTemplate().find("from InvestorInformation where registration_mark='"+registration_mark+"'");
				if(ins.size() > 0){
					Iterator itin = ins.iterator();
					int i=1;
					while (itin.hasNext()) {
						InvestorInformation ini = (InvestorInformation) itin.next();
						invesInfo += "("+i+") 名称："+ini.getLitigant()+"；出资金额："+ini.getCapital_contribution()+"；类型："+ini.getType()+"<br>"; 
						i++;
					}
				}
				List reins = this.getHibernateTemplate().find("from ReinvestmentInformation where registration_mark='"+registration_mark+"'");
				if(reins.size() > 0){
					Iterator itrein = reins.iterator();
					int i=1;
					while (itrein.hasNext()) {
						ReinvestmentInformation reini = (ReinvestmentInformation) itrein.next();
						reinvesInfo += "("+i+") 名称："+reini.getLitigant()+"；出资金额："+reini.getCapital_contribution()+"；类型："+reini.getType()+"<br>";  
						i++;
					}
				}*/
				
				Executebusiness executebus = new Executebusiness();
				executebus.setERenumber(ceb.getRegistration_mark());
				executebus.setEType(ceb.getBusiness_type());
				executebus.setEName(ceb.getBusiness_name());
				executebus.setERepname(ceb.getCorporation());
				executebus.setERepid("");
				executebus.setEDistrict("");
				executebus.setEDate(ceb.getEstablishmen_date());
				executebus.setEFund(ceb.getRegistered_capital());
				executebus.setPaidFund(ceb.getPaid_in_capital());
				executebus.setEDfrom(ceb.getOperating_period_since());
				executebus.setEDto(ceb.getOperating_period_to());
				executebus.setEOrgan(ceb.getRedistration_authority());
				executebus.setEAddress(ceb.getAddress());
				executebus.setEStatus(ceb.getEnterprise_status());
				executebus.setERemark(ceb.getBusiness_scope_mark());
				executebus.setUsers(user);
				executebus.setECCasecodeself(ceb.getCasecodeself());
				executebus.setESavetime(ceb.getSavetime());
				executebus.setEAnnual(ceb.getInspection_annual());
				executebus.setEResults(ceb.getInspection_results());
				executebus.setECancellation(ceb.getCancellation_date());
				executebus.setERevoke(ceb.getRevoke_date());
				executebus.setOrganization_code(ceb.getOrganization_code());
				executebus.setOrganization_code_issuing_agencies(ceb.getOrganization_code_issuing_agencies());
				executebus.setAdministrative_sanction_information(asiInfo);
				executebus.setAdverse_judicial_information(ajiInfo);
				executebus.setInvestor_information(invesInfo);
				executebus.setReinvestment_information(reinvesInfo);
				this.getHibernateTemplate().save(executebus);
						
			}
		}

		String sql3 = "UPDATE courtinfo SET executestep='2' WHERE casecodeself IN (SELECT casecodeself from `"+user.getUName()+"step2start`)";
		this.getSession().createSQLQuery(sql3).executeUpdate();
		String sql4 = "DELETE FROM enterprise_info WHERE casecodeself IN (SELECT casecodeself from `"+user.getUName()+"step2start`)";
		this.getSession().createSQLQuery(sql4).executeUpdate();
		sql4 = "DELETE FROM administrative_sanction_information";
		this.getSession().createSQLQuery(sql4).executeUpdate();
		sql4 = "DELETE FROM adverse_judicial_information ";
		this.getSession().createSQLQuery(sql4).executeUpdate();
		sql4 = "DELETE FROM investor_information";
		this.getSession().createSQLQuery(sql4).executeUpdate();
		sql4 = "DELETE FROM reinvestment_information";
		this.getSession().createSQLQuery(sql4).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Executebusiness> selExecutebusiness(Executebusiness executebus)
			throws Exception {
		String hql = "from Executebusiness exb where exb.ECCasecodeself='"
				+ executebus.getECCasecodeself() + "' and exb.EName like '%"
				+ executebus.getEName() + "%'";
		return this.getHibernateTemplate().find(hql);

	}

	@Override
	public void Executebusiness(List<com.lawyer.pojo.Executebusiness> list) {
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for (int i = 0; i < list.size(); i++) {
			Executebusiness exb = list.get(i);
			String sqlstr = "UPDATE executebusiness SET  e_status = '"+exb.getEStatus()+"',e_savetime='"+df1.format(new Date())+"' WHERE e_name='"+exb.getEName()+"' AND e_status != '"+exb.getEStatus()+"'";
		//	String sql = "UPDATE executebusiness SET e_status='"+exb.getEStatus()+"' WHERE e_name = '"
		//		+ exb.getEName() + "' ";
		this.getSession().createSQLQuery(sqlstr).executeUpdate();
		}
	}

	@Override
	public void updateExecutes(Executebusiness exbusiness)
			throws Exception {
		this.getHibernateTemplate().update(exbusiness);
		
//		for (int i = 0; i < exbusinessOlds.size(); i++) {
//			Executebusiness exb = exbusinessOlds.get(i);
//			if(exb.getEStatus()!=null && !exb.getEStatus().equals("")){
//				String sqlstr = "UPDATE executebusiness SET  e_status = '"+exb.getEStatus()+"' WHERE e_c_casecodeself='"+exb.getECCasecodeself()+"'";
//				this.getSession().createSQLQuery(sqlstr).executeUpdate();
//			}
//			
////			this.getHibernateTemplate().update(exbusinessOlds.get(i));
//		}
	}
}
