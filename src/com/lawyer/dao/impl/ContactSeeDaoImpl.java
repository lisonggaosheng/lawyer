package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContactSeeDao;
import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.Users;

public class ContactSeeDaoImpl extends HibernateDaoSupport implements ContactSeeDao {

	public void insertContactSee(ContactSee contactSee) throws Exception {
		this.getHibernateTemplate().save(contactSee);
		String sql = "UPDATE courtinfo SET executestep='6' WHERE casecodeself = '"+contactSee.getCsCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public ContactSee selectContactSee(ContactSee contactSee, Users users)
			throws Exception {
		String str1 = "";
		String str2 = "";
		ContactSee conSee = null;
		Iterator<ContactSee> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			conSee = it.next();
		}
		return conSee;
	}

	@SuppressWarnings("unchecked")
	public List selectContactSee(ContactSee contactSee) throws Exception {
		List list = this.getHibernateTemplate().find("from ContactSee where csCasecodeself = '"+contactSee.getCsCasecodeself()+"' ");
		return list;
	}

	public void updateContactSee(ContactSee contactSee) throws Exception {
		this.getHibernateTemplate().load(ContactSee.class, contactSee.getCsId());
	}

	public void deleteContactSee(ContactSee contactSee) throws Exception {
		this.getHibernateTemplate().delete(contactSee);
	}
}
