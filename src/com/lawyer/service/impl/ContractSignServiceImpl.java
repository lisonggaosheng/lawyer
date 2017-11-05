package com.lawyer.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ApplierinfoDao;
import com.lawyer.dao.ContractSignDao;
import com.lawyer.dao.CourtDao;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Users;
import com.lawyer.service.ContractSignService;

public class ContractSignServiceImpl implements ContractSignService {
	private ContractSignDao csd = null;
	private ApplierinfoDao appdao = null;
	private CourtDao courtDao;
	public ApplierinfoDao getAppdao() {
		return appdao;
	}

	public void setAppdao(ApplierinfoDao appdao) {
		this.appdao = appdao;
	}
	public CourtDao getCourtDao() {
		return courtDao;
	}
	public void setCourtDao(CourtDao courtDao) {
		this.courtDao = courtDao;
	}
	public ContractSignDao getCsd() {
		return csd;
	}

	public void setCsd(ContractSignDao csd) {
		this.csd = csd;
	}

	/**
	 * 新增案源签约
	 */
	public void insertContractSign(ContractSign contractSign) throws Exception {
		Court court = courtDao.selCourtByCasecodeself(contractSign.getCsCasecodeself());
		if(court!=null){
			contractSign.setDebtorName(court.getPname());
		}
		Applierinfo applierinfo = appdao.selectByCasecodeself(contractSign.getCsCasecodeself());
		if(applierinfo!=null){
			contractSign.setClaimName(applierinfo.getAppName());
		}
		this.csd.insertContractSign(contractSign);
	}

	/**
	 * ����Ȩ�ޣ���ѯ���޶���,������ִ������ϵ��Ϣ��ǩԼ�����
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
	 * ��ѯ  ������ִ������ϵ��Ϣ��ǩԼ�����
	 */
	public List selectContractSign(ContractSign contractSign) throws Exception {
	//	List list = this.getHibernateTemplate().find("from ContractSign");
		return null;
	}

	/**
	 * �޸�  ������ִ������ϵ��Ϣ��ǩԼ�����
	 */
	public void updateContractSign(ContractSign contractSign) throws Exception {
	//	this.getHibernateTemplate().load(ContractSign.class, contractSign.getCsId());
	}

	/**
	 * ɾ��  ������ִ������ϵ��Ϣ��ǩԼ�����
	 */
	public void deleteContractSign(ContractSign contractSign) throws Exception {
	//	this.getHibernateTemplate().delete(contractSign);
	}
}
