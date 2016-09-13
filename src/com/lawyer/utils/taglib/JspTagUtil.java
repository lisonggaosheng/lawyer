package com.lawyer.utils.taglib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 
 * @author xiaofeimi
 *
 */
public class JspTagUtil {

	private static Logger logger = LoggerFactory.getLogger(JspTagUtil.class);
	
	public static List<Map<String, String>> getSelectTag(String tagName) {
		Class<?> cls = null;
		List<Map<String, String>> selectList = new ArrayList<Map<String, String>>();
		Enum inter[] = null;
		try {
			try {
				cls = Class.forName(tagName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Method method = cls.getDeclaredMethod("values");

			if (cls.isEnum()) {
				List<?> list = Arrays.asList(cls.getEnumConstants());
				for (Object enu : list) {
					inter = (Enum[]) method.invoke(enu);
				}
			}

			// inter=Arrays.copyOfRange(inter, 0, inter.length-1);

			for (Enum enumMessage : inter) {
				Map<String, String> selectMap = new LinkedHashMap<String, String>();
				selectMap.put("" + cls.getDeclaredMethod("value").invoke(enumMessage),
						(String) cls.getDeclaredMethod("desc").invoke(enumMessage));
				selectMap.put("value", "" + cls.getDeclaredMethod("value").invoke(enumMessage));
				if(!"删除".equals((String) cls.getDeclaredMethod("desc").invoke(enumMessage)))
				  selectList.add(selectMap);
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return selectList;
	}
	
	
	public static String getDicDesc(String tagName,String value) {
		Class<?> cls = null;
		Enum inter[] = null;
		String descstr="";
		try {
			try {
				cls = Class.forName(tagName);
			} catch (Exception e) {
				e.printStackTrace();
			}
			Method method = cls.getDeclaredMethod("values");

			if (cls.isEnum()) {
				List<?> list = Arrays.asList(cls.getEnumConstants());
				for (Object enu : list) {
					inter = (Enum[]) method.invoke(enu);
				}
			}

			for (Enum enumMessage : inter) {
				String val = (String) cls.getDeclaredMethod("value").invoke(enumMessage);
				String corrdesc=(String) cls.getDeclaredMethod("desc").invoke(enumMessage);
				if(val.equals(value) )
					return corrdesc;
			}
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return descstr;
	}

}
