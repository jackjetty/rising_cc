package com.bhyf.pojo.constants.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rising.common.util.Md5Util;
import org.apache.commons.collections.KeyValue;

import com.bhyf.pojo.dto.Attr;

/**
 * 
 * @description 登录相关常量
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月4日 上午8:56:58
 *
 */
public class LoginConstants {
	
	/** 登录用户 Session key */
	public final static String SESSION_USER_KEY = "_SESSION_USER_";
	
	public final static String SESSION_AUTHORIZE_PERMS_KEY = "_SESSION_AUTHORIZE_PERMS_";
	public final static String SESSION_AUTHORIZE_ROLES_KEY = "_SESSION_AUTHORIZE_ROLES_";
	
	/**
	 * 防止会话标识篡改问题
	 */
	public final static String SESSION_ID = "_SESSION_ID_";
	
	/**
	 * 初始密码
	 */
	public final static String INITIAL_PASSWORD = "123456";
	
	/**
	 * 初始密码MD5加密
	 */
	public final static String INITIAL_PASSWORD_MD5 = Md5Util.MD5("123456");
	
	/** 登录检查错误：用户名不存在 */
	public final static String LOGIN_CHECK_ERROR_UNKNOWN_USER_NAME = "-0001";
	/** 登录检查错误：用户名或密码错误 */
	public final static String LOGIN_CHECK_ERROR_PASSWORD = "-0002";
	/** 登录检查错误：用户已被锁定 */
	public final static String LOGIN_CHECK_ERROR_LOCK = "-0003";
	/** 登录检查错误：用户异常 */
	public final static String LOGIN_CHECK_ERROR_NULL = "-0004";
	/**用户名和密码不能为空*/
	public final static String LOGIN_CHECK_ERROR_ALL_NULL="-0005";
	/**验证码错误*/
	public final static String LOGIN_CHECK_ERROR_CAPTCHA="-0006";
	/**验证码为空*/
	public final static String LOGIN_CHECK_ERROR_NOTCAPTCHA="-0007";
	
	public final static List<KeyValue> LOGIN_CHECK_ERROR_LIST = new ArrayList<KeyValue>();
	public final static Map<String,String> LOGIN_CHECK_ERROR_MAP = new HashMap<String,String>();
	static {
		LOGIN_CHECK_ERROR_LIST.add(new Attr(LOGIN_CHECK_ERROR_UNKNOWN_USER_NAME, "用户名不存在"));
		LOGIN_CHECK_ERROR_LIST.add(new Attr(LOGIN_CHECK_ERROR_PASSWORD, "用户名或密码错误"));
		LOGIN_CHECK_ERROR_LIST.add(new Attr(LOGIN_CHECK_ERROR_LOCK, "用户已被锁定"));
		LOGIN_CHECK_ERROR_LIST.add(new Attr(LOGIN_CHECK_ERROR_NULL, "认证异常"));
		LOGIN_CHECK_ERROR_LIST.add(new Attr(LOGIN_CHECK_ERROR_ALL_NULL, "用户名和密码不能为空"));
		LOGIN_CHECK_ERROR_LIST.add(new Attr(LOGIN_CHECK_ERROR_CAPTCHA, "验证码错误"));
		LOGIN_CHECK_ERROR_LIST.add(new Attr(LOGIN_CHECK_ERROR_NOTCAPTCHA, "验证码错误"));
		
		LOGIN_CHECK_ERROR_MAP.put(LOGIN_CHECK_ERROR_UNKNOWN_USER_NAME,"用户名不存在");	
		LOGIN_CHECK_ERROR_MAP.put(LOGIN_CHECK_ERROR_PASSWORD,"用户名或密码错误");	
		LOGIN_CHECK_ERROR_MAP.put(LOGIN_CHECK_ERROR_LOCK,"用户已被锁定");	
		LOGIN_CHECK_ERROR_MAP.put(LOGIN_CHECK_ERROR_NULL,"用户异常");	
		LOGIN_CHECK_ERROR_MAP.put(LOGIN_CHECK_ERROR_ALL_NULL,"用户名和密码不能为空");	
		LOGIN_CHECK_ERROR_MAP.put(LOGIN_CHECK_ERROR_CAPTCHA,"验证码错误");	
		LOGIN_CHECK_ERROR_MAP.put(LOGIN_CHECK_ERROR_NOTCAPTCHA,"验证码错误");	
		
	}
	
}
