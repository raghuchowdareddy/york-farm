/**
 * 
 */
package com.enuminfo.farm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enuminfo.farm.dto.CatalogDTO;
import com.enuminfo.farm.dto.CatalogProductDTO;
import com.enuminfo.farm.path.RequestPath;
import com.enuminfo.farm.service.ICatalogService;

/**
 * @author Kumar
 */
@RestController
@RequestMapping(value = RequestPath.CATALOG)
public class CatalogController {

	@Autowired ICatalogService catalogService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogDTO> handleInternalRequestForAll() {
		return catalogService.loadAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void handleInternalRequestForSave(@RequestBody CatalogDTO dtoCatalog) {
		if (dtoCatalog.getCatalogId() == 0) catalogService.add(dtoCatalog);
		else catalogService.edit(dtoCatalog);
	}
	
	@RequestMapping(value = RequestPath.WEEKLY + RequestPath.CATEGORY + RequestPath.NAME, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogProductDTO> handleInternalRequestForWeeklyCatalogProduct(@PathVariable String name) {
		return catalogService.loadAllWeekCatalogProductsByCategory(name);
	}
}
