package com.kt.Bean;

public class NewGoodsReceipt {
	public UserSession userSession=new UserSession();
	public UserOrderAddress userOrderAddress =new UserOrderAddress();
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
		return "NewGoodsReceipt [userSession=" + userSession
				+ ", userOrderAddress=" + userOrderAddress
				+ ", getUserSession()=" + getUserSession()
				+ ", getUserOrderAddress()=" + getUserOrderAddress()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
