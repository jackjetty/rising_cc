package com.bhyf.controller.login;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rising.common.util.UUIDGenerator;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.bhyf.auth.CaptchaUsernamePasswordToken;
import com.bhyf.model.user.SysUser;
import com.bhyf.pojo.constants.user.LoginConstants;
import com.bhyf.pojo.exception.auth.WrongCaptchaException;
import com.bhyf.service.interf.perm.PermService;
import com.bhyf.service.interf.user.UserService;

@Controller
public class LoginController extends FormAuthenticationFilter{
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	
	@Resource
	private UserService userService;
	
	@Resource
	private PermService permService;
	
	/**
	 * 
	 * @description 去登录
	 * @author caoy
	 * @date 2015年8月4日 上午10:58:37
	 * @param session
	 * @param request
	 * @param model
	 * @param errorCode
	 * @param userName
	 * @param userPwd
	 * @param captcha
	 * @return
	 */
    @RequestMapping(value="/login")  
    public String login(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam(required=false) String errorCode,
			@RequestParam(value="userName", required=false) String userName,
			@RequestParam(value = "userPwd", required = false) String userPwd,
			@RequestParam(value = "captcha", required = false) String captcha,
			@RequestParam(value = "num", required = false) Integer num) {  
        
    	if(StringUtils.isNotBlank(errorCode)){
    		model.addAttribute("message", LoginConstants.LOGIN_CHECK_ERROR_MAP.get(errorCode));
    		model.addAttribute("userName", userName);
    	}
    	num = (num==null ? 0 : num)+1;
    	model.addAttribute("num", num);
    	return "login.html";  
    }
    
    
    
    
	/**
	 * 
	 * @description 登录表单校验
	 * @author caoy
	 * @date 2015年8月4日 上午10:58:22
	 * @param request
	 * @param response
	 * @param model
	 * @param userName
	 * @param userPwd
	 * @param captcha
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/login/check")
	public RedirectView loginCheck(HttpServletRequest request, HttpServletResponse response, Model model, 
			@RequestParam(value="userName", required=false) String userName,
			@RequestParam(value = "userPwd", required = false) String userPwd,
			@RequestParam(value = "captcha", required = false) String captcha)
			throws IOException {
		Subject currentSubject = SecurityUtils.getSubject();
		
		String host=getHost(request);
		if(StringUtils.isBlank(captcha)) {
			model.addAttribute("error", LoginConstants.LOGIN_CHECK_ERROR_NOTCAPTCHA);
			return new RedirectView("/login", true);
		}

		
		CaptchaUsernamePasswordToken upt=
				new CaptchaUsernamePasswordToken(userName, 
						userPwd, false, host, captcha);
		
		boolean bool = false;
		
		try {
			
			upt.sessionIdIsNoUpdated();//会话标示未更新解决
			
			/*图形验证码验证*/  
			upt.doCaptchaValidate(request, upt);
			
			//验证用户名密码
			currentSubject.login(upt);
		} catch (WrongCaptchaException we) {
			bool = true;
			we.printStackTrace();
			model.addAttribute("errorCode", LoginConstants.LOGIN_CHECK_ERROR_CAPTCHA);
		} catch (UnknownAccountException uae) {
			bool = true;
			model.addAttribute("errorCode", LoginConstants.LOGIN_CHECK_ERROR_UNKNOWN_USER_NAME);
		} catch (IncorrectCredentialsException ice) {
			bool = true;
			model.addAttribute("errorCode", LoginConstants.LOGIN_CHECK_ERROR_PASSWORD);
		} catch (LockedAccountException lae) {
			bool = true;
			model.addAttribute("errorCode", LoginConstants.LOGIN_CHECK_ERROR_LOCK);
		} catch (AuthenticationException ae) {
			bool = true;
			ae.printStackTrace();
			model.addAttribute("errorCode", LoginConstants.LOGIN_CHECK_ERROR_NULL);
		}
		
		if(bool){
			model.addAttribute("userName", userName);
			model.addAttribute("num", 1);
			return new RedirectView("/login", true);
		}


		SysUser sysUser = userService.findSysUserByUserName(userName);
		
		currentSubject.getSession().setAttribute(LoginConstants.SESSION_USER_KEY, sysUser);
		currentSubject.getSession().setAttribute(LoginConstants.SESSION_ID, UUIDGenerator.getUUID());
		
		return new RedirectView("/index", true);
	}
    
	
	/**
	 * 
	 * @description 验证验证码是否正确
	 * @author caoy
	 * @date 2015年11月18日 上午10:25:39
	 * @param request
	 * @param captcha
	 * @return
	 */
	@RequestMapping(value="/captcha/check")
	@ResponseBody
	public String captchaCheck(HttpServletRequest request, 
			@RequestParam(value = "captcha", required = false) String captcha){
		
		try {
			CaptchaUsernamePasswordToken upt=
					new CaptchaUsernamePasswordToken();
			upt.setCaptcha(captcha);
			
			/*图形验证码验证*/  
			upt.doCaptchaValidate(request, upt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return "error";
		}
		
		return "success";
	}
	
	/**
	 * 
	 * @description 登出
	 * @author caoy
	 * @date 2015年8月11日 上午10:14:47
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping(value="/logout")
	public RedirectView logout(HttpServletRequest request, HttpServletResponse response,Model model) throws IOException{
		Subject currentSubject = SecurityUtils.getSubject();
		currentSubject.logout();
		currentSubject.getSession().removeAttribute(LoginConstants.SESSION_USER_KEY);
        return new RedirectView("/login", true);
	}
	
	@RequestMapping("/login/not_perm")
	public String toNotPerm(HttpServletRequest request, HttpServletResponse response,Model model){
//		String menuHtml = permService.createBootstrapMenuByUserName();
//		model.addAttribute("menuHtml", menuHtml);
		return "/auth/not_perm.html";
	}
    
}
