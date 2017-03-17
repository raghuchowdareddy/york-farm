/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.LocationDTO;
import com.enuminfo.farm.model.Country;
import com.enuminfo.farm.model.DeliveryLocation;
import com.enuminfo.farm.model.Location;
import com.enuminfo.farm.repository.ICountryRepository;
import com.enuminfo.farm.repository.IDeliveryLocationRepository;
import com.enuminfo.farm.repository.ILocationRepository;
import com.enuminfo.farm.service.IRegionService;
import com.enuminfo.farm.wrapper.CountryWrapper;
import com.enuminfo.farm.wrapper.DeliveryLocationWrapper;
import com.enuminfo.farm.wrapper.LocationWrapper;

/**
 * @author Kumar
 */
@Service
public class RegionService implements IRegionService {

	@Autowired ICountryRepository countryRepository;	
	@Autowired ILocationRepository locationRepository;
	@Autowired IDeliveryLocationRepository deliveryLocationRepository;
	
	@Override
	public void addCountry(LocationDTO dtoLocation) {
		Country country = CountryWrapper.getInstance().convert2ModelWithoutId(dtoLocation);
		countryRepository.save(country);
	}

	@Override
	public List<LocationDTO> loadAllCountries() {
		List<LocationDTO> dtoCountries = new ArrayList<LocationDTO>();
		Iterable<Country> countries = countryRepository.findAll();
		for (Iterator<Country> iterator = countries.iterator(); iterator.hasNext();) {
			dtoCountries.add(CountryWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoCountries;
	}

	@Override
	public void addLocation(LocationDTO dtoLocation) {
		Location location = LocationWrapper.getInstance().convert2ModelWithoutId(dtoLocation);
		locationRepository.save(location);
	}

	@Override
	public List<LocationDTO> loadAllStates(String countryName) {
		List<LocationDTO> dtoStates = new ArrayList<LocationDTO>();
		Country country = countryRepository.findByName(countryName);
		Iterable<Location> states = locationRepository.findByCountry(country);
		for (Iterator<Location> iterator = states.iterator(); iterator.hasNext();) {
			dtoStates.add(LocationWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoStates;
	}

	@Override
	public List<LocationDTO> loadAllCities(String stateName) {
		List<LocationDTO> dtoCities = new ArrayList<LocationDTO>();
		Iterable<Location> cities = locationRepository.findByState(stateName);
		for (Iterator<Location> iterator = cities.iterator(); iterator.hasNext();) {
			dtoCities.add(LocationWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoCities;
	}

	@Override
	public List<LocationDTO> loadAllLocations(String cityName) {
		List<LocationDTO> dtoLocations = new ArrayList<LocationDTO>();
		Iterable<Location> locations = locationRepository.findByCity(cityName);
		for (Iterator<Location> iterator = locations.iterator(); iterator.hasNext();) {
			dtoLocations.add(LocationWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoLocations;
	}

	@Override
	public LocationDTO loadLocation(int locationId) {
		return LocationWrapper.getInstance().convert2DTO(locationRepository.findOne(locationId));
	}

	@Override
	public List<LocationDTO> loadAllDeliveryLocations() {
		List<LocationDTO> dtoDeliveryLocations = new ArrayList<LocationDTO>();
		Iterable<DeliveryLocation> deliveryLocations = deliveryLocationRepository.findAll();
		for (Iterator<DeliveryLocation> iterator = deliveryLocations.iterator(); iterator.hasNext();) {
			dtoDeliveryLocations.add(DeliveryLocationWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoDeliveryLocations;
	}

	@Override
	public void addDeliveryLocation(LocationDTO dtoDeliveryLocation) {
		LocationDTO dtoLocation = LocationWrapper.getInstance().convert2DTO(locationRepository.findByName(dtoDeliveryLocation.getLocationName()));
		DeliveryLocation deliveryLocation = DeliveryLocationWrapper.getInstance().convert2ModelWithoutId(dtoDeliveryLocation, dtoLocation);
		deliveryLocationRepository.save(deliveryLocation);
	}

	@Override
	public void editDeliveryLocation(LocationDTO dtoDeliveryLocation) {
		LocationDTO dtoLocation = LocationWrapper.getInstance().convert2DTO(locationRepository.findByName(dtoDeliveryLocation.getLocationName()));
		DeliveryLocation deliveryLocation = DeliveryLocationWrapper.getInstance().convert2ModelWithId(dtoDeliveryLocation, dtoLocation);
		deliveryLocationRepository.save(deliveryLocation);
	}
}
