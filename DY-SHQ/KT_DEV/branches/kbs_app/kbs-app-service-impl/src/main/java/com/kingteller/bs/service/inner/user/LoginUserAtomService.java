package com.kingteller.bs.service.inner.user;

import com.kingteller.bs.domain.user.LoginUser;

public interface LoginUserAtomService {

	/**
	 * 插入LoginUser
	 * @param loginUser
	 * @return
	 * @throws Exception
	 */
	public boolean insertLoginUser(LoginUser loginUser) throws Exception;
	
	/**
	 * 根据账号和密码查询登录用户
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public LoginUser queryUserByNameAndPwd(String username, String password) throws Exception;
	
	/**
	 * 根据userBaseId和密码查询LoginUser
	 * @param userBaseId
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public LoginUser queryUserByUserBaseIdAndPwd(Long userBaseId, String password) throws Exception;
	
	/**
	 * 根据用户名查找用户数量
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public Integer queryUserCountByUsername(String username) throws Exception;
	
	/**
	 * 根據用戶名查詢用戶信息
	 * @return
	 * @throws Exception
	 */
	public LoginUser queryLoginUserByUsername(String username) throws Exception;
}
