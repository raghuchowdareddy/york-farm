/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.model.Category;

/**
 * @author Kumar
 */
public class CategoryWrapper {

	CategoryWrapper() {

	}
	
	public static CategoryWrapper getInstance() {
		return SingletonWrapper.CATEGORY_WRAPPER_INSTANCE;
	}
	
	public CategoryDTO convert2DTO(Category category) {
		CategoryDTO dtoCategory = new CategoryDTO();
		dtoCategory.setCategoryId(category.getId());
		dtoCategory.setCategoryName(category.getName());
		return dtoCategory;
	}
	
	public Category convert2ModelWithId(CategoryDTO dtoCategory) {
		Category category = Category.getBuilder()
				.withId(dtoCategory.getCategoryId())
				.withName(dtoCategory.getCategoryName())
				.build();
		return category;
	}
	
	public Category convert2ModelWithoutId(CategoryDTO dtoCategory) {
		Category category = Category.getBuilder()
				.withName(dtoCategory.getCategoryName())
				.build();
		return category;
	}
	
	public Category convert2ModelWithId(int categoryId, String categoryName) {
		Category category = Category.getBuilder()
				.withId(categoryId)
				.withName(categoryName)
				.build();
		return category;
	}
}
