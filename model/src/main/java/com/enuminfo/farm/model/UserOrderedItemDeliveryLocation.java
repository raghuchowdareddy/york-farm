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
@Table (name = TableType.T_ORDERED_DELIVERY_LOCATION)
public class UserOrderedItemDeliveryLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UserOrderedItem userOrderedItem;
	private DeliveryLocation deliveryLocation;
	
	private UserOrderedItemDeliveryLocation() {}
	
	private UserOrderedItemDeliveryLocation(Builder builder) {
		this.id = builder.id;
		this.userOrderedItem = builder.userOrderedItem;
		this.deliveryLocation = builder.deliveryLocation;
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
	public UserOrderedItem getUserOrderedItem() {
		return userOrderedItem;
	}

	public void setUserOrderedItem(UserOrderedItem userOrderedItem) {
		this.userOrderedItem = userOrderedItem;
	}

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = ColumnType.DELIVERY_LOCATION_ID)
	public DeliveryLocation getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setDeliveryLocation(DeliveryLocation deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	
	public static class Builder {
		
		private Integer id;
		private UserOrderedItem userOrderedItem;
		private DeliveryLocation deliveryLocation;
		
		private Builder() {}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withUserOrderedItem(UserOrderedItem userOrderedItem) {
			this.userOrderedItem = userOrderedItem;
			return this;
		}

		public Builder withDeliveryLocation(DeliveryLocation deliveryLocation) {
			this.deliveryLocation = deliveryLocation;
			return this;
		}
		
		public UserOrderedItemDeliveryLocation build() {
			return new UserOrderedItemDeliveryLocation(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
