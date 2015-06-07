package com.kingteller.bs.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingteller.bs.domain.business.BusinessProductComment;
import com.kingteller.bs.framework.constant.Constant;
import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.BusinessProductCommentService;
import com.kingteller.bs.service.inner.business.BusinessProductCommentAtomService;

@Component("businessProductCommentService")
public class BusinessProductCommentServiceImpl implements
		BusinessProductCommentService {

	private static final Logger logger = Logger.getLogger(BusinessProductCommentServiceImpl.class);
	
	@Autowired
	private BusinessProductCommentAtomService businessProductCommentAtomService;
	
	@Override
	public RestResponse getCommentByProductId(
			Long businessProductId, Long maxId, int count) {
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		List<BusinessProductComment> comments = null;
		try {
			comments = this.businessProductCommentAtomService.queryCommentsByProductId(businessProductId, maxId, count, Constant.COMMENT_ENABLED);
			if(null != comments && comments.size() > 0){
				logger.info("查询id为 " + businessProductId + " 的商品评价成功,查询到的评价条数为: " + comments.size()); 
				header.setErrorCode(ErrorCode.SUCCESS);
				header.setMessage("查询商品评价成功");
				response.setResponseBody(comments);
			}else{
				logger.info("id为 " + businessProductId + " 商品没有查询到评价信息");
				header.setErrorCode(ErrorCode.NULL_OR_BLACK);
				header.setMessage("该商品暂时没有收到任何评价");
			}
			
		} catch (Exception e) {
			logger.error("查询商品评价异常,原因是:" + e.getLocalizedMessage(), e);
			header.setErrorCode(ErrorCode.QUERY_EXCEPTION);
			header.setMessage("查询商品评价异常");
		}
		return response;
	}

}
