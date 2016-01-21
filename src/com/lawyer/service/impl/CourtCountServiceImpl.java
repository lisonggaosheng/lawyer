package com.lawyer.service.impl;


import java.util.List;

import com.lawyer.dao.CourtCountDao;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.Tongji;
import com.lawyer.pojo.Users;
import com.lawyer.service.CourtCountService;

public class CourtCountServiceImpl implements CourtCountService {
	private CourtCountDao ccd = null;
	
	public CourtCountDao getCcd() {
		return ccd;
	}

	public void setCcd(CourtCountDao ccd) {
		this.ccd = ccd;
	}

	@Override
	public int countCourtByTime(String sdate, String edate) throws Exception {
		
		return ccd.countCourtByTime(sdate, edate);
	}

	@Override
	public long countCourt() throws Exception {
		// TODO Auto-generated method stub
		return ccd.countCourt();
	}

	@SuppressWarnings("unchecked")
	public List<Tongji> countCourtUserOne() throws Exception {
		// TODO Auto-generated method stub
		return ccd.countCourtUserOne();
	}

	@Override
	public List<Tongji> countCourtUserFour() throws Exception {
		// TODO Auto-generated method stub
		return ccd.countCourtUserFour();
	}

	@Override
	public List<Tongji> countCourtUserThree() throws Exception {
		// TODO Auto-generated method stub
		return ccd.countCourtUserThree();
	}

	@Override
	public List<Tongji> countCourtUserTow() throws Exception {
		
		return ccd.countCourtUserTow();
	}

	@Override
	public List<Tongji> countCourtUserFourByTime(String sdate, String edate)
			throws Exception {
		return ccd.countCourtUserFourByTime(sdate, edate);
	}

	@Override
	public List<Tongji> countCourtUserOneByTime(String sdate, String edate)
			throws Exception {
		return ccd.countCourtUserOneByTime(sdate, edate);
	}

	@Override
	public List<Tongji> countCourtUserThreeByTime(String sdate, String edate)
			throws Exception {
		return ccd.countCourtUserThreeByTime(sdate, edate);
	}

	@Override
	public List<Tongji> countCourtUserTowByTime(String sdate, String edate)
			throws Exception {
		return ccd.countCourtUserTowByTime(sdate, edate);
	}

}
