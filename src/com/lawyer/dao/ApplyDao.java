package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Apply;
import com.lawyer.pojo.Users;

public interface ApplyDao {
	/**
	 *通过用户名模糊查询申请信息
	 *刘腾升
	 * */
	public List selectName(Users users)throws Exception;
	/**
	 * 通过用户ID批准授权
	 * 刘腾升
	 * */
	public void authorize(Apply apply)throws Exception;
	/**
	 * 通过用户ID得到授权记录
	 * 刘腾升
	 * */
	public Apply selectID(Apply apply)throws Exception;
	/**
	 * 通过用户ID拒绝授权
	 * 刘腾升
	 * */
	public void decline(Apply apply)throws Exception;
	/**
	 *通过用户名模糊查询申请信息2
	 *刘腾升
	 * */
	public List selectName2(Users users)throws Exception;
}
