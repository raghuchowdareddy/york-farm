/**
 * 
 */
package com.enuminfo.farm.dto;

import java.io.Serializable;

/**
 * @author Kumar
 */
public class UserOrderedItemDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userOrderItemId;
	private String productName, description, categoryName, imageName;
	private int productId, categoryId;
	private double quantity, price;
	
	public UserOrderedItemDTO() {
		
	}

	public int getUserOrderItemId() {
		return userOrderItemId;
	}

	public void setUserOrderItemId(int userOrderItemId) {
		this.userOrderItemId = userOrderItemId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
