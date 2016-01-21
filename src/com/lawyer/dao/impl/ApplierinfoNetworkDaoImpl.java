package com.lawyer.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ApplierinfoNetworkDao;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;

public class ApplierinfoNetworkDaoImpl extends HibernateDaoSupport implements ApplierinfoNetworkDao{

	private ApplierinfoNetworkDao applierinfoNetworkDao;
	
	public ApplierinfoNetworkDao getApplierinfoNetworkDao() {
		return applierinfoNetworkDao;
	}

	public void setApplierinfoNetworkDao(ApplierinfoNetworkDao applierinfoNetworkDao) {
		this.applierinfoNetworkDao = applierinfoNetworkDao;
	}

	public void insertAppnet(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		this.getHibernateTemplate().save(applierinfoNetwork);
		
		String sql = "UPDATE courtinfo SET executestep='4' WHERE casecodeself = '"+applierinfoNetwork.getAnCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public ApplierinfoNetwork selectAppnet(
			ApplierinfoNetwork applierinfoNetwork, Users users)
			throws Exception {
		ApplierinfoNetwork appnet=null;
		Iterator<ApplierinfoNetwork> it=this.getHibernateTemplate().find("from ApplierinfoNetwork").iterator();
		while(it.hasNext()){
			appnet=it.next();
		}
		return appnet;
	}

	@SuppressWarnings("unchecked")
	public List selectAppnet(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		List list = this.getHibernateTemplate().find("from ApplierinfoNetwork where anCasecodeself = '"+applierinfoNetwork.getAnCasecodeself()+"' ");
		return list;
	}

	public void updateAppnet(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		this.getHibernateTemplate().load(ApplierinfoNetwork.class, applierinfoNetwork.getAnId());
	}
	/**
	 * 案源批处理申请执行人企业信息（网络信息）——郭志鹏
	 */
	@SuppressWarnings("unchecked")
	public void insertAppNets(Users user) throws Exception {
		String sql = "SELECT ID as an_id, business_name AS an_name,address AS an_address,lianxiren AS an_conname,phone AS an_phone,fax AS an_fax,email AS an_mail,unique_code AS an_casecodeself,savetime as an_savetime,uid as an_uid from searchengine WHERE unique_code in(SELECT casecodeself AS unique_code FROM `"+user.getUName()+"step4start` )";
		List list = this.getSession().createSQLQuery(sql).addEntity(
				"applierinfo_network", ApplierinfoNetwork.class).list();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (list.size() > 0) {
			Iterator it = list.iterator();
			while (it.hasNext()) {
				ApplierinfoNetwork an = (ApplierinfoNetwork) it.next();
				/*String name = "";
				String address = "";
				String conname ="";
				String phone ="";
				String fax = "";
				String mail = "";
				if(an.getAnName()!=null && an.getAnName().length() > 100){
					name = an.getAnName().substring(0,100);
				}else{
					name = an.getAnName();
				}
				if(an.getAnAddress()!=null && an.getAnAddress().length() > 100){
					 address = an.getAnAddress().substring(0, 100);
				}else{
					address = an.getAnAddress();
				}
				if( an.getAnConname()!=null && an.getAnConname().length() > 100){
					conname = an.getAnConname().substring(0, 100);
				}else{
					conname = an.getAnConname();
				}
				if(an.getAnPhone()!=null && an.getAnPhone().length() > 100){
					phone = an.getAnPhone().substring(0, 100);
				}else{
					phone = an.getAnPhone();
				}
				if(an.getAnFax()!=null && an.getAnFax().length() > 100){
					fax = an.getAnFax().substring(0, 100);
				}else{
					fax = an.getAnFax();
				}
				if(an.getAnMail()!=null && an.getAnMail().length() > 100){
					mail = an.getAnMail().substring(0, 100);
				}else{
					mail = an.getAnMail();
				}
				
				String sqlstr = "INSERT INTO applierinfo_network(an_name,an_address,an_conname,an_phone,an_fax,an_mail,an_casecodeself,an_savetime,an_uid) values('"+name+"','"+address+"','"+conname+"','"+phone+"','"+fax+"','"+mail+"','"+an.getAnCasecodeself()+"','"+sdf.format(new Date())+"','"+user.getUId()+"')";
				*/
				
			String sqlstr = "INSERT INTO applierinfo_network(an_name,an_address,an_conname,an_phone,an_fax,an_mail,an_casecodeself,an_savetime,an_uid) values('"+an.getAnName()+"','"+an.getAnAddress()+"','"+an.getAnConname()+"','"+an.getAnPhone()+"','"+an.getAnFax()+"','"+an.getAnMail()+"','"+an.getAnCasecodeself()+"','"+sdf.format(new Date())+"','"+user.getUId()+"')";
				this.getSession().createSQLQuery(sqlstr).executeUpdate();
			}
		}			
		
		String sql3 = " UPDATE courtinfo SET executestep='4' WHERE casecodeself IN (SELECT casecodeself from `"+user.getUName()+"step4start`)";	
		this.getSession().createSQLQuery(sql3).executeUpdate();
			
		String sql4 = "DELETE FROM searchengine WHERE unique_code IN (SELECT casecodeself as unique_code from `"+user.getUName()+"step4start`)";
		this.getSession().createSQLQuery(sql4).executeUpdate();
	//	sql4 = "DROP TABLE `"+user.getUName()+"step4start`";
	//	this.getSession().createSQLQuery(sql4).executeUpdate();
	}

	@Override
	public void insertAppnetOne(ApplierinfoNetwork appnet)
			throws Exception {
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		Users user=(Users) session.getAttribute("admin");
		String sql = "";
		sql = "DROP TABLE IF EXISTS `"+user.getUName()+"step4start`";
		this.getSession().createSQLQuery(sql).executeUpdate();
//		String sql = "delete from step4start";
		sql = "CREATE TABLE `"+user.getUName()+"step4start` (`id` int(11) NOT NULL AUTO_INCREMENT,`casecodeself` varchar(255) NOT NULL,`pname` varchar(255) NOT NULL,`beizhu` varchar(255) NOT NULL,PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8";
		this.getSession().createSQLQuery(sql).executeUpdate();

		sql = "INSERT INTO `"+user.getUName()+"step4start`(casecodeself,pname,beizhu) VALUES('"
				+ appnet.getAnCasecodeself() + "','"
				+ appnet.getAnName() + "','') ";
		this.getSession().createSQLQuery(sql).executeUpdate();
		
	}

	@Override
	public void deleteAppnet(ApplierinfoNetwork applierinfoNetwork)
			throws Exception {
		HibernateTemplate ht = this.getHibernateTemplate();
		ApplierinfoNetwork appnet = (ApplierinfoNetwork) ht.get(ApplierinfoNetwork.class, applierinfoNetwork.getAnId());
		this.getHibernateTemplate().delete(appnet);
	}
}
