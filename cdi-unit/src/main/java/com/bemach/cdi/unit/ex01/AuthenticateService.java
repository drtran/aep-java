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
 * @param <String>
 *
 */
public interface AuthenticateService<String> {
	/**
	 * A successful login returns a
	 * @param userId
	 * @param psw
	 * @return
	 */
	public UserInfoImpl authenticate(String userId, String psw);
}
