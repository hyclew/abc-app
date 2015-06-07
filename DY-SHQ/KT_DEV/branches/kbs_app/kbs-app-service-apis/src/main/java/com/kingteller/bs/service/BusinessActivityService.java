package com.kingteller.bs.service;

import org.springframework.web.bind.annotation.PathVariable;

import com.kingteller.bs.framework.rest.RestResponse;

public interface BusinessActivityService {

	/**
	 * 查看商家活动信息
	 * @return
	 * @throws Exception
	 */
	public RestResponse queryBusinessActivitys(Long maxId, int dataCount) throws Exception;
	
}
