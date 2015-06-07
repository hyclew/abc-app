package com.kingteller.bs.service.inner.product;

import com.kingteller.bs.domain.product.ProductBase;

public interface ProductBaseAtomService {

	/**
	 * 更新商家基础信息表
	 * @param productBase
	 * @return
	 * @throws Exception
	 */
	public boolean insertProductBase(ProductBase productBase) throws Exception;
	
}
