package com.lawyer.tools;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

public class ObjAndList2Json {
	/**
	 * 利用反射机制  将任意对象  封装 成 json对象
	 * UserInfo u = new UserInfo("1001","zhangsan");
	 * {'user_id':'1001','user_name':'zhangsan'}
	 */
	public static String obj2json(Object obj){
		StringBuffer sbf = new StringBuffer("");
		sbf.append("{");
		//1.取得obj对应的Class对象
		Class<?> clz = obj.getClass();
		//2.取得所有方法
		Method[] methods = clz.getMethods();
		
		int i = 0;//拼接json字符串中的“,”用的标识
		for (Method method : methods) {//遍历所有方法
			//取得所有的public 修饰的方法
			if(method.getModifiers() == Modifier.PUBLIC){
				//取得get方法
				if(method.getName().substring(0,3).equals("get")){
					//拼接json字符串
					if(i!=0){
						sbf.append(",");
					}
					
					sbf.append("'");
					//去掉get，并转小写  得到字段名
					sbf.append(method.getName().substring(3).toLowerCase());
					sbf.append("'");
					sbf.append(":");
					sbf.append("'");
					try {
						//调用这个get方法  获得该字段的值
						sbf.append(method.invoke(obj));
					} catch (Exception e) {
						e.printStackTrace();
					} 
					sbf.append("'");
					i++;
				}
			}
		}
		String rs = sbf.append("}").toString();
		return rs;
	}
	
	/**
	 * 利用反射机制  将任意List集合 封装 成 json对象
	 * UserInfo u = new UserInfo("1001","zhangsan");
	 * [{},{},{}]
	 */
	public static String list2jsonarr(List<?> list){
		StringBuffer sbf = new StringBuffer("");
		sbf.append("[");
		int i = 0;
		for(Object obj : list){
			if(i != 0){
				sbf.append(",");
			}
			sbf.append(obj2json(obj));
			i++;
		}
		return sbf.append("]").toString();
	}
}
