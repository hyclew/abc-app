package com.kingteller.bs.domain.product;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ProductBase {
   
	private Long id;

    private String name;

    private String introduce;

    private Date updateTime;

    private String status;

    private Long unit;
    
    private String specification;

    private String comment;

    private Long productCatalogueId;

	@Override
	public String toString() {
		return "Productbase [id=" + id + ", name=" + name + ", introduce="
				+ introduce + ", updateTime=" + updateTime + ", status="
				+ status + ", unit=" + unit + ", specification="
				+ specification + ", comment=" + comment
				+ ", productCatalogueId=" + productCatalogueId + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getUnit() {
		return unit;
	}

	public void setUnit(Long unit) {
		this.unit = unit;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getProductCatalogueId() {
		return productCatalogueId;
	}

	public void setProductCatalogueId(Long productCatalogueId) {
		this.productCatalogueId = productCatalogueId;
	}

   
}