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
import javax.persistence.Table;

import com.enuminfo.farm.data.ColumnType;
import com.enuminfo.farm.data.TableType;

/**
 * @author Kumar
 */
@Entity
@Table (name = TableType.T_ROLE)
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private Collection<User> users;
	
	private Role(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.users = builder.users;
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

	@ManyToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable (name = TableType.T_USER_ROLE, joinColumns = {@JoinColumn(name = ColumnType.USER_ID)}, inverseJoinColumns = {@JoinColumn(name = ColumnType.ROLE_ID)})
	public Collection<User> getUsers() {
		return users;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public static class Builder {
		private Integer id;
		private String name;
		private Collection<User> users;
		
		public Builder() {
			// TODO Auto-generated constructor stub
		}
		
		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder withUsers(Collection<User> users) {
			this.users = users;
			return this;
		}
		
		public Role build() {
			return new Role(this);
		}
	}
	
	public static Builder getBuilder() {
		return new Builder();
	}
}
