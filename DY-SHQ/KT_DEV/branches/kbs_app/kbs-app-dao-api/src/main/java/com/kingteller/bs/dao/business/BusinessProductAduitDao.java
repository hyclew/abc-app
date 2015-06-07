package com.kingteller.bs.dao.business;

import com.kingteller.bs.domain.business.BusinessProductAduit;


public interface BusinessProductAduitDao {
	/**
	 * 
	 * 更新商家审核表
	 * @param businessProductAduit
	 * @return
	 * @throws Exception
	 */
	public boolean insertBusinessProductAduit(BusinessProductAduit businessProductAduit) throws Exception;
}