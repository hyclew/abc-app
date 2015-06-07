package com.kingteller.bs.service.inner.business;

import com.kingteller.bs.domain.business.BusinessProductAduit;


public interface BusinessProductAduitAtomService {

	/**
	 * 
	 * 更新商家审核表
	 * @param businessProductAduit
	 * @return
	 * @throws Exception
	 */
	public boolean insertBusinessProductAduit(BusinessProductAduit businessProductAduit) throws Exception;
}
