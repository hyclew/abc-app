package com.kingteller.bs.dao.user;

import com.kingteller.bs.domain.user.UserDetailed;

/**
 * UserDetailed相关DAO
 * @author wangyafei
 *
 */
public interface UserDetailedDao {

	/**
	 * 插入一个UserDetailed
	 * @param userDetailed
	 * @return
	 * @throws Exception
	 */
	public boolean insertUserDetailed(UserDetailed userDetailed) throws Exception;
	
}
