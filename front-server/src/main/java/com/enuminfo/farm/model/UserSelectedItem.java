package com.enuminfo.farm.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity(name="userSelectedItem")
@Table(name = TableType.T_USER_SELECTED_ITEM)

public class UserSelectedItem {
	
	private long userMobileNo;
	private String itemName;
	private int costPerKg;
	private String desscription;
	private int quantity;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private LocalDateTime deliveredDate;
	@JsonProperty
	private Boolean isDrafted = new Boolean(false);
	@JsonProperty
	private Boolean isOrdered = new Boolean(false);
	@JsonProperty
	private Boolean isDelivered = new Boolean(false);
	@JsonProperty
	private Boolean isOrderCanceled = new Boolean(false);;
	
	private int userSelectedItemId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=ColumnType.USER_SELECTED_ITEM_ID)
	public int getUserSelectedItemId() {
		return userSelectedItemId;
	}
	
	public void setUserSelectedItemId(int userSelectedItemId) {
		this.userSelectedItemId = userSelectedItemId;
	}
	
	@Column(name=ColumnType.USER_MOBILE_NO)
	public long getUserMobileNo() {
		return userMobileNo;
	}
	public void setUserMobileNo(long userMobileNo) {
		this.userMobileNo = userMobileNo;
	}
	
	@Column(name=ColumnType.ITEM_NAME)
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	@Column(name=ColumnType.COST_PER_KG)
	public int getCostPerKg() {
		return costPerKg;
	}
	public void setCostPerKg(int costPerKg) {
		this.costPerKg = costPerKg;
	}
	
	@Column(name=ColumnType.DESCRIPTION)
	public String getDesscription() {
		return desscription;
	}
	public void setDesscription(String desscription) {
		this.desscription = desscription;
	}
	
	@Column(name=ColumnType.QUANTITY)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name=ColumnType.CREATED_DATE)
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		if(createdDate == null){
			this.createdDate =  LocalDateTime.now();
		}else{
			this.createdDate = createdDate;
		}
	}
	
	@Column(name=ColumnType.UPDATED_DATE)
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	@Column(name=ColumnType.DELIVERED_DATE)
	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}
	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}
	
	@Column(name=ColumnType.DRAFETED)
	public Boolean isDrafted() {
		return isDrafted;
	}
	public void setDrafted(Boolean isDrafted) {
		this.isDrafted = isDrafted;
	}
	
	@Column(name=ColumnType.ORDERED)
	public Boolean isOrdered() {
		return isOrdered;
	}
	public void setOrdered(Boolean isOrdered) {
		this.isOrdered = isOrdered;
	}
	
	@Column(name=ColumnType.DELIVERED)
	public Boolean isDelivered() {
		return isDelivered;
	}
	public void setDelivered(Boolean isDelivered) {
		this.isDelivered = isDelivered;
	}
	
	@Column(name=ColumnType.ORDER_CANCELED)
	public Boolean isOrderCanceled() {
		return isOrderCanceled;
	}
	public void setOrderCanceled(Boolean isOrderCanceled) {
		this.isOrderCanceled = isOrderCanceled;
	}

	

	@Override
	public String toString() {
		return "UserSelectedItem [userMobileNo=" + userMobileNo + ", itemName=" + itemName + ", costPerKg=" + costPerKg
				+ ", desscription=" + desscription + ", quantity=" + quantity + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", deliveredDate=" + deliveredDate + ", isDrafted=" + isDrafted
				+ ", isOrdered=" + isOrdered + ", isDelivered=" + isDelivered + ", isOrderCanceled=" + isOrderCanceled
				+ ", userSelectedItemId=" + userSelectedItemId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + costPerKg;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((deliveredDate == null) ? 0 : deliveredDate.hashCode());
		result = prime * result + ((desscription == null) ? 0 : desscription.hashCode());
		result = prime * result + (isDelivered ? 1231 : 1237);
		result = prime * result + (isDrafted ? 1231 : 1237);
		result = prime * result + (isOrderCanceled ? 1231 : 1237);
		result = prime * result + (isOrdered ? 1231 : 1237);
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + (int) (userMobileNo ^ (userMobileNo >>> 32));
		result = prime * result + userSelectedItemId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserSelectedItem other = (UserSelectedItem) obj;
		if (costPerKg != other.costPerKg)
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (deliveredDate == null) {
			if (other.deliveredDate != null)
				return false;
		} else if (!deliveredDate.equals(other.deliveredDate))
			return false;
		if (desscription == null) {
			if (other.desscription != null)
				return false;
		} else if (!desscription.equals(other.desscription))
			return false;
		if (isDelivered != other.isDelivered)
			return false;
		if (isDrafted != other.isDrafted)
			return false;
		if (isOrderCanceled != other.isOrderCanceled)
			return false;
		if (isOrdered != other.isOrdered)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (userMobileNo != other.userMobileNo)
			return false;
		if (userSelectedItemId != other.userSelectedItemId)
			return false;
		return true;
	}
	
}
