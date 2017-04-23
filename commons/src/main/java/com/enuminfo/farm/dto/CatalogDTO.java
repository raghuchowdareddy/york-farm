/**
 * 
 */
package com.enuminfo.farm.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Kumar
 */
public class CatalogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int catalogId;
	private List<CatalogProductDTO> catalogProducts;
	private String startDate, endDate;
	
	public CatalogDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	public List<CatalogProductDTO> getCatalogProducts() {
		return catalogProducts;
	}

	public void setCatalogProducts(List<CatalogProductDTO> catalogProducts) {
		this.catalogProducts = catalogProducts;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
