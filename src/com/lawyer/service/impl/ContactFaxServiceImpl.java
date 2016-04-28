package com.lawyer.service.impl;

import java.util.Iterator;
import java.util.List;

import com.lawyer.dao.ContactFaxDao;
import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactFaxService;

public class ContactFaxServiceImpl implements ContactFaxService {

	private ContactFaxDao contactFaxDao;
	
	public ContactFaxDao getContactFaxDao() {
		return contactFaxDao;
	}

	public void setContactFaxDao(ContactFaxDao contactFaxDao) {
		this.contactFaxDao = contactFaxDao;
	}

	/**
	 * 添加   与申请执行人联系信息（传真）
	 */
	public void insertContactFax(ContactFax contactFax) throws Exception {
		contactFaxDao.insertContactFax(contactFax);
	}

	/**
	 * 申请权限，查询有无对象,与申请执行人联系信息（传真）
	 */
	public ContactFax selectContactFax(ContactFax contactFax, Users users)
			throws Exception {
		return contactFaxDao.selectContactFax(contactFax, users);
	}

	/**
	 * 查询   与申请执行人联系信息（传真）
	 */
	public List selectContactFax(ContactFax contactFax) throws Exception {
		return contactFaxDao.selectContactFax(contactFax);
	}

	/**
	 * 修改   与申请执行人联系信息（传真）
	 */
	public void updateContactFax(ContactFax contactFax) throws Exception {
		contactFaxDao.updateContactFax(contactFax);
	}

	/**
	 * 删除   与申请执行人联系信息（传真）
	 */
	public void deleteContactFax(ContactFax contactFax) throws Exception {
		contactFaxDao.deleteContactFax(contactFax);
	}

	@Override
	public ContactFax showConFax(String casecodeself) throws Exception {
		return contactFaxDao.showConFax(casecodeself);
	}
}
