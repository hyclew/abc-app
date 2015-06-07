package com.kingteller.bs.domain.order;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class OrderBaseAndDetailDomain {

	private CustomerOrderBase customerOrderBase;
	
	private List<OrderDetailBusinessDomain> orderDetailBusinessDomain;

	public CustomerOrderBase getCustomerOrderBase() {
		return customerOrderBase;
	}

	public void setCustomerOrderBase(CustomerOrderBase customerOrderBase) {
		this.customerOrderBase = customerOrderBase;
	}

	public List<OrderDetailBusinessDomain> getOrderDetailBusinessDomain() {
		return orderDetailBusinessDomain;
	}

	public void setOrderDetailBusinessDomain(
			List<OrderDetailBusinessDomain> orderDetailBusinessDomain) {
		this.orderDetailBusinessDomain = orderDetailBusinessDomain;
	}

	@Override
	public String toString() {
		return "OrderBaseAndDetailDomain [customerOrderBase="
				+ customerOrderBase + ", orderDetailBusinessDomain="
				+ orderDetailBusinessDomain + "]";
	}
	
}
