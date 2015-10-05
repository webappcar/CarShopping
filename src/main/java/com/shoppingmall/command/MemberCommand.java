package com.shoppingmall.command;

import com.shoppingmall.model.Member;

public class MemberCommand {
	private String id;			// size=15
	private String name;		// size=15
	private String password;	// size=64
	private String nickname;	// size=20
	private String phone;		// size=15
 	private String email;		// size=64
 	private String address;		// size=64
 	
 	@Override
 	public String toString() {
 		StringBuilder b = new StringBuilder();
 		
 		//JSON(Javascript Object Notation)
 		b.append("{ ");
 		b.append("id : " + id);		 b.append(", ");
 		b.append("name : " + name);  b.append(", ");
 		b.append("password : " + password);          b.append(", ");
 		b.append("nickname : " + nickname);      b.append(", ");
 		b.append("phone : " + phone); b.append(", ");
 		b.append("email : "+ email);	 b.append(", ");
 		b.append("address : "+ address); 
 		b.append(" }");
 		
 		return b.toString();
 	}
 	
 	public Member getMember() {
 		Member m = new Member();
 		m.setId(this.id);
 		m.setName(this.name);
 		m.setPassword(this.password);
 		m.setNickname(this.nickname);
 		m.setPhone(this.phone);
 		m.setEmail(this.email);
 		m.setAddress(this.address); 		
 		
 		return m;
 	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
 	
}








