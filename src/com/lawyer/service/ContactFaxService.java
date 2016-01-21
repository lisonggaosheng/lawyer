package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactFax;
import com.lawyer.pojo.Users;

public interface ContactFaxService {

	public void insertContactFax(ContactFax contactFax) throws Exception;//添加   与申请执行人联系信息（传真）——何静
	public ContactFax selectContactFax(ContactFax contactFax,Users users)throws Exception;//申请权限，查询有无对象,与申请执行人联系信息（传真）——何静
	public List selectContactFax(ContactFax contactFax)throws Exception;//查询与申请执行人联系信息（传真）——何静
	public void updateContactFax(ContactFax contactFax)throws Exception;//修改案源信息（与申请执行人联系信息——传真） ——何静
	public void deleteContactFax(ContactFax contactFax)throws Exception;//删除案源信息（与申请执行人联系信息——传真） ——何静
}
