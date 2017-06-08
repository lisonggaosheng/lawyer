package com.lawyer.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 日期时间操作工具类
 * 
 * @author zhangcd
 * 
 */
public final class DateTool {

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date();
	}

	/**
	 * 新建一个日期
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public static Date newDate(int year, int month, int day) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(year, month - 1, day);
		return c.getTime();
	}

	/**
	 * 新建一个日期
	 * 
	 * @param year
	 * @param month
	 * @param day
	 * @param hour
	 * @param minute
	 * @param second
	 * @return
	 */
	public static Date newDate(int year, int month, int day, int hour, int minute, int second) {
		Calendar c = Calendar.getInstance();
		c.clear();
		c.set(year, month - 1, day, hour, minute, second);
		return c.getTime();
	}

	/**
	 * 指定时间的小时开始
	 * 
	 * @param date
	 * @return ... HH:00:00.000
	 */
	public static Date hourBegin(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 指定时间的小时最后一毫秒
	 * 
	 * @param date
	 * @return ... HH:59:59.999
	 */
	public static Date hourEnd(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 获取指定时间的那天 00:00:00.000 的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date dayBegin(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 获取今天 00:00:00.000 的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date dayBegin() {
		return dayBegin(now());
	}

	/**
	 * 获取指定时间的那天 23:59:59.999 的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date dayEnd(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 获取今天 23:59:59.999 的时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date dayEnd() {
		return dayEnd(now());
	}

	/**
	 * 月首
	 * 
	 * @param date
	 * @return
	 */
	public static Date monthBegin(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 月末
	 * 
	 * @param date
	 * @return
	 */
	public static Date monthEnd(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 年首
	 * 
	 * @param date
	 * @return
	 */
	public static Date yearBegin(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_YEAR, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		return c.getTime();
	}

	/**
	 * 年末
	 * 
	 * @param date
	 * @return
	 */
	public static Date yearEnd(final Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_YEAR, c.getActualMaximum(Calendar.DAY_OF_YEAR));
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 999);
		return c.getTime();
	}

	/**
	 * 是否是指定日期
	 * 
	 * @param date
	 * @param day
	 * @return
	 */
	public static boolean isTheDay(final Date date, final Date day) {
		return date.getTime() >= DateTool.dayBegin(day).getTime() && date.getTime() <= DateTool.dayEnd(day).getTime();
	}

	/**
	 * 是否是今天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(final Date date) {
		return isTheDay(date, DateTool.now());
	}

	/**
	 * 增加、减少指定时数
	 * 
	 * @param date
	 * @param hour
	 *            要增加的时数（减少则为 负数）
	 * @return
	 */
	public static Date addHour(final Date date, int hour) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.HOUR, hour);
		return c.getTime();
	}

	/**
	 * 增加、减少指定天数
	 * 
	 * @param date
	 * @param day
	 *            要增加的天数（减少则为 负数）
	 * @return
	 */
	public static Date addDay(final Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, day);
		return c.getTime();
	}

	/**
	 * 增加、减少指定月数
	 * 
	 * @param date
	 * @param month
	 *            要增加的月数（减少则为 负数）
	 * @return
	 */
	public static Date addMonth(final Date date, int month) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.MONTH, month);
		return c.getTime();
	}

	/**
	 * 增加、减少指定年数
	 * 
	 * @param date
	 * @param year
	 *            要增加的年数（减少则为 负数）
	 * @return
	 */
	public static Date addYear(final Date date, int year) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.YEAR, year);
		return c.getTime();
	}

	/**
	 * 获取两个日期间的天数
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int amountDays(final Date startDate, final Date endDate) {
		long ms = endDate.getTime() - startDate.getTime();
		int ret = (int) (ms / 86400000L);
		return ret;
	}

	/**
	 * 获取两个日期间的月数（待改进）
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int amountMonths(final Date startDate, final Date endDate) {
		Calendar c1 = Calendar.getInstance(), c2 = Calendar.getInstance();
		boolean rev = false; // 翻转（是否 startDate > endDate）
		Date d1 = startDate, d2 = endDate;
		if (startDate.getTime() > endDate.getTime()) {
			rev = true;
			d1 = endDate;
			d2 = startDate;
		}
		c1.setTime(d1);
		c2.setTime(d2);
		int year1 = c1.get(Calendar.YEAR), year2 = c2.get(Calendar.YEAR), cy = year2 - year1; // count
																								// of
																								// year
		int month1 = c1.get(Calendar.MONTH), month2 = c2.get(Calendar.MONTH);
		int ret;
		if (cy > 0) {
			ret = (cy - 1) * 12;
			ret += month2;
			ret += (12 - month1);
		} else {
			ret = month2 - month1;
		}
		return rev ? (-1 * ret) : ret;
	}

	/**
	 * 获取两个日期间的年数（待改进）
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static int amountYears(final Date startDate, final Date endDate) {
		Calendar c = Calendar.getInstance();
		boolean rev = false; // 翻转（是否 startDate > endDate）
		Date d1 = startDate, d2 = endDate;
		if (startDate.getTime() > endDate.getTime()) {
			rev = true;
			d1 = endDate;
			d2 = startDate;
		}
		c.setTime(d1);
		int y1 = c.get(Calendar.YEAR);
		c.setTime(d2);
		int y2 = c.get(Calendar.YEAR);
		int ret = y2 - y1;
		return rev ? (-1 * ret) : ret;
	}

	/** yyyy-MM-dd HH:mm:ss */
	public static final int YMDHMS = 1;
	/** yyyy-MM-dd HH:mm */
	public static final int YMDHM = 2;
	/** yyyy-MM-dd HH */
	public static final int YMDH = 3;
	/** yyyy-MM-dd */
	public static final int YMD = 4;
	/** yyyy-MM */
	public static final int YM = 5;
	/** yyyy */
	public static final int Y = 6;

	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH");
	private static final SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
	private static final SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy-MM");
	private static final SimpleDateFormat sdf6 = new SimpleDateFormat("yyyy");

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @param date
	 * @return
	 */
	public static String toString(final Date date) {
		if (date == null)
			return "";
		return sdf1.format(date);
	}

	/**
	 * 转换到字符串
	 * 
	 * @param date
	 * @param type
	 *            DateUtils.YMDHMS : "yyyy-MM-dd HH:mm:ss", DateUtils.YMD :
	 *            "yyyy-MM-dd", DateUtils.YM : "yyyy-MM", DateUtils.Y : "yyyy"
	 * @return
	 */
	public static String toString(final Date date, int type) {
		if (date == null)
			return "null";
		switch (type) {
		case YMDHMS:
			return sdf1.format(date);
		case YMDHM:
			return sdf2.format(date);
		case YMDH:
			return sdf3.format(date);
		case YMD:
			return sdf4.format(date);
		case YM:
			return sdf5.format(date);
		case Y:
			return sdf6.format(date);
		}
		return "unknow";
	}

	/**
	 * 转换到字符串
	 * 
	 * @param date
	 * @param fmt
	 *            日期格式化字符串
	 * @return
	 */
	public static String toString(final Date date, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(date);
	}

	/**
	 * 从字符串解析为日期型
	 * 
	 * @param s
	 * @param fmt
	 * @return
	 */
	public static Date parse(final String s, final String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		try {
			return sdf.parse(s);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 从字符串(yyyy-MM-dd HH:mm:ss)解析为日期型
	 * 
	 * @param s
	 * @return
	 */
	public static Date parse(final String s) {
		try {
			return sdf1.parse(s);
		} catch (ParseException e) {
		}
		return null;
	}

	public static long parseLong(final String s, final String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		try {
			Date t = sdf.parse(s);
			return t == null ? 0L : t.getTime();
		} catch (ParseException e) {
		}
		return 0L;
	}

	public static long parseLong(final String s) {
		try {
			Date t = sdf1.parse(s);
			return t == null ? 0L : t.getTime();
		} catch (ParseException e) {
		}
		return 0L;
	}

	public static String getStartTime() {
		Calendar todayStart = Calendar.getInstance();
		todayStart.set(Calendar.DATE, todayStart.get(Calendar.DATE) - 1);
		todayStart.set(Calendar.HOUR_OF_DAY, 0);
		todayStart.set(Calendar.MINUTE, 0);
		todayStart.set(Calendar.SECOND, 0);
		todayStart.set(Calendar.MILLISECOND, 0);
		Date date = todayStart.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static String getEndTime() {
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);

		Date date = todayEnd.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static Map<String, String> getWeekDay() {
		Map<String, String> map = new HashMap<String, String>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
		map.put("monday", df.format(dayBegin(cal.getTime())));
		// 这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// 增加一个星期，才是我们中国人理解的本周日的日期
		cal.add(Calendar.WEEK_OF_YEAR, 1);
		map.put("sunday", df.format(dayEnd(cal.getTime())));
		return map;
	}

	public static Map<String, String> getWeekDay(Date date) {
		Map<String, String> map = new HashMap<String, String>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); // 获取本周一的日期
		map.put("monday", df.format(dayBegin(cal.getTime())));
		// 这种输出的是上个星期周日的日期，因为老外那边把周日当成第一天
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		// 增加一个星期，才是我们中国人理解的本周日的日期
		cal.add(Calendar.WEEK_OF_YEAR, 1);
		map.put("sunday", df.format(dayEnd(cal.getTime())));
		return map;
	}

	public static String getQu(String year, String data) {
		String q = "00";
		if ((year + "-01").equals(data)) {
			q = year + "-1";
		} else if ((year + "-04").equals(data)) {
			q = year + "-2";
		} else if ((year + "-07").equals(data)) {
			q = year + "-3";
		} else if ((year + "-10").equals(data)) {
			q = year + "-4";
		}
		return q;
	}

	/**
	 * 
	 * 1 第一季度 2 第二季度 3 第三季度 4 第四季度
	 * 
	 * @param date
	 * @return
	 */
	public static String getSeason(Date date) {

		int season = 0;

		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month = c.get(Calendar.MONTH);
		switch (month) {
		case Calendar.JANUARY:
		case Calendar.FEBRUARY:
		case Calendar.MARCH:
			season = 1;
			break;
		case Calendar.APRIL:
		case Calendar.MAY:
		case Calendar.JUNE:
			season = 2;
			break;
		case Calendar.JULY:
		case Calendar.AUGUST:
		case Calendar.SEPTEMBER:
			season = 3;
			break;
		case Calendar.OCTOBER:
		case Calendar.NOVEMBER:
		case Calendar.DECEMBER:
			season = 4;
			break;
		default:
			break;
		}
		return c.get(Calendar.YEAR) + "-Q" + season;
	}
	
	/** 
     * 取得季度第一天 
     *  
     * @param date 
     * @return 
     */  
    public static Date getFirstDateOfSeason(Date date) {  
        return monthBegin(getSeasonDate(date)[0]);  
    }  
  
    /** 
     * 取得季度最后一天 
     *  
     * @param date 
     * @return 
     */  
    public static Date getLastDateOfSeason(Date date) {  
        return monthEnd(getSeasonDate(date)[2]);  
    } 
    
    /** 
     * 取得季度月 
     *  
     * @param date 
     * @return 
     */  
    public static Date[] getSeasonDate(Date date) {  
        Date[] season = new Date[3];  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int nSeason =  Integer.valueOf(getSeasonForInt(date));  
        if (nSeason == 1) {// 第一季度  
            c.set(Calendar.MONTH, Calendar.JANUARY);  
            season[0] = c.getTime();  
            c.set(Calendar.MONTH, Calendar.FEBRUARY);  
            season[1] = c.getTime();  
            c.set(Calendar.MONTH, Calendar.MARCH);  
            season[2] = c.getTime();  
        } else if (nSeason == 2) {// 第二季度  
            c.set(Calendar.MONTH, Calendar.APRIL);  
            season[0] = c.getTime();  
            c.set(Calendar.MONTH, Calendar.MAY);  
            season[1] = c.getTime();  
            c.set(Calendar.MONTH, Calendar.JUNE);  
            season[2] = c.getTime();  
        } else if (nSeason == 3) {// 第三季度  
            c.set(Calendar.MONTH, Calendar.JULY);  
            season[0] = c.getTime();  
            c.set(Calendar.MONTH, Calendar.AUGUST);  
            season[1] = c.getTime();  
            c.set(Calendar.MONTH, Calendar.SEPTEMBER);  
            season[2] = c.getTime();  
        } else if (nSeason == 4) {// 第四季度  
            c.set(Calendar.MONTH, Calendar.OCTOBER);  
            season[0] = c.getTime();  
            c.set(Calendar.MONTH, Calendar.NOVEMBER);  
            season[1] = c.getTime();  
            c.set(Calendar.MONTH, Calendar.DECEMBER);  
            season[2] = c.getTime();  
        }  
        return season;  
    }  
    /** 
     *  
     * 1 第一季度 2 第二季度 3 第三季度 4 第四季度 
     *  
     * @param date 
     * @return 
     */  
    private static int getSeasonForInt(Date date) {  
        int season = 0;  
  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        case Calendar.MARCH:  
            season = 1;  
            break;  
        case Calendar.APRIL:  
        case Calendar.MAY:  
        case Calendar.JUNE:  
            season = 2;  
            break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        case Calendar.SEPTEMBER:  
            season = 3;  
            break;  
        case Calendar.OCTOBER:  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
            season = 4;  
            break;  
        default:  
            break;  
        }  
        return season;  
    }  

	/**
	 * 取得一年的第几周
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week_of_year = c.get(Calendar.WEEK_OF_YEAR);
		return c.get(Calendar.YEAR) + "-W" + week_of_year;
	}

	/**
	 * 取得一年的第几月
	 * 
	 * @param date
	 * @return
	 */
	public static String getMonthOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int month_of_year = c.get(Calendar.MONTH);
		return c.get(Calendar.YEAR) + "-M" + month_of_year;
	}

	/**
	 * 获取指定时间的那天上午十点的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String dayMorningTenBegin( Date date) {
		if(date == null){
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 10);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(c.getTime());
	}

	/**
	 * 获取指定时间的那天 下午十点的时间
	 * 
	 * @param date
	 * @return
	 */
	public static String dayAfternoonTenEnd(Date date) {
		if(date == null){
			date = new Date();
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.HOUR_OF_DAY, 22);
		c.set(Calendar.MINUTE, 30);
		c.set(Calendar.SECOND, 00);
		c.set(Calendar.MILLISECOND, 999);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(c.getTime());
	}

	/**
	 * 获取指定年份的周数
	 * 
	 * @param year
	 * @return
	 */
	public static String[] getWeeksInYear(int year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year + 1);
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 1);
		cal.add(Calendar.DAY_OF_MONTH, -(6 + cal.get(Calendar.DAY_OF_WEEK)));
		int weeks = cal.get(Calendar.WEEK_OF_YEAR);
		String[] days = new String[weeks];
		for (int i = weeks - 1; i >= 0; i--) {
			days[i] = String.format("%02d", i + 1);
		}
		return days;
	}

	/**
	 * 获取指定日期所在周的周一到周日日期
	 * 
	 * @param date
	 * @return
	 */
	public static List<String> getWeekDays(Date date) {
		List<String> dateStr = new ArrayList<String>();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		// 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
		int dayWeek = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		if (1 == dayWeek) {
			cal.add(Calendar.DAY_OF_WEEK, -1);
		}
		cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
		int day = cal.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
		cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值

		String imptime = null;// sdf.format(cal.getTime());
		for (int i = 0; i < 7; i++) {
			imptime = sdf.format(cal.getTime());
			dateStr.add(imptime);
			cal.add(Calendar.DATE, 1);
		}

		return dateStr;
	}
	
	/**
	 * 获取指定日期所在月的日期
	 * 
	 * @param date
	 * @return
	 */
	public static List<String> getMonthDays(Date date) {
		List<String> dateStr = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 设置时间格式
		
		Date monthBegin = monthBegin(date);
		Date monthEnd = monthEnd(date);
		Calendar calBegin = Calendar.getInstance();  
        // 使用给定的 Date 设置此 Calendar 的时间    
        calBegin.setTime(monthBegin);  
        Calendar calEnd = Calendar.getInstance();  
        // 使用给定的 Date 设置此 Calendar 的时间    
        calEnd.setTime(monthEnd);  
        while (calEnd.after(calBegin)) {  
        	String imptime = sdf.format(calBegin.getTime());
			dateStr.add(imptime);
        	
        	calBegin.add(Calendar.DAY_OF_MONTH, 1); 
        }
		return dateStr;
	}
	
	/**
	 * 获取指定时间内星期几所有日期
	 * @param dateFrom
	 * @param dateEnd
	 * @param weekDays
	 * @return
	 */
	public static Map<Integer,String> getQuarterWeekDates(String dateFrom,String dateEnd, String weekDays) {  
		Map<Integer,String> result = new HashMap<Integer,String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		
		long time = 1l;  
        long perDayMilSec = 24 * 60 * 60 * 1000;  
        
        //需要查询的星期系数  
        String strWeekNumber = weekForNum(weekDays);  
        try {  
            dateFrom = sdf.format(sdf.parse(dateFrom).getTime() - perDayMilSec);  
            while (true) {  
                    time = sdf.parse(dateFrom).getTime();  
                    time = time + perDayMilSec;  
                    Date date = new Date(time);  
                    dateFrom = sdf.format(date);  
                    if (dateFrom.compareTo(dateEnd) <= 0) {  
                        //查询的某一时间的星期系数  
                        Integer weekDay = dayForWeek(date);                      
                        //判断当期日期的星期系数是否是需要查询的  
                        if (strWeekNumber.indexOf(weekDay.toString())!=-1) {
                        	result.put(Parser.getInt(getWeekNumOfYear(date)) , dateFrom);
                        }  
                    } else {  
                        break;  
                    }  
            }  
        } catch (ParseException e1) {  
            e1.printStackTrace();  
        }  
        return result;  
    } 
	
	/**
	 * 取得一年的第几周
	 * 
	 * @param date
	 * @return
	 */
	private static int getWeekNumOfYear(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int week_of_year = c.get(Calendar.WEEK_OF_YEAR);
		return week_of_year;
	}
	//等到当期时间的周系数。星期日：7，星期一：1，星期二：2，星期三：3，星期四：4，星期五：5，星期六：6    
    public static Integer dayForWeek(Date date) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.setTime(date);  
        
        int day_of_week = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
         day_of_week = 7;
        return day_of_week;  
    } 
	/**  
     * 得到对应星期的系数 星期日：7，星期一：1，星期二：2，星期三：3，星期四：4，星期五：5，星期六：6    
     * @param weekDays 星期格式  星期一
     */  
    private static String weekForNum(String weekDays){  
        //返回结果为组合的星期系数  
        String weekNumber = "";  
        //解析传入的星期  
        if(weekDays.indexOf("|")!=-1){//多个星期数  
            String []strWeeks = weekDays.split("\\|");  
            for(int i=0;i<strWeeks.length;i++){  
                weekNumber = weekNumber + "" + getWeekNum(strWeeks[i]).toString();  
            }  
        }else{//一个星期数  
            weekNumber = getWeekNum(weekDays).toString();  
        }  
        return weekNumber;  
    }  
    //将星期转换为对应的系数  星期日：7，星期一：1，星期二：2，星期三：3，星期四：4，星期五：5，星期六：6  
    private static Integer getWeekNum(String strWeek){  
        Integer number = 1;//默认为星期日  
        if("星期一".equals(strWeek)){  
            number = 1;  
        }else if("星期二".equals(strWeek)){  
            number = 2;  
        }else if("星期三".equals(strWeek)){  
            number = 3;  
        }else if("星期四".equals(strWeek)){  
            number = 4;  
        }else if("星期五".equals(strWeek)){  
            number = 5;  
        }else if("星期六".equals(strWeek)){  
            number = 6;  
        }else if("星期日".equals(strWeek)){  
            number = 7;  
        }  
        return number;  
    }  
    
    public static Set<String> getHoursByTime(String startTime,String endTime){
    	Set<String> hours = new HashSet<String>();
    	Calendar startC = Calendar.getInstance();
    	startC.setTime(parse(startTime));
    	int startHour = startC.get(Calendar.HOUR_OF_DAY);
    	
    	Calendar endC = Calendar.getInstance();
    	endC.setTime(parse(endTime));
    	int endHour = endC.get(Calendar.HOUR_OF_DAY);
    	
    	for (int i = startHour; i <= endHour; i++) {
    		String hour = toString(parse(startTime), YMD)+" "+ i;
    		hours.add(hour);
		}
    	
    	return hours;
    }
    
    public static Set<String> getHalfHoursByTime(String startTime,String endTime){
    	Set<String> hours = new LinkedHashSet<String>();
    	Calendar startC = Calendar.getInstance();
    	startC.setTime(parse(startTime));
    	
    	Calendar endC = Calendar.getInstance();
    	endC.setTime(parse(endTime));
    	
    	while(startC.compareTo(endC) <= 0){
    		String hour = Parser.getString(startC.getTime());
    		hours.add(hour);
    		startC.add(Calendar.MINUTE, 30);
    	}
    	
    	return hours;
    }
    
    /** 
     * 判断时间是否在时间段内 
     *  
     * @param date 
     *            当前时间 yyyy-MM-dd HH:mm:ss 
     * @param strDateBegin 
     *            开始时间 00:00:00 
     * @param strDateEnd 
     *            结束时间 00:05:00 
     * @return 
     */  
    public static boolean isInDate(Date date, String strDateBegin,  
            String strDateEnd) {  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String strDate = sdf.format(date);  
        // 截取当前时间时分秒  
        int strDateH = Integer.parseInt(strDate.substring(11, 13));  
        int strDateM = Integer.parseInt(strDate.substring(14, 16));  
        int strDateS = Integer.parseInt(strDate.substring(17, 19));  
        // 截取开始时间时分秒  
        int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));  
        int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));  
        int strDateBeginS = Integer.parseInt(strDateBegin.substring(6, 8));  
        // 截取结束时间时分秒  
        int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));  
        int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));  
        int strDateEndS = Integer.parseInt(strDateEnd.substring(6, 8));  
        if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {  
            // 当前时间小时数在开始时间和结束时间小时数之间  
            if (strDateH > strDateBeginH && strDateH < strDateEndH) {  
                return true;  
                // 当前时间小时数等于开始时间小时数，分钟数在开始和结束之间  
            } else if (strDateH == strDateBeginH && strDateM >= strDateBeginM  
                    && strDateM <= strDateEndM) {  
                return true;  
                // 当前时间小时数等于开始时间小时数，分钟数等于开始时间分钟数，秒数在开始和结束之间  
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM  
                    && strDateS >= strDateBeginS && strDateS <= strDateEndS) {  
                return true;  
            }  
            // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数  
            else if (strDateH >= strDateBeginH && strDateH == strDateEndH  
                    && strDateM <= strDateEndM) {  
                return true;  
                // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数等于结束时间分钟数，秒数小等于结束时间秒数  
            } else if (strDateH >= strDateBeginH && strDateH == strDateEndH  
                    && strDateM == strDateEndM && strDateS <= strDateEndS) {  
                return true;  
            } else {  
                return false;  
            }  
        } else {  
            return false;  
        }  
    }  
    
    /** 
     * 获取两个时间段按照半小时划分集合
     * @param strDateBegin 
     *            开始时间 00:00:00 
     * @param strDateEnd 
     *            结束时间 00:05:00 
     * @return 
     */  
    public static List<String> getHalfHourList(String strDateBegin,  
            String strDateEnd) {  
    	List<String> timeList = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        
		try {
			Date endTime = sdf.parse(strDateEnd);
			Calendar endCal = Calendar.getInstance();
	        //使用给定的 Date 设置此 Calendar 的时间
			endCal.setTime(endTime);
			
			Date startTime = sdf.parse(strDateBegin);
			Calendar startCal = Calendar.getInstance();
	        //使用给定的 Date 设置此 Calendar 的时间
	        startCal.setTime(startTime);
	        timeList.add(sdf.format(startCal.getTime()));
	        while(true){
	        	if(startCal.after(endCal) || startCal.equals(endCal)){
		        	break;
		        }
	        	startCal.add(Calendar.MINUTE, 30);
	        	timeList.add(sdf.format(startCal.getTime()));
	        }
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
        
        return timeList;
    }  
    

	public static void main(String[] args) {
	}

}
