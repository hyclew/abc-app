package com.kingteller.bs.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingteller.bs.framework.rest.RestResponse;

public class UserPayControllerRestTest {

	private static RestTemplate restTemplate;
	static {
		restTemplate = new RestTemplate();
	}
	
	private static void testAddPayTool() throws Exception{
		String url = "http://192.168.2.103:8090/userpay/addpaytool";

		String userPayDomain = "{\"sessionId\":\"65E4C60E49209B9CD7D35454A4C738DE\", \"userPay\":{\"payTool\":\"0\", \"cvv\":\"6214623739000014978\", \"name\":\"王亚菲\", \"phone\":\"18710105371\",\"certificateType\":\"1\", \"certificateNumber\":\"140621199003034633\"}}";

		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				userPayDomain, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	
	public static void main(String[] args) throws Exception{
		testAddPayTool();
	}
	
}
