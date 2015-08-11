/**
 * Copyrights (C) 2013-2015 Kiet T. Tran
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 3.0 Unported License.
 *
 * Use as is - No warranties whatsoever.
 * 
 */
package com.bemach.cdi.unit.ex01;

import java.util.Date;
import java.util.List;

/**
 * This class contains basic information of a user after a successful login.
 * 
 * @author ktran
 *
 */
public class UserInfoImpl implements UserInfo {
	private String userId;
	private String encryptedPsw;
	private List<String> roles;
	private Date loginAt;
	private Date lastLoginAt;
	private Boolean active;
	
	public UserInfoImpl() {
	}

	public String getUserId() {
		return userId;
	}

	public String getEncryptedPsw() {
		return encryptedPsw;
	}

	public List<String> getRoles() {
		return roles;
	}

	public Date getLoginAt() {
		return loginAt;
	}

	public Date getLastLoginAt() {
		return lastLoginAt;
	}

	public Boolean isActive() {
		return active;
	}

	public Boolean isNill() {
		return false;
	}

	
	public Boolean isExpired() {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean getLoginFailCount() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
