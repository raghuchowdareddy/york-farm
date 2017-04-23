/**
 * 
 */
package com.enuminfo.farm.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table(name = TableType.T_PRODUCT)
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name, description;
	private Category category;
	private Collection<CatalogProduct> catalogProducts;

	private Product() {
		// TODO Auto-generated constructor stub
	}
	
	private Product(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.category = builder.category;
		this.catalogProducts = builder.catalogProducts;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	@Column(name = ColumnType.NAME)
	public String getName() {
		return name;
	}

	@Column(name = ColumnType.DESCRIPTION)
	public String getDescription() {
		return description;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = ColumnType.CATEGORY_ID)
	public Category getCategory() {
		return category;
	}

	@OneToMany (cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = ColumnType.PRODUCT)
	public Collection<CatalogProduct> getCatalogProducts() {
		return catalogProducts;
	}

	public void setCatalogProducts(Collection<CatalogProduct> catalogProducts) {
		this.catalogProducts = catalogProducts;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static class Builder {
		private Integer id;
		private String name, description;
		private Category category;
		private Collection<CatalogProduct> catalogProducts;

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Builder withCategory(Category category) {
			this.category = category;
			return this;
		}
		
		public Builder withCatalogProducts(Collection<CatalogProduct> catalogProducts) {
			this.catalogProducts = catalogProducts;
			return this;
		}

		public Product build() {
			return new Product(this);
		}
	}

	public static Builder getBuilder() {
		return new Builder();
	}
}
