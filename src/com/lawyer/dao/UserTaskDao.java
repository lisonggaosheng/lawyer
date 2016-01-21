package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.ContractSign;
import com.lawyer.pojo.Court;
import com.lawyer.pojo.SysTask;

public interface UserTaskDao {

	public Object insertUserTask(SysTask userTask) throws Exception;
	
	public List<SysTask> selectUserTasks(final int currentPage,final SysTask task) throws Exception;
	
	public Object selectUserTaskPageSize(SysTask task) throws Exception;
	
	public SysTask getTask(int taskid)throws Exception;
}
