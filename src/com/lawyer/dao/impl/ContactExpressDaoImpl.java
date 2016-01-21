package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContactExpressDao;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.Users;

public class ContactExpressDaoImpl extends HibernateDaoSupport implements ContactExpressDao {

	public void insertContactExpress(ContactExpress contactExpress)
			throws Exception {
		this.getHibernateTemplate().save(contactExpress);
		String sql = "UPDATE courtinfo SET executestep='6' WHERE casecodeself = '"+contactExpress.getCeCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public ContactExpress selectContactExpress(ContactExpress contactExpress,
			Users users) throws Exception {
		String str1 = "";
		String str2 = "";
		ContactExpress conEx = null;
		Iterator<ContactExpress> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			conEx = it.next();
		}
		return conEx;
	}

	@SuppressWarnings("unchecked")
	public List selectContactExpress(ContactExpress contactExpress)
			throws Exception {
		List list = this.getHibernateTemplate().find("from ContactExpress where ceCasecodeself = '"+contactExpress.getCeCasecodeself()+"'");
		return list;
	}

	public void updateContactExpress(ContactExpress contactExpress)
			throws Exception {
		this.getHibernateTemplate().load(ContactExpress.class, contactExpress.getCeId());
	}

	public void deleteContactExpress(ContactExpress contactExpress)
			throws Exception {
		this.getHibernateTemplate().delete(contactExpress);
	}

}
