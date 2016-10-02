/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.CategoryDTO;

/**
 * @author Kumar
 */
public interface ICategoryService {

	void add(CategoryDTO dtoCategory);
	List<CategoryDTO> loadAll();
	CategoryDTO loadById(int id);
	CategoryDTO loadByName(String name);
	void edit(CategoryDTO dtoCategory);
	void remove(int id);
}
