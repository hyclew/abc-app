package com.kingteller.bs.dao.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.mysql.MyBatisDao;
import com.kingteller.bs.domain.business.BusinessProductComment;

@Component("businessProductCommentDao")
public class BusinessProductCommentDaoImpl extends MyBatisDao implements BusinessProductCommentDao {
	
	private static final String NAMESPACE = "BusinessProductComment";

	@Override
	public List<BusinessProductComment> queryCommentsByProductId(Long businessProductId, Long maxId, int count, String status)
			throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("businessProductId", businessProductId);
		params.put("maxId", maxId);
		params.put("count", count);
		params.put("status", status);
		
		return this.getSqlSession().selectList(NAMESPACE + ".queryCommentsByProductId", params);
	}
	
}