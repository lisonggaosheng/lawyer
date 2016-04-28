package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.Users;

public interface ContactExpressDao {

	public void insertContactExpress(ContactExpress contactExpress) throws Exception;//添加   与申请执行人联系信息（快递）——何静
	public ContactExpress selectContactExpress(ContactExpress contactExpress,Users users)throws Exception;//申请权限，查询有无对象——何静
	public List selectContactExpress(ContactExpress contactExpress)throws Exception;//查询与申请执行人联系信息（快递）——何静
	public void updateContactExpress(ContactExpress contactExpress)throws Exception;//修改案源信息（与申请执行人联系信息——快递） ——何静
	public void deleteContactExpress(ContactExpress contactExpress)throws Exception;//删除案源信息（与申请执行人联系信息——快递） ——何静

	/**
	 * 添加快递信息时显示之前的信息
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactExpress showConExpress(String casecodeself) throws Exception;
}
