package com.kingteller.bs.service.inner.impl.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.business.BusinessActivityDao;
import com.kingteller.bs.domain.business.BusinessActivity;
import com.kingteller.bs.service.inner.business.BusinessActivityAtomService;

@Component("businessActivityAtomService")
public class BusinessActivityAtomServiceImpl implements BusinessActivityAtomService {

	@Autowired
	private BusinessActivityDao businessActivityDao;
	
	@Override
	public List<BusinessActivity> queryBusinessActivitys(
			BusinessActivity businessActivity, Long maxId, int dataCount) throws Exception {
		return this.businessActivityDao.queryBusinessActivitys(businessActivity, maxId, dataCount);
	}

}
