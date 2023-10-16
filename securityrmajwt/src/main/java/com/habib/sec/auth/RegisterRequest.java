package com.habib.sec.auth;

public class RegisterRequest {
    
    private String usernaString;
    private String password;
    private String role;
	
	public String getUsernaString() {
		return usernaString;
	}
	public void setUsernaString(String usernaString) {
		this.usernaString = usernaString;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RegisterRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public RegisterRequest(String usernaString, String password, String role) {
		super();
		
		this.usernaString = usernaString;
		this.password = password;
		this.role = role;
	}
	
    
    
    
}