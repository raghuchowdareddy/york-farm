/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Country;

/**
 * @author Kumar
 */
public interface ICountryRepository extends PagingAndSortingRepository<Country, Integer> {

	Country findByName(String name);
}
