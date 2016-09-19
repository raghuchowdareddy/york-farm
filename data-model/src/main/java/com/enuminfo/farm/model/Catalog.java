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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table(name = TableType.T_CATALOG)
public class Catalog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Collection<Product> products;
	private Date startDate;
	private Date endDate;

	private Catalog(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.products = builder.products;
		this.startDate = builder.startDate;
		this.endDate = builder.endDate;
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = TableType.T_CATALOG_PRODUCT, joinColumns = {
			@JoinColumn(name = ColumnType.CATALOG_ID) }, inverseJoinColumns = {
					@JoinColumn(name = ColumnType.PRODUCT_ID) })
	public Collection<Product> getProducts() {
		return products;
	}
	
	@Column (name = ColumnType.START_DATE)
	public Date getStartDate() {
		return startDate;
	}

	@Column (name = ColumnType.END_DATE)
	public Date getEndDate() {
		return endDate;
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

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public static class Builder {
		private Integer id;
		private String name;
		private Collection<Product> products;
		private Date startDate;
		private Date endDate;

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
		
		public Builder withStartDate(Date startDate) {
			this.startDate = startDate;
			return this;
		}

		public Builder withEndDate(Date endDate) {
			this.endDate = endDate;
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
