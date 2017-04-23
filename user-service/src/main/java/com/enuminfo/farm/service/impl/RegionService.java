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
		Country country = Country.getBuilder()
				.withName(dtoLocation.getCountryName())
				.withIsd(dtoLocation.getIsdCode())
				.build();
		countryRepository.save(country);
	}

	@Override
	public List<LocationDTO> loadAllCountries() {
		List<LocationDTO> dtoCountries = new ArrayList<LocationDTO>();
		Iterable<Country> countries = countryRepository.findAll();
		for (Iterator<Country> iterator = countries.iterator(); iterator.hasNext();) {
			dtoCountries.add(convert2DTO(iterator.next()));
		}
		return dtoCountries;
	}

	@Override
	public void addLocation(LocationDTO dtoLocation) {
		Location location = Location.getBuilder()
				.withName(dtoLocation.getLocationName())
				.withPin(dtoLocation.getPinCode())
				.withCity(dtoLocation.getCityName())
				.withState(dtoLocation.getStateName())
				.withCountry(countryRepository.findOne(dtoLocation.getCountryId()))
				.build();
		locationRepository.save(location);
	}

	@Override
	public List<LocationDTO> loadAllStates(String countryName) {
		List<LocationDTO> dtoStates = new ArrayList<LocationDTO>();
		Country country = countryRepository.findByName(countryName);
		Iterable<Location> states = locationRepository.findByCountry(country);
		for (Iterator<Location> iterator = states.iterator(); iterator.hasNext();) {
			dtoStates.add(convert2DTO(iterator.next()));
		}
		return dtoStates;
	}

	@Override
	public List<LocationDTO> loadAllCities(String stateName) {
		List<LocationDTO> dtoCities = new ArrayList<LocationDTO>();
		Iterable<Location> cities = locationRepository.findByState(stateName);
		for (Iterator<Location> iterator = cities.iterator(); iterator.hasNext();) {
			dtoCities.add(convert2DTO(iterator.next()));
		}
		return dtoCities;
	}

	@Override
	public List<LocationDTO> loadAllLocations(String cityName) {
		List<LocationDTO> dtoLocations = new ArrayList<LocationDTO>();
		Iterable<Location> locations = locationRepository.findByCity(cityName);
		for (Iterator<Location> iterator = locations.iterator(); iterator.hasNext();) {
			dtoLocations.add(convert2DTO(iterator.next()));
		}
		return dtoLocations;
	}

	@Override
	public LocationDTO loadLocation(int locationId) {
		return convert2DTO(locationRepository.findOne(locationId));
	}

	@Override
	public List<LocationDTO> loadAllDeliveryLocations() {
		List<LocationDTO> dtoDeliveryLocations = new ArrayList<LocationDTO>();
		Iterable<DeliveryLocation> deliveryLocations = deliveryLocationRepository.findAll();
		for (Iterator<DeliveryLocation> iterator = deliveryLocations.iterator(); iterator.hasNext();) {
			dtoDeliveryLocations.add(convert2DTO(iterator.next()));
		}
		return dtoDeliveryLocations;
	}

	@Override
	public void addDeliveryLocation(LocationDTO dtoDeliveryLocation) {
		DeliveryLocation deliveryLocation = DeliveryLocation.getBuilder()
				.withStreet(dtoDeliveryLocation.getValue1())
				.withLandmark1(dtoDeliveryLocation.getValue2())
				.withLandmark2(dtoDeliveryLocation.getValue3())
				.withLocation(locationRepository.findByName(dtoDeliveryLocation.getLocationName()))
				.build();
		deliveryLocationRepository.save(deliveryLocation);
	}

	@Override
	public void editDeliveryLocation(LocationDTO dtoDeliveryLocation) {
		DeliveryLocation deliveryLocation = DeliveryLocation.getBuilder()
				.withId(dtoDeliveryLocation.getLocationId())
				.withStreet(dtoDeliveryLocation.getValue1())
				.withLandmark1(dtoDeliveryLocation.getValue2())
				.withLandmark2(dtoDeliveryLocation.getValue3())
				.withLocation(locationRepository.findByName(dtoDeliveryLocation.getLocationName()))
				.build();
		deliveryLocationRepository.save(deliveryLocation);
	}
	
	private LocationDTO convert2DTO(Country country) {
		LocationDTO dtoLocation = new LocationDTO();
		dtoLocation.setCountryId(country.getId());
		dtoLocation.setCountryName(country.getName());
		dtoLocation.setIsdCode(country.getIsd());
		return dtoLocation;
	}
	
	private LocationDTO convert2DTO(Location location) {
		LocationDTO dtoLocation = new LocationDTO();
		dtoLocation.setLocationId(location.getId());
		dtoLocation.setLocationName(location.getName());
		dtoLocation.setCityName(location.getCity());
		dtoLocation.setStateName(location.getState());
		dtoLocation.setPinCode(location.getPin());
		dtoLocation.setCountryId(location.getCountry().getId());
		dtoLocation.setCountryName(location.getCountry().getName());
		dtoLocation.setIsdCode(location.getCountry().getIsd());
		return dtoLocation;
	}
	
	public LocationDTO convert2DTO(DeliveryLocation deliveryLocation) {
		LocationDTO dtoLocation = convert2DTO(deliveryLocation.getLocation());
		dtoLocation.setLocationId(deliveryLocation.getId());
		dtoLocation.setValue1(deliveryLocation.getStreet());
		dtoLocation.setValue2(deliveryLocation.getLandmark1());
		dtoLocation.setValue3(deliveryLocation.getLandmark2());
		return dtoLocation;
	}

	@Override
	public List<LocationDTO> loadAllDeliveryLocations(int locationId) {
		List<LocationDTO> dtoDeliveryLocations = new ArrayList<LocationDTO>();
		Location location = locationRepository.findOne(locationId);
		Iterable<DeliveryLocation> deliveryLocations = deliveryLocationRepository.findByLocation(location);
		for (Iterator<DeliveryLocation> iterator = deliveryLocations.iterator(); iterator.hasNext();) {
			dtoDeliveryLocations.add(convert2DTO(iterator.next()));
		}
		return dtoDeliveryLocations;
	}
}
