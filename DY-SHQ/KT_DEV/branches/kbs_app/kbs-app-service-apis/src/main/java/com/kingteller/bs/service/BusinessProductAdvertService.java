package com.kingteller.bs.service;

import java.util.List;

import com.kingteller.bs.domain.business.BusinessProductAdvert;

/**
 * 广告相关Service层操作
 * @author 王亚菲
 *
 */
public interface BusinessProductAdvertService {

	/**
	 * 获取最近的广告信息用于展示
	 * @return
	 * @throws Exception
	 */
	public List<BusinessProductAdvert> getLatestProductAdverts(String status, int count) throws Exception;
	
}
