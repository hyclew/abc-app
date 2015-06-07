package com.kt.Bean;

public class BusinessOrder {
	private String id;
	private String orderBaseId;
	private String businessId;
	private String orderNumber;
	private String count;
	private String totalCash;
	private String detailedAduit;
	private String status;
	private String updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrderBaseId() {
		return orderBaseId;
	}
	public void setOrderBaseId(String orderBaseId) {
		this.orderBaseId = orderBaseId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getTotalCash() {
		return totalCash;
	}
	public void setTotalCash(String totalCash) {
		this.totalCash = totalCash;
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
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "BusinessOrder [id=" + id + ", orderBaseId=" + orderBaseId
				+ ", businessId=" + businessId + ", orderNumber=" + orderNumber
				+ ", count=" + count + ", totalCash=" + totalCash
				+ ", detailedAduit=" + detailedAduit + ", status=" + status
				+ ", updateTime=" + updateTime + ", getId()=" + getId()
				+ ", getOrderBaseId()=" + getOrderBaseId()
				+ ", getBusinessId()=" + getBusinessId()
				+ ", getOrderNumber()=" + getOrderNumber() + ", getCount()="
				+ getCount() + ", getTotalCash()=" + getTotalCash()
				+ ", getDetailedAduit()=" + getDetailedAduit()
				+ ", getStatus()=" + getStatus() + ", getUpdateTime()="
				+ getUpdateTime() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
