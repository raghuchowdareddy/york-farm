/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.data.RoleEnum;
import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Customer;
import com.enuminfo.farm.repository.ICustomerRepository;
import com.enuminfo.farm.service.ICustomerService;
import com.enuminfo.farm.service.IRoleService;
import com.enuminfo.farm.service.IUserService;
import com.enuminfo.farm.wrapper.CustomerWrapper;

/**
 * @author Kumar
 */
@Service
public class CustomerService implements ICustomerService {

	@Autowired
	ICustomerRepository repository;
	
	@Autowired
	IRoleService roleService;
	
	@Autowired
	IUserService userService;
	
	@Override
	public void add(UserDTO dtoUser) {
		List<RoleDTO> dtoRoles = new ArrayList<RoleDTO>();
		dtoRoles.add(roleService.loadByName(RoleEnum.ROLE_USER.toString()));
		repository.save(CustomerWrapper.getInstance().convert2ModelWithoutId(dtoUser, dtoRoles));
	}

	@Override
	public List<UserDTO> loadAll() {
		List<UserDTO> dtoUsers = new ArrayList<UserDTO>();
		Iterable<Customer> customers = repository.findAll();
		for (Iterator<Customer> iterator = customers.iterator(); iterator.hasNext();) {
			dtoUsers.add(CustomerWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoUsers;
	}

	@Override
	public UserDTO loadById(int id) {
		return CustomerWrapper.getInstance().convert2DTO(repository.findOne(id));
	}

	@Override
	public void edit(UserDTO dtoUser) {
		repository.save(CustomerWrapper.getInstance().convert2ModelWithId(dtoUser));
	}

	@Override
	public void delete(int id) {
		repository.delete(repository.findOne(id));
	}

	@Override
	public UserDTO loadByUsername(String username) {
		UserDTO dtoUser = userService.loadByUsername(username);
		return CustomerWrapper.getInstance().convert2DTO(repository.findOne(dtoUser.getUserId()));
	}
}
