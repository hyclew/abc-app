package com.kt.Bean;

public class BusinessCartDomain {
	public String cartId;
	public String businessProductId;
	public String businessProductCatalogId;
	public String count;
	public String productSalePrice;
	public String productPreferPrice;
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getBusinessProductId() {
		return businessProductId;
	}
	public void setBusinessProductId(String businessProductId) {
		this.businessProductId = businessProductId;
	}
	public String getBusinessProductCatalogId() {
		return businessProductCatalogId;
	}
	public void setBusinessProductCatalogId(String businessProductCatalogId) {
		this.businessProductCatalogId = businessProductCatalogId;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getProductSalePrice() {
		return productSalePrice;
	}
	public void setProductSalePrice(String productSalePrice) {
		this.productSalePrice = productSalePrice;
	}
	public String getProductPreferPrice() {
		return productPreferPrice;
	}
	public void setProductPreferPrice(String productPreferPrice) {
		this.productPreferPrice = productPreferPrice;
	}
	@Override
	public String toString() {
		return "BusinessCartDomain [cartId=" + cartId + ", businessProductId="
				+ businessProductId + ", businessProductCatalogId="
				+ businessProductCatalogId + ", count=" + count
				+ ", productSalePrice=" + productSalePrice
				+ ", productPreferPrice=" + productPreferPrice
				+ ", getCartId()=" + getCartId() + ", getBusinessProductId()="
				+ getBusinessProductId() + ", getBusinessProductCatalogId()="
				+ getBusinessProductCatalogId() + ", getCount()=" + getCount()
				+ ", getProductSalePrice()=" + getProductSalePrice()
				+ ", getProductPreferPrice()=" + getProductPreferPrice()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
