package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.FilesDao;
import com.lawyer.pojo.Filelibrary;
import com.lawyer.pojo.Files;
import com.lawyer.service.FilesService;

public class FilesServiceImpl implements FilesService{
	private FilesDao filesDao;
	public void filesUpload(Files files1) {
		this.filesDao.filesUpload(files1);
	}
	public FilesDao getFilesDao() {
		return filesDao;
	}
	public void setFilesDao(FilesDao filesDao) {
		this.filesDao = filesDao;
	}
	public List list(int id) {
		String hql="from Files where f_flid='"+id+"'";
		return this.filesDao.list(hql);
	}
	public Filelibrary loadById(int id) {

		return this.filesDao.loadById(id);
	}
	public Files filesById(int id) {
		
		return this.filesDao.filesById(id);
	}
	public void update(Files fl) {
		this.filesDao.update(fl);
	}
	public void delete(int id) {
		this.filesDao.deleteById(id);
	}
	

}
