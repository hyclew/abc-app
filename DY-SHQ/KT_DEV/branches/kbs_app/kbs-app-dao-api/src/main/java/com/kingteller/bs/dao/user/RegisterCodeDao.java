package com.kingteller.bs.dao.user;

import com.kingteller.bs.domain.user.RegisterCode;

/**
 * 注册码相关DAO
 * @author wangyafei
 *
 */
public interface RegisterCodeDao {

	/**
	 * 插入一条验证码信息
	 * @param registerCode
	 * @return
	 * @throws Exception
	 */
	public int insertRegisterCode(RegisterCode registerCode) throws Exception;
	
	/**
	 * 根据ID查询验证码
	 * @param registerCode
	 * @return
	 * @throws Exception
	 */
	public RegisterCode queryCodeById(RegisterCode registerCode) throws Exception;
	
	/**
	 * 通过手机号删除验证码
	 * @param registerCode
	 * @throws Exception
	 */
	public void updateCodeByPhone(RegisterCode registerCode) throws Exception;
	
}
