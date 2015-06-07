package com.kingteller.bs.domain.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 针对于业务的Domain对象，是LoginUser、UserBase、UserDetailed的属性集合
 * @author 
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserInfoDomain {

	private UserBase userBase;
	
	private UserDetailed userDetailed;
	
	private LoginUser loginUser;

	public UserBase getUserBase() {
		return userBase;
	}

	public void setUserBase(UserBase userBase) {
		this.userBase = userBase;
	}

	public UserDetailed getUserDetailed() {
		return userDetailed;
	}

	public void setUserDetailed(UserDetailed userDetailed) {
		this.userDetailed = userDetailed;
	}

	public LoginUser getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(LoginUser loginUser) {
		this.loginUser = loginUser;
	}
	
	@Override
	public String toString() {
		return "UserInfoDomain [userBase=" + userBase + ", userDetailed="
				+ userDetailed + ", loginUser=" + loginUser + "]";
	}

	public void mergeProperty(){
		
	}
	
}
