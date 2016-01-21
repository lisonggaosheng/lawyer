package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.LawyerCourt;

public interface LawyerCourtService {
	/**
	 * 查找所有法院
	 * @return
	 * @throws Exception
	 */
	public List<?> findAllLawyerCourt() throws Exception;
	/**
	 * 查找所有的一级法院
	 * @return
	 */
	public List<LawyerCourt> findFirstLawyerCourt() throws Exception;
	/**
	 * 根据一级法院查找对应的二级法院
	 * @return
	 */
	public List<LawyerCourt> findSecondLawyerCourt(String fir_id) throws Exception;
	/**
	 *	根据二级法院查找对应的三级法院
	 * @return
	 */
	public List<LawyerCourt> findThirdLawyerCourt(String sec_id) throws Exception;
	/**
	 * 根据id查找法院
	 */
	public LawyerCourt selectCourtByID(int courtid) throws Exception;
	
	public LawyerCourt selectCourtByNumber(String courtnumber) throws Exception;
}
