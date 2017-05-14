package com.rising.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 字符校验工具类
 * 
 */
public class StringUtil {

	/**
	 * 检查IP串是否合法
	 * 
	 * @param ips
	 * @param limit
	 *            分隔符
	 * @return
	 */
	public static boolean checkIps(String ips, String limit) {
		Pattern pattern = Pattern
				.compile("^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])\\.){1,3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9]?[0-9])?$");
		boolean pass = false;
		String[] ipArray = ips.split(limit, 0);
		for (String ip : ipArray) {
			if (ip != null && ip.length() > 0) {
				if (pattern.matcher(ip).matches()) {
					pass = true;
				} else {
					pass = false;
					break;
				}
			}
		}
		return pass;
	}

	public static void main(String[] args) {
		System.out.println(checkMoney("1."));
	}

	/**
	 * 校验手机号码是否合法
	 * 
	 * @param mobile
	 * @return
	 */
	public static boolean checkMobile(String mobile) {
		Pattern pattern = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(mobile);
		return matcher.matches();
	}

	/**
	 * 校验是否全部为数字
	 * 
	 * @param numbers
	 * @return
	 */
	public static boolean checkNumber(String numbers) {
		Pattern pattern = Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence) numbers);
		return matcher.matches();
	}

	/**
	 * 校验邮箱是否合法
	 * 
	 * @param strEmail
	 * @return
	 */
	public static boolean checkEmail(String email) {
		String checkemail = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern pattern = Pattern.compile(checkemail);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * 校验金额，小数点后面只能保留两位
	 * 
	 * @param money
	 * @return
	 */
	public static boolean checkMoney(String money) {
		String checkMoney = "^(-)?(([1-9]{1}\\d*)|([0]{1}))(\\.(\\d){1,2})?$";
		Pattern pattern = Pattern.compile(checkMoney);
		Matcher matcher = pattern.matcher(money);
		return matcher.matches();
	}

	/**
	 * 显示消息页面
	 * 
	 * @param message
	 *            消息
	 * @param statusCode
	 *            状态码
	 * @param callbackType
	 *            执行完成后做什么? closeCurrent关闭弹出框
	 * @param navTabId
	 *            刷新页面rel名称
	 * @return
	 */
	// public static StringBuffer sendMessage(String message, String statusCode,
	// String callbackType, String navTabId) {
	// message = Native2AsciiUtils.native2Ascii(message);
	// StringBuffer sb = new StringBuffer("{");
	// sb.append("\"confirmMsg\":\"\",");
	// sb.append("\"forwardUrl\":\"\",");
	// sb.append("\"rel\":\"\",");
	// sb.append("\"navTabId\":\"" + navTabId + "\",");
	// sb.append("\"callbackType\":\"" + callbackType + "\",");
	// sb.append("\"statusCode\":\"" + statusCode + "\",");
	// sb.append("\"message\":\"" + message + "\"}");
	// return sb;
	// }

	/**
	 * 格式化日期时间
	 * 
	 * @param mydate
	 *            时间日期（String）
	 * @param isTime
	 *            是否格式化时间(是否格式化时间)true，false
	 * @return date类型的时间格式
	 */
	public static Date formatDate(String mydate, boolean isTime) {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sfDateTime = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		Date date = null;
		try {
			if (StringUtils.isBlank(mydate) == false) {
				if (isTime) {
					date = sfDateTime.parse(mydate);
					return date;
				} else {
					date = sfDate.parse(mydate);
					return date;
				}
			}
		} catch (ParseException e) {
			return date;
		}
		return date;
	}

	/**
	 * 格式化日期时间
	 * 
	 * @param myDateTime
	 *            （date类型）
	 * @param isTime
	 *            (是否格式化时间)true，false
	 * @return
	 */
	public static String getDateTime(Date myDateTime, boolean isTime) {
		SimpleDateFormat sfDate = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sfDateTime = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss");
		String date = null;
		try {
			if (myDateTime != null) {
				if (isTime) {
					date = sfDateTime.format(myDateTime);
				} else {
					date = sfDate.format(myDateTime);
				}
			}
		} catch (Exception e) {
			return date;
		}
		return date;
	}

	/**
	 * 获取时间戳加随机数的数字串
	 * 
	 * @return
	 */
	public static String getRandomName() {
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String formatDate = format.format(new Date());
		int random = new Random().nextInt(10000);
		return formatDate + random;
	}

	public static String hideEmail(String email) {
		return email;

	}

	public static String hideMobile(String email) {
		return email;

	}

	public static String hideName(String name) {
		String pre = "";
		for (int i = 1; i < name.length(); i++)
			pre += "*";
		name = pre + name.substring(name.length() - 1);
		return name;
	}
	
	public static List<String> splitToList(String str, String split) {
		if(StringUtils.isBlank(str))
			return null;
		
		String [] idArr = str.split(split);
		List<String> idList = new ArrayList<String>();
		for (int i = 0; i < idArr.length; i++) {
			String id = idArr[i];
			idList.add(id);
		}
		return idList;
	}
	
}
