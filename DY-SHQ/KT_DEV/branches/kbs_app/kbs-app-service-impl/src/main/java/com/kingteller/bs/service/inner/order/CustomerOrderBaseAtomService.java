package com.kingteller.bs.service.inner.order;

import java.util.List;

import com.kingteller.bs.domain.order.CustomerOrderBase;

public interface CustomerOrderBaseAtomService {

	/**
	 * 查询指定用户的、指定详细状态的未删除的用户订单
	 * @param customerOrderBase
	 * @return
	 * @throws Exception
	 */
	public List<CustomerOrderBase> queryOrderBaseByUserIdAndAduit(CustomerOrderBase customerOrderBase) throws Exception;
	
	/**
	 * 根据id查询订单基本信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public CustomerOrderBase queryOrderBaseById(Long id) throws Exception;
	
	/**
	 * 插入一条订单基本信息
	 * @return
	 * @throws Exception
	 */
	public CustomerOrderBase insertCustomerOrderBase(CustomerOrderBase customerOrderBase) throws Exception;
	
	/**
	 * 将订单状态改为已删除
	 * @param customerOrderBase
	 * @return
	 * @throws Exception
	 */
	public int updateCustomerOrderBase2Disabled(CustomerOrderBase customerOrderBase) throws Exception;
}
