/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.UserOrderDTO;

/**
 * @author Kumar
 */
public interface IUserOrderService {

	void addUserOrder(UserOrderDTO dtoUserOrder);
	List<UserOrderDTO> loadAllUserOrders(String status);
	UserOrderDTO loadUserOrder(String username, String status);
}
