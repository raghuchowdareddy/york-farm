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

	public void addUserOrder(UserOrderDTO dtoUserOrder);
	public List<UserOrderDTO> loadAllUserOrders();
}
