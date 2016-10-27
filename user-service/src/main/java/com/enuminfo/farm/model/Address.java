/**
 * 
 */
package com.enuminfo.farm.model;

import java.io.Serializable;
import java.util.Collection;

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
@Table(name = TableType.T_ADDRESS)
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String houseNo, street, landmark;
	private Location location;
	private Collection<User> users;

	private Address() {}
	
	private Address(Builder builder) {
		this.id = builder.id;
		this.houseNo = builder.houseNo;
		this.street = builder.street;
		this.landmark = builder.landmark;
		this.location = builder.location;
		this.users = builder.users;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	@Column(name = ColumnType.VALUE_1)
	public String getHouseNo() {
		return houseNo;
	}

	@Column(name = ColumnType.VALUE_2)
	public String getStreet() {
		return street;
	}

	@Column(name = ColumnType.VALUE_3)
	public String getLandmark() {
		return landmark;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = ColumnType.LOCATION_ID)
	public Location getLocation() {
		return location;
	}

	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = ColumnType.ADDRESS)
	public Collection<User> getUsers() {
		return users;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public static class Builder {
		private Integer id;
		private String houseNo, street, landmark;
		private Location location;
		private Collection<User> users;

		private Builder() {}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withHouseNo(String houseNo) {
			this.houseNo = houseNo;
			return this;
		}

		public Builder withStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder withLandmark(String landmark) {
			this.landmark = landmark;
			return this;
		}

		public Builder withLocation(Location location) {
			this.location = location;
			return this;
		}
		
		public Builder withUsers(Collection<User> users) {
			this.users = users;
			return this;
		}

		public Address build() {
			return new Address(this);
		}
	}

	public static Builder getBuilder() {
		return new Builder();
	}
}
