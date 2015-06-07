package com.kingteller.bs.domain.cart;

import java.util.List;

public class ShoppingCartListDomain {

	private String sessionId;
	
	private List<ShoppingCart> shoppingCartList;

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public List<ShoppingCart> getShoppingCartList() {
		return shoppingCartList;
	}

	public void setShoppingCartList(List<ShoppingCart> shoppingCartList) {
		this.shoppingCartList = shoppingCartList;
	}
}
