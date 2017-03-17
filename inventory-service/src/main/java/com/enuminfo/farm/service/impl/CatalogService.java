/**
 * 
 */
package com.enuminfo.farm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enuminfo.farm.dto.CatalogDTO;
import com.enuminfo.farm.dto.CatalogProductDTO;
import com.enuminfo.farm.dto.CategoryDTO;
import com.enuminfo.farm.dto.ProductDTO;
import com.enuminfo.farm.model.Catalog;
import com.enuminfo.farm.model.CatalogProduct;
import com.enuminfo.farm.repository.ICatalogProductRepository;
import com.enuminfo.farm.repository.ICatalogRepository;
import com.enuminfo.farm.service.ICatalogService;
import com.enuminfo.farm.service.ICategoryService;
import com.enuminfo.farm.service.IProductService;
import com.enuminfo.farm.util.DateTimeUtil;
import com.enuminfo.farm.wrapper.CatalogProductWrapper;
import com.enuminfo.farm.wrapper.CatalogWrapper;

/**
 * @author Kumar
 */
@Service
public class CatalogService implements ICatalogService {

	@Autowired ICatalogRepository catalogRepository;
	@Autowired ICatalogProductRepository catalogProductRepository;
	@Autowired IProductService productService;
	@Autowired ICategoryService categoryService;
	
	@Override
	public void add(CatalogDTO dtoCatalog) {
		Catalog catalog = CatalogWrapper.getInstance().convert2ModelWithoutId(dtoCatalog);
		catalog = catalogRepository.save(catalog);
		for (Iterator<CatalogProductDTO> iterator = dtoCatalog.getCatalogProducts().iterator(); iterator.hasNext();) {
			CatalogProductDTO dtoCatalogProduct = iterator.next();
			ProductDTO dtoProduct = productService.loadById(dtoCatalogProduct.getProductId());
			CategoryDTO dtoCategory = categoryService.loadById(dtoProduct.getCategoryId());
			CatalogProduct catalogProduct = CatalogProductWrapper.getInstance().convert2ModelWithoutId(dtoCatalogProduct, dtoProduct, dtoCategory);
			catalogProduct.setCatalog(catalog);
			catalogProductRepository.save(catalogProduct);
		}
	}

	@Override
	public List<CatalogDTO> loadAll() {
		List<CatalogDTO> dtoCatalogs = new ArrayList<CatalogDTO>();
		Iterable<Catalog> catalogs = catalogRepository.findAll();
		for (Iterator<Catalog> iteratorCatalog = catalogs.iterator(); iteratorCatalog.hasNext();) {
			Catalog catalog = iteratorCatalog.next();
			CatalogDTO dtoCatalog = CatalogWrapper.getInstance().convert2DTO(catalog);
			List<CatalogProductDTO> dtoCatalogProducts = new ArrayList<CatalogProductDTO>();
			Iterable<CatalogProduct> catalogProducts = catalogProductRepository.findByCatalog(catalog);
			for (Iterator<CatalogProduct> iteratorCatalogProduct = catalogProducts.iterator(); iteratorCatalogProduct.hasNext();) {
				CatalogProduct catalogProduct = iteratorCatalogProduct.next();
				dtoCatalogProducts.add(CatalogProductWrapper.getInstance().convert2DTO(catalogProduct));
			}
			dtoCatalog.setCatalogProducts(dtoCatalogProducts);
			dtoCatalogs.add(dtoCatalog);
		}
		return dtoCatalogs;
	}

	@Override
	public CatalogDTO loadById(int id) {
		return null;
	}

	@Override
	public CatalogDTO loadByName(String name) {
		return null;
	}

	@Override
	public void edit(CatalogDTO dtoCatalog) {
		
	}

	@Override
	public void remove(int id) {
		
	}

	@Override
	public List<CatalogProductDTO> loadAllWeekCatalogProductsByCategory(String categoryName) {
		List<CatalogProductDTO> weekCatalogProducts = new ArrayList<CatalogProductDTO>();
		List<Date> weekDates = DateTimeUtil.getWeekStartNEndDates();
		Iterable<Catalog> catalogs = catalogRepository.findAll();
		for (Iterator<Catalog> iteratorCatalog = catalogs.iterator(); iteratorCatalog.hasNext();) {
			Catalog catalog = iteratorCatalog.next();
			if (catalog.getStartDate().after(weekDates.get(0)) && catalog.getEndDate().before(weekDates.get(1))) {
				Iterable<CatalogProduct> catalogProducts = catalogProductRepository.findByCatalog(catalog);
				for (Iterator<CatalogProduct> iteratorCatalogProduct = catalogProducts.iterator(); iteratorCatalogProduct.hasNext();) {
					CatalogProduct catalogProduct = iteratorCatalogProduct.next();
					if (catalogProduct.getProduct().getCategory().getName().equalsIgnoreCase(categoryName))
						weekCatalogProducts.add(CatalogProductWrapper.getInstance().convert2DTO(catalogProduct));
				}
			}
		}
		return weekCatalogProducts;
	}
}
