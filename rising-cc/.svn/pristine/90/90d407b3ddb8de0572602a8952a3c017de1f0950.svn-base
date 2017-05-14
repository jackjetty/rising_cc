package com.rising.cc.util;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.rising.cc.pojo.command.mail.SendMailCommand;

//@Component
public class EmailSender {
	
	//@Resource
	private JavaMailSenderImpl javaMailSender;
	
	private static final String sendSourceMail = ConfigProperties.getInstance().get("sendEmail");
	
	public boolean sendEmail(SendMailCommand command){
		try {
			MimeMessage mailMessage = javaMailSender.createMimeMessage();
			
			//设置utf-8或GBK编码，否则邮件会有乱码  
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"utf-8");
			
			messageHelper.setTo(command.getTargetEmails());
			messageHelper.setFrom(sendSourceMail);
			messageHelper.setSubject(command.getSubject());// 主题
			
			// 邮件内容，注意加参数true，表示启用html格式
			messageHelper
					.setText(
							command.getContent(),
							command.isHtml() == null ? false : command.isHtml());
			
			javaMailSender.send(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			return false;
		}
		
		return true;
	}
	
}
