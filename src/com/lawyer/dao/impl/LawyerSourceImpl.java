package com.lawyer.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.LawyerSourceDao;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;

public class LawyerSourceImpl extends HibernateDaoSupport implements
		LawyerSourceDao {

	@SuppressWarnings("unchecked")
	public Court DaYinCourt(String casecode){
		Court c = null;
		Iterator<Court> it = this.getHibernateTemplate().find(
				"from Court where casecodeself='"+casecode+"'").iterator();
		while (it.hasNext()) {
			c = it.next();
		}
		
		// 被执行人企业信息
		Executebusiness eb = null;
		Iterator<Executebusiness> iteb = this.getHibernateTemplate().find(
				"from Executebusiness ex where ex.ECCasecodeself='"+casecode+"'")
				.iterator();
		while (iteb.hasNext()) {
			eb = iteb.next();
		}
		c.setEb(eb);
		
		Applierinfo ap = null;
		Iterator<Applierinfo> itan = this.getHibernateTemplate().find(
				"from Applierinfo ap where ap.appCCasecodeself='"+casecode+"'")
				.iterator();
		while (itan.hasNext()) {
			ap = itan.next();
		}
		c.setAp(ap);

		// 申请执行人信息（自有信息applierinfo_ oneself）
		ApplierinfoOnself ao = null;
		Iterator<ApplierinfoOnself> itao = this.getHibernateTemplate().find(
				"from ApplierinfoOnself api where api.aoCasecodeself='"+casecode+"'")
				.iterator();
		while (itao.hasNext()) {
			ao = itao.next();
		}
		c.setAo(ao);

		// 与申请执行人联系信息（电子邮件contact_mail）
		List<ContactMail> listcm = this.getHibernateTemplate().find(
				"from ContactMail cm where cm.cmCasecodeself='"+casecode+"'");

		if (listcm.size() < 1) {
			c.setListcm(null);
		} else {
			c.setListcm(listcm);
		}
		// 与申请执行人联系信息（快递contact_express）
		List<ContactExpress> listce = this.getHibernateTemplate().find(
				"from ContactExpress ce where ce.ceCasecodeself='"+casecode+"'");
		if (listcm.size() < 1) {
			c.setListce(null);
		} else {
			c.setListce(listce);
		}
		// 与申请执行人联系信息（电话联系contact_tel）
		List<ContactTel> listct = this.getHibernateTemplate().find(
				"from ContactTel ct where ct.ctCasecodeself='"+casecode+"'");

		if (listcm.size() < 1) {
			c.setListct(null);
		} else {
			c.setListct(listct);
		}

		// 签约情况(contract_sign)
		ContractSign csign = null;
		Iterator<ContractSign> itcsign = this.getHibernateTemplate().find(
				"from ContractSign csign where csign.csCasecodeself='"+casecode+"'")
				.iterator();
		while (itcsign.hasNext()) {
			csign = itcsign.next();
		}
		c.setCsign(csign);
		return c;
	}
	
	public List<?> seniorSelect(final int currentPage,final String showNote, final int pageSize,
			final String... params) throws Exception {

		return this.getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer mysql = new StringBuffer();
				if(showNote.endsWith("1")){
					mysql.append("select DISTINCT court0_.ID as id,court0_.caseId as caseid,court0_.pname as pname,court0_.noticeCourt as execcourtname,court0_.casecodeself as casecodeself,court0_.caseCreateTime as noticeTime,court0_.lawDocumentNum as caseCode ");
				}else{
					mysql.append("select DISTINCT court0_.ID as id,court0_.caseId as caseid,court0_.pname as pname,court0_.execCourtName as execcourtname,court0_.casecodeself as casecodeself,court0_.caseCreateTime as casecreatetime,court0_.caseCode as caseCode ");
				}
				
				mysql.append("from lawyer.courtinfo court0_  ");
				if(!"".equals(params[5].trim()) || !"".equals(params[6].trim()) || !"".equals(params[7].trim()) || !"".equals(params[8].trim()) || !"".equals(params[33].trim())
						|| !"".equals(params[41].trim()) || !"".equals(params[42].trim()) || !"".equals(params[43].trim()) || !"".equals(params[44].trim()) ){
					mysql.append("left join lawyer.applierinfo applierinf1_ ");
					mysql.append("ON court0_.casecodeself=applierinf1_.a_c_casecodeself ");
				}
				if(!"".equals(params[9].trim()) || !"".equals(params[10].trim()) || !"".equals(params[11].trim()) || !"".equals(params[12].trim())){
					mysql.append("left join lawyer.applierinfo_onself applierinf2_ ");
					mysql.append("ON court0_.casecodeself=applierinf2_.ao_casecodeself ");
				}
				if(!"".equals(params[13].trim()) || !"".equals(params[37].trim()) || !"".equals(params[38].trim()) || !"".equals(params[39].trim()) || !"".equals(params[40].trim())){
					mysql.append("left join lawyer.contact_tel contacttel3_ ");
					mysql.append("ON court0_.casecodeself=contacttel3_.ct_casecodeself ");
				}
				if(!"".equals(params[15].trim()) || !"".equals(params[14].trim()) || !"".equals(params[26].trim()) || !"".equals(params[27].trim())){
					mysql.append("left join lawyer.contact_sign contractsi4_  ");
					mysql.append("ON court0_.casecodeself=contractsi4_.cs_casecodeself ");
				}
				if(!"".equals(params[16].trim()) || !"".equals(params[17].trim()) || !"".equals(params[18].trim()) || !"".equals(params[19].trim()) || !"".equals(params[20].trim()) || !"".equals(params[21].trim()) || !"".equals(params[22].trim()) || !"".equals(params[25].trim())){
					mysql.append("left join lawyer.executebusiness executebus5_ ");
					mysql.append("ON court0_.casecodeself=executebus5_.e_c_casecodeself ");
				}
				if(!"".equals(params[23].trim()) ){
					mysql.append("left join lawyer.contact_mail contactmai6_ ");
					mysql.append("ON court0_.casecodeself=contactmai6_.cm_casecodeself ");
				}
				if(!"".equals(params[24].trim()) || !"".equals(params[34].trim()) || !"".equals(params[35].trim()) || !"".equals(params[36].trim())){
					mysql.append("left join lawyer.contact_express contact_ce_express ");
					mysql.append("ON court0_.casecodeself=contact_ce_express.ce_casecodeself ");
				}
				mysql.append("where ");
				mysql.append("court0_.excludeStatus ='0' ");
				System.out.println(showNote.endsWith("1"));
				if(showNote.endsWith("1")){
					if("".equals(params[28].trim())) params[28]="1111年11月11日";
					if("".equals(params[29].trim())) params[29]="2222年22月22日";
					mysql.append(" AND court0_.noticeTime between '"+params[28]+"' and '"+params[29]+"' ");
					if(!"".equals(params[0].trim()))
						mysql.append("and court0_.pname LIKE '%"+params[0]+"%' ");
					if(!"".equals(params[2].trim()))
						mysql.append("AND court0_.noticeCourt LIKE '%"+params[2]+"%' ");
					if(!"".equals(params[3].trim()))
						mysql.append("AND court0_.lawDocumentNum LIKE '%"+params[3]+"%' ");
				}else{
					if("".equals(params[28].trim())) params[28]="1111年11月11日";
					if("".equals(params[29].trim())) params[29]="2222年22月22日";
					mysql.append(" AND court0_.caseCreateTime between '"+params[28]+"' and '"+params[29]+"' ");
					
					if(!"".equals(params[30].trim()) || !"".equals(params[31].trim())){
						if("".equals(params[30].trim())) params[30]="0";
						if("".equals(params[31].trim())) params[31]="111111111111";
						mysql.append("and court0_.execMoney between '"+params[30]+"' and '"+params[31]+"' ");
					}
					if(!"".equals(params[0].trim()))
						mysql.append("and court0_.pname LIKE '%"+params[0]+"%' ");
					if(!"".equals(params[1].trim()))
						mysql.append("AND court0_.partyCardNum LIKE '%"+params[1]+"%' ");
					if(!"".equals(params[2].trim()))
						mysql.append("AND court0_.execCourtName LIKE '%"+params[2]+"%' ");
					if(!"".equals(params[3].trim()))
						mysql.append("AND court0_.caseCode LIKE '%"+params[3]+"%' ");
					if(!"".equals(params[4].trim()))
						mysql.append("AND court0_.caseState LIKE '%"+params[4]+"%' ");
				}
				
				if (!"".equals(params[26].trim()) || !"".equals(params[27].trim())){
					if("".equals(params[26].trim())) params[26]="1111年11月11日";
					if("".equals(params[27].trim())) params[27]="2222年22月22日";
					mysql.append("and contractsi4_.cs_date between '"+params[26]+"' AND '"+params[27]+"' ");
				}
				if (!"".equals(params[35].trim()) || !"".equals(params[36].trim())){
					if("".equals(params[35].trim())) params[35]="1111年11月11日";
					if("".equals(params[36].trim())) params[36]="2222年22月22日";
					mysql.append("and contact_ce_express.ce_date between '"+params[35]+"' AND '"+params[36]+"' ");
				}
				
				if (!"".equals(params[5].trim()))
					mysql.append("AND applierinf1_.a_repname LIKE '%"+params[5]+"%' ");
				if (!"".equals(params[6].trim()))
					mysql.append("AND applierinf1_.a_district LIKE '%"+params[6]+"%' ");
				if (!"".equals(params[7].trim()))
					mysql.append("AND applierinf1_.a_organ LIKE '%"+params[7]+"%' ");
				if (!"".equals(params[8].trim()))
					mysql.append("AND applierinf1_.a_address LIKE '%"+params[8]+"%' ");
				if (!"".equals(params[44].trim()))
					mysql.append("AND applierinf1_.dispose_result = '"+params[44]+"' ");
				if (!"".equals(params[41].trim()))
					mysql.append("AND applierinf1_.used_mark = "+params[41]+" ");
				if (!"".equals(params[42].trim()) || !"".equals(params[43].trim())){
					if("".equals(params[42].trim())) params[42]="1970-01-01";
					if("".equals(params[43].trim())) params[43]="2100-12-31";
					
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					try {
						params[42] = sdf1.format(sdf2.parse(params[42]));
						params[43] = sdf1.format(sdf2.parse(params[43]));
					} catch (ParseException e) {
					}
					mysql.append("and applierinf1_.mark_time between '"+params[42]+"' AND '"+params[43]+"' ");
				}
				
				if (!"".equals(params[9].trim()))
					mysql.append("AND applierinf2_.ao_name LIKE '%"+params[9]+"%' ");
				if (!"".equals(params[10].trim()))
					mysql.append("AND applierinf2_.ao_address LIKE '%"+params[10]+"%' ");
				if (!"".equals(params[11].trim()))
					mysql.append("AND applierinf2_.ao_name1 LIKE '%"+params[11]+"%' ");
				if (!"".equals(params[12].trim()))
					mysql.append("AND applierinf2_.ao_phone1 LIKE '%"+params[12]+"%' ");

				if (!"".equals(params[13].trim()))
					mysql.append("AND contacttel3_.ct_name LIKE '%"+params[13]+"%' ");
				if (!"".equals(params[37].trim()) || !"".equals(params[38].trim())){
					if("".equals(params[37].trim())) params[37]="1111年11月11日";
					if("".equals(params[38].trim())) params[38]="2222年22月22日";
					mysql.append("and contacttel3_.ct_time between '"+params[37]+"' AND '"+params[38]+"' ");
				}
				if (!"".equals(params[39].trim()))
					mysql.append("AND contacttel3_.ct_name1 LIKE '%"+params[39]+"%' ");
				if (!"".equals(params[40].trim()))
					mysql.append("AND contacttel3_.ct_tel1 LIKE '%"+params[40]+"%' ");
				
				
				if (!"".equals(params[14].trim()))
					mysql.append("AND contractsi4_.cs_name LIKE '%"+params[14]+"%' ");
				if (!"".equals(params[15].trim()))
					mysql.append("AND contractsi4_.cs_no LIKE '%"+params[15]+"%' ");

				if (!"".equals(params[16].trim()))
					mysql.append("AND executebus5_.e_renumber LIKE '%"+params[16]+"%' ");
				if (!"".equals(params[17].trim()))
					mysql.append("AND executebus5_.e_type LIKE '%"+params[17]+"%' ");
				if (!"".equals(params[18].trim()))
					mysql.append("AND executebus5_.e_name LIKE '%"+params[18]+"%' ");
				if (!"".equals(params[19].trim()))
					mysql.append("AND executebus5_.e_repname LIKE '%"+params[19]+"%' ");
				if (!"".equals(params[20].trim()))
					mysql.append("AND executebus5_.e_district LIKE '%"+params[20]+"%' ");
				if (!"".equals(params[21].trim()))
					mysql.append("AND executebus5_.e_organ LIKE '%"+params[21]+"%' ");
				if (!"".equals(params[22].trim()))
					mysql.append("AND executebus5_.e_address LIKE '%"+params[22]+"%' ");
				if (!"".equals(params[23].trim()))
					mysql.append("AND contactmai6_.cm_mail LIKE '%"+params[23]+"%' ");
				if (!"".equals(params[34].trim()))
					mysql.append("AND contact_ce_express.ce_name LIKE '%"+params[34]+"%' ");
				if (!"".equals(params[24].trim()))
					mysql.append("AND contact_ce_express.ce_number LIKE '%"+params[24]+"%' ");
				if(!"".equals(params[25].trim())){
					mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
				}
				if(!"".equals(params[32].trim()))
					mysql.append("AND court0_.casecodeself LIKE '%"+params[32]+"%' ");
				if (!"".equals(params[33].trim()))
					mysql.append("AND applierinf1_.a_name LIKE '%"+params[33]+"%' ");
				mysql.append(" limit "+(currentPage-1)*pageSize+","+pageSize);
				String sql = mysql.toString();
				Query query = session.createSQLQuery(sql);
				return query.list();
			}
		});
	}

	public Object seniorSelectPageSize(final int pageSize,final String showNote,
			final String... params) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer mysql = new StringBuffer();
				mysql.append("select count(DISTINCT court0_.casecodeself) ");
				mysql.append("from lawyer.courtinfo court0_  ");
				
				if(!"".equals(params[5].trim()) || !"".equals(params[6].trim()) || !"".equals(params[7].trim()) || !"".equals(params[8].trim()) || !"".equals(params[33].trim())
						|| !"".equals(params[41].trim()) || !"".equals(params[42].trim()) || !"".equals(params[43].trim()) || !"".equals(params[44].trim()) ){
					mysql.append("left join lawyer.applierinfo applierinf1_ ");
					mysql.append("ON court0_.casecodeself=applierinf1_.a_c_casecodeself ");
				}
				if(!"".equals(params[9].trim()) || !"".equals(params[10].trim()) || !"".equals(params[11].trim()) || !"".equals(params[12].trim())){
					mysql.append("left join lawyer.applierinfo_onself applierinf2_ ");
					mysql.append("ON court0_.casecodeself=applierinf2_.ao_casecodeself ");
				}
				if(!"".equals(params[13].trim()) || !"".equals(params[37].trim()) || !"".equals(params[38].trim()) || !"".equals(params[39].trim()) || !"".equals(params[40].trim())){
					mysql.append("left join lawyer.contact_tel contacttel3_ ");
					mysql.append("ON court0_.casecodeself=contacttel3_.ct_casecodeself ");
				}
				if(!"".equals(params[15].trim()) || !"".equals(params[14].trim()) || !"".equals(params[26].trim()) || !"".equals(params[27].trim())){
					mysql.append("left join lawyer.contact_sign contractsi4_  ");
					mysql.append("ON court0_.casecodeself=contractsi4_.cs_casecodeself ");
				}
				if(!"".equals(params[16].trim()) || !"".equals(params[17].trim()) || !"".equals(params[18].trim()) || !"".equals(params[19].trim()) || !"".equals(params[20].trim()) || !"".equals(params[21].trim()) || !"".equals(params[22].trim()) || !"".equals(params[25].trim())){
					mysql.append("left join lawyer.executebusiness executebus5_ ");
					mysql.append("ON court0_.casecodeself=executebus5_.e_c_casecodeself ");
				}
				if(!"".equals(params[23].trim())){
					mysql.append("left join lawyer.contact_mail contactmai6_ ");
					mysql.append("ON court0_.casecodeself=contactmai6_.cm_casecodeself ");
				}
				if(!"".equals(params[24].trim()) || !"".equals(params[34].trim()) || !"".equals(params[35].trim()) || !"".equals(params[36].trim())){
					mysql.append("left join lawyer.contact_express contact_ce_express ");
					mysql.append("ON court0_.casecodeself=contact_ce_express.ce_casecodeself ");
				}
				mysql.append("where ");
				mysql.append("court0_.excludeStatus ='0' ");
				
				if(showNote.endsWith("1")){
					if("".equals(params[28].trim())) params[28]="1111年11月11日";
					if("".equals(params[29].trim())) params[29]="2222年22月22日";
					mysql.append(" AND court0_.noticeTime between '"+params[28]+"' and '"+params[29]+"' ");
					if(!"".equals(params[0].trim()))
						mysql.append("and court0_.pname LIKE '%"+params[0]+"%' ");
					if(!"".equals(params[2].trim()))
						mysql.append("AND court0_.noticeCourt LIKE '%"+params[2]+"%' ");
					if(!"".equals(params[3].trim()))
						mysql.append("AND court0_.lawDocumentNum LIKE '%"+params[3]+"%' ");
				}else{
					if("".equals(params[28].trim())) params[28]="1111年11月11日";
					if("".equals(params[29].trim())) params[29]="2222年22月22日";
					mysql.append(" AND court0_.caseCreateTime between '"+params[28]+"' and '"+params[29]+"' ");
					
					if(!"".equals(params[30].trim()) || !"".equals(params[31].trim())){
						if("".equals(params[30].trim())) params[30]="0";
						if("".equals(params[31].trim())) params[31]="111111111111";
						mysql.append("and court0_.execMoney between '"+params[30]+"' and '"+params[31]+"' ");
					}
					if(!"".equals(params[0].trim()))
						mysql.append("and court0_.pname LIKE '%"+params[0]+"%' ");
					if(!"".equals(params[1].trim()))
						mysql.append("AND court0_.partyCardNum LIKE '%"+params[1]+"%' ");
					if(!"".equals(params[2].trim()))
						mysql.append("AND court0_.execCourtName LIKE '%"+params[2]+"%' ");
					if(!"".equals(params[3].trim()))
						mysql.append("AND court0_.caseCode LIKE '%"+params[3]+"%' ");
					if(!"".equals(params[4].trim()))
						mysql.append("AND court0_.caseState LIKE '%"+params[4]+"%' ");
				}
				if (!"".equals(params[26].trim()) || !"".equals(params[27].trim())){
					if("".equals(params[26].trim())) params[26]="1111年11月11日";
					if("".equals(params[27].trim())) params[27]="2222年22月22日";
					mysql.append("and contractsi4_.cs_date between '"+params[26]+"' AND '"+params[27]+"' ");
				}
				if (!"".equals(params[35].trim()) || !"".equals(params[36].trim())){
					if("".equals(params[35].trim())) params[35]="1111年11月11日";
					if("".equals(params[36].trim())) params[36]="2222年22月22日";
					mysql.append("and contact_ce_express.ce_date between '"+params[35]+"' AND '"+params[36]+"' ");
				}

				if (!"".equals(params[5].trim()))
					mysql.append("AND applierinf1_.a_repname LIKE '%"+params[5]+"%' ");
				if (!"".equals(params[6].trim()))
					mysql.append("AND applierinf1_.a_district LIKE '%"+params[6]+"%' ");
				if (!"".equals(params[7].trim()))
					mysql.append("AND applierinf1_.a_organ LIKE '%"+params[7]+"%' ");
				if (!"".equals(params[8].trim()))
					mysql.append("AND applierinf1_.a_address LIKE '%"+params[8]+"%' ");
				if (!"".equals(params[44].trim()))
					mysql.append("AND applierinf1_.dispose_result = '"+params[44]+"' ");
				if (!"".equals(params[41].trim()))
					mysql.append("AND applierinf1_.used_mark = "+params[41]+" ");
				if (!"".equals(params[42].trim()) || !"".equals(params[43].trim())){
					if("".equals(params[42].trim())) params[42]="1970-01-01";
					if("".equals(params[43].trim())) params[43]="2100-12-31";
					
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					try {
						params[42] = sdf1.format(sdf2.parse(params[42]));
						params[43] = sdf1.format(sdf2.parse(params[43]));
					} catch (ParseException e) {
					}
					mysql.append("and applierinf1_.mark_time between '"+params[42]+"' AND '"+params[43]+"' ");
				}
				
				if (!"".equals(params[9].trim()))
					mysql.append("AND applierinf2_.ao_name LIKE '%"+params[9]+"%' ");
				if (!"".equals(params[10].trim()))
					mysql.append("AND applierinf2_.ao_address LIKE '%"+params[10]+"%' ");
				if (!"".equals(params[11].trim()))
					mysql.append("AND applierinf2_.ao_name1 LIKE '%"+params[11]+"%' ");
				if (!"".equals(params[12].trim()))
					mysql.append("AND applierinf2_.ao_phone1 LIKE '%"+params[12]+"%' ");

				if (!"".equals(params[13].trim()))
					mysql.append("AND contacttel3_.ct_name LIKE '%"+params[13]+"%' ");
				if (!"".equals(params[37].trim()) || !"".equals(params[38].trim())){
					if("".equals(params[37].trim())) params[37]="1111年11月11日";
					if("".equals(params[38].trim())) params[38]="2222年22月22日";
					mysql.append("and contacttel3_.ct_time between '"+params[37]+"' AND '"+params[38]+"' ");
				}
				if (!"".equals(params[39].trim()))
					mysql.append("AND contacttel3_.ct_name1 LIKE '%"+params[39]+"%' ");
				if (!"".equals(params[40].trim()))
					mysql.append("AND contacttel3_.ct_tel1 LIKE '%"+params[40]+"%' ");
				
				
				if (!"".equals(params[14].trim()))
					mysql.append("AND contractsi4_.cs_name LIKE '%"+params[14]+"%' ");
				if (!"".equals(params[15].trim()))
					mysql.append("AND contractsi4_.cs_no LIKE '%"+params[15]+"%' ");
				if (!"".equals(params[16].trim()))
					mysql.append("AND executebus5_.e_renumber LIKE '%"+params[16]+"%' ");
				if (!"".equals(params[17].trim()))
					mysql.append("AND executebus5_.e_type LIKE '%"+params[17]+"%' ");
				if (!"".equals(params[18].trim()))
					mysql.append("AND executebus5_.e_name LIKE '%"+params[18]+"%' ");
				if (!"".equals(params[19].trim()))
					mysql.append("AND executebus5_.e_repname LIKE '%"+params[19]+"%' ");
				if (!"".equals(params[20].trim()))
					mysql.append("AND executebus5_.e_district LIKE '%"+params[20]+"%' ");
				if (!"".equals(params[21].trim()))
					mysql.append("AND executebus5_.e_organ LIKE '%"+params[21]+"%' ");
				if (!"".equals(params[22].trim()))
					mysql.append("AND executebus5_.e_address LIKE '%"+params[22]+"%' ");
				if (!"".equals(params[23].trim()))
					mysql.append("AND contactmai6_.cm_mail LIKE '%"+params[23]+"%' ");
				if (!"".equals(params[34].trim()))
					mysql.append("AND contact_ce_express.ce_name LIKE '%"+params[34]+"%' ");
				if (!"".equals(params[24].trim()))
					mysql.append("AND contact_ce_express.ce_number LIKE '%"+params[24]+"%' ");
				if(!"".equals(params[25].trim())){
					mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
				}
				if(!"".equals(params[32].trim()))
					mysql.append("AND court0_.casecodeself LIKE '%"+params[32]+"%' ");
				if (!"".equals(params[33].trim()))
					mysql.append("AND applierinf1_.a_name LIKE '%"+params[33]+"%' ");
		//		mysql.append(" limit "+(currentPage-1)*pageSize+","+currentPage*pageSize);
				String sql = mysql.toString();
				Query query = session.createSQLQuery(sql);
				
				return query.list().get(0);
			}
		});

	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByApplierinfo(
			Applierinfo applierinfo) throws Exception {
		return this.getHibernateTemplate().find(
				"from Applierinfo where appRepname like '%"
						+ applierinfo.getAppRepname() + "%' "
						+ "or appDistrict like '%"
						+ applierinfo.getAppDistrict()
						+ "%' or appOrgan like '%"
						+ applierinfo.getAppOrgan() + "%' "
						+ "or appAddress like '%"
						+ applierinfo.getAppAddress() + "%'");
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByApplierinfoOnself(
			ApplierinfoOnself applierinfoOnself) throws Exception {
		return this.getHibernateTemplate().find(
				"from ApplierinfoOnself where aoName like '%"
						+ applierinfoOnself.getAoName() + "%' "
						+ "or aoAddress like '%"
						+ applierinfoOnself.getAoAddress()
						+ "%' or aoName1 like '%"
						+ applierinfoOnself.getAoName1() + "%' "
						+ "or aoPhone1 like '%"
						+ applierinfoOnself.getAoPhone1() + "%'");
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByContactTel(ContactTel contactTel)
			throws Exception {
		return this.getHibernateTemplate().find(
				"from ContactTel where ctResult like '%"
						+ contactTel.getCtResult() + "%'");
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByContractSign(ContractSign contractSign)
			throws Exception {
		return this.getHibernateTemplate().find(
				"from ContractSign where csNo like '%" + contractSign.getCsNo()
						+ "%' " + "or csDate like '%"
						+ contractSign.getCsDate() + "%' or csName like '%"
						+ contractSign.getCsName() + "%'");
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByCourt(Court court) throws Exception {
		return this.getHibernateTemplate().find(
				"from Court where pname like '%" + court.getPname() + "%' "
						+ "or partyCardNum like '%" + court.getPartyCardNum()
						+ "%' or execCourtName like '%"
						+ court.getExecCourtName() + "%' "
						+ "or caseCreateTime like '%"
						+ court.getCaseCreateTime() + "%' or caseCode like '%"
						+ court.getCaseCode() + "%' " + "or execMoney like '%"
						+ court.getExecMoney() + "%' or caseState like '%"
						+ court.getCaseState() + "%'");
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByExecuteBusiness(
			Executebusiness executeBusiness) throws Exception {
		return this.getHibernateTemplate().find(
				"from Executebusiness where ERenumber like '%"
						+ executeBusiness.getERenumber() + "%' "
						+ "or EType like '%" + executeBusiness.getEType()
						+ "%' or EName like '%" + executeBusiness.getEName()
						+ "%' " + "or ERepname like '%"
						+ executeBusiness.getERepname()
						+ "%' or EDistrict like '%"
						+ executeBusiness.getEDistrict() + "%' "
						+ "or EOrgan like '%" + executeBusiness.getEOrgan()
						+ "%' or EAddress like '%"
						+ executeBusiness.getEAddress() + "%'");
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByContactExpress(ContactExpress contactExpress)
			throws Exception {
		return this.getHibernateTemplate().find(
				"from ContactExpress where ceNumber like '%"
						+ contactExpress.getCeNumber() + "%'");
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByContactMail(ContactMail contactMail)
			throws Exception {
		return this.getHibernateTemplate().find(
				"from ContactMail where cmMail like '%"
						+ contactMail.getCmMail() + "%'");
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSource(String cond) throws Exception {
		return this.getHibernateTemplate().find(
				"from Court c left join ApplierinfoNetwork an on "
						+ "c.caseId=an.an_c_casecodeself where 1=1 " + cond);

	}



	@Override
	public List excludeSeniorSelect(final int currentPage,final String showNote, final int pageSize,final List exclude,
			final String... params) throws Exception {
		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer mysql = new StringBuffer();
				mysql.append("select DISTINCT court0_.ID as id,court0_.caseId as caseid,court0_.pname as pname,court0_.execCourtName as execcourtname,court0_.casecodeself as casecodeself,court0_.caseCreateTime as casecreatetime,court0_.caseCode as caseCode ");
				mysql.append("from lawyer.courtinfo court0_  ");
				if(!"".equals(params[5].trim()) || !"".equals(params[6].trim()) || !"".equals(params[7].trim()) || !"".equals(params[8].trim()) || !"".equals(params[33].trim())
						|| !"".equals(params[41].trim()) || !"".equals(params[42].trim()) || !"".equals(params[43].trim()) || !"".equals(params[44].trim()) ){
					mysql.append("left join lawyer.applierinfo applierinf1_ ");
					mysql.append("ON court0_.casecodeself=applierinf1_.a_c_casecodeself ");
				}
				if(!"".equals(params[9].trim()) || !"".equals(params[10].trim()) || !"".equals(params[11].trim()) || !"".equals(params[12].trim())){
					mysql.append("left join lawyer.applierinfo_onself applierinf2_ ");
					mysql.append("ON court0_.casecodeself=applierinf2_.ao_casecodeself ");
				}
				if(!"".equals(params[13].trim()) || !"".equals(params[37].trim()) || !"".equals(params[38].trim()) || !"".equals(params[39].trim()) || !"".equals(params[40].trim())){
					mysql.append("left join lawyer.contact_tel contacttel3_ ");
					mysql.append("ON court0_.casecodeself=contacttel3_.ct_casecodeself ");
				}
				if(!"".equals(params[15].trim()) || !"".equals(params[14].trim()) || !"".equals(params[26].trim()) || !"".equals(params[27].trim())){
					mysql.append("left join lawyer.contact_sign contractsi4_  ");
					mysql.append("ON court0_.casecodeself=contractsi4_.cs_casecodeself ");
				}
				if(!"".equals(params[16].trim()) || !"".equals(params[17].trim()) || !"".equals(params[18].trim()) || !"".equals(params[19].trim()) || !"".equals(params[20].trim()) || !"".equals(params[21].trim()) || !"".equals(params[22].trim()) || !"".equals(params[25].trim())){
					mysql.append("left join lawyer.executebusiness executebus5_ ");
					mysql.append("ON court0_.casecodeself=executebus5_.e_c_casecodeself ");
				}
				if(!"".equals(params[23].trim())){
					mysql.append("left join lawyer.contact_mail contactmai6_ ");
					mysql.append("ON court0_.casecodeself=contactmai6_.cm_casecodeself ");
				}
				if(!"".equals(params[24].trim()) || !"".equals(params[34].trim()) || !"".equals(params[35].trim()) || !"".equals(params[36].trim())){
					mysql.append("left join lawyer.contact_express contact_ce_express ");
					mysql.append("ON court0_.casecodeself=contact_ce_express.ce_casecodeself ");
				}
				mysql.append("where ");
				if(showNote.endsWith("1")){
					if("".equals(params[28].trim())) params[28]="1111年11月11日";
					if("".equals(params[29].trim())) params[29]="2222年22月22日";
					mysql.append("court0_.noticeTime between '"+params[28]+"' and '"+params[29]+"' ");
					if(!"".equals(params[0].trim()))
						mysql.append("and court0_.pname LIKE '%"+params[0]+"%' ");
					if(!"".equals(params[2].trim()))
						mysql.append("AND court0_.noticeCourt LIKE '%"+params[2]+"%' ");
					if(!"".equals(params[3].trim()))
						mysql.append("AND court0_.lawDocumentNum LIKE '%"+params[3]+"%' ");
				}else{
					if("".equals(params[28].trim())) params[28]="1111年11月11日";
					if("".equals(params[29].trim())) params[29]="2222年22月22日";
					mysql.append("court0_.caseCreateTime between '"+params[28]+"' and '"+params[29]+"' ");
					if(!"".equals(params[30].trim()) || !"".equals(params[31].trim())){
						if("".equals(params[30].trim())) params[30]="0";
						if("".equals(params[31].trim())) params[31]="111111111111";
						mysql.append("and court0_.execMoney between '"+params[30]+"' and '"+params[31]+"' ");
					}
					if(!"".equals(params[0].trim()))
						mysql.append("and court0_.pname LIKE '%"+params[0]+"%' ");
					if(!"".equals(params[1].trim()))
						mysql.append("AND court0_.partyCardNum LIKE '%"+params[1]+"%' ");
					if(!"".equals(params[2].trim()))
						mysql.append("AND court0_.execCourtName LIKE '%"+params[2]+"%' ");
					if(!"".equals(params[3].trim()))
						mysql.append("AND court0_.caseCode LIKE '%"+params[3]+"%' ");
					if(!"".equals(params[4].trim()))
						mysql.append("AND court0_.caseState LIKE '%"+params[4]+"%' ");
				}
				if (!"".equals(params[26].trim()) || !"".equals(params[27].trim())){
					if("".equals(params[26].trim())) params[26]="1111年11月11日";
					if("".equals(params[27].trim())) params[27]="2222年22月22日";
					mysql.append("and contractsi4_.cs_date between '"+params[26]+"' AND '"+params[27]+"' ");
				}
				if (!"".equals(params[35].trim()) || !"".equals(params[36].trim())){
					if("".equals(params[35].trim())) params[35]="1111年11月11日";
					if("".equals(params[36].trim())) params[36]="2222年22月22日";
					mysql.append("and contact_ce_express.ce_date between '"+params[35]+"' AND '"+params[36]+"' ");
				}
				
				if (!"".equals(params[5].trim()))
					mysql.append("AND applierinf1_.a_repname LIKE '%"+params[5]+"%' ");
				if (!"".equals(params[6].trim()))
					mysql.append("AND applierinf1_.a_district LIKE '%"+params[6]+"%' ");
				if (!"".equals(params[7].trim()))
					mysql.append("AND applierinf1_.a_organ LIKE '%"+params[7]+"%' ");
				if (!"".equals(params[8].trim()))
					mysql.append("AND applierinf1_.a_address LIKE '%"+params[8]+"%' ");
				if (!"".equals(params[44].trim()))
					mysql.append("AND applierinf1_.dispose_result = '"+params[44]+"' ");
				if (!"".equals(params[41].trim()))
					mysql.append("AND applierinf1_.used_mark = "+params[41]+" ");
				if (!"".equals(params[42].trim()) || !"".equals(params[43].trim())){
					if("".equals(params[42].trim())) params[42]="1970-01-01";
					if("".equals(params[43].trim())) params[43]="2100-12-31";
					
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					try {
						params[42] = sdf1.format(sdf2.parse(params[42]));
						params[43] = sdf1.format(sdf2.parse(params[43]));
					} catch (ParseException e) {
					}
					mysql.append("and applierinf1_.mark_time between '"+params[42]+"' AND '"+params[43]+"' ");
				}
				
				if (!"".equals(params[9].trim()))
					mysql.append("AND applierinf2_.ao_name LIKE '%"+params[9]+"%' ");
				if (!"".equals(params[10].trim()))
					mysql.append("AND applierinf2_.ao_address LIKE '%"+params[10]+"%' ");
				if (!"".equals(params[11].trim()))
					mysql.append("AND applierinf2_.ao_name1 LIKE '%"+params[11]+"%' ");
				if (!"".equals(params[12].trim()))
					mysql.append("AND applierinf2_.ao_phone1 LIKE '%"+params[12]+"%' ");

				if (!"".equals(params[13].trim()))
					mysql.append("AND contacttel3_.ct_name LIKE '%"+params[13]+"%' ");
				if (!"".equals(params[37].trim()) || !"".equals(params[38].trim())){
					if("".equals(params[37].trim())) params[37]="1111年11月11日";
					if("".equals(params[38].trim())) params[38]="2222年22月22日";
					mysql.append("and contacttel3_.ct_time between '"+params[37]+"' AND '"+params[38]+"' ");
				}
				if (!"".equals(params[39].trim()))
					mysql.append("AND contacttel3_.ct_name1 LIKE '%"+params[39]+"%' ");
				if (!"".equals(params[40].trim()))
					mysql.append("AND contacttel3_.ct_tel1 LIKE '%"+params[40]+"%' ");

				
				if (!"".equals(params[14].trim()))
					mysql.append("AND contractsi4_.cs_name LIKE '%"+params[14]+"%' ");
				if (!"".equals(params[15].trim()))
					mysql.append("AND contractsi4_.cs_no LIKE '%"+params[15]+"%' ");

				if (!"".equals(params[16].trim()))
					mysql.append("AND executebus5_.e_renumber LIKE '%"+params[16]+"%' ");
				if (!"".equals(params[17].trim()))
					mysql.append("AND executebus5_.e_type LIKE '%"+params[17]+"%' ");
				if (!"".equals(params[18].trim()))
					mysql.append("AND executebus5_.e_name LIKE '%"+params[18]+"%' ");
				if (!"".equals(params[19].trim()))
					mysql.append("AND executebus5_.e_repname LIKE '%"+params[19]+"%' ");
				if (!"".equals(params[20].trim()))
					mysql.append("AND executebus5_.e_district LIKE '%"+params[20]+"%' ");
				if (!"".equals(params[21].trim()))
					mysql.append("AND executebus5_.e_organ LIKE '%"+params[21]+"%' ");
				if (!"".equals(params[22].trim()))
					mysql.append("AND executebus5_.e_address LIKE '%"+params[22]+"%' ");
				if (!"".equals(params[23].trim()))
					mysql.append("AND contactmai6_.cm_mail LIKE '%"+params[23]+"%' ");
				if (!"".equals(params[34].trim()))
					mysql.append("AND contact_ce_express.ce_name LIKE '%"+params[34]+"%' ");
				if (!"".equals(params[24].trim()))
					mysql.append("AND contact_ce_express.ce_number LIKE '%"+params[24]+"%' ");
				if(!"".equals(params[32].trim()))
					mysql.append("AND court0_.casecodeself LIKE '%"+params[32]+"%' ");
				if (!"".equals(params[33].trim()))
					mysql.append("AND applierinf1_.a_name LIKE '%"+params[33]+"%' ");
				if(exclude.size()== 1){
					if((exclude.get(0).toString().trim()).equals("2")){
						if(!"".equals(params[25].trim())){
							if("吊销".equals(params[25].trim()) || "注销".equals(params[25].trim())){
								mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
								mysql.append("AND court0_.executestep <3 ");
							}else{
								mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
							}
						}
					}
				}
				if(exclude.size() == 2){
					if(!"".equals(params[25].trim())){
						if("吊销".equals(params[25].trim()) || "注销".equals(params[25].trim())){
							mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
							mysql.append("AND court0_.executestep <3 ");
							mysql.append("AND court0_.excludeStatus ='0' ");
						}else{
							mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
							mysql.append("AND court0_.excludeStatus ='0' ");
						}
					}
				}
				
				mysql.append(" limit "+(currentPage-1)*pageSize+","+pageSize);
				String sql = mysql.toString();
				Query query = session.createSQLQuery(sql);
				return query.list();
			}
		});
	}

	@Override
	public Object excludeSeniorSelectPageSize(int pageSize,final List exclude,final String showNote, final String... params)
			throws Exception {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				StringBuffer mysql = new StringBuffer();
				mysql.append("select count(DISTINCT court0_.casecodeself) ");
				mysql.append("from lawyer.courtinfo court0_  ");
				
				if(!"".equals(params[5].trim()) || !"".equals(params[6].trim()) || !"".equals(params[7].trim()) || !"".equals(params[8].trim()) || !"".equals(params[33].trim())
						|| !"".equals(params[41].trim()) || !"".equals(params[42].trim()) || !"".equals(params[43].trim()) || !"".equals(params[44].trim()) ){
					mysql.append("left join lawyer.applierinfo applierinf1_ ");
					mysql.append("ON court0_.casecodeself=applierinf1_.a_c_casecodeself ");
				}
				if(!"".equals(params[9].trim()) || !"".equals(params[10].trim()) || !"".equals(params[11].trim()) || !"".equals(params[12].trim())){
					mysql.append("left join lawyer.applierinfo_onself applierinf2_ ");
					mysql.append("ON court0_.casecodeself=applierinf2_.ao_casecodeself ");
				}
				if(!"".equals(params[13].trim()) || !"".equals(params[37].trim()) || !"".equals(params[38].trim()) || !"".equals(params[39].trim()) || !"".equals(params[40].trim())){
					mysql.append("left join lawyer.contact_tel contacttel3_ ");
					mysql.append("ON court0_.casecodeself=contacttel3_.ct_casecodeself ");
				}
				if(!"".equals(params[15].trim()) || !"".equals(params[14].trim()) || !"".equals(params[26].trim()) || !"".equals(params[27].trim())){
					mysql.append("left join lawyer.contact_sign contractsi4_  ");
					mysql.append("ON court0_.casecodeself=contractsi4_.cs_casecodeself ");
				}
				if(!"".equals(params[16].trim()) || !"".equals(params[17].trim()) || !"".equals(params[18].trim()) || !"".equals(params[19].trim()) || !"".equals(params[20].trim()) || !"".equals(params[21].trim()) || !"".equals(params[22].trim()) || !"".equals(params[25].trim())){
					mysql.append("left join lawyer.executebusiness executebus5_ ");
					mysql.append("ON court0_.casecodeself=executebus5_.e_c_casecodeself ");
				}
				if(!"".equals(params[23].trim())){
					mysql.append("left join lawyer.contact_mail contactmai6_ ");
					mysql.append("ON court0_.casecodeself=contactmai6_.cm_casecodeself ");
				}
				if(!"".equals(params[24].trim()) || !"".equals(params[34].trim()) || !"".equals(params[35].trim()) || !"".equals(params[36].trim())){
					mysql.append("left join lawyer.contact_express contact_ce_express ");
					mysql.append("ON court0_.casecodeself=contact_ce_express.ce_casecodeself ");
				}
				mysql.append("where ");
				
				if (!"".equals(params[26].trim()) || !"".equals(params[27].trim())){
					if("".equals(params[26].trim())) params[26]="1111年11月11日";
					if("".equals(params[27].trim())) params[27]="2222年22月22日";
					mysql.append("and contractsi4_.cs_date between '"+params[26]+"' AND '"+params[27]+"' ");
				}
				if (!"".equals(params[35].trim()) || !"".equals(params[36].trim())){
					if("".equals(params[35].trim())) params[35]="1111年11月11日";
					if("".equals(params[36].trim())) params[36]="2222年22月22日";
					mysql.append("and contact_ce_express.ce_date between '"+params[35]+"' AND '"+params[36]+"' ");
				}
				
				if(showNote.endsWith("1")){
					if("".equals(params[28].trim())) params[28]="1111年11月11日";
					if("".equals(params[29].trim())) params[29]="2222年22月22日";
					mysql.append("court0_.noticeTime between '"+params[28]+"' and '"+params[29]+"' ");
					if(!"".equals(params[0].trim()))
						mysql.append("and court0_.pname LIKE '%"+params[0]+"%' ");
					if(!"".equals(params[2].trim()))
						mysql.append("AND court0_.noticeCourt LIKE '%"+params[2]+"%' ");
					if(!"".equals(params[3].trim()))
						mysql.append("AND court0_.lawDocumentNum LIKE '%"+params[3]+"%' ");
				}else{
					if("".equals(params[28].trim())) params[28]="1111年11月11日";
					if("".equals(params[29].trim())) params[29]="2222年22月22日";
					mysql.append("court0_.caseCreateTime between '"+params[28]+"' and '"+params[29]+"' ");
					if(!"".equals(params[30].trim()) || !"".equals(params[31].trim())){
						if("".equals(params[30].trim())) params[30]="0";
						if("".equals(params[31].trim())) params[31]="111111111111";
						mysql.append("and court0_.execMoney between '"+params[30]+"' and '"+params[31]+"' ");
					}
					if(!"".equals(params[0].trim()))
						mysql.append("and court0_.pname LIKE '%"+params[0]+"%' ");
					if(!"".equals(params[1].trim()))
						mysql.append("AND court0_.partyCardNum LIKE '%"+params[1]+"%' ");
					if(!"".equals(params[2].trim()))
						mysql.append("AND court0_.execCourtName LIKE '%"+params[2]+"%' ");
					if(!"".equals(params[3].trim()))
						mysql.append("AND court0_.caseCode LIKE '%"+params[3]+"%' ");
					if(!"".equals(params[4].trim()))
						mysql.append("AND court0_.caseState LIKE '%"+params[4]+"%' ");
				}
				
				if (!"".equals(params[5].trim()))
					mysql.append("AND applierinf1_.a_repname LIKE '%"+params[5]+"%' ");
				if (!"".equals(params[6].trim()))
					mysql.append("AND applierinf1_.a_district LIKE '%"+params[6]+"%' ");
				if (!"".equals(params[7].trim()))
					mysql.append("AND applierinf1_.a_organ LIKE '%"+params[7]+"%' ");
				if (!"".equals(params[8].trim()))
					mysql.append("AND applierinf1_.a_address LIKE '%"+params[8]+"%' ");
				if (!"".equals(params[44].trim()))
					mysql.append("AND applierinf1_.dispose_result = '"+params[44]+"' ");
				if (!"".equals(params[41].trim()))
					mysql.append("AND applierinf1_.used_mark = "+params[41]+" ");
				if (!"".equals(params[42].trim()) || !"".equals(params[43].trim())){
					if("".equals(params[42].trim())) params[42]="1970-01-01";
					if("".equals(params[43].trim())) params[43]="2100-12-31";
					
					SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					try {
						params[42] = sdf1.format(sdf2.parse(params[42]));
						params[43] = sdf1.format(sdf2.parse(params[43]));
					} catch (ParseException e) {
					}
					mysql.append("and applierinf1_.mark_time between '"+params[42]+"' AND '"+params[43]+"' ");
				}

				if (!"".equals(params[9].trim()))
					mysql.append("AND applierinf2_.ao_name LIKE '%"+params[9]+"%' ");
				if (!"".equals(params[10].trim()))
					mysql.append("AND applierinf2_.ao_address LIKE '%"+params[10]+"%' ");
				if (!"".equals(params[11].trim()))
					mysql.append("AND applierinf2_.ao_name1 LIKE '%"+params[11]+"%' ");
				if (!"".equals(params[12].trim()))
					mysql.append("AND applierinf2_.ao_phone1 LIKE '%"+params[12]+"%' ");

				if (!"".equals(params[13].trim()))
					mysql.append("AND contacttel3_.ct_name LIKE '%"+params[13]+"%' ");
				if (!"".equals(params[37].trim()) || !"".equals(params[38].trim())){
					if("".equals(params[37].trim())) params[37]="1111年11月11日";
					if("".equals(params[38].trim())) params[38]="2222年22月22日";
					mysql.append("and contacttel3_.ct_time between '"+params[37]+"' AND '"+params[38]+"' ");
				}
				if (!"".equals(params[39].trim()))
					mysql.append("AND contacttel3_.ct_name1 LIKE '%"+params[39]+"%' ");
				if (!"".equals(params[40].trim()))
					mysql.append("AND contacttel3_.ct_tel1 LIKE '%"+params[40]+"%' ");
				
				
				if (!"".equals(params[14].trim()))
					mysql.append("AND contractsi4_.cs_name LIKE '%"+params[14]+"%' ");
				if (!"".equals(params[15].trim()))
					mysql.append("AND contractsi4_.cs_no LIKE '%"+params[15]+"%' ");
				if (!"".equals(params[16].trim()))
					mysql.append("AND executebus5_.e_renumber LIKE '%"+params[16]+"%' ");
				if (!"".equals(params[17].trim()))
					mysql.append("AND executebus5_.e_type LIKE '%"+params[17]+"%' ");
				if (!"".equals(params[18].trim()))
					mysql.append("AND executebus5_.e_name LIKE '%"+params[18]+"%' ");
				if (!"".equals(params[19].trim()))
					mysql.append("AND executebus5_.e_repname LIKE '%"+params[19]+"%' ");
				if (!"".equals(params[20].trim()))
					mysql.append("AND executebus5_.e_district LIKE '%"+params[20]+"%' ");
				if (!"".equals(params[21].trim()))
					mysql.append("AND executebus5_.e_organ LIKE '%"+params[21]+"%' ");
				if (!"".equals(params[22].trim()))
					mysql.append("AND executebus5_.e_address LIKE '%"+params[22]+"%' ");
				if (!"".equals(params[23].trim()))
					mysql.append("AND contactmai6_.cm_mail LIKE '%"+params[23]+"%' ");
				if (!"".equals(params[24].trim()))
					mysql.append("AND contact_ce_express.ce_number LIKE '%"+params[24]+"%' ");
				if (!"".equals(params[34].trim()))
					mysql.append("AND contact_ce_express.ce_name LIKE '%"+params[34]+"%' ");
					
				if(!"".equals(params[32].trim()))
					mysql.append("AND court0_.casecodeself LIKE '%"+params[32]+"%' ");
				if (!"".equals(params[33].trim()))
					mysql.append("AND applierinf1_.a_name LIKE '%"+params[33]+"%' ");
				if(exclude.size() == 1){
					if((exclude.get(0)).equals("2")){
						if(!"".equals(params[25].trim())){
							if("吊销".equals(params[25].trim()) || "注销".equals(params[25].trim())){
								mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
								mysql.append("AND court0_.executestep <3 ");
							}else{
								mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
							}
						}
					}
				}
				if(exclude.size() == 2){
					if(!"".equals(params[25].trim())){
						if("吊销".equals(params[25].trim()) || "注销".equals(params[25].trim())){
							mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
							mysql.append("AND court0_.executestep <3 ");
						}else{
							mysql.append("AND executebus5_.e_status LIKE '%"+params[25]+"%' ");
						}
					}
				}
				String sql = mysql.toString();
				Query query = session.createSQLQuery(sql);
				
				return query.list().get(0);
			}
		});
	}

}
