package com.BusBookingbackend.entity;

public class JwtResponse {
	
	private String  username;
	private String jwtToken;
	public JwtResponse(String username, String jwtToken) {
		super();
		this.username = username;
		this.jwtToken = jwtToken;
	}
	public String getUser() {
		return username;
	}
	public void setUser(String username) {
		this.username = username;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	
	


}
