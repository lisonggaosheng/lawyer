package com.lawyer.dao;



import java.util.List;

import com.lawyer.pojo.Executebusiness;
import com.lawyer.pojo.Users;

public interface ExecutebusinessDao {
	
	
	public void insertStep2(Executebusiness executebus)throws Exception;
	public void insertMoreExecutes(Users user) throws Exception;//案源第二步被执行人企业信息的批处理操作——郭志鹏
	public List<Executebusiness> selExecutebusiness(Executebusiness executebus)throws Exception;
	public void insertEb(Executebusiness executebus) throws Exception;
	
	public void Executebusiness(List<com.lawyer.pojo.Executebusiness> list);
	
	//更新被执行人企业信息
	public void updateExecutes(Executebusiness exbusiness) throws Exception;
	
    
}
