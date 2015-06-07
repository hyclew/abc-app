package com.kingteller.bs.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kingteller.bs.framework.rest.ErrorCode;
import com.kingteller.bs.framework.rest.ResponseHeader;
import com.kingteller.bs.framework.rest.RestResponse;
import com.kingteller.bs.service.CustomerOrderService;

@RestController
@RequestMapping("/ordernumbertest")
public class OrderNumberTestController {

	@Autowired
	private CustomerOrderService customerOrderService;
	
	@RequestMapping(value = "/ordernumber/{code}", method = RequestMethod.GET)
	public RestResponse waterInformationsList(@PathVariable String code) throws Exception{
		RestResponse response = new RestResponse();
		String orderNumber = customerOrderService.generateOrderNumber(code);
		response.setResponseBody(orderNumber);
		ResponseHeader header = new ResponseHeader();
		header.setErrorCode(ErrorCode.SUCCESS);
		header.setMessage("SUCCESS");
		response.setResponseHeader(header);
		return response;
	}
	
}
