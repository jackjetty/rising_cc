package com.rising.common.util;

import org.apache.commons.lang.StringUtils;

public class PwdUtil {
	
	private final static String salt = "myschool";
	
	public static String getPwd(String orig) {
		return Md5FileUtil.MD5(Md5FileUtil.MD5(orig) + salt);
	}
	
	public static Boolean valiPwd(String orig, String cryp) {
		if (StringUtils.equals(getPwd(orig), cryp)) {
			return true;
		} else {
			return false;
		}
	}
}
