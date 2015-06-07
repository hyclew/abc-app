package com.kingteller.bs.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 用户证件资料信息表
 * 
 * @author Administrator
 * 
 */
public class UserFile implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 资料编码
	 */
	private String fileNo;

	/**
	 * 个人编码
	 */
	private String userNo;

	/**
	 * 企业编码
	 */
	private String entNo;

	/**
	 * 上传资料类型
	 */
	private String fileType;

	/**
	 * 资料文件
	 */
	@NotEmpty(message = "文件路径不能为空")
	@NotNull(message = "文件路径不能为空")
	private String filePath;

	/**
	 * 资料名称
	 */
	@NotEmpty
	@Size(max = 30)
	private String fileName;

	/**
	 * 资料年份
	 */
	@Size(max = 4)
	private String fileYear;

	/**
	 * 文件描述信息
	 */
	@Size(max = 64)
	private String description;

	/**
	 * 上传时间
	 */
	private String uploadTime;

	/**
	 * 文件状态
	 */
	private String fileStatus;

	/**
	 * 删除标志
	 */
	private String deleteStatus;

	/**
     * 文件内容
     */
    private byte[] fileContent;
    
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(String deleteStatus) {
		this.deleteStatus = deleteStatus;
	}

	public String getFileNo() {
		return fileNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo == null ? null : fileNo.trim();
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo == null ? null : userNo.trim();
	}

	public String getEntNo() {
		return entNo;
	}

	public void setEntNo(String entNo) {
		this.entNo = entNo == null ? null : entNo.trim();
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType == null ? null : fileType.trim();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath == null ? null : filePath.trim();
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime == null ? null : uploadTime.trim();
	}

	public String getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(String fileStatus) {
		this.fileStatus = fileStatus == null ? null : fileStatus.trim();
	}

	public String getFileYear() {
		return fileYear;
	}

	public void setFileYear(String fileYear) {
		this.fileYear = fileYear;
	}

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
	
	
}