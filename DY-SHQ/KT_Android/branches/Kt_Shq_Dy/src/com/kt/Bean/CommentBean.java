package com.kt.Bean;

public class CommentBean {
	
	private String username;
	private String comment;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString() {
		return "CommentBean [username=" + username + ", comment=" + comment
				+ ", getUsername()=" + getUsername() + ", getComment()="
				+ getComment() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
}
