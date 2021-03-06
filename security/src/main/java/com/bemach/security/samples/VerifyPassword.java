package com.bemach.security.samples;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
 
/**
 * This class is created for using with HTTP basic authentication.
 * 
 * You need a user ID and password for the authentication.
 *
 */
public class VerifyPassword extends Authenticator {
 	private String userId = null;
	private String password = null;
 	
	/**
	 * 
	 * @param userId
	 * @param password
	 */
	public VerifyPassword (String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
	
	/**
	 * returns the PasswordAuthentication object.
	 * @return PasswordAuthentication object.
	 */
	public PasswordAuthentication getPasswordAuthetication () {
		return new PasswordAuthentication (userId, password.toCharArray());
	}
}
