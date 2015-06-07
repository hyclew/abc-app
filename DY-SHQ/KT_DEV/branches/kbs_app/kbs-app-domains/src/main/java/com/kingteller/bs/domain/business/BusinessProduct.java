package com.kingteller.bs.domain.business;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessProduct {
	
    private Long id;

    private Long productCatalogueId;

    private Long productBaseId;
    
    private String businessName;

    private Integer numbers;

    private Float unitPrice;

    private String name;
    
    private String introduce;
    
    private Date publishTime;

    private Date updateTime;
    
    private String warmPrompt;
    
    private String prasie;
    
    private String status;
    
    private Float preferPrice;

    private Float salePrice;

    private Date saleStartTime;

    private Date saleOverTime;

    private Long businessId;

    private Long businessProductAduit;

    private String isSale;

    private Long resourceId;
    
    private String resourceIds;

    private String onSale;
    
    private Long order;
    
    private Long productId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductCatalogueId() {
		return productCatalogueId;
	}

	public void setProductCatalogueId(Long productCatalogueId) {
		this.productCatalogueId = productCatalogueId;
	}

	public Long getProductBaseId() {
		return productBaseId;
	}

	public void setProductBaseId(Long productBaseId) {
		this.productBaseId = productBaseId;
	}
	
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public Integer getNumbers() {
		return numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	public Float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
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

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public String getWarmPrompt() {
		return warmPrompt;
	}

	public void setWarmPrompt(String warmPrompt) {
		this.warmPrompt = warmPrompt;
	}
	
	public String getPrasie() {
		return prasie;
	}

	public void setPrasie(String prasie) {
		this.prasie = prasie;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getPreferPrice() {
		return preferPrice;
	}

	public void setPreferPrice(Float preferPrice) {
		this.preferPrice = preferPrice;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

	public Date getSaleStartTime() {
		return saleStartTime;
	}

	public void setSaleStartTime(Date saleStartTime) {
		this.saleStartTime = saleStartTime;
	}

	public Date getSaleOverTime() {
		return saleOverTime;
	}

	public void setSaleOverTime(Date saleOverTime) {
		this.saleOverTime = saleOverTime;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Long getBusinessProductAduit() {
		return businessProductAduit;
	}

	public void setBusinessProductAduit(Long businessProductAduit) {
		this.businessProductAduit = businessProductAduit;
	}

	public String getIsSale() {
		return isSale;
	}

	public void setIsSale(String isSale) {
		this.isSale = isSale;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}
	
	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getOnSale() {
		return onSale;
	}

	public void setOnSale(String onSale) {
		this.onSale = onSale;
	}
	
	public Long getOrder() {
		return order;
	}

	public void setOrder(Long order) {
		this.order = order;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "BusinessProduct [id=" + id + ", productCatalogueId="
				+ productCatalogueId + ", productBaseId=" + productBaseId
				+ ", businessName=" + businessName + ", numbers=" + numbers
				+ ", unitPrice=" + unitPrice + ", name=" + name
				+ ", introduce=" + introduce + ", publishTime=" + publishTime
				+ ", updateTime=" + updateTime + ", warmPrompt=" + warmPrompt
				+ ", prasie=" + prasie + ", status=" + status
				+ ", preferPrice=" + preferPrice + ", salePrice=" + salePrice
				+ ", saleStartTime=" + saleStartTime + ", saleOverTime="
				+ saleOverTime + ", businessId=" + businessId
				+ ", businessProductAduit=" + businessProductAduit
				+ ", isSale=" + isSale + ", resourceId=" + resourceId
				+ ", resourceIds=" + resourceIds + ", onSale=" + onSale
				+ ", order=" + order + ", productId=" + productId + "]";
	}
	
	
}