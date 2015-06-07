package com.kingteller.bs.service.inner.impl.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.user.BusinessCatalogueDao;
import com.kingteller.bs.domain.business.BusinessCatalogue;
import com.kingteller.bs.service.inner.business.BusinessCatalogueAtomService;

@Component("businessCatalogueAtomService")
public class BusinessCatalogueAtomServiceImpl implements
		BusinessCatalogueAtomService {

	@Autowired
	private BusinessCatalogueDao businessCatalogueDao;
	
	@Override
	public List<BusinessCatalogue> queryUserBaseByList(String businessid)
			throws Exception {
		return this.businessCatalogueDao.queryUserBaseByList(businessid);
	}

	@Override
	public BusinessCatalogue insertBusinessCatalogue(BusinessCatalogue businessCatalogue)
			throws Exception {
		// TODO Auto-generated method stub
		return this.businessCatalogueDao.insertBusinessCatalogue(businessCatalogue);
	}

}
