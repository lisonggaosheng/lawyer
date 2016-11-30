package com.lawyer.dao.impl;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.LawyerCourtDao;
import com.lawyer.pojo.LawyerCourt;

public class LawyerCourtDaoImpl extends HibernateDaoSupport implements LawyerCourtDao {

	/**
	 * 查找所有法院信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LawyerCourt> selectAll() throws Exception {
		return this.getHibernateTemplate().find("from LawyerCourt");
	}
	/**
	 * 查找一级的法院
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LawyerCourt> selectFirst() throws Exception {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from LawyerCourt c where c.lawyerCourt_pid = 0");
	}
	/**
	 * 根据一级查找二级
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LawyerCourt> selectSecond(String fir_id) throws Exception {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from LawyerCourt c where c.lawyerCourt_pid ="+fir_id);
	}
	/**
	 * 根据二级查找三级
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<LawyerCourt> selectThird(String sec_id) throws Exception {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from LawyerCourt c where c.lawyerCourt_pid ="+sec_id);
	}
	/**
	 * 根据id查找法院
	 */
	@SuppressWarnings("unchecked")
	public LawyerCourt selectCourtByID(int courtid) throws Exception {
		// TODO Auto-generated method stub
		return (LawyerCourt) this.getHibernateTemplate().get(LawyerCourt.class, courtid);
	}
	
	/**
	 * 根据number查找法院
	 */
	public LawyerCourt selectCourtByNumber(String courtnumber) throws Exception {
		LawyerCourt lawyerCourt = new LawyerCourt();
		Iterator<LawyerCourt> lcs = this
		.getHibernateTemplate()
		.find("from LawyerCourt lc where lc.lawyerCourt_number='"
				+ courtnumber + "'")
		.iterator();
		while (lcs.hasNext()) {
			lawyerCourt = lcs.next();
		}
		return lawyerCourt;
	}

}
