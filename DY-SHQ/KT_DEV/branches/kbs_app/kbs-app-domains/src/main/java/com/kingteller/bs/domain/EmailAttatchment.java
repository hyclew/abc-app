package com.kingteller.bs.domain;

import java.io.Serializable;
/**
 * 邮件附件模型
 *
 */
public class EmailAttatchment implements Serializable  {
	private static final long serialVersionUID = 4495808721461669558L;

	private byte[] data;
	
	private String fileName;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String name) {
		this.fileName = name;
	}
	
}

