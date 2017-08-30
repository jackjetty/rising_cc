package com.bhyf.common.component;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.constants.user.LoginConstants;
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
	
	public Session getSession(){
		Subject currentSubject = SecurityUtils.getSubject();
		return currentSubject.getSession();
	}
	
	public SysUser getCurrentUser(){
		Subject currentSubject = SecurityUtils.getSubject();
		return (SysUser)currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
	}
	
}
