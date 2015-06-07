package com.kingteller.bs.rest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.BusinessProductCommentService;

@RestController
@RequestMapping("/productcomment")
public class BusinessProductCommentController {

	private static final Logger logger = Logger.getLogger(BusinessProductCommentController.class);
	
	@Autowired
	private BusinessProductCommentService businessProductCommentService;
	
	@RequestMapping(value = "/productcomments/{productId}/{maxId}/{dataCount}", method = RequestMethod.GET)
	public RestResponse getAllProductCatalogues(@PathVariable Long productId, @PathVariable Long maxId, @PathVariable int dataCount){
		logger.info("开始查询商品评价信息,商品id是 " + productId + ", 查询最大id是 " + maxId + ", 查询条数是 " + dataCount);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			response = this.businessProductCommentService.getCommentByProductId(productId, maxId, dataCount);
		} catch (Exception e) {
			logger.error("查询商品评价异常,原因是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询商品评价异常");
		}
		return response;
	}
}
