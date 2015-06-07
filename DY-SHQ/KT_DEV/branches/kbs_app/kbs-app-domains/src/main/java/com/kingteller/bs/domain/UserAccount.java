package com.kingteller.bs.domain;

import java.io.Serializable;

/**
 * 用户登录帐号
 *
 */
public class UserAccount implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 用户编码
	 */
    private String userNo;
    
    /**
     * 用户类型
     * 1.个人客户
     * 2.企业工作人员
     */
    private String userType;

    /**
     * 用户名
     */
    private String userName;
    
    /**
     * 手机号码
     */
    private String mobile;
    
    /**
     * 邮箱
     */
    private String email;
    
    /**
     * 登录密码
     */
    private String pwd;
    
    /**
     * 盐值
     */
    private String salt;
    
    /**
     * 密码安全等级
     * 码表： 低中高
     */
    private String pwdLevel;
    
    /**
     * 邮箱验证状态
     * 码表： 未验证 已验证
     */
    private String emailChecked;
    
    /**
     * 用户状态
     * 码表：禁用（锁定） 正常
     */
    private String enabled;
    
    /**
     * 感兴趣内容
     */
    private String interest;
    
    /**
     * 注册时间
     */
    private String registerTime;
    /**
     * 个人信息
     */
    private Person person;
    
    /**
     * 获取个人信息
     * @return
     */
    public Person getPerson() {
		return person;
	}
    
    /**
     * 设置个人信息
     * @param person
     */
	public void setPerson(Person person) {
		this.person = person;
	}

	/**
     * 设置用户编码
     * @return
     */
    public String getUserNo() {
        return userNo;
    }
    
    /**
     * 设置用户编码
     * @param userNo
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }
    
    /**
     * 获取用户类型
     * @return
     */
    public String getUserType() {
        return userType;
    }
    
    /**
     * 设置用户类型
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }
    
    /**
     * 获取用户名
     * @return
     */
    public String getUserName() {
        return userName;
    }
    
    /**
     * 设置用户名
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
    
    /**
     * 获取手机号码
     * @return
     */
    public String getMobile() {
        return mobile;
    }
    
    /**
     *  设置手机号码
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }
    
    /**
     * 获取邮箱
     * @return
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * 设置邮箱
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    
    /**
     * 获取密码
     * @return
     */
    public String getPwd() {
        return pwd;
    }
    
    /**
     * 设置密码
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
    
    /**
     * 获取盐值
     * @return
     */
    public String getSalt() {
        return salt;
    }
    
    /**
     * 设置盐值
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
    
    /**
     * 获取密码安全等级
     * @return
     */
    public String getPwdLevel() {
        return pwdLevel;
    }
    
    /**
     * 设置密码安全等级
     * @param pwdLevel
     */
    public void setPwdLevel(String pwdLevel) {
        this.pwdLevel = pwdLevel == null ? null : pwdLevel.trim();
    }
    
    /**
     * 获取邮箱验证状态
     * @return
     */
    public String getEmailChecked() {
        return emailChecked;
    }

    /**
     * 设置邮箱验证状态
     * @param emailChecked
     */
    public void setEmailChecked(String emailChecked) {
        this.emailChecked = emailChecked == null ? null : emailChecked.trim();
    }
    
    /**
     * 获取用户状态
     * @return
     */
    public String getEnabled() {
        return enabled;
    }
    
    /**
     * 设置用户状态
     * @param enabled
     */
    public void setEnabled(String enabled) {
        this.enabled = enabled == null ? null : enabled.trim();
    }

    /**
     * 获取感兴趣内容
     * @return
     */
	public String getInterest() {
		return interest;
	}

	/**
	 * 设置感兴趣内容
	 * @param interest
	 */
	public void setInterest(String interest) {
		this.interest = interest;
	}

	/**
	 * 获取注册时间
	 * @return
	 */
	public String getRegisterTime() {
		return registerTime;
	}

	/**
	 * 设置注册时间
	 * @param registerTime
	 */
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
    
    
}