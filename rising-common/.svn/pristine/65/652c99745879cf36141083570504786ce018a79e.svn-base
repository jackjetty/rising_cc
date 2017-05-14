package com.rising.common.component;

import com.rising.common.page.Pagination;

public class BaseController {
	public Pagination createPagination(PaginQo paginQo, BaseQo qo) {
		paginQo = paginQo == null ?new PaginQo() : paginQo;
		Pagination pagination = new Pagination();
		pagination.setPageNo(paginQo.getPageNo());
		pagination.setPageSize(paginQo.getPageSize());
		pagination.setCondition(qo);
		return pagination;
	}

}
