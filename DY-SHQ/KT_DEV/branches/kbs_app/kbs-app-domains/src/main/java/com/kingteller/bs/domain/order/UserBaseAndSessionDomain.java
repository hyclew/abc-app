package com.kingteller.bs.domain.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserBaseAndSessionDomain {

	private String sessionId;
	
	private CustomerOrderBase customerOrderBase;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public CustomerOrderBase getCustomerOrderBase() {
		return customerOrderBase;
	}

	public void setCustomerOrderBase(CustomerOrderBase customerOrderBase) {
		this.customerOrderBase = customerOrderBase;
	}

	@Override
	public String toString() {
		return "UserBaseAndSessionDomain [sessionId=" + sessionId
				+ ", customerOrderBase=" + customerOrderBase + "]";
	}
	
}
