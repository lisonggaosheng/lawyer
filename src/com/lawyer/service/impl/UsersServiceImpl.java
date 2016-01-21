package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.UsersDao;
import com.lawyer.pojo.Users;
import com.lawyer.service.UsersService;

public class UsersServiceImpl implements UsersService {
	
	//:封装的Users操作层接口
	private UsersDao usersDao;
	public UsersDao getUsersDao() {
		return usersDao;
	}
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	/**
	 * 管理员用户登陆方法
	 */
	public Users login(Users users)throws Exception  {
		return usersDao.login(users);
	}

	/**
	 * 管理员添加用户方法，添加完成查询所有用户信息，跳转至SHOW页面，分页显示
	 * */
	public void insert(Users users) throws Exception {
		usersDao.insert(users);
	}

	/**
	 * 通过Id得到用户信息
	 * */
	public Users SelectID(Users users) throws Exception {
		return usersDao.SelectID(users);
	}

	/**
	 * 通过Id修改用户信息
	 * */
	public void update(Users users) throws Exception {
		 usersDao.update(users);
	}

	/**
	 * 通过Name得到用户信息
	 * */
	public List selectName(Users users) throws Exception {
		return usersDao.selectName(users);
	}
	/**
	 * 通过ID删除用户信息
	 * */
	public void delete(Users users) throws Exception {
		usersDao.delete(users);
	}
	@Override
	public List<Users> selectLawyers() throws Exception {
		return usersDao.selectLawyers();
	}
	
	@Override
	public List<Users> selectPensons() throws Exception {
		return usersDao.selectPensons();
	}
}
