package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ApplierinfoOnselfDao;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Users;

public class ApplierinfoOnselfDaoImpl extends HibernateDaoSupport implements ApplierinfoOnselfDao {

	public void insertAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		this.getHibernateTemplate().save(applierinfoOnself);
		
		String sql = "UPDATE courtinfo SET executestep='5' WHERE casecodeself = '"+applierinfoOnself.getAoCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public ApplierinfoOnself selectAppOnself(
			ApplierinfoOnself applierinfoOnself, Users users) throws Exception {
		String str1="案源管理申请执行人企业信息（自有信息）";
		String str2="新增";
		ApplierinfoOnself appOne=null;
		Iterator<ApplierinfoOnself> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			appOne = it.next();
		}
		return appOne;
	}

	public List selectAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		return this.getHibernateTemplate().find("from ApplierinfoOnself");
	}

	public void updateAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		this.getHibernateTemplate().load(ApplierinfoOnself.class, applierinfoOnself.getAoId());
	}

	public void deleteAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		this.getHibernateTemplate().delete(applierinfoOnself);
	}

}
