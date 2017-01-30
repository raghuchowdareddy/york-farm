/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.UserOrderedItemDTO;
import com.enuminfo.farm.model.UserOrderedItem;
import com.enuminfo.farm.repository.IUserOrderedItemRepository;
import com.enuminfo.farm.service.IUserOrderedItemService;
import com.enuminfo.farm.wrapper.UserOrderedItemWrapper;

/**
 * @author Kumar
 */
@Service
public class UserOrderedItemService implements IUserOrderedItemService {

	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	
	@Override
	public void addUserOrderedItem(UserOrderedItemDTO dtoUserOrderedItem) {
		UserOrderedItem userOrderedItem = UserOrderedItemWrapper.getInstance().convertUserOrderedItem2ModelWithoutId(dtoUserOrderedItem);
		userOrderedItemRepository.save(userOrderedItem);
	}

	@Override
	public List<UserOrderedItemDTO> loadAllUserOrderedItems() {
		List<UserOrderedItemDTO> dtoUserOrderedItems = new ArrayList<UserOrderedItemDTO>();
		
		return dtoUserOrderedItems;
	}
}
