/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.RoleDTO;

/**
 * @author Kumar
 */
public interface IRoleService {

	void add(RoleDTO dtoRole);
	List<RoleDTO> loadAll();
	RoleDTO loadById(int id);
	RoleDTO loadByName(String name);
	void edit(RoleDTO dtoRole);
	void delete(int id);
}
