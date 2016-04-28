package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContactTalkDao;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactTalk;
import com.lawyer.pojo.Users;

public class ContactTalkDaoImpl extends HibernateDaoSupport implements ContactTalkDao {

	public void insertContactTalk(ContactTalk contactTalk) throws Exception {
		this.getHibernateTemplate().save(contactTalk);
		String sql = "UPDATE courtinfo SET executestep='6' WHERE casecodeself = '"+contactTalk.getCtCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public ContactTalk selectContactTalk(ContactTalk ContactTalk, Users users)
			throws Exception {
		String str1 = "";
		String str2 = "";
		ContactTalk conSee = null;
		Iterator<ContactTalk> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			conSee = it.next();
		}
		return conSee;
	}

	@SuppressWarnings("unchecked")
	public List<ContactTalk> selectContactTalk(ContactTalk contactTalk) throws Exception {
		List<ContactTalk> list = this.getHibernateTemplate().find("from ContactTalk where ctCasecodeself = '"+contactTalk.getCtCasecodeself()+"' ");
		return list;
	}

	public void updateContactTalk(ContactTalk contactTalk) throws Exception {
		this.getHibernateTemplate().load(ContactTalk.class, contactTalk.getCtId());
	}

	public void deleteContactTalk(ContactTalk contactTalk) throws Exception {
		this.getHibernateTemplate().delete(contactTalk);
	}

	@Override
	public ContactTalk showConTalk(String casecodeself) throws Exception {
		String hql = "from ContactTalk where ctCasecodeself='"
				+ casecodeself + "' order by ctSavetime desc";
		List<ContactTalk> contalks = this.getHibernateTemplate().find(hql);
		if(contalks.size()<1){
			return null;
		}else{
			return contalks.get(0);
		}
	}
}
