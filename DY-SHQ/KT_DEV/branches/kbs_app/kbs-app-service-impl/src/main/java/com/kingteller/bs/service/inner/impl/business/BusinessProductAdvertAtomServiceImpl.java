package com.kingteller.bs.service.inner.impl.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.business.BusinessProductAdvertDao;
import com.kingteller.bs.domain.business.BusinessProductAdvert;
import com.kingteller.bs.service.inner.business.BusinessProductAdvertAtomService;

@Component("businessProductAdvertAtomService")
public class BusinessProductAdvertAtomServiceImpl implements
		BusinessProductAdvertAtomService {

	@Autowired
	private BusinessProductAdvertDao businessProductAdvertDao;

	@Override
	public List<BusinessProductAdvert> getLatestProductAdverts(String status,
			int count) throws Exception {
		// TODO Auto-generated method stub
		return this.businessProductAdvertDao.getLatestProductAdverts(status, count);
	}
	
}
