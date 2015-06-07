package com.kingteller.bs.service;

import java.util.List;

import com.kingteller.bs.domain.product.ProductCatalogue;

/**
 * 商品类别服务
 * @author wangyafei
 *
 */
public interface ProductCatalogueService {

	/**
	 * 查询所有商品类别
	 * @return
	 * @throws Exception
	 */
	public List<ProductCatalogue> getProductCatalogues() throws Exception;
	
	/**
	 * 更新商品类别的序列
	 * @param productCatalogues
	 * @return
	 * @throws Exception
	 */
	public List<ProductCatalogue> updateProductCatalogSerialize() throws Exception;
	
	/**
	 * 重置商品类别的序列,将此序列重置为0
	 * @param productCatalogue
	 * @return
	 * @throws Exception
	 */
	public ProductCatalogue resetSerialize(ProductCatalogue productCatalogue) throws Exception;
	
}
