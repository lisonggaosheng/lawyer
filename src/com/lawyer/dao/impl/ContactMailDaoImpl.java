package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContactMailDao;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Users;

public class ContactMailDaoImpl extends HibernateDaoSupport implements ContactMailDao {

	public void insertContactMail(ContactMail contactMail) throws Exception {
		this.getHibernateTemplate().save(contactMail);
		String sql = "UPDATE courtinfo SET executestep='6' WHERE casecodeself = '"+contactMail.getCmCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	public ContactMail selectContactMail(ContactMail contactMail, Users users)
			throws Exception {
		String str1 = "";
		String str2 = "";
		ContactMail conMa = null;
		Iterator<ContactMail> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			conMa = it.next();
		}
		return conMa;
	}

	@SuppressWarnings("unchecked")
	public List selectContactMail(ContactMail contactMail) throws Exception {
		List list =this.getHibernateTemplate().find("from ContactMail where cmCasecodeself = '"+contactMail.getCmCasecodeself()+"' ");
		return list;
	}

	public void updateContactMail(ContactMail contactMail) throws Exception {
		this.getHibernateTemplate().load(ContactMail.class, contactMail.getCmId());
	}

	public void deleteContactMail(ContactMail contactMail) throws Exception {
		this.getHibernateTemplate().delete(contactMail);
	}

}
