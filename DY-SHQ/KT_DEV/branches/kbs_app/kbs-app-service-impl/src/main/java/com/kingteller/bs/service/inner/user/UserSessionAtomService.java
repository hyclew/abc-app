package com.kingteller.bs.service.inner.user;

import com.kingteller.bs.domain.user.UserSession;

public interface UserSessionAtomService {

	/**
	 * 插入一个用户会话信息
	 * @param userSession
	 * @return
	 * @throws Exception
	 */
	public UserSession insertUserSession(UserSession userSession) throws Exception;
	
	/**
	 * 通过用户名更新会话信息
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public int updateUserSessionByUsername(String username, String status) throws Exception;
	
	/**
	 * 通過SessionId查找UserSession
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public UserSession queryBySessionId(String sessionId) throws Exception;
}
