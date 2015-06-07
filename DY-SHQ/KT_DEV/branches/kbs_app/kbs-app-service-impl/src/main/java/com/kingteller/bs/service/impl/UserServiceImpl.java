package com.kingteller.bs.service.impl;

import java.io.File;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.order.UserOrderAddress;
import com.kingteller.bs.domain.resources.Resources;
import com.kingteller.bs.domain.user.HeadPortraitDomail;
import com.kingteller.bs.domain.user.LoginUser;
import com.kingteller.bs.domain.user.RegisterCode;
import com.kingteller.bs.domain.user.UserBase;
import com.kingteller.bs.domain.user.UserDetailed;
import com.kingteller.bs.domain.user.UserSession;
import com.kingteller.bs.framework.base64.Base64Converter;
import com.kingteller.bs.framework.check.StringUtils;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.file.FileUtil;
import com.kingteller.bs.framework.properties.InitializeProperties;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.framework.session.SessionUtil;
import com.kingteller.bs.service.UserService;
import com.kingteller.bs.service.inner.order.UserOrderAddressAtomService;
import com.kingteller.bs.service.inner.resources.ResourcesAtomService;
import com.kingteller.bs.service.inner.user.LoginUserAtomService;
import com.kingteller.bs.service.inner.user.RegisterCodeAtomService;
import com.kingteller.bs.service.inner.user.UserBaseAtomService;
import com.kingteller.bs.service.inner.user.UserDetailedAtomService;
import com.kingteller.bs.service.inner.user.UserSessionAtomService;

@Component("userService")
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger
			.getLogger(UserServiceImpl.class);

	@Autowired
	private LoginUserAtomService loginUserAtomService;

	@Autowired
	private UserBaseAtomService userBaseAtomService;

	@Autowired
	private UserDetailedAtomService userDetailedAtomService;

	@Autowired
	private UserOrderAddressAtomService userOrderAddressAtomService;

	@Autowired
	private UserSessionAtomService userSessionAtomService;

	@Autowired
	private ResourcesAtomService resourcesAtomService;
	
	@Autowired
	private RegisterCodeAtomService registerCodeAtomService;

	@Override
	public RestResponse register(UserBase userBase, UserDetailed userDetailed, LoginUser loginUser)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		try {
			// 校验此用户是否已经被注册
			String username = loginUser.getUsername();
			String phone = userBase.getPhone();
			int loginUserCount = this.loginUserAtomService
					.queryUserCountByUsername(username);
			int uesrBaseCount = this.userBaseAtomService
					.queryUserBaseCountByPhone(phone);
			if (loginUserCount > 0) {
				logger.error("用户名已被注册");
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("用户名已被注册");
			} else if (uesrBaseCount > 0) {
				logger.error("手机号已被注册");
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("手机号已被注册");
			} else {
				// 将用户类型设置为买家
				userBase.setUserType(Constant.USER_TYPE_BUYER);
				userBase = this.userBaseAtomService.insertUserBase(userBase);
				Long userBaseId = null;
				if (null != userBase) {
					userBaseId = userBase.getId();
					logger.info("插入的UserBase的ID是:" + userBaseId);
					if (null != userBaseId && userBaseId > 0) {
						loginUser.setUserId(userBaseId);
						loginUser.setStatus(Constant.USER_LOGIN_ENABLED); // 设置买家状态为可用
						userDetailed.setUserBaseId(userBaseId);

						UserOrderAddress userOrderAddress = new UserOrderAddress();
						userOrderAddress.setName(userBase.getName());
						userOrderAddress.setAddress(userBase.getAddress());
						userOrderAddress.setPhone(userBase.getPhone());
						userOrderAddress.setUserId(userBaseId);

						boolean loginUserIsSuccess = false;
						boolean userDetailedIsSuccess = false;
						boolean userOrderAddressIsSuccess = false;
						try {
							loginUserIsSuccess = this.loginUserAtomService
									.insertLoginUser(loginUser);
							userDetailedIsSuccess = this.userDetailedAtomService
									.insertUserDetailed(userDetailed);
							userOrderAddressIsSuccess = this.userOrderAddressAtomService
									.insertUserOrderAddress(userOrderAddress);
						} catch (Exception e) {
							logger.error("插入用户基本信息、用户详细信息或订单地址信息失败", e);
							header.setErrorCode(ErrorCode.OPERATE_FAIL);
							header.setMessage("保存登录信息、详细信息或订单地址信息失败");
						}

						if (loginUserIsSuccess && userDetailedIsSuccess
								&& userOrderAddressIsSuccess) {
							logger.info("注册成功!");
							header.setErrorCode(ErrorCode.SUCCESS);
							header.setMessage("注册成功");
						}
					} else {
						logger.error("获取插入后的UserBase对象的ID失败");
						header.setErrorCode(ErrorCode.OPERATE_FAIL);
						header.setMessage("获取插入后的UserBase对象的ID失败");
					}
				} else {
					logger.error("插入UserBase失败");
					header.setErrorCode(ErrorCode.OPERATE_FAIL);
					header.setMessage("保存用户基本信息失败");
				}
			}
		} catch (Exception e) {
			logger.error("注册失败，失败原因是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("注册失败");
		}
		response.setResponseHeader(header);
		response.setResponseBody(null);
		return response;
	}

	@Override
	public RestResponse login(String username, String password)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		try {
			LoginUser loginUser = null;
			// 先通过账号查询
			loginUser = this.loginUserAtomService.queryUserByNameAndPwd(
					username, password);
			logger.info("通过账号查询到的登录用户信息为:" + loginUser);
			if (null != loginUser) { // 账号密码正确
				// 判断账号是否可用
				if (Constant.USER_LOGIN_DISABLED.equals(loginUser.getStatus())) {
					header.setErrorCode(ErrorCode.OPERATE_FAIL);
					header.setMessage("账号已被禁用");
				} else {
					// 查找UserBase，判断用户类型是否为买家
					Long userBaseId = loginUser.getUserId();
					UserBase userBase = this.userBaseAtomService
							.queryByUserId(userBaseId);
					if (Constant.USER_TYPE_BUYER.equals(userBase.getUserType())) {
						// 保存会话信息
						UserSession userSession = this.updateSession(loginUser
								.getUsername());
						if (null != userSession) {
							logger.info("登录成功");
							header.setErrorCode(ErrorCode.SUCCESS);
							header.setMessage("登录成功");
							response.setResponseBody(userSession);
						} else {
							header.setErrorCode(ErrorCode.OPERATE_FAIL);
							header.setMessage("保存会话信息失败导致登录失败");
						}
					} else {
						logger.info("用户 " + loginUser.getUsername() + " 不是买家");
						header.setErrorCode(ErrorCode.OPERATE_FAIL);
						header.setMessage("用户名或密码错误");
					}
				}
			} else { // 再通过手机号查询
				UserBase userBase = this.userBaseAtomService
						.queryUserBaseByPhone(username,
								Constant.USER_TYPE_BUYER);
				logger.info("通过手机号查询到的用户基本信息为:" + userBase);
				if (null != userBase) {
					Long userBaseId = userBase.getId();
					// 在通过userBaseId和password查询LoginUser
					loginUser = this.loginUserAtomService
							.queryUserByUserBaseIdAndPwd(userBaseId, password);
					logger.info("通过手机号查询到的登录用户信息为:" + loginUser);
					if (null != loginUser) {
						// 判断账号是否可用
						if (Constant.USER_LOGIN_DISABLED.equals(loginUser
								.getStatus())) {
							header.setErrorCode(ErrorCode.OPERATE_FAIL);
							header.setMessage("账号已被禁用");
						} else {
							UserSession userSession = this
									.updateSession(loginUser.getUsername());
							if (null != userSession) {
								logger.info("登录成功");
								header.setErrorCode(ErrorCode.SUCCESS);
								header.setMessage("登录成功");
								response.setResponseBody(userSession);
							} else {
								header.setErrorCode(ErrorCode.OPERATE_FAIL);
								header.setMessage("保存会话信息失败导致登录失败");
							}
						}
					} else {
						header.setErrorCode(ErrorCode.OPERATE_FAIL);
						header.setMessage("用户名或密码错误");
					}
				} else {
					header.setErrorCode(ErrorCode.OPERATE_FAIL);
					header.setMessage("用户名或密码错误");
				}
			}
		} catch (Exception e) {
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("登录异常");
			logger.error("用户登录出现异常 ，异常信息为:" + e.getLocalizedMessage(), e);
		}
		response.setResponseHeader(header);
		return response;
	}

	/**
	 * 更新用户会话
	 * 
	 * @param username
	 * @return
	 * @throws Exception
	 */
	private UserSession updateSession(String username) throws Exception {
		// 先将以前的会话信息设置为不可用
		this.userSessionAtomService.updateUserSessionByUsername(username,
				Constant.USER_SESSION_DISABLED);
		// 添加新的会话
		// 获取用户的SessionId
		String sessionId = SessionUtil.generateSessionId(username);
		UserSession userSession = new UserSession();
		userSession.setSessionId(sessionId);
		userSession.setUsername(username);
		userSession.setStatus(Constant.USER_SESSION_ENABLED);
		// 插入新的SessionId
		return this.userSessionAtomService.insertUserSession(userSession);
	}

	@Override
	public RestResponse uploadPortrait(HeadPortraitDomail headPortraitDomail)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		try {
			// 将头像写入到硬盘
			String path = InitializeProperties.getProperty("user.portrait");
			String fileName = StringUtils.getRandomString(15)
					+ headPortraitDomail.getPicSuffix();
			byte[] buff = Base64Converter.decodeBase64(headPortraitDomail
					.getHeadPortrait());
			FileUtil.writeFile(buff, fileName, path);

			// 将头像信息保存进数据库
			Resources resources = new Resources();
			resources.setResourceURL(path + fileName);
			resources.setName(fileName);
			resources = this.resourcesAtomService.insertResource(resources);
			if (null == resources) {
				logger.info("保存头像信息到数据库失败");
				header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
				header.setMessage("保存头像信息到数据库失败");
			} else {
				// 通过SessionId查找用戶名
				UserSession userSession = this.userSessionAtomService
						.queryBySessionId(headPortraitDomail.getSessionId());
				String username = userSession.getUsername();
				logger.info("SessionId对应的用户名是:" + username);

				// 通过用戶名查找UserBaseId
				LoginUser loginUser = this.loginUserAtomService
						.queryLoginUserByUsername(username);
				Long userBaseId = loginUser.getUserId();
				logger.info("查找到的UserBaseId是:" + userBaseId);

				// 通过userBaseId查找更新前的resourceid
				UserBase userBase = this.userBaseAtomService
						.queryByUserId(userBaseId);
				Long oldResourceId = userBase.getResourceId(); // 老的资源ID，在新的添加成功后将老的删除掉
				logger.info("老的资源ID是:" + oldResourceId);
				Resources oldResource = this.resourcesAtomService
						.getResourceById(oldResourceId);

				Long resourceId = resources.getId();
				logger.info("添加后的资源ID是:" + resourceId);
				// 更新用户信息
				this.userBaseAtomService.updateResorceIdByUserId(userBaseId,
						resourceId);

				if (null != oldResource) {
					// 删除旧的头像信息
					this.resourcesAtomService.deleteResourceById(oldResourceId);
					String oldURL = oldResource.getResourceURL();
					FileUtil.deleteFile(oldURL);
				}

				logger.info("上传头像成功");
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("上传头像成功");
				response.setResponseBody(resources);
			}
		} catch (Exception e) {
			logger.error("上传头像发生异常，异常信息为:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("上传头像失败");
		}
		response.setResponseHeader(header);
		return response;
	}

	@Override
	public boolean isLogin(String sessionId) throws Exception {
		logger.info("开始检测用户登录状态,SessionId是 " + sessionId);
		UserSession userSession = null;
		LoginUser loginUser = null;
		try {
			userSession = this.userSessionAtomService
					.queryBySessionId(sessionId);
			logger.info("根据SessionId查询到的UserSession是 " + userSession);
			if (null == userSession) {
				return false;
			} else {
				String status = userSession.getStatus();
				if (null != status
						&& Constant.USER_SESSION_ENABLED.equals(status)) {
					// 在SessionId未失效的情况下继续判断用户的登录状态
					String username = userSession.getUsername();
					if (null != username) {
						loginUser = this.loginUserAtomService
								.queryLoginUserByUsername(username);
						logger.info("根据username查询到的LoginUser是 " + loginUser);
						if (null != loginUser) {
							String userStatus = loginUser.getStatus();
							// 如果用户状态为登录，则说明用户处于登录状态
							if (null != userStatus
									&& Constant.USER_LOGIN_ENABLED
											.equals(userStatus)) {
								return true;
							} else {
								return false;
							}
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			logger.error("验证用户是否登录出错", e);
		}
		return false;
	}

	@Override
	public RestResponse generateCheckCode(RegisterCode registerCode)
			throws Exception {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		try {
			registerCode.setStatus(Constant.REGISTER_CHECK_CODE_DISABLED);
			//先将此手机号之前生成的验证码状态置为不可用,再重新生成新的验证码
			this.registerCodeAtomService.updateCodeByPhone(registerCode);
			
			registerCode.setStatus(Constant.REGISTER_CHECK_CODE_ENABLED);
			registerCode.setUpdateTime(new Date());
			int count = this.registerCodeAtomService.insertRegisterCode(registerCode);
			if(count > 0){
				registerCode = this.registerCodeAtomService.queryCodeById(registerCode);
				logger.info("生成验证码成功,生成的验证码信息为:" + registerCode);
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("生成验证码成功");
				response.setResponseBody(registerCode.getCheckCode());
			}else{
				logger.info("生成验证码失败");
				header.setErrorCode(ErrorCode.OPERATE_FAIL);
				header.setMessage("生成验证码失败");
			}
			
		} catch (Exception e) {
			logger.error("生成验证码发生异常，异常信息为:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.INSERT_EXCEPTION);
			header.setMessage("生成验证码失败");
			e.printStackTrace();
		}
		response.setResponseHeader(header);
		return response;
	}

}
