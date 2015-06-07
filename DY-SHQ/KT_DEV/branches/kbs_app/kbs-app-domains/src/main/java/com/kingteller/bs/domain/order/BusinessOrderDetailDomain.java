package com.kingteller.bs.domain.order;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kingteller.bs.domain.business.BusinessBase;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessOrderDetailDomain {

	private BusinessBase businessBase;
	
	private BusinessOrder businessOrder;
	
	private List<OrderDetailBusinessDomain> orderDetailBusinessDomain;

	public BusinessBase getBusinessBase() {
		return businessBase;
	}

	public void setBusinessBase(BusinessBase businessBase) {
		this.businessBase = businessBase;
	}

	public BusinessOrder getBusinessOrder() {
		return businessOrder;
	}

	public void setBusinessOrder(BusinessOrder businessOrder) {
		this.businessOrder = businessOrder;
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
		return "BusinessOrderDetailDomain [businessBase=" + businessBase
				+ ", businessOrder=" + businessOrder
				+ ", orderDetailBusinessDomain=" + orderDetailBusinessDomain
				+ "]";
	}
	
	
}
