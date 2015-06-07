package com.kingteller.bs.domain.business;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessProductAduit {
    private Long id;

    private Long productId;

    private Long productCatalogueId;

    private String name;

    private String protocal;

    private String aduitStatus;

    private String attachmentUrl;

    private Date startTime;

    private Float unitprice;

    private Integer numbers;

    private Date updateTime;

    private String status;

    private Long businessId;

    private Date finishaduitTime;


	@Override
	public String toString() {
		return "BusinessProductAduit [id=" + id + ", productId=" + productId
				+ ", productCatalogueId=" + productCatalogueId + ", name="
				+ name + ", protocal=" + protocal + ", aduitStatus="
				+ aduitStatus + ", attachmentUrl=" + attachmentUrl
				+ ", startTime=" + startTime + ", unitprice=" + unitprice
				+ ", numbers=" + numbers + ", updateTime=" + updateTime
				+ ", status=" + status + ", businessId=" + businessId
				+ ", finishaduitTime=" + finishaduitTime + "]";
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getProductCatalogueId() {
		return productCatalogueId;
	}

	public void setProductCatalogueId(Long productCatalogueId) {
		this.productCatalogueId = productCatalogueId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProtocal() {
		return protocal;
	}

	public void setProtocal(String protocal) {
		this.protocal = protocal;
	}

	public String getAduitStatus() {
		return aduitStatus;
	}

	public void setAduitStatus(String aduitStatus) {
		this.aduitStatus = aduitStatus;
	}

	public String getAttachmentUrl() {
		return attachmentUrl;
	}

	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Float getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Float unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getNumbers() {
		return numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Date getFinishaduitTime() {
		return finishaduitTime;
	}

	public void setFinishaduitTime(Date finishaduitTime) {
		this.finishaduitTime = finishaduitTime;
	}

   
}