package com.shoppingmall.service;

import org.springframework.dao.EmptyResultDataAccessException;

import com.shoppingmall.dao.MemberDao;
import com.shoppingmall.exception.IdPassswordNotMatchException;
import com.shoppingmall.model.AuthInfo;
import com.shoppingmall.model.Member;
import com.shoppingmall.util.Password;

public class AuthService {
	MemberDao dao;
	
	public void setMemberDao(MemberDao dao) {
		this.dao = dao;
	}
	
	public AuthInfo authenticate(String id, String password) {

		AuthInfo info = new AuthInfo();
		
		System.out.println("login.getId() ========== "+id);
		System.out.println("login.getPassword() =========== "+password);
		
		try {
			Member m = dao.selectById(id);
			
			System.out.println("m.getId() ========== "+m.getId());
			System.out.println("m.getName() =========== "+m.getName());
			
			if (!m.getPassword().equals(Password.encode(password))) {
				throw new IdPassswordNotMatchException();
			}
			info.setId(m.getId());
			info.setName(m.getName());
			info.setEmail(m.getEmail());
			info.setNickname(m.getNickname());
			
		} catch (EmptyResultDataAccessException e) {
			throw new IdPassswordNotMatchException(e);
		}
		
		return info;
	}

}
