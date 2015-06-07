package com.kingteller.bs.dao.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.business.BusinessBase;

@Component("businessBaseDao")
public class BusinessBaseDaoImpl extends MyBatisDao implements BusinessBaseDao {

	private static final String NAMESPACE = "BusinessBase";
	@Override
	public BusinessBase queryBusinessBaseByUserId(String userid) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userid);
		return this.getSqlSession().selectOne(NAMESPACE + ".queryBusinessBaseByUserId", params);
	}
	@Override
	public BusinessBase queryBusinessBaseByName(String name) throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		return this.getSqlSession().selectOne(NAMESPACE + ".queryBusinessBaseByName", params);
	}
	@Override
	public BusinessBase insertBusinessBase(BusinessBase businessBase)
			throws Exception {
		int count = this.getSqlSession().insert(NAMESPACE + ".insertBusinessBase", businessBase);
		return count <= 0 ? null : businessBase;
	}
	
	@Override
	public BusinessBase queryBusinessById(Long id) throws Exception {
		return this.getSqlSession().selectOne(NAMESPACE + ".queryBusinessById", id);
	}
	
	@Override
	public void updateBusinessBaseById(Long Id, Long productcatalogueid)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", Id);
		params.put("productcatalogueid", productcatalogueid);
		this.getSqlSession().update(NAMESPACE + ".updateBusinessBaseById", params);
		
	}
	@Override
	public void updateBusinessBaseBStatus(Long Id, String status)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", Id);
		params.put("status", status);
		this.getSqlSession().update(NAMESPACE + ".updateBusinessBaseBStatus", params);
		
	}
	@Override
	public List<BusinessBase> queryBusinessBaseByAll(String contractname, String name)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("contractname", contractname);
		params.put("name", name);
		return this.getSqlSession().selectList(NAMESPACE + ".queryBusinessBaseByAll", params);
	}
	@Override
	public void updateBusinessBase(BusinessBase businessBase)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", businessBase.getId());
		params.put("name", businessBase.getName());
		params.put("address", businessBase.getAddress());
		params.put("contractname", businessBase.getContractname());
		this.getSqlSession().update(NAMESPACE + ".updateBusinessBase", params);
	}
  
}