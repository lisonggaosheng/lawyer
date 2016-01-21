package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;

public interface LawyerSourceService {
	public Court DaYinCourt(String casecode) throws Exception;
	public List seniorSelect(final int currentPage,final String showNote, final int pageSize,
			final String... params) throws Exception;
	
	public List excludeSeniorSelect(final int currentPage,final String showNote, final int pageSize,List exclude,
			final String... params) throws Exception;

	public String excludeSeniorSelectPageSize(final int pageSize,List exclude,String showNote,
			final String... params) throws Exception;
	
	public String seniorSelectPageSize(final int pageSize,String showNote,
			final String... params) throws Exception;

	public List seniorSelectSourceByCourt(Court court) throws Exception;

	public List seniorSelectSourceByExecuteBusiness(
			Executebusiness executeBusiness) throws Exception;

	public List seniorSelectSourceByApplierinfo(
			Applierinfo applierinfo) throws Exception;

	public List seniorSelectSourceByApplierinfoOnself(
			ApplierinfoOnself applierinfoOnself) throws Exception;

	public List seniorSelectSourceByContactTel(ContactTel contactTel)
			throws Exception;

	public List seniorSelectSourceByContractSign(ContractSign contractSign)
			throws Exception;

	public List seniorSelectSourceByContactMail(ContactMail contactMail)
			throws Exception;

	public List seniorSelectSourceByContactExpress(ContactExpress contactExpress)
			throws Exception;

	public List seniorSelectSource(String cond) throws Exception;
}
