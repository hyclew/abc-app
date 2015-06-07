package com.kingteller.bs.service;

import com.kingteller.bs.domain.user.LoginUser;

public interface WelcomeControllerService {

	/**
	 * 根据账号和密码查询登录用户
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public LoginUser queryUserByNameAndPwd(String username, String password) throws Exception;
}
