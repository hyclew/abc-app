package com.kingteller.bs.service.inner.user;

import com.kingteller.bs.domain.user.UserDetailed;

public interface UserDetailedAtomService {

	/**
	 * 插入一个UserDetailed
	 * @param userDetailed
	 * @return
	 * @throws Exception
	 */
	public boolean insertUserDetailed(UserDetailed userDetailed) throws Exception;
	
}
