/**
 * 
 */
package com.enuminfo.farm.wrapper;

import java.util.List;

import com.enuminfo.farm.dto.RoleDTO;
import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Customer;

/**
 * @author Kumar
 */
public class CustomerWrapper {

	CustomerWrapper() {
		
	}
	
	public static CustomerWrapper getInstance() {
		return SingletonWrapper.CUSTOMER_WRAPPER_INSTANCE;
	}
	
	public UserDTO convert2DTO(Customer customer) {
		UserDTO dtoUser = new UserDTO();
		dtoUser = UserWrapper.getInstance().convert2DTO(customer.getUser());
		dtoUser.setName(customer.getName());
		dtoUser.setEmailId(customer.getEmailAddress());
		dtoUser.setMobileNo(customer.getMobileNumber());
		return dtoUser;
	}
	
	public Customer convert2ModelWithoutId(UserDTO dtoUser, List<RoleDTO> dtoRoles) {
		Customer customer = Customer.getBuilder()
				.withName(dtoUser.getName())
				.withEmailAddress(dtoUser.getEmailId())
				.withMobileNumber(dtoUser.getMobileNo())
				.withUser(UserWrapper.getInstance().convert2ModelWithoutId(dtoUser, dtoRoles))
				.build();		
		return customer;
	}
	
	public Customer convert2ModelWithId(UserDTO dtoUser) {
		Customer customer = Customer.getBuilder()
				.withId(dtoUser.getUserId())
				.withName(dtoUser.getName())
				.withEmailAddress(dtoUser.getEmailId())
				.withMobileNumber(dtoUser.getMobileNo())
				.withUser(UserWrapper.getInstance().convert2ModelWithId(dtoUser))
				.build();		
		return customer;
	}
}
