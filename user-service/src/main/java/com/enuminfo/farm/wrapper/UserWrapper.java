/**
 * 
 */
package com.enuminfo.farm.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Role;
import com.enuminfo.farm.model.User;
import com.enuminfo.farm.util.StringUtil;

/**
 * @author Kumar
 */
public class UserWrapper {

	UserWrapper() {

	}
	
	public static UserWrapper getInstance() {
		return SingletonWrapper.USER_WRAPPER_INSTANCE;
	}
	
	public UserDTO convert2DTO(User user) {
		UserDTO dtoUser = new UserDTO();
		dtoUser.setUserId(user.getId());
		dtoUser.setUsername(user.getUsername());
		dtoUser.setPassword(user.getPassword());
		List<String> roleList = new ArrayList<String>();
		Collection<Role> roles = user.getRoles();
		for (Iterator<Role> iterator = roles.iterator(); iterator.hasNext();) {
			Role role = iterator.next();
			roleList.add(role.getName());
		}
		dtoUser.setRoles(roleList);
		return dtoUser;
	}
	
	public User convert2ModelWithId(UserDTO dtoUser) {
		User user = User.getBuilder()
				.withId(dtoUser.getUserId())
				.withUsername(dtoUser.getMobileNo())
				.build();
		return user;
	}
	
	public User convert2ModelWithoutId(UserDTO dtoUser, List<RoleDTO> dtoRoles) {
		Collection<Role> roles = new ArrayList<Role>();
		for (Iterator<RoleDTO> iterator = dtoRoles.iterator(); iterator.hasNext();) {
			roles.add(RoleWrapper.getInstance().convert2ModelWithId(iterator.next()));
		}
		User user = User.getBuilder()
				.withUsername(dtoUser.getMobileNo())
				.withPassword(StringUtil.generatePassword())
				.withRoles(roles)
				.build();
		return user;
	}
}
