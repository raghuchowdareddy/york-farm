/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.dto.UserOrderDTO;
import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.repository.IUserOrderRepository;
import com.enuminfo.farm.repository.IUserOrderedItemRepository;
import com.enuminfo.farm.service.IUserOrderService;
import com.enuminfo.farm.service.IUserService;
import com.enuminfo.farm.wrapper.UserOrderWrapper;

/**
 * @author Kumar
 */
@Service
public class UserOrderService implements IUserOrderService {

	@Autowired IUserService userService;
	@Autowired IUserOrderRepository userOrderRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	
	@Override
	public void addUserOrder(UserOrderDTO dtoUserOrder) {
		UserDTO dtoUser = userService.loadById(dtoUserOrder.getUserId());
		UserOrder userOrder = UserOrderWrapper.getInstance().convert2ModelWithoutId(dtoUserOrder, dtoUser);
		userOrderRepository.save(userOrder);
	}
	@Override
	public List<UserOrderDTO> loadAllUserOrders() {
		return null;
	}
}
