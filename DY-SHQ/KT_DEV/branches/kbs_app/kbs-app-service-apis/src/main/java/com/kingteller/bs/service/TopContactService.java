package com.kingteller.bs.service;

import java.util.List;

import com.kingteller.bs.domain.TopContact;


/**
 * 常用联系人管理
 */
public interface TopContactService {

	/**
	 * 添加常用联系人，处理的加星（收藏）类型的常用联系人
	 * @param sessionId
	 * @param name 成员名字
	 * @param mobile 手机
	 * @param userId 常用联系人id
	 * @param orgId 常用联系人所在组织
	 * @return
	 */
	void addTopContact(String sessionId, Long orgMemberId, Long orgId);

	/**
	 * 删除常用联系人
	 * 
	 * @param sessionId
	 * @param quanMemberId
	 * @param orgId
	 * @return
	 */
	void deleteTopContact(String sessionId,Long orgMemberId, Long orgId);

	/**
	 * 查询常用联系人列表
	 * 每次返回登录用户的所有常用联系人
	 * @param sessionId
	 * @return
	 */
	List<TopContact> queryTopContactList(String sessionId);

	void submitTopContactList(String sessionId,List<String> mobileList);

}
