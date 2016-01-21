package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ContactSeeDao;
import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactSeeService;

public class ContactSeeServiceImpl implements ContactSeeService{
	
	private ContactSeeDao contactSeeDao;
	public ContactSeeDao getContactSeeDao() {
		return contactSeeDao;
	}
	public void setContactSeeDao(ContactSeeDao contactSeeDao) {
		this.contactSeeDao = contactSeeDao;
	}

	/**
	 * 添加   与申请执行人联系信息（登门拜访）
	 */
	public void insertContactSee(ContactSee contactSee) throws Exception {
		contactSeeDao.insertContactSee(contactSee);
	}

	/**
	 * 申请权限，查询有无对象,与申请执行人联系信息（登门拜访）
	 */
	public ContactSee selectContactSee(ContactSee contactSee, Users users)
			throws Exception {
		return contactSeeDao.selectContactSee(contactSee, users);
	}

	/**
	 * 查询与申请执行人联系信息（登门拜访）
	 */
	@SuppressWarnings("unchecked")
	public List selectContactSee(ContactSee contactSee) throws Exception {
		return contactSeeDao.selectContactSee(contactSee);
	}

	/**
	 * 修改案源信息（与申请执行人联系信息——登门拜访）
	 */
	public void updateContactSee(ContactSee contactSee) throws Exception {
		contactSeeDao.updateContactSee(contactSee);
	}

	/**
	 * 删除案源信息（与申请执行人联系信息——登门拜访）
	 */
	public void deleteContactSee(ContactSee contactSee) throws Exception {
		contactSeeDao.deleteContactSee(contactSee);
	}
}
