package com.kingteller.bs.service.inner.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.order.UserOrderAddressDao;
import com.kingteller.bs.domain.order.UserOrderAddress;
import com.kingteller.bs.service.inner.order.UserOrderAddressAtomService;

@Component("userOrderAddressAtomService")
public class UserOrderAddressAtomServiceImpl implements
		UserOrderAddressAtomService {

	@Autowired
	private UserOrderAddressDao userOrderAddressDao;
	
	@Override
	public boolean insertUserOrderAddress(UserOrderAddress userOrderAddress)
			throws Exception {
		return this.userOrderAddressDao.insertUserOrderAddress(userOrderAddress);
	}

	@Override
	public List<UserOrderAddress> queryAddressByUserId(UserOrderAddress userOrderAddress)
			throws Exception {
		return this.userOrderAddressDao.queryAddressByUserId(userOrderAddress);
	}

}
