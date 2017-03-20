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

/**
 * @author Kumar
 */
@Service
public class RoleService implements IRoleService {

	@Autowired IRoleRepository repository;
	
	@Override
	public void add(RoleDTO dtoRole) {
		Role role = Role.getBuilder()
				.withName(dtoRole.getRoleName())
				.build();
		repository.save(role);
	}

	@Override
	public List<RoleDTO> loadAll() {
		List<RoleDTO> dtoRoles = new ArrayList<RoleDTO>();
		Iterable<Role> roles = repository.findAll();
		for (Iterator<Role> iterator = roles.iterator(); iterator.hasNext();) {
			Role role = iterator.next();
			dtoRoles.add(convert2DTO(role));
		}
		return dtoRoles;
	}

	@Override
	public RoleDTO loadById(int id) {
		return convert2DTO(repository.findOne(id));
	}

	@Override
	public RoleDTO loadByName(String name) {
		return convert2DTO(repository.findByName(name));
	}

	@Override
	public void edit(RoleDTO dtoRole) {
		Role role = Role.getBuilder()
				.withId(dtoRole.getRoleId())
				.withName(dtoRole.getRoleName())
				.build();
		repository.save(role);
	}

	@Override
	public void delete(int id) {
		
	}

	private RoleDTO convert2DTO(Role role) {
		RoleDTO dtoRole = new RoleDTO();
		dtoRole.setRoleId(role.getId());
		dtoRole.setRoleName(role.getName());
		return dtoRole;
	}
}
