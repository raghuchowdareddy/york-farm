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
				.withStatus(dtoUserOrder.getStatus())
				.build();
		return userOrder;
	}
	
	public UserOrderDTO convert2DTO(UserOrder userOrder) {
		UserOrderDTO dtoUserOrder = new UserOrderDTO();
		dtoUserOrder.setOrderId(userOrder.getUserOrderId());
		dtoUserOrder.setUserName(userOrder.getUser().getName());
		dtoUserOrder.setMobileNumber(userOrder.getUser().getMobileNumber());
		dtoUserOrder.setEmailAddress(userOrder.getUser().getEmailAddress());
		dtoUserOrder.setStatus(userOrder.getStatus());
		return dtoUserOrder;
	}
}
