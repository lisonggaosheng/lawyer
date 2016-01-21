package com.lawyer.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lawyer.dao.ClearRecordDao;
import com.lawyer.pojo.ClearClear;
import com.lawyer.pojo.ClearRecord;
import com.lawyer.pojo.CloseRecord;
import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Execute;
import com.lawyer.pojo.Litigation;
import com.lawyer.pojo.Material;
import com.lawyer.pojo.Users;
import com.lawyer.service.ClearRecordService;

public class ClearRecordServiceImpl implements ClearRecordService {
	private ClearRecordDao crd = null;
	
	@Override
	public List<?> seniorSelectNew(int currentPage, int pageSize,
			ContractSign cont) throws Exception {
		List<ContractSign> signs = new ArrayList<ContractSign>();
		List<Object[]> objs = (List<Object[]>) crd.seniorSelectNew(currentPage,
				pageSize, cont);
		for (Object[] objects : objs) {
			signs.add(new ContractSign(Integer.parseInt(objects[0].toString()),
					new Users(Integer.parseInt(objects[1].toString())),
					objects[2] != null ? objects[2].toString() : "",
					objects[3] != null ? objects[3].toString() : "",
					objects[4] != null ? objects[4].toString() : "",
					objects[5] != null ? objects[5].toString() : "",
					objects[6] != null ? objects[6].toString() : "",
					objects[7] != null ? objects[7].toString() : "",
					objects[8] != null ? objects[8].toString() : "",
					objects[9] != null ? objects[9].toString() : "",
					objects[10] != null ? objects[10].toString() : "",
					objects[11] != null ? objects[11].toString() : ""));
		}

		return signs;
	}

	@Override
	public int seniorSelectPageSizeNew(int pageSize, ContractSign cont)
			throws Exception {
		return (Integer.parseInt(crd.seniorSelectPageSizeNew(pageSize, cont)
				.toString()) - 1)
				/ pageSize + 1;
	}

	/**
	 * 高级查询案件信息——李梦翔
	 */
	@SuppressWarnings("unchecked")
	public List<?> seniorSelect(int currentPage, int pageSize, String... params)
			throws Exception {
		List<ContractSign> signs = new ArrayList<ContractSign>();
		List<Object[]> objs = (List<Object[]>) crd.seniorSelect(currentPage,
				pageSize, params);
		for (Object[] objects : objs) {
			signs.add(new ContractSign(Integer.parseInt(objects[0].toString()),
					new Users(Integer.parseInt(objects[1].toString())),
					objects[2] != null ? objects[2].toString() : "",
					objects[3] != null ? objects[3].toString() : "",
					objects[4] != null ? objects[4].toString() : "",
					objects[5] != null ? objects[5].toString() : "",
					objects[6] != null ? objects[6].toString() : "",
					objects[7] != null ? objects[7].toString() : "",
					objects[8] != null ? objects[8].toString() : "",
					objects[9] != null ? objects[9].toString() : "",
					objects[10] != null ? objects[10].toString() : "",
					objects[11] != null ? objects[10].toString() : ""));
		}

		return signs;
	}

	public int seniorSelectPageSize(final int pageSize, final String... params)
			throws Exception {
		return (Integer.parseInt(crd.seniorSelectPageSize(pageSize, params)
				.toString()) - 1)
				/ pageSize + 1;
	}

	public ClearRecordDao getCrd() {
		return crd;
	}

	public void setCrd(ClearRecordDao crd) {
		this.crd = crd;
	}

	@Override
	public void insertClearRecord(ClearRecord clearRecord) throws Exception {
		crd.insertClearRecord(clearRecord);

	}

	@Override
	public List<ContractSign> selectCourts(final int currentPage,ContractSign cont,String startDate,String endDate)
			throws Exception {

		return crd.selectClearsNew(currentPage,cont,startDate,endDate);
	}

	@Override
	public String selectClearsPageSize(ContractSign cont,String startDate,String endDate) throws Exception {

		return (Integer.parseInt(crd.selectClearsPageSizeNew(cont,startDate,endDate).toString()) - 1)
				/ 10 + 1 + "";

	}

	@Override
	public ContractSign selectDetal(String csCasecodeself) throws Exception {

		return crd.selectDetal(csCasecodeself);
	}

	@Override
	public void addClearrecord(ClearRecord clearrecord) throws Exception {
		crd.addClearrecord(clearrecord);

	}

	@Override
	public void addClearclear(ClearClear clearclear) throws Exception {
		crd.addClearclear(clearclear);

	}

	@Override
	public void addLitigation(Litigation litigation) throws Exception {
		crd.addLitigation(litigation);

	}

	@Override
	public void addExecute(Execute execute) throws Exception {
		crd.addExecute(execute);

	}

	@Override
	public void addClearClose(CloseRecord closeRecord) throws Exception {
		crd.addClearClose(closeRecord);
	}

	@Override
	public ContractSign DaYinContractSign(String trim) throws Exception {
		
		return crd.DaYinContractSign(trim);
	}

	@Override
	public List<ClearRecord> DaYinClearRecord(String trim) throws Exception {
		// TODO Auto-generated method stub
		 return crd.DaYinClearRecord(trim);
	}

	@Override
	public List<ClearClear> DaYinClearClear(String trim) throws Exception {
		// TODO Auto-generated method stub
		return crd.DaYinClearClear(trim);
	}

	@Override
	public List<Litigation> DaYinLitigation(String trim) throws Exception {
		// TODO Auto-generated method stub
	 return crd.DaYinLitigation(trim);
	}

	@Override
	public List<Execute> DaYinExecute(String trim) throws Exception {
		// TODO Auto-generated method stub
		 return crd.DaYinExecute(trim);
	}

	@Override
	public CloseRecord DaYinCloseRecord(String trim) throws Exception {
		// TODO Auto-generated method stub
		 return crd.DaYinCloseRecord(trim);
	}

	@Override
	public List<ClearRecord> selectClearRecord(ClearRecord clearRecord)
			throws Exception {
		return crd.selectClearRecord(clearRecord);
	}

	@Override
	public List<ClearClear> selectClearClear(ClearClear clearClear)
			throws Exception {
		return crd.selectClearClear(clearClear);
	}

	@Override
	public List<Litigation> selectLitigation(Litigation litigation)
			throws Exception {
		return crd.selectLitigation(litigation);
	}

	@Override
	public List<Execute> selectExecute(Execute execute) throws Exception {
		return crd.selectExecute(execute);
	}

	@Override
	public List<?> selectClearsByname(int currentPage, String lawname)
			throws Exception {
		return crd.selectClearsByname(currentPage, lawname);
	}

	@Override
	public String selectClearsPageSizeByname(String lawname) throws Exception {
		return (Integer.parseInt(crd.selectClearsPageSizeByname(lawname).toString()) - 1)
		/ 10 + 1 + "";
	}

	
	@Override
	public void addMaterial(Material material) throws Exception {
		crd.addMaterial(material);
		
	}

	@Override
	public List<Material> selectMaterial(Material material) throws Exception {
		return crd.selectMaterial(material);
	}

	@Override
	public ClearRecord showclearrecord(String casecodeself) throws Exception {
		return crd.showclearrecord(casecodeself);
	}

	@Override
	public ClearClear showclearclear(String casecodeself) throws Exception {
		return crd.showclearclear(casecodeself);
	}

	@Override
	public Litigation showlitigation(String casecodeself) throws Exception {
		return crd.showlitigation(casecodeself);
	}

	@Override
	public Execute showexecute(String casecodeself) throws Exception {
		return crd.showexecute(casecodeself);
	}

}
