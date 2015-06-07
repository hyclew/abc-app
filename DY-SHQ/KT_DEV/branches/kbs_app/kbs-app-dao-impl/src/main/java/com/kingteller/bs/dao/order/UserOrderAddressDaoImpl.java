package com.kingteller.bs.dao.order;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.order.UserOrderAddress;

@Component("userOrderAddressDao")
public class UserOrderAddressDaoImpl extends MyBatisDao implements UserOrderAddressDao{

	private static final String NAMESPACE = "UserOrderAddress";
	
	@Override
	public boolean insertUserOrderAddress(UserOrderAddress userOrderAddress)
			throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertUserOrderAddress", userOrderAddress);
		return count <=0 ? false : true;
	}

	@Override
	public List<UserOrderAddress> queryAddressByUserId(UserOrderAddress userOrderAddress)
			throws Exception {
		return this.getSqlSession().selectList(NAMESPACE + ".queryAddressByUserId", userOrderAddress);
	}

	
	
}
