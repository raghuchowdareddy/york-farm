/**
 * 
 */
package com.enuminfo.farm.dto;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author Kumar
 */
public class CatalogDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int catalogId;
	private String catalogName;
	private Collection<ProductDTO> dtoProducts;
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

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public Collection<ProductDTO> getDtoProducts() {
		return dtoProducts;
	}

	public void setDtoProducts(Collection<ProductDTO> dtoProducts) {
		this.dtoProducts = dtoProducts;
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
