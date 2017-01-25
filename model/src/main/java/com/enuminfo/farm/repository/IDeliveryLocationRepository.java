/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.DeliveryLocation;
import com.enuminfo.farm.model.Location;

/**
 * @author Kumar
 */
public interface IDeliveryLocationRepository extends PagingAndSortingRepository<DeliveryLocation, Integer> {

	Iterable<DeliveryLocation> findByLocation(Location location);
}
