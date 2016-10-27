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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table (name = TableType.T_USER)
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name, emailAddress, mobileNumber, password;
	private Address address;
	private Collection<Role> roles;
	
	private User() {}
	
	private User(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.emailAddress = builder.emailAddress;
		this.mobileNumber = builder.mobileNumber;
		this.address = builder.address;
		this.roles = builder.roles;
		this.password = builder.password;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	@Column (name = ColumnType.NAME)
	public String getName() {
		return name;
	}

	@Column (name = ColumnType.EMAIL_ADDRESS)
	public String getEmailAddress() {
		return emailAddress;
	}

	@Column (name = ColumnType.MOBILE_NUMBER)
	public String getMobileNumber() {
		return mobileNumber;
	}

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn (name = ColumnType.ADDRESS_ID)
	public Address getAddress() {
		return address;
	}

	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable (name = TableType.T_USER_ROLE, joinColumns = {@JoinColumn(name = ColumnType.ROLE_ID)}, inverseJoinColumns = {@JoinColumn(name = ColumnType.USER_ID)})
	public Collection<Role> getRoles() {
		return roles;
	}
	
	@Column (name = ColumnType.PASSWORD)
	public String getPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class Builder {
		private Integer id;
		private String name, emailAddress, mobileNumber, password;
		private Address address;
		private Collection<Role> roles;
		
		private Builder() {}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder withEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
			return this;
		}
		
		public Builder withMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
			return this;
		}
		
		public Builder withAddress(Address address) {
			this.address = address;
			return this;
		}
		
		public Builder withRoles(Collection<Role> roles) {
			this.roles = roles;
			return this;
		}
		
		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
