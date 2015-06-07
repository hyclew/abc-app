package com.kingteller.bs.framework.rest;

public class ErrorCode {

	//-------------------------业务异常类-------------------------
	public static final String SUCCESS = "0000"; //成功
	
	public static final String NULL_OR_BLACK = "1000"; //查询结果为空或 未查询到相应数据
	public static final String RESOURCE_NOT_EXISTS = "1001"; //资源不存在
	public static final String PARAMS_ERROR = "1002"; //参数错误
	public static final String OPERATE_FAIL = "1004"; //操作失败
	public static final String USER_NOT_LOGIN = "1006"; //用户未登录
	
	
	//-------------------------系统异常类-------------------------
	public static final String QUERY_EXCEPTION = "2001"; //查询出现异常
	public static final String INSERT_EXCEPTION = "2002"; //数据插入异常
	public static final String UPDATE_EXCEPTION = "2003"; //数据更新异常
	
}
