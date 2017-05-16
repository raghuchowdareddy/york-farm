/**
 * 
 */
package com.enuminfo.farm.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	private String username, password;
	private Collection<Role> roles;
	
	private User() {}
	
	private User(Builder builder) {
		this.id = builder.id;
		this.username = builder.username;
		this.roles = builder.roles;
		this.password = builder.password;
	}

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = ColumnType.ID)
	public Integer getId() {
		return id;
	}

	@Column (name = ColumnType.USERNAME)
	public String getUsername() {
		return username;
	}

	@ManyToMany
	@JoinTable (name = TableType.T_USER_ROLE, joinColumns = {@JoinColumn(name = ColumnType.USER_ID)}, inverseJoinColumns = {@JoinColumn(name = ColumnType.ROLE_ID)})
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

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static class Builder {
		private Integer id;
		private String username, password;
		private Collection<Role> roles;
		
		private Builder() {}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder withUsername(String username) {
			this.username = username;
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
