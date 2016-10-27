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
@Table(name = TableType.T_LOCATION)
public class Location implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name, state, city;
	private Integer pin;
	private Country country;

	private Location() {}
	
	private Location(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.state = builder.state;
		this.city = builder.city;
		this.pin = builder.pin;
		this.country = builder.country;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	@Column(name = ColumnType.NAME)
	public String getName() {
		return name;
	}

	@Column(name = ColumnType.STATE_NAME)
	public String getState() {
		return state;
	}

	@Column(name = ColumnType.CITY_NAME)
	public String getCity() {
		return city;
	}

	@Column(name = ColumnType.ZIP_CODE)
	public Integer getPin() {
		return pin;
	}

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = ColumnType.COUNTRY_ID)
	public Country getCountry() {
		return country;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPin(Integer pin) {
		this.pin = pin;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public static class Builder {
		private Integer id;
		private String name, state, city;
		private Integer pin;
		private Country country;

		private Builder() {}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withState(String state) {
			this.state = state;
			return this;
		}

		public Builder withCity(String city) {
			this.city = city;
			return this;
		}

		public Builder withPin(Integer pin) {
			this.pin = pin;
			return this;
		}

		public Builder withCountry(Country country) {
			this.country = country;
			return this;
		}

		public Location build() {
			return new Location(this);
		}
	}

	public static Builder getBuilder() {
		return new Builder();
	}
}
