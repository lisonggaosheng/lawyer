package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.Users;

public interface ContactExpressService {

	public void insertContactExpress(ContactExpress contactExpress) throws Exception;//添加   与申请执行人联系信息（快递）——何静
	public ContactExpress selectContactExpress(ContactExpress contactExpress,Users users)throws Exception;//申请权限，查询有无对象——何静
	public List selectContactExpress(ContactExpress contactExpress)throws Exception;//查询与申请执行人联系信息（快递）——何静
	public void updateContactExpress(ContactExpress contactExpress)throws Exception;//修改案源信息（与申请执行人联系信息——快递） ——何静
	public void deleteContactExpress(ContactExpress contactExpress)throws Exception;//删除案源信息（与申请执行人联系信息——快递） ——何静
}
