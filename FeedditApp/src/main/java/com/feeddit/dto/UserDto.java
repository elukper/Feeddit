package com.feeddit.dto;

import java.io.Serializable;

public class UserDto implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -2611095774486063480L;
	private String username;
	private String password;
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(final String password) {
		this.password = password;
	}
	public void setUsername(final String username) {
		this.username = username;
	}



}
