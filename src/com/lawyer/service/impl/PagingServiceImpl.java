package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.PagingDao;
import com.lawyer.service.PagingService;
import com.lawyer.tools.PageBean;

public class PagingServiceImpl implements PagingService{

	PagingDao pagingDao;
	
	public PagingDao getPagingDao() {
		return pagingDao;
	}

	public void setPagingDao(PagingDao pagingDao) {
		this.pagingDao = pagingDao;
	}

	public int getAllRowCount(String hql) {
		return this.pagingDao.getAllRowCount(hql);
	}

	public List queryForPage(String hql, int offset, int length) {
		return this.pagingDao.queryForPage(hql, offset, length);
	}

	public PageBean queryForPage(int pageSize, int page, Object obj,String i,String starttime,String endtime) {
		return this.pagingDao.queryForPage(pageSize, page, obj,i,starttime,endtime);
	}

}
