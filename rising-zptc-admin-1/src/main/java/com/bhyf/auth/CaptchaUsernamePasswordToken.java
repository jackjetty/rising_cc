package com.bhyf.auth;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import com.bhyf.pojo.exception.auth.WrongCaptchaException;


/**
 * 
 * @description 验证码验证类
 * @company 碧海银帆
 * @author caoy
 * @date 2015年8月4日 上午8:50:41
 *
 */
@SuppressWarnings("serial")
public class CaptchaUsernamePasswordToken  extends UsernamePasswordToken {
	
	/**
	 * 验证码
	 */
    private String captcha; 
  
    public String getCaptcha() {  
    	return captcha;  
    }  
    
    public void setCaptcha(String captcha) {  
    	this.captcha = captcha;  
    }
    
	public CaptchaUsernamePasswordToken() {
		// TODO Auto-generated constructor stub
	}

    public CaptchaUsernamePasswordToken(String username, String password,  
    		 String captcha, boolean rememberMe) {  
    	super(username, password);  
    	this.captcha = captcha;  
    }  
    
    public CaptchaUsernamePasswordToken(String username, String password,  
            boolean rememberMe, String host, String captcha) {  
    	super(username, password);  
        //super(username, password, rememberMe, host);  
        this.captcha = captcha;  
    }  
    public CaptchaUsernamePasswordToken(String username, String password,  
            boolean rememberMe, String host) {  
        super(username, password, rememberMe, host);           
    }  
  

    /**
     * 
     * @description 校验验证码
     * @author caoy
     * @date 2015年8月4日 上午8:52:26
     * @param request
     * @param token
     */
    public void doCaptchaValidate(HttpServletRequest request,  
            CaptchaUsernamePasswordToken token) {  
    	
        String captcha = (String) request.getSession().getAttribute(  
                com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
        
        if(captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())){
    		throw new WrongCaptchaException("验证码错误！");
    	}
    }
    
    public void sessionIdIsNoUpdated(){
		Subject currentSubject = SecurityUtils.getSubject();//
		String captchaS = (String) currentSubject.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);  
		currentSubject.logout();
		currentSubject.getSession().setAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY, captchaS);
    }
    
    
}
