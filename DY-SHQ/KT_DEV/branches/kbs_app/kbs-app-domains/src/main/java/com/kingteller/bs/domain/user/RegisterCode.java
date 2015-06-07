package com.kingteller.bs.domain.user;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 注册验证码
 * @author wangyafei
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RegisterCode {

	private Long id;
	
	private String phone;
	
	private String checkCode;
	
	private Date updateTime;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCheckCode() {
		return checkCode;
	}

	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RegisterCode [id=" + id + ", phone=" + phone + ", checkCode="
				+ checkCode + ", updateTime=" + updateTime + ", status="
				+ status + "]";
	}
}
