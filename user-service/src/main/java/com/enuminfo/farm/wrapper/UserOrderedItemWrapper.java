/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.UserOrderedItemDTO;
import com.enuminfo.farm.model.UserOrderedItem;
import com.enuminfo.farm.model.UserOrderDeliveryLocation;

/**
 * @author Kumar
 */
public class UserOrderedItemWrapper {

	UserOrderedItemWrapper() {
		
	}
	
	public static UserOrderedItemWrapper getInstance() {
		return SingletonWrapper.USER_ORDERED_ITEM_WRAPPER;
	}
	
	public UserOrderedItemDTO convertUserOrderedItem2DTO(UserOrderedItem userOrderedItem) {
		UserOrderedItemDTO dtoUserOrderedItem = new UserOrderedItemDTO();
		
		return dtoUserOrderedItem;
	}
	
	public UserOrderedItemDTO convertUserOrderedItemDeliveryLocation2DTO(UserOrderDeliveryLocation userOrderedItemDeliveryLocation) {
			UserOrderedItemDTO dtoUserOrderedItem = new UserOrderedItemDTO();
		
		return dtoUserOrderedItem;
	}
	
	public UserOrderedItem convertUserOrderedItem2ModelWithoutId(UserOrderedItemDTO dtoUserOrderedItem) {
		UserOrderedItem userOrderedItem = UserOrderedItem.getBuilder()
				.build();
		return userOrderedItem;
	}
}
