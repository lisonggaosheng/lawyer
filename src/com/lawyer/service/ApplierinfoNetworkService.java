package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.Users;

public interface ApplierinfoNetworkService {

	public void insertAppnet(ApplierinfoNetwork applierinfoNetwork) throws Exception;//添加申请执行人企业信息（网络信息）——何静
	public ApplierinfoNetwork selectAppnet(ApplierinfoNetwork applierinfoNetwork,Users users)throws Exception;//申请权限，查询有无对象——何静
	public List selectAppnet(ApplierinfoNetwork applierinfoNetwork)throws Exception;//查询申请执行人企业信息（网络信息）——何静
	public void updateAppnet(ApplierinfoNetwork applierinfoNetwork)throws Exception;//修改案源信息（申请执行人企业信息——网络信息） ——何静
	public void insertAppNets(Users user) throws Exception;//案源批处理申请执行人企业信息（网络信息）——郭志鹏
	public void insertAppnetOne(ApplierinfoNetwork applierinfoNetwork )throws Exception;
	public void deleteAppnet(ApplierinfoNetwork applierinfoNetwork)throws Exception;
}
