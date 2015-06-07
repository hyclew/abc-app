package com.kingteller.bs.service.inner.impl.business;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.business.BusinessBaseDao;
import com.kingteller.bs.domain.business.BusinessBase;
import com.kingteller.bs.service.inner.business.BusinessBaseAtomService;

@Component("businessBaseAtomService")
public class BusinessBaseAtomServiceImpl implements BusinessBaseAtomService {

	@Autowired
	private BusinessBaseDao businessBaseDao;
	
	@Override
	public BusinessBase queryBusinessBaseByUserId(String userid) throws Exception {
		// TODO Auto-generated method stub
		return this.businessBaseDao.queryBusinessBaseByUserId(userid);
	}

	@Override
	public BusinessBase queryBusinessBaseByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return this.businessBaseDao.queryBusinessBaseByName(name);
	}

	@Override
	public BusinessBase insertBusinessBase(BusinessBase businessBase)
			throws Exception {
		// TODO Auto-generated method stub
		return this.businessBaseDao.insertBusinessBase(businessBase);
	}

	@Override
	public BusinessBase queryBusinessById(Long id) throws Exception {
		return this.businessBaseDao.queryBusinessById(id);
	}
	
	@Override
	public void updateBusinessBaseById(Long Id, Long productcatalogueid)
			throws Exception {
		this.businessBaseDao.updateBusinessBaseById(Id, productcatalogueid);
	}

	@Override
	public void updateBusinessBaseBStatus(Long Id, String status)
			throws Exception {
		this.businessBaseDao.updateBusinessBaseBStatus(Id, status);
	}

	@Override
	public List<BusinessBase> queryBusinessBaseByAll(String contractname, String name)
			throws Exception {
		// TODO Auto-generated method stub
		return this.businessBaseDao.queryBusinessBaseByAll(contractname, name);
	}

	@Override
	public void updateBusinessBase(BusinessBase businessBase)
			throws Exception {
		this.businessBaseDao.updateBusinessBase(businessBase);
	}


}
