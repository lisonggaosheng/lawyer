package com.lawyer.utils.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.lawyer.tools.SystemContents;

public class DictionaryTag extends SimpleTagSupport {


	private String value = "";
	private String type = "";

	@Override
	public void doTag() throws JspException, IOException {

        this.getJspContext().getOut().write(SystemContents.getDicDesc(type,value));  
        
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
