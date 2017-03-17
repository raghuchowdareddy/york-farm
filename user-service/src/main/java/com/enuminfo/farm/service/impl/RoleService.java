/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.model.Role;
import com.enuminfo.farm.repository.IRoleRepository;
import com.enuminfo.farm.service.IRoleService;
import com.enuminfo.farm.wrapper.RoleWrapper;

/**
 * @author Kumar
 */
@Service
public class RoleService implements IRoleService {

	@Autowired IRoleRepository repository;
	
	@Override
	public void add(RoleDTO dtoRole) {
		
	}

	@Override
	public List<RoleDTO> loadAll() {
		List<RoleDTO> dtoRoles = new ArrayList<RoleDTO>();
		Iterable<Role> roles = repository.findAll();
		for (Iterator<Role> iterator = roles.iterator(); iterator.hasNext();) {
			Role role = iterator.next();
			dtoRoles.add(RoleWrapper.getInstance().convert2DTO(role));
		}
		return dtoRoles;
	}

	@Override
	public RoleDTO loadById(int id) {
		return RoleWrapper.getInstance().convert2DTO(repository.findOne(id));
	}

	@Override
	public RoleDTO loadByName(String name) {
		return RoleWrapper.getInstance().convert2DTO(repository.findByName(name));
	}

	@Override
	public void edit(RoleDTO dtoRole) {
		
	}

	@Override
	public void delete(int id) {
		
	}
}
