/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserOrderedItemDeliveryLocation;

/**
 * @author Kumar
 */
public interface IUserOrderedItemDeliveryLocationRepository extends PagingAndSortingRepository<UserOrderedItemDeliveryLocation, Integer> {

}
