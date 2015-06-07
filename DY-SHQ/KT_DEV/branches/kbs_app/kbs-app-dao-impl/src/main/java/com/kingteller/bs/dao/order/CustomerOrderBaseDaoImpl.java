package com.kingteller.bs.dao.order;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.order.CustomerOrderBase;

@Component("customerOrderBaseDao")
public class CustomerOrderBaseDaoImpl extends MyBatisDao implements CustomerOrderBaseDao{

	private static final String NAMESPACE = "CustomerOrderBase";

	private static final Logger logger = Logger.getLogger(CustomerOrderBaseDaoImpl.class);
	
	@Override
	public List<CustomerOrderBase> queryOrderBaseByUserIdAndAduit(
			CustomerOrderBase customerOrderBase) throws Exception {
		logger.debug("查询查询用户订单信息，参数是:" + customerOrderBase);
		return this.getSqlSession().selectList(NAMESPACE + ".queryOrderBaseByUserIdAndAduit", customerOrderBase);
	}

	@Override
	public CustomerOrderBase queryOrderBaseById(Long id) throws Exception {
		return this.getSqlSession().selectOne(NAMESPACE + ".queryOrderBaseById", id);
	}

	@Override
	public CustomerOrderBase insertCustomerOrderBase(
			CustomerOrderBase customerOrderBase) throws Exception {
		this.getSqlSession().insert(NAMESPACE + ".insertCustomerOrderBase", customerOrderBase);
		return customerOrderBase;
	}

	@Override
	public int updateCustomerOrderBase2Disabled(
			CustomerOrderBase customerOrderBase) throws Exception {
		return this.getSqlSession().update(NAMESPACE + ".updateCustomerOrderBase2Disabled", customerOrderBase);
	}
	
}
