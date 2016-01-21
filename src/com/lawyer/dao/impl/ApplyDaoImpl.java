package com.lawyer.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ApplyDao;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Users;

public class ApplyDaoImpl extends HibernateDaoSupport implements ApplyDao{
	/**
	 *通过用户名模糊查询申请信息
	 *刘腾升
	 * */
	public List selectName(Users users) throws Exception {
		return this.getHibernateTemplate().find("select a from Apply a left join a.users u where u.UName like '%"+users.getUName()+"%' and a.appSta ='申请中'");
	}
	/**
	 * 通过用户ID批准授权
	 * 刘腾升
	 * */
	public void authorize(Apply apply) throws Exception {
		this.getHibernateTemplate().update(apply);
	}
	/**
	 * 通过用户ID得到授权记录
	 * 刘腾升
	 * */
	public Apply selectID(Apply apply) throws Exception {
		return (Apply) this.getHibernateTemplate().get(Apply.class, apply.getAppId());
	}
	/**
	 * 通过用户ID拒绝授权
	 * 刘腾升
	 * */
	public void decline(Apply apply) throws Exception {
		this.getHibernateTemplate().delete(apply);
	}
	/**
	 *通过用户名模糊查询申请信息2
	 *刘腾升
	 * */
	public List selectName2(Users users) throws Exception {
		return this.getHibernateTemplate().find("from Apply a left join fetch a.users u where u.UName like '%"+users.getUName()+"%' and a.appSta ='已批准'");
	}
}
