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
@Table (name = TableType.T_USER_ROLE)
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private User user;
	private Role role;
	
	private UserRole(Builder builder) {
		this.id = builder.id;
		this.user = builder.user;
		this.role = builder.role;
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

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = ColumnType.USER_ID)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn (name = ColumnType.ROLE_ID)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public static class Builder {
		private Integer id;
		private User user;
		private Role role;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder withUser(User user) {
			this.user = user;
			return this;
		}
		
		public Builder withRole(Role role) {
			this.role = role;
			return this;
		}
		
		public UserRole build() {
			return new UserRole(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
