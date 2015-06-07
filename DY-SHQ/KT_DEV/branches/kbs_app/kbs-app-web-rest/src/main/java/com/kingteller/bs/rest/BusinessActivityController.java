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
import com.kingteller.bs.service.BusinessActivityService;

@RestController
@RequestMapping("/businessactivity")
public class BusinessActivityController {

	private static final Logger logger = Logger.getLogger(BusinessActivityController.class);
	
	@Autowired
	private BusinessActivityService businessActivityService;
	
	@RequestMapping(value = "/businessactivitys/{maxId}/{dataCount}", method = RequestMethod.GET)
	public RestResponse waterInformationsList(@PathVariable Long maxId, @PathVariable int dataCount){
		logger.info("开始查询商家活动信息,最大ID是 " + maxId + ", 查询条数是 " + dataCount);
		RestResponse response = new RestResponse();
		ResponseHeader header = new ResponseHeader();
		response.setResponseHeader(header);
		try {
			response = this.businessActivityService.queryBusinessActivitys(maxId, dataCount);
		} catch (Exception e) {
			logger.error("查询商家活动信息异常,异常信息是:" + e.getLocalizedMessage(), e);
			response.getResponseHeader().setErrorCode(ErrorCode.QUERY_EXCEPTION);
			response.getResponseHeader().setMessage("查询商家活动信息异常");
		}
		return response;
	}
	
	
}
