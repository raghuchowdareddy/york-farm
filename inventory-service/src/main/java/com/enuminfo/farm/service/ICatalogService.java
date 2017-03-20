/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.CatalogDTO;
import com.enuminfo.farm.dto.CatalogProductDTO;

/**
 * @author Kumar
 */
public interface ICatalogService {

	void add(CatalogDTO dtoCatalog);
	List<CatalogDTO> loadAll();
	CatalogDTO loadById(int id);
	CatalogDTO loadByName(String name);
	void edit(CatalogDTO dtoCatalog);
	void remove(int id);
	List<CatalogProductDTO> loadAllWeekCatalogProductsByCategory(String categoryName);
}