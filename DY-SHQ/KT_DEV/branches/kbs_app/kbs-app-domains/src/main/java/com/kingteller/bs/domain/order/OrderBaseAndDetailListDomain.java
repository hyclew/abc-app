package com.kingteller.bs.domain.order;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class OrderBaseAndDetailListDomain {

	private CustomerOrderBase customerOrderBase;
	
	private List<CustomerOrderDetailed> customerOrderDetaileds;

	public CustomerOrderBase getCustomerOrderBase() {
		return customerOrderBase;
	}

	public void setCustomerOrderBase(CustomerOrderBase customerOrderBase) {
		this.customerOrderBase = customerOrderBase;
	}

	public List<CustomerOrderDetailed> getCustomerOrderDetaileds() {
		return customerOrderDetaileds;
	}

	public void setCustomerOrderDetaileds(
			List<CustomerOrderDetailed> customerOrderDetaileds) {
		this.customerOrderDetaileds = customerOrderDetaileds;
	}

	@Override
	public String toString() {
		return "OrderBaseAndDetailListDomain [customerOrderBase="
				+ customerOrderBase + ", customerOrderDetaileds="
				+ customerOrderDetaileds + "]";
	}
	
}
