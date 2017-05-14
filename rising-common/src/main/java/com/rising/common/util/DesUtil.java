package com.rising.common.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DesUtil {  
    private static byte[] iv = {1,2,3,4,5,6,7,8};  
    public static String encryptDES(String encryptString, String encryptKey) throws Exception {  
//      IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);  
        IvParameterSpec zeroIv = new IvParameterSpec(iv);  
        SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");  
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");  
        cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);  
        byte[] encryptedData = cipher.doFinal(encryptString.getBytes());  
       
        return Base64Utils.Base64Encode(encryptedData);  
    }  
    public static String decryptDES(String decryptString, String decryptKey) throws Exception {  
        byte[] byteMi = Base64Utils.Base64Decode(decryptString);  
        IvParameterSpec zeroIv = new IvParameterSpec(iv);  
//      IvParameterSpec zeroIv = new IvParameterSpec(new byte[8]);  
        SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");  
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");  
        cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);  
        byte decryptedData[] = cipher.doFinal(byteMi);  
       
        return new String(decryptedData);  
    }  
}  