/**
 * Copyrights (C) 2013-2015 Kiet T. Tran
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 3.0 Unported License.
 *
 * Use as is - No warranties whatsoever.
 * 
 */
package com.bemach.cdi.unit.ex01;

/**
 * 
 * @author ktran
 *
 */
public interface AuthenticateService {
	/**
	 * This creates a logged-in user instance.
	 * 
	 * @param userId
	 * @param psw
	 * @return NONE
	 */
	public void login(String userId, String psw);
	
	/**
	 * This queries the for an instance of the UserInfo for a currently unexpired logged-in user.
	 *  
	 * @param userId
	 * @return an instance of the UserInfo
	 */
	public UserInfo getUserInfo(String userId);
	
	/**
	 * This queries the current status of login of a user.
	 * 
	 * @return an instance of the UserInfo
	 */
	public boolean isUserLogin(String userId);
	
	/**
	 * This invalidates the login status of a user.
	 * 
	 * @return NONE.
	 */
	public void logout(String userId);
}
