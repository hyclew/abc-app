package com.kt.Bean;

public class BusinessProduct {
	private String id;
	private String productCatalogueId;
	private String businessName;
	private String numbers;
	private String unitPrice;
	private String name;
	private String introduce;
	private String warmPrompt;
	private String preferPrice;
	private String salePrice;
	private String businessId;
	private String resourceId;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductCatalogueId() {
		return productCatalogueId;
	}
	public void setProductCatalogueId(String productCatalogueId) {
		this.productCatalogueId = productCatalogueId;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getNumbers() {
		return numbers;
	}
	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}
	public String getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(String unitPrice) {
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
	public String getWarmPrompt() {
		return warmPrompt;
	}
	public void setWarmPrompt(String warmPrompt) {
		this.warmPrompt = warmPrompt;
	}
	public String getPreferPrice() {
		return preferPrice;
	}
	public void setPreferPrice(String preferPrice) {
		this.preferPrice = preferPrice;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getBusinessId() {
		return businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	@Override
	public String toString() {
		return "BusinessProduct [id=" + id + ", productCatalogueId="
				+ productCatalogueId + ", businessName=" + businessName
				+ ", numbers=" + numbers + ", unitPrice=" + unitPrice
				+ ", name=" + name + ", introduce=" + introduce
				+ ", warmPrompt=" + warmPrompt + ", preferPrice=" + preferPrice
				+ ", salePrice=" + salePrice + ", businessId=" + businessId
				+ ", resourceId=" + resourceId + ", getId()=" + getId()
				+ ", getProductCatalogueId()=" + getProductCatalogueId()
				+ ", getBusinessName()=" + getBusinessName()
				+ ", getNumbers()=" + getNumbers() + ", getUnitPrice()="
				+ getUnitPrice() + ", getName()=" + getName()
				+ ", getIntroduce()=" + getIntroduce() + ", getWarmPrompt()="
				+ getWarmPrompt() + ", getPreferPrice()=" + getPreferPrice()
				+ ", getSalePrice()=" + getSalePrice() + ", getBusinessId()="
				+ getBusinessId() + ", getResourceId()=" + getResourceId()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
}
