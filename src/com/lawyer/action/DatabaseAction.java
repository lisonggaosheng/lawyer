package com.lawyer.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;


import com.lawyer.tools.MySQL;
import com.opensymphony.xwork2.ActionSupport;

public class DatabaseAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String filename="test.sql";
	private File sqlfile;
	private String sqlfileFileName;
	private String sqlfileContentType;
	private String result;
	
	
	public InputStream getDownloadFile(){
		InputStream in=null;
		try {
			in = new FileInputStream("D:/"+filename);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return in;
	}
	public String backup(){
		try {
			MySQL.backup();
			return SUCCESS;
		} catch (IOException e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	public String load(){
		try {
			FileUtils.copyFile(sqlfile, new File("d:/test.sql"));
			MySQL.load();
			result="数据库还原完成！";
			
		} catch (Exception e) {
			e.printStackTrace();
			result="数据库还原失败！";
			return SUCCESS;
		}
		return SUCCESS;
	}
	
	
	public File getSqlfile() {
		return sqlfile;
	}
	public void setSqlfile(File sqlfile) {
		this.sqlfile = sqlfile;
	}
	public String getSqlfileFileName() {
		return sqlfileFileName;
	}
	public void setSqlfileFileName(String sqlfileFileName) {
		this.sqlfileFileName = sqlfileFileName;
	}
	public String getSqlfileContentType() {
		return sqlfileContentType;
	}
	public void setSqlfileContentType(String sqlfileContentType) {
		this.sqlfileContentType = sqlfileContentType;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
