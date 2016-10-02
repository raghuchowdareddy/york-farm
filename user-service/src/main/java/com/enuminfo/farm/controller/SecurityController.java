/**
 * 
 */
package com.enuminfo.farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = RequestPath.LOGGED_IN)
public class SecurityController {

	@Autowired
	IUserService userService;
	
	@RequestMapping(value = RequestPath.MOBILE + RequestPath.MOBILE_NO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO handleInternalRequestForLoggedUserDetailByMobile(@PathVariable String mobileNo) {
		return userService.loadByMobileNo(mobileNo);
	}
	
	@RequestMapping(value = RequestPath.EMAIL + RequestPath.EMAIL_ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserDTO handleInternalRequestForLoggedUserDetailByEmail(@PathVariable String emailId) {
		return userService.loadByEmailId(emailId);
	}
}
