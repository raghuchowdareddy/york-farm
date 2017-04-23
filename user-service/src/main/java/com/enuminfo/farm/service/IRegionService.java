/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.LocationDTO;

/**
 * @author Kumar
 */
public interface IRegionService {

	void addCountry(LocationDTO dtoLocation);
	List<LocationDTO> loadAllCountries();
	void addLocation(LocationDTO dtoLocation);
	List<LocationDTO> loadAllStates(String countryName);
	List<LocationDTO> loadAllCities(String stateName);
	List<LocationDTO> loadAllLocations(String cityName);
	LocationDTO loadLocation(int locationId);
	List<LocationDTO> loadAllDeliveryLocations();
	void addDeliveryLocation(LocationDTO dtoDeliveryLocation);
	void editDeliveryLocation(LocationDTO dtoDeliveryLocation);
	List<LocationDTO> loadAllDeliveryLocations(int locationId);
}
