package com.bhyf.pojo.command.mail;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SendMailCommand implements Serializable{
	
	/**
	 * 目标接收者
	 */
	private String [] targetEmails;
	
	/**
	 * 邮件标题
	 */
	private String subject;
	
	/**
	 * 邮件内容
	 */
	private String content;
	
	/**
	 * 邮件内容是否是html
	 * true：是html
	 * false：非html
	 */
	private Boolean isHtml;
	
	public SendMailCommand() {
		
	}


	
	public SendMailCommand(String [] targetEmails,
			String subject, String content, Boolean isHtml) {
		super();
		this.targetEmails = targetEmails;
		this.subject = subject;
		this.content = content;
		this.isHtml = isHtml;
	}



	public Boolean isHtml() {
		return isHtml;
	}

	public void setHtml(Boolean isHtml) {
		this.isHtml = isHtml;
	}

	public String[] getTargetEmails() {
		return targetEmails;
	}

	public void setTargetEmails(String[] targetEmails) {
		this.targetEmails = targetEmails;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
