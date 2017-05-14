package com.rising.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5HashUtil {
	private static final char[] HEX = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String toHexString(byte[] bytes) {
        int length = bytes.length;
        StringBuffer sb = new StringBuffer(length * 2);
        int x = 0;
        int n1 = 0, n2 = 0;
        for(int i=0; i<length; i++) {
            if(bytes[i]>=0){
                x = bytes[i];
            }else{
                x= 256 + bytes[i];
            }
	            n1 = x >> 4;
	        n2 = x & 0x0f;
	        sb = sb.append(HEX[n1]);
	        sb = sb.append(HEX[n2]);
        }
        return sb.toString();
    }

    /**
     * Make MD5 diaguest.
     * 
     * @param str Original String.
     * @return MD5-String.
     */
    public static String toMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buf;
			try {
				buf = md.digest(str.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				buf = md.digest(str.getBytes());
			}
            return toHexString(buf);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
