package com.lawyer.service.impl;

import java.util.Iterator;
import java.util.List;

import com.lawyer.dao.ContactExpressDao;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactExpressService;

public class ContactExpressServiceImpl implements ContactExpressService {

	private ContactExpressDao contactExpressDao;
	public ContactExpressDao getContactExpressDao() {
		return contactExpressDao;
	}
	public void setContactExpressDao(ContactExpressDao contactExpressDao) {
		this.contactExpressDao = contactExpressDao;
	}

	/**
	 * 添加   与申请执行人联系信息（快递）
	 */
	public void insertContactExpress(ContactExpress contactExpress)
			throws Exception {
		contactExpressDao.insertContactExpress(contactExpress);
	}

	/**
	 * 申请权限，查询有无对象, 与申请执行人联系信息（快递）
	 */
	public ContactExpress selectContactExpress(ContactExpress contactExpress,
			Users users) throws Exception {
		return contactExpressDao.selectContactExpress(contactExpress, users);
	}

	/**
	 * 查询   与申请执行人联系信息（快递）
	 */
	public List selectContactExpress(ContactExpress contactExpress)
			throws Exception {
		return contactExpressDao.selectContactExpress(contactExpress);
	}

	/**
	 * 修改   与申请执行人联系信息（快递）
	 */
	public void updateContactExpress(ContactExpress contactExpress)
			throws Exception {
		contactExpressDao.updateContactExpress(contactExpress);
	}

	/**
	 * 删除   与申请执行人联系信息（快递）
	 */
	public void deleteContactExpress(ContactExpress contactExpress)
			throws Exception {
		contactExpressDao.deleteContactExpress(contactExpress);
	}
}
