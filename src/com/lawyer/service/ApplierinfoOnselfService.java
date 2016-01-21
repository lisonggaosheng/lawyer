package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.Users;

public interface ApplierinfoOnselfService {

	public void insertAppOnself(ApplierinfoOnself applierinfoOnself) throws Exception;//添加申请执行人企业信息（自有信息）——何静
	public ApplierinfoOnself selectAppOnself(ApplierinfoOnself applierinfoOnself,Users users)throws Exception;//申请权限，查询有无对象——何静
	public List selectAppOnself(ApplierinfoOnself applierinfoOnself)throws Exception;//查询申请执行人企业信息（自有信息）——何静
	public void updateAppOnself(ApplierinfoOnself applierinfoOnself)throws Exception;//修改案源信息（申请执行人企业信息——自有信息） ——何静
	public void deleteAppOnself(ApplierinfoOnself applierinfoOnself)throws Exception;//删除案源信息（申请执行人企业信息——自有信息） ——何静
}
