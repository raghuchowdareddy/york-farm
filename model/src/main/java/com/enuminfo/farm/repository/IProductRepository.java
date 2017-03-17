/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Category;
import com.enuminfo.farm.model.Product;

/**
 * @author Kumar
 */
public interface IProductRepository extends PagingAndSortingRepository<Product, Integer> {

	Product findByName(String name);
	Iterable<Product> findByCategory(Category category);
}
