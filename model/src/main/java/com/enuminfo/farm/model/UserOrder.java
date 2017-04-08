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
	private String deliveryStatus;
	private Collection<UserOrderDeliveryLocation> deliveryLocations;
	private Date draftedDate;
	private Date orderedDate;
	private Date cancelledDate;
	
	private UserOrder() {}
	
	private UserOrder(Builder builder) {
		this.id = builder.id;
		this.user = builder.user;
		this.orderedItems = builder.orderedItems;
		this.status = builder.status;
		this.deliveryStatus = builder.deliveryStatus;
		this.deliveryLocations = builder.deliveryLocations;
		this.draftedDate = builder.draftedDate;
		this.orderedDate = builder.orderedDate;
		this.cancelledDate = builder.cancelledDate;
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
	
	@Column (name = ColumnType.DELIVERY_STATUS)
	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	@OneToMany (cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = ColumnType.USER_ORDER)
	public Collection<UserOrderDeliveryLocation> getDeliveryLocations() {
		return deliveryLocations;
	}

	@Column (name = ColumnType.DRAFTED_DATE)
	public Date getDraftedDate() {
		return draftedDate;
	}

	public void setDraftedDate(Date draftedDate) {
		this.draftedDate = draftedDate;
	}

	@Column (name = ColumnType.ORDERED_DATE)
	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Column (name = ColumnType.CANCELLED_DATE)
	public Date getCancelledDate() {
		return cancelledDate;
	}

	public void setCancelledDate(Date cancelledDate) {
		this.cancelledDate = cancelledDate;
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
	
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public static class Builder {
		
		private Integer id;
		private UserDetail user;
		private Collection<UserOrderedItem> orderedItems;
		private String status;
		private String deliveryStatus;
		private Collection<UserOrderDeliveryLocation> deliveryLocations;
		private Date draftedDate;
		private Date orderedDate;
		private Date cancelledDate;
		
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
		
		public Builder withDeliveryStatus(String deliveryStatus) {
			this.deliveryStatus = deliveryStatus;
			return this;
		}
		
		public Builder withDeliveryLocations(Collection<UserOrderDeliveryLocation> deliveryLocations) {
			this.deliveryLocations = deliveryLocations;
			return this;
		}
		
		public Builder withDraftedDate(Date draftedDate) {
			this.draftedDate = draftedDate;
			return this;
		}
		
		public Builder withOrderedDate(Date orderedDate) {
			this.orderedDate = orderedDate;
			return this;
		}
		
		public Builder withCancelledDate(Date cancelledDate) {
			this.cancelledDate = cancelledDate;
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