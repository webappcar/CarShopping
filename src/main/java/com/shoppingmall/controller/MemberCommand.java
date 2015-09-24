package com.shoppingmall.controller;

import java.util.Arrays;
import java.util.Date;

import com.shoppingmall.model.Member;

public class MemberCommand {
	private String id;
	private String password;
 	private String name;
 	private String nickname;
 	private String email;
 	private String phone;
 	private String address;
 	
 	
 	@Override
 	public String toString() {
 		StringBuilder b = new StringBuilder();
 		
 		//JSON(Javascript Object Notation)
 		b.append("{ ");
 		b.append("name : " + name);          b.append(", ");
 		b.append("email : " + email);		 b.append(", ");
 		b.append("password : " + password);  b.append(", ");
 		b.append(" }");
 		
 		return b.toString();
 	}
 	
 	public Member getMember() {
 		Member m = new Member();
 		m.setId(this.id);
 		m.setPassword(this.password);
 		m.setName(this.name);
 		m.setNickname(this.nickname);
 		m.setEmail(this.email);
 		m.setPhone(this.phone);
 		m.setAddress(this.address); 		
// 		m.setRegdate(new Date());
 		
 		return m;
 	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
