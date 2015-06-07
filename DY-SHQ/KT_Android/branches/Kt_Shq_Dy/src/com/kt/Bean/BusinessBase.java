package com.kt.Bean;

public class BusinessBase {
	private String id;
	private String name;
	private String address;
	private String status;
	private String updateTime;
	private String contractname;
	private String paytool;
	private String userid;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getContractname() {
		return contractname;
	}
	public void setContractname(String contractname) {
		this.contractname = contractname;
	}
	public String getPaytool() {
		return paytool;
	}
	public void setPaytool(String paytool) {
		this.paytool = paytool;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "BusinessBase [id=" + id + ", name=" + name + ", address="
				+ address + ", status=" + status + ", updateTime=" + updateTime
				+ ", contractname=" + contractname + ", paytool=" + paytool
				+ ", userid=" + userid + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getAddress()=" + getAddress()
				+ ", getStatus()=" + getStatus() + ", getUpdateTime()="
				+ getUpdateTime() + ", getContractname()=" + getContractname()
				+ ", getPaytool()=" + getPaytool() + ", getUserid()="
				+ getUserid() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
