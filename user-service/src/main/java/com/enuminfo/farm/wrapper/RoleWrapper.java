/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.model.Role;

/**
 * @author Kumar
 */
public class RoleWrapper {
	
	RoleWrapper() {

	}
	
	public static RoleWrapper getInstance() {
		return SingletonWrapper.ROLE_WRAPPER_INSTANCE;
	}

	public RoleDTO convert2DTO(Role role) {
		RoleDTO dtoRole = new RoleDTO();
		dtoRole.setRoleId(role.getId());
		dtoRole.setRoleName(role.getName());
		return dtoRole;
	}
	
	public Role convert2ModelWithId(RoleDTO dtoRole) {
		Role role = Role.getBuilder()
				.withId(dtoRole.getRoleId())
				.withName(dtoRole.getRoleName())
				.build();
		return role;
	}
	
	public Role convert2ModelWithoutId(RoleDTO dtoRole) {
		Role role = Role.getBuilder()
				.withName(dtoRole.getRoleName())
				.build();
		return role;
	}
}
