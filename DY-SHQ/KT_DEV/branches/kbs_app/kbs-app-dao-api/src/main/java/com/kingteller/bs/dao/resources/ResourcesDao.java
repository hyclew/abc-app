package com.kingteller.bs.dao.resources;

import com.kingteller.bs.domain.resources.Resources;

public interface ResourcesDao {

	/**
	 * 根据资源ID查询资源
	 * @return
	 * @throws Exception
	 */
	public Resources getResourceById(Long resourceId) throws Exception;
	
	/**
	 * 插入一個資源數據
	 * @param resources
	 * @return
	 * @throws Exception
	 */
	public Resources insertResource(Resources resources) throws Exception;
	
	/**
	 * 根据id删除资源信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteResourceById(Long id) throws Exception;
	
}
