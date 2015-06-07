package com.kingteller.bs.domain;

public class Mail {
	/**
	 * 发件人
	 */
	private String from;
	
	/**
	 * 收件人
	 */
	private String to;
	
	private String subject;
	
	private String content;
	
	private String templateName;
	/**
	 * 是否需要身份验证
	 */
	private boolean validate = false;
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
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
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
}

