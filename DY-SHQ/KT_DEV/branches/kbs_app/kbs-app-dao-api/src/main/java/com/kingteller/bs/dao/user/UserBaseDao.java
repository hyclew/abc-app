package com.kingteller.bs.dao.user;

import com.kingteller.bs.domain.user.UserBase;

/**
 * UserBase 相关DAO
 * @author wangyafei
 *
 */
public interface UserBaseDao {

	/**
	 * 插入一个UserBase对象
	 * @param userBase
	 * @return
	 * @throws Exception
	 */
	public UserBase insertUserBase(UserBase userBase) throws Exception;
	
	/**
	 * 根据手机号查询
	 * @return
	 * @throws Exception
	 */
	public UserBase queryUserBaseByPhone(String phone, String userType) throws Exception;
	
	/**
	 * 根据手机号查询用户个数
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public Integer queryUserBaseCountByPhone(String phone) throws Exception;
	
	/**
	 * 更新用户的头像信息
	 * @param userId
	 * @param resourceId
	 * @throws Exception
	 */
	public void updateResorceIdByUserId(Long userId, Long resourceId) throws Exception;
	
	/**
	 * 根据ID查找UserBase
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public UserBase queryByUserId(Long userId) throws Exception;
	
	/**
	 * 根据联系人查询
	 * @return
	 * @throws Exception
	 */
	public UserBase queryUserBaseByName(String name, String userType) throws Exception;
	
}
