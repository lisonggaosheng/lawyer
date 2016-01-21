package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.LawyerCourtDao;
import com.lawyer.pojo.LawyerCourt;
import com.lawyer.service.LawyerCourtService;

/**
 * @date 2013-4-13 15:57:01
 * @author 李梦翔
 *	法院的业务逻辑
 */
public class LawyerCourtServiceImpl implements LawyerCourtService{
	private LawyerCourtDao lawyerCourtDao;
	public void setLawyerCourtDao(LawyerCourtDao lawyerCourtDao) {
		this.lawyerCourtDao = lawyerCourtDao;
	}
	/**
	 * 查找所有法院信息
	 */
	@Override
	public List<?> findAllLawyerCourt() throws Exception {
		return lawyerCourtDao.selectAll();
	}
	/**
	 * 查找所有的一级法院
	 */
	@Override
	public List<LawyerCourt> findFirstLawyerCourt() throws Exception {
		// TODO Auto-generated method stub
		return lawyerCourtDao.selectFirst();
	}
	/**
	 * 根据一级法院查找对应的二级法院
	 */
	@Override
	public List<LawyerCourt> findSecondLawyerCourt(String firId)
			throws Exception {
		// TODO Auto-generated method stub
		return lawyerCourtDao.selectSecond(firId);
	}
	/**
	 * 根据二级法院查找对应的三级法院
	 */
	@Override
	public List<LawyerCourt> findThirdLawyerCourt(String secId)
			throws Exception {
		// TODO Auto-generated method stub
		return lawyerCourtDao.selectThird(secId);
	}
	/**
	 * 根据id查找法院
	 */
	public LawyerCourt selectCourtByID(int courtid) throws Exception {
		// TODO Auto-generated method stub
		return lawyerCourtDao.selectCourtByID(courtid);
	}
	@Override
	public LawyerCourt selectCourtByNumber(String courtnumber) throws Exception {
		return lawyerCourtDao.selectCourtByNumber(courtnumber);
	}

	
	
}
