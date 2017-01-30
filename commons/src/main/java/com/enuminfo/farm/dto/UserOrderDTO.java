/**
 * 
 */
package com.enuminfo.farm.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @author Kumar
 */
public class UserOrderDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int orderId, userId;
	private String userName, emailAddress, mobileNumber;
	private String status;
	private int deliveryLocationId;
	private String landmark1, landmark2, landmark3;
	private String locationName, cityName, stateName, countryName, isdCode;
	private int countryId, locationId;
	private long pinCode;
	private List<UserOrderedItemDTO> dtoOrderedItems;
	
	public UserOrderDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDeliveryLocationId() {
		return deliveryLocationId;
	}

	public void setDeliveryLocationId(int deliveryLocationId) {
		this.deliveryLocationId = deliveryLocationId;
	}

	public String getLandmark1() {
		return landmark1;
	}

	public void setLandmark1(String landmark1) {
		this.landmark1 = landmark1;
	}

	public String getLandmark2() {
		return landmark2;
	}

	public void setLandmark2(String landmark2) {
		this.landmark2 = landmark2;
	}

	public String getLandmark3() {
		return landmark3;
	}

	public void setLandmark3(String landmark3) {
		this.landmark3 = landmark3;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getIsdCode() {
		return isdCode;
	}

	public void setIsdCode(String isdCode) {
		this.isdCode = isdCode;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public long getPinCode() {
		return pinCode;
	}

	public void setPinCode(long pinCode) {
		this.pinCode = pinCode;
	}

	public List<UserOrderedItemDTO> getDtoOrderedItems() {
		return dtoOrderedItems;
	}

	public void setDtoOrderedItems(List<UserOrderedItemDTO> dtoOrderedItems) {
		this.dtoOrderedItems = dtoOrderedItems;
	}
}
