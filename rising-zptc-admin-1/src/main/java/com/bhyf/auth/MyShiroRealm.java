package com.bhyf.auth;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.constants.user.LoginConstants;
import com.bhyf.pojo.constants.user.UserConstants;
import com.bhyf.service.interf.perm.PermService;
import com.bhyf.service.interf.role.RoleService;
import com.bhyf.service.interf.user.UserService;

public class MyShiroRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

	@Resource
	private PermService permService;
	
	@Resource
	private RoleService roleService;
	
	@Resource
	private UserService userService;
	
	/**
	 * 获取授权信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.info("获取授权信息");
		String userName = (String) principals.fromRealm(getName()).iterator().next();
		if (StringUtils.isNotBlank(userName)) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			
			Subject currentSubject = SecurityUtils.getSubject();
			List<String> perms = (List<String>)currentSubject.getSession().getAttribute(LoginConstants.SESSION_AUTHORIZE_PERMS_KEY);
			List<String> roles = (List<String>)currentSubject.getSession().getAttribute(LoginConstants.SESSION_AUTHORIZE_ROLES_KEY);
			
			if(perms == null){
				perms = permService.findEnablePermUrlMd5ByUserName(userName);
				currentSubject.getSession().setAttribute(LoginConstants.SESSION_AUTHORIZE_PERMS_KEY,perms);
			}
			if(roles == null){
				roles = roleService.findAllRolesByUserName(userName);
				currentSubject.getSession().setAttribute(LoginConstants.SESSION_AUTHORIZE_ROLES_KEY,roles);
			}
			
			// 查询用户授权信息
			if (perms != null && !perms.isEmpty()) {
 				info.addStringPermissions(perms);
			}
			if (roles != null && !roles.isEmpty()) {
				info.addRoles(roles);
			}
			return info;
		}
		return null;
	}

	
	/**
	 * 获取认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		logger.info("获取认证信息");
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		// 通过表单接收的用户名
		String userName = token.getUsername();
		if (StringUtils.isNotBlank(userName)) {
			SysUser sysUser=userService.findSysUserByUserName(userName);
			if (sysUser != null) {
				if(sysUser.getStatus().equals(UserConstants.USER_DISABLE)){
					throw new LockedAccountException();
				}
				if(sysUser.getStatus().equals(UserConstants.USER_REMOVE)){
					throw new UnknownAccountException();
				}
				return new SimpleAuthenticationInfo(sysUser.getUserName(), sysUser.getUserPwd(), getName());
			}
		}
		return null;
	}
	
}