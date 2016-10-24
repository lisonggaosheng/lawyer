package com.lawyer.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lawyer.dao.ContractSignDao;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Users;

public class ContractSignDaoImpl extends HibernateDaoSupport implements ContractSignDao {

	public void insertContractSign(ContractSign contractSign) throws Exception {
		this.getHibernateTemplate().save(contractSign);
		String sql = "UPDATE courtinfo SET executestep='7' WHERE casecodeself = '"+contractSign.getCsCasecodeself()+"' ";
		this.getSession().createSQLQuery(sql).executeUpdate();
	}

	public ContractSign selectContractSign(ContractSign contractSign,
			Users users) throws Exception {
		String str1="";
		String str2="";
		ContractSign cs = null;
		Iterator<ContractSign> it = this.getHibernateTemplate().find("from Apply where app_uid="+users.getUId() +" and appTarget='"+str1+"' and app_content='"+str2+"'").iterator();
		while(it.hasNext()){
			cs = it.next();
		}
		return cs;
	}

	public List selectContractSign(ContractSign contractSign) throws Exception {
		List list = this.getHibernateTemplate().find("from ContractSign");
		return list;
	}

	public void updateContractSign(ContractSign contractSign) throws Exception {
		this.getHibernateTemplate().load(ContractSign.class, contractSign.getCsId());
	}

	public void deleteContractSign(ContractSign contractSign) throws Exception {
		this.getHibernateTemplate().delete(contractSign);
	}

	@Override
	public ContractSign getContractSign(String casecodeself) {
		// ǩԼ
		ContractSign contractsign = null;
		String hqlcs = "from ContractSign cs where cs.csCasecodeself='"
				+ casecodeself + "'";
		contractsign = (ContractSign) this.getHibernateTemplate().find(hqlcs)
				.iterator().next();
		
		return contractsign;
	}

}
