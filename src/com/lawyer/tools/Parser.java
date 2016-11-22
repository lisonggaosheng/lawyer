package com.lawyer.tools;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    /***
     * 为每个线程绑定一系列的SimpleDateFormat，用HashMap保存
     */
    public static ThreadLocal<HashMap<DateType,SimpleDateFormat>> tl =
            new ThreadLocal<HashMap<DateType,SimpleDateFormat>>(){
                @Override
                protected synchronized HashMap<DateType,SimpleDateFormat> initialValue() {//初始化为空
                    return new HashMap<DateType,SimpleDateFormat>();
                }
            };
    public enum DateType {
        Day,
        Year,
        Full,
        AllFull,
        FullNoDash,
        Short,
        Time,
        SpecialTime;
        public static SimpleDateFormat formatFromDateType (DateType type) {
            HashMap<DateType,SimpleDateFormat> typeMap = tl.get();
            if(typeMap.get(type) == null){
                setFormat(type);
            }
            return typeMap.get(type);
        }
        private static void setFormat (DateType type){
            SimpleDateFormat format = null;
            switch (type) {
                case Day: format = new SimpleDateFormat("yyyy-MM-dd");
                    break;
                case Year: format = new SimpleDateFormat("yyyy");
                    break;
                case Full: format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    break;
                case AllFull: format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                    break;
                case FullNoDash: format = new SimpleDateFormat("yyyyMMddHHmmss");
                    break;
                case Short: format = new SimpleDateFormat("M月d日 HH:mm");
                    break;
                case Time: format = new SimpleDateFormat("HH:mm:ss");
                    break;
                case SpecialTime: format = new SimpleDateFormat("M月d日HH-mm");
                    break;
                default:
                    format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            }
            tl.get().put(type, format);
        }
    }
    public static int defaultInt = -99999999;

//	private static SimpleDateFormat dtFormatFull = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	private static SimpleDateFormat dtFormatFullNoDash = new SimpleDateFormat("yyyyMMddHHmmss");
//	private static SimpleDateFormat dtFormatShort = new SimpleDateFormat("M月d日 HH:mm");
//	private static SimpleDateFormat dtFormatDay = new SimpleDateFormat("yyyy-MM-dd");
//	private static SimpleDateFormat dtFormatTime = new SimpleDateFormat("HH:mm:ss");
//	private static SimpleDateFormat dtFormatSpecial = new SimpleDateFormat("M月d日HH-mm");
//	private static SimpleDateFormat dtFormatYear = new SimpleDateFormat("yyyy");


    //int float section
    public static int getInt (Object obj, int defaultValue) {
        if ( obj != null ) {
            if (obj instanceof Integer) {
                return ((Integer)obj).intValue();
            }
            if (obj instanceof String) {
                String str = (String)obj;
                if ( str != null && !str.equals("") && str.matches("\\d+")) {
                    return Integer.parseInt(str);
                }
            }
            if (obj instanceof Long) {
                return (int)((Long)obj).longValue();
            }
            if (obj instanceof Float) {
                return (int)((Float)obj).floatValue();
            }
            if (obj instanceof Double) {
                return (int)((Double)obj).doubleValue();
            }
            if (obj instanceof BigDecimal) {
                return (int)((BigDecimal)obj).intValue();
            }
        }
        return defaultValue;
    }

    public static int getInt (Object obj) {
        return getInt(obj, defaultInt);
    }

    public static int getInt (HashMap<?, ?> set, String key) {
        if (key == null) {
            return defaultInt;
        }
        Object obj = set.get(key);
        return getInt(obj);
    }
    public static Long getLong (HashMap<?, ?> set, String key) {
        if (key == null) {
            return Long.valueOf(defaultInt);
        }
        Object obj = set.get(key);
        return getLong(obj);
    }
    public static int getInt (HashMap<?, ?> set, String key, int defaultValue) {
        int value = getInt(set, key);
        return value == defaultInt? defaultValue: value;
    }

    public static float getFloat (Object obj) {
        if ( obj != null && !"".equals(obj)) {
            if (obj instanceof Integer) {
                return ((Integer)obj).intValue();
            }
            if (obj instanceof String) {
                return Float.parseFloat((String)obj);
            }
            if (obj instanceof Long) {
                return ((Long)obj).longValue();
            }
            if (obj instanceof Float) {
                return ((Float)obj).floatValue();
            }
            if (obj instanceof Double) {
                return (float)((Double)obj).doubleValue();
            }
            if (obj instanceof BigDecimal) {
                return ((BigDecimal)obj).floatValue();
            }
            return 0;
        } else {
            return defaultInt;
        }
    }
    public static float getFloat(Object obj,float defualtValue){
        if(obj != null){
            return getFloat(obj);
        }
        return 0.0f;
    }
    public static float getFloat (HashMap<?, ?> set, String key) {
        if (key == null) {
            return defaultInt;
        }
        Object obj = set.get(key);
        return getFloat(obj);
    }

    /**
     * 值为空，则返回空
     * @param set
     * @param key
     * @return
     */
    public static Float getFloatByNull (HashMap<?, ?> set, String key) {
        if (key == null) {
            return null;
        }
        Object obj = set.get(key);
        if(obj == null) return null;
        return getFloat(obj);
    }
    public static Integer getIntByNull (HashMap<?, ?> set, String key,int defaultValue) {
        if (key == null) {
            return null;
        }
        Object obj = set.get(key);
        if(obj==null) return null;
        return getInt(obj,defaultValue);
    }
    public static Integer getIntByNull (HashMap<?, ?> set, String key) {
        if (key == null) {
            return null;
        }
        Object obj = set.get(key);
        if(obj==null) return null;
        return getInt(obj);
    }
    public static Long getLongByNull (HashMap<?, ?> set, String key) {
        if (key == null) {
            return null;
        }
        Object obj = set.get(key);
        if(obj==null) return null;
        return getLong(obj);
    }

    public static float getFloat (HashMap<?, ?> set, String key, int defaultValue) {
        float value = getFloat(set, key);
        return value == defaultInt? defaultValue: value;
    }

    public static double getDouble (Object obj) {
        if ( obj != null ) {
            if (obj instanceof Integer) {
                return ((Integer)obj).intValue();
            }
            if (obj instanceof String) {
                return Float.parseFloat((String)obj);
            }
            if (obj instanceof Long) {
                return ((Long)obj).longValue();
            }
            if (obj instanceof Float) {
                return ((Float)obj).floatValue();
            }
            if (obj instanceof Double) {
                return ((Double)obj).doubleValue();
            }
            return 0;
        } else {
            return defaultInt;
        }
    }
    public static long getLong (Object obj) {
        try {
            if(obj != null){
                String str = String.valueOf(obj);
                return Long.valueOf(str);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultInt;
    }

    public static double getDouble (Object obj, double defaultValue) {
        if ( obj != null ) {
            if (obj instanceof Integer) {
                return ((Integer)obj).intValue();
            }
            if (obj instanceof String) {
                return Float.parseFloat((String)obj);
            }
            if (obj instanceof Long) {
                return ((Long)obj).longValue();
            }
            if (obj instanceof Float) {
                return ((Float)obj).floatValue();
            }
            if (obj instanceof Double) {
                return ((Double)obj).doubleValue();
            }
            return 0;
        } else {
            return defaultValue;
        }
    }


    //string section
    public static String getString (int a) {
        return a + "";
    }
    public static String getString (Object obj) {
        if(obj != null){
            return obj.toString();
        }
        return null;
    }
    public static String getString (HashMap<?, ?> set, String key) {
        if (key == null) {
            return null;
        }
        Object obj = set.get(key);
        if ( obj != null ){
            if(obj instanceof String){
                return  obj.toString();
            }
            if(obj instanceof Date){
                return  Parser.getString((Date)obj);
            }
            return String.valueOf(obj);
        }
        return null;
    }
    public static String getString (HashMap<?, ?> set, String key,String defaultValue) {
        if (key == null) {
            return defaultValue;
        }
        Object obj = set.get(key);
        if ( obj != null ){
            if(obj instanceof String){
                return  obj.toString();
            }
            if(obj instanceof Date){
                return  Parser.getString((Date)obj);
            }
            return String.valueOf(obj);
        }
        return defaultValue;
    }
    public static String getString (HashMap<?, ?> set, String key,DateType type) {
        if (key == null) {
            return null;
        }
        Object obj = set.get(key);
        if ( obj != null ){
            if(obj instanceof String){
                return  obj.toString();
            }
            if(obj instanceof Date){
                return  Parser.getString((Date)obj,type);
            }
            return String.valueOf(obj);
        }
        return null;
    }
    public static String getString (Date date) {
        if ( date != null )
            return DateType.formatFromDateType(DateType.Full).format(date);
        return null;
    }
    /**
     * 获取日期类型的object对象
     * @param date
     * @param type
     * @return
     */
    public static String getString (Object date, DateType type) {
        if ( date != null ){
            if(date instanceof Date){
                return DateType.formatFromDateType(type).format(date);
            }else{
                return String.valueOf(date);
            }
        }
        return null;
    }

    public static String getString (Date date, DateType type) {
        if ( date != null )
            return DateType.formatFromDateType(type).format(date);
        return null;
    }

    public static String getDayStr(Date date) {
        if (date != null)
            return DateType.formatFromDateType(DateType.Day).format(date);
        return null;
    }

    public static int length (String string) {
        return string == null? 0: string.length();
    }

    public static String replace(String strSource, String strFrom, String strTo) {
        if (strSource == null) {
            return null;
        }

        int i = 0;
        if ((i = strSource.indexOf(strFrom, i)) >= 0) {
            char[] cSrc = strSource.toCharArray();
            char[] cTo = strTo.toCharArray();
            int len = strFrom.length();
            StringBuffer buf = new StringBuffer(cSrc.length);
            buf.append(cSrc, 0, i).append(cTo);
            i += len;
            int j = i;
            while ((i = strSource.indexOf(strFrom, i)) > 0) {
                buf.append(cSrc, j, i - j).append(cTo);
                i += len;
                j = i;
            }
            buf.append(cSrc, j, cSrc.length - j);
            return buf.toString();
        }
        return strSource;
    }

    public static String urlEncode (String source) {
        return urlEncode(source, "utf-8");
    }

    public static String urlEncode (String source, String enc) {
        if (source == null || enc == null) {
            return source;
        }
        String encode = null;
        try {
            encode = URLEncoder.encode(source, enc);
            encode = replace(encode, "+", "%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {

        }
        return encode;
    }

    public static String urlDecode (String source) {
        return urlDecode(source, "utf-8");
    }

    public static String urlDecode (String source, String enc) {
        String decode = null;
        try {
            decode = URLDecoder.decode(source, enc);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {

        }
        return decode;
    }

    /**
     * 检查是否包含某个子项，如果父串为 null/""/"all" 都认为是全部
     * */
    public static boolean containElementIgnoreCase (String parent, Object sub) {
        return containElementIgnoreCase(parent, sub, true);
    }

    public static boolean containElementIgnoreCase (String parent, Object sub, boolean nullMeansAll) {
        if (sub == null || sub.toString() == null) {
            return false;
        }
        if (parent == null || parent.equals("")){
            return nullMeansAll;
        }
        if (parent.equalsIgnoreCase("all") || parent.equalsIgnoreCase("*")) {
            return true;
        }
        return ( "," + parent.toLowerCase() + ",")
                .indexOf("," + sub.toString().toLowerCase() + ",") > -1;
    }

    /**
     * 全角半角转换
     * */
    public static String qj2bj(String src) {
        if (src == null) {
            return src;
        }

        //char DBC_CHAR_START = 33; // 半角!

        /**
         * ASCII表中可见字符到~结束，偏移位值为126(Decimal)
         */
        //char DBC_CHAR_END = 126; // 半角~

        /**
         * 全角对应于ASCII表的可见字符从！开始，偏移值为65281
         */
        char SBC_CHAR_START = 65281; // 全角！

        /**
         * 全角对应于ASCII表的可见字符到～结束，偏移值为65374
         */
        char SBC_CHAR_END = 65374; // 全角～

        /**
         * ASCII表中除空格外的可见字符与对应的全角字符的相对偏移
         */
        int CONVERT_STEP = 65248; // 全角半角转换间隔

        /**
         * 全角空格的值，它没有遵从与ASCII的相对偏移，必须单独处理
         */
        char SBC_SPACE = 12288; // 全角空格 12288

        /**
         * 半角空格的值，在ASCII中为32(Decimal)
         */
        char DBC_SPACE = ' '; // 半角空格

        StringBuilder buf = new StringBuilder(src.length());
        char[] ca = src.toCharArray();
        for (int i = 0; i < src.length(); i++) {
            if (ca[i] >= SBC_CHAR_START && ca[i] <= SBC_CHAR_END) { // 如果位于全角！到全角～区间内
                buf.append((char) (ca[i] - CONVERT_STEP));
            } else if (ca[i] == SBC_SPACE) { // 如果是全角空格
                buf.append(DBC_SPACE);
            } else { // 不处理全角空格，全角！到全角～区间外的字符
                buf.append(ca[i]);
            }
        }
        return buf.toString();
    }
    /**
     * 转化为日期对象,支持Date,String,Long类型，其它类型返回空
     * @param obj
     * @return
     */
    public static Date getDate(Object obj){
        if(obj instanceof Date){
            return (Date)obj;
        }else if(obj instanceof String){
            try {
                return getDate((String)obj);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else if(obj instanceof Long){
            return new Date((Long)obj);
        }
        return null;
    }
    public static Date getDate (HashMap<?, ?> set, String key) {
        if (key == null) {
            return null;
        }
        Object obj = set.get(key);
        if ( obj != null ){
            if (obj instanceof String) {
                try {
                    return getDate((String)obj);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (obj instanceof Date) {
                return (Date)obj;
            } else if (obj instanceof Long) {
                return new Date(((Long)obj).longValue());
            }
        }
        return null;
    }

    /**
     * 返回当前日期的格式化字符串
     * @param type
     * @return
     */
    public static String getDate(DateType type){
        return DateType.formatFromDateType(type).format(new Date());
    }
    public static boolean getBool (Object obj) {
        if ( obj != null ) {
            if (obj instanceof Integer) {
                return ((Integer)obj).intValue() > 0;
            }
            if (obj instanceof String) {
                String str = (String)obj;
                if ( str != null && !str.equals("") ) {
                    if (str.compareToIgnoreCase("yes") == 0
                            || str.compareToIgnoreCase("true") == 0) {
                        return true;
                    }
                    if (str.compareToIgnoreCase("no") == 0
                            || str.compareToIgnoreCase("false") == 0) {
                        return false;
                    }
                    return getInt(str)>0;
                }
                return Boolean.parseBoolean(str);
            }
            if (obj instanceof Long) {
                return ((Long)obj).longValue() > 0;
            }
            if (obj instanceof Float) {
                return ((Float)obj).floatValue() > 0;
            }
            if (obj instanceof Double) {
                return ((Double)obj).doubleValue() > 0;
            }
            if (obj instanceof Boolean) {
                return ((Boolean)obj).booleanValue();
            }
        }

        return false;
    }

    public static Boolean getBoolean (HashMap<?, ?> set, String key) {
        if (key == null) {
            return null;
        }
        Object obj = set.get(key);
        if ( obj != null ) {
            return Boolean.valueOf(getBool(obj));
        }
        return null;
    }

    public static boolean getBool (HashMap<?, ?> set, String key) {
        if (key == null) {
            return false;
        }
        Object obj = set.get(key);
        if ( obj != null ) {
            return getBool(obj);
        }
        return false;
    }


    //hashmap section
    public static HashMap<String, Object> trimHashMap (HashMap<String, Object> set) {
        Iterator<Entry<String, Object>> it =  set.entrySet().iterator();
        while( it.hasNext() ) {
            Entry<String, Object> obj = it.next();
            Object value = obj.getValue();
            if (value == null) {
                it.remove();
                continue;
            }
            if (value instanceof Integer) {
                if ( ((Integer)value).intValue() == defaultInt ) {
                    it.remove();
                }
            }
        }
        return set;
    }

    /**
     * @param obj
     * @return
     * 转化为字符串，若obj为null，则返回""
     */
    public static String objToString(Object obj){
        String str = null;
        try {
            str = String.valueOf(obj);
        } catch (Exception e) {
        }
        return str;
    }

    /**
     * 从字符串中提取日期
     * @param dateStr
     * @return
     */
    public static String extractDateStr(String dateStr){
        Matcher m = Pattern.compile("(\\b\\d+)\\D*(\\d+)*\\D*(\\d+)*\\D*").matcher(dateStr);
        String date = "";
        while(m.find()){
            String y = m.group(1);
            String M = m.group(2);
            String d = m.group(3);
            if(M == null){
                M = "01";
            }else if(M.length()<2){
                M = "0"+M;
            }
            if(d == null){
                d = "01";
            }else if(d.length()<2){
                d = "0"+d;
            }
            date = y+"-"+M+"-"+d;
        }
        return date;
    }
    /**
     * 日期匹配 匹配两种格式 yyyy-MM-dd或者yyyy-MM-dd
     * @param dateStr
     * @return
     */
    private static Date getDate(String dateStr) throws Exception{
        if(dateStr == null ||"".equals(dateStr)){
            return null;
        }
        String regex = "\\d{4}-\\d{1,2}-\\d{1,2}( \\d{1,2}:\\d{1,2}:\\d{1,2})?";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(dateStr);
        if(m.find()){
            if(dateStr.length()>10){
                return DateType.formatFromDateType(DateType.Full).parse(dateStr);
            }else{
                return DateType.formatFromDateType(DateType.Day).parse(dateStr);
            }
        }
        return null;
    }

    public static Date getDate (String str, DateType type) {
        if (str == null) {
            return null;
        }
        try {
            return DateType.formatFromDateType(type).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static Date newDate (int year, int month, int day, int hour, int min, int sec) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day, hour, min, sec);
        return calendar.getTime();
    }
    private static DecimalFormat df = new DecimalFormat("####.##");
    public static Float formatNumber(Float f){
        if(f==null) return f;
        String fNum = df.format(f);
        return Float.valueOf(fNum);
    }
    public static Float formatNumber(Float f,String regex){
        if(f==null) return f;
        String fNum = new DecimalFormat(regex).format(f);
        return Float.valueOf(fNum);
    }
    public static Float formatIntNumber(Float f){
        if(f==null) return f;
        String fNum = new DecimalFormat("####").format(f);
        return Float.valueOf(fNum);
    }
    public static Float formatIntNumberByFloor(Float f){
        if(f==null) return f;
        double x = Math.floor(f);
        return Float.valueOf(String.valueOf(x));
    }
    /**
     * 价格没有负数
     * @param f
     * @return
     */
    public static Float formatSpecialPrice(Float f){
        if(f==null||f<0)return null;
        return Parser.formatNumber(f);
    }
    /**
     * 把小于0的数值转化为0
     * @param number
     * @return
     */
    public static Integer formatNumber(Integer number){
        if(number==null||number<0) return 0;
        return number;
    }
    /**
     * 集合转化为字符串,并且元素以split代表的字符为连接符
     * @param l
     * @param split
     * @return
     */
    public static String coltoStr(Collection<String> l,String split){
        if(l == null || l.size()==0) return "";
        if(split == null){
            split = ",";
        }
        StringBuilder sb = new StringBuilder();
        for(String str:l){
            sb.append(str).append(split);
        }
        sb = sb.deleteCharAt(sb.length()-(split.length()));
        return sb.toString();
    }

    public static Date getNextDate(int amount) {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, amount);
        return c.getTime();
    }

    /**
     * 根据日期获取星期 周一至周末 分别代表 1,2,..7
     * @param planDate
     * @return
     */
    public static int getWeek(String planDate){
        planDate = planDate.substring(0,10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(planDate);
        } catch (ParseException e) {
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        if(week == 1){
            return 7;
        }else{
            return week-1;
        }
    }

}
