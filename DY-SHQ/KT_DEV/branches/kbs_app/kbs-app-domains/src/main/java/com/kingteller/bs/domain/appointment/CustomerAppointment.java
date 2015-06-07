package com.kingteller.bs.domain.appointment;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CustomerAppointment {

	private Long id;
	
	private Long productCatalogId;
	
	private String appointComment;
	
	private Date appointTime;
	
	private Date appointStartTime;
	
	private Date appointEndTime;
	
	private Long appointAddressId;
	
	private Long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductCatalogId() {
		return productCatalogId;
	}

	public void setProductCatalogId(Long productCatalogId) {
		this.productCatalogId = productCatalogId;
	}

	public String getAppointComment() {
		return appointComment;
	}

	public void setAppointComment(String appointComment) {
		this.appointComment = appointComment;
	}

	public Date getAppointTime() {
		return appointTime;
	}

	public void setAppointTime(Date appointTime) {
		this.appointTime = appointTime;
	}

	public Date getAppointStartTime() {
		return appointStartTime;
	}

	public void setAppointStartTime(Date appointStartTime) {
		this.appointStartTime = appointStartTime;
	}

	public Date getAppointEndTime() {
		return appointEndTime;
	}

	public void setAppointEndTime(Date appointEndTime) {
		this.appointEndTime = appointEndTime;
	}

	public Long getAppointAddressId() {
		return appointAddressId;
	}

	public void setAppointAddressId(Long appointAddressId) {
		this.appointAddressId = appointAddressId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CustomerAppointment [id=" + id + ", productCatalogId="
				+ productCatalogId + ", appointComment=" + appointComment
				+ ", appointTime=" + appointTime + ", appointStartTime="
				+ appointStartTime + ", appointEndTime=" + appointEndTime
				+ ", appointAddressId=" + appointAddressId + ", userId="
				+ userId + "]";
	}
	
}
