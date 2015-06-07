package com.kt.Bean;

import java.util.List;

public class OrderListBean {
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
		return "OrderListBean [businessBase=" + businessBase
				+ ", businessOrder=" + businessOrder
				+ ", orderDetailBusinessDomain=" + orderDetailBusinessDomain
				+ ", getBusinessBase()=" + getBusinessBase()
				+ ", getBusinessOrder()=" + getBusinessOrder()
				+ ", getOrderDetailBusinessDomain()="
				+ getOrderDetailBusinessDomain() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
