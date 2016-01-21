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
}
