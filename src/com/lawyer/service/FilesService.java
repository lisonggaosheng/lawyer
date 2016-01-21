package com.lawyer.service;

import java.util.List;

import com.lawyer.pojo.Filelibrary;
import com.lawyer.pojo.Files;

public interface FilesService {
	public void filesUpload(Files files1);
	public List list(int id);
	public Filelibrary loadById(int id);
	public Files filesById(int id);
	public void update(Files fl);
	public void delete(int id);
}
