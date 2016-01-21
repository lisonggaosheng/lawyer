package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.lawyer.dao.FilelibraryDao;

import com.lawyer.pojo.Filelibrary;

public class FilelibraryDaoImpl extends HibernateDaoSupport implements FilelibraryDao {

	/**
	 * @author 张西锋
	 * @since 2013-3-19
	 * @version 1.0
	 */
	public void add(Filelibrary filelibrary) {
		this.getHibernateTemplate().save(filelibrary);		
	}

	public List list(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	/*
	 * 根据id查询Filelibrary
	 */
	public Filelibrary loadById(int id) {
		return (Filelibrary) this.getHibernateTemplate().get(Filelibrary.class, id);
	}

	public void update(Filelibrary fl) {
		this.getHibernateTemplate().update(fl);
	}
	
	public void delete(Filelibrary fl) {
		this.getHibernateTemplate().delete(fl);
	}

	public void deleteById(int id) {
		Filelibrary f=(Filelibrary) this.getHibernateTemplate().get(Filelibrary.class, id);
		this.delete(f);
	}

	public List<Filelibrary> selectFilelibrary(Filelibrary filelibrary) {
		 List<Filelibrary> list=this.getHibernateTemplate().find("from Filelibrary where fl_id ="+filelibrary.getFlId()+" or fl_name ='"+filelibrary.getFlName()+"' or fl_category='"+filelibrary.getFlCategory()+"'");
		return list;
		
	}

	@Override
	public List<Filelibrary> findAllFilelibrary() {
		return this.getHibernateTemplate().find("from Filelibrary");
	}

}
