/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Address;
import com.enuminfo.farm.model.Customer;

/**
 * @author Kumar
 */
public class AddressWrapper {

	AddressWrapper() {
		
	}
	
	public static AddressWrapper getInstance() {
		return SingletonWrapper.ADDRESS_WRAPPER_INSTANCE;
	}
	
	public UserDTO convert2DTO(Customer customer) {
		UserDTO dtoUserAddress = new UserDTO();
		
		return dtoUserAddress;
	}
	
	public Address convert2ModelWithoutId(UserDTO dtoUser) {
		Address address = Address.getBuilder()
				.withHouseNo(dtoUser.getAddress1())
				.withStreet(dtoUser.getAddress2())
				.withStreet(dtoUser.getAddress3())
				.withLocation(LocationWrapper.getInstance().convert2ModelWithoutId(dtoUser))
				.build();
		return address;
	}
}
