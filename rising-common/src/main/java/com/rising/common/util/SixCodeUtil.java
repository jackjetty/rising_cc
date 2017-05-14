package com.rising.common.util;



public class SixCodeUtil {
	 /**
     * 对key先进行MD5加密，然后6位与运算得到
     * @param key
     * @return
     */
    public static String[] ShortText(String key){     
        String[] chars = new String[]{          //要使用生成URL的字符   
            "a","b","c","d","e","f","g","h",   
            "i","j","k","l","m","n","o","p",   
            "q","r","s","t","u","v","w","x",   
            "y","z","0","1","2","3","4","5",   
            "6","7","8","9","A","B","C","D",   
            "E","F","G","H","I","J","K","L",   
            "M","N","O","P","Q","R","S","T",   
            "U","V","W","X","Y","Z"   
        };   
        //进行MD5加密，生成32位16进制编码
        String hex = Md5HashUtil.toMD5(key);   
        int hexLen = hex.length();   
        int subHexLen = hexLen / 8;   
        String[] ShortStr = new String[4];   
           
        for (int i = 0; i < subHexLen; i++) {   
            String outChars = "";   
            int j = i + 1;   
            String subHex = hex.substring(i * 8, j * 8);   
            long idx = Long.valueOf("3FFFFFFF", 16) & Long.valueOf(subHex, 16);   
               
            for (int k = 0; k < 6; k++) {   
            	//0000003d表示转化为2进制111101，任何值与这个值进行最大为111101，也就是61
                int index = (int) (Long.valueOf("0000003D", 16) & idx);   
                outChars += chars[index];   
                idx = idx >> 5;   
            }   
            ShortStr[i] = outChars;   
        }   
           
        return ShortStr;   
    }   
}
