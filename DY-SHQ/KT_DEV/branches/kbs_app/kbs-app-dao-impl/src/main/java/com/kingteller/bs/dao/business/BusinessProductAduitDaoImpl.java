package com.kingteller.bs.dao.business;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.business.BusinessProductAduit;

@Component("businessProductAduitDao")
public class BusinessProductAduitDaoImpl extends MyBatisDao implements BusinessProductAduitDao {

	private static final String NAMESPACE = "BusinessProductAduit";
	
	@Override
	public boolean insertBusinessProductAduit(
			BusinessProductAduit businessProductAduit) throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertBusinessProductAduit", businessProductAduit);
		return count <=0 ? false : true;
	}
   
}