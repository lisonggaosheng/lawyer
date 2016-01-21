package com.lawyer.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.lawyer.pojo.CourtCount;
import com.lawyer.pojo.Tongji;
import com.lawyer.service.CourtCountService;
import com.opensymphony.xwork2.ActionSupport;

public class CourtCountAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String startDate;
	private String endDate;
	private CourtCountService ccs = null;
	private String total;
	private List<Tongji> tjlist1 = null;
	private List<Tongji> tjlist2 = null;
	private List<Tongji> tjlist3 = null;
	private List<Tongji> tjlist4 = null;
	private CourtCount cc = new CourtCount();

	
	public List<Tongji> getTjlist1() {
		return tjlist1;
	}
	public void setTjlist1(List<Tongji> tjlist1) {
		this.tjlist1 = tjlist1;
	}
	public List<Tongji> getTjlist2() {
		return tjlist2;
	}
	public void setTjlist2(List<Tongji> tjlist2) {
		this.tjlist2 = tjlist2;
	}
	public List<Tongji> getTjlist3() {
		return tjlist3;
	}
	public void setTjlist3(List<Tongji> tjlist3) {
		this.tjlist3 = tjlist3;
	}
	public List<Tongji> getTjlist4() {
		return tjlist4;
	}
	public void setTjlist4(List<Tongji> tjlist4) {
		this.tjlist4 = tjlist4;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public CourtCount getCc() {
		return cc;
	}

	public void setCc(CourtCount cc) {
		this.cc = cc;
	}
	public CourtCountService getCcs() {
		return ccs;
	}

	public void setCcs(CourtCountService ccs) {
		this.ccs = ccs;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String count() {
		try {
			long total1 = ccs.countCourt();
			total = total1 + "";
			tjlist1 = ccs.countCourtUserOne();
			tjlist2 = ccs.countCourtUserTow();
			tjlist3 = ccs.countCourtUserThree();
			tjlist4 = ccs.countCourtUserFour();
			
			return SUCCESS;
		} catch (Exception e) {
			return ERROR;
		}
	}
	

	public String countByTime() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			if(("").equals(startDate)){
				startDate = "1900年01月01日";
			}
			if(("").equals(endDate)){
				endDate = "2100年12月30日";
			}
			 Date resultDate = simpleDateFormat.parse(startDate);
			 startDate  = sdf.format(resultDate);
			 resultDate = simpleDateFormat.parse(endDate);
			 endDate  = sdf.format(resultDate);
			int total1 = ccs.countCourtByTime(startDate, endDate);
			total = total1 + "";
			tjlist1 = ccs.countCourtUserOneByTime(startDate, endDate);
			tjlist2 = ccs.countCourtUserTowByTime(startDate, endDate);
			tjlist3 = ccs.countCourtUserThreeByTime(startDate, endDate);
			tjlist4 = ccs.countCourtUserFourByTime(startDate, endDate);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}


}
