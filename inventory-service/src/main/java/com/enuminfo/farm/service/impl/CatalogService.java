/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.CatalogDTO;
import com.enuminfo.farm.service.ICatalogService;

/**
 * @author Kumar
 */
@Service
public class CatalogService implements ICatalogService {

	@Override
	public void add(CatalogDTO dtoCatalog) {
		
	}

	@Override
	public List<CatalogDTO> loadAll() {
		return null;
	}

	@Override
	public CatalogDTO loadById(int id) {
		return null;
	}

	@Override
	public CatalogDTO loadByName(String name) {
		return null;
	}

	@Override
	public void edit(CatalogDTO dtoCatalog) {
		
	}

	@Override
	public void remove(int id) {
		
	}
}
