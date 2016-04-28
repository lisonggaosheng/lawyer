package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.ContactTalkDao;
import com.lawyer.pojo.ContactTalk;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContactTalkService;

public class ContactTalkServiceImpl implements ContactTalkService{
	
	private ContactTalkDao contactTalkDao;
	public ContactTalkDao getContactTalkDao() {
		return contactTalkDao;
	}
	public void setContactTalkDao(ContactTalkDao contactTalkDao) {
		this.contactTalkDao = contactTalkDao;
	}

	/**
	 * 添加   与申请执行人联系信息（登门拜访）
	 */
	public void insertContactTalk(ContactTalk contactSee) throws Exception {
		contactTalkDao.insertContactTalk(contactSee);
	}

	/**
	 * 申请权限，查询有无对象,与申请执行人联系信息（登门拜访）
	 */
	public ContactTalk selectContactTalk(ContactTalk contactSee, Users users)
			throws Exception {
		return contactTalkDao.selectContactTalk(contactSee, users);
	}

	/**
	 * 查询与申请执行人联系信息（登门拜访）
	 */
	public List<ContactTalk> selectContactTalk(ContactTalk contactSee) throws Exception {
		return contactTalkDao.selectContactTalk(contactSee);
	}

	/**
	 * 修改案源信息（与申请执行人联系信息——登门拜访）
	 */
	public void updateContactTalk(ContactTalk contactSee) throws Exception {
		contactTalkDao.updateContactTalk(contactSee);
	}

	/**
	 * 删除案源信息（与申请执行人联系信息——登门拜访）
	 */
	public void deleteContactTalk(ContactTalk contactSee) throws Exception {
		contactTalkDao.deleteContactTalk(contactSee);
	}
	@Override
	public ContactTalk showConTalk(String casecodeself) throws Exception {
		return contactTalkDao.showConTalk(casecodeself);
	}
}
