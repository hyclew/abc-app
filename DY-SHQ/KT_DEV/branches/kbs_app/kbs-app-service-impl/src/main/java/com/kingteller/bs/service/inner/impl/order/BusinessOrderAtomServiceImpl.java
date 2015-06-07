package com.kingteller.bs.service.inner.impl.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.order.BusinessOrderDao;
import com.kingteller.bs.domain.order.BusinessOrder;
import com.kingteller.bs.service.inner.order.BusinessOrderAtomService;

@Component("businessOrderAtomService")
public class BusinessOrderAtomServiceImpl implements BusinessOrderAtomService{

	@Autowired
	private BusinessOrderDao businessOrderDao;
	
	@Override
	public List<BusinessOrder> getBusinessOrderByOrderBaseId(Long orderBaseId)
			throws Exception {
		return this.businessOrderDao.getBusinessOrderByOrderBaseId(orderBaseId);
	}

	@Override
	public BusinessOrder insertBusinessOrder(BusinessOrder businessOrder)
			throws Exception {
		return this.businessOrderDao.insertBusinessOrder(businessOrder);
	}

}
