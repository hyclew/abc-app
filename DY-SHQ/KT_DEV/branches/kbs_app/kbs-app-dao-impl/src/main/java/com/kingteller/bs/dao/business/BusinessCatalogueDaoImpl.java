package com.kingteller.bs.dao.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.dao.user.BusinessCatalogueDao;
import com.kingteller.bs.domain.business.BusinessCatalogue;

@Component("businessCatalogueDao")
public class BusinessCatalogueDaoImpl extends MyBatisDao implements
		BusinessCatalogueDao {

	private static final String NAMESPACE = "BusinessCatalogue";
	@Override
	public List<BusinessCatalogue> queryUserBaseByList(String businessid) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("businessid", businessid);
		return this.getSqlSession().selectList(NAMESPACE + ".queryUserBaseByList", params);
	}

	@Override
	public BusinessCatalogue insertBusinessCatalogue(BusinessCatalogue businessCatalogue) throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertBusinessCatalogue", businessCatalogue);
		return count <= 0 ? null : businessCatalogue;
	}

}
