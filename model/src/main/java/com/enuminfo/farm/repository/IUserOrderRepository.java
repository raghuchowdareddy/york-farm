/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserDetail;
import com.enuminfo.farm.model.UserOrder;

/**
 * @author Kumar
 */
public interface IUserOrderRepository extends PagingAndSortingRepository<UserOrder, Integer> {

	Iterable<UserOrder> findByStatus(String status);
	Iterable<UserOrder> findByUserAndStatusOrderByOrderedDateDesc(UserDetail user, String status);
	Iterable<UserOrder> findByStatusOrDeliveryStatus( String status,String deliveryStatus);
}
