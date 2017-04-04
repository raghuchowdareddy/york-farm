/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.UserOrderDTO;
import com.enuminfo.farm.dto.UserOrderedItemDTO;

/**
 * @author Kumar
 */
public interface IUserOrderService {

	void addDraftedUserOrder(UserOrderDTO dtoUserOrder);
	List<UserOrderDTO> loadAllUserOrders(String status);
	List<UserOrderDTO> loadUserOrders(String username, String status);
	void editDraftedUserOrder(UserOrderDTO dtoUserOrder);
	void confirmedUserOrder(UserOrderDTO dtoUserOrder);
	List<UserOrderedItemDTO> loadAllUserOrderedItemsByProduct(int productId);
	UserOrderDTO loadUserOrder(String username, String status);
	void cancelledUserOrder(UserOrderDTO dtoUserOrder);
}
