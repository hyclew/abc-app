package com.kingteller.bs.service.inner.business;

import java.util.List;

import com.kingteller.bs.domain.business.BusinessProductAdvert;

/**
 * 商品广告Atom Service
 * @author wangyafei
 *
 */
public interface BusinessProductAdvertAtomService {

	/**
	 * 获取最近的广告信息用于展示
	 * @param status 广告状态
	 * @param count 查询条数
	 * @return
	 * @throws Exception
	 */
	public List<BusinessProductAdvert> getLatestProductAdverts(String status, int count) throws Exception;
	
}
