package com.lawyer.action;

import java.io.InputStream;
import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DownAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String filename;
	
	public String downFile(){
		InputStream inputStream = ServletActionContext.getServletContext().getResourceAsStream(filename);
		
		if(inputStream != null){
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
		
	}
	public InputStream getDownloadFile(){
		InputStream  in = ServletActionContext.getServletContext().getResourceAsStream(filename);
	
		return in;
	}
	
	public String getFilename() {
		try {
			return new String(filename.getBytes(),"iso-8859-1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void setFilename(String filename) {
		try {
			
			filename=URLDecoder.decode(filename, "utf-8");
			this.filename = new String(filename.getBytes("iso-8859-1"),"utf-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
