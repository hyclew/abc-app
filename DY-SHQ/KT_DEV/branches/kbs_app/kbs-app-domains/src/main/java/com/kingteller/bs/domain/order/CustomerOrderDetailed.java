package com.kingteller.bs.domain.order;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 用户订单详细信息
 * @author wangyafei
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CustomerOrderDetailed {
	
    private Long id;
    
    private String detailOrderNumber;

    private Long customerOrderId;
    
    private Long businessOrderId;

    private Long businessProductId;
    
    private Long userBaseId;

    private Float preferPrice;
    
    private Float salePrice;

    private Integer numbers;

    private Float total;

    private String detailedAduit;

    private String status;

    private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDetailOrderNumber() {
		return detailOrderNumber;
	}

	public void setDetailOrderNumber(String detailOrderNumber) {
		this.detailOrderNumber = detailOrderNumber;
	}

	public Long getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(Long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	
	public Long getBusinessOrderId() {
		return businessOrderId;
	}

	public void setBusinessOrderId(Long businessOrderId) {
		this.businessOrderId = businessOrderId;
	}

	public Long getBusinessProductId() {
		return businessProductId;
	}

	public void setBusinessProductId(Long businessProductId) {
		this.businessProductId = businessProductId;
	}

	public Long getUserBaseId() {
		return userBaseId;
	}

	public void setUserBaseId(Long userBaseId) {
		this.userBaseId = userBaseId;
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

	public Integer getNumbers() {
		return numbers;
	}

	public void setNumbers(Integer numbers) {
		this.numbers = numbers;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
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
		return "CustomerOrderDetailed [id=" + id + ", detailOrderNumber="
				+ detailOrderNumber + ", customerOrderId=" + customerOrderId
				+ ", businessOrderId=" + businessOrderId
				+ ", businessProductId=" + businessProductId + ", userBaseId="
				+ userBaseId + ", preferPrice=" + preferPrice + ", salePrice="
				+ salePrice + ", numbers=" + numbers + ", total=" + total
				+ ", detailedAduit=" + detailedAduit + ", status=" + status
				+ ", updateTime=" + updateTime + "]";
	}
	
}