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
		dtoProduct.setCategoryId(product.getCategory().getId());
		dtoProduct.setCategoryName(product.getCategory().getName());
		return dtoProduct;
	}
	
	public Product convert2ModelWithId(ProductDTO dtoProduct, CategoryDTO dtoCategory) {
		Product product = Product.getBuilder()
				.withId(dtoProduct.getProductId())
				.withName(dtoProduct.getProductName())
				.withDescription(dtoProduct.getProductDescription())
				.withCategory(CategoryWrapper.getInstance().convert2ModelWithId(dtoCategory))
				.build();
		return product;
	}
	
	public Product convert2ModelWithoutId(ProductDTO dtoProduct, CategoryDTO dtoCategory) {
		Product product = Product.getBuilder()
				.withName(dtoProduct.getProductName())
				.withDescription(dtoProduct.getProductDescription())
				.withCategory(SingletonWrapper.CATEGORY_WRAPPER_INSTANCE.convert2ModelWithId(dtoCategory))
				.build();
		return product;
	}
	
	public Product convert2ModelWithId(int productId, String productName, String description, int categoryId, String categoryName) {
		Product product = Product.getBuilder()
				.withId(productId)
				.withName(productName)
				.withDescription(description)
				.withCategory(CategoryWrapper.getInstance().convert2ModelWithId(categoryId, categoryName))
				.build();
		return product;
	}
}
