package com.kingteller.bs.service.inner.order;

import java.util.List;

import com.kingteller.bs.domain.order.BusinessOrder;

public interface BusinessOrderAtomService {

	/**
	 * 根据OrderBaseId查询BusinessOrder
	 * @param orderBaseId
	 * @return
	 * @throws Exception
	 */
	public List<BusinessOrder> getBusinessOrderByOrderBaseId(Long orderBaseId) throws Exception;
	
	/**
	 * 插入一条商家订单信息
	 * @param businessOrder
	 * @return
	 * @throws Exception
	 */
	public BusinessOrder insertBusinessOrder(BusinessOrder businessOrder) throws Exception;
}
