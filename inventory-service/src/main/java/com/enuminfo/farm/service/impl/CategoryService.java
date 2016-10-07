/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.model.Category;
import com.enuminfo.farm.repository.ICategoryRepository;
import com.enuminfo.farm.service.ICategoryService;

/**
 * @author Kumar
 */
@Service
public class CategoryService implements ICategoryService {

	@Autowired
	ICategoryRepository categoryRepository;
	
	@Override
	public void add(CategoryDTO dtoCategory) {
		
	}

	@Override
	public List<CategoryDTO> loadAll() {
		List<CategoryDTO> dtoCategories = new ArrayList<CategoryDTO>();
		Iterable<Category> categories = categoryRepository.findAll();
		for (Iterator<Category> iterator = categories.iterator(); iterator.hasNext();) {
			Category category = iterator.next();
			dtoCategories.add(convert2DTO(category));
		}
		return dtoCategories;
	}

	@Override
	public CategoryDTO loadById(int id) {
		return convert2DTO(categoryRepository.findOne(id));
	}

	@Override
	public CategoryDTO loadByName(String name) {
		return convert2DTO(categoryRepository.findByName(name));
	}

	@Override
	public void edit(CategoryDTO dtoCategory) {
		
	}

	@Override
	public void remove(int id) {
		
	}
	
	private CategoryDTO convert2DTO(Category category) {
		CategoryDTO dtoCategory = new CategoryDTO();
		dtoCategory.setCategoryId(category.getId());
		dtoCategory.setCategoryName(category.getName());
		return dtoCategory;
	}
}
