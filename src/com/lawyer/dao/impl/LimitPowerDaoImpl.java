package com.lawyer.dao.impl;

import java.util.Iterator;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.LimitPowerDao;
import com.lawyer.pojo.LimitPower;
/**
 * 用户权限持久层实现类
 * @author 李梦翔
 * @date 2013-5-6 19:46:32
 *
 */
public class LimitPowerDaoImpl extends HibernateDaoSupport implements LimitPowerDao{
	/**
	 * 添加用户权限
	 */
	@Override
	public void addLP(LimitPower limitPower) {
		this.getHibernateTemplate().save(limitPower);
	}
	/**
	 * 根据用户名查询用户权限
	 */
	@Override
	public LimitPower selectLPByUserName(String userName) {
		LimitPower lp = null;
		Iterator<?> it = this.getHibernateTemplate().find("from LimitPower as lp where lp.lp_user_name='"+userName+"'").iterator();
		while(it.hasNext()){
			lp = (LimitPower) it.next();
		}
		return lp;
	}
	/**
	 * 修改用户权限
	 */
	@Override
	public void updLP(LimitPower limitPower) {
		this.getHibernateTemplate().update(limitPower);
	}
	/**
	 * 删除用户权限
	 */
	@Override
	public void delLP(LimitPower limitPower) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(limitPower);
	}

}
