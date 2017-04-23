/**
 * 
 */
package com.enuminfo.farm.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table (name = TableType.T_CATALOG)
public class Catalog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Date startDate;
	private Date endDate;
	private Collection<CatalogProduct> catalogProducts;
	
	private Catalog() {}
	
	private Catalog(Builder builder) {
		this.id = builder.id;
		this.startDate = builder.startDate;
		this.endDate = builder.endDate;
		this.catalogProducts = builder.catalogProducts;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	@Column (name = ColumnType.START_DATE)
	public Date getStartDate() {
		return startDate;
	}

	@Column (name = ColumnType.END_DATE)
	public Date getEndDate() {
		return endDate;
	}

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = ColumnType.CATALOG)
	public Collection<CatalogProduct> getCatalogProducts() {
		return catalogProducts;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setCatalogProducts(Collection<CatalogProduct> catalogProducts) {
		this.catalogProducts = catalogProducts;
	}

	public static class Builder {
		
		private Integer id;
		private Date startDate;
		private Date endDate;
		private Collection<CatalogProduct> catalogProducts;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withStartDate(Date startDate) {
			this.startDate = startDate;
			return this;
		}

		public Builder withEndDate(Date endDate) {
			this.endDate = endDate;
			return this;
		}

		public Builder withCatalogProducts(Collection<CatalogProduct> catalogProducts) {
			this.catalogProducts = catalogProducts;
			return this;
		}
		
		public Catalog build() {
			return new Catalog(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
