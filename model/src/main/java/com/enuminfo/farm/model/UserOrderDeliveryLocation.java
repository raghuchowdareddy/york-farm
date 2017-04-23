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
@Table(name = TableType.T_USER_ORDER_DELIVERY_LOCATION)
public class UserOrderDeliveryLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private UserOrder userOrder;
	private DeliveryLocation deliveryLocation;
	
	private UserOrderDeliveryLocation () {}
	
	private UserOrderDeliveryLocation (Builder builder) {
		this.id = builder.id;
		this.userOrder = builder.userOrder;
		this.deliveryLocation = builder.deliveryLocation;
	}
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	@ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.USER_ORDER_ID)
	public UserOrder getUserOrder() {
		return userOrder;
	}

	@ManyToOne (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.DELIVERY_LOCATION_ID)
	public DeliveryLocation getDeliveryLocation() {
		return deliveryLocation;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	public void setDeliveryLocation(DeliveryLocation deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}

	public static class Builder {
		
		private Integer id;
		private UserOrder userOrder;
		private DeliveryLocation deliveryLocation;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withUserOrder(UserOrder userOrder) {
			this.userOrder = userOrder;
			return this;
		}

		public Builder withDeliveryLocation(DeliveryLocation deliveryLocation) {
			this.deliveryLocation = deliveryLocation;
			return this;
		}
		
		public UserOrderDeliveryLocation build() {
			return new UserOrderDeliveryLocation(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
