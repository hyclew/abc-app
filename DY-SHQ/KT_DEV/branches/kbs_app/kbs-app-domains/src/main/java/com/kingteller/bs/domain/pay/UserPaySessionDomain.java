package com.kingteller.bs.domain.pay;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserPaySessionDomain {

	private String sessionId;
	
	private UserPay userPay;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public UserPay getUserPay() {
		return userPay;
	}

	public void setUserPay(UserPay userPay) {
		this.userPay = userPay;
	}

	@Override
	public String toString() {
		return "UserPaySessionDomain [sessionId=" + sessionId + ", userPay="
				+ userPay + "]";
	}
	
}
