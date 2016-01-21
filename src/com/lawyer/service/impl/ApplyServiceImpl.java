package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ApplyDao;
import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplyService;

public class ApplyServiceImpl implements ApplyService{
	
	//:封装的Apply的Dao接口
	private ApplyDao applyDao;

	public ApplyDao getApplyDao() {
		return applyDao;
	}

	public void setApplyDao(ApplyDao applyDao) {
		this.applyDao = applyDao;
	}
	/**
	 *通过用户名模糊查询申请信息
	 *刘腾升
	 * */
	public List selectName(Users users) throws Exception {
		return applyDao.selectName(users);
	}
	/**
	 * 通过用户ID批准授权
	 * 刘腾升
	 * */
	public void authorize(Apply apply) throws Exception {
		applyDao.authorize(apply);
	}
	/**
	 * 通过用户ID得到授权记录
	 * 刘腾升
	 * */
	public Apply selectID(Apply apply) throws Exception {
		return applyDao.selectID(apply);
	}
	/**
	 * 通过用户ID拒绝授权
	 * 刘腾升
	 * */
	public void decline(Apply apply) throws Exception {
		applyDao.decline(apply);
	}
	/**
	 *通过用户名模糊查询申请信息2
	 *刘腾升
	 * */
	public List selectName2(Users users) throws Exception {
		return applyDao.selectName2(users);
	}
	
}
