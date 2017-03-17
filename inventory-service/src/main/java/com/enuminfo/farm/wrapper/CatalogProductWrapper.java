/**
 * 
 */
package com.enuminfo.farm.wrapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.enuminfo.farm.dto.CatalogProductDTO;
import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.dto.ProductDTO;
import com.enuminfo.farm.model.CatalogProduct;
import com.enuminfo.farm.model.Category;
import com.enuminfo.farm.model.Product;

/**
 * @author Kumar
 */
public class CatalogProductWrapper {

	CatalogProductWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	public static CatalogProductWrapper getInstance() {
		return SingletonWrapper.CATALOG_PRODUCT_WRAPPER_INSTANCE;
	}
	
	public CatalogProduct convert2ModelWithoutId(CatalogProductDTO dtoCatalogProduct, ProductDTO dtoProduct, CategoryDTO dtoCategory) {
		CatalogProduct catalogProduct = CatalogProduct.getBuilder()
				.withProduct(ProductWrapper.getInstance().convert2ModelWithId(dtoProduct, dtoCategory))
				.withQuantity(dtoCatalogProduct.getQuantity())
				.withPrice(dtoCatalogProduct.getPrice())
				.build();
		return catalogProduct;
	}
	
	public CatalogProduct convert2ModelWithId(CatalogProductDTO dtoCatalogProduct, ProductDTO dtoProduct, CategoryDTO dtoCategory) {
		CatalogProduct catalogProduct = CatalogProduct.getBuilder()
				.withId(dtoCatalogProduct.getCatalogProductId())
				.withProduct(ProductWrapper.getInstance().convert2ModelWithId(dtoProduct, dtoCategory))
				.withQuantity(dtoCatalogProduct.getQuantity())
				.withPrice(dtoCatalogProduct.getPrice())
				.build();
		return catalogProduct;
	}
	
	public List<CatalogProduct> convertCatalogProducts2ModelWithoutId(List<CatalogProductDTO> dtoCatalogProducts) {
		List<CatalogProduct> catalogProducts = new ArrayList<CatalogProduct>();
		for (Iterator<CatalogProductDTO> iterator = dtoCatalogProducts.iterator(); iterator.hasNext();) {
			CatalogProductDTO dtoCatalogProduct = iterator.next();
			Category category = Category.getBuilder()
					.withId(dtoCatalogProduct.getCategoryId())
					.withName(dtoCatalogProduct.getCategoryName())
					.build();
			Product product = Product.getBuilder()
					.withId(dtoCatalogProduct.getProductId())
					.withName(dtoCatalogProduct.getProductName())
					.withDescription(dtoCatalogProduct.getProductDescription())
					.withCategory(category)
					.build();
			CatalogProduct catalogProduct = CatalogProduct.getBuilder()
					.withProduct(product)
					.withQuantity(dtoCatalogProduct.getQuantity())
					.withPrice(dtoCatalogProduct.getPrice())
					.build();
			catalogProducts.add(catalogProduct);
		}
		return catalogProducts;
	}
	
	public CatalogProductDTO convert2DTO(CatalogProduct catalogProduct) {
		CatalogProductDTO dtoCatalogProduct = new CatalogProductDTO();
		dtoCatalogProduct.setCatalogProductId(catalogProduct.getId());
		dtoCatalogProduct.setProductId(catalogProduct.getProduct().getId());
		dtoCatalogProduct.setProductName(catalogProduct.getProduct().getName());
		dtoCatalogProduct.setCategoryId(catalogProduct.getProduct().getCategory().getId());
		dtoCatalogProduct.setCategoryName(catalogProduct.getProduct().getCategory().getName());
		dtoCatalogProduct.setQuantity(catalogProduct.getQuantity());
		dtoCatalogProduct.setPrice(catalogProduct.getPrice());
		return dtoCatalogProduct;
	}
}
