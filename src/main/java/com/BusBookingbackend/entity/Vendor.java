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

    private String verification_status;

//    public Blob getDoc1() {
//        return doc1;
//    }
//
//    public void setDoc1(Blob doc1) {
//        this.doc1 = doc1;
//    }
//
//    public Blob getDoc2() {
//        return doc2;
//    }
//
//    public void setDoc2(Blob doc2) {
//        this.doc2 = doc2;
//    }

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

//    public MultipartFile getDoc1() {
//        return doc1;
//    }
//
//    public void setDoc1(MultipartFile doc1) {
//        this.doc1 = doc1;
//    }
//
//    public MultipartFile getDoc2() {
//        return doc2;
//    }
//
//    public void setDoc2(MultipartFile doc2) {
//        this.doc2 = doc2;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerification_status() {
        return verification_status;
    }

    public void setVerification_status(String verification_status) {
        this.verification_status = verification_status;
    }



    // Constructors, getters, and setters
    // Constructors
    public Vendor() {
    }

    public Vendor(String username, String email, String phone_number, String organization_name, String address, MultipartFile doc1, MultipartFile doc2, String password, String verification_status) {
        this.username = username;
        this.email = email;
        this.phone_number = phone_number;
        this.organization_name = organization_name;
        this.address = address;
//        this.doc1 = doc1;
//        this.doc2 = doc2;
        this.password = password;
        this.verification_status = verification_status;
    }

    // Getters and setters
    // Omitted for brevity, but you should provide getters and setters for all properties
}
