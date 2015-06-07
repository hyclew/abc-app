package com.kingteller.bs.service.inner.order;

import java.util.List;

import com.kingteller.bs.domain.order.CustomerOrderDetailed;

public interface CustomerOrderDetailedAtomService {

	/**
	 * 通过订单号查询订单详细信息
	 * @param customerOrderDetailed
	 * @return
	 * @throws Exception
	 */
	public List<CustomerOrderDetailed> getUserOrderDetailsByOrderId(CustomerOrderDetailed customerOrderDetailed) throws Exception;
	
	/**
	 * 根据BusinessOrder的ID查询订单详细信息
	 * @param businessOrderId
	 * @return
	 * @throws Exception
	 */
	public List<CustomerOrderDetailed> getUserOrderDetailsByBusinessOrderId(Long businessOrderId) throws Exception;
	
	/**
	 * 插入一条订单详细信息
	 * @param customerOrderDetailed
	 * @return
	 * @throws Exception
	 */
	public CustomerOrderDetailed insertCustomerOrderDetailed(CustomerOrderDetailed customerOrderDetailed) throws Exception;
}
