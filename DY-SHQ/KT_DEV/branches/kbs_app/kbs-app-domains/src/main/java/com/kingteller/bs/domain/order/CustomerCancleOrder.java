package com.kingteller.bs.domain.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class CustomerCancleOrder {
	
    private Long id;

    private Long businessProductId;

    private Long businessId;

    private String comment;

    private String status;

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

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CustomerCancleOrder [id=" + id + ", businessProductId="
				+ businessProductId + ", businessId=" + businessId
				+ ", comment=" + comment + ", status=" + status + "]";
	}

}