package com.kingteller.bs.domain.cart;

/**
 * 包含购物车与商品属性的Domain，用于展示购物车信息等
 * @author wangyafei
 *
 */
public class BusinessCartDomain {

	/**
	 * 购物车ID
	 */
	private Long cartId; 
	
	/**
	 * 商品ID
	 */
	private Long businessProductId; 
	
	/**
	 * 商品类别
	 */
	private Long businessProductCatalogId;
	
	/**
	 * 商品名称
	 */
	private String productName;
	
	/**
	 * 购物车数量
	 */
	private Integer count;
	
	/**
	 * 商品简介
	 */
	private String productIntroduce;
	
	/**
	 * 商品促销价格
	 */
	private Float productSalePrice;
	
	/**
	 * 商品的德阳卡价格
	 */
	private Float productPreferPrice;
	
	/**
	 * 资源（也就是商品图片）ID
	 */
	private Long resourceId;

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getBusinessProductId() {
		return businessProductId;
	}

	public void setBusinessProductId(Long businessProductId) {
		this.businessProductId = businessProductId;
	}
	
	public Long getBusinessProductCatalogId() {
		return businessProductCatalogId;
	}

	public void setBusinessProductCatalogId(Long businessProductCatalogId) {
		this.businessProductCatalogId = businessProductCatalogId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getProductIntroduce() {
		return productIntroduce;
	}

	public void setProductIntroduce(String productIntroduce) {
		this.productIntroduce = productIntroduce;
	}

	public Float getProductSalePrice() {
		return productSalePrice;
	}

	public void setProductSalePrice(Float productSalePrice) {
		this.productSalePrice = productSalePrice;
	}

	public Float getProductPreferPrice() {
		return productPreferPrice;
	}

	public void setProductPreferPrice(Float productPreferPrice) {
		this.productPreferPrice = productPreferPrice;
	}

	public Long getResourceId() {
		return resourceId;
	}

	public void setResourceId(Long resourceId) {
		this.resourceId = resourceId;
	}

	@Override
	public String toString() {
		return "BusinessCartDomain [cartId=" + cartId + ", businessProductId="
				+ businessProductId + ", businessProductCatalogId="
				+ businessProductCatalogId + ", productName=" + productName
				+ ", count=" + count + ", productIntroduce=" + productIntroduce
				+ ", productSalePrice=" + productSalePrice
				+ ", productPreferPrice=" + productPreferPrice
				+ ", resourceId=" + resourceId + "]";
	}

}
