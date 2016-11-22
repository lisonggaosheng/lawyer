package com.lawyer.tools;

import java.util.List;
import java.util.Map;

import com.lawyer.utils.taglib.JspTagUtil;

public class SystemContents {
	
	public enum SYS_DISPOSE_RESULT_TYPE{
		DISPOSE_RESULT_A("A", "有面谈、签约意向"), 
		DISPOSE_RESULT_B("B", "建议进一步跟进联系"), 
		DISPOSE_RESULT_C("C", "已面谈但未签约"), 
		DISPOSE_RESULT_D("D", "建议登门拜访"),
		DISPOSE_RESULT_E("E", ""),
		DISPOSE_RESULT_F("F", ""),
		DISPOSE_RESULT_G("G", ""),
		DISPOSE_RESULT_H("H", "债权人表示暂且不计划要此笔债权了"),
		DISPOSE_RESULT_I("I", "暂且找不到真正的债权人"),
		DISPOSE_RESULT_J("J", "已接同一债务人其他案件"),
		DISPOSE_RESULT_K("K", "债务人（已注销超过两年）"),
		DISPOSE_RESULT_L("L", "债务人（已进入破产程序）"),
		DISPOSE_RESULT_M("M", "债权人(已执行完毕)"),
		DISPOSE_RESULT_N("N", "债权人（已列入失信名单、显示被执行很多债务）"),
		DISPOSE_RESULT_O("O", "债权人（已进入清算程序、已注销、已吊销）"),
		DISPOSE_RESULT_P("P", "债权人为（政府，银行，律所、村委会）"),
		DISPOSE_RESULT_Q("Q", "债权人股东与债务人股东有重合、债权人是债务人的股东"),
		DISPOSE_RESULT_R("R", "债权人（没有地址及联系电话的个人等）"),
		DISPOSE_RESULT_S("S", "已签约"),
		DISPOSE_RESULT_T("T", ""),
		DISPOSE_RESULT_U("U", ""),
		DISPOSE_RESULT_V("V", ""),
		DISPOSE_RESULT_W("W", ""),
		DISPOSE_RESULT_X("X", ""),
		DISPOSE_RESULT_Y("Y", ""),
		DISPOSE_RESULT_Z("Z", "") ;
		
		private String value;
		private String desc;

		SYS_DISPOSE_RESULT_TYPE(String value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public String value() {
			return this.value;
		}

		public String desc() {
			return this.desc;
		}
	}
	
	/**
	 * 取字典描述：
	 * 用户状态->类型
	 * @param value
	 * @return
	 */
	public static String getsysUserSessionType(int value) {

		for (SYS_DISPOSE_RESULT_TYPE dic : SYS_DISPOSE_RESULT_TYPE.values()) {
			if (dic.value().equals(value)){
				return dic.desc();
			}
		}
		return "";

	}

	/**
	 * 依据类型及字典列表
	 */
	public static List<Map<String,String>> getSelectDic(String type){
		return JspTagUtil.getSelectTag(new SystemContents().getClass().getName()+"$"+type);
	}
	
	public static String getDicDesc(String type, String value) {
		return JspTagUtil.getDicDesc(new SystemContents().getClass().getName()+"$"+type, value);
	}
}
