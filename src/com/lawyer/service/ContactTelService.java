package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.Users;

public interface ContactTelService {

	public void insertContactTel(ContactTel contactTel) throws Exception;//与申请执行人联系信息（电话联系）——何静
	public ContactTel selectContactTel(ContactTel contactTel,Users users)throws Exception;//申请权限，查询有无对象——何静
	public List selectContactTel(ContactTel contactTel)throws Exception;//查询与申请执行人联系信息（电话联系）——何静
	public void updateContactTel(ContactTel contactTel)throws Exception;//修改案源信息（与申请执行人联系信息——电话联系） ——何静
	public void deleteContactTel(ContactTel contactTel)throws Exception;//删除案源信息（与申请执行人联系信息——电话联系） ——何静

	/**
	 * 添加电话联系信息时显示之前的信息
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactTel showConTel(String casecodeself) throws Exception;
	
}
