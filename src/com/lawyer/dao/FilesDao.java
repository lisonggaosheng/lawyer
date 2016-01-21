package com.lawyer.dao;

import java.util.List;

import com.lawyer.pojo.Filelibrary;
import com.lawyer.pojo.Files;

public interface FilesDao {
	public void filesUpload(Files files1);
	public List list(String hql);
	public Filelibrary loadById(int id);
	public Files filesById(int id);
	public void update(Files fl);
	public void delete(Files f);
	public void deleteById(int id);
}
