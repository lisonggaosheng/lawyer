package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ContactTelDao;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactTelService;

public class ContactTelServiceImpl implements ContactTelService {

	private ContactTelDao contactTelDao;
	public ContactTelDao getContactTelDao() {
		return contactTelDao;
	}
	public void setContactTelDao(ContactTelDao contactTelDao) {
		this.contactTelDao = contactTelDao;
	}

	/**
	 * 添加   与申请执行人联系信息（电话联系）
	 */
	public void insertContactTel(ContactTel contactTel) throws Exception {
		contactTelDao.insertContactTel(contactTel);
	}

	/**
	 * 申请权限，查询有无对象, 与申请执行人联系信息（电话联系）
	 */
	public ContactTel selectContactTel(ContactTel contactTel, Users users)
			throws Exception {
		return contactTelDao.selectContactTel(contactTel, users);
	}

	/**
	 * 查询   与申请执行人联系信息（电话联系）
	 */
	public List selectContactTel(ContactTel contactTel) throws Exception {
		return contactTelDao.selectContactTel(contactTel);
	}

	/**
	 * 修改   与申请执行人联系信息（电话联系）
	 */
	public void updateContactTel(ContactTel contactTel) throws Exception {
		contactTelDao.updateContactTel(contactTel);
	}

	/**
	 * 删除   与申请执行人联系信息（电话联系）
	 */
	public void deleteContactTel(ContactTel contactTel) throws Exception {
		contactTelDao.deleteContactTel(contactTel);
	}
	@Override
	public ContactTel showConTel(String casecodeself) throws Exception {
		return contactTelDao.showConTel(casecodeself);
	}
}
