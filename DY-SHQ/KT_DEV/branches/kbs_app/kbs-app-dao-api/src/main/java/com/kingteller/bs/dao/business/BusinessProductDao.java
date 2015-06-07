package com.kingteller.bs.dao.business;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.page.DataGridModel;

public interface BusinessProductDao {
	
	/**
	 * 查询商家产品信息
	 * @param productcatalogId 产品类别ID
	 * @param maxId 查询最大ID（从此最大ID往后查）
	 * @param dataCount 查询的数据条数
	 * @return
	 * @throws Exception
	 */
	public List<BusinessProduct> getBusinessproductBycatalogid(Long productcatalogId, Long maxId, int dataCount) throws Exception;
	
	/**
	 * 根据商家产品ID查询商家产品详细信息
	 * @param businessProductId 商家产品ID
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
	public List<BusinessProduct> getBusinessProductByAll(DataGridModel dgm,Long businessid,BusinessProduct businessProduct) throws Exception;
	
	/**
	 * 查询全部商家产品信息
	 * @param businessProduct
	 * @return
	 * @throws Exception
	 */
	public int getBusinessProductAll(Long businessid,BusinessProduct businessProduct) throws Exception;
}