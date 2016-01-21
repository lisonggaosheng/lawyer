package com.lawyer.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lawyer.dao.CourtDao;
import com.lawyer.dao.ExecutebusinessDao;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;
import com.lawyer.service.ExecutebusinessService;

@Entity
public class ExecutebusinessServiceImpl implements ExecutebusinessService  {
	private ExecutebusinessDao executebusDao;
	private CourtDao courtDao;
	
	public ExecutebusinessDao getExecutebusDao() {
		return executebusDao;
	}
	public void setExecutebusDao(ExecutebusinessDao executebusDao) {
		this.executebusDao = executebusDao;
	}
	public CourtDao getCourtDao() {
		return courtDao;
	}
	public void setCourtDao(CourtDao courtDao) {
		this.courtDao = courtDao;
	}
	/**
	 * 添加第二步
	 */
	public void insertStep2(Executebusiness executebus) throws Exception 	{
		this.executebusDao.insertStep2(executebus);
	}
	@Override
	public void insertMoreExecutes(Users user) throws Exception {
		this.executebusDao.insertMoreExecutes(user);
		
	}
	@Override
	public List<Executebusiness> selExecutebusiness(Executebusiness executebus)
			throws Exception {
		return 	this.executebusDao.selExecutebusiness(executebus);
	}
	@Override
	public void insertEb(Executebusiness executebus) throws Exception {
		this.executebusDao.insertEb(executebus);
		
	}
	@Override
	public void Executebusiness(List<com.lawyer.pojo.Executebusiness> list) {
		this.executebusDao.Executebusiness(list);
		
	}
	@Override
	public void excelInsertExecutebusiness(
			List<Executebusiness> dataList) throws Exception {
		HttpSession session=ServletActionContext.getRequest().getSession();
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Users admin=(Users) session.getAttribute("admin");	
		
		for (int i = 0; i < dataList.size(); i++) {
			Executebusiness exbus = dataList.get(i);
			List<Court> courts = courtDao.selectCourtsByName(exbus.getEName());
			
			for (int n = 0; n < courts.size(); n++) {
				Court court = courts.get(n);
				Executebusiness ecutebusiness = new Executebusiness();
				ecutebusiness.setEName(exbus.getEName());
				ecutebusiness.setEAddress(exbus.getEAddress());
				ecutebusiness.setEStatus(exbus.getEStatus());
				ecutebusiness.setECCasecodeself(court.getCasecodeself());
				ecutebusiness.setESavetime(df1.format(new Date())); 
				ecutebusiness.setUsers(admin);
				
				if( Integer.parseInt(court.getExecutestep()) >1 ){
					List<Executebusiness> exbusinessOlds = executebusDao.selExecutebusiness(ecutebusiness);
					if(exbusinessOlds.size()<=0){
						this.executebusDao.insertStep2(ecutebusiness);
					}else{
						for (int j = 0; j < exbusinessOlds.size(); j++) {
							Executebusiness exbold = exbusinessOlds.get(j);
							if(ecutebusiness.getEStatus()!=null && !ecutebusiness.getEStatus().equals("")){
								exbold.setEStatus(ecutebusiness.getEStatus());
							}
							if(ecutebusiness.getEAddress() !=null && !ecutebusiness.getEAddress().equals("")){
								exbold.setEAddress(ecutebusiness.getEAddress());
							}
							this.executebusDao.updateExecutes(exbold);
						}
					}
				}else{
					this.executebusDao.insertStep2(ecutebusiness);
				}
				
			}
		}
		
	}	
}
