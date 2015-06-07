package com.kingteller.bs.service;

import com.kingteller.bs.domain.resources.Resources;

/**
 * 产品资源Service
 * @author wangyafei
 *
 */
public interface ResourcesService {

	/**
	 * 根据资源ID查询资源
	 * @return
	 * @throws Exception
	 */
	public Resources getResourceById(Long resourceId) throws Exception;
	
}
