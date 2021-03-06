package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContactSee;
import com.lawyer.pojo.Users;

public interface ContactSeeDao {

	public void insertContactSee(ContactSee contactSee) throws Exception;//添加   与申请执行人联系信息（登门拜访）——何静
	public ContactSee selectContactSee(ContactSee contactSee,Users users)throws Exception;//申请权限，查询有无对象,与申请执行人联系信息（登门拜访）——何静
	public List selectContactSee(ContactSee contactSee)throws Exception;//查询与申请执行人联系信息（登门拜访）——何静
	public void updateContactSee(ContactSee contactSee)throws Exception;//修改案源信息（与申请执行人联系信息——登门拜访） ——何静
	public void deleteContactSee(ContactSee contactSee)throws Exception;//删除案源信息（与申请执行人联系信息——登门拜访） ——何静

	/**
	 * 添加登门拜访信息时显示之前的信息
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactSee showConSee(String casecodeself) throws Exception;
	
}
