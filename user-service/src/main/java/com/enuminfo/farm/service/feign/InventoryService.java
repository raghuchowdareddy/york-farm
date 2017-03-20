/**
 * 
 */
package com.enuminfo.farm.service.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.dto.ProductDTO;
import com.enuminfo.farm.path.RequestPath;

/**
 * @author Kumar
 */
@FeignClient (value = "inventory-service")
public interface InventoryService {

	@RequestMapping(method = RequestMethod.GET, value = RequestPath.PRODUCT + RequestPath.ID)
	public ProductDTO callProductServiceById(@PathVariable ("id") int id);
	
	@RequestMapping(method = RequestMethod.GET, value = RequestPath.CATEGORY + RequestPath.ID)
	public CategoryDTO callCategoryServiceById(@PathVariable ("id") int id);
}
