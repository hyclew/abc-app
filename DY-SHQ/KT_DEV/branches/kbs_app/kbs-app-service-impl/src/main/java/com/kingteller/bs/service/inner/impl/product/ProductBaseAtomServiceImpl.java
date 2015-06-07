package com.kingteller.bs.service.inner.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.product.ProductBaseDao;
import com.kingteller.bs.domain.product.ProductBase;
import com.kingteller.bs.service.inner.product.ProductBaseAtomService;

@Component("productBaseAtomService")
public class ProductBaseAtomServiceImpl implements ProductBaseAtomService {

	@Autowired
	private ProductBaseDao productBaseDao;
	
	@Override
	public boolean insertProductBase(ProductBase productBase) throws Exception {
		return this.productBaseDao.insertProductBase(productBase);
	}

}
