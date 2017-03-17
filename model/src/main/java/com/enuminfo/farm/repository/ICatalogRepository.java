/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Catalog;

/**
 * @author Kumar
 */
public interface ICatalogRepository extends PagingAndSortingRepository<Catalog, Integer> {

}
