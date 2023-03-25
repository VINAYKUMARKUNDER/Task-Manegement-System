package com.vinay.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



@Entity
public class Role {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "role_id")
	    private Integer id;
	    @Column(name = "role")
	    private String role;
	    @ManyToMany(mappedBy = "roles")
	    private List<User> users;

	    public Role() {
	    }

	    public Role(String role) {
	        this.role = role;
	    }

	    public Role(String role, List<User> users) {
	        this.role = role;
	        this.users = users;
	    }

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getRole() {
	        return role;
	    }

	    public void setRole(String role) {
	        this.role = role;
	    }

	    public List<User> getUsers() {
	        return users;
	    }

	    public void setUsers(List<User> users) {
	        this.users = users;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Role role1 = (Role) o;
	        return Objects.equals(id, role1.id) &&
	                Objects.equals(role, role1.role) &&
	                Objects.equals(users, role1.users);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id, role, users);
	    }
	}


