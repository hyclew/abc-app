package com.kingteller.bs.dao.product;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.product.ProductBase;

@Component("productBaseDao")
public class ProductBaseDaoImpl extends MyBatisDao implements ProductBaseDao {

	private static final String NAMESPACE = "ProductBase";
	
	@Override
	public boolean insertProductBase(ProductBase productBase) throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertProductBase", productBase);
		return count <=0 ? false : true;
	}
}