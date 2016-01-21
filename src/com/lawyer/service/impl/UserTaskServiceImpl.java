package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.UserTaskDao;
import com.lawyer.pojo.SysTask;
import com.lawyer.service.UserTaskService;

public class UserTaskServiceImpl implements UserTaskService {

	private UserTaskDao userTaskDao;
	
	public UserTaskDao getUserTaskDao() {
		return userTaskDao;
	}

	public void setUserTaskDao(UserTaskDao userTaskDao) {
		this.userTaskDao = userTaskDao;
	}

	@Override
	public Object insertUserTask(SysTask userTask) throws Exception {
		 return userTaskDao.insertUserTask(userTask);
		
	}

	@Override
	public List<SysTask> selectUserTasks(int currentPage,SysTask task)
			throws Exception {
		return userTaskDao.selectUserTasks(currentPage, task);
	}

	@Override
	public Integer selectUserTaskPageSize(SysTask task) throws Exception {
		return Integer.parseInt((String.valueOf(userTaskDao.selectUserTaskPageSize(task))));
	}

	@Override
	public SysTask getTask(int taskid) throws Exception {
		return userTaskDao.getTask(taskid);
	}

	

}
