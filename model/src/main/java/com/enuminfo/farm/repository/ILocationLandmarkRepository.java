/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.LandMark;
import com.enuminfo.farm.model.Location;

/**
 * @author Kumar
 */
public interface ILocationLandmarkRepository extends PagingAndSortingRepository<LandMark, Integer> {

	Iterable<LandMark> findByLocation(Location location);
}
