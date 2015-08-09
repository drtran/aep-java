/**
 * Copyrights (C) 2013-2015 Kiet T. Tran
 *
 * This work is licensed under a Creative Commons Attribution-ShareAlike 3.0 Unported License.
 *
 * Use as is - No warranties whatsoever.
 * 
 */
package com.bemach.cdi.cdi_unit.ex01;

import java.util.Date;
import java.util.List;

/**
 * @author ktran
 *
 */
public interface UserInfo {
	public String getUserId();
	public String getEncryptedPsw();
	public List<String> getRoles();
	public Date getLoginAt();
	public Date getLastLoginAt();
	public Boolean isActive();
	public Boolean isExpired();
	public Boolean getLoginFailCount();
	public Boolean isNill();
}
