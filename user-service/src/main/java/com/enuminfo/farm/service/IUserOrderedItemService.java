/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.UserOrderedItemDTO;

/**
 * @author Kumar
 */
public interface IUserOrderedItemService {

	public void addUserOrderedItem(UserOrderedItemDTO dtoUserOrderedItem);
	public List<UserOrderedItemDTO> loadAllUserOrderedItems();
}
