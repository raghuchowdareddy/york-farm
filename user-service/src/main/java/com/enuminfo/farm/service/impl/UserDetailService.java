/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.data.RoleEnum;
import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.UserDetail;
import com.enuminfo.farm.repository.IUserDetailRepository;
import com.enuminfo.farm.service.IRoleService;
import com.enuminfo.farm.service.IUserDetailService;
import com.enuminfo.farm.service.IUserService;
import com.enuminfo.farm.wrapper.UserDetailWrapper;

/**
 * @author Kumar
 */
@Service
public class UserDetailService implements IUserDetailService {

	@Autowired
	IUserDetailRepository repository;
	
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
		return UserDetailWrapper.getInstance().convert2DTO(repository.findOne(id));
	}

	@Override
	public void edit(UserDTO dtoUser) {
		repository.save(UserDetailWrapper.getInstance().convert2ModelWithId(dtoUser));
	}

	@Override
	public void delete(int id) {
		repository.delete(repository.findOne(id));
	}

	@Override
	public UserDTO loadByUsername(String username) {
		UserDTO dtoUser = userService.loadByUsername(username);
		return UserDetailWrapper.getInstance().convert2DTO(repository.findOne(dtoUser.getUserId()));
	}
}
