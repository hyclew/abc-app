package com.kingteller.bs.service.inner.business;

import java.util.List;
import java.util.Map;

import com.kingteller.bs.domain.business.BusinessBase;

public interface BusinessBaseAtomService {

	/**
	 * 根据用户ID查询
	 * @return
	 * @throws Exception
	 */
	public BusinessBase queryBusinessBaseByUserId(String userid) throws Exception;
	
	/**
	 * 根据商家名称查询
	 * @return
	 * @throws Exception
	 */
	public BusinessBase queryBusinessBaseByName(String name) throws Exception;

	/**
	 * 插入一个BusinessBase对象
	 * @param businessBase
	 * @return
	 * @throws Exception
	 */
	public BusinessBase insertBusinessBase(BusinessBase businessBase) throws Exception;
	
	/**
	 * 通过ID查询商家信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BusinessBase queryBusinessById(Long id) throws Exception;
	
	/**
	 * 更新商家产品分类
	 * @param userId
	 * @param resourceId
	 * @throws Exception
	 */
	public void updateBusinessBaseById(Long Id, Long productcatalogueid) throws Exception;
	
	
	/**
	 * 更新商家状态分类
	 * @param userId
	 * @param resourceId
	 * @throws Exception
	 */
	public void updateBusinessBaseBStatus(Long Id, String status) throws Exception;
	
	/**
	 * 根据商家名称或者商家联系人查询
	 * @return
	 * @throws Exception
	 */
	public List<BusinessBase> queryBusinessBaseByAll(String contractname,String name) throws Exception;
	
	/**
	 * 更新商家信息
	 * @param userId
	 * @param resourceId
	 * @throws Exception
	 */
	public void updateBusinessBase(BusinessBase businessBase) throws Exception;
}
