/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Country;
import com.enuminfo.farm.model.Location;

/**
 * @author Kumar
 */
public interface ILocationRepository extends PagingAndSortingRepository<Location, Integer> {

	Iterable<Location> findByCountry(Country country);
	Iterable<Location> findByState(String state);
	Iterable<Location> findByCity(String city);
}
