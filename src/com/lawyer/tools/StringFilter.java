package com.lawyer.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class StringFilter {
	
	private static String regex ="[\u4e00-\u9fa5]";
	
	public static String stringFilter(String str) throws PatternSyntaxException {
		// 只允许字母和数字
		// String regEx = "[^a-zA-Z0-9]";
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
	
	public static void main(String[] args) {
		System.out.println(getOrderNumber("123213元"));
	}
	
	public static String getOrderNumber(String str) {
        Pattern pat = Pattern.compile(regex);    
        Matcher mat = pat.matcher(str);   
        String repickStr = mat.replaceAll("");
        return repickStr;
    }
	
	
}
