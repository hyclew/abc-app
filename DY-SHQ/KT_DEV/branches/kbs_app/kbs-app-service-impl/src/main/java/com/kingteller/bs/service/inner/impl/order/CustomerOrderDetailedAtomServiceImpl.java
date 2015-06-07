package com.kingteller.bs.service.inner.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.order.CustomerOrderDetailedDao;
import com.kingteller.bs.domain.order.CustomerOrderDetailed;
import com.kingteller.bs.service.inner.order.CustomerOrderDetailedAtomService;

@Component("customerOrderDetailedAtomService")
public class CustomerOrderDetailedAtomServiceImpl implements
		CustomerOrderDetailedAtomService {

	@Autowired
	private CustomerOrderDetailedDao customerOrderDetailedDao;
	
	@Override
	public List<CustomerOrderDetailed> getUserOrderDetailsByOrderId(
			CustomerOrderDetailed customerOrderDetailed) throws Exception {
		return this.customerOrderDetailedDao.getUserOrderDetailsByOrderId(customerOrderDetailed);
	}

	@Override
	public List<CustomerOrderDetailed> getUserOrderDetailsByBusinessOrderId(
			Long businessOrderId) throws Exception {
		return this.customerOrderDetailedDao.getUserOrderDetailsByBusinessOrderId(businessOrderId);
	}

	@Override
	public CustomerOrderDetailed insertCustomerOrderDetailed(
			CustomerOrderDetailed customerOrderDetailed) throws Exception {
		return this.customerOrderDetailedDao.insertCustomerOrderDetailed(customerOrderDetailed);
	}

}
