package com.enuminfo.farm.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name=TableType.T_USER_ORDER)
public class UserOrder implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer userOrderId;
	private List<UserSelectItem> items;
	private UserContactInfo userContactInfo;
	private Double price;
	private Integer quantity;
	private String status;
	private String orderDate;
	@JsonIgnore private String deliveryDate;
	private String userName;
	@JsonIgnore
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name=ColumnType.USER_ORDER_ID)
	public Integer getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(Integer userOrderId) {
		this.userOrderId = userOrderId;
	}
	@OneToMany(mappedBy= "userOrder",cascade=CascadeType.ALL,orphanRemoval=true,fetch=FetchType.EAGER)
	public List<UserSelectItem> getItems() {
		return items;
	}
	public void setItems(List<UserSelectItem> items) {
		this.items = items;
	}
	
	@OneToOne(cascade=CascadeType.ALL,optional=true,orphanRemoval=true,fetch=FetchType.EAGER)
	public UserContactInfo getUserContactInfo() {
		return userContactInfo;
	}
	public void setUserContactInfo(UserContactInfo userContactInfo) {
		this.userContactInfo = userContactInfo;
	}
	@Column(name=ColumnType.STATUS)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Column(name=ColumnType.ORDER_PRICE)
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Column(name=ColumnType.ORDER_QUANTITY)
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Column(name=ColumnType.ORDER_DATE)
	public String getOrderDate() {
		if(orderDate==null || "".equals(orderDate)){
			this.orderDate = sdf.format(new Timestamp(System.currentTimeMillis()));
		}
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		if(orderDate==null || "".equals(orderDate)){
			this.orderDate = sdf.format(new Timestamp(System.currentTimeMillis()));
		}
		this.orderDate = orderDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Column(name=ColumnType.USERNAME)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((items == null) ? 0 : items.hashCode());
		result = prime * result + ((userContactInfo == null) ? 0 : userContactInfo.hashCode());
		result = prime * result + ((userOrderId == null) ? 0 : userOrderId.hashCode());
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
		UserOrder other = (UserOrder) obj;
		if (items == null) {
			if (other.items != null)
				return false;
		} else if (!items.equals(other.items))
			return false;
		if (userContactInfo == null) {
			if (other.userContactInfo != null)
				return false;
		} else if (!userContactInfo.equals(other.userContactInfo))
			return false;
		if (userOrderId == null) {
			if (other.userOrderId != null)
				return false;
		} else if (!userOrderId.equals(other.userOrderId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserOrder [userOrderId=" + userOrderId + ", items=" + items + ", userContactInfo=" + userContactInfo
				+ "]";
	}
	
	
	
	
}
