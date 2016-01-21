package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.SysTask;

public interface UserTaskService {

	public Object insertUserTask(SysTask userTask) throws Exception;
	
	Integer selectUserTaskPageSize(SysTask task) throws Exception;

	List<SysTask> selectUserTasks(int currentPage, SysTask task)
			throws Exception;
	
	public SysTask getTask(int taskid)throws Exception;
}
