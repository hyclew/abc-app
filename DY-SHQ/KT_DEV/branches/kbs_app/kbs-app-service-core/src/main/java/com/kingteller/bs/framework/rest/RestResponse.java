package com.kingteller.bs.framework.rest;

public class RestResponse {

	/**
	 * 返回头信息，包括返回码（ErrorCode类中定义的类型）和返回信息
	 */
	private ResponseHeader responseHeader;
	
	/**
	 * 返回体，也就是真正的业务数据，可以是List、Map、Object等类型
	 */
	private Object responseBody;

	public ResponseHeader getResponseHeader() {
		return responseHeader;
	}

	public void setResponseHeader(ResponseHeader responseHeader) {
		this.responseHeader = responseHeader;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}

}
