package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Court;
import com.lawyer.pojo.Tongji;
import com.lawyer.pojo.Users;

public interface CourtCountDao {
	public int countCourtByTime(String sdate, String edate) throws Exception; //获取时间段内的案源数量---郭志鹏
	public long countCourt() throws Exception; //获取人工录入的案源数量---郭志鹏
	public List<Tongji> countCourtUserOne() throws Exception; //获取人工录入第一步的录入者---郭志鹏
	public List<Tongji> countCourtUserTow() throws Exception; //获取人工录入第二步的录入者---郭志鹏
	public List<Tongji> countCourtUserThree() throws Exception; //获取人工录入第三步的录入者---郭志鹏
	public List<Tongji> countCourtUserFour() throws Exception; //获取人工录入第四步的录入者---郭志鹏
	public List<Tongji> countCourtUserOneByTime(String sdate, String edate) throws Exception; //获取时间段内的人工录入第一步的录入者---郭志鹏
	public List<Tongji> countCourtUserTowByTime(String sdate, String edate) throws Exception; //获取时间段内的人工录入第一步的录入者---郭志鹏
	public List<Tongji> countCourtUserThreeByTime(String sdate, String edate) throws Exception; //获取时间段内的人工录入第一步的录入者---郭志鹏
	public List<Tongji> countCourtUserFourByTime(String sdate, String edate) throws Exception; //获取时间段内的人工录入第一步的录入者---郭志鹏
	long countExeBussess() throws Exception;//获取被执行人企业信息数量---郭志鹏
	long countApp() throws Exception;//获取申请执行人企业信息数量---郭志鹏
	long countAppNet() throws Exception;//获取申请执行人企业网络信息数量---郭志鹏
	long countAppOnselt() throws Exception;//获取申请执行人企业自有信息数量---郭志鹏
	long countMail() throws Exception;//获取联系人邮箱信息数量---郭志鹏
	long countTel() throws Exception;//获取联系人电话信息数量---郭志鹏
	long countFax() throws Exception;//获取联系人传真信息数量---郭志鹏
	long countEx() throws Exception;//获取联系人快递信息数量---郭志鹏
	long countSee() throws Exception;//获取联系人拜访信息数量---郭志鹏
	long countSign() throws Exception;//获取联系人签约信息数量---郭志鹏

 
}
