package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.PageBean;



public interface IPageDao {
	
	/** 
     * 分页查询
     * @param hql 查询的条件
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return list
     */
    public List queryForPage(final String hql,final int offset,final int length) throws Exception;
    
    /**
     * 查询所有记录数
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int getAllRowCount(String hql) throws Exception;
    
	/**
	 * 刘腾升
	 * 通用分页方法调用方式
	 * 最后一个字符串 where 中写查询要用的条件
	 * */
	/**
     * 分页查询
     * @param page 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageBean queryForPage(int pageSize,int page,String object,String id,String where) throws Exception;

}
