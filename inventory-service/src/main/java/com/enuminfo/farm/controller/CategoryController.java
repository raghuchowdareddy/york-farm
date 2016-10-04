/**
 * 
 */
package com.enuminfo.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.path.RequestPath;
import com.enuminfo.farm.service.ICategoryService;

/**
 * @author Kumar
 */
@RestController
@RequestMapping(value = RequestPath.CATEGORY)
public class CategoryController {

	@Autowired
	ICategoryService categoryService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CategoryDTO> handleInternalRequestForAll() {
		return categoryService.loadAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void handleInternalRequestForSave(@RequestBody CategoryDTO dtoCategory) {
		if (dtoCategory.getCategoryId() == 0) categoryService.add(dtoCategory);
		else categoryService.edit(dtoCategory);
	}
}
