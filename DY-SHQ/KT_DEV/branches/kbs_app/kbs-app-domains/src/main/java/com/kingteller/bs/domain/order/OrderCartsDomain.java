package com.kingteller.bs.domain.order;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kingteller.bs.domain.cart.BusinessCartDomain;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class OrderCartsDomain {

	private String sessionId;
	
	private List<BusinessCartDomain> businessCartDomain;
	
	private CustomerOrderBase customerOrderBase;
	
	private UserOrderAddress userOrderAddress;
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public List<BusinessCartDomain> getBusinessCartDomain() {
		return businessCartDomain;
	}

	public void setBusinessCartDomain(List<BusinessCartDomain> businessCartDomain) {
		this.businessCartDomain = businessCartDomain;
	}
	
	public CustomerOrderBase getCustomerOrderBase() {
		return customerOrderBase;
	}

	public void setCustomerOrderBase(CustomerOrderBase customerOrderBase) {
		this.customerOrderBase = customerOrderBase;
	}
	
	public UserOrderAddress getUserOrderAddress() {
		return userOrderAddress;
	}

	public void setUserOrderAddress(UserOrderAddress userOrderAddress) {
		this.userOrderAddress = userOrderAddress;
	}

	@Override
	public String toString() {
		return "OrderCartsDomain [sessionId=" + sessionId
				+ ", businessCartDomain=" + businessCartDomain
				+ ", customerOrderBase=" + customerOrderBase
				+ ", userOrderAddress=" + userOrderAddress + "]";
	}

}
