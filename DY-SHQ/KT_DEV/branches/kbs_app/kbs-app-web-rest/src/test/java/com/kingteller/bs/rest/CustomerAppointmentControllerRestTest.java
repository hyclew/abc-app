package com.kingteller.bs.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingteller.bs.domain.appointment.CustomerAppointment;
import com.kingteller.bs.domain.appointment.CustomerAppointmentSessionDomain;
import com.kingteller.bs.domain.resources.Resources;
import com.kingteller.bs.framework.json.Json2Object;
import com.kingteller.bs.framework.rest.RestResponse;

public class CustomerAppointmentControllerRestTest {

	private static RestTemplate restTemplate;
	static {
		restTemplate = new RestTemplate();
	}
	
	private static void testAddAppointment() throws Exception{
		String url = "http://192.168.2.103:8090/appointment/addappointment";
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String formatDate = dateFormat.format(date);
		System.out.println("--------------- " + formatDate + " ---------------");
		
		/*
		CustomerAppointmentSessionDomain customerAppointmentSessionDomain = new CustomerAppointmentSessionDomain();
		customerAppointmentSessionDomain.setSessionId("65E4C60E49209B9CD7D35454A4C738DE");
		CustomerAppointment customerAppointment = new CustomerAppointment();
		customerAppointment.setProductCatalogId(1001L);
		customerAppointment.setAppointComment("Wash Clothes on Wednesday");
		customerAppointment.setAppointStartTime(new Date());
		customerAppointment.setAppointEndTime(new Date());
		customerAppointment.setAppointAddressId(119L);
		customerAppointmentSessionDomain.setCustomerAppointment(customerAppointment);
		*/
		
		String order = "{\"sessionId\":\"65E4C60E49209B9CD7D35454A4C738DE\",\"customerAppointment\":{\"productCatalogId\":1001, \"appointComment\":\"Wash Clothes on Wednesday\", \"appointStartTime\":"+1432369095399L+", \"appointEndTime\":"+1432369095390L+", \"appointAddressId\":119}}";
		
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				order, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	private static void testaddUserAddress() throws Exception {
		String url = "http://192.168.2.103:8090/appointment/addaddress";

		String userAddressDomain = "{\"userSession\":{\"sessionId\":\"65E4C60E49209B9CD7D35454A4C738DE\"},\"userOrderAddress\":{\"name\":\"wangyafei222\",\"address\":\"xi zhi men nan da jie\",\"phone\":\"15110792419\"}}";

		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				userAddressDomain, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	
	public static void main(String[] args) throws Exception{
		//testaddUserAddress();
		List<Resources> resourceses = new ArrayList<Resources>();
		Resources resources1 = new Resources();
		resources1.setId(1L);
		
		Resources resources2 = new Resources();
		resources2.setId(2L);
		
		Resources resources3 = new Resources();
		resources3.setId(3L);
		
		Resources resources4 = new Resources();
		resources4.setId(4L);
		
		Resources resources5 = new Resources();
		resources5.setId(5L);
		resourceses.add(resources1);
		resourceses.add(resources2);
		resourceses.add(resources3);
		resourceses.add(resources4);
		resourceses.add(resources5);
		String json = Json2Object.serializeObject(resourceses);
		System.out.println(json);
	}
	
}
