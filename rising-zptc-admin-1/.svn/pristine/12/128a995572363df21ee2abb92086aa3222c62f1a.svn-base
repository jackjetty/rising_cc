package com.bhyf.filter;

import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.constants.user.LoginConstants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse resp,
						 FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse response = (HttpServletResponse) resp;
		if(hreq.getRequestURI().indexOf("/login")>-1//登录请求放过
				|| hreq.getRequestURI().indexOf("/logout")>-1//登出请求放过
				|| hreq.getRequestURI().indexOf("/kaptcha")>-1//验证码请求放过
				|| hreq.getRequestURI().indexOf("/resources")>-1//源数据放过
				|| hreq.getRequestURI().indexOf("/ueditor")>-1//源数据放过
				|| hreq.getRequestURI().indexOf("/upload")>-1//源数据放过
				|| hreq.getRequestURI().indexOf("/check")>-1//源数据放过
				|| hreq.getRequestURI().indexOf("/isalive")>-1){//监控请求放过
			chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request),
					response);
			return;
		}
		Subject currentSubject = SecurityUtils.getSubject();
		SysUser sysUser = (SysUser) currentSubject.getSession().getAttribute(LoginConstants.SESSION_USER_KEY);
		if(sysUser == null){
			response.sendRedirect("/rising-zptc-admin/logout");
		}
		chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request),
				response);
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
