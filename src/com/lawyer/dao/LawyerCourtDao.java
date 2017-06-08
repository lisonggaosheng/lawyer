package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.LawyerCourt;

/**
 * @date 2013-4-13 15:45:03
 * @author 李梦翔
 *	法院的持久化层
 */
public interface LawyerCourtDao {
	/**
	 * 查找所有法院信息
	 * @return
	 * @throws Exception
	 */
	public List<LawyerCourt> selectAll() throws Exception;
	/**
	 * 查找一级的法院
	 */
	public List<LawyerCourt> selectFirst() throws Exception;
	/**
	 * 根据一级查找二级
	 */
	public List<LawyerCourt> selectSecond(String fir_id) throws Exception;
	/**
	 * 根据二级查找三级
	 */
	public List<LawyerCourt> selectThird(String sec_id) throws Exception;
	/**
	 * 根据id查找法院
	 */
	public LawyerCourt selectCourtByID(int courtid) throws Exception;
	
	/**
	 * 根据number查找法院
	 */
	public LawyerCourt selectCourtByNumber(String courtnumber) throws Exception;
	
	String getCourtNumberByName(String courtName);
}
