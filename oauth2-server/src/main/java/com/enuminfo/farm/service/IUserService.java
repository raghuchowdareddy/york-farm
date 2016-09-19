/**
 * 
 */
package com.enuminfo.farm.service;

import com.enuminfo.farm.dto.UserDTO;

/**
 * @author Kumar
 */
public interface IUserService {

	UserDTO getUserByUsername(String username);
}
