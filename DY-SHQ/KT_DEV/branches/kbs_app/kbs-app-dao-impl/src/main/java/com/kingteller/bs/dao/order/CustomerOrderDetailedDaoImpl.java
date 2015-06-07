package com.kingteller.bs.dao.order;

import java.util.List;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.order.CustomerOrderDetailed;

@Component("customerOrderDetailedDao")
public class CustomerOrderDetailedDaoImpl extends MyBatisDao implements CustomerOrderDetailedDao {

	private static final String NAMESPACE = "CustomerOrderDetailed";
	
	@Override
	public List<CustomerOrderDetailed> getUserOrderDetailsByOrderId(
			CustomerOrderDetailed customerOrderDetailed) throws Exception {
		return this.getSqlSession().selectList(NAMESPACE + ".getUserOrderDetailsByOrderId", customerOrderDetailed);
	}

	@Override
	public List<CustomerOrderDetailed> getUserOrderDetailsByBusinessOrderId(
			Long businessOrderId) throws Exception {
		return this.getSqlSession().selectList(NAMESPACE + ".getUserORderDetailsByBusinessOrderId", businessOrderId);
	}

	@Override
	public CustomerOrderDetailed insertCustomerOrderDetailed(
			CustomerOrderDetailed customerOrderDetailed) throws Exception {
		this.getSqlSession().insert(NAMESPACE + ".insertCustomerOrderDetailed", customerOrderDetailed);
		return customerOrderDetailed;
	}

}
