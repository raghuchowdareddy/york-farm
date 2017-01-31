/**
 * 
 */
package com.enuminfo.farm.wrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.dto.ProductDTO;
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
	
	public List<UserOrderedItemDTO> convertUserOrderedItems2DTO(List<UserOrderedItem> userOrderedItems) {
		List<UserOrderedItemDTO> dtoUserOrderedItems = new ArrayList<UserOrderedItemDTO>();
		for (Iterator<UserOrderedItem> iterator = userOrderedItems.iterator(); iterator.hasNext();) {
			UserOrderedItemDTO dtoUserOrderedItem = new UserOrderedItemDTO();
			UserOrderedItem userOrderedItem = iterator.next();
			dtoUserOrderedItem.setUserOrderItemId(userOrderedItem.getId());
			dtoUserOrderedItem.setProductId(userOrderedItem.getProduct().getId());
			dtoUserOrderedItem.setProductName(userOrderedItem.getProduct().getName());
			dtoUserOrderedItem.setDescription(userOrderedItem.getProduct().getDescription());
			dtoUserOrderedItem.setCategoryId(userOrderedItem.getProduct().getCategory().getId());
			dtoUserOrderedItem.setCategoryName(userOrderedItem.getProduct().getCategory().getName());
			dtoUserOrderedItem.setQuantity(userOrderedItem.getQuantity());
			dtoUserOrderedItems.add(dtoUserOrderedItem);
		}
		return dtoUserOrderedItems;
	}
	
	public UserOrderedItemDTO convertUserOrderedItemDeliveryLocation2DTO(UserOrderDeliveryLocation userOrderedItemDeliveryLocation) {
			UserOrderedItemDTO dtoUserOrderedItem = new UserOrderedItemDTO();
		
		return dtoUserOrderedItem;
	}
	
	public UserOrderedItem convertUserOrderedItem2ModelWithoutId(UserOrderedItemDTO dtoUserOrderedItem, ProductDTO dtoProduct, CategoryDTO dtoCategory) {
		UserOrderedItem userOrderedItem = UserOrderedItem.getBuilder()
				.withProduct(ProductWrapper.getInstance().convert2ModelWithId(dtoProduct, dtoCategory))
				.withQuantity(dtoUserOrderedItem.getQuantity())
				.build();
		return userOrderedItem;
	}
	
	public List<UserOrderedItem> convertUserOrderedItems2ModelWithoutId(List<UserOrderedItemDTO> dtoUserOrderedItems) {
		List<UserOrderedItem> userOrderedItems = new ArrayList<UserOrderedItem>();
		for (Iterator<UserOrderedItemDTO> iterator = dtoUserOrderedItems.iterator(); iterator.hasNext();) {
			UserOrderedItemDTO dtoUserOrderedItem = iterator.next();
			UserOrderedItem userOrderedItem = UserOrderedItem.getBuilder()
					.withProduct(ProductWrapper.getInstance().convert2ModelWithId(dtoUserOrderedItem.getProductId(), dtoUserOrderedItem.getProductName(), 
							dtoUserOrderedItem.getDescription(), dtoUserOrderedItem.getCategoryId(), dtoUserOrderedItem.getCategoryName()))
					.withQuantity(dtoUserOrderedItem.getQuantity())
					.build();
			userOrderedItems.add(userOrderedItem);
		}
		return userOrderedItems;
	}
}
