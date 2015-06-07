package com.kingteller.bs.domain.business;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessProductComment {
	
    private Long id;

    private Long businessProductId;

    private String comment;

    private Long productBaseId;
    
    private String username;

    private Long userBaseId;

    private String status;

    private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusinessProductId() {
		return businessProductId;
	}

	public void setBusinessProductId(Long businessProductId) {
		this.businessProductId = businessProductId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getProductBaseId() {
		return productBaseId;
	}

	public void setProductBaseId(Long productBaseId) {
		this.productBaseId = productBaseId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getUserBaseId() {
		return userBaseId;
	}

	public void setUserBaseId(Long userBaseId) {
		this.userBaseId = userBaseId;
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
		return "BusinessProductComment [id=" + id + ", businessProductId="
				+ businessProductId + ", comment=" + comment
				+ ", productBaseId=" + productBaseId + ", username=" + username
				+ ", userBaseId=" + userBaseId + ", status=" + status
				+ ", updateTime=" + updateTime + "]";
	}

}