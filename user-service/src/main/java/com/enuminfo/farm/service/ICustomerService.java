/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.UserDTO;

/**
 * @author Kumar
 */
public interface ICustomerService {

	void add(UserDTO dtoUser);
	List<UserDTO> loadAll();
	UserDTO loadById(int id);
	void edit(UserDTO dtoUser);
	void delete(int id);
	UserDTO loadByUsername(String username);
}
