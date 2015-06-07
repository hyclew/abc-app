package com.kingteller.bs.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingteller.bs.framework.rest.RestResponse;

public class UserOrderAddressControllerRestTest {

	private static RestTemplate restTemplate;
	static {
		restTemplate = new RestTemplate();
	}
	
	private static void testaddUserAddress() throws Exception {
		String url = "http://192.168.2.103:8090/orderaddress/addaddress";

		String userAddressDomain = "{\"userSession\":{\"sessionId\":\"65E4C60E49209B9CD7D35454A4C738DE\"},\"userOrderAddress\":{\"name\":\"wangyafei222\",\"address\":\"xi zhi men nan da jie\",\"phone\":\"15110792419\"}}";

		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				userAddressDomain, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	public static void main(String[] args) throws Exception {
		testaddUserAddress();
	}
	
}
