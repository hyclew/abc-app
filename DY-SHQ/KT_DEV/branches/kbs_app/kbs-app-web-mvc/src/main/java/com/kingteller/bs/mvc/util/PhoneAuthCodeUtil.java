package com.kingteller.bs.mvc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

/**
 * 手机验证码的工具类
 * 
 * 类功能说明：产生和验证手机验证码
 *
 * @author 宋杰 2013年11月29日 下午7:43:54
 * 
 * @version 1.0.0
 */
public class PhoneAuthCodeUtil {
	public static int PHONE_AUTH_CODE_EXPIRE_TIME = 3000000;//5分钟
	
	public static String PHONE_AUTH_CODE = "phoneAuthCode";//手机验证码的key
	
	public static String PHONE_AUTH_CODE_SENDTIME = "phoneAuthCodeSendTime";//手机验证码发送时间的key
	
	public static String PHONE_AUTH_CODE_MOBILENO = "phoneAuthCodeMobileNo";//session存储的手机号
	
	
	/**
	 * 方法说明 :对手机验证码进行校验
	 *
	 * @author 宋杰 2013年12月6日上午10:15:13
	 *
	 * @param session
	 * 				HttpSession对象
	 * @param phoneAuthCode
	 * 				验证码
	 * @param mobileNo
	 * 				手机号码
	 * @return
	 */
	public static String validateAuthCode(HttpSession session, String phoneAuthCode, String mobileNo){
		String rtn = "right";
		
		phoneAuthCode = phoneAuthCode.trim();
		
		String phoneAuthCodeFromSession = session.getAttribute(PHONE_AUTH_CODE) == null ? "" : session.getAttribute(PHONE_AUTH_CODE).toString();
		
		long authCodeSendTimeFromSesssion = session.getAttribute(PHONE_AUTH_CODE_SENDTIME) == null ? 0 : Long.parseLong(session.getAttribute(PHONE_AUTH_CODE_SENDTIME).toString());
		
		String mobileNoFromSession = session.getAttribute(PHONE_AUTH_CODE_MOBILENO) ==null ? "" : session.getAttribute(PHONE_AUTH_CODE_MOBILENO).toString();
		
		long nowTime = new Date().getTime();
		
		if(phoneAuthCode.length() != 6 || 
				!(phoneAuthCode.equals(phoneAuthCodeFromSession)) || 
				phoneAuthCodeFromSession.equals("") || 
				authCodeSendTimeFromSesssion == 0 || 
				!mobileNoFromSession.equals(mobileNo)){
			
			rtn = "wrong";
		}else if(nowTime - authCodeSendTimeFromSesssion > PHONE_AUTH_CODE_EXPIRE_TIME){
			
			rtn = "expired";
		}
		
		if(rtn.equals("right") || rtn.equals("expired")){
			
			session.removeAttribute(PHONE_AUTH_CODE);
			
			session.removeAttribute(PHONE_AUTH_CODE_SENDTIME);
			
			session.removeAttribute(PHONE_AUTH_CODE_MOBILENO);
		}
		
		return rtn;
	}
	
	/**
	 * 方法说明 :产生新的手机验证码
	 *
	 * @author 宋杰 2013年12月6日上午10:01:53
	 *
	 * @param session
	 * @param mobileNo
	 */
	public static void generateNewAuthCode(HttpSession session, String mobileNo){
		String phoneAuthCode =  generateAuthCode();
		
		long phoneAuthCodeSendTime = new Date().getTime();//当前时间，记录的是秒数
		
		session.setAttribute(PHONE_AUTH_CODE, phoneAuthCode);
		
		session.setAttribute(PHONE_AUTH_CODE_SENDTIME, phoneAuthCodeSendTime);
		
		session.setAttribute(PHONE_AUTH_CODE_MOBILENO, mobileNo);
	}
		
	/**
	 * 产生六位手机验证码
	 * @return
	 */
	public static String generateAuthCode(){
		return generateAuthCode(6);
	}
	
	/**
	 * 生成手机验证码，可以自定义长度
	 * @param length:生成的验证码的长度
	 * @return
	 */
	public static String generateAuthCode(int length){
		String base = "0123456789";  
		
        Random random = new Random();   
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < length; i++) {   
            int number = random.nextInt(base.length());   
            sb.append(base.charAt(number));   
        }   
        
        return sb.toString();   
	}
}
