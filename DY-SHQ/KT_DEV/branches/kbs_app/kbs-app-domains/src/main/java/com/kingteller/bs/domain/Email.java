package com.kingteller.bs.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 邮件模型
 * @author yinghui
 *
 */
public class Email implements Serializable {
	private static final long serialVersionUID = -1691945802197528171L;

	private String customerName;

	private String bizName;

	private String templateCode;// templateCode为空的话，直接发送message中的内容

	private String content;

	private String bizId;
	
	private String customerId;

	private Map<String, Object> context = new HashMap<String, Object>();

	private List<String> receiverList;

	private List<String> ccReceiverList;
	
	private List<EmailAttatchment> attatchmentList;
	
	private String subject;
	
	public List<String> getCcReceiverList() {
		return ccReceiverList;
	}

	public void setCcReceiverList(List<String> ccReceiverList) {
		this.ccReceiverList = ccReceiverList;
	}

	/**
	 * 添加内容
	 * @param name
	 * @param value
	 */
	public void addContext(String name, String value) {
		context.put(name, value);
	}	
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<EmailAttatchment> getAttatchmentList() {
		return attatchmentList;
	}

	public void setAttatchmentList(List<EmailAttatchment> attatchmentList) {
		this.attatchmentList = attatchmentList;
	}

	/**
	 * 添加附件
	 * @param attatchment
	 */
	public void addAttachment(EmailAttatchment attatchment) {
		if (attatchmentList == null) {
			attatchmentList = new ArrayList<EmailAttatchment>();
		}
		attatchmentList.add(attatchment);
	}
	
	
	public List<String> getReceiverList() {
		return receiverList;
	}	
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	

	/**
	 * 添加接收人
	 * @param receiver
	 */
	public void addReceiver(String receiver) {
		if (receiverList == null) {
			receiverList = new ArrayList<String>();
		}
		receiverList.add(receiver);
	}
	
	/**
	 * 添加抄送接收人
	 * @param ccReceiver
	 */
	public void addCcReceiver(String ccReceiver) {
		if (ccReceiverList == null) {
			ccReceiverList = new ArrayList<String>();
		}
		ccReceiverList.add(ccReceiver);
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}


	public Map<String, Object> getContext() {
		return context;
	}

	public void setContext(Map<String, Object> context) {
		this.context = context;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getTemplateCode() {
		return templateCode;
	}

	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

}
