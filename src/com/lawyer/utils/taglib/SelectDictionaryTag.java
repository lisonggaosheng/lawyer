package com.lawyer.utils.taglib;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.lawyer.tools.SystemContents;


public class SelectDictionaryTag extends SimpleTagSupport {

	private String value = "";
	private String type = "";
	private String name = "";
	private String id = "";

	@Override
	public void doTag() throws JspException, IOException {
		List<Map<String, String>> selectDic = SystemContents.getSelectDic(type);
		JspWriter out = getJspContext().getOut();

		out.print("<select name=\"" + name + "\" class=\"fufong mt10\" id=\"" + id + "\">");
		out.print("<option value=''>--«Î—°‘Ò--</option>");
		for (Map<String, String> type : selectDic) {
			if (value.toUpperCase().equals(type.keySet().iterator().next())) {
				out.print("<option value=" + type.get("value") + " selected='selected'>"+ type.get("value")+ type.values().iterator().next() + "</option>");
			} else
				out.print("<option value=" + type.get("value") + " >" + type.get("value") + type.values().iterator().next() + "</option>");

		}

		out.print("</select>");
		super.doTag();

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
