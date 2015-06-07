package com.kt.Bean;

public class LifeBean {
	private String id;
	private String businessName;
	private Double unitPrice;
	private String name;
	private String introduce;
	private Double salePrice;
	private Double publishTime;
	private int numbers;
	private Double preferPrice;
	private String resourceId;
	private String productId;
	public String maxid;
	
	public String getMaxid() {
		return maxid;
	}
	public void setMaxid(String maxid) {
		this.maxid = maxid;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public Double getPreferPrice() {
		return preferPrice;
	}
	public void setPreferPrice(Double preferPrice) {
		this.preferPrice = preferPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public Double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Double getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Double publishTime) {
		this.publishTime = publishTime;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public String getWarmPrompt() {
		return warmPrompt;
	}
	public void setWarmPrompt(String warmPrompt) {
		this.warmPrompt = warmPrompt;
	}
	private String warmPrompt;
	
	@Override
	public String toString() {
		return "LifeBean [id=" + id + ", businessName=" + businessName
				+ ", unitPrice=" + unitPrice + ", name=" + name
				+ ", introduce=" + introduce + ", salePrice=" + salePrice
				+ ", publishTime=" + publishTime + ", numbers=" + numbers
				+ ", preferPrice=" + preferPrice + ", resourceId=" + resourceId
				+ ", productId=" + productId + ", maxid=" + maxid
				+ ", warmPrompt=" + warmPrompt + ", getMaxid()=" + getMaxid()
				+ ", getProductId()=" + getProductId() + ", getResourceId()="
				+ getResourceId() + ", getPreferPrice()=" + getPreferPrice()
				+ ", getId()=" + getId() + ", getBusinessName()="
				+ getBusinessName() + ", getUnitPrice()=" + getUnitPrice()
				+ ", getName()=" + getName() + ", getIntroduce()="
				+ getIntroduce() + ", getSalePrice()=" + getSalePrice()
				+ ", getPublishTime()=" + getPublishTime() + ", getNumbers()="
				+ getNumbers() + ", getWarmPrompt()=" + getWarmPrompt()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
