package com.kingteller.bs.domain.business;

import com.kingteller.bs.domain.product.ProductBase;

public class BusinessProductDomail {

	private ProductBase productBase;
	
	private BusinessProductAduit businessProductAduit;

	@Override
	public String toString() {
		return "BusinessProductDomail [productBase=" + productBase
				+ ", businessProductAduit=" + businessProductAduit + "]";
	}

	public ProductBase getProductBase() {
		return productBase;
	}

	public void setProductBase(ProductBase productBase) {
		this.productBase = productBase;
	}

	public BusinessProductAduit getBusinessProductAduit() {
		return businessProductAduit;
	}

	public void setBusinessProductAduit(BusinessProductAduit businessProductAduit) {
		this.businessProductAduit = businessProductAduit;
	}
	
}
