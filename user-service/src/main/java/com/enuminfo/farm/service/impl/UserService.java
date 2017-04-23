/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.data.RoleEnum;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Role;
import com.enuminfo.farm.model.User;
import com.enuminfo.farm.model.UserDetail;
import com.enuminfo.farm.repository.IRoleRepository;
import com.enuminfo.farm.repository.IUserDetailRepository;
import com.enuminfo.farm.repository.IUserRepository;
import com.enuminfo.farm.service.IUserService;
import com.enuminfo.farm.util.StringUtil;

/**
 * @author Kumar
 */
@Service
public class UserService implements IUserService {

	@Autowired IUserRepository userRepository;
	@Autowired IUserDetailRepository userDetailRepository;
	@Autowired IRoleRepository roleRepository;
	
	@Override
	public void add(UserDTO dtoUser) {
		Collection<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName(RoleEnum.ROLE_USER.toString()));
		User user = User.getBuilder()
				.withUsername(dtoUser.getMobileNo())
				.withPassword(StringUtil.defaultPassword())
				.withRoles(roles)
				.build();
		UserDetail detailUser = UserDetail.getBuilder()
				.withName(dtoUser.getName())
				.withEmailAddress(dtoUser.getEmailId())
				.withMobileNumber(dtoUser.getMobileNo())
				.withUser(user)
				.build();
		userDetailRepository.save(detailUser);
	}

	@Override
	public UserDTO loadByUsername(String username) {
		return convert2DTO(userRepository.findByUsername(username));
	}
	
	private UserDTO convert2DTO(User user) {
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
}
