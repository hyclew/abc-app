package com.kingteller.bs.domain.order;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessOrder {

	private Long id;
	
	private Long orderBaseId;
	
	private Long businessId;
	
	private String orderNumber;
	
	private Integer count;
	
	private Float totalCash;
	
	private String detailedAduit;
	
	private String status;
	
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getOrderBaseId() {
		return orderBaseId;
	}

	public void setOrderBaseId(Long orderBaseId) {
		this.orderBaseId = orderBaseId;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(Float totalCash) {
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "BusinessOrder [id=" + id + ", orderBaseId=" + orderBaseId
				+ ", businessId=" + businessId + ", orderNumber=" + orderNumber
				+ ", count=" + count + ", totalCash=" + totalCash
				+ ", detailedAduit=" + detailedAduit + ", status=" + status
				+ ", updateTime=" + updateTime + "]";
	}
	
}
