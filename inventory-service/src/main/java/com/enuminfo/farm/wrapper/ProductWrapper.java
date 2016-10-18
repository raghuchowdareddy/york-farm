/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.dto.ProductDTO;
import com.enuminfo.farm.model.Product;

/**
 * @author Kumar
 */
public class ProductWrapper {
	
	ProductWrapper() {

	}
	
	public static ProductWrapper getInstance() {
		return SingletonWrapper.PRODUCT_WRAPPER_INSTANCE;
	}

	public ProductDTO convert2DTO(Product product) {
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
	
	public Product convert2ModelWithId(ProductDTO dtoProduct, CategoryDTO dtoCategory) {
		Product product = Product.getBuilder()
				.withId(dtoProduct.getProductId())
				.withName(dtoProduct.getProductName())
				.withDescription(dtoProduct.getProductDescription())
				.withPrice(dtoProduct.getPrice())
				.withStock(dtoProduct.isStock())
				.withCategory(SingletonWrapper.CATEGORY_WRAPPER_INSTANCE.convert2ModelWithId(dtoCategory))
				.build();
		return product;
	}
	
	public Product convert2ModelWithoutId(ProductDTO dtoProduct, CategoryDTO dtoCategory) {
		Product product = Product.getBuilder()
				.withName(dtoProduct.getProductName())
				.withDescription(dtoProduct.getProductDescription())
				.withPrice(dtoProduct.getPrice())
				.withStock(dtoProduct.isStock())
				.withCategory(SingletonWrapper.CATEGORY_WRAPPER_INSTANCE.convert2ModelWithId(dtoCategory))
				.build();
		return product;
	}
}
