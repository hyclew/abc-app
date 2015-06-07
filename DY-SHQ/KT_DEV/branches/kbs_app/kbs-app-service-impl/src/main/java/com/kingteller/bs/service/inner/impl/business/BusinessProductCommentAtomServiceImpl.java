package com.kingteller.bs.service.inner.impl.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.dao.business.BusinessProductCommentDao;
import com.kingteller.bs.domain.business.BusinessProductComment;
import com.kingteller.bs.service.inner.business.BusinessProductCommentAtomService;

@Component("businessProductCommentAtomService")
public class BusinessProductCommentAtomServiceImpl implements
		BusinessProductCommentAtomService {

	@Autowired
	private BusinessProductCommentDao businessProductCommentDao;
	
	@Override
	public List<BusinessProductComment> queryCommentsByProductId(Long businessProductId, Long maxId, int count, String status) throws Exception {
		return this.businessProductCommentDao.queryCommentsByProductId(businessProductId, maxId, count, status);
	}

}
