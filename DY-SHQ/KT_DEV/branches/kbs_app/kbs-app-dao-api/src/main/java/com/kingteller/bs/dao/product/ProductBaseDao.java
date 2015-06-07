package com.kingteller.bs.dao.product;

import com.kingteller.bs.domain.product.ProductBase;


public interface ProductBaseDao {
	/**
	 * 更新商家基本信息表
	 * @param productBase
	 * @return
	 * @throws Exception
	 */
	public boolean insertProductBase(ProductBase productBase) throws Exception;
}