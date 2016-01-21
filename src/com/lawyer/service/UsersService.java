package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Users;

public interface UsersService {
	
	/**
	 * 管理员用户登陆方法
	 * 刘腾升
	 */
	public Users login(Users users) throws Exception ;
	/**
	 * 管理员添加用户方法，添加完成查询所有用户信息，跳转至SHOW页面，分页显示
	 * 刘腾升
	 * */
	public void insert(Users users)throws Exception ;
	/**
	 * 通过Id得到用户信息
	 * 刘腾升
	 * */
	public Users SelectID(Users users)throws Exception ;
	/**
	 * 通过Id修改用户信息
	 * 刘腾升
	 * */
	public void update(Users users)throws Exception ;
	/**
	 * 通过Name得到用户信息
	 * 刘腾升
	 * */
	public List selectName(Users users)throws Exception ;
	/**
	 * 通过ID删除用户信息
	 * 刘腾升
	 * */
	public void delete(Users users)throws Exception ;
	
	/**
	 * 获取所有的律师
	 * @return
	 * @throws Exception
	 */
	public List<Users> selectLawyers()throws Exception ;
	
	
	/**
	 * 获取所有的办公人员
	 * @return
	 * @throws Exception
	 */
	public List<Users> selectPensons()throws Exception ;
	
	
}
