package com.shoppingmall.model;

public class Review {
	private int writing_id;		// size=5
 	private String id;			// size=15
 	private String name;		// size=15
 	private String nickname;	// size=20
 	private String title;		// size=100
 	private String code;		// size=10
 	private String register_date;		// size=20
 	
	public int getWriting_id() {
		return writing_id;
	}
	public void setWriting_id(int writing_id) {
		this.writing_id = writing_id;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getRegister_date() {
		return register_date;
	}
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}
 	
}
