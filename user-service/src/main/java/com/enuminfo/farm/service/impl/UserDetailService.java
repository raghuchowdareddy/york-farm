/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Role;
import com.enuminfo.farm.model.User;
import com.enuminfo.farm.model.UserDetail;
import com.enuminfo.farm.repository.IRoleRepository;
import com.enuminfo.farm.repository.IUserDetailRepository;

import com.enuminfo.farm.repository.IUserRepository;
import com.enuminfo.farm.service.IUserDetailService;

import com.enuminfo.farm.service.IRoleService;
import com.enuminfo.farm.service.IUserDetailService;
import com.enuminfo.farm.service.IUserService;
import com.enuminfo.farm.wrapper.UserDetailWrapper;


/**
 * @author Kumar
 */
@Service
public class UserDetailService implements IUserDetailService {

	@Autowired IUserRepository userRepository;
	@Autowired IUserDetailRepository userDetailRepository;
	@Autowired IRoleRepository roleRepository;

	@Autowired
	IRoleService roleService;
	
	@Autowired
	IUserService userService;
	
	@Override
	public void add(UserDTO dtoUser) {
		Set<RoleDTO> dtoRoles = new HashSet<RoleDTO>();
		dtoRoles.add(roleService.loadByName(RoleEnum.ROLE_USER.toString()));
		repository.save(UserDetailWrapper.getInstance().convert2ModelWithId(dtoUser));
	}

	@Override
	public List<UserDTO> loadAll() {
		List<UserDTO> dtoUsers = new ArrayList<UserDTO>();
		Iterable<UserDetail> customers = repository.findAll();
		for (Iterator<UserDetail> iterator = customers.iterator(); iterator.hasNext();) {
			dtoUsers.add(UserDetailWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoUsers;
	}


	@Override
	public UserDTO loadById(int id) {
		return convert2DTO(userDetailRepository.findOne(id));
	}

	@Override
	public UserDTO loadByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return convert2DTO(userDetailRepository.findOne(user.getId()));
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
	
	private UserDTO convert2DTO(UserDetail userDetail) {
		UserDTO dtoUser = new UserDTO();
		dtoUser = convert2DTO(userDetail.getUser());
		dtoUser.setName(userDetail.getName());
		dtoUser.setEmailId(userDetail.getEmailAddress());
		dtoUser.setMobileNo(userDetail.getMobileNumber());
		return dtoUser;
	}
}
