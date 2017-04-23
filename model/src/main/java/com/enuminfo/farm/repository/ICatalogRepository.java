/**
 * 
 */
package com.enuminfo.farm.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.enuminfo.farm.model.Catalog;

/**
 * @author Kumar
 */
public interface ICatalogRepository extends PagingAndSortingRepository<Catalog, Integer> {

	@Query ("SELECT model FROM Catalog model WHERE model.startDate BETWEEN ?1 AND ?2 AND model.endDate BETWEEN ?1 AND ?2")
	Catalog findByDatesBetween(Date startDate, Date endDate);
}
