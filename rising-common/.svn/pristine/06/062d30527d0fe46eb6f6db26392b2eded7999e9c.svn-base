package com.rising.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * 时间工具类
 * 
 */
public class DateUtil {

	// 直接使用静态变量会导致线程不安全
//	public final static SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	public final static SimpleDateFormat DATE_TIME_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//	public final static SimpleDateFormat DATE_TIME_FORMAT3 = new SimpleDateFormat("yyyyMMddHHmmss");
//	public final static SimpleDateFormat DATE_TIME_FORMAT4 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//	public final static SimpleDateFormat DATE_TIME_FORMAT5 = new SimpleDateFormat("yyyy/MM/dd HH:mm");
//	public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
//	public final static SimpleDateFormat DATE_FORMAT2 = new SimpleDateFormat("yyyy-MM-dd");
//	public final static SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HHmmss");
	
	public final static SimpleDateFormat DATE_TIME_FORMAT(){return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");}
	public final static SimpleDateFormat DATE_TIME_FORMAT2(){return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");}
	public final static SimpleDateFormat DATE_TIME_FORMAT3(){return new SimpleDateFormat("yyyyMMddHHmmss");}
	public final static SimpleDateFormat DATE_TIME_FORMAT4(){return new SimpleDateFormat("yyyy-MM-dd HH:mm");}
	public final static SimpleDateFormat DATE_TIME_FORMAT5(){return new SimpleDateFormat("yyyy/MM/dd HH:mm");}
	public final static SimpleDateFormat DATE_FORMAT(){return new SimpleDateFormat("yyyyMMdd");}
	public final static SimpleDateFormat DATE_FORMAT2(){return new SimpleDateFormat("yyyy-MM-dd");}
	public final static SimpleDateFormat TIME_FORMAT(){return new SimpleDateFormat("HHmmss");}

	/**
	 * 将日期字符串转换为 零点开始的日期(Date)对象
	 * 
	 * @param dateStr		日期字符串(yyyy-MM-dd)
	 * @return
	 */
	public static Date dateStr2BeginDate(String dateStr) {
		if(StringUtils.isNotBlank(dateStr)){
			try {
				return DATE_TIME_FORMAT2().parse(dateStr + " 00:00:00.000");
			} catch (ParseException e) { }
		}
		return null;
	}
	
	/**
	 * 获取YYYY-MM-DD格式
	 * 
	 * @return
	 */
	public static String getDay() {
		return DATE_FORMAT().format(new Date());
	}

	/**
	 * 将日期字符串转换为 59分59秒999毫秒结束的日期(Date)对象
	 * 
	 * @param dateStr		日期字符串(yyyy-MM-dd)
	 * @return
	 */
	public static Date dateStr2EndDate(String dateStr) {
		if(StringUtils.isNotBlank(dateStr)){
			try {
				return DATE_TIME_FORMAT2().parse(dateStr + " 23:59:59.999");
			} catch (ParseException e) { }
		}
		return null;
	}

	public static Date parseDateTime(String dateStr){
		try {
			return DATE_TIME_FORMAT().parse(dateStr);
		} catch (Exception e) { }
		return null;
	}
	
	public static Date parseDate(String dateStr){
		try {
			return DATE_TIME_FORMAT2().parse(dateStr);
		} catch (Exception e) { }
		return null;
	}
	
	public static String formatDate(Date date) {
		if (date != null) {
			return DATE_FORMAT2().format(date);
		}
		return "";
	}
	
	public static String formatDateTime(Date date) {
		if (date != null) {
			return DATE_TIME_FORMAT().format(date);
		}
		return "";
	}
	
	public static String formatDateTime(Date date, String formatStr) {
		if (date != null) {
			if (!StringUtils.isBlank(formatStr)) {
				SimpleDateFormat format = new SimpleDateFormat(formatStr);
				return format.format(date);
			} else {
				return DATE_TIME_FORMAT().format(date);
			}
		}
		return "";
	}
	
	public static Date parseDateTime(String dateStr, String formatStr){
		if (dateStr != null) {
			if (!StringUtils.isBlank(formatStr)) {
				SimpleDateFormat format = new SimpleDateFormat(formatStr);
				try {
					return format.parse(dateStr);
				} catch (ParseException e) { }
			} else {
				try {
					return DATE_TIME_FORMAT().parse(dateStr);
				} catch (ParseException e) { }
			}
		}
		return null;
	}
	
	/**
	 * 格式化yyyyMMdd
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate2(String dateStr){
		try {
			if(StringUtils.isBlank(dateStr)){
				return null;
			}
			return DATE_FORMAT().parse(dateStr);
		} catch (ParseException e) { }
		return null;
	}
	
	/**
	 * 格式化yyyyMMddHHmmss
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate4(String dateStr){
		try {
			if(StringUtils.isBlank(dateStr)){
				return null;
			}
			return DATE_TIME_FORMAT3().parse(dateStr);
		} catch (ParseException e) { }
		return null;
	}
	
	/**
	 * 
	 * @方法功能说明：格式化yyyy-MM-dd HH:mm
	 * @修改者名字：tandeng
	 * @修改时间：2014年8月5日上午9:50:19
	 * @修改内容：
	 * @参数：@param dateStr
	 * @参数：@return
	 * @return:Date
	 * @throws
	 */
	public static Date parseDate5(String dateStr){
		try {
			if(StringUtils.isBlank(dateStr)){
				return null;
			}
			return DATE_TIME_FORMAT4().parse(dateStr);
		} catch (ParseException e) { }
		return null;
	}
	/**
	 * 
	 * @方法功能说明：格式化yyyy/MM/dd HH:mm
	 * @修改者名字：tandeng
	 * @修改时间：2014年8月5日上午9:50:19
	 * @修改内容：
	 * @参数：@param dateStr
	 * @参数：@return
	 * @return:Date
	 * @throws
	 */
	public static Date parseDate6(String dateStr){
		try {
			if(StringUtils.isBlank(dateStr)){
				return null;
			}
			return DATE_TIME_FORMAT5().parse(dateStr);
		} catch (ParseException e) { }
		return null;
	}
	
	/**
	 * YYYY-MM-DD
	 * @param dateStr
	 * @return
	 */
	public static Date parseDate3(String dateStr){
		try {
			return DATE_FORMAT2().parse(dateStr);
		} catch (ParseException e) { }
		return null;
	}
	
	/**
	 * HHmmss
	 * @param timeStr
	 * @return
	 */
	public static Date parseTime(String timeStr){
		try {
			return TIME_FORMAT().parse(timeStr);
		} catch (ParseException e) { }
		return null;
	}
	
	/**
	 * @方法功能说明: 检查 时间/日期 字符串格式 
	 * @param date
	 * @param form，默认为‘yyyy-MM-dd’
	 * @return
	 */
	public static boolean checkDate(String date,String form){
		if(StringUtils.isBlank(date))
			return false;
		
		ParsePosition pos = new ParsePosition(0);
		DateFormat format = null;
		if(StringUtils.isBlank(form))
			format = new SimpleDateFormat("yyyy-MM-dd");
		else
			format = new SimpleDateFormat(form);
		//严格解析时间格式
		format.setLenient(false);
		
		if(null == format.parse(date,pos))
			return false;
		//如果开始索引不相等的话
		if(pos.getErrorIndex() > 0 || pos.getIndex() != date.length())
			return false;
		return true;
	}
	
	/**
	 * 日期比较
	 * @param baseDate 相比较日期的基准，可以为null，如果为null则和当前日期比较
	 * @param reqDate 需要比较的日期，不能为null
	 * @return 大于基准日期则返回true,否则返回false
	 */
	public static boolean dateCompare(Date baseDate, Date reqDate) {
		boolean theFlag = false;
		// if baseDate is null,set current date to baseDate
		if (baseDate == null) {
			baseDate = new Date();
		}
		if (reqDate.getTime() > baseDate.getTime()) {
			theFlag = true;
		}
		return theFlag;
	}

	/**
	 * 日期比较
	 * @param baseDate 相比较日期的基准，可以为null或空，如果为null则和当前日期比较
	 * @param reqDate 需要比较的日期，不能为null或空
	 * @return 大于基准日期则返回true,否则返回false
	 */
	public static boolean dateCompare(String baseDate, String reqDate) {
		Date bDate = null;
		Date rDate;
		if (baseDate == null || baseDate.trim().equals("")) {
			bDate = new Date();
		} else {
			bDate = parseDate3(baseDate);
		}
		rDate = parseDate3(reqDate);
		return dateCompare(bDate, rDate);
	}
	
	/**
	 * 计算日期的天数差
	 * <br>格式“YYYY-MM-DD”的字符，结束日期减去开始日期的天数，相等返回零
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int dateDiff(String dateStart, String dateEnd) throws Exception {
		int days = 0;
		
		if(!checkDate(dateStart,null) || !checkDate(dateEnd,null))
			return days;
		try {
			Date dStart = parseDate3(dateStart);
			Date dEnd = parseDate3(dateEnd);
//			long diff = Math.abs(dEnd.getTime() - dStart.getTime());
			// modify by yzs 去掉绝对值
			long diff = dEnd.getTime() - dStart.getTime();
			days = (int) (diff / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
			throw new Exception("获取日期之间的天数", e);
		}
		return days;
	}
	
	/**
	 * 计算日期的天数差
	 * <br>结束日期减去开始日期的天数，相等返回零
	 * @param dateStart
	 * @param dateEnd
	 * @return
	 */
	public static int dateDiff(Date dateStart,Date dateEnd) throws Exception {
		int days = 0;
		
		if(null == dateStart || null == dateEnd)
			return days;
		try {
			Date dStart =  DateUtils.truncate(dateStart,Calendar.DAY_OF_MONTH);
			Date dEnd =  DateUtils.truncate(dateEnd,Calendar.DAY_OF_MONTH);
//			long diff = Math.abs(dEnd.getTime() - dStart.getTime());
			// modify by yzs 去掉绝对值
			long diff = dEnd.getTime() - dStart.getTime();
			days = (int) (diff / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
			throw new Exception("获取日期之间的天数", e);
		}
		return days;
	}
	
}