package com.kt.Bean;
import java.util.Date;


public class UserBase {

	private Long id;
	
	public String name;
	
	public String address;
	
	public String phone;
	
	private String telephone;
	
	private String status;
	
	private Date updateTime;
	
	private String userType;

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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserBase [id=" + id + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", telephone=" + telephone + ", status="
				+ status + ", updateTime=" + updateTime + ", userType="
				+ userType + "]";
	}
	
}
