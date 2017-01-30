/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserOrder;

/**
 * @author Kumar
 */
public interface IUserOrderRepository extends PagingAndSortingRepository<UserOrder, Integer> {

}
