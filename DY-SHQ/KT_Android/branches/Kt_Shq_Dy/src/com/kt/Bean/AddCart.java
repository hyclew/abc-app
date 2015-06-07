package com.kt.Bean;

public class AddCart {
	public String sessionId;
	public ShoppingCart shoppingCart= new ShoppingCart();
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	@Override
	public String toString() {
		return "AddCart [sessionId=" + sessionId + ", shoppingCart="
				+ shoppingCart + ", getSessionId()=" + getSessionId()
				+ ", getShoppingCart()=" + getShoppingCart() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
