package com.rising.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Md5工具类
 * 
 */
public class Md5Util {
	static MessageDigest MD5 = null;//消息加密对象

	/**
	 * 静态代码块，初始化消息加密对象
	 */
	static {
		try {
			MD5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ne) {
			ne.printStackTrace();
		}
	}
	
	/**
	 * 对输入流获取md5字符值
	 * @return md5串
	 */
	public static String getMD5(InputStream inputStream) {
		try {
			byte[] buffer = new byte[8192];
			int length;
			while ((length = inputStream.read(buffer)) != -1) {
				MD5.update(buffer, 0, length);
			}
			return new String(Hex.encodeHex(MD5.digest()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 对一个文件获取md5字符值
	 * @return md5串
	 */
	public static String getMD5(File file) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
			return getMD5(fileInputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 求一个字符串的md5字符值
	 * @param target 字符串
	 * @return md5 value
	 */
	public static String MD5(String target) {
		return DigestUtils.md5Hex(target);
	}
	
	/**
	 * 求一个字符串的md5字符值
	 * @param target 字符串
	 * @return md5 value
	 */
	public static String MD5_16(String target) {
		return DigestUtils.md5Hex(target).substring(8, 24);
	}
	
	/**
	 * 求一个字符串数组的md5字符值
	 * @param targs 字符数组
	 * @return md5 value
	 */
	public static String MD5(String[] targs) {
    	StringBuilder sb = new StringBuilder(3);
    	for(int i = 0,len = targs.length;i < len;i++){
    		sb.append(targs[i]);
    	}
		return MD5(sb.toString());
	}
	
	public static void main(String[] args) {
		String a = MD5("cancel_direct_productorder_by_user322819");
		System.out.println(a);
	}
}