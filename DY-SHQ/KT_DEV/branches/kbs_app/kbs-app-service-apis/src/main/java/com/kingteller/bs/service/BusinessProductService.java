package com.kingteller.bs.service;

import java.util.List;
import java.util.Map;

import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.domain.business.BusinessProductDomail;
import com.kingteller.bs.page.DataGridModel;

/**
 * 
 * @author wangyafei
 * 
 *	
 */
public interface BusinessProductService {
	
	/**
	 * 查询商家产品列表
	 * @param productcatalogId 产品类别ID
	 * @param maxId 查询最大ID（从此最大ID往后查）
	 * @param dataCount 查询的数据条数
	 * @return
	 * @throws Exception
	 */
	public List<BusinessProduct> getBusinessProductInfos(Long productcatalogId, Long maxId, int dataCount) throws Exception;
	
	/**
	 * 根据商家产品ID查询产品详细信息
	 * @param businessProductId
	 * @return
	 * @throws Exception
	 */
	public BusinessProduct getBusinessProductDetail(Long businessProductId) throws Exception;
	
	/**
	 * 查询全部商家产品信息
	 * @param dgm 分页条件
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> getBusinessProductByAll(DataGridModel dgm,Long businessid,BusinessProduct businessProduct) throws Exception;
	
	/**
	 * 添加商品，先进行更新数据到 商家基本信息表和商家审核表
	 * @param businessProductDomail
	 * @return
	 * @throws Exception
	 */
	public boolean updateBusinessProductAduit(BusinessProductDomail businessProductDomail) throws Exception;
	
}
