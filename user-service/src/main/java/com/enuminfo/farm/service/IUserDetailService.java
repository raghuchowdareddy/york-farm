/**
 * 
 */
package com.enuminfo.farm.service;

import com.enuminfo.farm.dto.UserDTO;

/**
 * @author Kumar
 */
public interface IUserDetailService {

	UserDTO loadById(int id);
	UserDTO loadByUsername(String username);
}
