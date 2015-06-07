package com.kingteller.bs.service.inner.order;

import java.util.List;

import com.kingteller.bs.domain.order.UserOrderAddress;

/**
 * 
 * @author wangyafei
 *
 */
public interface UserOrderAddressAtomService {

	/**
	 * 插入一条收货人信息
	 * @param userOrderAddress
	 * @return
	 * @throws Exception
	 */
	public boolean insertUserOrderAddress(UserOrderAddress userOrderAddress) throws Exception;
	
	/**
	 * 根据用户ID查询用户收获地址信息
	 * @param userBaseId
	 * @return
	 * @throws Exception
	 */
	public List<UserOrderAddress> queryAddressByUserId(UserOrderAddress userOrderAddress) throws Exception;
	
}
