/**
 * 
 */
package com.enuminfo.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.dto.UserOrderDTO;
import com.enuminfo.farm.dto.UserOrderedItemDTO;
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
	public void handleInternalRequestForSaveUserDraftedItems(@RequestBody UserOrderDTO[] dtoUserOrderObj) {
		for (UserOrderDTO dtoUserOrder : dtoUserOrderObj) {
			dtoUserOrder.setStatus(StatusTypeEnum.DRAFTED.toString());
			if (dtoUserOrder.getOrderId() == 0) orderService.addDraftedUserOrder(dtoUserOrder);
			else orderService.editDraftedUserOrder(dtoUserOrder);
		}
	}
	
	@RequestMapping (value = RequestPath.DRAFTED + RequestPath.ITEMS + RequestPath.USERNAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserOrderDTO handleInternalRequestForUserDraftedItems(@PathVariable String username) {
		return orderService.loadUserOrder(username, StatusTypeEnum.DRAFTED.toString());
	}
	
	@RequestMapping (value = RequestPath.ORDERED + RequestPath.ITEMS, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void handleInternalRequestForSaveUserOrderedIteams(@RequestBody UserOrderDTO[] dtoUserOrderObj) {
		for (UserOrderDTO dtoUserOrder : dtoUserOrderObj) {
			dtoUserOrder.setStatus(StatusTypeEnum.ORDERED.toString());
			dtoUserOrder.setDeliveryStatus(StatusTypeEnum.INPROGRESS.toString());
			orderService.confirmedUserOrder(dtoUserOrder);
		}
	}
	
	@RequestMapping (value = RequestPath.ORDERED + RequestPath.ITEMS + RequestPath.USERNAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserOrderDTO> handleInternalRequestForUserOrderedItems(@PathVariable String username) {
		return orderService.loadUserOrders( StatusTypeEnum.ORDERED.toString(),StatusTypeEnum.INPROGRESS.toString(),username);
	}
	
	@RequestMapping (value = RequestPath.CANCELLED + RequestPath.ITEMS, method = RequestMethod.POST)
	public void handleInternalRequestForCancelledUserOrderedItems(@RequestBody UserOrderDTO dtoUserOrder) {
		dtoUserOrder.setStatus(StatusTypeEnum.CANCELLED.toString());
		orderService.cancelledUserOrder(dtoUserOrder);
	}
	
	@RequestMapping (value = RequestPath.ITEMS + RequestPath.PRODUCT + RequestPath.ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserOrderedItemDTO> handleInternalRequestForUserOrderedItemsByProductId(@PathVariable int id) {
		return orderService.loadAllUserOrderedItemsByProduct(id);
	}
}
