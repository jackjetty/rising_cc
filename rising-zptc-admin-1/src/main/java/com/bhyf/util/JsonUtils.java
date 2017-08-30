package com.bhyf.util;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bhyf.model.perm.SysPermission;

/**
 * 
 * @description Json相关工具类
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月24日 下午4:03:37
 *
 */
public class JsonUtils {
	
	/**
	 * 
	 * @description 转换json数组为List<SysPermission>
	 * 数据格式为-->  [{"id":7,"children":[{"id":8},{"id":9},{"id":12},{"id":11},{"id":10}]},{"id":5},{"id":1,"children":[{"id":4},{"id":3,"children":[{"id":2}]}]}]
	 * @author caoy
	 * @date 2015年8月24日 下午4:13:46
	 * @param jsonArray
	 * @return
	 */
	public static List<SysPermission> JsonStringToSysPermissionList(String jsonArrayStr){
		
		JSONArray jsonArray = JSON.parseArray(jsonArrayStr);

		List<SysPermission> list = new ArrayList<SysPermission>();
		
		JsonStringToSysPermissionChildrenList(jsonArray, null, list);
		
		return list;
		
	}
	
	private static void  JsonStringToSysPermissionChildrenList(JSONArray jsonArray, Integer parentId, List<SysPermission> list){
		for (int i = 0; i < jsonArray.size(); i++) {
			SysPermission perm = new SysPermission();
			JSONObject jsonObj = jsonArray.getJSONObject(i);
			
			int id = jsonObj.getIntValue("id");
			
			perm.setId(id);
			perm.setSortNum(i);
			
			if(parentId != null){
				SysPermission parentPerm = new SysPermission();
				parentPerm.setId(parentId);
				perm.setParentSysPerm(parentPerm);
				
			}
			
			list.add(perm);
			
			if(null != jsonObj.get("children")){
				JsonStringToSysPermissionChildrenList(jsonObj.getJSONArray("children"), id, list);
			}
			
		}
	}
	
}
