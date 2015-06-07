package com.kingteller.bs.dao.business;

import java.util.List;

import com.kingteller.bs.domain.business.BusinessProductAdvert;

/**
 * 广告相关DAO处理
 * @author 王亚菲
 *
 */
public interface BusinessProductAdvertDao {
	
	/**
	 * 查询商品广告信息
	 * @param status 广告状态
	 * @param count 查询条数
	 * @return
	 * @throws Exception
	 */
	public List<BusinessProductAdvert> getLatestProductAdverts(String status, int count) throws Exception;
	
}