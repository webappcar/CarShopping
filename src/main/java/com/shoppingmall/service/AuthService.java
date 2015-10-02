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
	
	public AuthInfo authenticate(String email, String password) {

		AuthInfo info = new AuthInfo();
		
		try {
			Member m = dao.selectByEmail(email);
			if (!m.getPassword().equals(Password.encode(password))) {
				throw new IdPassswordNotMatchException();
			}
			info.setEmail(m.getEmail());
			info.setName(m.getName());
			
		} catch (EmptyResultDataAccessException e) {
			throw new IdPassswordNotMatchException(e);
		}
		
		return info;
	}

}
