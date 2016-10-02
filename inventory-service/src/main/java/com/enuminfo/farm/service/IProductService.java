/**
 * 
 */
package com.enuminfo.farm.service;

import java.util.List;

import com.enuminfo.farm.dto.ProductDTO;

/**
 * @author Kumar
 */
public interface IProductService {

	void add(ProductDTO dtoProduct);
	List<ProductDTO> loadAll();
	ProductDTO loadById(int id);
	ProductDTO loadByName(String name);
	void edit(ProductDTO dtoProduct);
	void remove(int id);
	List<ProductDTO> loadProductsByStock(boolean stock);
}
