/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.UserDTO;
import com.enuminfo.farm.model.Location;

/**
 * @author Kumar
 */
public class LocationWrapper {

	LocationWrapper() {
		
	}
	
	public static LocationWrapper getInstance() {
		return SingletonWrapper.LOCATION_WRAPPER_INSTANCE;
	}
	
	public Location convert2ModelWithoutId(UserDTO dtoUser) {
		Location location = Location.getBuilder()
				.withName(dtoUser.getLocationName())
				.withPin(Integer.parseInt(dtoUser.getPinCode()))
				.withCity(dtoUser.getCityName())
				.withState(dtoUser.getStateName())
				.withCountry(CountryWrapper.getInstance().convert2ModelWithoutId(dtoUser))
				.build();
		return location;
	}
}
