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
import com.enuminfo.farm.wrapper.CategoryWrapper;

/**
 * @author Kumar
 */
@Service
public class CategoryService implements ICategoryService {

	@Autowired
	ICategoryRepository categoryRepository;
	
	@Override
	public void add(CategoryDTO dtoCategory) {
		Category category = CategoryWrapper.getInstance().convert2ModelWithoutId(dtoCategory);
		categoryRepository.save(category);
	}

	@Override
	public List<CategoryDTO> loadAll() {
		List<CategoryDTO> dtoCategories = new ArrayList<CategoryDTO>();
		Iterable<Category> categories = categoryRepository.findAll();
		for (Iterator<Category> iterator = categories.iterator(); iterator.hasNext();) {
			dtoCategories.add(CategoryWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoCategories;
	}

	@Override
	public CategoryDTO loadById(int id) {
		return CategoryWrapper.getInstance().convert2DTO(categoryRepository.findOne(id));
	}

	@Override
	public CategoryDTO loadByName(String name) {
		return CategoryWrapper.getInstance().convert2DTO(categoryRepository.findByName(name));
	}

	@Override
	public void edit(CategoryDTO dtoCategory) {
		Category category = CategoryWrapper.getInstance().convert2ModelWithId(dtoCategory);
		categoryRepository.save(category);
	}

	@Override
	public void remove(int id) {
		Category category = CategoryWrapper.getInstance().convert2ModelWithId(CategoryWrapper.getInstance().convert2DTO(categoryRepository.findOne(id)));
		categoryRepository.delete(category);
	}
}
