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

	void addDraftedUserOrder(UserOrderDTO dtoUserOrder);
	List<UserOrderDTO> loadAllUserOrders(String status);
	UserOrderDTO loadUserOrder(String username, String status);
	void editDraftedUserOrder(UserOrderDTO dtoUserOrder);
	void confirmedUserOrder(UserOrderDTO dtoUserOrder);
}
