package com.lawyer.dao;

import java.util.Date;
import java.util.List;

import com.lawyer.pojo.Log;
import com.lawyer.pojo.Users;

public interface LogDao {
	/**
	 * 获得当前系统时间方法
	 * 刘腾升
	 * */
	public String getDataTime()throws Exception;
	/**
	 * 所有的操作，记录入日志表（包括登陆，退出）
	 * 刘腾升
	 * */
	public void insert(Log log)throws Exception;
	/**
	 * 通过用户名迷糊查询用户日志记录
	 * 刘腾升
	 * */
	public List selectUsersName(Users users)throws Exception;
	/**
	 * 通过用户名迷糊查询管理员日志记录
	 * 刘腾升
	 * */
	public List selectUsersName2(Users users) throws Exception;
}
