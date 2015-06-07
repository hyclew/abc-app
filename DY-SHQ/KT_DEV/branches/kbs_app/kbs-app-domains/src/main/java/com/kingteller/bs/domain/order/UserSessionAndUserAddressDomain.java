package com.kingteller.bs.domain.order;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kingteller.bs.domain.user.UserSession;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserSessionAndUserAddressDomain {

	private UserSession userSession;
	
	private UserOrderAddress userOrderAddress;

	public UserSession getUserSession() {
		return userSession;
	}

	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}

	public UserOrderAddress getUserOrderAddress() {
		return userOrderAddress;
	}

	public void setUserOrderAddress(UserOrderAddress userOrderAddress) {
		this.userOrderAddress = userOrderAddress;
	}

	@Override
	public String toString() {
		return "UserAndUserAddressDomain [userSession=" + userSession
				+ ", userOrderAddress=" + userOrderAddress + "]";
	}
}
