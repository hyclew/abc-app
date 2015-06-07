package com.kt.Bean;

public class CustomerOrderDetailed {
	private String id;
	private String detailOrderNumber;
	private String customerOrderId;
	private String businessOrderId;
	private String businessProductId;
	private String userBaseId;
	private String preferPrice;
	private Double salePrice;
	private Double numbers;
	private Double total;
	private String status;
	private String updateTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDetailOrderNumber() {
		return detailOrderNumber;
	}
	public void setDetailOrderNumber(String detailOrderNumber) {
		this.detailOrderNumber = detailOrderNumber;
	}
	public String getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	public String getBusinessOrderId() {
		return businessOrderId;
	}
	public void setBusinessOrderId(String businessOrderId) {
		this.businessOrderId = businessOrderId;
	}
	public String getBusinessProductId() {
		return businessProductId;
	}
	public void setBusinessProductId(String businessProductId) {
		this.businessProductId = businessProductId;
	}
	public String getUserBaseId() {
		return userBaseId;
	}
	public void setUserBaseId(String userBaseId) {
		this.userBaseId = userBaseId;
	}
	public String getPreferPrice() {
		return preferPrice;
	}
	public void setPreferPrice(String preferPrice) {
		this.preferPrice = preferPrice;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getNumbers() {
		return numbers;
	}
	public void setNumbers(Double numbers) {
		this.numbers = numbers;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
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
		return "CustomerOrderDetailed [id=" + id + ", detailOrderNumber="
				+ detailOrderNumber + ", customerOrderId=" + customerOrderId
				+ ", businessOrderId=" + businessOrderId
				+ ", businessProductId=" + businessProductId + ", userBaseId="
				+ userBaseId + ", preferPrice=" + preferPrice + ", salePrice="
				+ salePrice + ", numbers=" + numbers + ", total=" + total
				+ ", status=" + status + ", updateTime=" + updateTime
				+ ", getId()=" + getId() + ", getDetailOrderNumber()="
				+ getDetailOrderNumber() + ", getCustomerOrderId()="
				+ getCustomerOrderId() + ", getBusinessOrderId()="
				+ getBusinessOrderId() + ", getBusinessProductId()="
				+ getBusinessProductId() + ", getUserBaseId()="
				+ getUserBaseId() + ", getPreferPrice()=" + getPreferPrice()
				+ ", getSalePrice()=" + getSalePrice() + ", getNumbers()="
				+ getNumbers() + ", getTotal()=" + getTotal()
				+ ", getStatus()=" + getStatus() + ", getUpdateTime()="
				+ getUpdateTime() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
