package com.shoppingmall.model.member;

import java.util.List;

public class MemberList {
	List<Member> members;
	
	public MemberList() {
		super();
	}
	
	public MemberList(int itemsPerPage, int pagesPerGroup) {
		
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

}
