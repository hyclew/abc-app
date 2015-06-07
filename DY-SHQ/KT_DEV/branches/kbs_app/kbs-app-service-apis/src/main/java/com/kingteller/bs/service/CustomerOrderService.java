package com.kingteller.bs.service;

import com.kingteller.bs.domain.order.CustomerOrderBase;
import com.kingteller.bs.domain.order.OrderCartsDomain;
import com.kingteller.bs.framework.rest.RestResponse;

/**
 * 订单服务
 * @author wangyafei
 *
 */
public interface CustomerOrderService {

	/**
	 * 获取用户订单信息
	 * @param sessionId
	 * @param detailedAduit
	 * @return
	 * @throws Exception
	 */
	public RestResponse getUserOrders(String sessionId, String detailedAduit) throws Exception;
	
	/**
	 * 获取用户订单基本信息
	 * @param sessionId
	 * @param detailedAduit
	 * @return
	 * @throws Exception
	 */
	public RestResponse getUserOrderBases(String sessionId, String detailedAduit) throws Exception;
	
	/**
	 * 查询订单详细信息
	 * @param orderBaseId
	 * @return
	 * @throws Exception
	 */
	public RestResponse getUserOrderDetaileds(Long orderBaseId) throws Exception;
	
	/**
	 * 查询针对于商家的详细订单信息
	 * @param orderBaseId
	 * @return
	 * @throws Exception
	 */
	public RestResponse getBusinessAndOrderDetaileds(Long orderBaseId) throws Exception;
	
	/**
	 * 更成订单号
	 * @param code
	 * @return
	 */
	public String generateOrderNumber(String code) throws Exception;
	
	/**
	 * 生成订单详细的订单号
	 * @return
	 */
	public String generateOrderDetailNumber(String orderBaseNumber, int index) throws Exception;
	
	/**
	 * 生成用户订单
	 * @param orderCartsDomain
	 * @return
	 * @throws Exception
	 */
	public RestResponse generateUserOrder(OrderCartsDomain orderCartsDomain) throws Exception;
	
	/**
	 * 删除用户订单
	 * @return
	 */
	public RestResponse deleteUserOrder(CustomerOrderBase customerOrderBase) throws Exception;
}
