
package com.lawyer.tools;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
public class CommonUtil {
	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	/**
	  * 返回一个定长的随机字符串(只包含大小写字母、数字)
	  * 
	  * @param length
	  *            随机字符串长度
	  * @return 随机字符串
	  */
	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
		}
		return sb.toString();
	}
	
	/**
	 * 去除特殊符号
	 * @param str
	 * @return
	 * @throws PatternSyntaxException
	 */
	private static String StringFilter(String str) throws PatternSyntaxException { 
		// 只允许字母和数字 // String regEx ="[^a-zA-Z0-9]"; 
		// 清除掉所有特殊字符 
		String regEx="[`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]"; 
		Pattern p = Pattern.compile(regEx); 
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	} 
	private static int getLastChinese(String s){
		   int index = 0;
		   for (int i = s.length()-1;i>=0;i--)
		   {
			  String w=s.substring(i, i+1);
			  if(w.compareTo("\u4e00")>0&&w.compareTo("\u9fa5")<0)
			  {
				  index = i;
				  break;
			  }
		   }
		   return index;
	   } 
	
	private static Double stringToDouble(String s){
		Double cny = Double.parseDouble(s);//6.2041    这个是转为double类型  
		DecimalFormat df = new DecimalFormat("0.00");   
		String CNY = df.format(cny); //6.20   这个是字符串，但已经是我要的两位小数了  
		Double money = Double.parseDouble(CNY); //6.20  
		return money;
	}
	
	//截取数字  
	   public static Double getNumbers(String str) {  
		   Double money = 0.00; 
		   str = StringFilter(str);
		   String[] array = str.split("元");
		   for (String string : array) {
			   String gogoro = string.replaceAll("^[0.0-9.0]+$",""); 
			   String moneyStr = gogoro.substring(getLastChinese(gogoro)+1);
			   if(moneyStr!=null && moneyStr.length()>1){
				   money += stringToDouble(moneyStr);
			   }
		   }
	       return money;
	   }  
	   
	   public static void main(String[] args) {
		   String str = "判决如下：\n一、自本判决书生效之日起5日内，原告天津博航一统装饰材料有限公司支付被告张阳2015年5月1日至4日的工资97.29元；\n二、自本判决书生效之日起5日内，原告天津博航一统装饰材料有限公司支付被告张阳2014年8月、9月防暑降温费256元；\n三、自本判决书生效之日起5日内，原告天津博航一统装饰材料有限公司支付被告张阳2014年7月15日至2015年4月27日法定节假日加班费1751.2 元；\n四、自本判决书生效之日起5日内，原告天津博航一统装饰材料有限公司支付被告张阳2014年7月15日至2015年4月27日休息日加班费6436元；\n五、驳回原告天津博航一统装饰材料有限公司的其他诉讼请求。\n案件受理费10元，由原告负担。";
		   String str1 = "被告给付原告10272元";
		   System.out.println(getNumbers(str1));
	}
}
