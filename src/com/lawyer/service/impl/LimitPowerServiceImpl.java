package com.lawyer.service.impl;

import com.lawyer.dao.LimitPowerDao;
import com.lawyer.pojo.LimitPower;
import com.lawyer.service.LimitPowerService;

public class LimitPowerServiceImpl implements LimitPowerService{
	private LimitPowerDao lpdao;
	/**
	 * 添加用户权限
	 */
	@Override
	public void addLP(LimitPower limitPower) {
		// TODO Auto-generated method stub
		lpdao.addLP(limitPower);
	}
	/**
	 * 根据用户名查询用户权限
	 */
	@Override
	public LimitPower findLPByUserName(String user_name) {
		// TODO Auto-generated method stub
		return lpdao.selectLPByUserName(user_name);
	}
	/**
	 * 修改用户权限
	 */
	@Override
	public void updLP(LimitPower limitPower) {
		// TODO Auto-generated method stub
		lpdao.updLP(limitPower);
	}
	/**
	 * 删除用户权限
	 */
	@Override
	public void removeLP(LimitPower limitPower) {
		// TODO Auto-generated method stub
		lpdao.delLP(limitPower);
	}
	public LimitPowerDao getLpdao() {
		return lpdao;
	}
	public void setLpdao(LimitPowerDao lpdao) {
		this.lpdao = lpdao;
	}
	
}
