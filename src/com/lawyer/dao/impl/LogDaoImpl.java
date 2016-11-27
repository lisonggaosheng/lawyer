package com.lawyer.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.lawyer.dao.LogDao;
import com.lawyer.pojo.Log;
import com.lawyer.pojo.Users;

public class LogDaoImpl extends HibernateDaoSupport implements LogDao{

	/**
	 * 获得当前系统时间方法
	 * 返回值为字符串的 年-月-日  时：分：秒
	 * 刘腾升
	 * */
	public String getDataTime() throws Exception {
		Date date=new Date();
		SimpleDateFormat  f=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime=f.format(date);
		return dateTime;
	}
	/**
	 * 所有的操作，记录入日志表（包括登陆，退出）
	 * 
	 * */
	public void insert(Log log) throws Exception {
		this.getHibernateTemplate().save(log);
	}
	/**
	 * 通过用户名迷糊查询普通用户日志记录
	 * 刘腾升
	 * */
	@SuppressWarnings("unchecked")
	public List selectUsersName(Users users) throws Exception {
		return this.getHibernateTemplate().find("from Log where logUrole='普通用户' and logUname like '%"+users.getUName()+"%'");
	}
	/**
	 * 通过用户名迷糊查询管理员日志记录
	 * 刘腾升
	 * */
	@SuppressWarnings("unchecked")
	public List selectUsersName2(Users users) throws Exception {
		return this.getHibernateTemplate().find("from Log where logUrole='管理员' and logUname like '%"+users.getUName()+"%'");
	}
}
