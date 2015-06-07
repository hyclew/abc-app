package com.kingteller.bs.domain.business;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)

public class BusinessCatalogue {

	private Long id;
	
	private Long businessid;
	
	private Long cataloguecode;
	
	private String name;
	
	private Date updatetime;

	@Override
	public String toString() {
		return "BusinessCatalogue [id=" + id + ", businessid=" + businessid
				+ ", cataloguecode=" + cataloguecode + ", name=" + name + "]";
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBusinessid() {
		return businessid;
	}

	public void setBusinessid(Long businessid) {
		this.businessid = businessid;
	}

	public Long getCataloguecode() {
		return cataloguecode;
	}

	public void setCataloguecode(Long cataloguecode) {
		this.cataloguecode = cataloguecode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
