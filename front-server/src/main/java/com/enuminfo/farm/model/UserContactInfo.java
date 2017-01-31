package com.enuminfo.farm.model;


import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = TableType.T_USER_CONTACT_INFO)

public class UserContactInfo implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long userContactInfo;
	
	private Long contactNumber;
	private String emailId;
	private String name;
	private String flatNumber;
	private String street;
	private String landMark;
	private Integer postalCode;
	private String updateDate;
	private UserOrder userOrder;
	
	@JsonIgnore
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= ColumnType.USER_CONTACT_INFO_ID)
	public Long getUserContactInfo() {
		return userContactInfo;
	}

	public void setUserContactInfo(Long userContactInfo) {
		this.userContactInfo = userContactInfo;
	}
	
	@Column(name = ColumnType.MOBILE_NUMBER)
	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	@Column(name = ColumnType.EMAIL_ID)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Column(name = ColumnType.USERNAME)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = ColumnType.FLAT_NUMBER)
	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}
	@Column(name = ColumnType.STREET)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	@Column(name = ColumnType.LANDMARK)
	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	@Column(name = ColumnType.POSTALCODE)
	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	
	@Column(name = ColumnType.UPDATE_DATE)
	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		if (this.updateDate == null) {
			this.updateDate = sdf.format(new Timestamp(System.currentTimeMillis()));
		}
		this.updateDate = updateDate;
	}
	@JsonBackReference
    @OneToOne(mappedBy="userContactInfo")
	public UserOrder getUserOrder() {
		return userOrder;
	}

	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactNumber == null) ? 0 : contactNumber.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + ((flatNumber == null) ? 0 : flatNumber.hashCode());
		result = prime * result + ((landMark == null) ? 0 : landMark.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((updateDate == null) ? 0 : updateDate.hashCode());
		result = prime * result + ((userContactInfo == null) ? 0 : userContactInfo.hashCode());
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
		UserContactInfo other = (UserContactInfo) obj;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (flatNumber == null) {
			if (other.flatNumber != null)
				return false;
		} else if (!flatNumber.equals(other.flatNumber))
			return false;
		if (landMark == null) {
			if (other.landMark != null)
				return false;
		} else if (!landMark.equals(other.landMark))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (updateDate == null) {
			if (other.updateDate != null)
				return false;
		} else if (!updateDate.equals(other.updateDate))
			return false;
		if (userContactInfo == null) {
			if (other.userContactInfo != null)
				return false;
		} else if (!userContactInfo.equals(other.userContactInfo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserContactInfo [userContactInfo=" + userContactInfo + ", contactNumber=" + contactNumber + ", emailId="
				+ emailId + ", name=" + name + ", flatNumber=" + flatNumber + ", street=" + street + ", landMark="
				+ landMark + ", postalCode=" + postalCode + ", updateDate=" + updateDate + "]";
	}

	

}
