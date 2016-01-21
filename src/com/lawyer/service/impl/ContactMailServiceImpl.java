package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ContactMailDao;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactMailService;

public class ContactMailServiceImpl implements ContactMailService {

	private ContactMailDao contactMailDao;
	
	public ContactMailDao getContactMailDao() {
		return contactMailDao;
	}

	public void setContactMailDao(ContactMailDao contactMailDao) {
		this.contactMailDao = contactMailDao;
	}

	/**
	 * 与申请执行人联系信息（电子邮件）
	 */
	public void insertContactMail(ContactMail contactMail) throws Exception {
		this.contactMailDao.insertContactMail(contactMail);
	}

	/**
	 * 申请权限，查询有无对象，与申请执行人联系信息（电子邮件）
	 */
	public ContactMail selectContactMail(ContactMail contactMail, Users users)
			throws Exception {	
		ContactMail conMa = null;
		return conMa;
	}

	/**
	 * 查询与申请执行人联系信息（电子邮件）
	 */
	@SuppressWarnings("unchecked")
	public List selectContactMail(ContactMail contactMail) throws Exception {
		return this.contactMailDao.selectContactMail(contactMail);
	}

	/**
	 * 修改案源信息（与申请执行人联系信息——电子邮件）
	 */
	public void updateContactMail(ContactMail contactMail) throws Exception {
		
	}
	
	/**
	 * 删除案源信息（与申请执行人联系信息——电子邮件）
	 */
	public void deleteContactMail(ContactMail contactMail) throws Exception {
		
	}

}
