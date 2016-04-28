package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContactTalk;
import com.lawyer.pojo.Users;

public interface ContactTalkDao {

	public void insertContactTalk(ContactTalk contactTalk) throws Exception;//添加   与申请执行人联系信息（登门拜访）——何静
	public ContactTalk selectContactTalk(ContactTalk contactTalk,Users users)throws Exception;//申请权限，查询有无对象,与申请执行人联系信息（登门拜访）——何静
	public List<ContactTalk> selectContactTalk(ContactTalk contactTalk)throws Exception;//查询与申请执行人联系信息（登门拜访）——何静
	public void updateContactTalk(ContactTalk contactTalk)throws Exception;//修改案源信息（与申请执行人联系信息——登门拜访） ——何静
	public void deleteContactTalk(ContactTalk contactTalk)throws Exception;//删除案源信息（与申请执行人联系信息——登门拜访） ——何静

	/**
	 * 添加约谈信息时显示之前的信息
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactTalk showConTalk(String casecodeself) throws Exception;
}
