package com.BusBookingbackend.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Set;

@Entity
public class Vendor implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String phone_number;
    private String organization_name;
    private String address;
    private String doc1;
    private String doc2;
    private String password;
    private Boolean verification_status;

    public Set<Role> getRole() {
        return Role;
    }

    public void setRole(Set<Role> role) {
        this.Role = role;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE", joinColumns = {
            @JoinColumn(name = "USER_ID", referencedColumnName = "username")
    },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }

    )
    private Set<Role> Role;
    //getter sETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getDoc1() {
        return doc1;
    }

    public void setDoc1(String doc1) {
        this.doc1 = doc1;
    }

    public String getDoc2() {
        return doc2;
    }

    public void setDoc2(String doc2) {
        this.doc2 = doc2;
    }

    public Boolean getVerification_status() {
        return verification_status;
    }

    public void setVerification_status(Boolean verification_status) {
        this.verification_status = verification_status;
    }



    // Constructors, getters, and setters
    // Constructors
    public Vendor() {
    }

}
