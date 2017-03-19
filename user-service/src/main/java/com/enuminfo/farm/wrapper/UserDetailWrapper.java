/**
 * 
 */
package com.enuminfo.farm.wrapper;

import java.util.List;
import java.util.Set;

import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.UserDetail;

/**
 * @author Kumar
 */
public class UserDetailWrapper {

	UserDetailWrapper() {
		
	}
	
	public static UserDetailWrapper getInstance() {
		return SingletonWrapper.USER_DETAIL_WRAPPER_INSTANCE;
	}
	
	public UserDTO convert2DTO(UserDetail userDetail) {
		UserDTO dtoUser = new UserDTO();
		dtoUser = UserWrapper.getInstance().convert2DTO(userDetail.getUser());
		dtoUser.setName(userDetail.getName());
		dtoUser.setEmailId(userDetail.getEmailAddress());
		dtoUser.setMobileNo(userDetail.getMobileNumber());
		return dtoUser;
	}
	
	public UserDetail convert2ModelWithoutId(UserDTO dtoUser, Set<RoleDTO> dtoRoles) {
		UserDetail customer = UserDetail.getBuilder()
				.withName(dtoUser.getName())
				.withEmailAddress(dtoUser.getEmailId())
				.withMobileNumber(dtoUser.getMobileNo())
				.withUser(UserWrapper.getInstance().convert2ModelWithoutId(dtoUser, dtoRoles))
				.build();		
		return customer;
	}
	
	public UserDetail convert2ModelWithId(UserDTO dtoUser) {
		UserDetail customer = UserDetail.getBuilder()
				.withId(dtoUser.getUserId())
				.withName(dtoUser.getName())
				.withEmailAddress(dtoUser.getEmailId())
				.withMobileNumber(dtoUser.getMobileNo())
				.withUser(UserWrapper.getInstance().convert2ModelWithId(dtoUser))
				.build();		
		return customer;
	}
}
