/**
 * 
 */
package com.enuminfo.farm.service;

import com.enuminfo.farm.dto.UserDTO;

/**
 * @author Kumar
 */
public interface IUserService {

	void add(UserDTO dtoUser);
	UserDTO loadByUsername(String username);
}
