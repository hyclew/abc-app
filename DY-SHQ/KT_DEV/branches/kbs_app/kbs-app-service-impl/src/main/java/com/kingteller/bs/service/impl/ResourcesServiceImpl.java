package com.kingteller.bs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.resources.Resources;
import com.kingteller.bs.service.ResourcesService;
import com.kingteller.bs.service.inner.resources.ResourcesAtomService;

@Component("resourcesService")
public class ResourcesServiceImpl implements ResourcesService {

	@Autowired
	private ResourcesAtomService resourceAtomService;
	
	@Override
	public Resources getResourceById(Long resourceId) throws Exception {
		return this.resourceAtomService.getResourceById(resourceId);
		
	}

}
