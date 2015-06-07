package com.kingteller.bs.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kingteller.bs.framework.rest.RestResponse;

public class UserControllerRestTest {

	private static RestTemplate restTemplate;
	static {
		restTemplate = new RestTemplate();
	}

	private static void testUserRegister() throws Exception {
		String url = "http://192.168.2.103:8090/user/register";

		String userInfoDomain = "{\"userBase\":{\"id\":null,\"name\":\"王亚飞\",\"address\":\"bei jing shi xi cheng qu\",\"phone\":\"18710205372\",\"telephone\":null,\"status\":null,\"updateTime\":null,\"userType\":null},\"userDetailed\":{\"id\":null,\"sex\":\"0\",\"userBaseId\":null},\"loginUser\":{\"id\":null,\"userId\":null,\"businessId\":null,\"status\":null,\"updateTime\":null,\"online\":null,\"username\":\"a7025861\",\"password\":\"a123456\", \"confirmPassword\":\"a123456\"}}";

		// String userInfoDomain = "fdsfds{\'name\':\'wang\'}dfdfdsf";

		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				userInfoDomain, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}

	private static void testUserLogin() throws Exception {
		String url = "http://192.168.2.103:8090/user/login";
		// restTemplate.exchange(url, HttpMethod.PUT, null, RestResponse.class,
		// null);/a7025460/123456
		
		String userInfo = "{\"username\":\"18514209115\", \"password\":\"123456\"}";
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				userInfo, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}

	/**
	 * 测试头像上传
	 * 
	 * @throws Exception
	 */
	public static void testUploadPortrait() throws Exception {
		String url = "http://192.168.2.103:8090/user/uploadportrait";
		String headPortraitDomail = "{\"headPortrait\":\"/9j/4QAYRXhpZgAASUkqAAgAAAAAAAAAAAAAAP/sABFEdWNreQABAAQAAABkAAD/4QMraHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLwA8P3hwYWNrZXQgYmVnaW49Iu+7vyIgaWQ9Ilc1TTBNcENlaGlIenJlU3pOVGN6a2M5ZCI/PiA8eDp4bXBtZXRhIHhtbG5zOng9ImFkb2JlOm5zOm1ldGEvIiB4OnhtcHRrPSJBZG9iZSBYTVAgQ29yZSA1LjMtYzAxMSA2Ni4xNDU2NjEsIDIwMTIvMDIvMDYtMTQ6NTY6MjcgICAgICAgICI+IDxyZGY6UkRGIHhtbG5zOnJkZj0iaHR0cDovL3d3dy53My5vcmcvMTk5OS8wMi8yMi1yZGYtc3ludGF4LW5zIyI+IDxyZGY6RGVzY3JpcHRpb24gcmRmOmFib3V0PSIiIHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIgeG1sbnM6eG1wTU09Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9tbS8iIHhtbG5zOnN0UmVmPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VSZWYjIiB4bXA6Q3JlYXRvclRvb2w9IkFkb2JlIFBob3Rvc2hvcCBDUzYgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOjBGOTU1QUYyRThCRjExRTQ5RkVBOUE3RUVBREI1NDNGIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOjBGOTU1QUYzRThCRjExRTQ5RkVBOUE3RUVBREI1NDNGIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6MEY5NTVBRjBFOEJGMTFFNDlGRUE5QTdFRUFEQjU0M0YiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6MEY5NTVBRjFFOEJGMTFFNDlGRUE5QTdFRUFEQjU0M0YiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz7/7gAOQWRvYmUAZMAAAAAB/9sAhAABAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAgICAgICAgICAgIDAwMDAwMDAwMDAQEBAQEBAQIBAQICAgECAgMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwMDAwP/wAARCAAeAB4DAREAAhEBAxEB/8QAdwAAAgMAAAAAAAAAAAAAAAAACAkABwoBAAMBAAAAAAAAAAAAAAAAAAABAgMQAAAGAgECAgcJAQAAAAAAAAECAwQFBhEHABIIIRMxFLUWN3cJQWGBIpIV1RdXGREBAAICAwEBAAAAAAAAAAAAAAERITFhAhJBIv/aAAwDAQACEQMRAD8A1y/9Htaf59sD9VY/neV4k6UpMd2Wh7Xs+Vv9003MWhL3YpUNWE5ZlV5CQgpCtzNwlpF+iDmT9XbFfmnmfQKahj9TQRNj8vK8zVQKkQ+ntxaB7hNwHcMNMix2EzjPe8t0sURWlX5Va2tCxTI6cgyfPH4PmqblAETYwQiOMhgOTMTEcDIgp7QlEfbBpOwomo1KOnIa7P7ZaJYIpJOWnvPq9lYtRM5RRH1h83tUiwkAOsIdJmnWUesAAVc1Qtng5spOAHJ9Pj49SHy2svtypcjvop0bzaa5JzVh1tKsXaDdnULdJzsygqs4TUfx7ygXWroNmxEUlEnCyctYmywlVEhATSMYBE5SFNmlmi5utMh4hn0en7vt8fw4Acn0+Pj1IfLay+3KlyO+inRlk4n3BrXqmxjMlULUG14fzcrc4o7lNI1JCCsCCdPtFHkJZu/Wl1XL5sRrJR8i5bi8RI6WaJJkFuefzXJFKaepfbIUG03uzcQnwKaxaPV6xsIC48B8mdsaNTBY+ciU6MeBOkQyV0YBEOXM9vkHke2z2nYi/oVfZzkpQoWIcNTpVSV1+mda0sCGMqCrkiVVj5WWOkm76xXCSbLNxc584oq55MeyypHtAq9ArncdIf13s1jsWBca6tAoHNXLTWp2PJ++1QxU5RrNQzOMcgUuCgs2cGFU2RFBIMBx9r85OdGz8zS//9k=\",\"picSuffix\":\".jpg\",\"sessionId\":\"65E4C60E49209B9CD7D35454A4C738DE\"}";
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				headPortraitDomail, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}
	
	public static void testGenerateCode() throws Exception{
		String url = "http://192.168.2.103:8090/user/generatecode";
		String phone = "{\"phone\":\"15110782562\"}";
		ResponseEntity<RestResponse> entity = restTemplate.postForEntity(url,
				phone, RestResponse.class);
		System.out.println("====================== : "
				+ new ObjectMapper().writeValueAsString(entity.getBody()));
	}

	public static void main(String[] args) throws Exception {
		//testUserRegister();
		// testPost();
		// testUserLogin();
		 testUploadPortrait();
		//testGenerateCode();
	}

}
