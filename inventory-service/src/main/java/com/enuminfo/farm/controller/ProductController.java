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

import com.enuminfo.farm.dto.ProductDTO;
import com.enuminfo.farm.path.RequestPath;
import com.enuminfo.farm.service.IProductService;

/**
 * @author Kumar
 */
@RestController
@RequestMapping(value = RequestPath.PRODUCT)
public class ProductController {

	@Autowired
	IProductService productService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ProductDTO> handleInternalRequestForAll() {
		return productService.loadAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void handleInternalRequestForSave(@RequestBody ProductDTO dtoProduct) {
		if (dtoProduct.getProductId() == 0) productService.add(dtoProduct);
		else productService.edit(dtoProduct);
	}
}
