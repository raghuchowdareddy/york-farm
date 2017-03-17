/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.dto.ProductDTO;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.dto.UserOrderDTO;
import com.enuminfo.farm.dto.UserOrderedItemDTO;
import com.enuminfo.farm.model.UserDetail;
import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.model.UserOrderedItem;
import com.enuminfo.farm.repository.IUserDetailRepository;
import com.enuminfo.farm.repository.IUserOrderRepository;
import com.enuminfo.farm.repository.IUserOrderedItemRepository;
import com.enuminfo.farm.service.IUserOrderService;
import com.enuminfo.farm.service.IUserService;
import com.enuminfo.farm.service.feign.InventoryService;
import com.enuminfo.farm.wrapper.UserOrderWrapper;
import com.enuminfo.farm.wrapper.UserOrderedItemWrapper;

/**
 * @author Kumar
 */
@Service
public class UserOrderService implements IUserOrderService {

	@Autowired IUserService userService;
	@Autowired IUserOrderRepository userOrderRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	@Autowired InventoryService inventoryService;
	@Autowired IUserDetailRepository userDetailrepository;
	
	@Override
	public void addUserOrder(UserOrderDTO dtoUserOrder) {
		UserDTO dtoUser = userService.loadById(dtoUserOrder.getUserId());
		UserOrder userOrder = UserOrderWrapper.getInstance().convert2ModelWithoutId(dtoUserOrder, dtoUser);
		userOrder = userOrderRepository.save(userOrder);
		for (Iterator<UserOrderedItemDTO> iterator = dtoUserOrder.getOrderedItems().iterator(); iterator.hasNext();) {
			UserOrderedItemDTO dtoUserorderedItem = iterator.next();
			ProductDTO dtoProduct = inventoryService.callProductServiceById(dtoUserorderedItem.getProductId());
			CategoryDTO dtoCategory = inventoryService.callCategoryServiceById(dtoProduct.getCategoryId());
			UserOrderedItem orderedItem = UserOrderedItemWrapper.getInstance().convert2ModelWithoutId(dtoUserorderedItem, dtoProduct, dtoCategory);
			orderedItem.setUserOrder(userOrder);
			userOrderedItemRepository.save(orderedItem);
		}
	}
	
	@Override
	public List<UserOrderDTO> loadAllUserOrders(String status) {
		List<UserOrderDTO> dtoUserOrders = new ArrayList<UserOrderDTO>();
		Iterable<UserOrder> userOrders = userOrderRepository.findByStatus(status);
		for (Iterator<UserOrder> iterator = userOrders.iterator(); iterator.hasNext();) {
			UserOrder userOrder = iterator.next();
			dtoUserOrders.add(UserOrderWrapper.getInstance().convert2DTO(userOrder));
		}
		return dtoUserOrders;
	}
	
	@Override
	public UserOrderDTO loadUserOrder(String username, String status) {
		UserOrderDTO dtoUserOrder = new UserOrderDTO();
		UserDTO dtoUser = userService.loadByUsername(username);
		UserDetail userDetail = userDetailrepository.findOne(dtoUser.getUserId());
		UserOrder userOrder = userOrderRepository.findByUserAndStatus(userDetail, status);
		if (userOrder != null) {
			dtoUserOrder = UserOrderWrapper.getInstance().convert2DTO(userOrder);
			Iterable<UserOrderedItem> orderedItems = userOrderedItemRepository.findByUserOrder(userOrder);
			List<UserOrderedItemDTO> dtoUserOrderedItems = new ArrayList<UserOrderedItemDTO>();
			for (Iterator<UserOrderedItem> iterator = orderedItems.iterator(); iterator.hasNext();) {
				UserOrderedItem orderedItem = iterator.next();
				dtoUserOrderedItems.add(UserOrderedItemWrapper.getInstance().convert2DTO(orderedItem));
			}
			dtoUserOrder.setOrderedItems(dtoUserOrderedItems);
		}
		return dtoUserOrder;
	}
}
