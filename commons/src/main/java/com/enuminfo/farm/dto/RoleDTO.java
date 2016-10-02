/**
 * 
 */
package com.enuminfo.farm.dto;

import java.io.Serializable;

/**
 * @author Kumar
 */
public class RoleDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roleId;
	private String roleName;
	
	public RoleDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
