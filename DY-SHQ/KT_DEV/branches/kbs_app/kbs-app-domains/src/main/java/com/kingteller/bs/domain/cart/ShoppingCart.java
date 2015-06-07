package com.kingteller.bs.domain.cart;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 购物车
 * @author wangyafei
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ShoppingCart {

	private Long id;
	
	private Long userBaseId;
	
	private Long businessProductId;
	
	private Integer count;
	
	private String isOrdered;
	
	private Long orderBaseid;
	
	private String status;
	
	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserBaseId() {
		return userBaseId;
	}

	public void setUserBaseId(Long userBaseId) {
		this.userBaseId = userBaseId;
	}

	public Long getBusinessProductId() {
		return businessProductId;
	}

	public void setBusinessProductId(Long businessProductId) {
		this.businessProductId = businessProductId;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getIsOrdered() {
		return isOrdered;
	}

	public void setIsOrdered(String isOrdered) {
		this.isOrdered = isOrdered;
	}

	public Long getOrderBaseid() {
		return orderBaseid;
	}

	public void setOrderBaseid(Long orderBaseid) {
		this.orderBaseid = orderBaseid;
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
		return "ShoppingCart [id=" + id + ", userBaseId=" + userBaseId
				+ ", businessProductId=" + businessProductId + ", count="
				+ count + ", isOrdered=" + isOrdered + ", orderBaseid="
				+ orderBaseid + ", status=" + status + ", updateTime="
				+ updateTime + "]";
	}

}
