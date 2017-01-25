/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Address;

/**
 * @author Kumar
 */
public interface IAddressRepository extends PagingAndSortingRepository<Address, Integer> {

}
