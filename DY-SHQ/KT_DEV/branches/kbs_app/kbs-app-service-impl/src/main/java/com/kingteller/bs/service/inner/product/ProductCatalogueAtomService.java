package com.kingteller.bs.service.inner.product;

import java.util.List;

import com.kingteller.bs.domain.product.ProductCatalogue;

public interface ProductCatalogueAtomService {

	/**
	 * 查询所有商品类别
	 * @return
	 * @throws Exception
	 */
	public List<ProductCatalogue> getProductCatalogues(ProductCatalogue productCatalogue) throws Exception;
	
	/**
	 * 更新数据库中某条记录的
	 * @param productCatalogue
	 * @return
	 * @throws Exception
	 */
	public Integer updateProductCatalogSerialize(ProductCatalogue productCatalogue) throws Exception;
	
	/**
	 * 通过code查询商品类别
	 * @param productCatalogue
	 * @return
	 * @throws Exception
	 */
	public ProductCatalogue queryProductCatalogByCode(ProductCatalogue productCatalogue) throws Exception;
	
	/**
	 * 重置ProductCatalog的序列为1000
	 * @param productCatalogue
	 * @return
	 * @throws Exception
	 */
	public Integer resetProductCatalogSerialize(ProductCatalogue productCatalogue) throws Exception;
	
	/**
	 * 重置产品类别序列为1000
	 * @param productCatalogue
	 * @return
	 * @throws Exception
	 */
	public ProductCatalogue resetSerialize(ProductCatalogue productCatalogue) throws Exception;
	
	/**
	 * 提供重试测试将序列增加1000
	 * @param productCatalogue
	 * @return
	 * @throws Exception
	 */
	public ProductCatalogue cycleTryUpdateSerializeAddThousand(ProductCatalogue productCatalogue) throws Exception;
}
