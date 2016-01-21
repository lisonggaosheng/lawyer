package com.lawyer.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.FilesDao;
import com.lawyer.pojo.Filelibrary;
import com.lawyer.pojo.Files;

public class FilesDaoImpl extends HibernateDaoSupport implements FilesDao {



	public void filesUpload(Files files1) {
		this.getHibernateTemplate().save(files1);
	}

	public List list(String hql) {
		
		return this.getHibernateTemplate().find(hql);
	}

	public Filelibrary loadById(int id) {

		return (Filelibrary) this.getHibernateTemplate().get(Filelibrary.class, id);
	}

	public Files filesById(int id) {
		
		return (Files) this.getHibernateTemplate().get(Files.class, id);
	}

	public void update(Files fl) {
		this.getHibernateTemplate().update(fl);
	}
	public void delete(Files f) {
		this.getHibernateTemplate().delete(f);
	}

	public void deleteById(int id) {
		Files f=(Files) this.getHibernateTemplate().get(Files.class, id);
		this.delete(f);
	}


}
