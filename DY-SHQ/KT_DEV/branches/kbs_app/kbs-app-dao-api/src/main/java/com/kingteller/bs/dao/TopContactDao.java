package com.kingteller.bs.dao;

import java.util.List;
import java.util.Map;

import com.kingteller.bs.domain.TopContact;

public interface TopContactDao {
    /**
     * @deprecated
     * @param id
     * @return
     */
    Integer deleteById(Long id);

    /**
     * @deprecated
     * @param id
     * @return
     */
    TopContact selectById(Long id);

    /**
     * @deprecated
     * @param map
     * @return
     */
    Integer updateByParams(Map map);

    /**
     * @deprecated
     * @param record
     * @return
     */
    Integer updateById(TopContact record);
    
    /**
     * @deprecated
     * @param id
     * @return
     */
    Integer updateStatusById(Long id);

	/**
	 * @deprecated
	 * @param orgMemberIdList
	 * @param ownerUserId
	 * @return
	 */
	List<TopContact> queryByMemberIdsOwnerUserId(List<Long> orgMemberIdList,Long ownerUserId);

	/**
	 * 
	 * @param record
	 * @return
	 */
    Integer insert(TopContact record);
    
    /**
     * 
     * @param ownerUserId
     * @return
     */
	List<TopContact> queryTopContactListByOwnerUserId(Long ownerUserId);
	
	/**
	 * 
	 * @param orgId
	 * @param orgMemberId
	 * @param ownerUserId
	 * @return
	 */
	TopContact queryByOrgIdMemberIdOwnerUserId(Long orgId,Long orgMemberId,Long ownerUserId);
	
	/**
	 * 
	 * @param orgId
	 * @param orgMemberId
	 * @param ownerUserId
	 * @param sourceType
	 * @return
	 */
	Integer updateByOrgIdMemberIdOwnerUserId(Long orgId,Long orgMemberId,Long ownerUserId,Integer sourceType);
	
	/**
	 * 更新系统推荐的种类，此时如果已经存在，则联系次数累积
	 * @param orgId
	 * @param orgMemberId
	 * @param ownerUserId
	 * @param contactTotal
	 * @return
	 */
	Integer updateRecommendByOrgIdMemberIdOwnerUserId(Long orgId,Long orgMemberId,Long ownerUserId,Integer contactTotal);
	
	/**
	 * 仅仅把status更新为1，即取消常用联系人状态
	 * @param orgId
	 * @param orgMemberId
	 * @param ownerUserId
	 * @return
	 */
	Integer updateStatusByOrgIdMemberIdOwnerUserId(Long orgId, Long orgMemberId,Long ownerUserId);
}