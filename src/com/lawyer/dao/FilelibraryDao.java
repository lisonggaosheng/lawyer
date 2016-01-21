package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Filelibrary;


	/**
	 * @author ÕÅÎ÷·æ
	 * @version 1.0
	 * @since 2013-3-19
	 */
public interface FilelibraryDao {
	public void add(Filelibrary filelibrary);
	public List list(String hql);
	public Filelibrary loadById(int id);
	public void update(Filelibrary fl);
	public void delete(Filelibrary fl);
	public void deleteById(int id);
	public List<Filelibrary> selectFilelibrary(Filelibrary filelibrary);
	public List<Filelibrary> findAllFilelibrary();
}
