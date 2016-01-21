package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Users;

public interface ContactMailService {
	
	public void insertContactMail(ContactMail contactMail) throws Exception;//与申请执行人联系信息（电子邮件）——何静
	public ContactMail selectContactMail(ContactMail contactMail,Users users)throws Exception;//申请权限，查询有无对象——何静
	public List selectContactMail(ContactMail contactMail)throws Exception;//查询与申请执行人联系信息（电子邮件）——何静
	public void updateContactMail(ContactMail contactMail)throws Exception;//修改案源信息（与申请执行人联系信息——电子邮件） ——何静
	public void deleteContactMail(ContactMail contactMail)throws Exception;//删除案源信息（与申请执行人联系信息——电子邮件） ——何静

}
