package com.lawyer.dao;

import java.util.List;

import com.lawyer.tools.PageBean;

public interface PagingDao {
	/** 
     * 分页查询
     * @param hql 查询的条件
     * @param offset 开始记录
     * @param length 一次查询几条记录
     * @return
     */
    public List queryForPage(final String hql,final int offset,final int length);
    
    /**
     * 查询所有记录数
     * @param hql 查询的条件
     * @return 总记录数
     */
    public int getAllRowCount(String hql);
    
	/**
     * 分页查询
     * @param page 当前第几页
     * @param pageSize 每页大小
     * @return 封闭了分页信息(包括记录集list)的Bean
     */
    public PageBean queryForPage(int pageSize,int page,Object obj,String i,String starttime,String endtime);
}
