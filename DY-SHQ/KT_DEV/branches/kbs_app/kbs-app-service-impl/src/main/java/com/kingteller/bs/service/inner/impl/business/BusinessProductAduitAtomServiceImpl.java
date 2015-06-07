package com.kingteller.bs.service.inner.impl.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.business.BusinessProductAduitDao;
import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.business.BusinessProductAduit;
import com.kingteller.bs.service.inner.business.BusinessProductAduitAtomService;

@Component("businessProductAduitAtomService")
public class BusinessProductAduitAtomServiceImpl extends MyBatisDao implements BusinessProductAduitAtomService {

	@Autowired
	private BusinessProductAduitDao businessProductAduitDao;
	@Override
	public boolean insertBusinessProductAduit(
			BusinessProductAduit businessProductAduit) throws Exception {
		return this.businessProductAduitDao.insertBusinessProductAduit(businessProductAduit);
	}

}
