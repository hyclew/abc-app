package com.kingteller.bs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.business.BusinessProductAdvert;
import com.kingteller.bs.service.BusinessProductAdvertService;
import com.kingteller.bs.service.inner.business.BusinessProductAdvertAtomService;

@Component("businessProductAdvertService")
public class BusinessProductAdvertServiceImpl implements
		BusinessProductAdvertService {

	@Autowired
	private BusinessProductAdvertAtomService businessProductAdvertAtomService;

	@Override
	public List<BusinessProductAdvert> getLatestProductAdverts(String status,
			int count) throws Exception {
		return this.businessProductAdvertAtomService.getLatestProductAdverts(status, count);
	}
	
}
