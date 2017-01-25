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
@Table (name = TableType.T_DELIVERY_LOCATION)
public class DeliveryLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String street, landmark1, landmark2;
	private Location location;
	
	private DeliveryLocation() {}
	
	private DeliveryLocation(Builder builder) {
		this.id = builder.id;
		this.street = builder.street;
		this.landmark1 = builder.landmark1;
		this.landmark2 = builder.landmark2;
		this.location = builder.location;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column (name = ColumnType.VALUE_1)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column (name = ColumnType.VALUE_2)
	public String getLandmark1() {
		return landmark1;
	}

	public void setLandmark1(String landmark1) {
		this.landmark1 = landmark1;
	}

	@Column (name = ColumnType.VALUE_3)
	public String getLandmark2() {
		return landmark2;
	}

	public void setLandmark2(String landmark2) {
		this.landmark2 = landmark2;
	}

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.LOCATION_ID)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public static class Builder {
		
		private Integer id;
		private String street, landmark1, landmark2;
		private Location location;
		
		private Builder() {}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withStreet(String street) {
			this.street = street;
			return this;
		}

		public Builder withLandmark1(String landmark1) {
			this.landmark1 = landmark1;
			return this;
		}

		public Builder withLandmark2(String landmark2) {
			this.landmark2 = landmark2;
			return this;
		}

		public Builder withLocation(Location location) {
			this.location = location;
			return this;
		}
		
		public DeliveryLocation build() {
			return new DeliveryLocation(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
