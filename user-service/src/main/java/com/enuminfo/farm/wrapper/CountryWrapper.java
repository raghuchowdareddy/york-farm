/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.LocationDTO;
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
	
	public Country convert2ModelWithoutId(LocationDTO dtoLocation) {
		Country country = Country.getBuilder()
				.withName(dtoLocation.getCountryName())
				.withIsd(dtoLocation.getIsdCode())
				.build();
		return country;
	}
	
	public LocationDTO convert2DTO(Country country) {
		LocationDTO dtoLocation = new LocationDTO();
		dtoLocation.setCountryId(country.getId());
		dtoLocation.setCountryName(country.getName());
		dtoLocation.setIsdCode(country.getIsd());
		return dtoLocation;
	}
}
