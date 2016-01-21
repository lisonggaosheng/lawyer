package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Users;

public interface ContractSignDao {

	public void insertContractSign(ContractSign contractSign) throws Exception;//与申请执行人联系信息（签约情况）——何静
	public ContractSign selectContractSign(ContractSign contractSign,Users users)throws Exception;//申请权限，查询有无对象——何静
	public List selectContractSign(ContractSign contractSign)throws Exception;//查询与申请执行人联系信息（签约情况）——何静
	public void updateContractSign(ContractSign contractSign)throws Exception;//修改案源信息（与申请执行人联系信息——签约情况） ——何静
	public void deleteContractSign(ContractSign contractSign)throws Exception;//删除案源信息（与申请执行人联系信息——签约情况） ——何静
}
