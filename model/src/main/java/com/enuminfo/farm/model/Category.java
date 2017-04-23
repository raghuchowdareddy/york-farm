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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table(name = TableType.T_CATEGORY)
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Collection<Product> products;

	private Category() {
		// TODO Auto-generated constructor stub
	}
	
	private Category(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.products = builder.products;
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

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = ColumnType.CATEGORY)
	public Collection<Product> getProducts() {
		return products;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProducts(Collection<Product> products) {
		this.products = products;
	}

	public static class Builder {
		private Integer id;
		private String name;
		private Collection<Product> products;

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder withProducts(Collection<Product> products) {
			this.products = products;
			return this;
		}

		public Category build() {
			return new Category(this);
		}
	}

	public static Builder getBuilder() {
		return new Builder();
	}
}
