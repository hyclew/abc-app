package com.kingteller.bs.domain.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserDetailed {

	private Long id;
	
	private String sex;
	
	private Long userBaseId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Long getUserBaseId() {
		return userBaseId;
	}

	public void setUserBaseId(Long userBaseId) {
		this.userBaseId = userBaseId;
	}

	@Override
	public String toString() {
		return "UserDetailed [id=" + id + ", sex=" + sex + ", userBaseId="
				+ userBaseId + "]";
	}
	
}
