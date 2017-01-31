package com.enuminfo.farm.model;


import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="userSelectItem")
@Table(name = TableType.T_USER_SELECT_ITEM)

public class UserSelectItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int userSelectItemId;
	private Long userMobileNo;
	private String itemName;
	private int price;
	private String desscription;
	private String imageName;
	private int quantity;
	private String createDate;
	private String updateDate;
	private String deliveryDate;
	private String status;
	private UserOrder userOrder;
	
	
	@JsonIgnore
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ColumnType.USER_SELECTE_ITEM_ID)
	public int getUserSelectItemId() {
		return userSelectItemId;
	}

	public void setUserSelectItemId(int userSelectItemId) {
		this.userSelectItemId = userSelectItemId;
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

	@Column(name = ColumnType.CREATE_DATE)
	public String getCreateDate() {
		if (this.createDate == null) {
			this.createDate = sdf.format(new Timestamp(System.currentTimeMillis()));
		}
		return createDate;
	}

	public void setCreateDate(String createDate) {
		if (createDate == null) {
			this.createDate = sdf.format(new Timestamp(System.currentTimeMillis()));
		} else {
			this.createDate = createDate;
		}
	}

	@Column(name = ColumnType.UPDATE_DATE)
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = ColumnType.DELIVERY_DATE)
	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	@Column(name = ColumnType.STATUS)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    @JsonBackReference
	@ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY,optional=true)
    @JoinColumn(name="USER_ORDER_ID")
	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	@Override
	public String toString() {
		return "UserSelectedItem [userMobileNo=" + userMobileNo + ", itemName=" + itemName + ", costPerKg=" + price
				+ ", desscription=" + desscription + ", quantity=" + quantity + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", deliveryDate=" + deliveryDate + ", status=" + status
				+ ", userSelectItemId=" + userSelectItemId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + price;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((deliveryDate == null) ? 0 : deliveryDate.hashCode());
		result = prime * result + ((desscription == null) ? 0 : desscription.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + quantity;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((userMobileNo == null) ? 0 : userMobileNo.hashCode());
		result = prime * result + userSelectItemId;
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
		UserSelectItem other = (UserSelectItem) obj;
		if (price != other.price)
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (deliveryDate == null) {
			if (other.deliveryDate != null)
				return false;
		} else if (!deliveryDate.equals(other.deliveryDate))
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
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		if (userMobileNo == null) {
			if (other.userMobileNo != null)
				return false;
		} else if (!userMobileNo.equals(other.userMobileNo))
			return false;
		if (userSelectItemId != other.userSelectItemId)
			return false;
		return true;
	}

}
