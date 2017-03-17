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
	private Integer userOrderId;
	private UserDetail user;
	private Collection<UserOrderedItem> orderedItems;
	private String status;
	private Collection<UserOrderDeliveryLocation> deliveryLocations;
	
	private UserOrder() {}
	
	private UserOrder(Builder builder) {
		this.userOrderId = builder.userOrderId;
		this.user = builder.user;
		this.orderedItems = builder.orderedItems;
		this.status = builder.status;
		this.deliveryLocations = builder.deliveryLocations;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getUserOrderId() {
		return userOrderId;
	}

	@ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.USER_ID)
	public UserDetail getUser() {
		return user;
	}

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = ColumnType.USER_ORDER)
	public Collection<UserOrderedItem> getOrderedItems() {
		return orderedItems;
	}

	@Column (name = ColumnType.STATUS)
	public String getStatus() {
		return status;
	}

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = ColumnType.USER_ORDER)
	public Collection<UserOrderDeliveryLocation> getDeliveryLocations() {
		return deliveryLocations;
	}

	public void setDeliveryLocations(Collection<UserOrderDeliveryLocation> deliveryLocations) {
		this.deliveryLocations = deliveryLocations;
	}

	public void setUserOrderId(Integer userOrderId) {
		this.userOrderId = userOrderId;
	}

	public void setUser(UserDetail user) {
		this.user = user;
	}

	public void setOrderedItems(Collection<UserOrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public static class Builder {
		
		private Integer userOrderId;
		private UserDetail user;
		private Collection<UserOrderedItem> orderedItems;
		private String status;
		private Collection<UserOrderDeliveryLocation> deliveryLocations;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder withUserOrderId(Integer userOrderId) {
			this.userOrderId = userOrderId;
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
		
		public Builder withDeliveryLocations(Collection<UserOrderDeliveryLocation> deliveryLocations) {
			this.deliveryLocations = deliveryLocations;
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