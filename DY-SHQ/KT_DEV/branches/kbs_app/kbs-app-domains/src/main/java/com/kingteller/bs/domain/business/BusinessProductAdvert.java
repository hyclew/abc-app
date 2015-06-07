package com.kingteller.bs.domain.business;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessProductAdvert {
	
    private Long id;

    private Long productBaseId;

    private Long businessId;

    private String troduce;

    private Long resourceId;

    private Date startTime;

    private Date endTime;

    private String status;

    private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductBaseId() {
		return productBaseId;
	}

	public void setProductBaseId(Long productBaseId) {
		this.productBaseId = productBaseId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getTroduce() {
		return troduce;
	}

	public void setTroduce(String troduce) {
		this.troduce = troduce;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	@Override
	public String toString() {
		return "BusinessProductAdvert [id=" + id + ", productBaseId="
				+ productBaseId + ", businessId=" + businessId + ", troduce="
				+ troduce + ", resourceId=" + resourceId + ", startTime="
				+ startTime + ", endTime=" + endTime + ", status=" + status
				+ ", updateTime=" + updateTime + "]";
	}

    
}