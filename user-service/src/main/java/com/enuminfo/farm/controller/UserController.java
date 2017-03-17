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
import com.enuminfo.farm.dto.UserOrderDTO;
import com.enuminfo.farm.path.RequestPath;
import com.enuminfo.farm.service.IUserDetailService;
import com.enuminfo.farm.service.IUserOrderService;
import com.enuminfo.farm.service.IUserService;
import com.enuminfo.farm.util.StatusTypeEnum;

/**
 * @author Kumar
 */
@RestController
@RequestMapping(value = RequestPath.USER)
public class UserController {

	@Autowired IUserService service;
	@Autowired IUserDetailService detailService;
	@Autowired IUserOrderService orderService;
	
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
	
	@RequestMapping (value = RequestPath.DRAFTED + RequestPath.ITEMS, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void handleInternalRequestForSaveUserDraftedIteams(@RequestBody UserOrderDTO[] dtoUserOrderObj) {
		for (UserOrderDTO dtoUserOrder : dtoUserOrderObj) {
			dtoUserOrder.setStatus(StatusTypeEnum.DRAFTED.toString());
			orderService.addUserOrder(dtoUserOrder);
		}
	}
	
	@RequestMapping (value = RequestPath.DRAFTED + RequestPath.ITEMS + RequestPath.USERNAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserOrderDTO handleInternalRequestForUserDraftedIteams(@PathVariable String username) {
		return orderService.loadUserOrder(username, StatusTypeEnum.DRAFTED.toString());
	}
	
	@RequestMapping (value = RequestPath.ORDERED + RequestPath.ITEMS, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void handleInternalRequestForSaveUserOrderedIteams(@RequestBody UserOrderDTO[] dtoUserOrderObj) {
		for (UserOrderDTO dtoUserOrder : dtoUserOrderObj) {
			dtoUserOrder.setStatus(StatusTypeEnum.ORDERED.toString());
			orderService.addUserOrder(dtoUserOrder);
		}
	}
	
	@RequestMapping (value = RequestPath.ORDERED + RequestPath.ITEMS + RequestPath.USERNAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserOrderDTO handleInternalRequestForUserOrderedIteams(@PathVariable String username) {
		return orderService.loadUserOrder(username, StatusTypeEnum.ORDERED.toString());
	}
}
