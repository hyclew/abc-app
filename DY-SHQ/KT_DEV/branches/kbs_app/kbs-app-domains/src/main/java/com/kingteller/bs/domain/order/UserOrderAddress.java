package com.kingteller.bs.domain.order;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 用户订单地址信息
 * @author wangyafei
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserOrderAddress {

	private Long id;
	
	private String name; //收货人姓名
	
	private String address; //收货人地址
	
	private String phone; //收货人电话
	
	private Date updateTime;
	
	private Long userId;
	
	private String addressType;
	
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
	
	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserOrderAddress [id=" + id + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", updateTime=" + updateTime
				+ ", userId=" + userId + ", addressType=" + addressType
				+ ", status=" + status + "]";
	}
}
