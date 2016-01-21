package com.lawyer.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lawyer.dao.PagingDao;
import com.lawyer.pojo.Filelibrary;
import com.lawyer.pojo.Files;
import com.lawyer.tools.PageBean;

public class PagingDaoImpl extends HibernateDaoSupport implements PagingDao{

	public int getAllRowCount(String hql) {
		List list=this.getHibernateTemplate().find(hql);
		return list.size();
	}

	/**
	 * 把数据表中的数据分页放入List
	 */
	public List queryForPage(String hql, int offset, int length) {
		//Hibernate分页
		Query q=this.getSession().createQuery(hql);
		q.setFirstResult(offset);
		q.setMaxResults(length);
		List list=q.list();
		return list;
	}

	/**
	 * 先把数据表中的数据分页入List，然后把List在页面分页
	 */
	public PageBean queryForPage(int pageSize, int page,Object obj,String i,String starttime,String endtime) {
		// 页面分页
		String hql=null;
		
		if(i.equals("null")){
			hql="from "+obj;
		}else if(i.equals("filelibrary")){
			Filelibrary fl=(Filelibrary) obj;
			hql="from Filelibrary where fl_name like '%"+fl.getFlName()+"%' and fl_category like '%"+fl.getFlCategory()+"%'";
		}else if(i.equals("files")){
			Files f=(Files) obj;
			hql="from Files where filelibrary.flId="+f.getFilelibrary().getFlId();
		}else if(i.equals("files2")){
			Files f=(Files) obj;
			hql="from Files where filelibrary.flId = '"+f.getFilelibrary().getFlId()+"' and FTitle like '%"+f.getFTitle()+"%' and FReldate between '"+starttime+"' and '"+endtime+"' ";
		}
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
