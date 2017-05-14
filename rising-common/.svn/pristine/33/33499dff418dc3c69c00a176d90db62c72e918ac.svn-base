package com.rising.common.util;

import org.apache.commons.lang.math.RandomUtils;

/**
 * 
 * <p>Title : RandomStrUtils</p>
 * <p>Description : 随机生成字符串</p>
 * <p>Company : 杭州冉思科技有限公司</p>
 * @author : caoyang
 * @date : 2016年3月31日 下午7:31:14
 */
public class RandomStrUtils {
	//26个字母+10个数字
	final static int maxNum = 36;
	
	final static char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k','l', 'm', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'n', 'o', 'p', 'q', 'r', 
			's', 't', 'u', 'v', 'w','x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
	
	/**
	 * 
	 * <p>Description : 随机生成指定字符串</p>
	 * @author : caoyang
	 * @date : 2016年3月31日 下午7:39:54
	 * @param length
	 * @return
	 */
	public static String genRandomStr(int length) {
		StringBuffer result = new StringBuffer();

		for (int i = 0; i < length; i++) {
			int num = RandomUtils.nextInt(maxNum);
			result.append(str[num]);
		}
		return result.toString();
		
	}
	
	public static void main(String[] args) {
		System.out.println(RandomStrUtils.genRandomStr(50));
	}
}
