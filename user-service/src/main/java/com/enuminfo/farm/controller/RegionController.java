/**
 * 
 */
package com.enuminfo.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enuminfo.farm.dto.LocationDTO;
import com.enuminfo.farm.path.RequestPath;
import com.enuminfo.farm.service.IRegionService;

/**
 * @author Kumar
 */
@Controller
@RequestMapping (name = RequestPath.REGION)
public class RegionController {

	@Autowired
	IRegionService service;
	
	@RequestMapping (value = RequestPath.COUNTRIES, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LocationDTO> handleInteralRequestForAllCountries() {
		return service.loadAllCountries();
	}
	
	@RequestMapping (value = RequestPath.STATES + RequestPath.COUNTRY, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LocationDTO> handleInternalRequestForAllStates(@PathVariable String country) {
		return service.loadAllStates(country);
	}
	
	@RequestMapping (value = RequestPath.CITIES + RequestPath.STATE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LocationDTO> handleInternalRequestForAllCities(@PathVariable String state) {
		return service.loadAllCities(state);
	}
	
	@RequestMapping (value = RequestPath.LOCATIONS + RequestPath.CITY, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LocationDTO> handleInternalRequestForAllLocations(@PathVariable String city) {
		return service.loadAllLocations(city);
	}
	
	@RequestMapping (value = RequestPath.LOCATION + RequestPath.ID, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public LocationDTO handleInternalRequestForLocationById(@PathVariable Integer id) {
		return service.loadLocation(id);
	}
}
