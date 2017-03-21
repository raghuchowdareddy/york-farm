/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Product;
import com.enuminfo.farm.model.UserOrder;
import com.enuminfo.farm.model.UserOrderedItem;

/**
 * @author Kumar
 */
public interface IUserOrderedItemRepository extends PagingAndSortingRepository<UserOrderedItem, Integer> {

	Iterable<UserOrderedItem> findByUserOrder(UserOrder order);
	Iterable<UserOrderedItem> findByProduct(Product product);
}
