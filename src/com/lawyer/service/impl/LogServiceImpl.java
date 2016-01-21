package com.lawyer.service.impl;

import java.util.Date;
import java.util.List;

import com.lawyer.dao.LogDao;
import com.lawyer.pojo.Log;
import com.lawyer.pojo.Users;
import com.lawyer.service.LogService;

public class LogServiceImpl implements LogService{

	//:封装的Log对象的Dao接口
	private LogDao logDao;
	
	public LogDao getLogDao() {
		return logDao;
	}

	public void setLogDao(LogDao logDao) {
		this.logDao = logDao;
	}

	/**
	 * 获得当前系统时间方法
	 * 刘腾升
	 * */
	public String getDataTime() throws Exception {
		return logDao.getDataTime();
	}
	/**
	 * 所有的操作，记录入日志表（包括登陆，退出）
	 * 刘腾升
	 * */
	public void insert(Log log) throws Exception {
		logDao.insert(log);
	}
	/**
	 * 通过用户名迷糊查询用户日志记录
	 * 刘腾升
	 * */
	public List selectUsersName(Users users) throws Exception {
		return logDao.selectUsersName(users);
	}
	/**
	 * 通过用户名迷糊查询管理员日志记录
	 * 刘腾升
	 * */
	public List selectUsersName2(Users users) throws Exception {
		return logDao.selectUsersName2(users);
	}
	
}
