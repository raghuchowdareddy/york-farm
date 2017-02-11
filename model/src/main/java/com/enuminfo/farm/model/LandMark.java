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
@Table(name = TableType.T_LOCATION_LANDMARK)
public class LandMark implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Location location;
	private LandMark() {}
	
	private LandMark(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.location = builder.location;
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
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = ColumnType.LOCATION_ID)
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}



	public static class Builder {
		private Integer id;
		private String name;
		private Location location;

		private Builder() {}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		public Builder withLocation(Location location){
			this.location = location;
			return this;
		}

		public LandMark build() {
			return new LandMark(this);
		}
	}

	public static Builder getBuilder() {
		return new Builder();
	}
}
