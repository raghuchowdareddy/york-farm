/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.data.RoleEnum;
import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.UserDetail;
import com.enuminfo.farm.repository.IUserDetailRepository;
import com.enuminfo.farm.repository.IUserRepository;
import com.enuminfo.farm.service.IRoleService;
import com.enuminfo.farm.service.IUserService;
import com.enuminfo.farm.wrapper.UserDetailWrapper;
import com.enuminfo.farm.wrapper.UserWrapper;

/**
 * @author Kumar
 */
@Service
public class UserService implements IUserService {

	@Autowired IUserRepository userRepository;
	@Autowired IUserDetailRepository userDetailRepository;
	@Autowired IRoleService roleService;
	
	@Override
	public void add(UserDTO dtoUser) {
		List<RoleDTO> dtoRoles = new ArrayList<RoleDTO>();
		dtoRoles.add(roleService.loadByName(RoleEnum.ROLE_USER.toString()));
		UserDetail detailUser = UserDetailWrapper.getInstance().convert2ModelWithoutId(dtoUser, dtoRoles);
		userDetailRepository.save(detailUser);
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
		return UserWrapper.getInstance().convert2DTO(userRepository.findByUsername(username));
	}
}
