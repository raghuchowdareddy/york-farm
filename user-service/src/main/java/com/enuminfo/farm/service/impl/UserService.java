/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import java.util.HashSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.data.RoleEnum;
import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Role;
import com.enuminfo.farm.model.User;
import com.enuminfo.farm.model.UserDetail;
import com.enuminfo.farm.repository.IRoleRepository;
import com.enuminfo.farm.repository.IUserDetailRepository;
import com.enuminfo.farm.repository.IUserRepository;
import com.enuminfo.farm.service.IRoleService;
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
	@Autowired IRoleService roleService;
	@Autowired UserDetailService userDetailService;
	@Override
	public void add(UserDTO dtoUser) {		dtoUser.setPassword("password");//TODO lets do later.
		Set<RoleDTO> dtoRoles = new HashSet<RoleDTO>();
		dtoRoles.add(roleService.loadByName(RoleEnum.ROLE_USER.toString()));
//		User newUser = userRepository.save(UserWrapper.getInstance().convert2ModelWithId(new UserDTO()));
//		dtoUser.setUserId(newUser.getId());
		User persistedUser = userRepository.save(UserWrapper.getInstance().convert2ModelWithoutId(dtoUser, dtoRoles));
		dtoUser.setUserId(persistedUser.getId());
		userDetailService.add(dtoUser);
	}

	@Override
	public List<UserDTO> loadAll() {
		return null;
	}

	@Override
	public UserDTO loadById(int id) {
		return UserWrapper.getInstance().convert2DTO(userRepository.findOne(id));
	}

	@Override
	public void edit(UserDTO dtoUser) {
		
	}

	@Override
	public void delete(int id) {

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
