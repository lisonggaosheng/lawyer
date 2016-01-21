package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;

public interface ExecutebusinessService {
	
	public void insertStep2(Executebusiness executebus)throws Exception; //添加第二步
	public void insertMoreExecutes(Users user) throws Exception;//案源第二步被执行人企业信息的批处理操作——郭志鹏
	public List<Executebusiness> selExecutebusiness(Executebusiness executebus)throws Exception;
	public void insertEb(Executebusiness executebus) throws Exception;
    public void Executebusiness(List<com.lawyer.pojo.Executebusiness> list);
    
    
    /**
	 * excel导入被执行人企业信息
     * @throws Exception 
	 */
	public void excelInsertExecutebusiness(List<Executebusiness> dataList) throws Exception;
    
}
