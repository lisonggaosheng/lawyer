package com.lawyer.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lawyer.dao.ApplierinfoDao;
import com.lawyer.dao.CourtDao;
import com.lawyer.pojo.Applierinfo;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Users;
import com.lawyer.service.ApplierinfoService;

public class ApplierinfoServiceImpl implements ApplierinfoService {
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
	
	@Override
	public void insertApp(Applierinfo applierinfo) throws Exception {
		appdao.insertApp(applierinfo);
	}

	@Override
	public List selectApp(Applierinfo applierinfo) throws Exception {
		return null;
	}

	@Override
	public void updateApp(Applierinfo applierinfo) throws Exception {
		this.appdao.updateAppMark(applierinfo);

	}

	/**
	 * 案源第三步申请执行人企业信息的批处理操作——郭志鹏
	 */
	public void insertMoreApplierinfos(Users user) throws Exception {
		this.appdao.insertMoreApplierinfos(user);
		
	}

	@Override
	public void insertAppSoft(Applierinfo applierinfo) throws Exception {
		this.appdao.insertAppSoft(applierinfo);
		
	}

	@Override
	public List<Applierinfo> selAp(Applierinfo applierinfo) throws Exception {
		// TODO Auto-generated method stub
		return this.appdao.selAp(applierinfo);
	}

	@Override
	public void excelInsertApplierinfo(List<Applierinfo> dataList)
			throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Users admin=(Users) session.getAttribute("admin");	
		
		for (int i = 0; i < dataList.size(); i++) {
			Applierinfo applierinfo = dataList.get(i);
			
			List<Court> courts = courtDao.selectCourtsByNameCasecode(applierinfo.getPname(),applierinfo.getCasecode());
			
			for (int n = 0; n < courts.size(); n++) {
				Court court = courts.get(n);
				applierinfo.setAppCCasecodeself(court.getCasecodeself());
				applierinfo.setAppSavetime(df1.format(new Date())); 
				applierinfo.setUsers(admin);
				if( Integer.parseInt(court.getExecutestep()) ==2 ){
					this.appdao.insertApp(applierinfo);
				}
				
			}
		}
	}

	@Override
	public void excelUpdateApplierinfo(List<Applierinfo> dataList) throws Exception {
		
		for (int i = 0; i < dataList.size(); i++) {
			Applierinfo applierinfo = dataList.get(i);
			this.appdao.updateAppStatus(applierinfo);
		}
	}


}
