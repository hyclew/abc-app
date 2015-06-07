package com.kingteller.bs.dao.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.business.BusinessActivity;

@Component("businessActivityDao")
public class BusinessActivityDaoImpl extends MyBatisDao implements BusinessActivityDao {

	private static final String NAMESPACE = "BusinessActivity";
	
	@Override
	public List<BusinessActivity> queryBusinessActivitys(BusinessActivity businessActivity, Long maxId, int dataCount)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("maxId", maxId);
		params.put("dataCount", dataCount);
		params.put("isEnabled", businessActivity.getIsEnabled());
		return this.getSqlSession().selectList(NAMESPACE + ".queryBusinessActivitys", params);
	}

}
