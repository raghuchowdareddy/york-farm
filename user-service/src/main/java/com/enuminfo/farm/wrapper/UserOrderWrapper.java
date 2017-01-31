/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.dto.UserOrderDTO;
import com.enuminfo.farm.model.UserOrder;

/**
 * @author Kumar
 */
public class UserOrderWrapper {

	UserOrderWrapper() {
		
	}
	
	public static UserOrderWrapper getInstance() {
		return SingletonWrapper.USER_ORDER_WRAPPER;
	}
	
	public UserOrder convert2ModelWithoutId(UserOrderDTO dtoUserOrder, UserDTO dtoUser) {
		UserOrder userOrder = UserOrder.getBuilder()
				.withUser(UserDetailWrapper.getInstance().convert2ModelWithId(dtoUser))
				.withOrderedItems(UserOrderedItemWrapper.getInstance().convertUserOrderedItems2ModelWithoutId(dtoUserOrder.getDtoOrderedItems()))
				.withStatus(dtoUserOrder.getStatus())
				.build();
		return userOrder;
	}
}
