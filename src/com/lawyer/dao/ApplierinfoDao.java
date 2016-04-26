package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.Users;

public interface ApplierinfoDao {
	public void insertApp(Applierinfo applierinfo) throws Exception;//添加申请执行人企业信息（注册信息）——郭志鹏
//	public Applierinfo selectApp(Applierinfo applierinfo,Users users)throws Exception;//申请权限，查询有无对象——郭志鹏
	public List selectApp(Applierinfo applierinfo)throws Exception;//查询申请执行人企业信息（注册信息）——郭志鹏
	public void updateAppMark(Applierinfo applierinfo)throws Exception;//更新申请人市场标记 ——郭志鹏
	public void insertMoreApplierinfos(Users user) throws Exception;//案源第三步申请执行人企业信息的批处理操作——郭志鹏
	public void insertAppSoft(Applierinfo applierinfo) throws Exception;
	public List<Applierinfo> selAp(Applierinfo applierinfo)throws Exception;
	
	/**
	 * 更新申请人的企业状态
	 * @param applierinfo
	 * @throws Exception
	 */
	public void updateAppStatus(Applierinfo applierinfo)throws Exception;
}
