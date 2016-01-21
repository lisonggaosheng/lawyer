package com.lawyer.service.impl;

import java.util.List;

import com.lawyer.dao.FilelibraryDao;
import com.lawyer.pojo.Filelibrary;
import com.lawyer.service.FilelibraryService;

public class FilelibraryServiceImpl implements FilelibraryService{
	private FilelibraryDao filelibraryDao;

	public void add(Filelibrary filelibrary) {
		this.filelibraryDao.add(filelibrary);
	}
	public List list() {
		String hql="from Filelibrary order by flId desc";
		return this.filelibraryDao.list(hql);
	}
	public FilelibraryDao getFilelibraryDao() {
		return filelibraryDao;
	}

	public void setFilelibraryDao(FilelibraryDao filelibraryDao) {
		this.filelibraryDao = filelibraryDao;
	}
	public Filelibrary updateInput(int id) {
		return this.filelibraryDao.loadById(id);
	}
	public void update(Filelibrary fl) {
		this.filelibraryDao.update(fl);
	}
	public void delete(int id) {
		this.filelibraryDao.deleteById(id);
	}
	public List<Filelibrary>  selectFilelibrary(Filelibrary filelibrary) {
		return filelibraryDao.selectFilelibrary(filelibrary);
	}
	@Override
	public List<Filelibrary> findAllFilelibrary() {
		
		return filelibraryDao.findAllFilelibrary();
	}

	
	

}
