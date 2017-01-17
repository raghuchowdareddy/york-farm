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

@Entity(name = "userSelectedItem")
@Table(name = TableType.T_USER_SELECTED_ITEM)

public class UserSelectedItem {

	private Long userMobileNo;
	private String itemName;
	private int price;
	private String desscription;
	private String imageName;
	private int quantity;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	private LocalDateTime deliveredDate;
	private String status;

	private int userSelectedItemId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ColumnType.USER_SELECTED_ITEM_ID)
	public int getUserSelectedItemId() {
		return userSelectedItemId;
	}

	public void setUserSelectedItemId(int userSelectedItemId) {
		this.userSelectedItemId = userSelectedItemId;
	}

	@Column(name = ColumnType.USER_MOBILE_NO)
	public Long getUserMobileNo() {
		return userMobileNo;
	}

	public void setUserMobileNo(Long userMobileNo) {
		this.userMobileNo = userMobileNo;
	}

	@Column(name = ColumnType.ITEM_NAME)
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = ColumnType.PRICE)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Column(name = ColumnType.DESCRIPTION)
	public String getDesscription() {
		return desscription;
	}

	public void setDesscription(String desscription) {
		this.desscription = desscription;
	}

	@Column(name = ColumnType.IMAGE_NAME)
	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Column(name = ColumnType.QUANTITY)
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = ColumnType.CREATED_DATE)
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		if (createdDate == null) {
			this.createdDate = LocalDateTime.now();
		} else {
			this.createdDate = createdDate;
		}
	}

	@Column(name = ColumnType.UPDATED_DATE)
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = ColumnType.DELIVERED_DATE)
	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	@Column(name = ColumnType.STATUS)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserSelectedItem [userMobileNo=" + userMobileNo + ", itemName=" + itemName + ", costPerKg=" + price
				+ ", desscription=" + desscription + ", quantity=" + quantity + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + ", deliveredDate=" + deliveredDate + ", status=" + status
				+ ", userSelectedItemId=" + userSelectedItemId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((deliveredDate == null) ? 0 : deliveredDate.hashCode());
		result = prime * result + ((desscription == null) ? 0 : desscription.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updatedDate == null) ? 0 : updatedDate.hashCode());
		result = prime * result + ((userMobileNo == null) ? 0 : userMobileNo.hashCode());
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
		if (price != other.price)
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
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (quantity != other.quantity)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (updatedDate == null) {
			if (other.updatedDate != null)
				return false;
		} else if (!updatedDate.equals(other.updatedDate))
			return false;
		if (userMobileNo == null) {
			if (other.userMobileNo != null)
				return false;
		} else if (!userMobileNo.equals(other.userMobileNo))
			return false;
		if (userSelectedItemId != other.userSelectedItemId)
			return false;
		return true;
	}

}
