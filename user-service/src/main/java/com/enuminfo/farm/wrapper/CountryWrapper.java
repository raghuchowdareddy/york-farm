/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Country;

/**
 * @author Kumar
 */
public class CountryWrapper {

	CountryWrapper() {
		
	}
	
	public static CountryWrapper getInstance() {
		return SingletonWrapper.COUNTRY_WRAPPER_INSTANCE;
	}
	
	public Country convert2ModelWithoutId(UserDTO dtoUser) {
		Country country = Country.getBuilder()
				.withName(dtoUser.getCountryName())
				.withIsd(dtoUser.getIsdCode())
				.build();
		return country;
	}
}
