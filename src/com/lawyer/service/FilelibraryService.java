package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Filelibrary;



public interface FilelibraryService {
	public void add(Filelibrary filelibrary);
	public List list();
	public Filelibrary updateInput(int id);
	public void update(Filelibrary fl);
	public void delete(int id);
	public List<Filelibrary>  selectFilelibrary(Filelibrary filelibrary);
	public List<Filelibrary> findAllFilelibrary();
}
