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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table(name = TableType.T_COUNTRY)
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name, isd;
	private Collection<Location> locations;

	private Country() {
		// TODO Auto-generated constructor stub
	}
	
	private Country(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.isd = builder.isd;
		this.locations = builder.locations;
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

	@Column(name = ColumnType.ISD_CODE)
	public String getIsd() {
		return isd;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = ColumnType.COUNTRY, fetch = FetchType.LAZY)
	public Collection<Location> getLocations() {
		return locations;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIsd(String isd) {
		this.isd = isd;
	}

	public void setLocations(Collection<Location> locations) {
		this.locations = locations;
	}

	public static class Builder {
		private Integer id;
		private String name, isd;
		private Collection<Location> locations;

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withIsd(String isd) {
			this.isd = isd;
			return this;
		}

		public Builder withLocations(Collection<Location> locations) {
			this.locations = locations;
			return this;
		}

		public Country build() {
			return new Country(this);
		}
	}

	public static Builder getBuilder() {
		return new Builder();
	}
}
