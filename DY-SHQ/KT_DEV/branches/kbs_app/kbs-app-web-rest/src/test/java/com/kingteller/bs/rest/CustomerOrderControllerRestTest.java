package com.kingteller.bs.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingteller.bs.framework.rest.RestResponse;

public class CustomerOrderControllerRestTest {

	private static RestTemplate restTemplate;
	static {
		restTemplate = new RestTemplate();
	}
	
	private static void testAddUserOrder() throws Exception{
		String url = "http://192.168.2.103:8090/order/addorder";
		
		//String order = "{\"sessionId\":\"65E4C60E49209B9CD7D35454A4C738DE\",\"customerOrderBase\":{\"isInvoice\":\"1\", \"isClub\":\"0\", \"invoiceTitle\":\"guang zhou yu yin ke ji gu fen you xian gong si\"},\"userOrderAddress\":{\"id\":117}, \"businessCartDomain\":[{\"cartId\":109,\"businessProductId\":145, \"businessProductCatalogId\":1001, \"count\":3, \"productSalePrice\":8, \"productPreferPrice\":5}, {\"cartId\":110,\"businessProductId\":146, \"businessProductCatalogId\":1001, \"count\":7, \"productSalePrice\":8, \"productPreferPrice\":5}, {\"cartId\":111,\"businessProductId\":148, \"businessProductCatalogId\":1001, \"count\":1, \"productSalePrice\":8, \"productPreferPrice\":5}]}";
		
		String order = "{\"sessionId\":\"65E4C60E49209B9CD7D35454A4C738DE\",\"customerOrderBase\":{\"isInvoice\":\"1\", \"isClub\":\"0\", \"invoiceTitle\":\"guang zhou yu yin ke ji gu fen you xian gong si -> Second 2\"},\"userOrderAddress\":{\"id\":117}, \"businessCartDomain\":[{\"cartId\":109,\"businessProductId\":145, \"businessProductCatalogId\":1001, \"count\":3, \"productSalePrice\":7.5, \"productPreferPrice\":5}, {\"cartId\":110,\"businessProductId\":146, \"businessProductCatalogId\":1001, \"count\":7, \"productSalePrice\":3.5, \"productPreferPrice\":5}, {\"cartId\":111,\"businessProductId\":148, \"businessProductCatalogId\":1001, \"count\":1, \"productSalePrice\":1.5, \"productPreferPrice\":5}]}";
		
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				order, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	private static void testDeleteUserOrder() throws Exception{
		String url = "http://192.168.2.103:8090/order/deleteorder";
		String order = "{\"sessionId\":\"fds6f4sd654f6s5d4f65sd4f\", \"customerOrderBase\":{\"id\":12}}";
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				order, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	public static void main(String[] args) throws Exception{
		//testAddUserOrder();
		testDeleteUserOrder();
	}
	
}
