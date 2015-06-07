package com.kingteller.bs.domain.business;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class BusinessBase {
    
    private Long id;
   
    private String name;//商家名称
   
    private String address;//商家地址
 
    private String geo;//商家地理信息

    private String status;//商家状态

    private Date updateTime;//更新时间
  
    private String contractname;//联系人

    private Long productcatalogueid;//产品分类
    
    private String paytool;//支付工具
    
    private Long userid;//用户id

	@Override
	public String toString() {
		return "BusinessBase [id=" + id + ", name=" + name + ", address="
				+ address + ", geo=" + geo + ", status=" + status
				+ ", updateTime=" + updateTime + ", contractname="
				+ contractname + ", productcatalogueid=" + productcatalogueid
				+ ", paytool=" + paytool + ", userid=" + userid + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getContractname() {
		return contractname;
	}

	public void setContractname(String contractname) {
		this.contractname = contractname;
	}

	public Long getProductcatalogueid() {
		return productcatalogueid;
	}

	public void setProductcatalogueid(Long productcatalogueid) {
		this.productcatalogueid = productcatalogueid;
	}

	public String getPaytool() {
		return paytool;
	}

	public void setPaytool(String paytool) {
		this.paytool = paytool;
	}

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
	}
    
}