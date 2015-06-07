package com.kingteller.bs.service.inner.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.order.CustomerOrderBaseDao;
import com.kingteller.bs.domain.order.CustomerOrderBase;
import com.kingteller.bs.service.inner.order.CustomerOrderBaseAtomService;

@Component("customerOrderBaseAtomService")
public class CustomerOrderBaseAtomServiceImpl implements
		CustomerOrderBaseAtomService {

	@Autowired
	private CustomerOrderBaseDao customerOrderBaseDao;
	
	@Override
	public List<CustomerOrderBase> queryOrderBaseByUserIdAndAduit(
			CustomerOrderBase customerOrderBase) throws Exception {
		return this.customerOrderBaseDao.queryOrderBaseByUserIdAndAduit(customerOrderBase);
	}

	@Override
	public CustomerOrderBase queryOrderBaseById(Long id) throws Exception {
		return this.customerOrderBaseDao.queryOrderBaseById(id);
	}

	@Override
	public CustomerOrderBase insertCustomerOrderBase(
			CustomerOrderBase customerOrderBase) throws Exception {
		return this.customerOrderBaseDao.insertCustomerOrderBase(customerOrderBase);
	}

	@Override
	public int updateCustomerOrderBase2Disabled(
			CustomerOrderBase customerOrderBase) throws Exception {
		return this.customerOrderBaseDao.updateCustomerOrderBase2Disabled(customerOrderBase);
	}

}
