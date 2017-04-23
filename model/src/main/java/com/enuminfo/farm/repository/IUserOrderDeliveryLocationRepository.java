/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.model.UserOrderDeliveryLocation;

/**
 * @author Kumar
 */
public interface IUserOrderDeliveryLocationRepository extends PagingAndSortingRepository<UserOrderDeliveryLocation, Integer> {

	UserOrderDeliveryLocation findByUserOrder(UserOrder userOrder);
}
