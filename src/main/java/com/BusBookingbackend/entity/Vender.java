//package com.BusBookingbackend.entity;
//
//import java.util.Set;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinTable;
//import javax.persistence.Lob;
//import javax.persistence.ManyToMany;
//
//public class Vender {
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  
//  private String username;
//  private String email;
//  private String mobile_no;
//  private String organization_name;
//  private String address;
//  @Lob
//  @Column(name = "doc1", columnDefinition = "BLOB")
//  private byte[] doc1;
//
//  private String password;
//  private String confirom_password;
//
//  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//  @JoinTable(name="VENDER_ROLE",
//  
//        joinColumns = {
//        		@JoinColumn(name="VENDER_ID")
//        },
//        inverseJoinColumns = {
//        		@JoinColumn(name="ROLE_ID")
//        		
//        }
//		  )
//
//  private Set<Role> role;
//  
//
//public Vender() {}
//
//public Vender(String username, String email, String mobile_no, String organization_name, String address, byte[] doc1,
//		String password, String confirom_password, Set<Role> role) {
//	super();
//	this.username = username;
//	this.email = email;
//	this.mobile_no = mobile_no;
//	this.organization_name = organization_name;
//	this.address = address;
//	this.doc1 = doc1;
//	this.password = password;
//	this.confirom_password = confirom_password;
//	this.role = role;
//}
//
//public String getUsername() {
//	return username;
//}
//
//public void setUsername(String username) {
//	this.username = username;
//}
//
//public String getEmail() {
//	return email;
//}
//
//public void setEmail(String email) {
//	this.email = email;
//}
//
//public String getMobile_no() {
//	return mobile_no;
//}
//
//public void setMobile_no(String mobile_no) {
//	this.mobile_no = mobile_no;
//}
//
//public String getOrganization_name() {
//	return organization_name;
//}
//
//public void setOrganization_name(String organization_name) {
//	this.organization_name = organization_name;
//}
//
//public String getAddress() {
//	return address;
//}
//
//public void setAddress(String address) {
//	this.address = address;
//}
//
//public byte[] getDoc1() {
//	return doc1;
//}
//
//public void setDoc1(byte[] doc1) {
//	this.doc1 = doc1;
//}
//
//public String getPassword() {
//	return password;
//}
//
//public void setPassword(String password) {
//	this.password = password;
//}
//
//public String getConfirom_password() {
//	return confirom_password;
//}
//
//public void setConfirom_password(String confirom_password) {
//	this.confirom_password = confirom_password;
//}
//
//public Set<Role> getRole() {
//	return role;
//}
//
//public void setRole(Set<Role> role) {
//	this.role = role;
//}
//
//
//
//}
