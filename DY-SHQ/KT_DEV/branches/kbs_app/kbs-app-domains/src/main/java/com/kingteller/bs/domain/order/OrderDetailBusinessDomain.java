package com.kingteller.bs.domain.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kingteller.bs.domain.business.BusinessProduct;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class OrderDetailBusinessDomain {

	private CustomerOrderDetailed customerOrderDetailed;
	
	private BusinessProduct businessProduct;

	public CustomerOrderDetailed getCustomerOrderDetailed() {
		return customerOrderDetailed;
	}

	public void setCustomerOrderDetailed(CustomerOrderDetailed customerOrderDetailed) {
		this.customerOrderDetailed = customerOrderDetailed;
	}

	public BusinessProduct getBusinessProduct() {
		return businessProduct;
	}

	public void setBusinessProduct(BusinessProduct businessProduct) {
		this.businessProduct = businessProduct;
	}

	@Override
	public String toString() {
		return "OrderDetailBusinessDomain [customerOrderDetailed="
				+ customerOrderDetailed + ", businessProduct="
				+ businessProduct + "]";
	}
	
}
