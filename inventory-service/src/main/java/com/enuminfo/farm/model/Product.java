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
@Table(name = TableType.T_PRODUCT)
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name, description;
	private Double price;
	private Boolean stock;
	private Category category;

	private Product() {
		// TODO Auto-generated constructor stub
	}
	
	private Product(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.description = builder.description;
		this.price = builder.price;
		this.stock = builder.stock;
		this.category = builder.category;
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

	@Column(name = ColumnType.PRICE)
	public Double getPrice() {
		return price;
	}

	@Column(name = ColumnType.IS_STOCK)
	public Boolean getStock() {
		return stock;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = ColumnType.CATEGORY_ID)
	public Category getCategory() {
		return category;
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

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setStock(Boolean stock) {
		this.stock = stock;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static class Builder {
		private Integer id;
		private String name, description;
		private Double price;
		private Boolean stock;
		private Category category;

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

		public Builder withPrice(Double price) {
			this.price = price;
			return this;
		}

		public Builder withStock(Boolean stock) {
			this.stock = stock;
			return this;
		}

		public Builder withCategory(Category category) {
			this.category = category;
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
