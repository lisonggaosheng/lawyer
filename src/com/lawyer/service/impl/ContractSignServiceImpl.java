package com.lawyer.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContractSignDao;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContractSignService;

public class ContractSignServiceImpl implements ContractSignService {
	private ContractSignDao csd = null;
	public ContractSignDao getCsd() {
		return csd;
	}

	public void setCsd(ContractSignDao csd) {
		this.csd = csd;
	}

	/**
	 * 与申请执行人联系信息（签约情况）
	 */
	public void insertContractSign(ContractSign contractSign) throws Exception {
		this.csd.insertContractSign(contractSign);
	}

	/**
	 * 申请权限，查询有无对象,与申请执行人联系信息（签约情况）
	 */
	public ContractSign selectContractSign(ContractSign contractSign,
			Users users) throws Exception {
		String str1="";
		String str2="";
		ContractSign cs = null;
		/*
		Iterator<ContractSign> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			cs = it.next();
		}*/
		return cs;
	}

	/**
	 * 查询  与申请执行人联系信息（签约情况）
	 */
	public List selectContractSign(ContractSign contractSign) throws Exception {
	//	List list = this.getHibernateTemplate().find("from ContractSign");
		return null;
	}

	/**
	 * 修改  与申请执行人联系信息（签约情况）
	 */
	public void updateContractSign(ContractSign contractSign) throws Exception {
	//	this.getHibernateTemplate().load(ContractSign.class, contractSign.getCsId());
	}

	/**
	 * 删除  与申请执行人联系信息（签约情况）
	 */
	public void deleteContractSign(ContractSign contractSign) throws Exception {
	//	this.getHibernateTemplate().delete(contractSign);
	}
}
