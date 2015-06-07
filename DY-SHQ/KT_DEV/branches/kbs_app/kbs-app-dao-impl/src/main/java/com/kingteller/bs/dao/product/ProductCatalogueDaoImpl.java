package com.kingteller.bs.dao.product;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.product.ProductCatalogue;

@Component("productCatalogueDao")
public class ProductCatalogueDaoImpl extends MyBatisDao implements ProductCatalogueDao {

	private static final String NAMESPACE = "ProductCatalogue";
	private static Logger logger = Logger.getLogger(ProductCatalogueDaoImpl.class);
	
	@Override
	public List<ProductCatalogue> getProductCatalogues(ProductCatalogue productCatalogue) throws Exception {
		logger.info("开始查询商品类别信息, 查询参数是:" + productCatalogue);
		return this.getSqlSession().selectList(NAMESPACE + ".getProductCatalogues", productCatalogue);
	}

	@Override
	public Integer updateProductCatalogSerialize(
			ProductCatalogue productCatalogue) throws Exception {
		Integer count = this.getSqlSession().update(NAMESPACE + ".updateProductCatalogSerialize", productCatalogue);
		logger.debug("更新Code为 " + productCatalogue.getCode() + ", 类型为" + productCatalogue.getComment() + " 的商品类别的条数为: " + count + " 条");
		return count;
	}

	@Override
	public ProductCatalogue queryProductCatalogByCode(
			ProductCatalogue productCatalogue) throws Exception {
		return this.getSqlSession().selectOne(NAMESPACE + ".queryProductCatalogByCode", productCatalogue);
	}

	@Override
	public Integer resetProductCatalogSerialize(
			ProductCatalogue productCatalogue) throws Exception {
		return this.getSqlSession().update(NAMESPACE + ".resetProductCatalogSerialize", productCatalogue);
	}
}