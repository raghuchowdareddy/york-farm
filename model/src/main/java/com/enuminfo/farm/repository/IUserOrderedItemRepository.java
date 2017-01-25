/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.UserOrderedItem;

/**
 * @author Kumar
 */
public interface IUserOrderedItemRepository extends PagingAndSortingRepository<UserOrderedItem, Integer> {

}
