/**
 * 
 */
package com.enuminfo.farm.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.path.RequestPath;
import com.enuminfo.farm.service.IUserService;

/**
 * @author Kumar
 */
@RestController
@RequestMapping (value = RequestPath.USER)
public class UserController {

	@Autowired
	IUserService userService;
	
	@RequestMapping (method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Principal handleInternalRequestForPrincipal(Principal principal) {
		return principal;
	}
	
	@RequestMapping (value = RequestPath.LOGGED_IN, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDTO> handleInternalRequestForLoggedUserDetail(Principal principal) {
		UserDTO dtoUser = userService.getUserByUsername(principal.getName());
		return Optional.ofNullable(dtoUser)
                .map(a -> new ResponseEntity<UserDTO>(a, HttpStatus.OK))
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
	}
}
