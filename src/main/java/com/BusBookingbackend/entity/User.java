package com.BusBookingbackend.entity;

import java.io.Serializable;
import java.util.Set;


import javax.persistence.*;


@Entity
public class User implements Serializable {
//	public Integer getId() {
//		return id;
//	}

	public void setId(Integer id) {
//		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String username;
    private String name;
    private String email;
    private String password;
    private String contactnumber;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "username")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")
    }
           
    )
    private Set<Role> Role;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

//	public void setRole(Role role) {
//		this.role = role;
//	}
	public Set<Role> getRole() {
		return Role;
	}
	public void setRole(Set<Role> role) {
		this.Role = role;
	}


   
}
