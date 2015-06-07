package com.kingteller.bs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.product.ProductCatalogue;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.service.ProductCatalogueService;
import com.kingteller.bs.service.inner.product.ProductCatalogueAtomService;

@Component("productCatalogueService")
public class ProductCatalogueServiceImpl implements ProductCatalogueService {
	
	
	private static final Logger logger = Logger.getLogger(ProductCatalogueServiceImpl.class);
	
	@Autowired
	private ProductCatalogueAtomService productCatalogueAtomService;
	
	public List<ProductCatalogue> getProductCatalogues() throws Exception{
		ProductCatalogue productCatalogue = new ProductCatalogue();
		productCatalogue.setStatus(Constant.PRODUCT_CATALOGUE_ENABLED);
		return this.productCatalogueAtomService.getProductCatalogues(productCatalogue);
	}

	@Override
	public List<ProductCatalogue> updateProductCatalogSerialize() throws Exception {
		List<ProductCatalogue> catalogReturn = new ArrayList<ProductCatalogue>();
		List<ProductCatalogue> productCatalogues = null;
		try {
			productCatalogues = this.getProductCatalogues();
			for(ProductCatalogue productCatalogue : productCatalogues){
				productCatalogue = this.productCatalogueAtomService.cycleTryUpdateSerializeAddThousand(productCatalogue);
				catalogReturn.add(productCatalogue);
			}
		} catch (Exception e) {
			logger.error("更新产品类型序列失败，失败原因是:" + e.getLocalizedMessage(), e);
			e.printStackTrace();
		}
		return catalogReturn;
	}
	
	public ProductCatalogue resetSerialize(ProductCatalogue productCatalogue) throws Exception{
		try {
			return this.productCatalogueAtomService.resetSerialize(productCatalogue);
		} catch (Exception e) {
			logger.error("重置Code为 " + productCatalogue.getCode() + " 的商品序列异常");
			e.printStackTrace();
		}
		return null;
	}
	

}
