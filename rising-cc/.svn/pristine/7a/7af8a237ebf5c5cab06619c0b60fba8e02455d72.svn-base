package com.rising.cc.auth;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import com.rising.common.util.Md5Util;

public class URLPermissionsFilter extends PermissionsAuthorizationFilter {

	@Override
	public boolean isAccessAllowed(ServletRequest request,
			ServletResponse response, Object mappedValue) throws IOException {
		
		String[] perms = new String[1];
		HttpServletRequest req = (HttpServletRequest) request;
		String oper = req.getParameter("oper");

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		if (StringUtils.isNotBlank(contextPath)) {
		    uri = uri.substring(contextPath.length()+1);
		}else{
			uri = uri.substring(1);
		}
		if (StringUtils.isNotBlank(oper)) {
			uri = uri + "?oper=" + oper;
		}
		
		perms[0] = Md5Util.MD5(uri);// path直接作为权限字符串
		
		return super.isAccessAllowed(request, response, perms);
	}

}