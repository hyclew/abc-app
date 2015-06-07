package com.kt.Bean;

import java.util.ArrayList;
import java.util.List;

import com.kt.kt_shq_dy.R.id;

public class DeleteCart {
	public String sessionId;
	public List<ShoppingCartId> shoppingCartList= new ArrayList<ShoppingCartId>();
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public List<ShoppingCartId> getList() {
		return shoppingCartList;
	}
	public void setList(List<ShoppingCartId> list) {
		this.shoppingCartList = list;
	}
	@Override
	public String toString() {
		return "DeleteCart [sessionId=" + sessionId + ", shoppingCartList=" + shoppingCartList
				+ ", getSessionId()=" + getSessionId() + ", getList()="
				+ getList() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
