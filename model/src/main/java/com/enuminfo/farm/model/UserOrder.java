/**
 * 
 */
package com.enuminfo.farm.model;

import java.io.Serializable;
import java.sql.Timestamp;
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
	private Collection<UserOrderDeliveryLocation> deliveryLocations;
	private Timestamp createdDate;
	private Timestamp updatedDate;
	private Timestamp deliveryDate;
	
	private UserOrder() {}
	
	private UserOrder(Builder builder) {
		this.id = builder.id;
		this.user = builder.user;
		this.orderedItems = builder.orderedItems;
		this.status = builder.status;
		this.deliveryLocations = builder.deliveryLocations;
		this.createdDate = builder.createdDate;
		this.updatedDate = builder.updatedDate;
		this.deliveryDate = builder.deliveryDate;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getId() {
		return id;
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

	@OneToMany (cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = ColumnType.USER_ORDER)
	public Collection<UserOrderDeliveryLocation> getDeliveryLocations() {
		return deliveryLocations;
	}

	@Column (name = ColumnType.CREATED_DATE)
	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	@Column (name = ColumnType.UPDATED_DATE)
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column (name = ColumnType.DELIVERY_DATE)
	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public void setDeliveryLocations(Collection<UserOrderDeliveryLocation> deliveryLocations) {
		this.deliveryLocations = deliveryLocations;
	}

	public void setId(Integer id) {
		this.id = id;
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
		
		private Integer id;
		private UserDetail user;
		private Collection<UserOrderedItem> orderedItems;
		private String status;
		private Collection<UserOrderDeliveryLocation> deliveryLocations;
		private Timestamp createdDate;
		private Timestamp updatedDate;
		private Timestamp deliveryDate;
		
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
		
		public Builder withDeliveryLocations(Collection<UserOrderDeliveryLocation> deliveryLocations) {
			this.deliveryLocations = deliveryLocations;
			return this;
		}
		
		public Builder withCreatedDate(Timestamp createdDate) {
			this.createdDate = createdDate;
			return this;
		}
		
		public Builder withUpdatedDate(Timestamp updatedDate) {
			this.updatedDate = updatedDate;
			return this;
		}
		
		public Builder withDeliveryDate(Timestamp deliveryDate) {
			this.deliveryDate = deliveryDate;
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