package com.shoppingmall.command;

public class LoginCommand {
	
	String id;
	String email;
	String password;
	boolean remember;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	
	@Override
	public String toString() {
		
		return "id = " + id + " pwd = " + password + " remember = " + remember;
	}
	
}
