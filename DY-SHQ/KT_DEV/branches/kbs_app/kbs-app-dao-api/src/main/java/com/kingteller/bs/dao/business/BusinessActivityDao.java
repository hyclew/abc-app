package com.kingteller.bs.dao.business;

import java.util.List;

import com.kingteller.bs.domain.business.BusinessActivity;

/**
 * 
 * @author wangyafei
 *
 */
public interface BusinessActivityDao {

	/**
	 * 查询商家活动信息
	 * @param businessActivity
	 * @return
	 * @throws Exception
	 */
	public List<BusinessActivity> queryBusinessActivitys(BusinessActivity businessActivity, Long maxId, int dataCount) throws Exception;
	
}
