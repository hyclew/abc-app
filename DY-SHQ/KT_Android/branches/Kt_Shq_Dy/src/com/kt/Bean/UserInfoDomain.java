package com.kt.Bean;
public class UserInfoDomain {

	public UserBase userBase=new UserBase();
	
	public  UserDetailed userDetailed=new UserDetailed();
	
	public LoginUser loginUser=new LoginUser();

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
