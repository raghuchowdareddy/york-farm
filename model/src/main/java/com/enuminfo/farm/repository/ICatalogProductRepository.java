/**
 * 
 */
package com.enuminfo.farm.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Catalog;
import com.enuminfo.farm.model.CatalogProduct;

/**
 * @author Kumar
 */
public interface ICatalogProductRepository extends PagingAndSortingRepository<CatalogProduct, Integer> {

	Iterable<CatalogProduct> findByCatalog(Catalog catalog);
}
