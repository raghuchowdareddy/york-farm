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

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Role;
import com.enuminfo.farm.model.User;
import com.enuminfo.farm.repository.IUserRepository;
import com.enuminfo.farm.service.IUserService;

/**
 * @author Kumar
 */
@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;
	
	@Override
	public UserDTO getUserByUsername(String username) {
		return convert2DTO(userRepository.findByUsername(username));
	}
	
	private UserDTO convert2DTO(User user) {
		UserDTO dtoUser = new UserDTO();
		dtoUser.setId(user.getId());
		dtoUser.setUsername(user.getUsername());
		dtoUser.setPassword(user.getPassword());
		List<String> roles = new ArrayList<>();
		Collection<Role> list = user.getRoles();
		for (Iterator<Role> iterator = list.iterator(); iterator.hasNext();) {
			Role role = iterator.next();
			roles.add(role.getName());
		}
		dtoUser.setRoles(roles);
		return dtoUser;
	}
}
