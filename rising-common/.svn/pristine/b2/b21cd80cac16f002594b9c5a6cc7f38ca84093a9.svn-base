package com.rising.common.page;

import org.apache.commons.lang.StringUtils;

public class PaginationConditionCacheUtils {

	/**
	 * 进行分页搜索筛选条件的缓存处理
	 * @param sessionId 
	 * @param sc			是否采用上一次的分页搜索筛选条件进行本次分页搜索 (1 采用)
	 * @param pageNo		当前页码(最小为第1页)
	 * @param pageSize 		每页条数
	 * @param paramName 	识别一个分页表单的独有缓存对象名称
	 * @param condition		本次分页搜索条件
	 * @param request		
	 * @return 
	 */
	public static Pagination initPaginationCondition(String sessionId, Integer sc,
			Integer pageNo, Integer pageSize, String paramName,
			Object condition) {
		Pagination pagination = new Pagination();
		pagination.setPageNo(pageNo);
		pagination.setPageSize(pageSize);
		pagination.setCondition(condition);
		
		if (StringUtils.isBlank(sessionId)) {
			return pagination;
		}
		
		
			Object[] conditions = new Object[3];
			conditions[0] = condition;
			conditions[1] = pageNo;
			conditions[2] = pageSize;

		return pagination;
	}
	
}
