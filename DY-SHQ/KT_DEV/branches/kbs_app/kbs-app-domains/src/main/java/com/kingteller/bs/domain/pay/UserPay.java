package com.kingteller.bs.domain.pay;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserPay {

	private Long id;
	
	private String payTool;
	
	private String cvv;
	
	private String status;
	
	private String name;
	
	private String phone;
	
	private String certificateType; //证件类型
	
	private String certificateNumber; //证件号码
	
	private Date updateTime;
	
	private Long userId;
	
	@Override
	public String toString() {
		return "UserPay [id=" + id + ", payTool=" + payTool + ", cvv=" + cvv
				+ ", status=" + status + ", name=" + name + ", phone=" + phone
				+ ", certificateType=" + certificateType
				+ ", certificateNumber=" + certificateNumber + ", updateTime="
				+ updateTime + ", userId=" + userId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayTool() {
		return payTool;
	}

	public void setPayTool(String payTool) {
		this.payTool = payTool;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	
	
}
