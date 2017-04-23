/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Category;

/**
 * @author Kumar
 */
public interface ICategoryRepository extends PagingAndSortingRepository<Category, Integer> {

	Category findByName(String name);
}
