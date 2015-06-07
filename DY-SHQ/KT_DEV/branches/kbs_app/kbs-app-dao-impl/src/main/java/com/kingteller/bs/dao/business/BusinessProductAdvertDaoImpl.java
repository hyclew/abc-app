package com.kingteller.bs.dao.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.business.BusinessProductAdvert;

@Component("businessProductAdvertDao")
public class BusinessProductAdvertDaoImpl extends MyBatisDao implements BusinessProductAdvertDao {
  
	private static final String NAMESPACE = "BusinessProductAdvert";


	@Override
	public List<BusinessProductAdvert> getLatestProductAdverts(String status,
			int count) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", status);
		params.put("count", count);
		return this.getSqlSession().selectList(NAMESPACE + ".getBusinessProductAdvert", params);
	}
	
	
	
	
	
}