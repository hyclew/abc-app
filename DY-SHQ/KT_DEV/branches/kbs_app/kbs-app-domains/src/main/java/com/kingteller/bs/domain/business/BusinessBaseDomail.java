package com.kingteller.bs.domain.business;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kingteller.bs.domain.pay.UserPay;
import com.kingteller.bs.domain.product.ProductCatalogue;
import com.kingteller.bs.domain.user.UserBase;



/**
 * 针对于业务的Domain对象，是BusinessBase、UserPay、ProductCatalogue、UserBase的属性集合
 * @author 
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessBaseDomail {

	private BusinessBase businessBase;
	
	private UserPay userPay;
	
	private ProductCatalogue productCatalogue;
	
	private UserBase userBase;
	
	private List productcatalogueid;
	
	private BusinessCatalogue BusinessCatalogue;


	@Override
	public String toString() {
		return "BusinessBaseDomail [businessBase=" + businessBase
				+ ", userPay=" + userPay + ", productCatalogue="
				+ productCatalogue + ", userBase=" + userBase
				+ ", productcatalogueid=" + productcatalogueid
				+ ", BusinessCatalogue=" + BusinessCatalogue + "]";
	}

	public BusinessCatalogue getBusinessCatalogue() {
		return BusinessCatalogue;
	}

	public void setBusinessCatalogue(BusinessCatalogue businessCatalogue) {
		BusinessCatalogue = businessCatalogue;
	}

	public List getProductcatalogueid() {
		return productcatalogueid;
	}

	public void setProductcatalogueid(List productcatalogueid) {
		this.productcatalogueid = productcatalogueid;
	}

	public BusinessBase getBusinessBase() {
		return businessBase;
	}

	public void setBusinessBase(BusinessBase businessBase) {
		this.businessBase = businessBase;
	}

	public UserPay getUserPay() {
		return userPay;
	}

	public void setUserPay(UserPay userPay) {
		this.userPay = userPay;
	}

	public ProductCatalogue getProductCatalogue() {
		return productCatalogue;
	}

	public void setProductCatalogue(ProductCatalogue productCatalogue) {
		this.productCatalogue = productCatalogue;
	}

	public UserBase getUserBase() {
		return userBase;
	}

	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}
	
}
