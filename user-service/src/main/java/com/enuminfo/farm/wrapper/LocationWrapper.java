/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.LocationDTO;
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
	
	public Location convert2ModelWithoutId(LocationDTO dtoLocation) {
		Location location = Location.getBuilder()
				.withName(dtoLocation.getLocationName())
				.withPin(dtoLocation.getPinCode())
				.withCity(dtoLocation.getCityName())
				.withState(dtoLocation.getStateName())
				.withCountry(CountryWrapper.getInstance().convert2ModelWithoutId(dtoLocation))
				.build();
		return location;
	}
	
	public LocationDTO convert2DTO(Location location) {
		LocationDTO dtoLocation = new LocationDTO();
		
		return dtoLocation;
	}
}
