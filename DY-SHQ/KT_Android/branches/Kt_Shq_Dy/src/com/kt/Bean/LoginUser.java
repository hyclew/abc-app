package com.kt.Bean;

import java.util.Date;


public class LoginUser {

	private Long id;
	
	private Long userId;
	
	private Long businessId;
	
	private String status;
	
	private Date updateTime;
	
	private String online;
	
	public String username;
	
	public String password;
	
	public String confirmPassword;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getOnline() {
		return online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "LoginUser [id=" + id + ", userId=" + userId + ", businessId="
				+ businessId + ", status=" + status + ", updateTime="
				+ updateTime + ", online=" + online + ", username=" + username
				+ ", password=" + password + ", confirmPassword="
				+ confirmPassword + ", getId()=" + getId() + ", getUserId()="
				+ getUserId() + ", getBusinessId()=" + getBusinessId()
				+ ", getStatus()=" + getStatus() + ", getUpdateTime()="
				+ getUpdateTime() + ", getOnline()=" + getOnline()
				+ ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getConfirmPassword()="
				+ getConfirmPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
