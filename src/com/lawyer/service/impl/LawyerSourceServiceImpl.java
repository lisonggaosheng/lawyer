package com.lawyer.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lawyer.dao.LawyerSourceDao;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.ApplierinfoNetwork;
import com.lawyer.pojo.ApplierinfoOnself;
import com.lawyer.pojo.ContactExpress;
import com.lawyer.pojo.ContactMail;
import com.lawyer.pojo.ContactTel;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.service.LawyerSourceService;

public class LawyerSourceServiceImpl implements LawyerSourceService {
	@SuppressWarnings("unchecked")
	@Override
	public List<Court> seniorSelect(int currentPage,String showNote, int pageSize, String... params)
			throws Exception {

		List<Court> courts = new ArrayList<Court>();
		List<Object[]> objs = lawyerSource.seniorSelect(currentPage,showNote, pageSize,
				params);

		for (Object[] objects : objs) {
			if(objects!=null){
				Court court = new Court();
				if(objects[0] != null){
					court.setId(Integer.parseInt(objects[0].toString()));
				}
				if(objects[1] != null){
					court.setCaseId(objects[1].toString());
				}
				if(objects[2] != null){
					court.setPname(objects[2].toString());			
				}
				if(objects[3] != null){
					court.setExecCourtName(objects[3].toString());		
				}
				if(objects[4] != null){
					court.setCasecodeself(objects[4].toString());		
				}
				if(objects[5] != null){
					court.setCaseCreateTime(objects[5].toString());		
				}
				if(objects[6] != null){
					court.setCaseCode(objects[6].toString());		
				}
				courts.add(court);
			}
		}
		return courts;
	}

	public String seniorSelectPageSize(int pageSize,String showNote, String... params)
			throws Exception {
		
		return (Integer.parseInt(lawyerSource.seniorSelectPageSize(
				pageSize,showNote, params).toString()) - 1)/ pageSize + 1 + "";

	}

	private LawyerSourceDao lawyerSource;

	public LawyerSourceDao getLawyerSource() {
		return lawyerSource;
	}

	public void setLawyerSource(LawyerSourceDao lawyerSource) {
		this.lawyerSource = lawyerSource;
	}

	@SuppressWarnings("unchecked")
	public List seniorSelectSourceByApplierinfo(
			Applierinfo applierinfo) throws Exception {
		return this.lawyerSource
				.seniorSelectSourceByApplierinfo(applierinfo);
	}

	public List seniorSelectSourceByApplierinfoOnself(
			ApplierinfoOnself applierinfoOnself) throws Exception {
		return this.lawyerSource
				.seniorSelectSourceByApplierinfoOnself(applierinfoOnself);
	}

	public List seniorSelectSourceByContactTel(ContactTel contactTel)
			throws Exception {
		return this.lawyerSource.seniorSelectSourceByContactTel(contactTel);
	}

	public List seniorSelectSourceByContractSign(ContractSign contractSign)
			throws Exception {
		return this.lawyerSource.seniorSelectSourceByContractSign(contractSign);
	}

	public List seniorSelectSourceByCourt(Court court) throws Exception {
		return this.lawyerSource.seniorSelectSourceByCourt(court);
	}

	public List seniorSelectSourceByExecuteBusiness(
			Executebusiness executeBusiness) throws Exception {
		return this.lawyerSource
				.seniorSelectSourceByExecuteBusiness(executeBusiness);
	}

	public List seniorSelectSourceByContactExpress(ContactExpress contactExpress)
			throws Exception {
		return this.lawyerSource
				.seniorSelectSourceByContactExpress(contactExpress);
	}

	public List seniorSelectSourceByContactMail(ContactMail contactMail)
			throws Exception {
		return this.lawyerSource.seniorSelectSourceByContactMail(contactMail);
	}

	public List<?> seniorSelectSource(String cond) throws Exception {

		return this.lawyerSource.seniorSelectSource(cond);
	}

	@Override
	public Court DaYinCourt(String casecode) throws Exception {
		return this.lawyerSource.DaYinCourt(casecode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Court> excludeSeniorSelect(int currentPage,String showNote, int pageSize,List exclude,
			String... params) throws Exception {
		List<Court> courts = new ArrayList<Court>();
		List<Object[]> objs = lawyerSource.excludeSeniorSelect(currentPage,showNote, pageSize,exclude,
				params);

		for (Object[] objects : objs) {
			courts.add(new Court(Integer.parseInt(objects[0].toString()),
					objects[1].toString(), objects[2].toString(), objects[3]
							.toString(), objects[4].toString(), objects[5]
							.toString(), objects[6].toString()));
		}

		return courts;
	}

	@Override
	public String excludeSeniorSelectPageSize(int pageSize,List exclude,String showNote, String... params)
			throws Exception {
		return (Integer.parseInt(lawyerSource.excludeSeniorSelectPageSize(
				pageSize,exclude,showNote, params).toString()) - 1)/ pageSize + 1 + "";
	}

}
