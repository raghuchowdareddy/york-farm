/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Location;

/**
 * @author Kumar
 */
public interface ILocationRepository extends PagingAndSortingRepository<Location, Integer> {

}
