package com.lawyer.dao.impl;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.AddrecordDao;
import com.lawyer.pojo.Addrecord;

public class AddrecordDaoImpl extends HibernateDaoSupport implements AddrecordDao {

	/**
	 * //添加 用户添加案件记录——郭志鹏
	 */
	public void insertRecord(Addrecord addrecord) throws Exception {
		this.getHibernateTemplate().save(addrecord);
	}

}
