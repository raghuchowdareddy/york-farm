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
@Table (name = TableType.T_USER_ORDER)
public class UserOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UserDetail user;
	private Collection<UserOrderedItem> orderedItems;
	private String status;
	
	private UserOrder() {}
	
	private UserOrder(Builder builder) {
		this.id = builder.id;
		this.user = builder.user;
		this.orderedItems = builder.orderedItems;
		this.status = builder.status;
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

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.USER_ID)
	public UserDetail getUser() {
		return user;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = ColumnType.USER_ORDERED_ITEMS)
	public Collection<UserOrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(Collection<UserOrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	@Column (name = ColumnType.STATUS)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public static class Builder {
		
		private Integer id;
		private UserDetail user;
		private Collection<UserOrderedItem> orderedItems;
		private String status;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withUser(UserDetail user) {
			this.user = user;
			return this;
		}

		public Builder withOrderedItems(Collection<UserOrderedItem> orderedItems) {
			this.orderedItems = orderedItems;
			return this;
		}

		public Builder withStatus(String status) {
			this.status = status;
			return this;
		}
		
		public UserOrder build() {
			return new UserOrder(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
