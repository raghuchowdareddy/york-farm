/**
 * 
 */
package com.enuminfo.farm.wrapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.dto.ProductDTO;
import com.enuminfo.farm.dto.UserOrderedItemDTO;
import com.enuminfo.farm.model.UserOrderedItem;

/**
 * @author Kumar
 */
public class UserOrderedItemWrapper {

	UserOrderedItemWrapper() {
		
	}
	
	public static UserOrderedItemWrapper getInstance() {
		return SingletonWrapper.USER_ORDERED_ITEM_WRAPPER;
	}
	
	public UserOrderedItem convert2ModelWithoutId(UserOrderedItemDTO dtoUserOrderedItem, ProductDTO dtoProduct, CategoryDTO dtoCategory) {
		UserOrderedItem userOrderedItem = UserOrderedItem.getBuilder()
				.withProduct(ProductWrapper.getInstance().convert2ModelWithId(dtoProduct, dtoCategory))
				.withQuantity(dtoUserOrderedItem.getQuantity())
				.withPrice(dtoUserOrderedItem.getPrice())
				.build();		
		return userOrderedItem;
	}
	
	public List<UserOrderedItem> convertUserOrderedItems2ModelWithoutId(List<UserOrderedItemDTO> dtoUserOrderedItems) {
		List<UserOrderedItem> userOrderedItems = new ArrayList<UserOrderedItem>();
		
		return userOrderedItems;
	}
	
	public List<UserOrderedItemDTO> convert2DTO(Collection<UserOrderedItem> userOrderedItems) {
		List<UserOrderedItemDTO> dtoUserOrderedItems = new ArrayList<UserOrderedItemDTO>();
		
		return dtoUserOrderedItems;
	}
	
	public UserOrderedItemDTO convert2DTO(UserOrderedItem userOrderedItem) {
		UserOrderedItemDTO dtoUserOrderedItem = new UserOrderedItemDTO();
		dtoUserOrderedItem.setProductId(userOrderedItem.getProduct().getId());
		dtoUserOrderedItem.setProductName(userOrderedItem.getProduct().getName());
		dtoUserOrderedItem.setQuantity(userOrderedItem.getQuantity());
		dtoUserOrderedItem.setPrice(userOrderedItem.getPrice());
		return dtoUserOrderedItem;
	}
}
