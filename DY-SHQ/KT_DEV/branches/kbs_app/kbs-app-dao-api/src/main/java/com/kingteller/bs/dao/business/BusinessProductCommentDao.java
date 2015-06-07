package com.kingteller.bs.dao.business;

import java.util.List;

import com.kingteller.bs.domain.business.BusinessProductComment;

public interface BusinessProductCommentDao {
	
	/**
	 * 查看商品对应的评价
	 * @param businessProductId 商品id
	 * @param maxId 商品最大id
	 * @param count 查询数据条数
	 * @return
	 * @throws Exception
	 */
	public List<BusinessProductComment> queryCommentsByProductId(Long businessProductId, Long maxId, int count, String status) throws Exception;
	
}