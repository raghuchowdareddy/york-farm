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
@Table (name = TableType.T_USER_ORDERED_ITEM)
public class UserOrderedItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UserOrder order;
	private Product product;
	private Integer quantity;
	
	private UserOrderedItem() {}
	
	private UserOrderedItem(Builder builder) {
		this.id = builder.id;
		this.order = builder.order;
		this.product = builder.product;
		this.quantity = builder.quantity;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = ColumnType.USER_ORDER_ID)
	public UserOrder getOrder() {
		return order;
	}

	public void setOrder(UserOrder order) {
		this.order = order;
	}

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.PRODUCT_ID)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column (name = ColumnType.QUANTITY)
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public static class Builder {
		
		private Integer id;
		private UserOrder order;
		private Product product;
		private Integer quantity;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withUser(UserOrder order) {
			this.order = order;
			return this;
		}

		public Builder withProduct(Product product) {
			this.product = product;
			return this;
		}

		public Builder withQuantity(Integer quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public UserOrderedItem build() {
			return new UserOrderedItem(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
