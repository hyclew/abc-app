package com.kt.Bean;

import java.util.ArrayList;
import java.util.List;

public class SubmitOrders {
	public String sessionId;
	public CustomerOrderBase customerOrderBase =new CustomerOrderBase();
	public UserOrderAddress userOrderAddress=new UserOrderAddress();
	public  List<BusinessCartDomain> businessCartDomain =new ArrayList<BusinessCartDomain>();
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
	public UserOrderAddress getUserOrderAddress() {
		return userOrderAddress;
	}
	public void setUserOrderAddress(UserOrderAddress userOrderAddress) {
		this.userOrderAddress = userOrderAddress;
	}
	public List<BusinessCartDomain> getList() {
		return businessCartDomain;
	}
	public void setList(List<BusinessCartDomain> list) {
		this.businessCartDomain = list;
	}
	@Override
	public String toString() {
		return "SubmitOrders [sessionId=" + sessionId + ", customerOrderBase="
				+ customerOrderBase + ", userOrderAddress=" + userOrderAddress
				+ ", list=" + businessCartDomain + ", getSessionId()=" + getSessionId()
				+ ", getCustomerOrderBase()=" + getCustomerOrderBase()
				+ ", getUserOrderAddress()=" + getUserOrderAddress()
				+ ", getList()=" + getList() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
