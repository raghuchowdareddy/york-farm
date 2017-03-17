/**
 * 
 */
package com.enuminfo.farm.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table (name = TableType.T_CATALOG_PRODUCT)
public class CatalogProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Catalog catalog;
	private Product product;
	private Double quantity;
	private Double price;
	
	private CatalogProduct() {}
	
	private CatalogProduct(Builder builder) {
		this.id = builder.id;
		this.catalog = builder.catalog;
		this.product = builder.product;
		this.quantity = builder.quantity;
		this.price = builder.price;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	@ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.PRODUCT_ID)
	public Product getProduct() {
		return product;
	}

	@JoinColumn (name = ColumnType.QUANTITY)
	public Double getQuantity() {
		return quantity;
	}

	@JoinColumn (name = ColumnType.PRICE)
	public Double getPrice() {
		return price;
	}
	
	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = ColumnType.CATALOG_ID)
	public Catalog getCatalog() {
		return catalog;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCatalog(Catalog catalog) {
		this.catalog = catalog;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public static class Builder {
		
		private Integer id;
		private Catalog catalog;
		private Product product;
		private Double quantity;
		private Double price;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder withCatalog(Catalog catalog) {
			this.catalog = catalog;
			return this;
		}

		public Builder withProduct(Product product) {
			this.product = product;
			return this;
		}

		public Builder withQuantity(Double quantity) {
			this.quantity = quantity;
			return this;
		}

		public Builder withPrice(Double price) {
			this.price = price;
			return this;
		}
		
		public CatalogProduct build() {
			return new CatalogProduct(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
