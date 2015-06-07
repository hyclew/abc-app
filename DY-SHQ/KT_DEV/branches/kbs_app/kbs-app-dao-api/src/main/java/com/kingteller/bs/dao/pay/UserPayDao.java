package com.kingteller.bs.dao.pay;

import java.util.List;

import com.kingteller.bs.domain.pay.UserPay;

/**
 * userPay 相关DAO
 * @author jaimel
 *
 */
public interface UserPayDao {

	/**
	 * 插入一个UserPay对象
	 * @param userPay
	 * @return
	 * @throws Exception
	 */
	public UserPay insertUserBase(UserPay userPay) throws Exception;
	
	/**
	 * 通过USERID查询支付工具
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public UserPay queryUserPayAllByID(Long userId) throws Exception;
	
	/**
	 * 根据用户ID查询银行卡绑定列表信息
	 * @param userPay
	 * @return
	 * @throws Exception
	 */
	public List<UserPay> queryUserPayListByUserID(UserPay userPay) throws Exception;
	
}
