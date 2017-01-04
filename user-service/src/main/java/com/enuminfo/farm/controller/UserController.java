/**
 * 
 */
package com.enuminfo.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.path.RequestPath;
import com.enuminfo.farm.service.IUserDetailService;
import com.enuminfo.farm.service.IUserService;

/**
 * @author Kumar
 */
@RestController
@RequestMapping(value = RequestPath.USER)
public class UserController {

	@Autowired
	IUserService service;
	
	@Autowired
	IUserDetailService detailService;
	
	@RequestMapping (value = RequestPath.LOGGED_IN + RequestPath.USERNAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO handleInteralRequestForLoggedUserDetailByUsername(@PathVariable String username) {
		return service.loadByUsername(username);
	}
	
	@RequestMapping (method = RequestMethod.POST)
	public void handleInternalRequestForSaveCustomer(@RequestBody UserDTO dtoUser) {
		service.add(dtoUser);
	}
	
	@RequestMapping (value = RequestPath.USERNAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO handleInternalRequestForDetailByUsername(@PathVariable String username) {
		return detailService.loadByUsername(username);
	}
}
