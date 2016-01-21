package com.lawyer.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lawyer.dao.IPageDao;
import com.lawyer.pojo.PageBean;


public class PageDaoImpl extends HibernateDaoSupport implements IPageDao {

	/**
	 * 查询所有记录数 
	 * @param hql 查询的条件
	 * @return 总记录数
	 */
	public int getAllRowCount(String hql) throws Exception {
		List list=this.getHibernateTemplate().find(hql);
		return list.size();
	}

	/**
	 * 分页查询
     * @param hql 查询的条件
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return list
	 */
	public List queryForPage(String hql, int offset, int length)
			throws Exception {
		Query q=this.getSession().createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List list=q.list();
		return list;
	}

	/**
	 * 刘腾升
	 * 通用分页方法调用方式
	 * 最后一个字符串 where 中写查询要用的条件
	 * */
	/**
	 * 分页查询
     * @param page 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
	 */
	public PageBean queryForPage(int pageSize, int page, String object,
			String id,String where) throws Exception {
		String hql="from "+object+" "+where+" order by "+id+" desc";
		//总条数
		int allRow=getAllRowCount(hql);
		//总页数
		int totalPage=PageBean.countTotalPage(pageSize, allRow);
		//当前页
		int currentPage=PageBean.countCurrentPage(page);
		//当前页开始记录
		int offset=PageBean.countOffset(pageSize, currentPage);
		List list=queryForPage(hql,offset,pageSize);
		//把各个属性封装到PageBean
		PageBean pb=new PageBean();
		pb.setAllRow(allRow);
		pb.setCurrentPage(currentPage);
		pb.setPageSize(pageSize);
		pb.setTotalPage(totalPage);
		pb.setList(list);
		pb.init();
		return pb;
	}

}
