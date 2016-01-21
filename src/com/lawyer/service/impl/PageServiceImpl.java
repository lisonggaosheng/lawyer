package com.lawyer.service.impl;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.IPageDao;
import com.lawyer.pojo.PageBean;
import com.lawyer.service.PageService;

public class PageServiceImpl  implements PageService {

	private IPageDao pageDao;
	
	public IPageDao getPageDao() {
		return pageDao;
	}

	public void setPageDao(IPageDao pageDao) {
		this.pageDao = pageDao;
	}

	public int getAllRowCount(String hql) throws Exception {
		return pageDao.getAllRowCount(hql);
	}

	public List queryForPage(String hql, int offset, int length)
			throws Exception {
		return pageDao.queryForPage(hql, offset, length);
	}

	/**
	 * 刘腾升
	 * 通用分页方法调用方式
	 * 最后一个字符串 where 中写查询要用的条件
	 * */
	public PageBean queryForPage(int pageSize, int page, String object,
			String id,String where) throws Exception {
		return pageDao.queryForPage(pageSize, page, object, id,where);
	}

}
