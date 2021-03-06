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
	public void add(UserDTO dtoUser) {
		
	}

	@Override
	public List<UserDTO> loadAll() {
		return null;
	}

	@Override
	public UserDTO loadById(int id) {
		return convert2DTO(userRepository.findOne(id));
	}

	@Override
	public UserDTO loadByName(String name) {
		return convert2DTO(userRepository.findByUsername(name));
	}

	@Override
	public void edit(UserDTO dtoUser) {
		
	}

	@Override
	public void delete(int id) {
		
	}
	
	private UserDTO convert2DTO(User user) {
		UserDTO dtoUser = new UserDTO();
		dtoUser.setId(user.getId());
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
