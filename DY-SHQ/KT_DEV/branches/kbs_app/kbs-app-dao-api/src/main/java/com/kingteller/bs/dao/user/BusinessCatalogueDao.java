package com.kingteller.bs.dao.user;

import java.util.List;

import com.kingteller.bs.domain.business.BusinessCatalogue;

public interface BusinessCatalogueDao {

	
	/**
	 * 根据商家用户id查询
	 * @return
	 * @throws Exception
	 */
	public List<BusinessCatalogue> queryUserBaseByList(String businessid) throws Exception;
	
	/**
	 * 插入一个BusinessCatalogue对象
	 * @param userBase
	 * @return
	 * @throws Exception
	 */
	public BusinessCatalogue insertBusinessCatalogue(BusinessCatalogue businessCatalogue) throws Exception;
}
