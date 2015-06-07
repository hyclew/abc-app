package com.kingteller.bs.domain;

import java.io.Serializable;
import java.util.Date;

public class TopContact implements Serializable {

	private static final long serialVersionUID = 4400142373755491335L;

	private Long id;
	//mobile
	private String mobile;

    public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	private Integer sourceType;
    //常用联系人组织ID
    private Long orgId;
    //常用联系人，联系次数
    private Integer contactTotal;
    //常用联系人id
    private Long orgMemberId;

    //自己的userId
    private Long ownerUserId;
        
    private Date createTime;

    private Date modifyTime;

    private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getSourceType() {
		return sourceType;
	}

	public void setSourceType(Integer sourceType) {
		this.sourceType = sourceType;
	}

	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public Integer getContactTotal() {
		return contactTotal;
	}

	public void setContactTotal(Integer contactTotal) {
		this.contactTotal = contactTotal;
	}

	public Long getOrgMemberId() {
		return orgMemberId;
	}

	public void setOrgMemberId(Long orgMemberId) {
		this.orgMemberId = orgMemberId;
	}

	public Long getOwnerUserId() {
		return ownerUserId;
	}

	public void setOwnerUserId(Long ownerUserId) {
		this.ownerUserId = ownerUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TopContact [id=" + id + ", mobile=" + mobile + ", sourceType="
				+ sourceType + ", orgId=" + orgId + ", contactTotal="
				+ contactTotal + ", orgMemberId=" + orgMemberId
				+ ", ownerUserId=" + ownerUserId + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", status=" + status + "]";
	}


   
}