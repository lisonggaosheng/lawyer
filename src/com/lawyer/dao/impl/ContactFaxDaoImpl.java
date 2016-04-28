package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContactFaxDao;
import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Users;

public class ContactFaxDaoImpl extends HibernateDaoSupport implements ContactFaxDao {

	public void insertContactFax(ContactFax contactFax) throws Exception {
		this.getHibernateTemplate().save(contactFax);
		String sql = "UPDATE courtinfo SET executestep='6' WHERE casecodeself = '"+contactFax.getCfCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public ContactFax selectContactFax(ContactFax contactFax, Users users)
			throws Exception {
		String str1 = "";
		String str2 = "";
		ContactFax conFax = null;
		Iterator<ContactFax> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			conFax = it.next();
		}
		return conFax;
	}

	@SuppressWarnings("unchecked")
	public List selectContactFax(ContactFax contactFax) throws Exception {
		List list = this.getHibernateTemplate().find("from ContactFax where cfCasecodeself = '"+contactFax.getCfCasecodeself()+"' ");
		return list;
	}

	public void updateContactFax(ContactFax contactFax) throws Exception {
		this.getHibernateTemplate().load(ContactFax.class, contactFax.getCfId());
	}

	public void deleteContactFax(ContactFax contactFax) throws Exception {
		this.getHibernateTemplate().delete(contactFax);
	}

	@Override
	public ContactFax showConFax(String casecodeself) throws Exception {
		String hql = "from ContactFax where cfCasecodeself='"
				+ casecodeself + "' order by cfSavetime desc";
		List<ContactFax> confaxs = this.getHibernateTemplate().find(hql);
		if(confaxs.size()<1){
			return null;
		}else{
			return confaxs.get(0);
		}
	}

}
