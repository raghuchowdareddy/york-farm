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
import com.enuminfo.farm.dto.ProductDTO;
import com.enuminfo.farm.model.Product;
import com.enuminfo.farm.repository.IProductRepository;
import com.enuminfo.farm.service.ICategoryService;
import com.enuminfo.farm.service.IProductService;
import com.enuminfo.farm.wrapper.ProductWrapper;

/**
 * @author Kumar
 */
@Service
public class ProductService implements IProductService {

	@Autowired
	IProductRepository productRepository;
	
	@Autowired
	ICategoryService categoryService;
	
	@Override
	public void add(ProductDTO dtoProduct) {
		CategoryDTO dtoCategory = categoryService.loadById(dtoProduct.getCategoryId());
		Product product = ProductWrapper.getInstance().convert2ModelWithoutId(dtoProduct, dtoCategory);
		productRepository.save(product);
	}

	@Override
	public List<ProductDTO> loadAll() {
		List<ProductDTO> dtoProducts = new ArrayList<ProductDTO>();
		Iterable<Product> products = productRepository.findAll();
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			dtoProducts.add(ProductWrapper.getInstance().convert2DTO(iterator.next()));
		}
		return dtoProducts;
	}

	@Override
	public ProductDTO loadById(int id) {
		return ProductWrapper.getInstance().convert2DTO(productRepository.findOne(id));
	}

	@Override
	public ProductDTO loadByName(String name) {
		return ProductWrapper.getInstance().convert2DTO(productRepository.findByName(name));
	}

	@Override
	public void edit(ProductDTO dtoProduct) {
		CategoryDTO dtoCategory = categoryService.loadById(dtoProduct.getCategoryId());
		Product product = ProductWrapper.getInstance().convert2ModelWithId(dtoProduct, dtoCategory);
		productRepository.save(product);
	}

	@Override
	public void remove(int id) {
		
	}

	@Override
	public List<ProductDTO> loadProductsByStock(boolean stock) {
		return null;
	}
}
