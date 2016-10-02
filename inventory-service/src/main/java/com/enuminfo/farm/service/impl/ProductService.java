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
import com.enuminfo.farm.model.Category;
import com.enuminfo.farm.model.Product;
import com.enuminfo.farm.repository.IProductRepository;
import com.enuminfo.farm.service.ICategoryService;
import com.enuminfo.farm.service.IProductService;

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
		Category category = Category.getBuilder()
				.withId(dtoCategory.getCategoryId())
				.withName(dtoCategory.getCategoryName())
				.build();
		Product product = Product.getBuilder()
				.withName(dtoProduct.getProductName())
				.withDescription(dtoProduct.getProductDescription())
				.withPrice(dtoProduct.getPrice())
				.withStock(dtoProduct.isStock())
				.withCategory(category)
				.build();
		productRepository.save(product);
	}

	@Override
	public List<ProductDTO> loadAll() {
		List<ProductDTO> dtoProducts = new ArrayList<ProductDTO>();
		Iterable<Product> products = productRepository.findAll();
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			dtoProducts.add(convert2DTO(iterator.next()));
		}
		return dtoProducts;
	}

	@Override
	public ProductDTO loadById(int id) {
		return convert2DTO(productRepository.findOne(id));
	}

	@Override
	public ProductDTO loadByName(String name) {
		return null;
	}

	@Override
	public void edit(ProductDTO dtoProduct) {
		CategoryDTO dtoCategory = categoryService.loadById(dtoProduct.getCategoryId());
		Category category = Category.getBuilder()
				.withId(dtoCategory.getCategoryId())
				.withName(dtoCategory.getCategoryName())
				.build();
		Product product = Product.getBuilder()
				.withId(dtoProduct.getProductId())
				.withName(dtoProduct.getProductName())
				.withDescription(dtoProduct.getProductDescription())
				.withPrice(dtoProduct.getPrice())
				.withStock(dtoProduct.isStock())
				.withCategory(category)
				.build();
		productRepository.save(product);
	}

	@Override
	public void remove(int id) {
		
	}

	@Override
	public List<ProductDTO> loadProductsByStock(boolean stock) {
		return null;
	}
	
	private ProductDTO convert2DTO(Product product) {
		ProductDTO dtoProduct = new ProductDTO();
		dtoProduct.setProductId(product.getId());
		dtoProduct.setProductName(product.getName());
		dtoProduct.setProductDescription(product.getDescription());
		dtoProduct.setPrice(product.getPrice());
		dtoProduct.setStock(product.getStock());
		dtoProduct.setCategoryId(product.getCategory().getId());
		dtoProduct.setCategoryName(product.getCategory().getName());
		return dtoProduct;
	}
}
