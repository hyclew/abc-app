package com.kingteller.bs.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingteller.bs.framework.rest.RestResponse;

public class ShoppingCartControllerRestTest {

	private static RestTemplate restTemplate;
	static {
		restTemplate = new RestTemplate();
	}
	
	private static void testAddToShoppingCart() throws Exception{
		String url = "http://192.168.2.103:8090/shoppingcart/addcart";
		
		String cart = "{\"sessionId\":\"65E4C60E49209B9CD7D35454A4C738DE\", \"shoppingCart\":{\"businessProductId\":1, \"count\":5}}";
		
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				cart, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	private static void testUpdateCart() throws Exception{
		String url = "http://192.168.2.103:8090/shoppingcart/updatecart";
		String cart = "{\"sessionId\":\"3ACD51A59A93334FB357FFF6C38C17D1\", \"shoppingCart\":{\"id\":7, \"count\":11}}";
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				cart, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	/**
	 * 测试删除购物车
	 * @throws Exception
	 */
	public static void testDeleteUserCart() throws Exception{
		String url = "http://192.168.2.103:8090/shoppingcart/delcart";
		String str = "{\"sessionId\":\"0976CE5D20C1D54D408ED64C34F78F36\", \"shoppingCart\":{\"id\":7}}";
		new RestTemplate().put(url, str);
	}
	
	public static void deleteCartList() throws Exception{
		String url = "http://192.168.2.103:8090/shoppingcart/delcartlist";
		String str = "{\"sessionId\":\"082E7AE51D8A9888526835F689939CB7\", \"shoppingCartList\":[{\"id\":10},{\"id\":11}]}";
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				str, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
		
	}
	
	public static void main(String[] args) throws Exception {
		//testAddToShoppingCart();
		//testUpdateCart();
		//testDeleteUserCart();
		deleteCartList();
	}
}
