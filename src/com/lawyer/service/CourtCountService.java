package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Tongji;
import com.lawyer.pojo.Users;

public interface CourtCountService {
	public int countCourtByTime(String sdate, String edate) throws Exception; //获取时间段内的案源数量---郭志鹏
	public long countCourt() throws Exception; //获取人工录入的案源数量---郭志鹏
	public List<Tongji> countCourtUserOne() throws Exception; //获取人工录入第一步的录入者---郭志鹏
	public List<Tongji> countCourtUserTow() throws Exception; //获取人工录入第二步的录入者---郭志鹏
	public List<Tongji> countCourtUserThree() throws Exception; //获取人工录入第三步的录入者---郭志鹏
	public List<Tongji> countCourtUserFour() throws Exception; //获取人工录入第四步的录入者---郭志鹏
	public List<Tongji> countCourtUserOneByTime(String sdate, String edate) throws Exception; //获取时间段内人工录入第一步的录入者---郭志鹏
	public List<Tongji> countCourtUserTowByTime(String sdate, String edate) throws Exception; //获取时间段内人工录入第二步的录入者---郭志鹏
	public List<Tongji> countCourtUserThreeByTime(String sdate, String edate) throws Exception; //获取时间段内人工录入第三步的录入者---郭志鹏
	public List<Tongji> countCourtUserFourByTime(String sdate, String edate) throws Exception; //获取时间段内人工录入第四步的录入者---郭志鹏

}
