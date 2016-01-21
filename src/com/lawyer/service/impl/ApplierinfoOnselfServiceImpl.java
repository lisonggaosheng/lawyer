package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ApplierinfoOnselfDao;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplierinfoOnselfService;

public class ApplierinfoOnselfServiceImpl implements ApplierinfoOnselfService {

	private ApplierinfoOnselfDao applierinfoOnselfDao;
	public ApplierinfoOnselfDao getApplierinfoOnselfDao() {
		return applierinfoOnselfDao;
	}
	public void setApplierinfoOnselfDao(ApplierinfoOnselfDao applierinfoOnselfDao) {
		this.applierinfoOnselfDao = applierinfoOnselfDao;
	}

	/**
	 * 添加申请执行人企业信息（自有信息）
	 * 
	 */
	public void insertAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		applierinfoOnselfDao.insertAppOnself(applierinfoOnself);
	}

	/**
	 * 查询申请执行人企业信息（自有信息）——申请权限，判断有无权限
	 */
	public ApplierinfoOnself selectAppOnself(
			ApplierinfoOnself applierinfoOnself, Users users) throws Exception {
		return applierinfoOnselfDao.selectAppOnself(applierinfoOnself, users);
	}

	/**
	 * 查询申请执行人企业信息（自有信息）
	 * 
	 */
	public List selectAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		return applierinfoOnselfDao.selectAppOnself(applierinfoOnself);
	}

	/**
	 * 修改申请执行人企业信息（自有信息）
	 * 
	 */
	public void updateAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		applierinfoOnselfDao.updateAppOnself(applierinfoOnself);
	}

	/**
	 * 删除申请执行人企业信息（自有信息）
	 * 
	 */
	public void deleteAppOnself(ApplierinfoOnself applierinfoOnself)
			throws Exception {
		applierinfoOnselfDao.deleteAppOnself(applierinfoOnself);
	}

	
}