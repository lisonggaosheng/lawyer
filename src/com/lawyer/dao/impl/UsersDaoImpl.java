package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.UsersDao;
import com.lawyer.pojo.Users;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {
	/**
	 * 管理员用户登陆方法
	 */
	public Users login(Users users)throws Exception  {
		Users u = null;
		Iterator<?> it = this.getHibernateTemplate().find("from Users as u where u.UName='"+users.getUName()+"' and u.UPassword='"+users.getUPassword()+"'").iterator();
		while(it.hasNext()){
			u=(Users) it.next();
		}
		return u;
	}
	/**
	 * 管理员添加用户方法，添加完成查询所有用户信息，跳转至SHOW页面，分页显示
	 * */
	public void insert(Users users) throws Exception {
		this.getHibernateTemplate().save(users);
	}

	public Users SelectID(Users users) throws Exception {
		return (Users) this.getHibernateTemplate().get(Users.class, users.getUId());
	}

	public void update(Users users) throws Exception {
		this.getHibernateTemplate().update(users);
	}

	public List selectName(Users users) throws Exception {
		return this.getHibernateTemplate().find("from Users where UName Like '%"+users.getUName()+"%' and UName <> 'admin'");
	}
	
	public void delete(Users users) throws Exception {
		this.getHibernateTemplate().delete(users);
	}
	@Override
	public Users SelectByID(int uid) throws Exception {
		return (Users) this.getHibernateTemplate().get(Users.class, uid);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Users> selectLawyers() throws Exception {
		return this.getHibernateTemplate().find("from Users where URole='办案律师'");
	}
	
	@Override
	public List<Users> selectPensons() throws Exception {
		return this.getHibernateTemplate().find("from Users where USta like '%启用%' and length(trim(roleName))>1 ");
	}

}
