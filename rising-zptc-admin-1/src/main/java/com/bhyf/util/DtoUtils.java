package com.bhyf.util;

import com.alibaba.fastjson.JSON;

public class DtoUtils {
	public static <T> T dtoToEntity(Object object,Class<T> clazz){
		return JSON.parseObject(JSON.toJSONString(object), clazz);
	}
}
