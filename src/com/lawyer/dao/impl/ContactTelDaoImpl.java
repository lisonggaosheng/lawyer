package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContactTelDao;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Users;

public class ContactTelDaoImpl extends HibernateDaoSupport implements ContactTelDao {

	public void insertContactTel(ContactTel contactTel) throws Exception {
		this.getHibernateTemplate().save(contactTel);
		String sql = "UPDATE courtinfo SET executestep='6' WHERE casecodeself = '"+contactTel.getCtCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public ContactTel selectContactTel(ContactTel contactTel, Users users)
			throws Exception {
		String str1="";
		String str2="";
		ContactTel ct = null;
		Iterator<ContactTel> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			ct = it.next();
		}
		return ct;
	}

	@SuppressWarnings("unchecked")
	public List selectContactTel(ContactTel contactTel) throws Exception {
		List list = this.getHibernateTemplate().find("from ContactTel where ctCasecodeself = '"+contactTel.getCtCasecodeself()+"'");
		return list;
	}

	public void updateContactTel(ContactTel contactTel) throws Exception {
		this.getHibernateTemplate().load(ContactTel.class, contactTel.getCtId());
	}

	public void deleteContactTel(ContactTel contactTel) throws Exception {
		this.getHibernateTemplate().delete(contactTel);
	}

	@Override
	public ContactTel showConTel(String casecodeself) throws Exception {
		String hql = "from ContactTel where ctCasecodeself='"
				+ casecodeself + "' order by ctSavetime desc";
		List<ContactTel> contels = this.getHibernateTemplate().find(hql);
		if(contels.size()<1){
			return null;
		}else{
			return contels.get(0);
		}
	}

}
