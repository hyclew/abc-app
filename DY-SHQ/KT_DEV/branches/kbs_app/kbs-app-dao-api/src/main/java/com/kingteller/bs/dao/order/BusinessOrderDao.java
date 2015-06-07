package com.kingteller.bs.dao.order;

import java.util.List;

import com.kingteller.bs.domain.order.BusinessOrder;

/**
 * 商家订单信息DAO
 * @author wangyafei
 *
 */
public interface BusinessOrderDao {

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
