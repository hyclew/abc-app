package com.kt.Bean;

public class MyOrderBean {
	private String id;
	private String orderNumber;
	private String totalCash;
	private String totalNumbers;
	private String orderAduit;
	private String updateTime;
	private String detailedAduit;
	private String status;
	private String userBaseId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(String totalCash) {
		this.totalCash = totalCash;
	}
	public String getTotalNumbers() {
		return totalNumbers;
	}
	public void setTotalNumbers(String totalNumbers) {
		this.totalNumbers = totalNumbers;
	}
	public String getOrderAduit() {
		return orderAduit;
	}
	public void setOrderAduit(String orderAduit) {
		this.orderAduit = orderAduit;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getDetailedAduit() {
		return detailedAduit;
	}
	public void setDetailedAduit(String detailedAduit) {
		this.detailedAduit = detailedAduit;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserBaseId() {
		return userBaseId;
	}
	public void setUserBaseId(String userBaseId) {
		this.userBaseId = userBaseId;
	}
	@Override
	public String toString() {
		return "MyOrderBean [id=" + id + ", orderNumber=" + orderNumber
				+ ", totalCash=" + totalCash + ", totalNumbers=" + totalNumbers
				+ ", orderAduit=" + orderAduit + ", updateTime=" + updateTime
				+ ", detailedAduit=" + detailedAduit + ", status=" + status
				+ ", userBaseId=" + userBaseId + ", getId()=" + getId()
				+ ", getOrderNumber()=" + getOrderNumber()
				+ ", getTotalCash()=" + getTotalCash() + ", getTotalNumbers()="
				+ getTotalNumbers() + ", getOrderAduit()=" + getOrderAduit()
				+ ", getUpdateTime()=" + getUpdateTime()
				+ ", getDetailedAduit()=" + getDetailedAduit()
				+ ", getStatus()=" + getStatus() + ", getUserBaseId()="
				+ getUserBaseId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
}
