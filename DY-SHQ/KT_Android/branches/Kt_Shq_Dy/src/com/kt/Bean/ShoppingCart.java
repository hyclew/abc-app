package com.kt.Bean;

public class ShoppingCart {
	public String count;
	public String businessProductId;
	public String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getBusinessProductId() {
		return businessProductId;
	}
	public void setBusinessProductId(String businessProductId) {
		this.businessProductId = businessProductId;
	}
	@Override
	public String toString() {
		return "ShoppingCart [count=" + count + ", businessProductId="
				+ businessProductId + ", id=" + id + ", getId()=" + getId()
				+ ", getCount()=" + getCount() + ", getBusinessProductId()="
				+ getBusinessProductId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
