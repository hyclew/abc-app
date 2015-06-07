package com.kingteller.bs.service.inner.impl.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.resources.ResourcesDao;
import com.kingteller.bs.domain.resources.Resources;
import com.kingteller.bs.service.inner.resources.ResourcesAtomService;

@Component("resourcesAtomService")
public class ResourcesAtomServiceImpl implements ResourcesAtomService{

	@Autowired
	private ResourcesDao resourcesDao;

	
	@Override
	public Resources getResourceById(Long resourceId) throws Exception {
		return this.resourcesDao.getResourceById(resourceId);
	}


	@Override
	public Resources insertResource(Resources resources) throws Exception {
		return this.resourcesDao.insertResource(resources);
	}


	@Override
	public void deleteResourceById(Long id) throws Exception {
		this.resourcesDao.deleteResourceById(id);
	}
	
	
	
}
