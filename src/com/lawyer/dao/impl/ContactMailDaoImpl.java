package com.lawyer.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContactMailDao;
import com.lawyer.pojo.ClearRecord;
import com.lawyer.pojo.ContactMail;

public class ContactMailDaoImpl extends HibernateDaoSupport implements ContactMailDao {

	public void insertContactMail(ContactMail contactMail) throws Exception {
		this.getHibernateTemplate().save(contactMail);
		String sql = "UPDATE courtinfo SET executestep='6' WHERE casecodeself = '"+contactMail.getCmCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("rawtypes")
	public List<ContactMail> selectContactMail(ContactMail contactMail) throws Exception {
		List<ContactMail> list =this.getHibernateTemplate().find("from ContactMail where cmCasecodeself = '"+contactMail.getCmCasecodeself()+"' ");
		return list;
	}

	public void updateContactMail(ContactMail contactMail) throws Exception {
		this.getHibernateTemplate().load(ContactMail.class, contactMail.getCmId());
	}

	public void deleteContactMail(ContactMail contactMail) throws Exception {
		this.getHibernateTemplate().delete(contactMail);
	}

	@Override
	public ContactMail showConMail(String casecodeself) throws Exception {
		String hql = "from ContactMail cm where cm.cmCasecodeself='"
				+ casecodeself + "' order by cm.cmSavetime desc";
		List<ContactMail> conmails = this.getHibernateTemplate().find(hql);
		if(conmails.size()<1){
			return null;
		}else{
			return conmails.get(0);
		}
	}

}
