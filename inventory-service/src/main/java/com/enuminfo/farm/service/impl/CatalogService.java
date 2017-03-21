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
import com.enuminfo.farm.model.Catalog;
import com.enuminfo.farm.model.CatalogProduct;
import com.enuminfo.farm.model.UserOrderedItem;
import com.enuminfo.farm.repository.ICatalogProductRepository;
import com.enuminfo.farm.repository.ICatalogRepository;
import com.enuminfo.farm.repository.IProductRepository;
import com.enuminfo.farm.repository.IUserOrderedItemRepository;
import com.enuminfo.farm.service.ICatalogService;
import com.enuminfo.farm.util.DateTimeUtil;

/**
 * @author Kumar
 */
@Service
public class CatalogService implements ICatalogService {

	@Autowired ICatalogRepository catalogRepository;
	@Autowired ICatalogProductRepository catalogProductRepository;
	@Autowired IProductRepository productRepository;
	@Autowired IUserOrderedItemRepository userOrderedItemRepository;
	
	@Override
	public void add(CatalogDTO dtoCatalog) {
		Catalog catalog = Catalog.getBuilder()
				.withStartDate(DateTimeUtil.convertString2UtilDate(dtoCatalog.getStartDate()))
				.withEndDate(DateTimeUtil.convertString2UtilDate(dtoCatalog.getEndDate()))
				.build();
		Catalog savedCatalog = catalogRepository.save(catalog);
		for (Iterator<CatalogProductDTO> iterator = dtoCatalog.getCatalogProducts().iterator(); iterator.hasNext();) {
			CatalogProductDTO dtoCatalogProduct = iterator.next();
			CatalogProduct catalogProduct = CatalogProduct.getBuilder()
					.withId(dtoCatalogProduct.getCatalogProductId())
					.withCatalog(savedCatalog)
					.withProduct(productRepository.findOne(dtoCatalogProduct.getProductId()))
					.withQuantity(dtoCatalogProduct.getQuantity())
					.withPrice(dtoCatalogProduct.getPrice())
					.build();
			catalogProductRepository.save(catalogProduct);
		}
	}

	@Override
	public List<CatalogDTO> loadAll() {
		List<CatalogDTO> dtoCatalogs = new ArrayList<CatalogDTO>();
		Iterable<Catalog> catalogs = catalogRepository.findAll();
		for (Iterator<Catalog> iteratorCatalog = catalogs.iterator(); iteratorCatalog.hasNext();) {
			Catalog catalog = iteratorCatalog.next();
			CatalogDTO dtoCatalog = convert2DTO(catalog);
			List<CatalogProductDTO> dtoCatalogProducts = new ArrayList<CatalogProductDTO>();
			Iterable<CatalogProduct> catalogProducts = catalogProductRepository.findByCatalog(catalog);
			for (Iterator<CatalogProduct> iteratorCatalogProduct = catalogProducts.iterator(); iteratorCatalogProduct.hasNext();) {
				CatalogProduct catalogProduct = iteratorCatalogProduct.next();
				dtoCatalogProducts.add(convert2DTO(catalogProduct));
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
					if (catalogProduct.getProduct().getCategory().getName().equalsIgnoreCase(categoryName)) {
						CatalogProductDTO dtoCatalogProduct = convert2DTO(catalogProduct);
						double selectedProductQuantity = dtoCatalogProduct.getQuantity();
						Iterable<UserOrderedItem> orderedItems = userOrderedItemRepository.findByProduct(catalogProduct.getProduct());
						for (Iterator<UserOrderedItem> iterator = orderedItems.iterator(); iterator.hasNext();) {
							UserOrderedItem orderedItem = iterator.next();
							selectedProductQuantity = selectedProductQuantity - orderedItem.getQuantity();
						}
						dtoCatalogProduct.setQuantity(selectedProductQuantity);
						weekCatalogProducts.add(dtoCatalogProduct);
					}
				}
			}
		}
		return weekCatalogProducts;
	}
	
	private CatalogDTO convert2DTO(Catalog catalog) {
		CatalogDTO dtoCatalog = new CatalogDTO();
		dtoCatalog.setCatalogId(catalog.getId());
		dtoCatalog.setStartDate(catalog.getStartDate().toString());
		dtoCatalog.setEndDate(catalog.getEndDate().toString());
		return dtoCatalog;
	}
	
	private CatalogProductDTO convert2DTO(CatalogProduct catalogProduct) {
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
