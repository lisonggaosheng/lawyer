package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.ClearClear;
import com.lawyer.pojo.ClearRecord;
import com.lawyer.pojo.CloseRecord;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Execute;
import com.lawyer.pojo.Litigation;
import com.lawyer.pojo.MaintainCustomers;
import com.lawyer.pojo.Material;

public interface ClearRecordService {
	public List<?> seniorSelectNew(final int currentPage, final int pageSize,final ContractSign cont) throws Exception;
	public int seniorSelectPageSizeNew(final int pageSize,final ContractSign cont) throws Exception;
	
	
	/**
	 * 高级查询案件信息——李梦翔
	 */
	public List<?> seniorSelect(final int currentPage, final int pageSize,final String... params) throws Exception;
	public int seniorSelectPageSize(final int pageSize,final String... params) throws Exception;
	
	public void insertClearRecord(ClearRecord clearRecord) throws Exception;//添加   立案信息——郭志鹏
	public List<ContractSign> selectCourts(final int currentPage,ContractSign cont,String startDate,String endDate) throws Exception;//查询全部案件---张磊
	public String selectClearsPageSize(ContractSign cont,String startDate,String endDate) throws Exception;
	public ContractSign selectDetal(String csCasecodeself)throws Exception;
	public void addClearrecord(ClearRecord clearrecord) throws Exception;
	public void addClearclear(ClearClear clearclear)throws Exception;
	public void addLitigation(Litigation litigation)throws Exception;
	public void addExecute(Execute execute)throws Exception;
	public void addClearClose(CloseRecord closeRecord)throws Exception;
	public ContractSign DaYinContractSign(String trim)throws Exception;
	public List<ClearRecord> DaYinClearRecord(String trim)throws Exception;
	public List<ClearClear> DaYinClearClear(String trim)throws Exception;
	public List<Litigation> DaYinLitigation(String trim)throws Exception;
	public List<Execute> DaYinExecute(String trim)throws Exception;
	public CloseRecord DaYinCloseRecord(String trim)throws Exception;
	
	public List<ClearRecord> selectClearRecord(ClearRecord clearRecord)throws Exception;
	public List<ClearClear> selectClearClear(ClearClear clearClear)throws Exception;
	public List<Litigation> selectLitigation(Litigation litigation)throws Exception;
	public List<Execute> selectExecute(Execute execute)throws Exception;
	
	
	public List<?> selectClearsByname(final int currentPage,String  lawname) throws Exception;//查询全部案件---张磊
	public String selectClearsPageSizeByname(String  lawname) throws Exception;
	
	//材料整理
	public void addMaterial(Material material) throws Exception;
	public List<Material> selectMaterial(Material material)throws Exception;
	
	//案件步骤添加时显示以前的信息
	public MaintainCustomers showcustomer(String casecodeself) throws Exception;
	public ClearRecord showclearrecord(String casecodeself) throws Exception;
	public ClearClear showclearclear(String casecodeself) throws Exception;
	public Litigation showlitigation(String casecodeself) throws Exception;
	public Execute showexecute(String casecodeself) throws Exception;
	
	//维护客户
	public void addCustomers(MaintainCustomers maintainCustomers) throws Exception;
	public List<MaintainCustomers> selectCustomers(String casecodeself) throws Exception;
}
