package com.kt.Bean;

public class GoodsReceiptBean {
	private String id;
	private String name;
	private String address;
	private String phone;
	private String updateTime;
	private String userId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "GoodsReceiptBean [id=" + id + ", name=" + name + ", address="
				+ address + ", phone=" + phone + ", updateTime=" + updateTime
				+ ", userId=" + userId + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getPhone()=" + getPhone() + ", getUpdateTime()="
				+ getUpdateTime() + ", getUserId()=" + getUserId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
