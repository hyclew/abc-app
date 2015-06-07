package com.kingteller.bs.service;

import com.kingteller.bs.domain.user.HeadPortraitDomail;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.domain.user.RegisterCode;
import com.kingteller.bs.domain.user.UserBase;
import com.kingteller.bs.domain.user.UserDetailed;
import com.kingteller.bs.domain.user.UserInfoDomain;
import com.kingteller.bs.framework.rest.RestResponse;

/**
 * 用户相关Service
 * @author wangyafei
 *
 */
public interface UserService {

	/**
	 * 用户注册
	 * @param userLogin
	 * @param userBase
	 * @param userDetailed
	 * @return
	 * @throws Exception
	 */
	public RestResponse register(UserBase userBase, UserDetailed userDetailed, LoginUser loginUser) throws Exception;
	
	/**
	 * 用户登录
	 * @param password 密码
	 * @param username 账号
	 * @return
	 * @throws Exception
	 */
	public RestResponse login(String username, String password) throws Exception;
	
	/**
	 * 用户上传头像
	 * @param headPortraitDomail
	 * @return
	 * @throws Exception
	 */
	public RestResponse uploadPortrait(HeadPortraitDomail headPortraitDomail) throws Exception;
	
	/**
	 * 根据SessionId判断用户当前是否处于登录状态
	 * @param sessionId
	 * @return
	 * @throws Exception
	 */
	public boolean isLogin(String sessionId) throws Exception;
	
	/**
	 * 生产验证码
	 * @param registerCode
	 * @return
	 * @throws Exception
	 */
	public RestResponse generateCheckCode(RegisterCode registerCode) throws Exception;
	
	
}
