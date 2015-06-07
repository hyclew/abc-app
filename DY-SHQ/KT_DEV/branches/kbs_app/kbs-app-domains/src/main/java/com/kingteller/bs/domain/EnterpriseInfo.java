package com.kingteller.bs.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 企业信息表
 * 
 * @author
 * 
 */
public class EnterpriseInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 企业编码
     */
    private String entNo;

    /**
     * 所属商圈，一个企业暂时属于一个商圈
     */
    private BusinessGroup businessGroup;
    
    /**
     * 企业基本资料
     */
    private List<UserFile> basicFiles;

    /**
     * 中文全称
     */
    @NotEmpty(message = "中文全称不能为空")
    @Size(max = 30)
    private String chineseFullname;

    /**
     * 中文简称
     */
    @Size(max = 5)
    private String chineseName;

    /**
     * 英文全称
     */
    @Size(max = 100)
    private String englishFullname;

    /**
     * 英文简称
     */
    @Size(max = 15)
    private String englishName;

    /**
     * 注册国家或地区
     */
    private String registerCountry;

    /**
     * 注册地行政区划
     */
    private String registerArea;

    /**
     * 注册地址
     */
    private String address;

    /**
     * 单位类型
     */
    private String entType;

    /**
     * 注册地城乡属性
     */
    private String addressAttribute;

    /**
     * 虚拟账号
     */
    private String virtualAcct;

    /**
     * 企业LOGO文件路径
     */
    private String logo;

    /**
     * 组织机构代码
     */
    @Size(max = 20)
    private String orgCode;

    /**
     * 组织机构代码年检日期
     */
    private String checkDate;

    /**
     * 注册或登记证件类型
     */
    private String registerIdentType;

    /**
     * 注册或登记证件号码
     */
    private String registerIdentNo;

    /**
     * 注册或批准成立日期
     */
    private String registerDate;

    /**
     * 注册或登记证件年检日期
     */
    private String regCheckDate;

    /**
     * 营业执照号码
     */
    @Size(max = 20)
    private String busiLicense;

    /**
     * 营业有效期起始日期
     */
    private String busiStartDate;

    /**
     * 营业有效期终止日期
     */
    private String busiEndDate;

    /**
     * 法人姓名
     */
    @Size(max = 30)
    private String corpName;

    /**
     * 企业法人代表有效证件类型
     */
    private String corpIdentType;

    /**
     * 企业法人代表有效证件号码
     */
    @Size(max = 20)
    private String corpIdentNo;

    /**
     * 企业法人代表手机号
     */
    @Size(max = 11)
    private String corpIdentMobile;

    /**
     * 联系人
     */
    private String contractor;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 成员数
     */
    private int staffNum;

    /**
     * 区域编码
     */
    private String areaCode;

    /**
     * 区域领域模型
     */
    private Area area;

    /**
     * 是否核心企业
     */
    private String coreFlag = BaseConstant.CORE_FLAG_N;

    /**
     * 是否圈内用户
     */
    private String bgFlag = BaseConstant.BG_FLAG_N;

    /**
     * 注册时间
     */
    private String registerTime;

    /**
     * 激活码
     */
    private String activateCode;

    /**
     * 激活码产生时间
     */
    private String createTime;

    /**
     * 激活码状态
     */
    private String activateStatus = BaseConstant.ACTIVATE_STATUS_N;

    /**
     * 激活时间
     */
    private String activateTime;

    /**
     * 实名认证等级
     */
    private int auLevel = 0;

    /**
     * 客户等级
     */
    private String userGrade;

    /**
     * 企业信息完整度
     */
    private BigDecimal infoProcess;

    /**
     * 信息状态
     */
    private String infoStatus = BaseConstant.ENT_INFO_STATUS_NONE;
    
    public String getEntNo() {
        return entNo;
    }

    public void setEntNo(String entNo) {
        this.entNo = entNo == null ? null : entNo.trim();
    }

    public String getChineseFullname() {
        return chineseFullname;
    }

    public void setChineseFullname(String chineseFullname) {
        this.chineseFullname = chineseFullname == null ? null : chineseFullname
                .trim();
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    public String getEnglishFullname() {
        return englishFullname;
    }

    public void setEnglishFullname(String englishFullname) {
        this.englishFullname = englishFullname == null ? null : englishFullname
                .trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getRegisterCountry() {
        return registerCountry;
    }

    public void setRegisterCountry(String registerCountry) {
        this.registerCountry = registerCountry == null ? null : registerCountry
                .trim();
    }

    public String getRegisterArea() {
        return registerArea;
    }

    public void setRegisterArea(String registerArea) {
        this.registerArea = registerArea;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getEntType() {
        return entType;
    }

    public void setEntType(String entType) {
        this.entType = entType == null ? null : entType.trim();
    }

    public String getAddressAttribute() {
        return addressAttribute;
    }

    public void setAddressAttribute(String addressAttribute) {
        this.addressAttribute = addressAttribute == null ? null
                : addressAttribute.trim();
    }

    public String getVirtualAcct() {
        return virtualAcct;
    }

    public void setVirtualAcct(String virtualAcct) {
        this.virtualAcct = virtualAcct == null ? null : virtualAcct.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getCheckDate() {
        return checkDate;
    }

    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate == null ? null : checkDate.trim();
    }

    public String getRegisterIdentType() {
        return registerIdentType;
    }

    public void setRegisterIdentType(String registerIdentType) {
        this.registerIdentType = registerIdentType == null ? null
                : registerIdentType.trim();
    }

    public String getRegisterIdentNo() {
        return registerIdentNo;
    }

    public void setRegisterIdentNo(String registerIdentNo) {
        this.registerIdentNo = registerIdentNo == null ? null : registerIdentNo
                .trim();
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate == null ? null : registerDate.trim();
    }

    public String getRegCheckDate() {
        return regCheckDate;
    }

    public void setRegCheckDate(String regCheckDate) {
        this.regCheckDate = regCheckDate == null ? null : regCheckDate.trim();
    }

    public String getBusiLicense() {
        return busiLicense;
    }

    public void setBusiLicense(String busiLicense) {
        this.busiLicense = busiLicense == null ? null : busiLicense.trim();
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName == null ? null : corpName.trim();
    }

    public String getCorpIdentType() {
        return corpIdentType;
    }

    public void setCorpIdentType(String corpIdentType) {
        this.corpIdentType = corpIdentType == null ? null : corpIdentType
                .trim();
    }

    public String getCorpIdentNo() {
        return corpIdentNo;
    }

    public void setCorpIdentNo(String corpIdentNo) {
        this.corpIdentNo = corpIdentNo == null ? null : corpIdentNo.trim();
    }

    public String getCorpIdentMobile() {
        return corpIdentMobile;
    }

    public void setCorpIdentMobile(String corpIdentMobile) {
        this.corpIdentMobile = corpIdentMobile == null ? null : corpIdentMobile
                .trim();
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor == null ? null : contractor.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public int getStaffNum() {
        return staffNum;
    }

    public void setStaffNum(int staffNum) {
        this.staffNum = staffNum;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode == null ? null : areaCode.trim();
    }

    public String getCoreFlag() {
        return coreFlag;
    }

    public void setCoreFlag(String coreFlag) {
        this.coreFlag = coreFlag == null ? null : coreFlag.trim();
    }

    public String getBgFlag() {
        return bgFlag;
    }

    public void setBgFlag(String bgFlag) {
        this.bgFlag = bgFlag == null ? null : bgFlag.trim();
    }

    public String getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime == null ? null : registerTime.trim();
    }

    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode == null ? null : activateCode.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(String activateStatus) {
        this.activateStatus = activateStatus == null ? null : activateStatus
                .trim();
    }

    public String getActivateTime() {
        return activateTime;
    }

    public void setActivateTime(String activateTime) {
        this.activateTime = activateTime == null ? null : activateTime.trim();
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public BusinessGroup getBusinessGroup() {
        return businessGroup;
    }

    public void setBusinessGroup(BusinessGroup businessGroup) {
        this.businessGroup = businessGroup;
    }

    public String getBusiStartDate() {
        return busiStartDate;
    }

    public void setBusiStartDate(String busiStartDate) {
        this.busiStartDate = busiStartDate;
    }

    public String getBusiEndDate() {
        return busiEndDate;
    }

    public void setBusiEndDate(String busiEndDate) {
        this.busiEndDate = busiEndDate;
    }

    public BigDecimal getInfoProcess() {
        return infoProcess;
    }

    public void setInfoProcess(BigDecimal infoProcess) {
        this.infoProcess = infoProcess;
    }

    public String getInfoStatus() {
        return infoStatus;
    }

    public void setInfoStatus(String infoStatus) {
        this.infoStatus = infoStatus;
    }

	public List<UserFile> getBasicFiles() {
		return basicFiles;
	}

	public void setBasicFiles(List<UserFile> basicFiles) {
		this.basicFiles = basicFiles;
	}
    
}