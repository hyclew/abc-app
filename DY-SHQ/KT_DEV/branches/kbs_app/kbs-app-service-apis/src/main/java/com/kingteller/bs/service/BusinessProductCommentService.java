package com.kingteller.bs.service;

import com.kingteller.bs.framework.rest.RestResponse;

public interface BusinessProductCommentService {

	/**
	 * 根据商品id查询商品评价
	 * @param businessProductId
	 * @param maxId
	 * @param count
	 * @return
	 */
	public RestResponse getCommentByProductId(Long businessProductId, Long maxId, int count);
	
}
