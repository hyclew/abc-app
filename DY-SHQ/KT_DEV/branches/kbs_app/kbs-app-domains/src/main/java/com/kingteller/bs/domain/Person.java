package com.kingteller.bs.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

/**
 * 个人信息
 * 
 * @author Administrator
 * 
 */
public class Person implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户编码
	 */
	private String userNo;

	/**
	 * 用户
	 */
	private UserAccount userAccount;
	
	/**
	 * 用户基础文件
	 */
	private List<UserFile> basicFiles;

	/**
	 * 姓名
	 */
	@Size(max = 30)
	private String name;

	/**
	 * 性别
	 */
	private String gender;

	/**
	 * 证件类型
	 */
	private String identType;

	/**
	 * 证件号码
	 */
	private String identNo;

	/**
	 * 国际行业分类
	 */
	private String tradeCode;

	/**
	 * 年龄
	 */
	@Digits(fraction = 0, integer = 3)
	private int age;

	/**
	 * 婚姻状态
	 */
	private String marriStatus;

	/**
	 * 紧急联系人
	 */
	@Size(max = 30)
	private String urgentPerson;

	/**
	 * 紧急联系方式
	 */
	@Size(max = 15)
	private String urgentTel;

	/**
	 * 联系地址
	 */
	@Size(max = 30)
	private String address;

	/**
	 * 所在公司
	 */
	@Size(max = 30)
	private String company;

	/**
	 * 工作所在省
	 */
	private String workProvince;

	/**
	 * 工作所在市
	 */
	private String workCity;

	/**
	 * 工作年限
	 */
	private String workYear;

	/**
	 * 职位
	 */
	@Size(max = 15)
	private String position;

	/**
	 * 年收入范围
	 */
	private String incomeScope;

	/**
	 * 用户头像地址
	 */
	private String headFile;

	/**
	 * 所属企业编码
	 */
	private String entNo;

	/**
	 * 信息完成度
	 */
	private BigDecimal infoProcess;

	/**
	 * 是否企业管理员
	 */
	private String adminFlag;

	/**
	 * 虚拟账户
	 */
	private String virtualAcct;

	/**
	 * 是否行内客户
	 */
	private String abcFlag;

	/**
	 * 注册时间
	 */
	private String registerTime;

	/**
	 * 实名认证等级
	 */
	private int auLevel;

	/**
	 * 客户等级
	 */
	private String userGrade;
	
    /**
     * 审核状态
     */
    private String infoStatus;
    
    /**
     * 操作是否需要审核
     */
    private String recheckFlag;

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender == null ? null : gender.trim();
	}

	public String getIdentType() {
		return identType;
	}

	public void setIdentType(String identType) {
		this.identType = identType == null ? null : identType.trim();
	}

	public String getIdentNo() {
		return identNo;
	}

	public void setIdentNo(String identNo) {
		this.identNo = identNo == null ? null : identNo.trim();
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode == null ? null : tradeCode.trim();
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMarriStatus() {
		return marriStatus;
	}

	public void setMarriStatus(String marriStatus) {
		this.marriStatus = marriStatus == null ? null : marriStatus.trim();
	}

	public String getUrgentPerson() {
		return urgentPerson;
	}

	public void setUrgentPerson(String urgentPerson) {
		this.urgentPerson = urgentPerson == null ? null : urgentPerson.trim();
	}

	public String getUrgentTel() {
		return urgentTel;
	}

	public void setUrgentTel(String urgentTel) {
		this.urgentTel = urgentTel == null ? null : urgentTel.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company == null ? null : company.trim();
	}

	public String getWorkProvince() {
		return workProvince;
	}

	public void setWorkProvince(String workProvince) {
		this.workProvince = workProvince == null ? null : workProvince.trim();
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity == null ? null : workCity.trim();
	}

	public String getWorkYear() {
		return workYear;
	}

	public void setWorkYear(String workYear) {
		this.workYear = workYear;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position == null ? null : position.trim();
	}

	public String getIncomeScope() {
		return incomeScope;
	}

	public void setIncomeScope(String incomeScope) {
		this.incomeScope = incomeScope == null ? null : incomeScope.trim();
	}

	public String getHeadFile() {
		return headFile;
	}

	public void setHeadFile(String headFile) {
		this.headFile = headFile == null ? null : headFile.trim();
	}

	public String getEntNo() {
		return entNo;
	}

	public void setEntNo(String entNo) {
		this.entNo = entNo == null ? null : entNo.trim();
	}

	public BigDecimal getInfoProcess() {
		return infoProcess;
	}

	public void setInfoProcess(BigDecimal infoProcess) {
		this.infoProcess = infoProcess;
	}

	public String getVirtualAcct() {
		return virtualAcct;
	}

	public void setVirtualAcct(String virtualAcct) {
		this.virtualAcct = virtualAcct == null ? null : virtualAcct.trim();
	}

	public String getAbcFlag() {
		return abcFlag;
	}

	public void setAbcFlag(String abcFlag) {
		this.abcFlag = abcFlag == null ? null : abcFlag.trim();
	}

	public String getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime == null ? null : registerTime.trim();
	}

	public int getAuLevel() {
		return auLevel;
	}

	public void setAuLevel(int auLevel) {
		this.auLevel = auLevel;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade == null ? null : userGrade.trim();
	}

	public String getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(String adminFlag) {
		this.adminFlag = adminFlag;
	}
	
    public String getInfoStatus() {
		return infoStatus;
	}

	public void setInfoStatus(String infoStatus) {
		this.infoStatus = infoStatus;
	}

	public String getRecheckFlag() {
		return recheckFlag;
	}

	public void setRecheckFlag(String recheckFlag) {
		this.recheckFlag = recheckFlag;
	}

	public List<UserFile> getBasicFiles() {
		return basicFiles;
	}

	public void setBasicFiles(List<UserFile> basicFiles) {
		this.basicFiles = basicFiles;
	}
}