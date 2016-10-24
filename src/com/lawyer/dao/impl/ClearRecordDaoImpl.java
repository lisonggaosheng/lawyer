package com.lawyer.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ClearRecordDao;
import com.lawyer.pojo.ClearClear;
import com.lawyer.pojo.ClearRecord;
import com.lawyer.pojo.CloseRecord;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Execute;
import com.lawyer.pojo.Litigation;
import com.lawyer.pojo.MaintainCustomers;
import com.lawyer.pojo.Material;

public class ClearRecordDaoImpl extends HibernateDaoSupport implements
		ClearRecordDao {
	/**
	 * 高级查询案件信息修改——郭志鹏
	 */
	public List<?> seniorSelectNew(final int currentPage, final int pageSize,
			final ContractSign cont) throws Exception {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				StringBuffer mysql = new StringBuffer();
				mysql.append("select contractsi0_.cs_id as cs1_16_0_,contractsi0_.cs_uid as cs2_16_0_,contractsi0_.cs_date as cs3_16_0_, contractsi0_.cs_ale as cs4_16_0_, contractsi0_.cs_name as cs5_16_0_,contractsi0_.cs_tel as cs6_16_0_,contractsi0_.cs_no as cs7_16_0_,contractsi0_.cs_remark as cs8_16_0_,contractsi0_.cs_attach as cs9_16_0_,contractsi0_.cs_casecodeself as cs10_16_0_,c.pname,a.a_name ");
				mysql.append("from ");
				mysql.append("lawyer.contact_sign contractsi0_  inner join courtinfo c on contractsi0_.cs_casecodeself=c.casecodeself inner join applierinfo a on cs_casecodeself=a.a_c_casecodeself  ");
				if(cont.getClearrecord()!= null){
					mysql.append("left join lawyer.clear_record clearrecor1_ ");
					mysql.append("on contractsi0_.cs_casecodeself=clearrecor1_.cr_casecodeself ");
				}
				if(cont.getClearclear() != null){
					mysql.append("left join lawyer.clear_clear clearclear2_ ");
					mysql.append("on contractsi0_.cs_casecodeself=clearclear2_.cc_casecodeself ");
				}
				if(cont.getLitigation() !=null){
					mysql.append("left join lawyer.litigation litigation3_ ");
					mysql.append("on contractsi0_.cs_casecodeself=litigation3_.li_casecodeself ");
				}
				if(cont.getExecute()!=null){
					mysql.append("left join lawyer.execute execute4_ ");
					mysql.append("on contractsi0_.cs_casecodeself=execute4_.ex_casecodeself ");
				}
				if(cont.getCloserecord()!=null){
					mysql.append("left join lawyer.close_record closerecor5_ ");
					mysql.append("on contractsi0_.cs_casecodeself=closerecor5_.cr_casecodeself ");
				}
				mysql.append("where ");
				mysql.append(" contractsi0_.cs_no like '%"+cont.getCsNo().trim()+"%' ");
				
				if (!"".equals(cont.getCsName().trim()))
					mysql.append(" and contractsi0_.cs_name like '%"+cont.getCsName().trim()+"%' ");
				if (!"".equals(cont.getCsTel().trim()))
					mysql.append(" and contractsi0_.cs_tel like '%"+cont.getCsTel().trim()+"%' ");
				if(!"".equals(cont.getContMinTime().trim()) && !"".equals(cont.getContMaxTime().trim())){
					mysql.append("and contractsi0_.cs_date BETWEEN '"+cont.getContMinTime().trim()+"' and '"+cont.getContMaxTime().trim()+"' ");
				}
				
				if (!"".equals(cont.getClearrecord().getCrnumber().trim()))
					mysql.append(" and clearrecor1_.cr_number like '%"+cont.getClearrecord().getCrnumber().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrcontactjudge().trim()))
					mysql.append("and clearrecor1_.cr_contact_judge like '%"+cont.getClearrecord().getCrcontactjudge().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrcontacttel().trim()))
					mysql.append("and clearrecor1_.cr_contact_tel like '%"+cont.getClearrecord().getCrcontacttel().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrlawname().trim()))
					mysql.append("and clearrecor1_.cr_lawname like '%"+cont.getClearrecord().getCrlawname().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrlawtel().trim()))
					mysql.append("and clearrecor1_.cr_lawtel like '%"+cont.getClearrecord().getCrlawtel().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrfollowupresult().trim()))
					mysql.append("and clearrecor1_.cr_followupresult like '%"+cont.getClearrecord().getCrfollowupresult().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getAssistingName().trim()))
					mysql.append("and clearrecor1_.assisting_name like '%"+cont.getClearrecord().getAssistingName().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getAssistingTel().trim()))
					mysql.append("and clearrecor1_.assisting_tel like '%"+cont.getClearrecord().getAssistingTel().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCompetentCourt().trim()))
					mysql.append("and clearrecor1_.competent_court like '%"+cont.getClearrecord().getCompetentCourt().trim()+"%' ");
				if(!"".equals(cont.getClearrecord().getClearrecordMinTime().trim()) && !"".equals(cont.getClearrecord().getClearrecordMaxTime().trim())){
					mysql.append("and clearrecor1_.cr_date BETWEEN '"+cont.getClearrecord().getClearrecordMinTime().trim()+"' and '"+cont.getClearrecord().getClearrecordMaxTime().trim()+"' ");
				}
				
				
				if (!"".equals(cont.getClearclear().getCcnumber().trim()))
					mysql.append("and clearclear2_.cc_number like '%"+cont.getClearclear().getCcnumber().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCcjudge().trim()))
					mysql.append("and clearclear2_.cc_judge like '%"+cont.getClearclear().getCcjudge().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCcjudgetel().trim()))
					mysql.append("and clearclear2_.cc_judgetel like '%"+cont.getClearclear().getCcjudgetel().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCclawname().trim()))
					mysql.append("and clearclear2_.cc_lawname like '%"+cont.getClearclear().getCclawname().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCclawnametel().trim()))
					mysql.append("and clearclear2_.cc_lawnametel like '%"+cont.getClearclear().getCclawnametel().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCcfollowupresult().trim()))
					mysql.append("and clearclear2_.cr_followupresult like '%"+cont.getClearclear().getCcfollowupresult().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getAssistingName().trim()))
					mysql.append("and clearclear2_.assisting_name like '%"+cont.getClearclear().getAssistingName().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getAssistingTel().trim()))
					mysql.append("and clearclear2_.assisting_tel like '%"+cont.getClearclear().getAssistingTel().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCompetentCourt().trim()))
					mysql.append("and clearclear2_.competent_court like '%"+cont.getClearclear().getCompetentCourt().trim()+"%' ");
				
				
				if (!"".equals(cont.getLitigation().getLinumber().trim()))
					mysql.append("and litigation3_.li_number like '%"+cont.getLitigation().getLinumber().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLijudge().trim()))
					mysql.append("and litigation3_.li_judge like '%"+cont.getLitigation().getLijudge().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLijudgetel().trim()))
					mysql.append("and litigation3_.li_judgetel like '%"+cont.getLitigation().getLijudgetel().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLilawname().trim()))
					mysql.append("and litigation3_.li_lawname like '%"+cont.getLitigation().getLilawname().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLilawtel().trim()))
					mysql.append("and litigation3_.li_lawtel like '%"+cont.getLitigation().getLilawtel().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLifollowupresult().trim()))
					mysql.append("and litigation3_.li_followupresult like '%"+cont.getLitigation().getLifollowupresult().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getAssistingName().trim()))
					mysql.append("and litigation3_.assisting_name like '%"+cont.getLitigation().getAssistingName().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getAssistingTel().trim()))
					mysql.append("and litigation3_.assisting_tel like '%"+cont.getLitigation().getAssistingTel().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getCompetentCourt().trim()))
					mysql.append("and litigation3_.competent_court like '%"+cont.getLitigation().getCompetentCourt().trim()+"%' ");
				if(!"".equals(cont.getLitigation().getLitigationMinTime().trim()) && !"".equals(cont.getLitigation().getLitigationMaxTime().trim())){
					mysql.append("and litigation3_.li_date BETWEEN '"+cont.getLitigation().getLitigationMinTime().trim()+"' and '"+cont.getLitigation().getLitigationMaxTime().trim()+"' ");
				}
				if(!"".equals(cont.getLitigation().getLitigationMinMoney().trim()) || !"".equals(cont.getLitigation().getLitigationMaxMoney().trim())){
					if("".equals(cont.getLitigation().getLitigationMinMoney().trim().trim())) cont.getLitigation().setLitigationMinMoney("0");
					if("".equals(cont.getLitigation().getLitigationMaxMoney().trim().trim())) cont.getLitigation().setLitigationMaxMoney("111111111111");
					mysql.append("and litigation3_.li_fund BETWEEN '"+cont.getLitigation().getLitigationMinMoney().trim()+"' and '"+cont.getLitigation().getLitigationMaxMoney().trim()+"' ");
				}
				
				
				
				if (!"".equals(cont.getExecute().getExnumber().trim()))
					mysql.append("and execute4_.ex_number like '%"+cont.getExecute().getExnumber().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExjudge().trim()))
					mysql.append("and execute4_.ex_judge like '%"+cont.getExecute().getExjudge().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExjudgetel().trim()))
					mysql.append("and execute4_.ex_judgetel like '%"+cont.getExecute().getExjudgetel().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExlawname().trim()))
					mysql.append("and execute4_.ex_lawname like '%"+cont.getExecute().getExlawname().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExlawtel().trim()))
					mysql.append("and execute4_.ex_lawtel like '%"+cont.getExecute().getExlawtel().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExfollowupresult().trim()))
					mysql.append("and execute4_.ex_followupresult like '%"+cont.getExecute().getExfollowupresult().trim()+"%' ");
				if (!"".equals(cont.getExecute().getAssistingName().trim()))
					mysql.append("and execute4_.assisting_name like '%"+cont.getExecute().getAssistingName().trim()+"%' ");
				if (!"".equals(cont.getExecute().getAssistingTel().trim()))
					mysql.append("and execute4_.assisting_tel like '%"+cont.getExecute().getAssistingTel().trim()+"%' ");
				if (!"".equals(cont.getExecute().getCompetentCourt().trim()))
					mysql.append("and execute4_.competent_court like '%"+cont.getExecute().getCompetentCourt().trim()+"%' ");
				if(!"".equals(cont.getExecute().getExecuteMinTime().trim()) && !"".equals(cont.getExecute().getExecuteMaxTime().trim())){
					mysql.append("and execute4_.ex_date BETWEEN '"+cont.getExecute().getExecuteMinTime()+"' and '"+cont.getExecute().getExecuteMaxTime()+"' ");
				}
				if(!"".equals(cont.getExecute().getExecuteMinMoney().trim()) || !"".equals(cont.getExecute().getExecuteMaxMoney().trim())){
					if("".equals(cont.getExecute().getExecuteMinMoney().trim().trim())) cont.getExecute().setExecuteMinMoney("0");
					if("".equals(cont.getExecute().getExecuteMaxMoney().trim().trim())) cont.getExecute().setExecuteMaxMoney("111111111111");
					mysql.append("and litigation3_.li_fund BETWEEN '"+cont.getExecute().getExecuteMinMoney().trim()+"' and '"+cont.getExecute().getExecuteMaxMoney().trim()+"' ");
				}
				
				
				
				if (!"".equals(cont.getCloserecord().getCrperson().trim()))
					mysql.append("and closerecor5_.cr_person like '%"+cont.getCloserecord().getCrperson().trim()+"%' ");
				if (!"".equals(cont.getCloserecord().getCrpersontel().trim()))
					mysql.append("and closerecor5_.cr_persontel like '%"+cont.getCloserecord().getCrpersontel().trim()+"%' ");
				if(!"".equals(cont.getCloserecord().getCloserecordMinTime().trim()) && !"".equals(cont.getCloserecord().getCloserecordMaxTime().trim())){
					mysql.append("and closerecor5_.cr_time BETWEEN '"+cont.getCloserecord().getCloserecordMinTime().trim()+"' and '"+cont.getCloserecord().getCloserecordMaxTime().trim()+"' ");
				}
				
				mysql.append("");
				mysql.append(" group by contractsi0_.cs_id limit "+(currentPage-1)*pageSize+","+pageSize);
				String sql = mysql.toString();
				Query query = session.createSQLQuery(sql);
				
				return query.list();
			}
		});
		
	}

	public Object seniorSelectPageSizeNew(final int pageSize,
			final ContractSign cont) {

		return this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer mysql = new StringBuffer();
				mysql.append("select count(distinct contractsi0_.cs_id) ");
				mysql.append("from ");
				mysql.append("lawyer.contact_sign contractsi0_  inner join courtinfo c on contractsi0_.cs_casecodeself=c.casecodeself inner join applierinfo a on cs_casecodeself=a.a_c_casecodeself  ");
				if(cont.getClearrecord()!= null){
					mysql.append("left join lawyer.clear_record clearrecor1_ ");
					mysql.append("on contractsi0_.cs_casecodeself=clearrecor1_.cr_casecodeself ");
				}
				if(cont.getClearclear() != null){
					mysql.append("left join lawyer.clear_clear clearclear2_ ");
					mysql.append("on contractsi0_.cs_casecodeself=clearclear2_.cc_casecodeself ");
				}
				if(cont.getLitigation() !=null){
					mysql.append("left join lawyer.litigation litigation3_ ");
					mysql.append("on contractsi0_.cs_casecodeself=litigation3_.li_casecodeself ");
				}
				if(cont.getExecute()!=null){
					mysql.append("left join lawyer.execute execute4_ ");
					mysql.append("on contractsi0_.cs_casecodeself=execute4_.ex_casecodeself ");
				}
				if(cont.getCloserecord()!=null){
					mysql.append("left join lawyer.close_record closerecor5_ ");
					mysql.append("on contractsi0_.cs_casecodeself=closerecor5_.cr_casecodeself ");
				}
				mysql.append("where ");
				mysql.append(" contractsi0_.cs_no like '%"+cont.getCsNo().trim()+"%' ");
				
				if (!"".equals(cont.getCsName().trim()))
					mysql.append(" and contractsi0_.cs_name like '%"+cont.getCsName().trim()+"%' ");
				if (!"".equals(cont.getCsTel().trim()))
					mysql.append(" and contractsi0_.cs_tel like '%"+cont.getCsTel().trim()+"%' ");
				if(!"".equals(cont.getContMinTime().trim()) && !"".equals(cont.getContMaxTime().trim())){
					mysql.append("and contractsi0_.cs_date BETWEEN '"+cont.getContMinTime().trim()+"' and '"+cont.getContMaxTime().trim()+"' ");
				}
				
				if (!"".equals(cont.getClearrecord().getCrnumber().trim()))
					mysql.append(" and clearrecor1_.cr_number like '%"+cont.getClearrecord().getCrnumber().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrcontactjudge().trim()))
					mysql.append("and clearrecor1_.cr_contact_judge like '%"+cont.getClearrecord().getCrcontactjudge().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrcontacttel().trim()))
					mysql.append("and clearrecor1_.cr_contact_tel like '%"+cont.getClearrecord().getCrcontacttel().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrlawname().trim()))
					mysql.append("and clearrecor1_.cr_lawname like '%"+cont.getClearrecord().getCrlawname().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrlawtel().trim()))
					mysql.append("and clearrecor1_.cr_lawtel like '%"+cont.getClearrecord().getCrlawtel().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCrfollowupresult().trim()))
					mysql.append("and clearrecor1_.cr_followupresult like '%"+cont.getClearrecord().getCrfollowupresult().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getAssistingName().trim()))
					mysql.append("and clearrecor1_.assisting_name like '%"+cont.getClearrecord().getAssistingName().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getAssistingTel().trim()))
					mysql.append("and clearrecor1_.assisting_tel like '%"+cont.getClearrecord().getAssistingTel().trim()+"%' ");
				if (!"".equals(cont.getClearrecord().getCompetentCourt().trim()))
					mysql.append("and clearrecor1_.competent_court like '%"+cont.getClearrecord().getCompetentCourt().trim()+"%' ");
				if(!"".equals(cont.getClearrecord().getClearrecordMinTime().trim()) && !"".equals(cont.getClearrecord().getClearrecordMaxTime().trim())){
					mysql.append("and clearrecor1_.cr_date BETWEEN '"+cont.getClearrecord().getClearrecordMinTime().trim()+"' and '"+cont.getClearrecord().getClearrecordMaxTime().trim()+"' ");
				}
				
				
				if (!"".equals(cont.getClearclear().getCcnumber().trim()))
					mysql.append("and clearclear2_.cc_number like '%"+cont.getClearclear().getCcnumber().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCcjudge().trim()))
					mysql.append("and clearclear2_.cc_judge like '%"+cont.getClearclear().getCcjudge().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCcjudgetel().trim()))
					mysql.append("and clearclear2_.cc_judgetel like '%"+cont.getClearclear().getCcjudgetel().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCclawname().trim()))
					mysql.append("and clearclear2_.cc_lawname like '%"+cont.getClearclear().getCclawname().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCclawnametel().trim()))
					mysql.append("and clearclear2_.cc_lawnametel like '%"+cont.getClearclear().getCclawnametel().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCcfollowupresult().trim()))
					mysql.append("and clearclear2_.cr_followupresult like '%"+cont.getClearclear().getCcfollowupresult().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getAssistingName().trim()))
					mysql.append("and clearclear2_.assisting_name like '%"+cont.getClearclear().getAssistingName().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getAssistingTel().trim()))
					mysql.append("and clearclear2_.assisting_tel like '%"+cont.getClearclear().getAssistingTel().trim()+"%' ");
				if (!"".equals(cont.getClearclear().getCompetentCourt().trim()))
					mysql.append("and clearclear2_.competent_court like '%"+cont.getClearclear().getCompetentCourt().trim()+"%' ");
				
				
				if (!"".equals(cont.getLitigation().getLinumber().trim()))
					mysql.append("and litigation3_.li_number like '%"+cont.getLitigation().getLinumber().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLijudge().trim()))
					mysql.append("and litigation3_.li_judge like '%"+cont.getLitigation().getLijudge().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLijudgetel().trim()))
					mysql.append("and litigation3_.li_judgetel like '%"+cont.getLitigation().getLijudgetel().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLilawname().trim()))
					mysql.append("and litigation3_.li_lawname like '%"+cont.getLitigation().getLilawname().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLilawtel().trim()))
					mysql.append("and litigation3_.li_lawtel like '%"+cont.getLitigation().getLilawtel().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getLifollowupresult().trim()))
					mysql.append("and litigation3_.li_followupresult like '%"+cont.getLitigation().getLifollowupresult().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getAssistingName().trim()))
					mysql.append("and litigation3_.assisting_name like '%"+cont.getLitigation().getAssistingName().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getAssistingTel().trim()))
					mysql.append("and litigation3_.assisting_tel like '%"+cont.getLitigation().getAssistingTel().trim()+"%' ");
				if (!"".equals(cont.getLitigation().getCompetentCourt().trim()))
					mysql.append("and litigation3_.competent_court like '%"+cont.getLitigation().getCompetentCourt().trim()+"%' ");
				if(!"".equals(cont.getLitigation().getLitigationMinTime().trim()) && !"".equals(cont.getLitigation().getLitigationMaxTime().trim())){
					mysql.append("and litigation3_.li_date BETWEEN '"+cont.getLitigation().getLitigationMinTime().trim()+"' and '"+cont.getLitigation().getLitigationMaxTime().trim()+"' ");
				}
				if(!"".equals(cont.getLitigation().getLitigationMinMoney().trim()) || !"".equals(cont.getLitigation().getLitigationMaxMoney().trim())){
					if("".equals(cont.getLitigation().getLitigationMinMoney().trim().trim())) cont.getLitigation().setLitigationMinMoney("0");
					if("".equals(cont.getLitigation().getLitigationMaxMoney().trim().trim())) cont.getLitigation().setLitigationMaxMoney("111111111111");
					mysql.append("and litigation3_.li_fund BETWEEN '"+cont.getLitigation().getLitigationMinMoney().trim()+"' and '"+cont.getLitigation().getLitigationMaxMoney().trim()+"' ");
				}
				
				
				
				if (!"".equals(cont.getExecute().getExnumber().trim()))
					mysql.append("and execute4_.ex_number like '%"+cont.getExecute().getExnumber().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExjudge().trim()))
					mysql.append("and execute4_.ex_judge like '%"+cont.getExecute().getExjudge().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExjudgetel().trim()))
					mysql.append("and execute4_.ex_judgetel like '%"+cont.getExecute().getExjudgetel().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExlawname().trim()))
					mysql.append("and execute4_.ex_lawname like '%"+cont.getExecute().getExlawname().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExlawtel().trim()))
					mysql.append("and execute4_.ex_lawtel like '%"+cont.getExecute().getExlawtel().trim()+"%' ");
				if (!"".equals(cont.getExecute().getExfollowupresult().trim()))
					mysql.append("and execute4_.ex_followupresult like '%"+cont.getExecute().getExfollowupresult().trim()+"%' ");
				if (!"".equals(cont.getExecute().getAssistingName().trim()))
					mysql.append("and execute4_.assisting_name like '%"+cont.getExecute().getAssistingName().trim()+"%' ");
				if (!"".equals(cont.getExecute().getAssistingTel().trim()))
					mysql.append("and execute4_.assisting_tel like '%"+cont.getExecute().getAssistingTel().trim()+"%' ");
				if (!"".equals(cont.getExecute().getCompetentCourt().trim()))
					mysql.append("and execute4_.competent_court like '%"+cont.getExecute().getCompetentCourt().trim()+"%' ");
				if(!"".equals(cont.getExecute().getExecuteMinTime().trim()) && !"".equals(cont.getExecute().getExecuteMaxTime().trim())){
					mysql.append("and execute4_.ex_date BETWEEN '"+cont.getExecute().getExecuteMinTime()+"' and '"+cont.getExecute().getExecuteMaxTime()+"' ");
				}
				if(!"".equals(cont.getExecute().getExecuteMinMoney().trim()) || !"".equals(cont.getExecute().getExecuteMaxMoney().trim())){
					if("".equals(cont.getExecute().getExecuteMinMoney().trim().trim())) cont.getExecute().setExecuteMinMoney("0");
					if("".equals(cont.getExecute().getExecuteMaxMoney().trim().trim())) cont.getExecute().setExecuteMaxMoney("111111111111");
					mysql.append("and litigation3_.li_fund BETWEEN '"+cont.getExecute().getExecuteMinMoney().trim()+"' and '"+cont.getExecute().getExecuteMaxMoney().trim()+"' ");
				}
				
				
				
				if (!"".equals(cont.getCloserecord().getCrperson().trim()))
					mysql.append("and closerecor5_.cr_person like '%"+cont.getCloserecord().getCrperson().trim()+"%' ");
				if (!"".equals(cont.getCloserecord().getCrpersontel().trim()))
					mysql.append("and closerecor5_.cr_persontel like '%"+cont.getCloserecord().getCrpersontel().trim()+"%' ");
				if(!"".equals(cont.getCloserecord().getCloserecordMinTime().trim()) && !"".equals(cont.getCloserecord().getCloserecordMaxTime().trim())){
					mysql.append("and closerecor5_.cr_time BETWEEN '"+cont.getCloserecord().getCloserecordMinTime().trim()+"' and '"+cont.getCloserecord().getCloserecordMaxTime().trim()+"' ");
				}
				
				mysql.append("");
				
				String sql = mysql.toString();
				Query query = session.createSQLQuery(sql);
				
				return query.list().get(0);
			}
		});

	}
	
	/**
	 * 高级查询案件信息——李梦翔
	 */
	public List<?> seniorSelect(final int currentPage, final int pageSize,
			final String... params) throws Exception {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				StringBuffer mysql = new StringBuffer();
				mysql.append("select contractsi0_.cs_id as cs1_16_0_,contractsi0_.cs_uid as cs2_16_0_,contractsi0_.cs_date as cs3_16_0_, contractsi0_.cs_ale as cs4_16_0_, contractsi0_.cs_name as cs5_16_0_,contractsi0_.cs_tel as cs6_16_0_,contractsi0_.cs_no as cs7_16_0_,contractsi0_.cs_remark as cs8_16_0_,contractsi0_.cs_attach as cs9_16_0_,contractsi0_.cs_casecodeself as cs10_16_0_,c.pname,a.a_name ");
				mysql.append("from ");
				mysql.append("lawyer.contact_sign contractsi0_  inner join courtinfo c on contractsi0_.cs_casecodeself=c.casecodeself inner join applierinfo a on cs_casecodeself=a.a_c_casecodeself  ");
				if(!"".equals(params[4].trim()) || !"".equals(params[5].trim()) || !"".equals(params[6].trim()) || !"".equals(params[7].trim()) || !"".equals(params[8].trim()) || !"".equals(params[9].trim()) || !"".equals(params[32].trim()) || !"".equals(params[33].trim())){
					mysql.append("left join lawyer.clear_record clearrecor1_ ");
					mysql.append("on contractsi0_.cs_casecodeself=clearrecor1_.cr_casecodeself ");
				}
				if(!"".equals(params[10].trim()) || !"".equals(params[11].trim()) || !"".equals(params[12].trim()) || !"".equals(params[13].trim()) || !"".equals(params[14].trim()) || !"".equals(params[15].trim())){
					mysql.append("left join lawyer.clear_clear clearclear2_ ");
					mysql.append("on contractsi0_.cs_casecodeself=clearclear2_.cc_casecodeself ");
				}
				if(!"".equals(params[16].trim()) || !"".equals(params[17].trim()) || !"".equals(params[18].trim()) || !"".equals(params[19].trim()) || !"".equals(params[20].trim()) || !"".equals(params[21].trim()) || !"".equals(params[34].trim()) || !"".equals(params[35].trim()) || !"".equals(params[36].trim()) || !"".equals(params[37].trim())){
					mysql.append("left join lawyer.litigation litigation3_ ");
					mysql.append("on contractsi0_.cs_casecodeself=litigation3_.li_casecodeself ");
				}
				if(!"".equals(params[22].trim()) || !"".equals(params[23].trim()) || !"".equals(params[24].trim()) || !"".equals(params[25].trim()) || !"".equals(params[26].trim()) || !"".equals(params[27].trim()) || !"".equals(params[38].trim()) || !"".equals(params[39].trim())){
					mysql.append("left join lawyer.execute execute4_ ");
					mysql.append("on contractsi0_.cs_casecodeself=execute4_.ex_casecodeself ");
				}
				if(!"".equals(params[28].trim()) || !"".equals(params[29].trim()) || !"".equals(params[40].trim()) || !"".equals(params[41].trim())){
					mysql.append("left join lawyer.close_record closerecor5_ ");
					mysql.append("on contractsi0_.cs_casecodeself=closerecor5_.cr_casecodeself ");
				}
				mysql.append("where ");
				
				mysql.append("contractsi0_.cs_no like '%"+params[0]+"%' ");
				
				if (!"".equals(params[1].trim()))
					mysql.append("and contractsi0_.cs_ale like '%"+params[1]+"%' ");
				if (!"".equals(params[2].trim()))
					mysql.append("and contractsi0_.cs_name like '%"+params[2]+"%' ");
				if (!"".equals(params[3].trim()))
					mysql.append("and contractsi0_.cs_tel like '%"+params[3]+"%' ");
				
				if (!"".equals(params[4].trim()))
					mysql.append("and clearrecor1_.cr_number like '%"+params[4]+"%' ");
				if (!"".equals(params[5].trim()))
					mysql.append("and clearrecor1_.cr_contact_judge like '%"+params[5]+"%' ");
				if (!"".equals(params[6].trim()))
					mysql.append("and clearrecor1_.cr_contact_tel like '%"+params[6]+"%' ");
				if (!"".equals(params[7].trim()))
					mysql.append("and clearrecor1_.cr_lawname like '%"+params[7]+"%' ");
				if (!"".equals(params[8].trim()))
					mysql.append("and clearrecor1_.cr_lawtel like '%"+params[8]+"%' ");
				if (!"".equals(params[9].trim()))
					mysql.append("and clearrecor1_.cr_followupresult like '%"+params[9]+"%' ");
				
				if (!"".equals(params[10].trim()))
					mysql.append("and clearclear2_.cc_number like '%"+params[10]+"%' ");
				if (!"".equals(params[11].trim()))
					mysql.append("and clearclear2_.cc_judge like '%"+params[11]+"%' ");
				if (!"".equals(params[12].trim()))
					mysql.append("and clearclear2_.cc_judgetel like '%"+params[12]+"%' ");
				if (!"".equals(params[13].trim()))
					mysql.append("and clearclear2_.cc_lawname like '%"+params[13]+"%' ");
				if (!"".equals(params[14].trim()))
					mysql.append("and clearclear2_.cc_lawnametel like '%"+params[14]+"%' ");
				if (!"".equals(params[15].trim()))
					mysql.append("and clearclear2_.cr_followupresult like '%"+params[15]+"%' ");
				
				if (!"".equals(params[16].trim()))
					mysql.append("and litigation3_.li_number like '%"+params[16]+"%' ");
				if (!"".equals(params[17].trim()))
					mysql.append("and litigation3_.li_judge like '%"+params[17]+"%' ");
				if (!"".equals(params[18].trim()))
					mysql.append("and litigation3_.li_judgetel like '%"+params[18]+"%' ");
				if (!"".equals(params[19].trim()))
					mysql.append("and litigation3_.li_lawname like '%"+params[19]+"%' ");
				if (!"".equals(params[20].trim()))
					mysql.append("and litigation3_.li_lawtel like '%"+params[20]+"%' ");
				if (!"".equals(params[21].trim()))
					mysql.append("and litigation3_.li_followupresult like '%"+params[21]+"%' ");
				
				if (!"".equals(params[22].trim()))
					mysql.append("and execute4_.ex_number like '%"+params[22]+"%' ");
				if (!"".equals(params[23].trim()))
					mysql.append("and execute4_.ex_judge like '%"+params[23]+"%' ");
				if (!"".equals(params[24].trim()))
					mysql.append("and execute4_.ex_judgetel like '%"+params[24]+"%' ");
				if (!"".equals(params[25].trim()))
					mysql.append("and execute4_.ex_lawname like '%"+params[25]+"%' ");
				if (!"".equals(params[26].trim()))
					mysql.append("and execute4_.ex_lawtel like '%"+params[26]+"%' ");
				if (!"".equals(params[27].trim()))
					mysql.append("and execute4_.ex_followupresult like '%"+params[27]+"%' ");
				
				if (!"".equals(params[28].trim()))
					mysql.append("and closerecor5_.cr_person like '%"+params[28]+"%' ");
				if (!"".equals(params[29].trim()))
					mysql.append("and closerecor5_.cr_persontel like '%"+params[29]+"%' ");
				
				if(!"".equals(params[30].trim()) || !"".equals(params[31].trim())){
					if("".equals(params[30].trim())) params[30]="1111年11月11日";
					if("".equals(params[31].trim())) params[31]="2222年02月02日";
					mysql.append("and contractsi0_.cs_date BETWEEN '"+params[30]+"' and '"+params[31]+"' ");
				}
				if(!"".equals(params[32].trim()) || !"".equals(params[33].trim())){
					if("".equals(params[32].trim())) params[32]="1111年11月11日";
					if("".equals(params[33].trim())) params[33]="2222年02月02日";
					mysql.append("and clearrecor1_.cr_date BETWEEN '"+params[32]+"' and '"+params[33]+"' ");
				}
				
				if(!"".equals(params[34].trim()) || !"".equals(params[35].trim())){
					if("".equals(params[34].trim())) params[34]="1111年11月11日";
					if("".equals(params[35].trim())) params[35]="2222年02月02日";
					mysql.append("and litigation3_.li_date BETWEEN '"+params[34]+"' and '"+params[35]+"' ");
				}
				
				if(!"".equals(params[36].trim()) || !"".equals(params[37].trim())){
					if("".equals(params[36].trim())) params[36]="0";
					if("".equals(params[37].trim())) params[37]="111111111111";
					mysql.append("and litigation3_.li_fund BETWEEN '"+params[36]+"' and '"+params[37]+"' ");
				}
				
				if(!"".equals(params[38].trim()) || !"".equals(params[39].trim())){
					if("".equals(params[38].trim())) params[38]="1111年11月11日";
					if("".equals(params[39].trim())) params[39]="2222年02月02日";
					mysql.append("and execute4_.ex_date BETWEEN '"+params[38]+"' and '"+params[39]+"' ");
				}
				
				if(!"".equals(params[40].trim()) || !"".equals(params[41].trim())){
					if("".equals(params[40].trim())) params[40]="1111年11月11日";
					if("".equals(params[41].trim())) params[41]="2222年02月02日";
					mysql.append("and closerecor5_.cr_time BETWEEN '"+params[40]+"' and '"+params[41]+"' ");
				}
				
				mysql.append("");
				mysql.append(" limit "+(currentPage-1)*pageSize+","+pageSize);
				String sql = mysql.toString();
				Query query = session.createSQLQuery(sql);
				
				return query.list();
			}
		});
		
	}

	public Object seniorSelectPageSize(final int pageSize,
			final String... params) {

		return this.getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer mysql = new StringBuffer();
				mysql.append("select count(contractsi0_.cs_id) ");
				mysql.append("from ");
				mysql.append("lawyer.contact_sign contractsi0_  ");
				if(!"".equals(params[4].trim()) || !"".equals(params[5].trim()) || !"".equals(params[6].trim()) || !"".equals(params[7].trim()) || !"".equals(params[8].trim()) || !"".equals(params[9].trim()) || !"".equals(params[32].trim()) || !"".equals(params[33].trim())){
					mysql.append("left join lawyer.clear_record clearrecor1_ ");
					mysql.append("on contractsi0_.cs_casecodeself=clearrecor1_.cr_casecodeself ");
				}
				if(!"".equals(params[10].trim()) || !"".equals(params[11].trim()) || !"".equals(params[12].trim()) || !"".equals(params[13].trim()) || !"".equals(params[14].trim()) || !"".equals(params[15].trim())){
					mysql.append("left join lawyer.clear_clear clearclear2_ ");
					mysql.append("on contractsi0_.cs_casecodeself=clearclear2_.cc_casecodeself ");
				}
				if(!"".equals(params[16].trim()) || !"".equals(params[17].trim()) || !"".equals(params[18].trim()) || !"".equals(params[19].trim()) || !"".equals(params[20].trim()) || !"".equals(params[21].trim()) || !"".equals(params[34].trim()) || !"".equals(params[35].trim()) || !"".equals(params[36].trim()) || !"".equals(params[37].trim())){
					mysql.append("left join lawyer.litigation litigation3_ ");
					mysql.append("on contractsi0_.cs_casecodeself=litigation3_.li_casecodeself ");
				}
				if(!"".equals(params[22].trim()) || !"".equals(params[23].trim()) || !"".equals(params[24].trim()) || !"".equals(params[25].trim()) || !"".equals(params[26].trim()) || !"".equals(params[27].trim()) || !"".equals(params[38].trim()) || !"".equals(params[39].trim())){
					mysql.append("left join lawyer.execute execute4_ ");
					mysql.append("on contractsi0_.cs_casecodeself=execute4_.ex_casecodeself ");
				}
				if(!"".equals(params[28].trim()) || !"".equals(params[29].trim()) || !"".equals(params[40].trim()) || !"".equals(params[41].trim())){
					mysql.append("left join lawyer.close_record closerecor5_ ");
					mysql.append("on contractsi0_.cs_casecodeself=closerecor5_.cr_casecodeself ");
				}
				mysql.append("where ");
				
				mysql.append("contractsi0_.cs_no like '%"+params[0]+"%' ");
				
				if (!"".equals(params[1].trim()))
					mysql.append("and contractsi0_.cs_ale like '%"+params[1]+"%' ");
				if (!"".equals(params[2].trim()))
					mysql.append("and contractsi0_.cs_name like '%"+params[2]+"%' ");
				if (!"".equals(params[3].trim()))
					mysql.append("and contractsi0_.cs_tel like '%"+params[3]+"%' ");
				
				if (!"".equals(params[4].trim()))
					mysql.append("and clearrecor1_.cr_number like '%"+params[4]+"%' ");
				if (!"".equals(params[5].trim()))
					mysql.append("and clearrecor1_.cr_contact_judge like '%"+params[5]+"%' ");
				if (!"".equals(params[6].trim()))
					mysql.append("and clearrecor1_.cr_contact_tel like '%"+params[6]+"%' ");
				if (!"".equals(params[7].trim()))
					mysql.append("and clearrecor1_.cr_lawname like '%"+params[7]+"%' ");
				if (!"".equals(params[8].trim()))
					mysql.append("and clearrecor1_.cr_lawtel like '%"+params[8]+"%' ");
				if (!"".equals(params[9].trim()))
					mysql.append("and clearrecor1_.cr_followupresult like '%"+params[9]+"%' ");
				
				if (!"".equals(params[10].trim()))
					mysql.append("and clearclear2_.cc_number like '%"+params[10]+"%' ");
				if (!"".equals(params[11].trim()))
					mysql.append("and clearclear2_.cc_judge like '%"+params[11]+"%' ");
				if (!"".equals(params[12].trim()))
					mysql.append("and clearclear2_.cc_judgetel like '%"+params[12]+"%' ");
				if (!"".equals(params[13].trim()))
					mysql.append("and clearclear2_.cc_lawname like '%"+params[13]+"%' ");
				if (!"".equals(params[14].trim()))
					mysql.append("and clearclear2_.cc_lawnametel like '%"+params[14]+"%' ");
				if (!"".equals(params[15].trim()))
					mysql.append("and clearclear2_.cr_followupresult like '%"+params[15]+"%' ");
				
				if (!"".equals(params[16].trim()))
					mysql.append("and litigation3_.li_number like '%"+params[16]+"%' ");
				if (!"".equals(params[17].trim()))
					mysql.append("and litigation3_.li_judge like '%"+params[17]+"%' ");
				if (!"".equals(params[18].trim()))
					mysql.append("and litigation3_.li_judgetel like '%"+params[18]+"%' ");
				if (!"".equals(params[19].trim()))
					mysql.append("and litigation3_.li_lawname like '%"+params[19]+"%' ");
				if (!"".equals(params[20].trim()))
					mysql.append("and litigation3_.li_lawtel like '%"+params[20]+"%' ");
				if (!"".equals(params[21].trim()))
					mysql.append("and litigation3_.li_followupresult like '%"+params[21]+"%' ");
				
				if (!"".equals(params[22].trim()))
					mysql.append("and execute4_.ex_number like '%"+params[22]+"%' ");
				if (!"".equals(params[23].trim()))
					mysql.append("and execute4_.ex_judge like '%"+params[23]+"%' ");
				if (!"".equals(params[24].trim()))
					mysql.append("and execute4_.ex_judgetel like '%"+params[24]+"%' ");
				if (!"".equals(params[25].trim()))
					mysql.append("and execute4_.ex_lawname like '%"+params[25]+"%' ");
				if (!"".equals(params[26].trim()))
					mysql.append("and execute4_.ex_lawtel like '%"+params[26]+"%' ");
				if (!"".equals(params[27].trim()))
					mysql.append("and execute4_.ex_followupresult like '%"+params[27]+"%' ");
				
				if (!"".equals(params[28].trim()))
					mysql.append("and closerecor5_.cr_person like '%"+params[28]+"%' ");
				if (!"".equals(params[29].trim()))
					mysql.append("and closerecor5_.cr_persontel like '%"+params[29]+"%' ");
				
				if(!"".equals(params[30].trim()) || !"".equals(params[31].trim())){
					if("".equals(params[30].trim())) params[30]="1111年11月11日";
					if("".equals(params[31].trim())) params[31]="2222年02月02日";
					mysql.append("and contractsi0_.cs_date BETWEEN '"+params[30]+"' and '"+params[31]+"' ");
				}
				if(!"".equals(params[32].trim()) || !"".equals(params[33].trim())){
					if("".equals(params[32].trim())) params[32]="1111年11月11日";
					if("".equals(params[33].trim())) params[33]="2222年02月02日";
					mysql.append("and clearrecor1_.cr_date BETWEEN '"+params[32]+"' and '"+params[33]+"' ");
				}
				
				if(!"".equals(params[34].trim()) || !"".equals(params[35].trim())){
					if("".equals(params[34].trim())) params[34]="1111年11月11日";
					if("".equals(params[35].trim())) params[35]="2222年02月02日";
					mysql.append("and litigation3_.li_date BETWEEN '"+params[34]+"' and '"+params[35]+"' ");
				}
				
				if(!"".equals(params[36].trim()) || !"".equals(params[37].trim())){
					if("".equals(params[36].trim())) params[36]="0";
					if("".equals(params[37].trim())) params[37]="111111111111";
					mysql.append("and litigation3_.li_fund BETWEEN '"+params[36]+"' and '"+params[37]+"' ");
				}
				
				if(!"".equals(params[38].trim()) || !"".equals(params[39].trim())){
					if("".equals(params[38].trim())) params[38]="1111年11月11日";
					if("".equals(params[39].trim())) params[39]="2222年02月02日";
					mysql.append("and execute4_.ex_date BETWEEN '"+params[38]+"' and '"+params[39]+"' ");
				}
				
				if(!"".equals(params[40].trim()) || !"".equals(params[41].trim())){
					if("".equals(params[40].trim())) params[40]="1111年11月11日";
					if("".equals(params[41].trim())) params[41]="2222年02月02日";
					mysql.append("and closerecor5_.cr_time BETWEEN '"+params[40]+"' and '"+params[41]+"' ");
				}
				
				mysql.append("");
				
				String sql = mysql.toString();
				Query query = session.createSQLQuery(sql);
				
				return query.list().get(0);
			}
		});

	}
	
	
	/**
	 * 添加 立案信息——郭志鹏
	 */
	public void insertClearRecord(ClearRecord clearRecord) throws Exception {
		this.getHibernateTemplate().save(clearRecord);

	}


	@SuppressWarnings("unchecked")
	@Override
	public ContractSign selectDetal(String csCasecodeself) throws Exception {

		// 签约
		ContractSign contractsign = null;
		String hqlcs = "from ContractSign cs where cs.csCasecodeself='"
				+ csCasecodeself + "'";
		contractsign = (ContractSign) this.getHibernateTemplate().find(hqlcs)
				.iterator().next();

		//材料整理
		String hqlme = "from Material m where m.casecodeself='"
				+ csCasecodeself + "' order by savetime desc limit 1";
		List<Material> materials = this.getHibernateTemplate().find(hqlme);
		if(materials.size()<1){
			materials=null;
		}else{
			contractsign.setMaterial(materials.get(0));
		}
		
		// 立案
		String hqlcr = "from ClearRecord cr where cr.crcasecodeself='"
				+ csCasecodeself + "' order by crSaveTime desc";
		List<ClearRecord> clearrecords = this.getHibernateTemplate().find(hqlcr);
		if(clearrecords.size()<1){
			clearrecords=null;
		}else{
			contractsign.setClearrecord(clearrecords.get(0));
		}
		// 清算
	
		String hqlcc = "from ClearClear cc  where cc.cccasecodeself='"
				+ csCasecodeself + "' order by ccsaveTime desc";
		List<ClearClear> clearclears = this.getHibernateTemplate().find(hqlcc);
		if(clearclears.size()<1){
			clearclears=null;
		}else{
			contractsign.setClearclear(clearclears.get(0));
		}
		
		
		// 诉讼阶段
		String hqlli = "from Litigation  li  where li.licasecodeself='"
				+ csCasecodeself + "' order by lisaveTime desc";
		List<Litigation> litigations = this.getHibernateTemplate().find(hqlli);
		if(litigations.size()<1){
			litigations=null;
		}else{
			contractsign.setLitigation(litigations.get(0));
		}
		
		
		// 执行阶段
		String hqlex = "from Execute  ex  where ex.excasecodeself='"
				+ csCasecodeself + "' order by exsavetime desc";
		List<Execute> executes = this.getHibernateTemplate().find(hqlex);
		if(executes.size()<1){
			executes=null;
		}else{
			contractsign.setExecute(executes.get(0));
		}

		// 结案阶段
		CloseRecord closerecord = null;
		String hqlcl = "from CloseRecord  cl  where cl.crcasecodeself='"
				+ csCasecodeself + "'";
		List<?> closerecords = this.getHibernateTemplate().find(hqlcl);
		if (closerecords != null && closerecords.size() > 0) {
			closerecord = (CloseRecord) closerecords.iterator().next();
		}

		Hibernate.initialize(contractsign.getUsers());
//		contractsign.setClearrecords(clearrecords);
//		contractsign.setClearclears(clearclears);
//		contractsign.setLitigations(litigations);
//		contractsign.setExecutes(executes);
		contractsign.setCloserecord(closerecord);
		return contractsign;
	}

	@Override
	public void addClearrecord(ClearRecord clearrecord) throws Exception {
		this.getHibernateTemplate().save(clearrecord);
	}

	@Override
	public void addClearclear(ClearClear clearclear) throws Exception {
		this.getHibernateTemplate().save(clearclear);
	}

	@Override
	public void addLitigation(Litigation litigation) throws Exception {
		this.getHibernateTemplate().save(litigation);
	}

	@Override
	public void addExecute(Execute execute) throws Exception {
		this.getHibernateTemplate().save(execute);

	}

	@Override
	public void addClearClose(CloseRecord closeRecord) throws Exception {
		this.getHibernateTemplate().save(closeRecord);
	}

	@Override
	public ContractSign DaYinContractSign(String trim) throws Exception {
		String hqlcs = "from ContractSign cs where cs.csCasecodeself='"
			+ trim + "'";
		return (ContractSign) this.getHibernateTemplate().find(hqlcs).get(0);
	}

	@Override
	public List<ClearRecord> DaYinClearRecord(String trim) throws Exception {
		String hqlcr = "from ClearRecord cr where cr.crcasecodeself='"
				+ trim + "'";
		@SuppressWarnings("unchecked")
		List<ClearRecord> clearrecords = this.getHibernateTemplate().find(hqlcr);
		return clearrecords;
	}

	@Override
	public List<ClearClear> DaYinClearClear(String trim) throws Exception {
		String hqlcc = "from ClearClear cc  where cc.cccasecodeself='"
				+ trim + "'";
		@SuppressWarnings("unchecked")
		List<ClearClear> clearclears = this.getHibernateTemplate().find(hqlcc);
		return clearclears;
	}

	@Override
	public List<Litigation> DaYinLitigation(String trim) throws Exception {
		String hqlli = "from Litigation  li  where li.licasecodeself='"
			+ trim + "'";
	@SuppressWarnings("unchecked")
	List<Litigation> litigations = this.getHibernateTemplate().find(hqlli);
	return litigations;
	}

	@Override
	public List<Execute> DaYinExecute(String trim) throws Exception {
		String hqlex = "from Execute  ex  where ex.excasecodeself='"
				+ trim + "'";
		@SuppressWarnings("unchecked")
		List<Execute> executes = this.getHibernateTemplate().find(hqlex);
		return executes;
	}

	@Override
	public CloseRecord DaYinCloseRecord(String trim) throws Exception {
		CloseRecord closerecord = null;
		String hqlcl = "from CloseRecord  cl  where cl.crcasecodeself='"
				+ trim + "'";
		List<?> closerecords = this.getHibernateTemplate().find(hqlcl);
		if (closerecords != null && closerecords.size() > 0) {
			closerecord = (CloseRecord) closerecords.iterator().next();
		}
		return closerecord;
	}
	
	@SuppressWarnings("unchecked")
	public List<ContractSign> selectClearsNew(final int currentPage,
			final ContractSign cont, final String startDate,
			final String endDate) throws Exception {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "";
				if (startDate != null && endDate != null
						&& !startDate.equals("") && !endDate.equals("")) {
					sql += " s.csDate between '" + startDate + "' and '"
							+ endDate + "' and ";
				}
				if (cont != null) {
					if (cont.getCsId() != null) {
						sql += " s.csId=" + cont.getCsId() + "and ";
					}
					if (cont.getCsNo() != null
							&& !cont.getCsNo().equals("")) {
						sql += " s.csNo like '%" + cont.getCsNo() + "%' and ";
					}
					if (cont.getCsName() != null
							&& !cont.getCsName().equals("")) {
						sql += " s.csName like '%" + cont.getCsName() + "%' and ";
					}
					if (cont.getPname() != null
							&& !cont.getPname().equals("")) {
						sql += " c.pname like '%" + cont.getPname() + "%' and ";
					}
					if (cont.getAppName() != null
							&& !cont.getAppName().equals("")) {
						sql += " a.appName like '%" + cont.getAppName() + "%' and ";
					}
				}
				
				String hql = "select s.csId,s.csDate,s.csName,s.csTel,s.csNo,s.csRemark,s.csCasecodeself,s.csCaseID,c.pname,a.appName from ContractSign s,Court c,Applierinfo a where s.csCasecodeself=c.casecodeself and s.csCasecodeself=a.appCCasecodeself and c.executestep=7 and " + sql;
				hql = hql.substring(0, hql.length() - 4) + " GROUP BY s.csId order by s.csId asc";
				Query query = session.createQuery(hql);
				query.setFirstResult((currentPage - 1) * 10);
				query.setMaxResults(10);
				return query.list();
			}
		});
	}

	public Object selectClearsPageSizeNew(final ContractSign cont,
			final String startDate, final String endDate) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String sql = "";
				if (cont != null) {
					if (cont.getCsId() != null) {
						sql += " s.csId=" + cont.getCsId() + "and ";
					}
					if (cont.getCsNo() != null
							&& !cont.getCsNo().equals("")) {
						sql += " s.csNo like '%" + cont.getCsNo() + "%' and ";
					}
					if (cont.getCsName() != null
							&& !cont.getCsName().equals("")) {
						sql += " s.csName like '%" + cont.getCsName() + "%' and ";
					}
					if (cont.getPname() != null
							&& !cont.getPname().equals("")) {
						sql += " c.pname like '%" + cont.getPname() + "%' and ";
					}
					if (cont.getAppName() != null
							&& !cont.getAppName().equals("")) {
						sql += " a.appName like '%" + cont.getAppName() + "%' and ";
					}
				}
				if (startDate != null && endDate != null
						&& !startDate.equals("") && !endDate.equals("")) {
					sql += " s.csDate between '" + startDate + "' and '"
							+ endDate + "' and ";
				}
				String hql = "select count(distinct s.csId) from ContractSign s,Court c,Applierinfo a where s.csCasecodeself=c.casecodeself and s.csCasecodeself=a.appCCasecodeself and c.executestep=7 and " + sql;
				hql = hql.substring(0, hql.length() - 4);
				Query query = session.createQuery(hql);
				return query.iterate().next();

			}
		});

	}

	@Override
	public List<ClearRecord> selectClearRecord(ClearRecord clearRecord)
			throws Exception {
		String hqlcr = "from ClearRecord cr where cr.crcasecodeself='"
				+ clearRecord.getCrcasecodeself() + "' order by crSaveTime desc";
		@SuppressWarnings("unchecked")
		List<ClearRecord> clearrecords = this.getHibernateTemplate().find(hqlcr);
		return clearrecords;
	}

	@Override
	public List<ClearClear> selectClearClear(ClearClear clearClear)
			throws Exception {
		String hqlcc = "from ClearClear cc  where cc.cccasecodeself='"
				+ clearClear.getCccasecodeself() + "' order by ccsaveTime desc";
		@SuppressWarnings("unchecked")
		List<ClearClear> clearclears = this.getHibernateTemplate().find(hqlcc);
		return clearclears;
	}

	@Override
	public List<Litigation> selectLitigation(Litigation litigation)
			throws Exception {
		String hqlli = "from Litigation  li  where li.licasecodeself='"
				+ litigation.getLicasecodeself() + "' order by lisaveTime desc";
		@SuppressWarnings("unchecked")
		List<Litigation> litigations = this.getHibernateTemplate().find(hqlli);
				
		return litigations;
	}

	@Override
	public List<Execute> selectExecute(Execute execute) throws Exception {
		String hqlex = "from Execute  ex  where ex.excasecodeself='"
				+ execute.getExcasecodeself() + "' order by exsavetime desc";
		@SuppressWarnings("unchecked")
		List<Execute> executes = this.getHibernateTemplate().find(hqlex);
		return executes;
	}
	
	@Override
	public List<?> selectClearsByname(final int currentPage,
			final String  lawname) throws Exception {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer mysql = new StringBuffer();
				mysql.append(" select s.cs_id as csId,s.cs_date as csDate,s.cs_name as csName,s.cs_tel as csTel,s.cs_no as csNo," +
						"s.cs_remark as csRemark,s.cs_casecodeself as csCasecodeself,s.cs_caseid as csCaseID,ci.pname as pname,a.a_name as appName from lawyer.contact_sign s inner join courtinfo ci on s.cs_casecodeself=ci.casecodeself ");
				mysql.append(" inner join lawyer.applierinfo a on s.cs_casecodeself=a.a_c_casecodeself ");
				mysql.append("  inner join lawyer.clear_record r on s.cs_casecodeself=r.cr_casecodeself ");
				mysql.append(" where r.cr_lawname like '%"+lawname+"%' ");
				mysql.append(" union ");
				mysql.append(" select s.cs_id as csId,s.cs_date as csDate,s.cs_name as csName,s.cs_tel as csTel,s.cs_no as csNo," +
						"s.cs_remark as csRemark,s.cs_casecodeself as csCasecodeself,s.cs_caseid as csCaseID,ci.pname as pname,a.a_name as appName from lawyer.contact_sign s inner join courtinfo ci on s.cs_casecodeself=ci.casecodeself ");
				mysql.append(" inner join lawyer.applierinfo a on s.cs_casecodeself=a.a_c_casecodeself ");
				mysql.append(" inner join clear_clear c on s.cs_casecodeself=c.cc_casecodeself ");
				mysql.append(" where c.cc_lawname like '%"+lawname+"%' ");
				mysql.append(" union ");
				mysql.append(" select s.cs_id as csId,s.cs_date as csDate,s.cs_name as csName,s.cs_tel as csTel,s.cs_no as csNo," +
						"s.cs_remark as csRemark,s.cs_casecodeself as csCasecodeself,s.cs_caseid as csCaseID,ci.pname as pname,a.a_name as appName from lawyer.contact_sign s inner join courtinfo ci on s.cs_casecodeself=ci.casecodeself ");
				mysql.append(" inner join lawyer.applierinfo a on s.cs_casecodeself=a.a_c_casecodeself ");
				mysql.append(" inner join litigation l on s.cs_casecodeself=l.li_casecodeself ");
				mysql.append(" where l.li_lawname like '%"+lawname+"%' ");
				mysql.append(" union ");
				mysql.append(" select s.cs_id as csId,s.cs_date as csDate,s.cs_name as csName,s.cs_tel as csTel,s.cs_no as csNo," +
						"s.cs_remark as csRemark,s.cs_casecodeself as csCasecodeself,s.cs_caseid as csCaseID,ci.pname as pname,a.a_name as appName from lawyer.contact_sign s inner join courtinfo ci on s.cs_casecodeself=ci.casecodeself ");
				mysql.append(" inner join lawyer.applierinfo a on s.cs_casecodeself=a.a_c_casecodeself ");
				mysql.append(" inner join execute e on s.cs_casecodeself=e.ex_casecodeself ");
				mysql.append(" where e.ex_lawname like '%"+lawname+"%' ");
				
				Query query = session.createSQLQuery(mysql.toString());
				query.setFirstResult((currentPage - 1) * 10);
				query.setMaxResults(10);
				return query.list();

			}
		});

	}
	@Override
	public Object selectClearsPageSizeByname(final String  lawname) throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer mysql = new StringBuffer();
				mysql.append("select count(*) from (");
				mysql.append(" select s.cs_id as csId,s.cs_date as csDate,s.cs_name as csName,s.cs_tel as csTel,s.cs_no as csNo," +
				"s.cs_remark as csRemark,s.cs_casecodeself as csCasecodeself,s.cs_caseid as csCaseID,ci.pname as pname,a.a_name as appName from lawyer.contact_sign s inner join courtinfo ci on s.cs_casecodeself=ci.casecodeself ");
				mysql.append(" inner join lawyer.applierinfo a on s.cs_casecodeself=a.a_c_casecodeself ");
				mysql.append("  inner join lawyer.clear_record r on s.cs_casecodeself=r.cr_casecodeself ");
				mysql.append(" where r.cr_lawname like '%"+lawname+"%' ");
				mysql.append(" union ");
				mysql.append(" select s.cs_id as csId,s.cs_date as csDate,s.cs_name as csName,s.cs_tel as csTel,s.cs_no as csNo," +
						"s.cs_remark as csRemark,s.cs_casecodeself as csCasecodeself,s.cs_caseid as csCaseID,ci.pname as pname,a.a_name as appName from lawyer.contact_sign s inner join courtinfo ci on s.cs_casecodeself=ci.casecodeself ");
				mysql.append(" inner join lawyer.applierinfo a on s.cs_casecodeself=a.a_c_casecodeself ");
				mysql.append(" inner join clear_clear c on s.cs_casecodeself=c.cc_casecodeself ");
				mysql.append(" where c.cc_lawname like '%"+lawname+"%' ");
				mysql.append(" union ");
				mysql.append(" select s.cs_id as csId,s.cs_date as csDate,s.cs_name as csName,s.cs_tel as csTel,s.cs_no as csNo," +
						"s.cs_remark as csRemark,s.cs_casecodeself as csCasecodeself,s.cs_caseid as csCaseID,ci.pname as pname,a.a_name as appName from lawyer.contact_sign s inner join courtinfo ci on s.cs_casecodeself=ci.casecodeself ");
				mysql.append(" inner join lawyer.applierinfo a on s.cs_casecodeself=a.a_c_casecodeself ");
				mysql.append(" inner join litigation l on s.cs_casecodeself=l.li_casecodeself ");
				mysql.append(" where l.li_lawname like '%"+lawname+"%' ");
				mysql.append(" union ");
				mysql.append(" select s.cs_id as csId,s.cs_date as csDate,s.cs_name as csName,s.cs_tel as csTel,s.cs_no as csNo," +
						"s.cs_remark as csRemark,s.cs_casecodeself as csCasecodeself,s.cs_caseid as csCaseID,ci.pname as pname,a.a_name as appName from lawyer.contact_sign s inner join courtinfo ci on s.cs_casecodeself=ci.casecodeself ");
				mysql.append(" inner join lawyer.applierinfo a on s.cs_casecodeself=a.a_c_casecodeself ");
				mysql.append(" inner join execute e on s.cs_casecodeself=e.ex_casecodeself ");
				mysql.append(" where e.ex_lawname like '%"+lawname+"%' ");
				mysql.append(" ) t ");
				
				Query query = session.createSQLQuery(mysql.toString());
				return query.list().get(0);
			}
		});
	}

	@Override
	public void addMaterial(Material material) throws Exception {
		this.getHibernateTemplate().save(material);
		
	}

	@Override
	public List<Material> selectMaterial(Material material) throws Exception {
		String hqlcc = "from Material cc  where cc.casecodeself='"
			+ material.getCasecodeself() + "' order by savetime desc";
		@SuppressWarnings("unchecked")
		List<Material> materials = this.getHibernateTemplate().find(hqlcc);
		return materials;
	}

	@Override
	public ClearRecord showclearrecord(String casecodeself) throws Exception {
		String hqlcr = "from ClearRecord cr where cr.crcasecodeself='"
			+ casecodeself + "' order by crSaveTime desc";
		List<ClearRecord> clearrecords = this.getHibernateTemplate().find(hqlcr);
		if(clearrecords.size()<1){
			return null;
		}else{
			return clearrecords.get(0);
		}
	}

	@Override
	public ClearClear showclearclear(String casecodeself) throws Exception {
		// 清算
		String hqlcc = "from ClearClear cc  where cc.cccasecodeself='"
				+ casecodeself + "' order by ccsaveTime desc";
		List<ClearClear> clearclears = this.getHibernateTemplate().find(hqlcc);
		if(clearclears.size()<1){
			return null;
		}else{
			return clearclears.get(0);
		}
		
	}

	@Override
	public Litigation showlitigation(String casecodeself) throws Exception {
		// 诉讼阶段
		String hqlli = "from Litigation  li  where li.licasecodeself='"
				+ casecodeself + "' order by lisaveTime desc";
		List<Litigation> litigations = this.getHibernateTemplate().find(hqlli);
		if(litigations.size()<1){
			return null;
		}else{
			return litigations.get(0);
		}
	}

	@Override
	public Execute showexecute(String casecodeself) throws Exception {
		// 执行阶段
		String hqlex = "from Execute  ex  where ex.excasecodeself='"
				+ casecodeself + "' order by exsavetime desc";
		List<Execute> executes = this.getHibernateTemplate().find(hqlex);
		if(executes.size()<1){
			return null;
		}else{
			return executes.get(0);
		}
	}

	@Override
	public MaintainCustomers showMaintainCustomers(String casecodeself)
			throws Exception {
		String hqlli = "from MaintainCustomers  mc  where mc.licasecodeself='"
				+ casecodeself + "' order by mc.saveTime desc";
		List<MaintainCustomers> maintainCustomers = this.getHibernateTemplate().find(hqlli);
		if(maintainCustomers.size()<1){
			return null;
		}else{
			return maintainCustomers.get(0);
		}
	}

	@Override
	public void addCustomers(MaintainCustomers maintainCustomers)
			throws Exception {
		this.getHibernateTemplate().save(maintainCustomers);
	}

	@Override
	public List<MaintainCustomers> selectMaintainCustomers(
			MaintainCustomers maintainCustomer) throws Exception {
		String hqlcc = "from MaintainCustomers mc  where mc.casecodeself='"
				+ maintainCustomer.getCasecodeself() + "' order by mc.savetime desc";
			List<MaintainCustomers> maintainCustomers = this.getHibernateTemplate().find(hqlcc);
			return maintainCustomers;
	}

	@Override
	public Material showMaterial(String casecodeself) throws Exception {
		String hqlme = "from Material m where m.casecodeself='"
				+ casecodeself + "' order by savetime desc limit 1";
		List<Material> materials = this.getHibernateTemplate().find(hqlme);
		if(materials.size()<1){
			return null;
		}else{
			return materials.get(0);
		}
	}

	@Override
	public CloseRecord getCloseRecord(String casecodeself) throws Exception {
		CloseRecord closerecord = null;
		String hqlcl = "from CloseRecord  cl  where cl.crcasecodeself='"
				+ casecodeself + "'";
		List<?> closerecords = this.getHibernateTemplate().find(hqlcl);
		if (closerecords != null && closerecords.size() > 0) {
			closerecord = (CloseRecord) closerecords.iterator().next();
		}
		return closerecord;
	}
	
	
}
