package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContactMail;

public interface ContactMailDao {

	public void insertContactMail(ContactMail contactMail) throws Exception;//与申请执行人联系信息（电子邮件）——何静
	@SuppressWarnings("rawtypes")
	public List selectContactMail(ContactMail contactMail)throws Exception;//查询与申请执行人联系信息（电子邮件）——何静
	public void updateContactMail(ContactMail contactMail)throws Exception;//修改案源信息（与申请执行人联系信息——电子邮件） ——何静
	public void deleteContactMail(ContactMail contactMail)throws Exception;//删除案源信息（与申请执行人联系信息——电子邮件） ——何静

	/**
	 * 添加邮寄信息时显示之前的信息
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactMail showConMail(String casecodeself) throws Exception;
}
