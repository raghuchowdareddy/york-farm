/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.UserDTO;

/**
 * @author Kumar
 */
public interface IUserService {

	void add(UserDTO dtoUser);
	List<UserDTO> loadAll();
	UserDTO loadById(int id);
	UserDTO loadByMobileNo(String mobileNo);
	UserDTO loadByEmailId(String emailId);
	void edit(UserDTO dtoUser);
	void delete(int id);
}
