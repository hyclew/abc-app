package com.kt.Bean;

public class ShoppingCartBean {
	private String cartId;
	private String productName;
	private String count;
	private String productIntroduce;
	private String productSalePrice;
	private String productPreferPrice;
	private String resourceId;
	private String businessProductId;
	private String businessProductCatalogId;
	
	public String getBusinessProductCatalogId() {
		return businessProductCatalogId;
	}
	public void setBusinessProductCatalogId(String businessProductCatalogId) {
		this.businessProductCatalogId = businessProductCatalogId;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getProductIntroduce() {
		return productIntroduce;
	}
	public void setProductIntroduce(String productIntroduce) {
		this.productIntroduce = productIntroduce;
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
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}
	public String getBusinessProductId() {
		return businessProductId;
	}
	public void setBusinessProductId(String businessProductId) {
		this.businessProductId = businessProductId;
	}
	@Override
	public String toString() {
		return "ShoppingCartBean [cartId=" + cartId + ", productName="
				+ productName + ", count=" + count + ", productIntroduce="
				+ productIntroduce + ", productSalePrice=" + productSalePrice
				+ ", productPreferPrice=" + productPreferPrice
				+ ", resourceId=" + resourceId + ", businessProductId="
				+ businessProductId + ", businessProductCatalogId="
				+ businessProductCatalogId + ", getBusinessProductCatalogId()="
				+ getBusinessProductCatalogId() + ", getCartId()="
				+ getCartId() + ", getProductName()=" + getProductName()
				+ ", getCount()=" + getCount() + ", getProductIntroduce()="
				+ getProductIntroduce() + ", getProductSalePrice()="
				+ getProductSalePrice() + ", getProductPreferPrice()="
				+ getProductPreferPrice() + ", getResourceId()="
				+ getResourceId() + ", getBusinessProductId()="
				+ getBusinessProductId() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
