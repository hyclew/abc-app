package com.kingteller.bs.service.inner.impl.product;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.product.ProductCatalogueDao;
import com.kingteller.bs.domain.product.ProductCatalogue;
import com.kingteller.bs.framework.exception.AppException;
import com.kingteller.bs.service.inner.product.ProductCatalogueAtomService;

@Component("productCatalogueAtomService")
public class ProductCatalogueAtomServiceImpl implements
		ProductCatalogueAtomService {

	@Autowired
	private ProductCatalogueDao productCatalogueDao;

	private static final Logger logger = Logger
			.getLogger(ProductCatalogueAtomServiceImpl.class);

	private static final Integer MAX_AUTO_TRY = 5; // 最大重试次数

	@Override
	public List<ProductCatalogue> getProductCatalogues(
			ProductCatalogue productCatalogue) throws Exception {
		return this.productCatalogueDao.getProductCatalogues(productCatalogue);
	}

	@Override
	public Integer updateProductCatalogSerialize(
			ProductCatalogue productCatalogue) throws Exception {
		return this.productCatalogueDao
				.updateProductCatalogSerialize(productCatalogue);
	}

	@Override
	public ProductCatalogue queryProductCatalogByCode(
			ProductCatalogue productCatalogue) throws Exception {
		return this.productCatalogueDao
				.queryProductCatalogByCode(productCatalogue);
	}

	@Override
	public Integer resetProductCatalogSerialize(
			ProductCatalogue productCatalogue) throws Exception {
		return this.productCatalogueDao
				.resetProductCatalogSerialize(productCatalogue);
	}

	public ProductCatalogue resetSerialize(ProductCatalogue productCatalogue)
			throws Exception {
		Integer count = 0;
		// 使用序列号作为更新条件，相当于实现乐观锁
		count = this.resetProductCatalogSerialize(productCatalogue);
		Integer cycleCount = 0;
		// 如果第一次更新失败，则重试5次
		while (count == 0 && cycleCount < MAX_AUTO_TRY) {
			logger.info("重置商品类别为 " + productCatalogue.getCode() + " 的序列，正在进行第 "
					+ (cycleCount + 1) + " 次重试");
			// 更新失败，说明此记录已被其他事务修改，则重新查询一次
			productCatalogue = this.queryProductCatalogByCode(productCatalogue);
			count = this.resetProductCatalogSerialize(productCatalogue);
			cycleCount++;
		}
		logger.info("重置Code为 " + productCatalogue.getCode() + "、 类型为"
				+ productCatalogue.getComment() + " 的商品类别的条数为: " + count + " 条");
		// 如果最后仍更新失败,则抛出运行时异常,事务全部回滚
		if (count <= 0) {
			throw new AppException("重置类型为 " + productCatalogue.getComment()
					+ " 的序列失败");
		} else {
			productCatalogue = this.queryProductCatalogByCode(productCatalogue);
			return productCatalogue;
		}
	}

	@Override
	public ProductCatalogue cycleTryUpdateSerializeAddThousand(
			ProductCatalogue productCatalogue) throws Exception {
		Integer count = 0;
		//使用序列号作为更新条件，相当于实现乐观锁
		count = this.updateProductCatalogSerialize(productCatalogue);
		Integer cycleCount = 0;
		//如果第一次更新失败，则重试5次
		while(count == 0 && cycleCount < MAX_AUTO_TRY){
			logger.info("更新商品类别为 " + productCatalogue.getCode() + " 的序列，正在进行第 " + (cycleCount + 1) + " 次重试");
			//更新失败，说明此记录已被其他事务修改，则重新查询一次
			productCatalogue = this.queryProductCatalogByCode(productCatalogue);
			count = this.updateProductCatalogSerialize(productCatalogue);
			cycleCount++;
		}
		logger.info("更新Code为 " + productCatalogue.getCode() + "、 类型为" + productCatalogue.getComment() + " 的商品类别的条数为: " + count + " 条");
		//如果最后仍更新失败,则抛出运行时异常,事务全部回滚
		if(count <= 0){
			throw new AppException("更新类型为 " + productCatalogue.getComment() + " 的序列失败");
		} else{
			productCatalogue = this.queryProductCatalogByCode(productCatalogue);
			return productCatalogue;
		}
	}

}
