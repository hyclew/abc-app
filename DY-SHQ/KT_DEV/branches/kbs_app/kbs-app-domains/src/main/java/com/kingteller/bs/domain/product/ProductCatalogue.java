package com.kingteller.bs.domain.product;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ProductCatalogue {
    
    private String code;

    private String comment;

    private String status;

    private Date updateTime;
    
    private Long serialize;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public Long getSerialize() {
		return serialize;
	}

	public void setSerialize(Long serialize) {
		this.serialize = serialize;
	}

	@Override
	public String toString() {
		return "ProductCatalogue [code=" + code + ", comment=" + comment
				+ ", status=" + status + ", updateTime=" + updateTime
				+ ", serialize=" + serialize + "]";
	}
    
}