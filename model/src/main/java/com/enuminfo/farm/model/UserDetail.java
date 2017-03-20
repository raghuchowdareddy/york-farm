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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table (name = TableType.T_USER_DETAIL)
public class UserDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name, emailAddress, mobileNumber;
	private User user;
	private Collection<UserOrder> orders;
	
	private UserDetail() {}
	
	private UserDetail(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.emailAddress = builder.emailAddress;
		this.mobileNumber = builder.mobileNumber;
		this.user = builder.user;
		this.orders = builder.orders;
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

	@OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public User getUser() {
		return user;
	}

	@OneToMany (cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = ColumnType.USER)
	public Collection<UserOrder> getOrders() {
		return orders;
	}

	public void setOrders(Collection<UserOrder> orders) {
		this.orders = orders;
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

	public void setUser(User user) {
		this.user = user;
	}

	public static class Builder {
		private Integer id;
		private String name, emailAddress, mobileNumber;
		private User user;
		private Collection<UserOrder> orders;
		
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
		
		public Builder withUser(User user) {
			this.user = user;
			return this;
		}
		
		public Builder withOrders(Collection<UserOrder> orders) {
			this.orders = orders;
			return this;
		}
		
		public UserDetail build() {
			return new UserDetail();
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
