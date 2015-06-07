package com.kingteller.bs.framework.session;

import com.kingteller.bs.framework.md5.MD5Util;

public class SessionUtil {

	/**
	 * 生成SessionID
	 * @param username
	 * @return
	 */
	public static String generateSessionId(String username){
		String sessionId = username + System.currentTimeMillis();
		//SessionKey使用MD5加密
		return MD5Util.MD5(sessionId);
	}
	
}
