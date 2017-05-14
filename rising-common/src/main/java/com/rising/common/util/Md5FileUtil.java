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

public class Md5FileUtil {

	static MessageDigest MD5 = null;

	static {
		try {
			MD5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ne) {
			ne.printStackTrace();
		}
	}
	
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
	 * 对一个文件获取md5值
	 * 
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
	 * 求一个字符串的md5值
	 * 
	 * @param target 字符串
	 * @return md5 value
	 */
	public static String MD5(String target) {
		return DigestUtils.md5Hex(target);
	}

	public static void main(String[] args) {

		File file=new File("C:\\Documents and Settings\\Administrator\\桌面\\新建文件夹");
		if(file.isFile()){
			System.out.println(getMD5(file));
		}else{
			File[] files=file.listFiles();
			for(File f:files){
				System.out.println(f.getName()+":"+getMD5(f));
			}
		}
	}
}