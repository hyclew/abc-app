package com.kingteller.bs.service.inner.impl.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.business.BusinessProductDao;
import com.kingteller.bs.domain.business.BusinessProduct;
import com.kingteller.bs.page.DataGridModel;
import com.kingteller.bs.service.inner.business.BusinessProductAtomService;

@Component("businessProductAtomService")
public class BusinessProductAtomServiceImpl implements BusinessProductAtomService{

	@Autowired
	private BusinessProductDao businessProductDao;
	
	@Override
	public List<BusinessProduct> getBusinessListBycatalogid(Long productcatalogId, Long maxId, int dataCount) throws Exception {
		return this.businessProductDao.getBusinessproductBycatalogid(productcatalogId, maxId, dataCount);
	}

	@Override
	public BusinessProduct getBusinessProductDetail(Long businessProductId)
			throws Exception {
		return this.businessProductDao.getBusinessProductDetail(businessProductId);
	}

	@Override
	public List<BusinessProduct> getBusinessProductByAll(DataGridModel dgm,Long businessid,BusinessProduct businessProduct) throws Exception {
		return this.businessProductDao.getBusinessProductByAll(dgm,businessid,businessProduct);
	}

	@Override
	public int getBusinessProductAll(Long businessid,BusinessProduct businessProduct)
			throws Exception {
		return this.businessProductDao.getBusinessProductAll(businessid,businessProduct);
	}
	
	

}
