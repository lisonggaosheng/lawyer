package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ContactTalk;
import com.lawyer.pojo.Users;

public interface ContactTalkService {

	public void insertContactTalk(ContactTalk contactTalk) throws Exception;
	public ContactTalk selectContactTalk(ContactTalk contactTalk,Users users)throws Exception;
	public List<ContactTalk> selectContactTalk(ContactTalk contactTalk)throws Exception;
	public void updateContactTalk(ContactTalk contactTalk)throws Exception;
	public void deleteContactTalk(ContactTalk contactTalk)throws Exception;
	
	/**
	 * 添加约谈信息时显示之前的信息
	 * @param casecodeself
	 * @return
	 * @throws Exception
	 */
	public ContactTalk showConTalk(String casecodeself) throws Exception;
	
}
