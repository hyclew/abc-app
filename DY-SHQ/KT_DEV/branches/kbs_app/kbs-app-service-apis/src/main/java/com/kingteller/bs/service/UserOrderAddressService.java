package com.kingteller.bs.service;

import com.kingteller.bs.domain.order.UserOrderAddress;
import com.kingteller.bs.framework.rest.RestResponse;

/**
 * 收获人相关服务
 * @author wangyafei
 *
 */
public interface UserOrderAddressService {

	/**
	 * 查询用户收获地址信息
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public RestResponse getUserOrderAddresses(String sessionId) throws Exception;
	
	/**
	 * 插入一条收货人信息
	 * @param userOrderAddress
	 * @return
	 * @throws Exception
	 */
	public RestResponse insertUserOrderAddress(String sessionId, UserOrderAddress userOrderAddress) throws Exception;
	
}
