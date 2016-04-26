package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.Users;

public interface ApplierinfoService {
	public void insertApp(Applierinfo applierinfo) throws Exception;//添加申请执行人企业信息（注册信息）——郭志鹏
//	public Applierinfo selectAppnet(Applierinfo applierinfo,Users users)throws Exception;//申请权限，查询有无对象——郭志鹏
	public List selectApp(Applierinfo applierinfo)throws Exception;//查询申请执行人企业信息（注册信息）——郭志鹏
	public void updateApp(Applierinfo applierinfo)throws Exception;//修改案源信息（申请执行人企业信息——注册信息） ——郭志鹏
	public void insertMoreApplierinfos(Users user) throws Exception;//案源第三步申请执行人企业信息的批处理操作——郭志鹏
	public void insertAppSoft(Applierinfo applierinfo) throws Exception;
	public List<Applierinfo> selAp(Applierinfo applierinfo)throws Exception;
	
	
	/**
	 * excel导入申请人信息
     * @throws Exception 
	 */
	public void excelInsertApplierinfo(List<Applierinfo> dataList) throws Exception;
	
	/**
	 * excel导入更新申请人信息
	 * @param dataList
	 * @throws Exception
	 */
	public void excelUpdateApplierinfo(List<Applierinfo> dataList)throws Exception;
}
