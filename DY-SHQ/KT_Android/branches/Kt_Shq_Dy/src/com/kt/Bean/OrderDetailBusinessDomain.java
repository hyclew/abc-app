package com.kt.Bean;

public class OrderDetailBusinessDomain {
	private CustomerOrderDetailed customerOrderDetailed;
	private BusinessProduct businessProduct;
	
	public CustomerOrderDetailed getCustomerOrderDetailed() {
		return customerOrderDetailed;
	}
	public void setCustomerOrderDetailed(CustomerOrderDetailed customerOrderDetailed) {
		this.customerOrderDetailed = customerOrderDetailed;
	}
	public BusinessProduct getBusinessProduct() {
		return businessProduct;
	}
	public void setBusinessProduct(BusinessProduct businessProduct) {
		this.businessProduct = businessProduct;
	}
	@Override
	public String toString() {
		return "OrderDetailBusinessDomain [customerOrderDetailed="
				+ customerOrderDetailed + ", businessProduct="
				+ businessProduct + ", getCustomerOrderDetailed()="
				+ getCustomerOrderDetailed() + ", getBusinessProduct()="
				+ getBusinessProduct() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
