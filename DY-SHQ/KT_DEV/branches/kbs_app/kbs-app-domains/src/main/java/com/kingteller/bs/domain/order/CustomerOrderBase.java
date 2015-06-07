package com.kingteller.bs.domain.order;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 用户订单基础信息
 * @author wangyafei
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CustomerOrderBase {
	
    private Long id;

    private String orderNumber;
    
    private Float totalCash;

    private Integer totalNumbers;

    private String orderAduit;

    private Date updateTime;
    
    private String detailedAduit;

    private String status;
    
    private Long userBaseId;
    
    private Long orderAddressId;
    
    private String isInvoice; //是否开发票
    
    private String isClub; //公司还是个人
    
    private String invoiceTitle; //发票抬头

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Float getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(Float totalCash) {
		this.totalCash = totalCash;
	}

	public Integer getTotalNumbers() {
		return totalNumbers;
	}

	public void setTotalNumbers(Integer totalNumbers) {
		this.totalNumbers = totalNumbers;
	}

	public String getOrderAduit() {
		return orderAduit;
	}

	public void setOrderAduit(String orderAduit) {
		this.orderAduit = orderAduit;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	
	public Long getUserBaseId() {
		return userBaseId;
	}

	public void setUserBaseId(Long userBaseId) {
		this.userBaseId = userBaseId;
	}
	
	public Long getOrderAddressId() {
		return orderAddressId;
	}

	public void setOrderAddressId(Long orderAddressId) {
		this.orderAddressId = orderAddressId;
	}
	
	public String getIsInvoice() {
		return isInvoice;
	}

	public void setIsInvoice(String isInvoice) {
		this.isInvoice = isInvoice;
	}

	public String getIsClub() {
		return isClub;
	}

	public void setIsClub(String isClub) {
		this.isClub = isClub;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	@Override
	public String toString() {
		return "CustomerOrderBase [id=" + id + ", orderNumber=" + orderNumber
				+ ", totalCash=" + totalCash + ", totalNumbers=" + totalNumbers
				+ ", orderAduit=" + orderAduit + ", updateTime=" + updateTime
				+ ", detailedAduit=" + detailedAduit + ", status=" + status
				+ ", userBaseId=" + userBaseId + ", orderAddressId="
				+ orderAddressId + ", isInvoice=" + isInvoice + ", isClub="
				+ isClub + ", invoiceTitle=" + invoiceTitle + "]";
	}
	
}