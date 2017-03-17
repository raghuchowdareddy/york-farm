/**
 * 
 */
package com.enuminfo.farm.wrapper;

import com.enuminfo.farm.dto.CatalogDTO;
import com.enuminfo.farm.model.Catalog;
import com.enuminfo.farm.util.DateTimeUtil;

/**
 * @author Kumar
 */
public class CatalogWrapper {

	CatalogWrapper() {
		// TODO Auto-generated constructor stub
	}
	
	public static CatalogWrapper getInstance() {
		return SingletonWrapper.CATALOG_WRAPPER_INSTANCE;
	}
	
	public Catalog convert2ModelWithoutId(CatalogDTO dtoCatalog) {
		Catalog catalog = Catalog.getBuilder()
				.withStartDate(DateTimeUtil.convertString2UtilDate(dtoCatalog.getStartDate()))
				.withEndDate(DateTimeUtil.convertString2UtilDate(dtoCatalog.getEndDate()))
				.build();		
		return catalog;
	}
	
	public CatalogDTO convert2DTO(Catalog catalog) {
		CatalogDTO dtoCatalog = new CatalogDTO();
		dtoCatalog.setCatalogId(catalog.getId());
		dtoCatalog.setStartDate(catalog.getStartDate().toString());
		dtoCatalog.setEndDate(catalog.getEndDate().toString());
		return dtoCatalog;
	}
}
