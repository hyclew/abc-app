package com.kingteller.bs.domain.cart;

public class ShoppingCartDomain {

	private ShoppingCart shoppingCart;
	
	private String sessionId;

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "ShoppingCartDomain [shoppingCart=" + shoppingCart
				+ ", sessionId=" + sessionId + "]";
	}
}
