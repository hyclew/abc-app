package com.kingteller.bs.domain.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * 头像上传
 * @author wangyafei
 *
 */
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class HeadPortraitDomail {

	//头像的base64编码
	private String headPortrait;
	
	//图片的后缀，也就是图像格式
	private String picSuffix;
	
	//会话ID
	private String sessionId;

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait;
	}

	public String getPicSuffix() {
		return picSuffix;
	}

	public void setPicSuffix(String picSuffix) {
		this.picSuffix = picSuffix;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public String toString() {
		return "HeadPortraitDomail [headPortrait=" + headPortrait
				+ ", picSuffix=" + picSuffix + ", sessionId=" + sessionId
				+ "]";
	}
}
