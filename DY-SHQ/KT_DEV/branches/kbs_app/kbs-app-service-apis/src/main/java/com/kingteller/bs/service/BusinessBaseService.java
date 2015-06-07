package com.kingteller.bs.service;

import java.util.List;

import com.kingteller.bs.domain.business.BusinessBase;
import com.kingteller.bs.domain.business.BusinessBaseDomail;

public interface BusinessBaseService {

	/**
	 * 根据用户ID查询
	 * name 商家名称
	 * phone 商家电话
	 * @return
	 * @throws Exception
	 */
	public List<BusinessBase> queryBusinessBaseAll(String name,String phone) throws Exception;
	
	/**
	 * 插入一个BusinessBase对象
	 * @param businessBase
	 * @return
	 * @throws Exception
	 */
	public boolean insertBusinessBase(BusinessBaseDomail businessBaseDomail) throws Exception;
	
	/**
	 * 更新商家状态分类
	 * @param userId
	 * @param resourceId
	 * @throws Exception
	 */
	public boolean updateBusinessBaseBStatus(List list) throws Exception;
	
	/**
	 * 通过ID查询商家信息
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public BusinessBase queryBusinessBaseAllByID(Long id) throws Exception;
	
	/**
	 * 更新商家信息
	 * @param userId
	 * @param resourceId
	 * @throws Exception
	 */
	public boolean updateBusinessBase(BusinessBase businessBase) throws Exception;
	
	/**
	 * 根据商家ID查询
	 * 查询商家基础信息表
	 * 查询用户基本信息表
	 * 查询支付工具表
	 * @return
	 * @throws Exception
	 */
	public BusinessBaseDomail queryBusinessBaseAll(Long id) throws Exception;
}
