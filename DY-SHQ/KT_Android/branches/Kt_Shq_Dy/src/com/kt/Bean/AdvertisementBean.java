package com.kt.Bean;

public class AdvertisementBean {
	private String resourceId;
	private String productBaseId;
	private String businessId;
	private String startTime;
	private String endTime;
	private String updateTime;
	
	
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getProductBaseId() {
		return productBaseId;
	}
	public void setProductBaseId(String productBaseId) {
		this.productBaseId = productBaseId;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	@Override
	public String toString() {
		return "AdvertisementBean [resourceId=" + resourceId
				+ ", productBaseId=" + productBaseId + ", businessId="
				+ businessId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", updateTime=" + updateTime + ", getResourceId()="
				+ getResourceId() + ", getProductBaseId()="
				+ getProductBaseId() + ", getBusinessId()=" + getBusinessId()
				+ ", getStartTime()=" + getStartTime() + ", getEndTime()="
				+ getEndTime() + ", getUpdateTime()=" + getUpdateTime()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
