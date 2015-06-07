package com.kingteller.bs.domain;

import java.io.Serializable;

/**
 * 区域
 * 
 * @author 公共组 Jimmy
 * 
 */
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 区域代码
	 */
	private String areaCode;

	/**
	 * 区域名称
	 */
	private String areaName;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode == null ? null : areaCode.trim();
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName == null ? null : areaName.trim();
	}

}