package com.kingteller.bs.dao.order;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.order.BusinessOrder;

@Component("businessOrderDao")
public class BusinessOrderDaoImpl extends MyBatisDao implements BusinessOrderDao {

	private static final String NAMESPACE = "BusinessOrder"; 
	
	@Override
	public List<BusinessOrder> getBusinessOrderByOrderBaseId(Long orderBaseId)
			throws Exception {
		return this.getSqlSession().selectList(NAMESPACE + ".getBusinessOrderByOrderBaseId", orderBaseId);
	}

	@Override
	public BusinessOrder insertBusinessOrder(BusinessOrder businessOrder)
			throws Exception {
		this.getSqlSession().insert(NAMESPACE + ".insertBusinessOrder", businessOrder);
		return businessOrder;
	}

	
	
}
